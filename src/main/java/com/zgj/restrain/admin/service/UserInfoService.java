package com.zgj.restrain.admin.service;

import com.zgj.restrain.admin.dao.UserInfoRepository;
import com.zgj.restrain.admin.model.UserInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by user on 2018/5/9.
 */
@Service
public class UserInfoService {
    @Resource
    private UserInfoRepository userInfoRepository;
    public UserInfo findByUsername(String username) {
        return userInfoRepository.findByUsername(username);
    }
    public UserInfo user(Integer id){
        return userInfoRepository.findByUid(id);
    }
}
