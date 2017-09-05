package com.tiangou.cache;
//package com.tiangou.cache;
//
//import javax.servlet.http.HttpServletRequest;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.ResponseBody;
//
//import com.tiangou.entity.Indent;
//import com.tiangou.service.RabbitUtil;
//import com.tiangou.util.JsonUtils;
//
//@Controller
//public class IndexController {
//	@Autowired
//	private RabbitUtil RabbitUtil;
//
//	@RequestMapping(value = "/index")
//	@ResponseBody
//	public String getIndex(HttpServletRequest request) {
//		Indent indent = new Indent();
//		indent.setAddress("Çàµº");
//		indent.setId("dddddddddddd");
//		indent.setName("¶¡½¨ÀÚ");
//		String objectToJson = JsonUtils.objectToJson(indent);
//		RabbitUtil.sendReliable("exchangeTest", objectToJson);
//		return "niah";
//	}
//}
