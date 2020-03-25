package com.lancaiwu.cloud.storecenterservice.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lancaiwu.cloud.storecenterclient.entity.TStoreUserMappingEntity;
import com.lancaiwu.cloud.storecenterclient.req.AddStoreUserMappingReq;
import com.lancaiwu.cloud.storecenterservice.mapper.StoreUserMappingMapper;
import com.lancaiwu.cloud.storecenterservice.service.StoreUserMappingService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: lancaiwu
 * Email: lancaiwu@gmail.com
 * Date: 2020-03-16
 * Time: 16:34
 * Description: 店铺与用户的映射
 */
@Service
public class StoreUserMappingServiceImpl extends ServiceImpl<StoreUserMappingMapper, TStoreUserMappingEntity> implements StoreUserMappingService {
    @Override
    public TStoreUserMappingEntity addStoreUserMapping(AddStoreUserMappingReq addStoreUserMappingReq) {
        TStoreUserMappingEntity tStoreUserMappingEntity = new TStoreUserMappingEntity();
        BeanUtils.copyProperties(addStoreUserMappingReq, tStoreUserMappingEntity);
        tStoreUserMappingEntity.setCreateDate(new Date());
        baseMapper.insert(tStoreUserMappingEntity);
        return tStoreUserMappingEntity;
    }
}
