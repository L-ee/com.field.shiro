package com.linan.shiro.service.impl;

import com.linan.shiro.dao.SysResourceDao;
import com.linan.shiro.model.SysResource;
import com.linan.shiro.service.SysResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by lee on 2016/3/8.
 */
@Service("sysResourceService")
public class SysResourceServiceImpl implements SysResourceService {

    @Autowired
    private SysResourceDao sysResourceDao;


    @Override
    public List<SysResource> getSysResourceById(String ids) {
        return sysResourceDao.getSysResourceById(ids);
    }
}
