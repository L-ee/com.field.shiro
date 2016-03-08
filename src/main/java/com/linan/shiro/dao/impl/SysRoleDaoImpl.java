package com.linan.shiro.dao.impl;

import com.linan.shiro.dao.SysRoleDao;
import com.linan.shiro.model.SysRole;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Created by lee on 2016/3/8.
 */
@Repository("sysRoleDao")
public class SysRoleDaoImpl implements SysRoleDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public SysRole getSysRoleById(int id) {
        Session session = sessionFactory.openSession();
        Query query = session.createQuery("from SysRole as s where s.id=" + id);
        return (SysRole) query.list().get(0);
    }
}
