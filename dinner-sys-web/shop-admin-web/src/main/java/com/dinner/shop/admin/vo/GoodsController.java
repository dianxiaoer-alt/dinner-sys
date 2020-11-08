package com.dinner.shop.admin.vo;

import com.dinner.commons.domain.Goods;
import com.dinner.commons.domain.GoodsType;
import com.dinner.commons.query.GoodsQuery;
import com.dinner.commons.query.GoodsTypeQuery;
import com.dinner.commons.request.GoodsReq;
import com.dinner.commons.request.GoodsTypeReq;
import com.dinner.commons.result.Result;
import com.dinner.config.oss.utils.PathConfigEnum;
import com.dinner.config.utils.generate.code.QRCodeGenerator;
import com.dinner.config.utils.generate.code.entity.QRCodeEntity;
import com.dinner.shop.admin.config.jwt.UserLoginToken;
import com.dinner.shop.admin.config.jwt.UserPassToken;
import com.dinner.shop.admin.config.oss.OssUploadConfig;
import com.dinner.shop.admin.feign.GoodsFeign;
import com.dinner.shop.admin.vo.base.AbstractController;
import com.google.zxing.WriterException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.UUID;

/**
 * 功能描述：
 *
 * @author:陈丽强
 * @Date:2020/5/2 16:46
 */
@RequestMapping("goods")
@RestController
public class GoodsController extends AbstractController {
    @Autowired
    private GoodsFeign goodsFeign;

    @UserLoginToken
    @RequestMapping("queryList")
    public Result<List<Goods>> queryList(GoodsQuery query, HttpServletRequest request){
        query.setGoods_shop_id(parseShopId(request));
        return goodsFeign.queryList(query);
    }

    @UserLoginToken
    @PostMapping(value = "/save")
    Result<Integer> save(@Valid GoodsReq goodsReq){
        return goodsFeign.save(goodsReq);
    }

    @UserLoginToken
    @GetMapping(value = "deleteById")
    Result<Integer> deleteById(@RequestParam("goodsId") Long goodsId){
        return goodsFeign.deleteById(goodsId);
    }

    @UserLoginToken
    @GetMapping(value = "queryById")
    Result<Goods> queryById(@RequestParam("goodsId") Long goodsId){
        return goodsFeign.queryById(goodsId);
    }

    @UserLoginToken
    @PostMapping("queryGoodsTypeList")
    Result<List<GoodsType>> queryGoodsTypeList( GoodsTypeQuery goodsTypeQuery, HttpServletRequest request){
        goodsTypeQuery.setShop_id(parseShopId(request));
        return goodsFeign.queryGoodsTypeList(goodsTypeQuery);
    }

    @UserLoginToken
    @GetMapping("queryListByShopId")
    Result<List<Goods>> queryListByShopId(HttpServletRequest request){
        return goodsFeign.queryListByShopId(parseShopId(request));
    }

    @UserLoginToken
    @PostMapping("goodsTypeUpdate")
    Result<Integer> goodsTypeUpdate(GoodsTypeReq goodsTypeReq){
        return goodsFeign.goodsTypeUpdate(goodsTypeReq);
    }

    @UserLoginToken
    @GetMapping("goodsTypeDelete")
    Result<Integer> goodsTypeDelete(@RequestParam("id")Long id){
        return goodsFeign.goodsTypeDelete(id);
    }

    @UserLoginToken
    @GetMapping("goodsTypeQueryOneById")
    Result<GoodsType> goodsTypeQueryOneById(@RequestParam("id") Long id){
        return goodsFeign.goodsTypeQueryOneById(id);
    }

    @UserLoginToken
    @PostMapping("goodsTypeInsert")
    Result<Integer> goodsTypeInsert( GoodsTypeReq goodsTypeReq,HttpServletRequest request){
        goodsTypeReq.setShop_id(parseShopId(request));
        return goodsFeign.goodsTypeInsert(goodsTypeReq);
    }



    @UserLoginToken
    @PostMapping(value = "/update")
    Result<Integer> update(GoodsReq goodsReq){
        return goodsFeign.update(goodsReq);
    }

    @UserLoginToken
    @GetMapping("onSaleOrNo")
    Result<Integer> onSaleOrNo(@RequestParam("goods_id")Long goods_id, @RequestParam("is_on_sale")Integer is_on_sale){
        return goodsFeign.onSaleOrNo(goods_id,is_on_sale);
    }
}
