package com.rock.cybski.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value="/jqPlot")
public class JqPlotController {
	
	private final Log log = LogFactory.getLog(JqPlotController.class);
	
	@RequestMapping(value="")
	public String entryPage(Model m){
		log.debug("JqPlotController->entryPage");
		m.addAttribute("testStr", "RT Test");
		System.out.println("Test");
		return "jqPlot/jqPlot";
	}
	
}
