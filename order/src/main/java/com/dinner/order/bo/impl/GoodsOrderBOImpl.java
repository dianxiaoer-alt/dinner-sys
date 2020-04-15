package com.dinner.order.bo.impl;

import com.dinner.commons.domain.GoodsOrder;
import com.dinner.order.bo.GoodsOrderBO;
import com.dinner.order.dal.GoodsOrderDO;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.util.List;

@Service("GoodsOrderBO")
public class GoodsOrderBOImpl implements GoodsOrderBO {
    @Autowired
    private GoodsOrderDO goodsOrderDO;

    @Override
    public int insertGoodsOrder(GoodsOrder goodsOrder) {
        return goodsOrderDO.insertGoodsOrder(goodsOrder);
    }

    @Override
    public int deleteById(Long goodsOrderId) {
        return goodsOrderDO.deleteById(goodsOrderId);
    }

    @Override
    public PageInfo<GoodsOrder> queryPage(GoodsOrder goodsOrder,int pageNum,int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<GoodsOrder> resList = goodsOrderDO.queryPage(goodsOrder);
        PageInfo<GoodsOrder> page =  new PageInfo<>(resList);
        return page;
    }

    @Override
    public GoodsOrder queryById(Long goodsOrderId) {
        return goodsOrderDO.queryById(goodsOrderId);
    }

    @Override
    public int updateGoodsOrder(GoodsOrder goodsOrder) {
        return goodsOrderDO.updateGoodsOrder(goodsOrder);
    }


    @Override
    public List<GoodsOrder> queryList(GoodsOrder goodsOrder) {
        return goodsOrderDO.queryList(goodsOrder);
    }
}
