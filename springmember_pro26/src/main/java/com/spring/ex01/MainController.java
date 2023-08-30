package com.spring.ex01;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/*@Controller �ڵ� ��ü ����
@RequestMapping 1�� ����
@RequestAMapping(value="/main2.do get�������"
@���۾��Ҽ��ְ��ϴ� ������ action-servlet�� bean��ü�� ���� 2����! */
@Controller("mainController")
@RequestMapping("/test")
public class MainController {
	
	@RequestMapping(value="/main1.do", method=RequestMethod.GET)
    public ModelAndView main1(HttpServletRequest request, HttpServletResponse response) throws Exception {
    	ModelAndView mav =new ModelAndView();
    	mav.addObject("msg", "main1");
		/*
		  mad.addObject �𵨾ص�信�� �������ִ� �޼��� msg�� ��Ʈ�������� ���ϰ�, main1�� ��Ʈ�����̱⶧����
		  setviewname�޼��� ȣ���ϸ� main�� �־���
		 */
    	mav.setViewName("main");
		
    	return mav;
    	/*
		  mav��ü�� ���� ������ ���� �޴� ��ü�� main1�� ȣ���� �༮ action-sevlet.xml�� dispatcherServlet����
		  main.jsp ȣ��
		  main2.do�� ���� �Ǹ� , *.do dispatcherservlet !
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
