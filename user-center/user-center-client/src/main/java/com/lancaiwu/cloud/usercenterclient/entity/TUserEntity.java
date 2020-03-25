package com.lancaiwu.cloud.usercenterclient.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.lancaiwu.cloud.baseclientcore.entity.BaseEntity;
import lombok.Data;

/**
 * Created with IntelliJ IDEA.
 * User: lancaiwu
 * Email: lancaiwu@gmail.com
 * Date: 2020-03-11
 * Time: 15:03
 * Description: 用户表
 */
@Data
@TableName("t_user")
public class TUserEntity extends BaseEntity {
    /**
     * 雪花id
     */
    @TableId(value = "id", type = IdType.ASSIGN_ID)
    private String id;
    private String username;
    private String password;
}
