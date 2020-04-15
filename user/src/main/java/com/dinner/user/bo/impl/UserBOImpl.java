/*
 * Copyright 2020 The JA-SIG Collaborative. All rights reserved.
 * distributed with thi file and available online at
 */
package com.dinner.user.bo.impl;


import com.dinner.commons.domain.User;
import com.dinner.user.bo.UserBO;
import com.dinner.user.dal.UserDO;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <pre>
 * 微信登录授权用户表业务代码默认实现类，这里提供最小元素原子操作，所以尽量少在该类中做流程代码。
 * 业务流程代码应该写在AO中。
 * </pre>
 * 
 * @author 醉翁 clq_zuiweng@163.com
 * @since  1.0.0
 */
@Service("UserBO")
public class UserBOImpl implements UserBO {
	/**
	 *微信登录授权用户表数据操作对象
	 */
    @Autowired
	private UserDO userDAL;
	

	@Override
	public int insertUser(User user) {
		return userDAL.insertUser(user);
	}

	@Override
	public int deleteById(Long userId) {
		return userDAL.deleteById(userId);
	}

	@Override
	public User queryById(Long userId) {
		return userDAL.queryById(userId);
	}

	@Override
	public PageInfo<User> queryPage( User user,int pageNum,int pageSize) {
		PageHelper.startPage(pageNum,pageSize);
		return new PageInfo<>( userDAL.queryPage(user));
	}

	@Override
	public int updateUser(User user) {
		return userDAL.updateUser(user);
	}

	@Override
	public List<User> queryList(User user){
		return userDAL.queryList(user);
	}

}
