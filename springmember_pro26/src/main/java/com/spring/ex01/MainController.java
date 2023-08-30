package com.spring.ex01;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/*@Controller 자동 객체 생성
@RequestMapping 1차 매핑
@RequestAMapping(value="/main2.do get방식으롱"
@이작업할수있게하는 공간은 action-servlet의 bean객체로 인해 2가지! */
@Controller("mainController")
@RequestMapping("/test")
public class MainController {
	
	@RequestMapping(value="/main1.do", method=RequestMethod.GET)
    public ModelAndView main1(HttpServletRequest request, HttpServletResponse response) throws Exception {
    	ModelAndView mav =new ModelAndView();
    	mav.addObject("msg", "main1");
		/*
		  mad.addObject 모델앤드뷰에서 지원해주는 메서드 msg는 스트링형으로 변하고, main1이 스트링형이기때문에
		  setviewname메서드 호출하며 main을 넣어줌
		 */
    	mav.setViewName("main");
		
    	return mav;
    	/*
		  mav객체를 리턴 리턴한 값을 받는 객체는 main1을 호출한 녀석 action-sevlet.xml의 dispatcherServlet에서
		  main.jsp 호출
		  main2.do가 실행 되면 , *.do dispatcherservlet !
		 */
    }
	
	@RequestMapping(value="/main2.do", method=RequestMethod.GET)
    public ModelAndView main2(HttpServletRequest request, HttpServletResponse response) throws Exception {
    	ModelAndView mav =new ModelAndView();
    	mav.addObject("msg", "main2");
    	mav.setViewName("main");
    	
    	return mav;
    }

}
