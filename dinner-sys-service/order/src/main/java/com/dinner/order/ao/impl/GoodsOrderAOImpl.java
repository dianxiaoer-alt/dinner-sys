package com.dinner.order.ao.impl;

import com.dinner.commons.domain.GoodsOrder;
import com.dinner.commons.domain.OrderDetail;
import com.dinner.commons.domain.Shop;
import com.dinner.commons.error.ErrorEnum;
import com.dinner.commons.query.GoodsOrderQuery;
import com.dinner.commons.request.GoodsOrderReq;
import com.dinner.commons.result.Result;
import com.dinner.commons.result.ResultCodeEnum;
import com.dinner.commons.result.dto.GoodsCollectDTO;
import com.dinner.order.ao.GoodsOrderAO;
import com.dinner.order.bo.GoodsOrderBO;
import com.dinner.order.bo.OrderDetailBO;
import com.dinner.order.feign.GoodsCollectFeign;
import com.dinner.order.feign.ShopFeign;
import com.dinner.order.utils.PayOrderNumProduceUtil;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service("GoodsOrderAO")
public class GoodsOrderAOImpl implements GoodsOrderAO {

    @Autowired
    private GoodsOrderBO goodsOrderBO;

    @Autowired
    private OrderDetailBO orderDetailBO;

    @Autowired
    private ShopFeign shopFeign;

    @Autowired
    private GoodsCollectFeign goodsCollectFeign;

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

    @Transactional
    @Override
    public Result<Integer> saveByCollectIds(List<Long> idList, Long userId, Long shopId) {
        Result<Integer> resp = new Result<>();
        try {
            if (idList.size() == 0)
                return Result.error(1,"id不能为空");
            if (userId == null || shopId == null)
                return Result.error(1,"用户id或商家id不能为空");
            Result<Shop> res = shopFeign.queryById(shopId);

            if (res.getCode() != 0 && res.getData() == null)
                return Result.error(1,"商家不存在");

            List<GoodsCollectDTO> list = new ArrayList<>();

            for (Long collectId : idList ) {
                Result<GoodsCollectDTO> re = goodsCollectFeign.queryById(collectId);
                if (re.getCode() == 0)
                    list.add(re.getData());
            }

            double allPrice = getAllGoodsPrice(list);
            GoodsOrder goodsOrder = new GoodsOrder();
            goodsOrder.setIs_payed(0);
            goodsOrder.setPay_type(1);
            goodsOrder.setOrder_num(PayOrderNumProduceUtil.wxProductOrderNum(userId.intValue(),allPrice));
            goodsOrder.setShop_id(shopId);
            goodsOrder.setUser_id(userId);
            goodsOrder.setOrder_price(allPrice);
            Integer inRes = goodsOrderBO.insertGoodsOrder(goodsOrder);

            if (inRes > 0){
                for (GoodsCollectDTO collectDO: list ) {
                    OrderDetail orderDetail = new OrderDetail();
                    orderDetail.setGoods_count(collectDO.getGoods_num());
                    orderDetail.setGoods_id(collectDO.getGoods_id());
                    orderDetail.setGoods_sum_price(collectDO.getGoods_num()*collectDO.getGoods_price());
                    orderDetail.setOrder_id(goodsOrder.getId());
                    if (orderDetailBO.insertOrderDetail(orderDetail) > 0){
                        resp = Result.success(inRes);
                    }else{
                        throw new RuntimeException(ErrorEnum.ADD_DATA_FAIL.getMsg());
                    }

                }

            }else{
                throw new RuntimeException(ErrorEnum.ADD_DATA_FAIL.getMsg());
            }

        }catch (Exception e){
           // resp =resp.error(ErrorEnum.ADD_DATA_FAIL);
            throw new RuntimeException(ErrorEnum.ADD_DATA_FAIL.getMsg());
        }
        return resp;
    }

    private double getAllGoodsPrice( List<GoodsCollectDTO> list){
        double res  =  0;
        for (GoodsCollectDTO g:list) {
            res+=g.getGoods_price()*g.getGoods_num();
        }
        return res;
    }
}
