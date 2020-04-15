package com.lancaiwu.cloud.storecenterservice.client.user;

import com.lancaiwu.cloud.baseservicecore.pojo.APIResponse;
import com.lancaiwu.cloud.usercenterclient.req.AddUserReq;
import com.lancaiwu.cloud.usercenterclient.vo.UserVO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created with IntelliJ IDEA.
 * User: lancaiwu
 * Email: lancaiwu@gmail.com
 * Date: 2020-03-17
 * Time: 11:39
 * Description: 调用用户中心
 */
@Component
@FeignClient(value = "user-center-service", fallback = UserCenterHystrix.class, configuration = UserCenterFeignConfig.class)
public interface UserCenterClient {
    /**
     * 根据用户id查询用户信息
     *
     * @param id
     * @return
     */
    @PostMapping("/user" + "/getUserById")
    APIResponse<UserVO> getUserById(@RequestParam String id);

    @PostMapping("/user" + "/seataTest")
    APIResponse<UserVO> getUserById(@RequestBody AddUserReq addUserReq);

    @PostMapping("/user" + "/lcnTest")
    APIResponse lcnTest(AddUserReq addUserReq);
}
