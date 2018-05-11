package com.zgj.restrain.admin.dao;

import com.zgj.restrain.admin.model.SysPermission;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by user on 2018/5/9.
 */
public interface SysPermissionRepository extends CrudRepository<SysPermission,Integer> {
    List<SysPermission> findAll();

    @Query(value = "SELECT re.*  FROM sys_permission re LEFT JOIN sys_role_permission rr  ON re.id = rr.permission_id  LEFT JOIN sys_user_role ur  ON rr.role_id =ur.role_id WHERE ur.uid=:userId ORDER by re.id",nativeQuery = true)
    public List<SysPermission> loadUserResources(@Param(value = "userId") Integer userId);
}
