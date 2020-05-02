package com.dinner.shop.admin.feign.impl;

import com.dinner.commons.domain.Goods;
import com.dinner.commons.query.GoodsQuery;
import com.dinner.commons.request.GoodsReq;
import com.dinner.commons.result.Result;
import com.dinner.shop.admin.feign.GoodsFeign;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * 功能描述：
 *
 * @author:陈丽强
 * @Date:2020/5/2 16:18
 */
public class GoodsFeignImpl implements GoodsFeign {

    @Override
    public Result<Integer> save(GoodsReq goodsReq) {
        return null;
    }

    @Override
    public Result<Integer> deleteById(Long goodsId) {
        return null;
    }

    @Override
    public Result<Goods> queryById(Long goodsId) {
        return null;
    }

    @Override
    public Result<PageInfo<Goods>> queryPage(GoodsQuery query) {
        return null;
    }

    @Override
    public Result<Integer> update(GoodsReq goodsReq) {
        return null;
    }

    @Override
    public Result<List<Goods>> queryList(GoodsQuery query) {
        return null;
    }

    @Override
    public Result<List<Goods>> queryListByTypeId(Long goods_type_id) {
        return null;
    }

    @Override
    public Result<List<Goods>> queryListByTypeAndShop(Long goods_type_id, Long goods_shop_id) {
        return null;
    }

    @Override
    public Result<List<Goods>> queryListByShopId(Long goods_shop_id) {
        return null;
    }
}
