package com.zgj.restrain.admin.dao;

import com.zgj.restrain.admin.model.UserInfo;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by user on 2018/5/9.
 */
public interface UserInfoRepository extends CrudRepository<UserInfo,Integer> {
    /**通过username查找用户信息;*/
    public UserInfo findByUsername(String username);

    public UserInfo findByUid(Integer uid);
}
