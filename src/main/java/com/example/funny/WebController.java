package com.example.funny;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
public class WebController {
    @ResponseBody
    @GetMapping("/")
    public ModelAndView home() {
        ModelAndView modelAndView = new ModelAndView();
        
        modelAndView.setViewName("home");
        
        Map<String, Object> map = new HashMap<>();
        map.put("name", "test page");
        map.put("date", LocalDateTime.now());
        
        modelAndView.addObject("data", map);
        
        return modelAndView;
    }
    
    @GetMapping("/job01")
    public void job01() {
    	List<String> command = new ArrayList<>();

    	// javaコマンド
    	command.add(System.getProperty("java.home") + "/bin/java");
    	command.add("-Dfile.encoding=UTF-8");
    	command.add("-Dspring.datasource.initialization-mode=never");
    	command.add("-Dspring.main.web-application-type=none");
    	command.add("-Dspring.batch.job.enabled=true");
    	command.add("-Dspring.batch.job.names=job01");
   		command.add("-jar");
   		command.add(System.getProperty("/tmp/demo-0.0.1-SNAPSHOT.jar"));
    	command.add("run.id=1");

    	ProcessBuilder builder = new ProcessBuilder(command);
    	builder.inheritIO();

    	try {
    		builder.start();
		} catch (IOException e) {
			e.printStackTrace();
		}
    }  
}
