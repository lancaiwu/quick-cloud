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
 * Date: 2020-03-14
 * Time: 18:06
 * Description: 店铺
 */
@EqualsAndHashCode(callSuper = true)
@Data
@TableName("t_store")
public class TStoreEntity extends BaseEntity {
    /**
     * 雪花id
     */
    @TableId(value = "id", type = IdType.ASSIGN_ID)
    private String id;
    private String storeName;
    private String storeDesc;
}
