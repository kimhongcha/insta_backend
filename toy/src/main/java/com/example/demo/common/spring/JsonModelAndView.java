package com.example.demo.common.spring;

import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

public class JsonModelAndView extends ModelAndView{

		Map<String, Object> resultMap;

		public JsonModelAndView(){
			super("jsonView");
		}

		public JsonModelAndView(Map<String, ?> paramMap) {
			super("jsonView");
			super.addAllObjects(paramMap);
		}

		public JsonModelAndView(String attributeName, Object attributeValue){
			this();
			put(attributeName, attributeValue);
		}

		public JsonModelAndView put(String attributeName, Object attributeValue){
			addObject(attributeName, attributeValue);
			return this;
		}


	}


