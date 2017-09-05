package com.tiangou.util;



import java.io.FileReader;
import java.io.IOException;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;

import com.alibaba.fastjson.JSONObject;

public class CommonUtils {

	public static JSONObject getUrlParam() {
		JSONObject jsonObject = null;
		FileReader reader = null;
		try {
			ScriptEngineManager manager = new ScriptEngineManager();
			ScriptEngine engine = manager.getEngineByName("javascript");
			
			String jsFileName = "H://toutiao.js"; // 读取js文件

			reader = new FileReader(jsFileName); // 执行指定脚本
			engine.eval(reader);

			if (engine instanceof Invocable) {
				Invocable invoke = (Invocable) engine;
				Object obj = invoke.invokeFunction("getParam");
				jsonObject = JSONObject.parseObject(obj != null ? obj.toString() : null);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (reader != null) {
					reader.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return jsonObject;
	}
	
}
