package com.fq.springcloud.provider.service.Impl;

import com.fq.springcloud.entities.Dept;
import com.fq.springcloud.provider.dao.DeptDao;
import com.fq.springcloud.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class DeptServiceImpl implements DeptService {

    @Autowired
    private DeptDao deptDao;

    @Override
    public boolean addDept(Dept dept) {
        return deptDao.addDept(dept);
    }


    @Override
    public List<Dept> findAll() {
        return deptDao.findAll();
    }

    @Override
    public Dept findByid(Long id) {
        return deptDao.findById(id);
    }
}