package com.dinner.goods.bo.impl;

import com.dinner.commons.domain.GoodsType;
import com.dinner.commons.request.GoodsTypeReq;
import com.dinner.goods.bo.GoodsTypeBO;
import com.dinner.goods.dal.GoodsTypeDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 功能描述：
 *
 * @author:陈丽强
 * @Date:2020/7/20 23:01
 */
@Service("GoodsTypeBO")
public class GoodsTypeBOImpl implements GoodsTypeBO {

    @Autowired
    private final GoodsTypeDO  goodsTypeDO;

    public GoodsTypeBOImpl(GoodsTypeDO  goodsTypeDO){
        this.goodsTypeDO = goodsTypeDO;
    }

    @Override
    public int insert(GoodsTypeReq goodsTypeReq) {
        return goodsTypeDO.insert(goodsTypeReq);
    }

    @Override
    public int update(GoodsTypeReq goodsTypeReq) {
        return goodsTypeDO.update(goodsTypeReq);
    }

    @Override
    public GoodsType queryOneById(Long id) {
        return goodsTypeDO.queryOneById(id);
    }

    @Override
    public List<GoodsType> queryList(GoodsTypeReq goodsTypeReq) {
        return goodsTypeDO.queryList(goodsTypeReq);
    }

    @Override
    public List<GoodsType> queryListByShopId(Long shop_id) {
        return goodsTypeDO.queryListByShopId(shop_id);
    }

    @Override
    public int delete(Long id) {
        return goodsTypeDO.delete(id);
    }
}
