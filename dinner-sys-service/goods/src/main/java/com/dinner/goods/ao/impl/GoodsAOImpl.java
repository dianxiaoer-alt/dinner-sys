package com.dinner.goods.ao.impl;

import com.dinner.commons.domain.Goods;
import com.dinner.commons.page.Page;
import com.dinner.commons.page.PageResult;
import com.dinner.commons.query.GoodsQuery;
import com.dinner.commons.request.GoodsReq;
import com.dinner.commons.result.Result;
import com.dinner.commons.result.ResultCodeEnum;
import com.dinner.goods.ao.GoodsAO;

import com.dinner.goods.bo.GoodsBO;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("goodsBO")
public class GoodsAOImpl implements GoodsAO {
    /**
     * 菜品表业务操作对象
     */
    @Autowired
    private GoodsBO goodsBO;


  

    @Override
    public Result<Long> insertGoods(GoodsReq goodsReq) {
        Result<Long> resp = new Result<>();
        try {
            //TODO 你需要做点校验吗?
            if (resp.isSuccess()) {
                Goods goods = new Goods();
                BeanUtils.copyProperties(goodsReq, goods);
                goodsBO.insertGoods(goods);
                resp = Result.success(goods.getId());
            }
        } catch (Exception e) {
            resp =resp.error(ResultCodeEnum.FAIL.getCode(),e.getMessage());
        }
        return resp;
    }

    @Override
    public Result<Integer> deleteById(Long goodsId) {
        Result<Integer> resp = new Result<>();
        try {
            int flag = goodsBO.deleteById(goodsId);
            resp = Result.success(flag);
        } catch (Exception e) {
            resp =resp.error(ResultCodeEnum.FAIL.getCode(),e.getMessage());
        }
        return resp;
    }

    @Override
    public Result<Goods> queryById(Long goodsId) {
        Result<Goods> resp = new Result<>();
        try {
            Goods goods = goodsBO.queryById(goodsId);
            resp = Result.success(goods);
        } catch (Exception e) {
            resp =resp.error(ResultCodeEnum.FAIL.getCode(),e.getMessage());
        }
        return resp;
    }

    @Override
    public Result<PageInfo<Goods>> queryPage(GoodsQuery query) {
        Result<PageInfo<Goods>> pr = new Result<>();
        try {
            Goods goods = new Goods();
            BeanUtils.copyProperties(query,goods);
            PageInfo<Goods> list = goodsBO.queryPage( goods,query.getPageNum(),query.getPageSize());
            pr = Result.success(list);
        } catch (Exception e) {
            pr =pr.error(ResultCodeEnum.FAIL.getCode(),e.getMessage());
        }
        return pr;
    }

    @Override
    public Result<Integer> updateGoods(GoodsReq goodsReq) {
        Result<Integer> resp = new Result<>();
        try {
            //TODO 你需要做点校验吗?
            if (resp.isSuccess()) {
                Goods goods = new Goods();
                BeanUtils.copyProperties(goodsReq, goods);
                int flag = goodsBO.updateGoods(goods);
                resp = Result.success(flag);
            }
        } catch (Exception e) {
            resp =resp.error(ResultCodeEnum.FAIL.getCode(),e.getMessage());
        }
        return resp;
    }
    @Override
    public	Result<List<Goods>> queryList(GoodsQuery query){
        Result<List<Goods>> resp = new Result<>();

        try {
            //TODO 你需要做点校验吗?
            if (resp.isSuccess()) {
                Goods goods = new Goods();
                BeanUtils.copyProperties(query, goods);
                List<Goods> list = goodsBO.queryList(goods);
                resp = Result.success(list);
            }
        } catch (Exception e) {
            resp =resp.error(ResultCodeEnum.FAIL.getCode(),e.getMessage());
        }
        return resp;
    }

    @Override
    public Result<List<Goods>> queryListByTypeId(Long goods_type_id) {
        Result<List<Goods>> resp = new Result<>();
        try {
            List<Goods>  list = goodsBO.queryListByTypeId(goods_type_id);
            resp = Result.success(list);
        }catch (Exception e) {
            resp =resp.error(ResultCodeEnum.FAIL.getCode(),e.getMessage());
        }
        return resp;
    }

    @Override
    public Result<List<Goods>> queryListByTypeAndShop(Long goods_type_id, Long goods_shop_id) {
        return null;
    }

    @Override
    public Result<List<Goods>> queryListByShopId(Long goods_shop_id) {
        Result<List<Goods>> resp = new Result<>();
        try {
            List<Goods>  list = goodsBO.queryListByShopId(goods_shop_id);
            resp = Result.success(list);
        }catch (Exception e) {
            resp =resp.error(ResultCodeEnum.FAIL.getCode(),e.getMessage());
        }
        return resp;
    }
}
