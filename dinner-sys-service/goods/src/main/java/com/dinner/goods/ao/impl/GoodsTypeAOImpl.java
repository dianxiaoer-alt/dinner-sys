package com.dinner.goods.ao.impl;

import com.dinner.commons.domain.GoodsType;
import com.dinner.commons.error.ErrorEnum;
import com.dinner.commons.query.GoodsTypeQuery;
import com.dinner.commons.request.GoodsTypeReq;
import com.dinner.commons.result.Result;
import com.dinner.goods.ao.GoodsTypeAO;
import com.dinner.goods.bo.GoodsTypeBO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 功能描述：
 *
 * @author:陈丽强
 * @Date:2020/7/20 23:06
 */
@Service("GoodsTypeAO")
public class GoodsTypeAOImpl implements GoodsTypeAO {

    @Autowired
    private GoodsTypeBO goodsTypeBO;

    @Override
    public Result<Integer> insert(GoodsTypeReq goodsTypeReq) {
        try {
            return Result.success(goodsTypeBO.insert(goodsTypeReq));
        }catch (Exception e){
            return Result.error(ErrorEnum.UNKNOW_ERROR);
        }
    }

    @Override
    public Result<Integer> update(GoodsTypeReq goodsTypeReq) {
        try {
            return Result.success(goodsTypeBO.update(goodsTypeReq));
        }catch (Exception e){
            return Result.error(ErrorEnum.UNKNOW_ERROR);
        }
    }

    @Override
    public Result<GoodsType> queryOneById(Long id) {
        try {
            return Result.success(goodsTypeBO.queryOneById(id));
        }catch (Exception e){
            return Result.error(ErrorEnum.UNKNOW_ERROR);
        }

    }

    @Override
    public Result<List<GoodsType>> queryList(GoodsTypeQuery goodsTypeQuery) {
        try {
            GoodsTypeReq goodsTypeReq = new GoodsTypeReq();
            BeanUtils.copyProperties(goodsTypeQuery,goodsTypeReq);
            return Result.success(goodsTypeBO.queryList(goodsTypeReq));
        }catch (Exception e){
            return Result.error(ErrorEnum.UNKNOW_ERROR);
        }
    }

    @Override
    public Result<List<GoodsType>> queryListByShopId(Long shop_id) {
        try {
            return Result.success(goodsTypeBO.queryListByShopId(shop_id));
        }catch (Exception e){
            return Result.error(ErrorEnum.UNKNOW_ERROR);
        }
    }

    @Override
    public Result<Integer> delete(Long id) {
        try {
            return Result.success(goodsTypeBO.delete(id));
        }catch (Exception e){
            return Result.error(ErrorEnum.UNKNOW_ERROR);
        }
    }
}
