package com.lancaiwu.cloud.usercenterservice.service.impl;

import com.lancaiwu.cloud.usercenterclient.entity.TUserEntity;
import com.lancaiwu.cloud.usercenterservice.mapper.UserMapper;
import com.lancaiwu.cloud.usercenterservice.service.UserService;
import org.springframework.stereotype.Service;

/**
 * Created with IntelliJ IDEA.
 * User: lancaiwu
 * Email: lancaiwu@gmail.com
 * Date: 2020-03-11
 * Time: 15:16
 * Description: 用户
 */
@Service
public class UserServiceImpl extends BaseServiceImpl<UserMapper, TUserEntity> implements UserService {

    @Override
    public TUserEntity getUserById(String id) {
        return baseMapper.selectById(id);
    }

    @Override
    public TUserEntity addUser(TUserEntity tUserEntity) {
        baseMapper.insert(tUserEntity);
        return tUserEntity;
    }
}
