package com.dinner.commons.result.dto;

import com.dinner.commons.domain.ShopDetail;
import com.dinner.commons.domain.base.Base;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class ShopDTO extends Base implements Serializable {

    @ApiModelProperty("")
    private Long id;
    /**
     * <pre>
     * 数据库字段: shop_name
     * 描述: ;字段长度:32,是否必填:是。
     * </pre>
     */
    @ApiModelProperty("")
    private String shop_name;
    /**
     * <pre>
     * 数据库字段: head_img_url
     * 描述: 店铺头像;字段长度:300,是否必填:否。
     * </pre>
     */
    @ApiModelProperty("店铺头像")
    private String head_img_url;

    private String code_img;
    /**
     * <pre>
     * 数据库字段: shop_email
     * 描述: ;字段长度:32,是否必填:是。
     * </pre>
     */
    @ApiModelProperty("")
    private String shop_email;
    /**
     * <pre>
     * 数据库字段: shop_tel
     * 描述: 店铺电话;字段长度:32,是否必填:是。
     * </pre>
     */
    @ApiModelProperty("店铺电话")
    private String shop_tel;
    /**
     * <pre>
     * 数据库字段: shop_password
     * 描述: ;字段长度:300,是否必填:是。
     * </pre>
     */
    @ApiModelProperty("")
    private String shop_password;
    /**
     * <pre>
     * 数据库字段: app_id
     * 描述: 公众号APPID;字段长度:200,是否必填:否。
     * </pre>
     */
    @ApiModelProperty("公众号APPID")
    private String app_id;
    /**
     * <pre>
     * 数据库字段: app_secret
     * 描述: 公众号AppSecret;字段长度:200,是否必填:否。
     * </pre>
     */
    @ApiModelProperty("公众号AppSecret")
    private String app_secret;
    /**
     * <pre>
     * 数据库字段: mch_id
     * 描述: 商户号;字段长度:200,是否必填:否。
     * </pre>
     */
    @ApiModelProperty("商户号")
    private String mch_id;
    /**
     * <pre>
     * 数据库字段: pay_key
     * 描述: 商户支付密码;字段长度:200,是否必填:否。
     * </pre>
     */
    @ApiModelProperty("商户支付密码")
    private String pay_key;
    /**
     * <pre>
     * 数据库字段: last_login_ip
     * 描述: ;字段长度:32,是否必填:否。
     * </pre>
     */
    @ApiModelProperty("")
    private String last_login_ip;
    /**
     * <pre>
     * 数据库字段: is_deleted
     * 描述: ;字段长度:1,是否必填:否。
     * </pre>
     */
    @ApiModelProperty("")
    private Integer is_deleted;
    /**
     * <pre>
     * 数据库字段: is_confirm
     * 描述: 0没有通过认证，1已通过认证;字段长度:1,是否必填:否。
     * </pre>
     */
    @ApiModelProperty("0没有通过认证，1已通过认证")
    private Integer is_confirm;
    /**
     * <pre>
     * 数据库字段: is_on
     * 描述: 是否在缴费使用期是否正常使用；0不能使用，1能使用;字段长度:1,是否必填:否。
     * </pre>
     */
    @ApiModelProperty("是否在缴费使用期是否正常使用；0不能使用，1能使用")
    private Integer is_on;
    /**
     * <pre>
     * 数据库字段: use_start_time
     * 描述: 使用期限开始日期;字段长度:,是否必填:否。
     * </pre>
     */
    @ApiModelProperty("使用期限开始日期")
    private Date use_start_time;
    /**
     * <pre>
     * 数据库字段: use_end_time
     * 描述: 使用期限结束日期;字段长度:,是否必填:否。
     * </pre>
     */
    @ApiModelProperty("使用期限结束日期")
    private Date use_end_time;


    private String shop_user_name;
    private String shop_user_code;


    private ShopDetail shop_detail;
}
