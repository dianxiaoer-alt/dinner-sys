/*
 * Copyright 2020 The JA-SIG Collaborative. All rights reserved.
 * distributed with thi file and available online at
 */
package com.dinner.user.bo;

import java.util.List;

//import ;
import com.dinner.commons.domain.User;
import com.dinner.commons.query.UserQuery;
import com.dinner.commons.page.Page;
import com.github.pagehelper.PageInfo;

/**
 * <pre>
 *  微信登录授权用户表 业务逻辑操作对象，保持事务一致，尽量在这里减少操作时间，
 *  比如：初始化数据（除非跟数据库交互），尽量不要在该层操作，
 *  不然会拉长事务的时间，加大对数据库的锁（不一定是行锁、全数据锁）时间。
 *
 *  控制层统一命名规则：
 *  增加保存 	insertXX,
 *  修改保存 	updateXX,
 *  查询分页 	queryPage,
 *  根据ID查询 	queryById,
 *  删除 		deleteById
 * </pre>
 * 
 * @author 醉翁 clq_zuiweng@163.com
 * @version 1.0.0
 */
public interface UserBO {
    /**
     * <pre>
     * 新增 微信登录授权用户表
     * //TODO 生成的代码，如果确认你已经使用该方法，请删除该行注释，不然后续清理代码的时候，将会删除该方法
     * </pre>
     *
     * @param user 微信登录授权用户表
     * @throws 
     */
    int insertUser(User user);
    /**
     * <pre>
     * 根据ID删除 微信登录授权用户表
     * //TODO 生成的代码，如果确认你已经使用该方法，请删除该行注释，不然后续清理代码的时候，将会删除该方法
     * </pre>
     *
     * @param userId 微信登录授权用户表Id
     * @return 更改数量
     * @throws 
     */
    int deleteById(Long userId);
    /**
     * <pre>
     * 分页查询微信登录授权用户表
     * //TODO 生成的代码，如果确认你已经使用该方法，请删除该行注释，不然后续清理代码的时候，将会删除该方法
     * </pre>
     *
     * @param page  分页信息
     * @param user 查询条件
     * @return 数据集合
     * @throws 
     */
    PageInfo<User> queryPage(User user,int pageNum,int pageSize);
    /**
     * <pre>
     * 根据ID查询微信登录授权用户表
     * //TODO 生成的代码，如果确认你已经使用该方法，请删除该行注释，不然后续清理代码的时候，将会删除该方法
     * </pre>
     *
     * @param userId 微信登录授权用户表Id
     * @return User
     * @throws 
     */
    User queryById(Long userId);
    /**
     * <pre>
     * 根据ID修改微信登录授权用户表
     * //TODO 生成的代码，如果确认你已经使用该方法，请删除该行注释，不然后续清理代码的时候，将会删除该方法
     * </pre>
     *
     * @param user 微信登录授权用户表
     * @return 修改数量
     * @throws 
     */
    int updateUser(User user);
     /**
     *
     * @param user  查询对象信息
     * @return 数据集合
     */
     List<User> queryList(User user);

    User queryUserByOpenId(String openId);
}
