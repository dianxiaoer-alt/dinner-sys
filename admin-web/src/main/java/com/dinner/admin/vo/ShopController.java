package com.dinner.admin.vo;

import com.dinner.admin.feign.ShopFeign;
import com.dinner.commons.domain.Shop;
import com.dinner.commons.query.ShopQuery;
import com.dinner.commons.result.Result;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("shop")
public class ShopController {
    @Autowired
    private ShopFeign shopFeign;
    @RequestMapping("queryList")
    public Result<List<Shop>> queryList( ShopQuery query){
        return shopFeign.queryList(query);
    }
    @RequestMapping("queryPage")
    public Result<PageInfo<Shop>> queryPage( ShopQuery query){
        return shopFeign.queryPage(query);
    }
    @RequestMapping(value = "queryById")
    public Result<Shop> queryById(@RequestParam("shopId")Long shopId){
        return shopFeign.queryById(shopId);
    }
}
