package com.dinner.order.bo.impl;

import com.dinner.commons.domain.OrderDetail;
import com.dinner.order.bo.OrderDetailBO;
import com.dinner.order.dal.OrderDetailDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("OrderDetailBO")
public class OrderDetailBOImpl implements OrderDetailBO {
    @Autowired
    private OrderDetailDO orderDetailDO;
    @Override
    public int insertOrderDetail(OrderDetail orderDetail) {
        return orderDetailDO.insertOrderDetail(orderDetail);
    }

    @Override
    public int deleteById(Long Id) {
        return orderDetailDO.deleteById(Id);
    }

    @Override
    public OrderDetail queryById(Long Id) {
        return orderDetailDO.queryById(Id);
    }

    @Override
    public int countPage(OrderDetail orderDetail) {
        return orderDetailDO.countPage(orderDetail);
    }

    @Override
    public List<OrderDetail> queryPage(OrderDetail query) {
        return orderDetailDO.queryPage(query);
    }

    @Override
    public int updateOrderDetail(OrderDetail orderDetail) {
        return orderDetailDO.updateOrderDetail(orderDetail);
    }

    @Override
    public List<OrderDetail> queryList(OrderDetail orderDetail) {
        return orderDetailDO.queryList(orderDetail);
    }
}
