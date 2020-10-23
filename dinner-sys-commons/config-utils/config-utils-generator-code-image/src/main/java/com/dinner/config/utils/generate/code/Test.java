package com.dinner.config.utils.generate.code;

import com.dinner.config.utils.generate.code.entity.QRCodeEntity;
import com.google.zxing.WriterException;

import java.io.IOException;
import java.io.InputStream;

public class Test {
    public static void main(String[] args) throws IOException, WriterException {
        QRCodeEntity qrCodeEntity = new QRCodeEntity();
        qrCodeEntity.setText("test");
        InputStream in = QRCodeGenerator.getQRCodeImage(qrCodeEntity);
        System.out.println(in);
    }
}
