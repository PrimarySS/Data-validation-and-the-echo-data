package cn.ssm.xhchen.controller.converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.core.convert.converter.Converter;

/**
 * 
 * ClassName: CustomerDateConverter
 * 
 * @Description: 日期转换器
 * @author XHChen
 * @date 2018年10月21日 上午11:56:35
 */
public class CustomerDateConverter implements Converter<String, Date> {

	@Override
	public Date convert(String source) {

		// 把日期串转换成yyyy:MM:dd HH:mm:ss格式
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy:MM:dd HH:mm:ss");

		// 根据需求格式转换
		try {
			return simpleDateFormat.parse(source);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		return null;
	}

}
