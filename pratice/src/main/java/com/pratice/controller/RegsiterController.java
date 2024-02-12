package com.pratice.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pratice.dto.MemerInfoDto;
import com.pratice.dto.SaveResultDto;
import com.pratice.service.RegesiterService;

@Controller
@RequestMapping("/register")
public class RegsiterController {
    @Autowired
    RegesiterService regesiter;
    
    @GetMapping("/add")
    public String register() {
        return "registerForm"; // WEB-INF/views/registerForm.jsp
    }
    
    
    
    @PostMapping("/save")
    public String save(MemerInfoDto inDto , Model m) {
    	SaveResultDto outDto = new SaveResultDto(); 
    	//서비스에 보내기
    	try {
    		outDto = regesiter.regesiter(inDto);

		} catch (Exception e) {
			e.printStackTrace();
			m.addAttribute("errorMessage", e.getMessage());
			
			return "registerForm";
		}
        
        // 모델에 MemerInfoDto 객체를 추가
        //m.addAttribute("memerInfoDto",inDto);
        //return "registerInfo"; // WEB-INF/views/registerInfo.jsp
        return "loginForm";
    }
}