/*
 * Copyright 2020 The JA-SIG Collaborative. All rights reserved.
 * distributed with thi file and available online at
 */
package com.dinner.message.bo.impl;


import com.dinner.commons.domain.Message;
import com.dinner.message.bo.MessageBO;
import com.dinner.message.dal.MessageDO;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * <pre>
 * 业务代码默认实现类，这里提供最小元素原子操作，所以尽量少在该类中做流程代码。
 * 业务流程代码应该写在AO中。
 * </pre>
 * 
 * @author 醉翁 clq_zuiweng@163.com
 * @since  1.0.0
 */
@Service("MessageBO")
public class MessageBOImpl implements MessageBO {
	/**
	 *数据操作对象
	 */
    @Autowired
	private  MessageDO messageDAL;
	

	@Override
	public int insertMessage(Message message) {
		return messageDAL.insertMessage(message);
	}

	@Override
	public int deleteById(Long messageId) {
		return messageDAL.deleteById(messageId);
	}

	@Override
	public Message queryById(Long messageId) {
		return messageDAL.queryById(messageId);
	}

	@Override
	public PageInfo<Message> queryPage(Message message, int pageNum, int pageSize) {
		PageHelper.startPage(pageNum,pageSize);
		return new PageInfo<>(messageDAL.queryPage(message));
	}

	@Override
	public int updateMessage(Message message) {
		return messageDAL.updateMessage(message);
	}

	@Override
	public List<Message> queryList(Message message){
		return messageDAL.queryList(message);
	}

}
