/**
 * Copyright  2010-2015 四川数码物联网络科技有限责任公司. All Rights Reserved.
 */
package com.yida.model.test;

import java.io.File;
import java.util.Date;

import com.yida.dzyj.model.ICalculable;
import com.yida.dzyj.model.ModelCalcParameter;
import com.yida.dzyj.model.impl.basic.CasualtiesCalc;
import com.yida.utils.DateUtils;
import com.yida.utils.FileUtils;

/**
 *********************
 * @author wj
 * @version 1.0
 * @created 2017年7月25日 下午2:11:34
 ***********************
 */
public class CasualtiesCalcTest {

	public static void main(String[] args) throws Exception {

		String inputPath = "C:\\Users\\lenovo\\Desktop\\网格计算输出\\人员伤亡输入.xml";
		String parameterPath = "C:\\Users\\lenovo\\Desktop\\网格计算输出\\人员伤亡计算参数.xml";
		File file = new File(inputPath);
		String input = FileUtils.readFile(file, FileUtils.getFileCharset(file));
		File file1 = new File(parameterPath);
		String parameterStr = FileUtils.readFile(file1, FileUtils.getFileCharset(file1));

		ICalculable c = new CasualtiesCalc();
		ModelCalcParameter parameters = new ModelCalcParameter();
		parameters.setModelCoeff(parameterStr);

		String s = "2017-07-25 11:03:25";
		Date converToDate = DateUtils.converToDate(s, DateUtils.DATE_TIME24_FORMAT);
		parameters.setHappenTime(converToDate);
		long currentTimeMillis = System.currentTimeMillis();
		String calculate = c.calculate(input, parameters);
		System.err.println("耗时：" + (System.currentTimeMillis() - currentTimeMillis));
		FileUtils.writeFile(calculate, new File("C:\\Users\\lenovo\\Desktop\\网格计算输出\\iiiiiiiiii.xml"));
	}

}
