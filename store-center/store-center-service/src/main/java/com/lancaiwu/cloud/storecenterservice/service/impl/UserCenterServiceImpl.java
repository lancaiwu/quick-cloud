package com.lancaiwu.cloud.storecenterservice.service.impl;

import com.lancaiwu.cloud.baseservicecore.eums.APIResultCodeEnums;
import com.lancaiwu.cloud.baseservicecore.excetion.BaseException;
import com.lancaiwu.cloud.baseservicecore.pojo.APIResponse;
import com.lancaiwu.cloud.storecenterservice.client.user.UserCenterClient;
import com.lancaiwu.cloud.storecenterservice.service.UserCenterService;
import com.lancaiwu.cloud.usercenterclient.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created with IntelliJ IDEA.
 * User: lancaiwu
 * Email: lancaiwu@gmail.com
 * Date: 2020-03-17
 * Time: 15:26
 * Description: 用户中心远程调用
 */
@Service
public class UserCenterServiceImpl implements UserCenterService {

    @Autowired
    private UserCenterClient userCenterClient;

    /**
     * 根据用户id查询用户信息
     *
     * @param id
     * @return
     */
    @Override
    public UserVO getUserById(String id) {
        APIResponse<UserVO> apiResponse = userCenterClient.getUserById(id);
        if (!apiResponse.getCode().equals(APIResultCodeEnums.SUCCESS.getCode())) {
            throw new BaseException(apiResponse.getCode());
        }
        return apiResponse.getData();
    }
}
