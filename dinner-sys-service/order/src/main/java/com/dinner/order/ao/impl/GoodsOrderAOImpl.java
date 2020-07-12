package com.dinner.order.ao.impl;

import com.dinner.commons.domain.GoodsOrder;
import com.dinner.commons.page.PageResult;
import com.dinner.commons.query.GoodsOrderQuery;
import com.dinner.commons.request.GoodsOrderReq;
import com.dinner.commons.result.Result;
import com.dinner.commons.result.ResultCodeEnum;
import com.dinner.order.ao.GoodsOrderAO;
import com.dinner.order.bo.GoodsOrderBO;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("GoodsOrderAO")
public class GoodsOrderAOImpl implements GoodsOrderAO {

    @Autowired
    private GoodsOrderBO goodsOrderBO;

    @Override
    public Result<Long> insertGoodsOrder(GoodsOrderReq goodsOrderReq) {
        Result<Long> resp = new Result<>();
        try {
            //TODO 你需要做点校验吗?
            if (resp.isSuccess()) {
                GoodsOrder goodsOrder = new GoodsOrder();
                BeanUtils.copyProperties(goodsOrderReq, goodsOrder);
                goodsOrderBO.insertGoodsOrder(goodsOrder);
                resp = Result.success(goodsOrder.getId());
            }
        } catch (Exception e) {

            resp =resp.error(ResultCodeEnum.FAIL.getCode(),e.getMessage());
        }
        return resp;
    }

    @Override
    public Result<Integer> deleteById(Long goodsOrderId) {
        Result<Integer> resp = new Result<>();
        try {
            int flag = goodsOrderBO.deleteById(goodsOrderId);
            resp = Result.success(flag);
        } catch (Exception e) {
            resp =resp.error(ResultCodeEnum.FAIL.getCode(),e.getMessage());
        }
        return resp;
    }

    @Override
    public Result<GoodsOrder> queryById(Long goodsOrderId) {
        Result<GoodsOrder> resp = new Result<>();
        try {
            GoodsOrder goodsOrder = goodsOrderBO.queryById(goodsOrderId);
            resp = Result.success(goodsOrder);
        } catch (Exception e) {
            resp =resp.error(ResultCodeEnum.FAIL.getCode(),e.getMessage());
        }
        return resp;
    }

    @Override
    public Result<PageInfo<GoodsOrder>> queryPage(GoodsOrderQuery query) {
        Result<PageInfo<GoodsOrder>> pr = new Result<>();
        try {
            GoodsOrder goodsOrder = new GoodsOrder();
            BeanUtils.copyProperties(query,goodsOrder);

            PageInfo<GoodsOrder> list = goodsOrderBO.queryPage(goodsOrder,query.getPageNum(), query.getPageSize());
             pr = pr.success(list);

        } catch (Exception e) {
            pr =pr.error(ResultCodeEnum.FAIL.getCode(),e.getMessage());
        }
        return pr;
    }

    @Override
    public Result<Integer> updateGoodsOrder(GoodsOrderReq goodsOrderReq) {
        Result<Integer> resp = new Result<>();
        try {
            //TODO 你需要做点校验吗?
            if (resp.isSuccess()) {
                GoodsOrder goodsOrder = new GoodsOrder();
                BeanUtils.copyProperties(goodsOrderReq, goodsOrder);
                int flag = goodsOrderBO.updateGoodsOrder(goodsOrder);
                resp = Result.success(flag);
            }
        } catch (Exception e) {
            resp =resp.error(ResultCodeEnum.FAIL.getCode(),e.getMessage());
        }
        return resp;
    }



    @Override
    public Result<List<GoodsOrder>> queryList(GoodsOrderQuery goodsOrderQuery) {
        Result<List<GoodsOrder>> resq = new Result<>();
        try {
            GoodsOrder goodsOrder = new GoodsOrder();
            BeanUtils.copyProperties(goodsOrderQuery,goodsOrder);
            List<GoodsOrder> list = goodsOrderBO.queryList(goodsOrder);
            resq = Result.success(list);
        }catch (Exception e){
            resq = Result.error(e.hashCode(),e.getMessage());
            e.printStackTrace();
        }
        return resq;
    }
}
