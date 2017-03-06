package com.rock.cybski.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value="/jqPlot")
public class JqPlotController {
	
	private final Log log = LogFactory.getLog(JqPlotController.class);
	
	@RequestMapping(value="")
	public String entryPage(Model m){
		m.addAttribute("testStr", "RT Test");
		System.out.println("Test");
		return "jqPlot/jqPlot";
	}
	
	@RequestMapping(value="/json4AjaxJsonDataRenderer")
	@ResponseBody
	public List<List<Integer>> json4AjaxJsonDataRenderer(){
		log.debug("json4AjaxJsonDataRenderer");
		List<Integer> result = new ArrayList<Integer>();
		for(int i=0;i<5;i++){
			Integer x = i+1;
			result.add(x);
		}
		List<List<Integer>> ret= new ArrayList<List<Integer>>();
		ret.add(result);
		return ret;
	}
}
