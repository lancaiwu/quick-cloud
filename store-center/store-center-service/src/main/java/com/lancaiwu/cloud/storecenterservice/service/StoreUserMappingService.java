package com.lancaiwu.cloud.storecenterservice.service;

import com.lancaiwu.cloud.storecenterclient.entity.TStoreUserMappingEntity;
import com.lancaiwu.cloud.storecenterclient.req.AddStoreUserMappingReq;

/**
 * Created with IntelliJ IDEA.
 * User: lancaiwu
 * Email: lancaiwu@gmail.com
 * Date: 2020-03-16
 * Time: 16:34
 * Description: No Description
 */
public interface StoreUserMappingService {
    TStoreUserMappingEntity addStoreUserMapping(AddStoreUserMappingReq addStoreUserMappingReq);
}
