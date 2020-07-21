package com.dinner.goods.vo;

import com.dinner.commons.domain.GoodsType;
import com.dinner.commons.query.GoodsTypeQuery;
import com.dinner.commons.request.GoodsTypeReq;
import com.dinner.commons.result.Result;
import com.dinner.goods.ao.GoodsTypeAO;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * 功能描述：
 *
 * @author:陈丽强
 * @Date:2020/7/20 23:27
 */
@Api(tags = "菜品表分类")
@RestController
@RequestMapping("goodsType")
public class GoodsTypeVO {

    @Autowired
    private GoodsTypeAO goodsTypeAO;

    @PostMapping("insert")
    Result<Integer> insert(@Valid @RequestBody GoodsTypeReq goodsTypeReq){
        return goodsTypeAO.insert(goodsTypeReq);
    }

    @PostMapping("update")
    Result<Integer> update(@Valid @RequestBody  GoodsTypeReq goodsTypeReq){
        return goodsTypeAO.update(goodsTypeReq);
    }

    @GetMapping("queryOneById")
    Result<GoodsType> queryOneById(Long id){
        return goodsTypeAO.queryOneById(id);
    }

    @GetMapping("queryList")
    Result<List<GoodsType>> queryList(@RequestBody GoodsTypeQuery goodsTypeQuery){
        return goodsTypeAO.queryList(goodsTypeQuery);
    }

    @GetMapping("queryListByShopId")
    Result<List<GoodsType>> queryListByShopId(Long shop_id){
        return goodsTypeAO.queryListByShopId(shop_id);
    }

    @GetMapping("delete")
    Result<Integer> delete(Long id){
        return goodsTypeAO.delete(id);
    }
}
