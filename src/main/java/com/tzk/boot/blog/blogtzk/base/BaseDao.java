package com.tzk.boot.blog.blogtzk.base;

import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.special.InsertListMapper;

/**
 * dao层抽取
 * Mapper包含了基本的增删改查
 * InsertListMapper则包含了批量插入
 * @param <T>
 */
public interface BaseDao<T> extends Mapper<T>, InsertListMapper<T>{

}
