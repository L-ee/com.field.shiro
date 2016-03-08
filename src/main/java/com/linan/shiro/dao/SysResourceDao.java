package com.linan.shiro.dao;


import com.linan.shiro.model.SysResource;
import java.util.List;

/**
 * Created by lee on 2016/3/8.
 */
public interface SysResourceDao {

    public List<SysResource> getSysResourceById(String ids);

}
