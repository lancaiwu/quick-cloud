package com.lancaiwu.cloud.usercenterservice.service.impl;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lancaiwu.cloud.usercenterservice.service.BaseService;

/**
 * Created with IntelliJ IDEA.
 * User: lancaiwu
 * Email: lancaiwu@gmail.com
 * Date: 2020-03-11
 * Time: 18:05
 * Description: No Description
 */
public class BaseServiceImpl<M extends BaseMapper<E>, E> extends ServiceImpl<M, E> implements BaseService<E> {

}
