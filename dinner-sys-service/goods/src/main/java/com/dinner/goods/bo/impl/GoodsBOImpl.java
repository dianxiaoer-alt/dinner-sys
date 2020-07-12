package com.dinner.goods.bo.impl;

import com.dinner.commons.domain.Goods;
import com.dinner.commons.page.Page;
import com.dinner.goods.bo.GoodsBO;
import com.dinner.goods.dal.GoodsDO;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class GoodsBOImpl implements GoodsBO {
    /**
     *菜品表数据操作对象
     */
    @Autowired
    private  GoodsDO goodsDAL;



    @Override
    public int insertGoods(Goods goods) {
        return goodsDAL.insertGoods(goods);
    }

    @Override
    public int deleteById(Long goodsId) {
        return goodsDAL.deleteById(goodsId);
    }

    @Override
    public Goods queryById(Long goodsId) {
        return goodsDAL.queryById(goodsId);
    }

    @Override
    public PageInfo<Goods> queryPage(Goods goods,int pageNum,int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        return new PageInfo<>(goodsDAL.queryPage(goods)) ;
    }

    @Override
    public int updateGoods(Goods goods) {
        return  goodsDAL.updateGoods(goods);
    }

    @Override
    public List<Goods> queryList(Goods goods){
        return goodsDAL.queryList(goods);
    }

    /**
     * 缓存机制
     * 缓存只能缓存键key为一种的value，由于goods对象每次调用会新创建新对象，所以起不到缓存的作用
     * 得手动重写List集合查询方法
     */

    /**
     * 查询goods_shop_id条件下集合
     * @param goods_shop_id
     * @return
     */
    public List<Goods> queryListByShopId(Long goods_shop_id){
        Goods goods = new Goods();
        goods.setGoods_shop_id(goods_shop_id);
        goods.setIs_on_sale(1);
        return goodsDAL.queryList(goods);
    }

    @Override
    public List<Goods> queryListByTypeAndShop(Long goods_type_id, Long goods_shop_id) {
        Goods goods = new Goods();
        goods.setGoods_shop_id(goods_shop_id);
        goods.setGoods_type_id(goods_type_id);
        goods.setIs_on_sale(1);
        return goodsDAL.queryList(goods);
    }


    public List<Goods> queryListByTypeId(Long goods_type_id){
        Goods goods = new Goods();
        goods.setGoods_type_id(goods_type_id);
        goods.setIs_on_sale(1);
        return goodsDAL.queryList(goods);
    }
}
