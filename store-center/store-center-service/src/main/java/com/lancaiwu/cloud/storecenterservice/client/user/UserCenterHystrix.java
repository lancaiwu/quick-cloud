package com.lancaiwu.cloud.storecenterservice.client.user;

import com.lancaiwu.cloud.baseservicecore.eums.APIResultCodeEnums;
import com.lancaiwu.cloud.baseservicecore.pojo.APIResponse;
import com.lancaiwu.cloud.usercenterclient.req.AddUserReq;
import com.lancaiwu.cloud.usercenterclient.vo.UserVO;
import org.springframework.stereotype.Component;

/**
 * Created with IntelliJ IDEA.
 * User: lancaiwu
 * Email: lancaiwu@gmail.com
 * Date: 2020-03-17
 * Time: 15:13
 * Description: No Description
 */
@Component
public class UserCenterHystrix implements UserCenterClient {
    @Override
    public APIResponse<UserVO> getUserById(String id) {
        return new APIResponse<>(APIResultCodeEnums.FAIL);
    }

    @Override
    public APIResponse<UserVO> getUserById(AddUserReq addUserReq) {
        return new APIResponse<>(APIResultCodeEnums.FAIL);
    }

    @Override
    public APIResponse lcnTest(AddUserReq addUserReq) {
        return new APIResponse<>(APIResultCodeEnums.FAIL);
    }
}
