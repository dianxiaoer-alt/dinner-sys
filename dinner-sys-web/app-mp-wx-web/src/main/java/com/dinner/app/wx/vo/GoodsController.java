package com.dinner.app.wx.vo;

import com.dinner.app.wx.config.jwt.UserPassToken;
import com.dinner.app.wx.feign.GoodsFeignAO;
import com.dinner.commons.domain.Goods;
import com.dinner.commons.query.GoodsQuery;
import com.dinner.commons.result.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("goods")
public class GoodsController {
    @Autowired
    private GoodsFeignAO goodsFeignAO;

    @UserPassToken
    @RequestMapping("queryList")
    public Result<List<Goods>> queryList(@RequestBody  GoodsQuery query){
        return goodsFeignAO.queryList(query);
    }
}
