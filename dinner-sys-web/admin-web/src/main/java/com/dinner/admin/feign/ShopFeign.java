package com.dinner.admin.feign;

import com.dinner.admin.feign.impl.ShopFeignFallbackFactoryImpl;
import com.dinner.commons.domain.Shop;
import com.dinner.commons.domain.ShopDetail;
import com.dinner.commons.query.ShopDetailQuery;
import com.dinner.commons.query.ShopQuery;
import com.dinner.commons.request.ShopDetailReq;
import com.dinner.commons.request.ShopReq;
import com.dinner.commons.result.Result;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.ApiOperation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * shop店铺服务
 */
@FeignClient(value = "shop",fallbackFactory = ShopFeignFallbackFactoryImpl.class)
public interface ShopFeign {


    /*********************************店铺部分***********************************/
    //保存
    @RequestMapping(value = "shop/save")
    Result<Long> save(@RequestBody ShopReq shopReq);

    //根据ID删除
    @RequestMapping(value = "shop/delete")
    public Result<Integer> deleteById(@RequestParam("shopId") Long shopId);

    @ApiOperation("根据ID查询")
    @RequestMapping(value = "shop/queryById")
   Result<Shop> queryById(@RequestParam("shopId") Long shopId);

   //"查询")
    @RequestMapping(value = "shop/queryPage")
   Result<PageInfo<Shop>> queryPage(@RequestBody ShopQuery query);

   //更新
    @RequestMapping(value = "shop/update")
    Result<Integer> update(@RequestBody ShopReq shopReq);

    //查询集合
    @RequestMapping(value = "shop/queryList")
   Result<List<Shop>> queryList(@RequestBody ShopQuery query);



    /******************************店铺详情，营业执照信息*********************************/


    //保存
    @RequestMapping(value = "shopDetail/save")
    Result<Long> save(@RequestBody ShopDetailReq shopDetailReq) ;

   //根据ID删除
    @RequestMapping(value = "shopDetail/delete")
   Result<Integer> deleteShopDetailById(@RequestParam("shopDetailId")Long shopDetailId) ;

   //根据ID查询
    @RequestMapping(value = "shopDetail/queryById")
   Result<ShopDetail> queryShopDetailById(@RequestParam("shopDetailId") Long shopDetailId);



   //更新
    @RequestMapping(value = "shopDetail/update")
    Result<Integer> update(@RequestBody ShopDetailReq shopDetailReq);

   //查询集合
    @RequestMapping(value = "shopDetail/queryList")
   Result<List<ShopDetail>> queryList(@RequestBody ShopDetailQuery query) ;


}
