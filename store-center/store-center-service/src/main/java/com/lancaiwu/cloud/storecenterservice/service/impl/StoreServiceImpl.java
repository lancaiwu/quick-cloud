package com.lancaiwu.cloud.storecenterservice.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lancaiwu.cloud.storecenterclient.entity.TStoreEntity;
import com.lancaiwu.cloud.storecenterservice.mapper.StoreMapper;
import com.lancaiwu.cloud.storecenterservice.service.StoreService;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: lancaiwu
 * Email: lancaiwu@gmail.com
 * Date: 2020-03-14
 * Time: 18:05
 * Description: 店铺
 */
@Service
public class StoreServiceImpl extends ServiceImpl<StoreMapper, TStoreEntity> implements StoreService {
    @Override
    public TStoreEntity getStoreById(String id) {
        return baseMapper.selectById(id);
    }

    @Override
    public TStoreEntity addStore(TStoreEntity tStoreEntity) {
        tStoreEntity.setCreateDate(new Date());
        baseMapper.insert(tStoreEntity);
        return tStoreEntity;
    }
}
