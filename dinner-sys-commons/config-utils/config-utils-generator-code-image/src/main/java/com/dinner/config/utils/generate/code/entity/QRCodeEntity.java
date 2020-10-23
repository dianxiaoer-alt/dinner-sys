package com.dinner.config.utils.generate.code.entity;

import lombok.Data;

@Data
public class QRCodeEntity {

    private Integer width = 800;

    private Integer height = 800;

    private String text;

    private String format = "PNG";

    private String filePath = "/dinner/cache/img/test.png";
}
