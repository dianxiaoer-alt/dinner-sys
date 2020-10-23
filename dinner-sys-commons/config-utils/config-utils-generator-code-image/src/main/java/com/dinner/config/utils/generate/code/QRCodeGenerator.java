package com.dinner.config.utils.generate.code;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import com.dinner.config.utils.generate.code.entity.QRCodeEntity;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import org.apache.commons.lang3.StringUtils;

/**
 * 二维码生成器
 */
public final class QRCodeGenerator {
	/**
	 * 生成二维码
	 * @param qrCodeEntity
	 * @throws WriterException
	 * @throws IOException
	 */
	public static void generateQRCodeImage(QRCodeEntity qrCodeEntity) throws WriterException, IOException {
		if (qrCodeEntity == null || StringUtils.isBlank(qrCodeEntity.getText()))
			throw new RuntimeException("参数非法");

		QRCodeWriter qrCodeWriter = new QRCodeWriter();
		
		BitMatrix bitMatrix = qrCodeWriter.encode(qrCodeEntity.getText(), BarcodeFormat.QR_CODE, qrCodeEntity.getWidth(), qrCodeEntity.getHeight());

		Path path = FileSystems.getDefault().getPath(qrCodeEntity.getFilePath());
		//Path p = new
		
		MatrixToImageWriter.writeToPath(bitMatrix, qrCodeEntity.getFormat(), path);
		
	}

	public static InputStream getQRCodeImage(QRCodeEntity qrCodeEntity) throws WriterException, IOException {
		QRCodeWriter qrCodeWriter = new QRCodeWriter();
		if (qrCodeEntity == null || StringUtils.isBlank(qrCodeEntity.getText()))
			throw new RuntimeException("参数非法");
		BitMatrix bitMatrix = qrCodeWriter.encode(qrCodeEntity.getText(), BarcodeFormat.QR_CODE, qrCodeEntity.getWidth(), qrCodeEntity.getHeight());

		ByteArrayOutputStream pngOutputStream = new ByteArrayOutputStream();
		MatrixToImageWriter.writeToStream(bitMatrix, "PNG", pngOutputStream);
		byte[] pngData = pngOutputStream.toByteArray();
		InputStream in = new ByteArrayInputStream(pngData);
		return in;
	}
 
}