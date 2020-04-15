package com.dinner.shop.ao.impl;

import com.dinner.commons.domain.Shop;
import com.dinner.commons.page.PageResult;
import com.dinner.commons.query.ShopQuery;
import com.dinner.commons.request.ShopReq;
import com.dinner.commons.result.Result;
import com.dinner.commons.result.ResultCodeEnum;
import com.dinner.shop.ao.ShopAO;
import com.dinner.shop.bo.ShopBO;
import com.dinner.shop.config.JasyptConfig;
import com.github.pagehelper.PageInfo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service("ShopAO")
public class ShopAOImpl implements ShopAO {
    /**
     * 业务操作对象
     */
    @Autowired
    private  ShopBO shopManager;
    @Autowired
    private JasyptConfig jasyptConfig;


    @Override
    public Result<Long> insertShop(ShopReq shopReq) {
        Result<Long> resp = new Result<>();
        try {
            //TODO 你需要做点校验吗?
            if (resp.isSuccess()) {
                Shop shop = new Shop();
                BeanUtils.copyProperties(shopReq, shop);

                if(StringUtils.isNoneBlank(shop.getApp_secret()))
                    shop.setApp_secret(jasyptConfig.encryptPwd(shop.getApp_secret()));

                if(StringUtils.isNoneBlank(shop.getPay_key()))
                    shop.setPay_key(jasyptConfig.encryptPwd(shop.getPay_key()));

                if(StringUtils.isNoneBlank(shop.getApp_id()))
                    shop.setApp_id(jasyptConfig.encryptPwd(shop.getApp_id()));

                if(StringUtils.isNoneBlank(shop.getMch_id()))
                    shop.setMch_id(jasyptConfig.encryptPwd(shop.getMch_id()));

                if(StringUtils.isNoneBlank(shop.getShop_password()))
                    shop.setShop_password(jasyptConfig.encryptPwd(shop.getShop_password()));

                shopManager.insertShop(shop);
                resp = Result.success(shop.getId());
            }
        } catch (Exception e) {
            resp =resp.error(ResultCodeEnum.FAIL.getCode(),e.getMessage());
        }
        return resp;
    }

    @Override
    public Result<Integer> deleteById(Long shopId) {
        Result<Integer> resp = new Result<>();
        try {
            int flag = shopManager.deleteById(shopId);
            resp = Result.success(flag);
        } catch (Exception e) {
            resp =resp.error(ResultCodeEnum.FAIL.getCode(),e.getMessage());
        }
        return resp;
    }

    @Override
    public Result<Shop> queryById(Long shopId) {
        Result<Shop> resp = new Result<>();
        try {
            Shop shop = shopManager.queryById(shopId);
            resp = Result.success(shop);
        } catch (Exception e) {
            resp =resp.error(ResultCodeEnum.FAIL.getCode(),e.getMessage());
        }
        return resp;
    }

    @Override
    public Result<PageInfo<Shop>> queryPage(ShopQuery query) {
        Result<PageInfo<Shop>> resp = new Result<>();
        try {
            Shop shop = new Shop();
            BeanUtils.copyProperties(query,shop);
            PageInfo<Shop> list = shopManager.queryPage(shop,query.getPageNum(),query.getPageSize());
            resp = resp.success(list);
        } catch (Exception e) {
            resp =resp.error(ResultCodeEnum.FAIL.getCode(),e.getMessage());
        }
        return resp;
    }

    @Override
    public Result<Integer> updateShop(ShopReq shopReq) {
        Result<Integer> resp = new Result<>();
        try {
            //TODO 你需要做点校验吗?
            if (resp.isSuccess()) {
                Shop shop = new Shop();

                BeanUtils.copyProperties(shopReq, shop);

                if(StringUtils.isNoneBlank(shop.getApp_secret()))
                    shop.setApp_secret(jasyptConfig.encryptPwd(shop.getApp_secret()));

                if(StringUtils.isNoneBlank(shop.getPay_key()))
                    shop.setPay_key(jasyptConfig.encryptPwd(shop.getPay_key()));

                if(StringUtils.isNoneBlank(shop.getApp_id()))
                    shop.setApp_id(jasyptConfig.encryptPwd(shop.getApp_id()));

                if(StringUtils.isNoneBlank(shop.getMch_id()))
                    shop.setMch_id(jasyptConfig.encryptPwd(shop.getMch_id()));

                if(StringUtils.isNoneBlank(shop.getShop_password()))
                    shop.setShop_password(jasyptConfig.encryptPwd(shop.getShop_password()));

                int flag = shopManager.updateShop(shop);
                resp = Result.success(flag);
            }
        } catch (Exception e) {
            resp =resp.error(ResultCodeEnum.FAIL.getCode(),e.getMessage());
        }
        return resp;
    }
    @Override
    public	Result<List<Shop>> queryList(ShopQuery query){
        Result<List<Shop>> resp = new Result<>();

        try {
            //TODO 你需要做点校验吗?
            if (resp.isSuccess()) {
                Shop shop = new Shop();
                BeanUtils.copyProperties(query, shop);
                List<Shop> list = shopManager.queryList(shop);
                resp = Result.success(list);
            }
        } catch (Exception e) {
            resp =resp.error(ResultCodeEnum.FAIL.getCode(),e.getMessage());
        }
        return resp;
    }
}
