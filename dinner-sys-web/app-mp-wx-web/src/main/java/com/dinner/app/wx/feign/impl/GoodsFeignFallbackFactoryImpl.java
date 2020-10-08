package com.dinner.app.wx.feign.impl;

import com.dinner.app.wx.constant.AbstractFallbackFactory;
import com.dinner.app.wx.feign.GoodsFeignAO;
import com.dinner.commons.domain.Goods;
import com.dinner.commons.error.ErrorEnum;
import com.dinner.commons.query.GoodsQuery;
import com.dinner.commons.result.Result;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service("goodsFeignAO")
public class GoodsFeignFallbackFactoryImpl extends AbstractFallbackFactory implements FallbackFactory<GoodsFeignAO> {
    @Override
    public GoodsFeignAO create(Throwable throwable) {
        return new GoodsFeignAO() {
            @Override
            public Result<List<Goods>> queryList(GoodsQuery query) {
                return Result.error(ErrorEnum.SERVER_DOWN);
            }
        };
    }
}
