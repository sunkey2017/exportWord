package com.demo.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;

@Controller
public class StudentController {

	@RequestMapping("/helloWorld")
	public String helloWorld(Model model) {
		
		Map<String, Object> testMap = new HashMap<String, Object>();
		// 构造散数据
		testMap.put("title", "java freemarker 导出Word");
		testMap.put("author", "孙珂test");
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
		testMap.put("tableData", list);
		//将数据添加到视图数据容器中
		model.addAttribute("datas",testMap);
		return "Hello.ftl";
	}
}
