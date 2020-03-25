package com.lancaiwu.cloud.baseclientcore.entity;

import lombok.Data;

import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: lancaiwu
 * Email: lancaiwu@gmail.com
 * Date: 2020-03-16
 * Time: 16:27
 * Description: 基础表
 */
@Data
public class BaseEntity {
    private Date createDate;
    private String createBy;
    private Date updateDate;
    private String updateBy;
}
