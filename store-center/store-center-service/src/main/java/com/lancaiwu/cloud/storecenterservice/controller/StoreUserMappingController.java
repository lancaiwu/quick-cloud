package com.lancaiwu.cloud.storecenterservice.controller;

import com.lancaiwu.cloud.baseservicecore.eums.APIResultCodeEnums;
import com.lancaiwu.cloud.baseservicecore.pojo.APIResponse;
import com.lancaiwu.cloud.storecenterclient.entity.TStoreUserMappingEntity;
import com.lancaiwu.cloud.storecenterclient.req.AddStoreUserMappingReq;
import com.lancaiwu.cloud.storecenterclient.vo.StoreUserMappingVO;
import com.lancaiwu.cloud.storecenterservice.client.user.UserCenterClient;
import com.lancaiwu.cloud.storecenterservice.service.StoreService;
import com.lancaiwu.cloud.storecenterservice.service.StoreUserMappingService;
import com.lancaiwu.cloud.storecenterservice.service.UserCenterService;
import com.lancaiwu.cloud.usercenterclient.vo.UserVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ObjectUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created with IntelliJ IDEA.
 * User: lancaiwu
 * Email: lancaiwu@gmail.com
 * Date: 2020-03-16
 * Time: 16:33
 * Description: 店铺与用户的映射
 */
@Api(tags = "店铺与用户的映射")
@RestController
@RequestMapping("/storeUserMapping")
public class StoreUserMappingController {

    @Autowired
    private StoreUserMappingService storeUserMappingService;

    @Autowired
    private StoreService storeService;

    @Autowired
    private UserCenterService userCenterService;

    @ApiOperation("新增店铺与用户的映射")
    @PostMapping("/addStoreUserMapping")
    public APIResponse<StoreUserMappingVO> addStoreUserMapping(@Validated @RequestBody AddStoreUserMappingReq addStoreUserMappingReq) {

        // 先查询 用户存在不
        if (ObjectUtils.isEmpty(userCenterService.getUserById(addStoreUserMappingReq.getUserId()))) {
            return new APIResponse<>(APIResultCodeEnums.USER_NOT_EXIST);
        }

        // 查询 店铺是否存在
        if (ObjectUtils.isEmpty(storeService.getStoreById(addStoreUserMappingReq.getStoreId()))) {
            return new APIResponse<>(APIResultCodeEnums.STORE_NOT_EXIST);
        }

        TStoreUserMappingEntity tStoreUserMappingEntity = storeUserMappingService.addStoreUserMapping(addStoreUserMappingReq);
        StoreUserMappingVO storeUserMappingVO = new StoreUserMappingVO();
        BeanUtils.copyProperties(tStoreUserMappingEntity, storeUserMappingVO);
        return new APIResponse<>(storeUserMappingVO);
    }


}
