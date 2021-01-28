package com.servi.study.extend.imag;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Base64;
import net.coobird.thumbnailator.Thumbnails;

public class ImageAdjustUtils {

	/**
	 * 默认大小
	 */
	private static final int DEFAULT_SIZE = 1024;

	/**
	 * 图片处理
	 */
	public static byte[] adjustSize(byte[] input) throws IOException {

		return adjustSize(input, DEFAULT_SIZE);
	}

	/**
	 * 图片处理
	 */
	public static byte[] adjustSize(byte[] input, int outputSize) throws IOException {

		ByteArrayOutputStream out = new ByteArrayOutputStream();
		Thumbnails.of(new ByteArrayInputStream(input)).size(outputSize, outputSize).useExifOrientation(
				true).outputFormat("jpg").toOutputStream(out);
		return out.toByteArray();
	}

	/**
	 *
	 * @Description 将原始base64编码的图像压缩
	 *
	 * @param base64file
	 * @return 压缩后的base64编码
	 * @throws IOException
	 */
	public static String adjustSize(String base64file) throws IOException {

		byte[] b = Base64.getDecoder().decode(base64file);

		InputStream stream = new ByteArrayInputStream(b);
		// 如果数据大于 300K 才执行压缩算法
		if (300 * 1024 > stream.available()) {
			return base64file;
		}

		for (int i = 0; i < b.length; ++i) {
			if (b[i] < 0) {// 调整异常数据
				b[i] += 256;
			}
		}
		String newFile = Base64.getEncoder().encodeToString(ImageAdjustUtils.adjustSize(b));
		return newFile;
	}
}
