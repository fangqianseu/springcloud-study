package com.fq.springcloud.myrules;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.AbstractLoadBalancerRule;
import com.netflix.loadbalancer.ILoadBalancer;
import com.netflix.loadbalancer.Server;

import java.util.List;
import java.util.Random;

/**
 * 自定义随机算法，每个服务器查询5次后随机更换
 */
public class MyRandomRule extends AbstractLoadBalancerRule {

    /*
     初始化大于5，第一次随机选一个
     */
    private int total = 4;
    private int index = 0;
    /*
    每个服务器访问次数
     */
    private final int count = 3;
    Random rand;

    public MyRandomRule() {
        rand = new Random();
    }

    /**
     * Randomly choose from all living servers
     */
    public Server choose(ILoadBalancer lb, Object key) {
        if (lb == null) {
            return null;
        }
        Server server = null;

        while (server == null) {
            if (Thread.interrupted()) {
                return null;
            }
            List<Server> upList = lb.getReachableServers();//得到现在活着的所有服务器
            List<Server> allList = lb.getAllServers();//得到euraka中所有的服务

            int serverCount = allList.size();//所有服务的个数
            if (serverCount == 0) {
                /*
                 * No servers. End regardless of pass, because subsequent passes
                 * only get more restrictive.
                 */
                return null;
            }

            //从所有服务中随机获取一个
            if (total < count) {
                server = upList.get(index);
                total++;
            } else {
                total = 0;
                index = rand.nextInt(serverCount);
            }

            if (server == null) {
                /*
                 * The only time this should happen is if the server list were
                 * somehow trimmed. This is a transient condition. Retry after
                 * yielding.
                 */
                Thread.yield();
                continue;
            }

            if (server.isAlive()) {
                return (server);
            }

            // Shouldn't actually happen.. but must be transient or a bug.
            server = null;
            Thread.yield();
        }

        return server;

    }

    @Override
    public Server choose(Object key) {
        return choose(getLoadBalancer(), key);
    }

    @Override
    public void initWithNiwsConfig(IClientConfig clientConfig) {
        // TODO Auto-generated method stub

    }
}