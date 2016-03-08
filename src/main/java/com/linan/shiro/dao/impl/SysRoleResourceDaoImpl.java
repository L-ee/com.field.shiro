package com.linan.shiro.dao.impl;

import com.linan.shiro.dao.SysResourceDao;
import com.linan.shiro.dao.SysRoleDao;
import com.linan.shiro.model.SysResource;
import com.linan.shiro.model.SysRole;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lee on 2016/3/8.
 */
@Repository("sysResourceDao")
public class SysRoleResourceDaoImpl implements SysResourceDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<SysResource> getSysResourceById(String ids) {
        List<SysResource> list = new ArrayList<>();
        String[] split = ids.split(",");
        for (int i = 0;i<split.length;i++){
            System.out.println(split[i]);
            list.add(getSysResourceById(Integer.valueOf(split[i])));
        }
        return list;
    }

    public SysResource getSysResourceById(int id){
        Session session = sessionFactory.openSession();
        Query query = session.createQuery("from SysResource s where s.id=" + id);
        return (SysResource) query.list().get(0);
    }

}
