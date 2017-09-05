package com.tiangou.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tiangou.entity.Indent;
import com.tiangou.mapper.IndentMapper;

@Controller("/")
public class IndexController {
	@Autowired
	private IndentMapper indentMapper;

	@RequestMapping("index")
	public String getIndex() {
		return "index";
	}
}
