/*
 * Copyright 2020 The JA-SIG Collaborative. All rights reserved.
 * distributed with thi file and available online at
 */
package com.dinner.message.ao.impl;

import com.dinner.commons.domain.Message;
import com.dinner.commons.page.PageResult;
import com.dinner.commons.query.MessageQuery;
import com.dinner.commons.request.MessageReq;
import com.dinner.commons.result.Result;
import com.dinner.commons.result.ResultCodeEnum;
import com.dinner.message.ao.MessageAO;
import com.dinner.message.bo.MessageBO;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;



/**
 * <pre>
 *   默认 应用实现类，提供相关流程应用操作、查询等。
 * </pre>
 * 
 * @author 醉翁 clq_zuiweng@163.com
 * @since  1.0.0
 */
@Service("messageAO")
public class DefaultMessageAO implements MessageAO {
	/**
	 * 业务操作对象
	 */
    @Autowired
	private MessageBO messageManager;
	

	@Override
	public Result<Long> insertMessage(MessageReq messageReq) {
		Result<Long> resp = new Result<>();
		try {
			//TODO 你需要做点校验吗?
			if (resp.isSuccess()) {
				Message message = new Message();
				BeanUtils.copyProperties(messageReq, message);
				messageManager.insertMessage(message);
				resp = Result.success(message.getId());
			}
		} catch (Exception e) {

				resp =resp.error(ResultCodeEnum.FAIL.getCode(),e.getMessage());
		}
		return resp;
	}
	
	@Override
	public Result<Integer> deleteById(Long messageId) {
		Result<Integer> resp = new Result<>();
		try {
			int flag = messageManager.deleteById(messageId);
			resp = Result.success(flag);
		} catch (Exception e) {

			resp =resp.error(ResultCodeEnum.FAIL.getCode(),e.getMessage());
		}
		return resp;
	}

	@Override
	public Result<Message> queryById(Long messageId) {
		Result<Message> resp = new Result<>();
		try {
			Message message = messageManager.queryById(messageId);
		    resp = Result.success(message);
		} catch (Exception e) {
			resp =resp.error(ResultCodeEnum.FAIL.getCode(),e.getMessage());
		}
		return resp;
	}

	@Override
	public Result<PageInfo<Message>> queryPage( MessageQuery query) {
		Result<PageInfo<Message>> pr = new Result<>();
		try {
			Message message = new Message();
			BeanUtils.copyProperties(query,message);
			PageInfo<Message> list = messageManager.queryPage(message,query.getPageNum(),query.getPageSize());
			pr = pr.success(list);

		} catch (Exception e) {
			pr = pr.error(ResultCodeEnum.FAIL.getCode(),e.getMessage());
		}
		return pr;
	}

	@Override
	public Result<Integer> updateMessage(MessageReq messageReq) {
		Result<Integer> resp = new Result<>();
		try {
			//TODO 你需要做点校验吗?
			if (resp.isSuccess()) {
				Message message = new Message();
				BeanUtils.copyProperties(messageReq, message);
				int flag = messageManager.updateMessage(message);
				resp = Result.success(flag);
			}
		} catch (Exception e) {
				resp = resp.error(ResultCodeEnum.FAIL.getCode(),e.getMessage());
		}
		return resp;
	}
	@Override
	public	Result<List<Message>> queryList( MessageQuery query){
		Result<List<Message>> resp = new Result<>();

		try {
			//TODO 你需要做点校验吗?
			if (resp.isSuccess()) {
				Message message = new Message();
				BeanUtils.copyProperties(query, message);
				List<Message> list = messageManager.queryList(message);
				resp = Result.success(list);
			}
		} catch (Exception e) {
			resp = resp.error(ResultCodeEnum.FAIL.getCode(),e.getMessage());
		}
		return resp;
	}


}
