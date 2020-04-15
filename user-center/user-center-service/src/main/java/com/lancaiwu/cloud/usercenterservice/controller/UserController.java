package com.lancaiwu.cloud.usercenterservice.controller;

import com.codingapi.txlcn.tc.annotation.LcnTransaction;
import com.lancaiwu.cloud.baseservicecore.eums.APIResultCodeEnums;
import com.lancaiwu.cloud.baseservicecore.pojo.APIResponse;
import com.lancaiwu.cloud.usercenterclient.entity.TUserEntity;
import com.lancaiwu.cloud.usercenterclient.req.AddUserReq;
import com.lancaiwu.cloud.usercenterclient.vo.UserVO;
import com.lancaiwu.cloud.usercenterservice.service.UserService;
//import io.seata.spring.annotation.GlobalTransactional;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * Created with IntelliJ IDEA.
 * User: lancaiwu
 * Email: lancaiwu@gmail.com
 * Date: 2020-03-11
 * Time: 15:13
 * Description: 用户
 */
@Api(tags = "用户")
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @ApiOperation(value = "查询用户", notes = "根据用户id查询用户", httpMethod = "POST")
    @PostMapping("/getUserById")
    public APIResponse<UserVO> getUserById(@RequestParam String id) {
        TUserEntity tUserEntity = userService.getUserById(id);
        if (tUserEntity != null) {
            UserVO userVO = new UserVO();
            BeanUtils.copyProperties(tUserEntity, userVO);
            return new APIResponse<>(userVO);
        } else {
            return new APIResponse<>(APIResultCodeEnums.USER_NOT_EXIST);
        }

    }

    @ApiOperation(value = "新增用户", notes = "新增用户", httpMethod = "POST")
    @PostMapping("/add")
    public APIResponse<UserVO> addUser(@Validated @RequestBody AddUserReq addUserReq) {
        TUserEntity tUserEntity = new TUserEntity();
        BeanUtils.copyProperties(addUserReq, tUserEntity);
        tUserEntity = userService.addUser(tUserEntity);
        UserVO userVO = new UserVO();
        BeanUtils.copyProperties(tUserEntity, userVO);
        return new APIResponse<>(userVO);
    }

    @ApiOperation(value = "测试gateway网关的熔断")
    @GetMapping("/testGatewayHystrix")
    public APIResponse<UserVO> testGatewayHystrix() {
        try {
            // 休眠五秒
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return new APIResponse<>();
    }


    /**
     * 测试 seata
     *
     * @return
     */
    @PostMapping("/seataTest")
    public APIResponse seataTest(@Validated @RequestBody AddUserReq addUserReq) {
        TUserEntity tUserEntity = new TUserEntity();
        BeanUtils.copyProperties(addUserReq, tUserEntity);
        tUserEntity = userService.addUser(tUserEntity);
        return new APIResponse<>(tUserEntity);
    }

    /**
     * 测试 lcn -- store是发起方
     *
     * @return
     */
    @PostMapping("/lcnTest")
    @LcnTransaction
    @Transactional
    public APIResponse lcnTest(@Validated @RequestBody AddUserReq addUserReq) {
        TUserEntity tUserEntity = new TUserEntity();
        BeanUtils.copyProperties(addUserReq, tUserEntity);
        tUserEntity = userService.addUser(tUserEntity);
        return new APIResponse<>(tUserEntity);
    }

}
