/*
 * Copyright 2020 The JA-SIG Collaborative. All rights reserved.
 * distributed with thi file and available online at
 */
package com.dinner.message.vo;

import javax.validation.Valid;

import com.dinner.message.ao.MessageAO;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dinner.commons.domain.Message;
import com.dinner.commons.query.MessageQuery;
import com.dinner.commons.page.Page;
import com.dinner.commons.page.PageResult;
import com.dinner.commons.result.Result;
import com.dinner.commons.request.MessageReq;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
import java.util.List;


/**
 * <pre>
 *  控制对象，提供  新增,编辑,查询等操作。
 *  控制层统一命名规则：
 *  新增提供数据      add,
 *  增加保存 	  save,
 *  修改提供数据      edit,
 *  修改保存 	  update,
 *  查询分页 	  queryPage,
 *  根据ID查询 	  get,
 *  根据ID删除         deleteById
 * </pre>
 * 
 * @author 醉翁 clq_zuiweng@163.com
 * @version 1.0.0
 */
@Api(tags = "系统消息")
@RestController
@RequestMapping("message")
public class MessageVO {
	/**
	 * 应用流程对象
	 */
    @Autowired
	private final MessageAO messageAO;
	

	public MessageVO(MessageAO messageAO) {
		this.messageAO = messageAO;
	}
	
	@ApiOperation("保存")
	@RequestMapping(value = "save",method = {RequestMethod.POST})
	public Result<Long> save(@RequestBody MessageReq messageReq) {
		return messageAO.insertMessage(messageReq);
	}

	@ApiOperation("根据ID删除")
	//@DeleteMapping("delete")
	@RequestMapping(value = "delete",method = {RequestMethod.POST,RequestMethod.GET,RequestMethod.DELETE})
	public Result<Integer> deleteById(@RequestParam("messageId")Long messageId) {
		return messageAO.deleteById(messageId);
	}

	@ApiOperation("根据ID查询")
	//@GetMapping("queryById")
	@RequestMapping(value = "queryById",method = {RequestMethod.POST,RequestMethod.GET})
	public Result<Message> queryById(@RequestParam("messageId") Long messageId) {
		return messageAO.queryById(messageId);
	}

	@ApiOperation("查询")
	@RequestMapping(value = "queryPage",method = {RequestMethod.POST,RequestMethod.GET})
	public Result<PageInfo<Message>> queryPage(@RequestBody MessageQuery query) {
		return messageAO.queryPage(query);
	}

	@ApiOperation("更新")
	//@PutMapping("update")
	@RequestMapping(value = "update",method = {RequestMethod.POST,RequestMethod.GET,RequestMethod.PUT})
	public Result<Integer> update(@RequestBody MessageReq messageReq) {
		return messageAO.updateMessage(messageReq);
	}

	@ApiOperation("查询集合")
	@RequestMapping(value = "queryList",method = {RequestMethod.POST,RequestMethod.GET})
	public Result<List<Message>> queryList(@RequestBody MessageQuery query) {
		return messageAO.queryList(query);
	}

}
