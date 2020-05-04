package com.dinner.shop.admin.vo;

import com.dinner.commons.domain.Goods;
import com.dinner.commons.query.GoodsQuery;
import com.dinner.commons.result.Result;
import com.dinner.shop.admin.config.jwt.UserLoginToken;
import com.dinner.shop.admin.feign.GoodsFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 功能描述：
 *
 * @author:陈丽强
 * @Date:2020/5/2 16:46
 */
@RequestMapping("goods")
@RestController
public class GoodsController {
    @Autowired
    private GoodsFeign goodsFeign;

    @UserLoginToken
    @RequestMapping("queryList")
    public Result<List<Goods>> queryList(GoodsQuery query){
        return goodsFeign.queryList(query);
    }


}
