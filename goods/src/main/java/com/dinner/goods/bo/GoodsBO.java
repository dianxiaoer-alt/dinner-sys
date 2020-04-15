/*
 * Copyright 2020 The JA-SIG Collaborative. All rights reserved.
 * distributed with thi file and available online at
 */
package com.dinner.goods.bo;

import java.util.List;

//import ;
import com.dinner.commons.domain.Goods;
import com.dinner.commons.query.GoodsQuery;
import com.dinner.commons.page.Page;
import com.dinner.commons.result.Result;
import com.github.pagehelper.PageInfo;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;

/**
 * <pre>
 *  菜品表 业务逻辑操作对象，保持事务一致，尽量在这里减少操作时间，
 *  比如：初始化数据（除非跟数据库交互），尽量不要在该层操作，
 *  不然会拉长事务的时间，加大对数据库的锁（不一定是行锁、全数据锁）时间。
 *
 *  控制层统一命名规则：
 *  增加保存 	insertXX,
 *  修改保存 	updateXX,
 *  查询分页 	queryPage,
 *  根据ID查询 	queryById,
 *  删除 		deleteById
 * </pre>
 * 
 * @author 醉翁 clq_zuiweng@163.com
 * @version 1.0.0
 */
public interface GoodsBO {
    /**
     * <pre>
     * 新增 菜品表
     * //TODO 生成的代码，如果确认你已经使用该方法，请删除该行注释，不然后续清理代码的时候，将会删除该方法
     * </pre>
     *
     * @param goods 菜品表
     * @throws 
     */
    @CacheEvict(value = "goods",allEntries = true) //清除缓存
    int insertGoods(Goods goods);
    /**
     * <pre>
     * 根据ID删除 菜品表
     * //TODO 生成的代码，如果确认你已经使用该方法，请删除该行注释，不然后续清理代码的时候，将会删除该方法
     * </pre>
     *
     * @param goodsId 菜品表Id
     * @return 更改数量
     * @throws 
     */
    @CacheEvict(value = "goods",allEntries = true) //清除缓存
    int deleteById(Long goodsId);
    /**
     * <pre>
     * 分页查询菜品表
     * //TODO 生成的代码，如果确认你已经使用该方法，请删除该行注释，不然后续清理代码的时候，将会删除该方法
     * </pre>
     *
     * @param page  分页信息
     * @param goods 查询条件
     * @return 数据集合
     * @throws 
     */
    @Cacheable(value="goods",key="#goods.goods_shop_id")
    PageInfo<Goods> queryPage(Goods goods,int pageNum,int pageSize);
    /**
     * <pre>
     * 根据ID查询菜品表
     * //TODO 生成的代码，如果确认你已经使用该方法，请删除该行注释，不然后续清理代码的时候，将会删除该方法
     * </pre>
     *
     * @param goodsId 菜品表Id
     * @return Goods
     * @throws 
     */
    @Cacheable(value="goods",key="#goodsId")
    Goods queryById(Long goodsId);
    /**
     * <pre>
     * 根据ID修改菜品表
     * //TODO 生成的代码，如果确认你已经使用该方法，请删除该行注释，不然后续清理代码的时候，将会删除该方法
     * </pre>
     *
     * @param goods 菜品表
     * @return 修改数量
     * @throws 
     */
    @CacheEvict(value = "goods",allEntries = true) //清除缓存
    int updateGoods(Goods goods);
     /**
     *
     * @param goods  查询对象信息
     * @return 数据集合
     */
     List<Goods> queryList(Goods goods);

    @Cacheable(value="goods",key="#goods_type_id")
    List<Goods> queryListByTypeId(Long goods_type_id);

    /**
     *
     * @param goods_shop_id
     * @return
     */
    @Cacheable(value="goods",key="#goods_shop_id")
    List<Goods> queryListByShopId(Long goods_shop_id);


    /**
     * 某店铺下某分类下的菜品集合（已上架）
     * @param goods_type_id
     * @param goods_shop_id
     * @return
     */
    @Cacheable(value = "goods",key = "#goods_shop_id")
    List<Goods> queryListByTypeAndShop(Long goods_type_id, Long goods_shop_id);
}
