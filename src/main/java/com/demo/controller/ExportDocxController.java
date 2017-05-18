package com.demo.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

import org.springframework.stereotype.Controller;

import com.demo.util.WordUtil;
import com.demo.util.ZipUtils;
import com.jfinal.kit.PathKit;

import freemarker.template.Template;

@Controller
public class ExportDocxController {

	private static final String basePath = PathKit.getRootClassPath() + "/template/2007/";

	/**
	 * 构造测试数据
	 * 
	 * @return
	 */
	public Map<String, Object> createDatas() {
		Map<String, Object> testMap = new HashMap<String, Object>();
		// 构造散数据
		testMap.put("author", "孙珂");
		testMap.put("date", "2015-11-20");

		// 构造列表循环数据存放在ArrayList集合中
		List<Map<String, String>> list = new ArrayList<Map<String, String>>();
		for (int i = 0; i < 5; i++) {
			Map<String, String> map = new HashMap<String, String>();
			map.put("xh", (i + 1) + "");
			map.put("name", "张三" + i);
			map.put("phone", "1381111222" + i);
			list.add(map);
		}
		testMap.put("datas", list);

		return testMap;
	}

	/**
	 * 生成docx
	 * 
	 * @throws Exception
	 */
	public void exportDocx() throws Exception {

		WordUtil handler = new WordUtil();

		/** 加载模板 **/
		Template template = handler.getTemplate(basePath, "document.xml");

		/** 准备数据 **/
		Map<String, Object> dataMap = createDatas();

		/** 指定输出word文件的路径 **/
		String outFilePath = basePath + "data.xml";
		handler.writeTemlate(outFilePath, template, dataMap);
		try {

			ZipInputStream zipInputStream = ZipUtils
					.wrapZipInputStream(new FileInputStream(new File(basePath
							+ "ftltest.zip")));
			ZipOutputStream zipOutputStream = ZipUtils
					.wrapZipOutputStream(new FileOutputStream(new File(basePath
							+ "test07.docx")));
			String itemname = "word/document.xml";
			ZipUtils.replaceItem(zipInputStream, zipOutputStream, itemname,
					new FileInputStream(new File(basePath + "data.xml")));
			System.out.println("07导出成功");

		} catch (Exception e) {
			System.out.println(e.toString());
		}
	}

	/**
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {
		ExportDocxController exporter = new ExportDocxController();
		exporter.exportDocx();
	}
}
