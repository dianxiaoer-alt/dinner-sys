package com.dinner.order.ao.impl;

import com.dinner.commons.domain.OrderDetail;
import com.dinner.commons.page.PageResult;
import com.dinner.commons.query.OrderDetailQuery;
import com.dinner.commons.request.OrderDetailReq;
import com.dinner.commons.result.Result;
import com.dinner.commons.result.ResultCodeEnum;
import com.dinner.order.ao.OrderDetailAO;
import com.dinner.order.bo.OrderDetailBO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service("OrderDetailAO")
public class OrderDetailAOImpl implements OrderDetailAO {
    @Autowired
    private OrderDetailBO orderDetailBO;
    @Override
    public Result<Long> insertOrderDetail(OrderDetailReq orderDetailReq) {
        Result<Long> resp = new Result<>();
        try {
            //TODO 你需要做点校验吗?
            if (resp.isSuccess()) {
                OrderDetail orderDetail = new OrderDetail();
                BeanUtils.copyProperties(orderDetailReq, orderDetail);
                orderDetailBO.insertOrderDetail(orderDetail);
                resp = Result.success(orderDetail.getId());
            }
        } catch (Exception e) {
            resp =resp.error(ResultCodeEnum.FAIL.getCode(),e.getMessage());
        }
        return resp;
    }

    @Override
    public Result<Integer> deleteById(Long orderDetailId) {
        Result<Integer> resp = new Result<>();
        try {
            int flag = orderDetailBO.deleteById(orderDetailId);
            resp = Result.success(flag);
        } catch (Exception e) {
            resp =resp.error(ResultCodeEnum.FAIL.getCode(),e.getMessage());
        }
        return resp;
    }

    @Override
    public Result<OrderDetail> queryById(Long orderDetailId) {
        Result<OrderDetail> resp = new Result<>();
        try {
            OrderDetail orderDetail = orderDetailBO.queryById(orderDetailId);
            resp = Result.success(orderDetail);
        } catch (Exception e) {
            resp =resp.error(ResultCodeEnum.FAIL.getCode(),e.getMessage());
        }
        return resp;
    }

    @Override
    public PageResult<OrderDetail> queryPage(OrderDetailQuery query) {
        PageResult<OrderDetail> pr = new PageResult<>();
        try {
            OrderDetail orderDetail = new OrderDetail();
            BeanUtils.copyProperties(query,orderDetail);
            List<OrderDetail> list = orderDetailBO.queryPage( orderDetail);
            pr = pr.success(list);
        } catch (Exception e) {
            pr = pr.error(ResultCodeEnum.FAIL.getCode(),e.getMessage());
        }
        return pr;
    }

    @Override
    public Result<Integer> updateOrderDetail(OrderDetailReq orderDetailReq) {
        Result<Integer> resp = new Result<>();
        try {
            //TODO 你需要做点校验吗?
            if (resp.isSuccess()) {
                OrderDetail orderDetail = new OrderDetail();
                BeanUtils.copyProperties(orderDetailReq, orderDetail);
                int flag = orderDetailBO.updateOrderDetail(orderDetail);
                resp = Result.success(flag);
            }
        } catch (Exception e) {
            resp = resp.error(ResultCodeEnum.FAIL.getCode(),e.getMessage());
        }
        return resp;
    }
    @Override
    public	Result<List<OrderDetail>> queryList( OrderDetailQuery query){
        Result<List<OrderDetail>> resp = new Result<>();
        try {
            //TODO 你需要做点校验吗?
            if (resp.isSuccess()) {
                OrderDetail orderDetail = new OrderDetail();
                BeanUtils.copyProperties(query, orderDetail);
                List<OrderDetail> list = orderDetailBO.queryList(orderDetail);
                resp = Result.success(list);
            }
        } catch (Exception e) {
            resp = resp.error(ResultCodeEnum.FAIL.getCode(),e.getMessage());
        }
        return resp;
    }
}
