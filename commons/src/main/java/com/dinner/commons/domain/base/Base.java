package com.dinner.commons.domain.base;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class Base {
    /**
     * <pre>
     * 数据库字段:
     * is_enable
     * 字段描述:
     *  data status: 1-enabled,2-inactived,0-disabled ;字段的长度:2,是否必填:是。
     * </pre>
     * @ApiModelProperty(hidden = true)
     */
    //private Integer is_enable;
    /**
     * <pre>
     * 数据库字段:
     * is_delete
     * 字段描述:
     *  data logic delete status: 1-deleted,0-not deleted ;字段的长度:2,是否必填:是。
     * </pre>
     */
    //private Integer is_delete;


    /**
     * <pre>
     * 数据库字段:
     * create_time
     * 字段描述:
     *  create_time;字段的长度:,是否必填:是。
     * </pre>
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date create_time;
    /**
     * <pre>
     * 数据库字段:
     * create_by
     * 字段描述:
     *  created_by user;字段的长度:20,是否必填:否。
     * </pre>
     */
    //private Long create_by;
    /**
     * <pre>
     * 数据库字段:
     * update_time
     * 字段描述:
     *  update_time;字段的长度:,是否必填:否。
     * </pre>
     */
    //@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date update_time;
    /**
     * <pre>
     * 数据库字段:
     * update_by
     * 字段描述:
     *  updated_by user;字段的长度:20,是否必填:否。
     * </pre>
     */
    //private Long update_by;
}
