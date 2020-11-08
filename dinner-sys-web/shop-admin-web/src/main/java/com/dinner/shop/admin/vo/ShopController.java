package com.dinner.shop.admin.vo;

import com.dinner.commons.domain.Shop;
import com.dinner.commons.error.ErrorEnum;
import com.dinner.commons.request.ShopReq;
import com.dinner.commons.result.Result;
import com.dinner.config.oss.utils.PathConfigEnum;
import com.dinner.config.utils.generate.code.QRCodeGenerator;
import com.dinner.config.utils.generate.code.entity.QRCodeEntity;
import com.dinner.shop.admin.config.jwt.JWTTokenConfig;
import com.dinner.shop.admin.config.jwt.PassToken;
import com.dinner.shop.admin.config.jwt.UserLoginToken;

import com.dinner.shop.admin.config.jwt.UserPassToken;
import com.dinner.shop.admin.config.oss.OssUploadConfig;
import com.dinner.shop.admin.feign.ShopFeign;
import com.dinner.shop.admin.vo.base.AbstractController;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;

/**
 * 功能描述：
 *
 * @author:陈丽强
 * @Date:2020/5/3 15:49
 */
@RestController
@RequestMapping("shop")
public class ShopController extends AbstractController {
    @Autowired
    private ShopFeign shopFeign;

    @Value("${dinner.sys.appUrl}")
    private String appUrl;

    @Autowired
    private JWTTokenConfig jwtTokenConfig;

    @Autowired
    OssUploadConfig ossUploadConfig;

    @PassToken
    @GetMapping("login")
    public Result<String> shopLoginByTelOrEmail(@RequestParam("value") String value, @RequestParam("password") String password){
      Result<Shop> res = shopFeign.shopLoginByTelOrEmail(value,password);
      if (res.getCode() != 0)
          return Result.error(ErrorEnum.AUTHENTICATION_FAILED);
      return Result.success(jwtTokenConfig.getTokenString(res.getData()));
    }


    @UserLoginToken
    @GetMapping("getShopUser")
    public Result<Shop> getShopUser(HttpServletRequest request){
        Long shop_id = parseShopId(request);
        return Result.success(shopFeign.queryById(shop_id).getData());
    }

    @UserLoginToken
    @RequestMapping("orcode")
    public Result<String> ORCode(HttpServletRequest request) throws IOException, Exception {
        QRCodeEntity qrCodeEntity = new QRCodeEntity();
        qrCodeEntity.setText(appUrl+"?shopId="+parseShopId(request));
        InputStream in = QRCodeGenerator.getQRCodeImage(qrCodeEntity);
        String res = ossUploadConfig.upload(in, PathConfigEnum.DATE.getPath(),true, UUID.randomUUID().toString().replace("-","")+".png","png");

        if (StringUtils.isNoneBlank(res)){
            ShopReq shop = new ShopReq();
            shop.setId(parseShopId(request));
            shop.setCode_img(res);
            shopFeign.update(shop);
        }

        return Result.success(res);
    }
}
