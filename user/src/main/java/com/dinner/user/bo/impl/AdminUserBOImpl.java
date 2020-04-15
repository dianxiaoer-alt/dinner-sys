/*
 * Copyright 2020 The JA-SIG Collaborative. All rights reserved.
 * distributed with thi file and available online at
 */
package com.dinner.user.bo.impl;

import com.dinner.commons.domain.AdminUser;
import com.dinner.user.bo.AdminUserBO;
import com.dinner.user.dal.AdminUserDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <pre>
 * 后台管理员用户业务代码默认实现类，这里提供最小元素原子操作，所以尽量少在该类中做流程代码。
 * 业务流程代码应该写在AO中。
 * </pre>
 * 
 * @author 醉翁 clq_zuiweng@163.com
 * @since  1.0.0
 */
@Service("AdminUserBO")
public class AdminUserBOImpl implements AdminUserBO {
	/**
	 *后台管理员用户数据操作对象
	 */
    @Autowired
	private AdminUserDO adminUserDAL;
	

	@Override
	public int insertAdminUser(AdminUser adminUser) {
		return adminUserDAL.insertAdminUser(adminUser);
	}

	@Override
	public int deleteById(Long adminUserId) {
		return adminUserDAL.deleteById(adminUserId);
	}

	@Override
	public AdminUser queryById(Long adminUserId) {
		return adminUserDAL.queryById(adminUserId);
	}

	@Override
	public List<AdminUser> queryPage(AdminUser adminUser) {
		return adminUserDAL.queryPage( adminUser);
	}

	@Override
	public int updateAdminUser(AdminUser adminUser) {
		return adminUserDAL.updateAdminUser(adminUser);
	}

	@Override
	public List<AdminUser> queryList(AdminUser adminUser){
		return adminUserDAL.queryList(adminUser);
	}

	@Override
	public AdminUser queryUserByUserName(String username) {
		return adminUserDAL.queryUserByUserName(username);
	}

}
