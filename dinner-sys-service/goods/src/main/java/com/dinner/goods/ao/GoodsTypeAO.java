package com.dinner.goods.ao;

import com.dinner.commons.domain.GoodsType;
import com.dinner.commons.query.GoodsTypeQuery;
import com.dinner.commons.request.GoodsTypeReq;
import com.dinner.commons.result.Result;

import java.util.List;

/**
 * 功能描述：
 *
 * @author:陈丽强
 * @Date:2020/7/20 23:04
 */
public interface GoodsTypeAO {

    Result<Integer> insert(GoodsTypeReq goodsTypeReq);

    Result<Integer> update(GoodsTypeReq goodsTypeReq);

    Result<GoodsType> queryOneById(Long id);

    Result<List<GoodsType>> queryList(GoodsTypeQuery goodsTypeQuery);

    Result<List<GoodsType>> queryListByShopId(Long shop_id);

    Result<Integer> delete(Long id);
}
