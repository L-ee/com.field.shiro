package com.linan.shiro.service.impl;

import com.linan.shiro.dao.SysRoleDao;
import com.linan.shiro.model.SysRole;
import com.linan.shiro.service.SysRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by lee on 2016/3/8.
 */
@Service("sysRoleService")
public class SysRoleServiceImpl implements SysRoleService {

    @Autowired
    private SysRoleDao sysRoleDao;


    @Override
    public SysRole getSysRoleById(int id) {
        return sysRoleDao.getSysRoleById(id);
    }
}
