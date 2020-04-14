package com.lancaiwu.cloud.storecenterservice.controller;

import com.lancaiwu.cloud.baseservicecore.eums.APIResultCodeEnums;
import com.lancaiwu.cloud.baseservicecore.pojo.APIResponse;
import com.lancaiwu.cloud.storecenterclient.entity.TStoreEntity;
import com.lancaiwu.cloud.storecenterclient.req.AddStoreReq;
import com.lancaiwu.cloud.storecenterclient.vo.StoreVO;
import com.lancaiwu.cloud.storecenterservice.client.user.UserCenterClient;
import com.lancaiwu.cloud.storecenterservice.service.StoreService;
import com.lancaiwu.cloud.usercenterclient.req.AddUserReq;
//import io.seata.spring.annotation.GlobalTransactional;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * Created with IntelliJ IDEA.
 * User: lancaiwu
 * Email: lancaiwu@gmail.com
 * Date: 2020-03-14
 * Time: 18:04
 * Description: 店铺
 */
@Api(tags = "店铺")
@RestController
@RequestMapping("/store")
public class StoreController {

    @Autowired
    private StoreService storeService;

    @Autowired
    private UserCenterClient userCenterClient;

    @ApiOperation(value = "查询店铺", notes = "根据店铺id查询店铺", httpMethod = "POST")
    @PostMapping("/getStoreById")
    public APIResponse<StoreVO> getStoreById(@RequestParam String id) {
        TStoreEntity tStoreEntity = storeService.getStoreById(id);
        if (tStoreEntity != null) {
            StoreVO storeVO = new StoreVO();
            BeanUtils.copyProperties(tStoreEntity, storeVO);
            return new APIResponse<>(storeVO);
        } else {
            return new APIResponse<>(APIResultCodeEnums.NOT_EXIST);
        }
    }

    @ApiOperation("新增店铺")
    @PostMapping("/add")
    public APIResponse<StoreVO> addStore(@Validated @RequestBody AddStoreReq addStoreReq) {
        TStoreEntity tStoreEntity = new TStoreEntity();
        BeanUtils.copyProperties(addStoreReq, tStoreEntity);
        tStoreEntity = storeService.addStore(tStoreEntity);
        StoreVO storeVO = new StoreVO();
        BeanUtils.copyProperties(tStoreEntity, storeVO);
        return new APIResponse<>(storeVO);
    }

    /**
     * 测试 seata
     *
     * @return
     */
   // @GlobalTransactional
    @GetMapping("/seataTest")
    public APIResponse seataTest(@Validated @RequestBody AddStoreReq addStoreReq) {
        TStoreEntity tStoreEntity = new TStoreEntity();
        BeanUtils.copyProperties(addStoreReq, tStoreEntity);
        tStoreEntity = storeService.addStore(tStoreEntity);
        AddUserReq addUserReq = new AddUserReq();
        addUserReq.setUsername(addStoreReq.getStoreName());
        addUserReq.setPassword(addStoreReq.getStoreDesc());
        APIResponse apiResponse = userCenterClient.getUserById(addUserReq);
        return apiResponse;
    }
}
