package com.dinner.shop.admin.vo;

import com.dinner.commons.domain.Goods;
import com.dinner.commons.query.GoodsQuery;
import com.dinner.commons.result.Result;
import com.dinner.config.utils.generate.code.QRCodeGenerator;
import com.dinner.config.utils.generate.code.entity.QRCodeEntity;
import com.dinner.shop.admin.config.jwt.UserLoginToken;
import com.dinner.shop.admin.config.oss.OssUploadConfig;
import com.dinner.shop.admin.feign.GoodsFeign;
import com.google.zxing.WriterException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
public class GoodsController {
    @Autowired
    private GoodsFeign goodsFeign;

    @Autowired
    OssUploadConfig ossUploadConfig;
    @UserLoginToken
    @RequestMapping("queryList")
    public Result<List<Goods>> queryList(GoodsQuery query){
        return goodsFeign.queryList(query);
    }

    @UserLoginToken
    @RequestMapping("orcode")
    public Result<String> ORCode() throws IOException, Exception {
        QRCodeEntity qrCodeEntity = new QRCodeEntity();
        qrCodeEntity.setText("Test");
        InputStream in = QRCodeGenerator.getQRCodeImage(qrCodeEntity);
        String res = ossUploadConfig.upload(in,"",true, UUID.randomUUID().toString().replace("-",""),"png");
        return Result.success(res);
    }

}
