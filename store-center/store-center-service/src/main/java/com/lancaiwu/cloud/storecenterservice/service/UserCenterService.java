package com.lancaiwu.cloud.storecenterservice.service;

import com.lancaiwu.cloud.usercenterclient.vo.UserVO;

/**
 * Created with IntelliJ IDEA.
 * User: lancaiwu
 * Email: lancaiwu@gmail.com
 * Date: 2020-03-17
 * Time: 15:26
 * Description: No Description
 */
public interface UserCenterService {
    UserVO getUserById(String id);
}
