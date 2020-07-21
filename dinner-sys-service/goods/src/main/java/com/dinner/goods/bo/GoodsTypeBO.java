package com.dinner.goods.bo;

import com.dinner.commons.domain.GoodsType;
import com.dinner.commons.request.GoodsTypeReq;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 功能描述：
 *
 * @author:陈丽强
 * @Date:2020/7/20 23:00
 */

public interface GoodsTypeBO {

    int insert(GoodsTypeReq goodsTypeReq);

    int update(GoodsTypeReq goodsTypeReq);

    GoodsType queryOneById(Long id);

    List<GoodsType> queryList(GoodsTypeReq goodsTypeReq);

    List<GoodsType> queryListByShopId(Long shop_id);

    int delete(Long id);
}
