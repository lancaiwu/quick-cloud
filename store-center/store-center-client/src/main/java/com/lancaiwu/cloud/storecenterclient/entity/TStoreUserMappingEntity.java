package com.lancaiwu.cloud.storecenterclient.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.lancaiwu.cloud.baseclientcore.entity.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Created with IntelliJ IDEA.
 * User: lancaiwu
 * Email: lancaiwu@gmail.com
 * Date: 2020-03-16
 * Time: 16:24
 * Description: 店铺与用户的映射
 */
@EqualsAndHashCode(callSuper = true)
@Data
@TableName("t_store_user_mapping")
public class TStoreUserMappingEntity extends BaseEntity {
    @TableId(value = "id", type = IdType.ASSIGN_ID)
    private String id;
    /**
     * 用户id
     */
    private String userId;
    /**
     * 店铺id
     */
    private String storeId;
}
