package shop.HealthJava.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UtilController {

    // 서비스 팝업창
    @RequestMapping("/product/service")
    public ModelAndView service() {
        ModelAndView serviceForm = new ModelAndView("util/service"); // 페이지 경로
        
        return serviceForm;
    }
    
    // 회사소개 팝업창
    @RequestMapping("/product/company_introduce")
    public ModelAndView company_introduce() {
    	ModelAndView company_introduceForm = new ModelAndView("util/company_introduce"); // 페이지 경로
    	
    	return company_introduceForm;
    }
    
    // 개인정보 팝업창
    @RequestMapping("/product/privacy")
    public ModelAndView privacy() {
    	ModelAndView privacyForm = new ModelAndView("util/privacy"); // 페이지 경로
    	
    	return privacyForm;
    }
    
    // 가맹점 문의 팝업창
    @RequestMapping("/product/inquiry")
    public ModelAndView inquiry() {
    	ModelAndView inquiryForm = new ModelAndView("util/inquiry"); // 페이지 경로
    	
    	return inquiryForm;
    }
    
    // 나이스페이 팝업창
    @RequestMapping("/product/certificate")
    public ModelAndView certificate() {
    	ModelAndView certificateForm = new ModelAndView("util/certificate"); // 페이지 경로
    	
    	return certificateForm;
    }
	
}
