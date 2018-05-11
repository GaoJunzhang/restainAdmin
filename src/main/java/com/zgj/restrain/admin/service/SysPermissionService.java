package com.zgj.restrain.admin.service;

import com.zgj.restrain.admin.dao.SysPermissionRepository;
import com.zgj.restrain.admin.model.SysPermission;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by user on 2018/5/9.
 */
@Service
public class SysPermissionService {
    @Autowired
    private SysPermissionRepository sysPermissionRepository;

    public List<SysPermission> findAll(){
        return sysPermissionRepository.findAll();
    }

    public List<SysPermission> loadUserResources(Integer uid){
        return sysPermissionRepository.loadUserResources(uid);
    }
}
