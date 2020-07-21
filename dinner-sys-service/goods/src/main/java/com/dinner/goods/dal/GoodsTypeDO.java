package com.dinner.goods.dal;

import com.dinner.commons.domain.GoodsType;
import com.dinner.commons.request.GoodsTypeReq;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 功能描述：
 *
 * @author:陈丽强
 * @Date:2020/7/20 22:52
 */
@Mapper
public interface GoodsTypeDO {

    int insert(GoodsTypeReq goodsTypeReq);

    int update(GoodsTypeReq goodsTypeReq);

    GoodsType queryOneById(@Param("id") Long id);

    List<GoodsType> queryList(GoodsTypeReq goodsTypeReq);

    List<GoodsType> queryListByShopId(@Param("shop_id") Long shop_id);

    int delete(@Param("id") Long id);
}
