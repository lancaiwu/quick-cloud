package com.lancaiwu.cloud.usercenterservice.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.lancaiwu.cloud.usercenterclient.entity.TUserEntity;

/**
 * Created with IntelliJ IDEA.
 * User: lancaiwu
 * Email: lancaiwu@gmail.com
 * Date: 2020-03-11
 * Time: 15:14
 * Description: No Description
 */
public interface UserService extends IService<TUserEntity> {
    TUserEntity getUserById(String id);

    TUserEntity addUser(TUserEntity tUserEntity);
}
