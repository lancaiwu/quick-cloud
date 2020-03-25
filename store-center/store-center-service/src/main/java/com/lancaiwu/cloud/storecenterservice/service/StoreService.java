package com.lancaiwu.cloud.storecenterservice.service;

import com.lancaiwu.cloud.storecenterclient.entity.TStoreEntity;

/**
 * Created with IntelliJ IDEA.
 * User: lancaiwu
 * Email: lancaiwu@gmail.com
 * Date: 2020-03-14
 * Time: 18:04
 * Description: No Description
 */
public interface StoreService {
    TStoreEntity getStoreById(String id);

    TStoreEntity addStore(TStoreEntity tStoreEntity);
}
