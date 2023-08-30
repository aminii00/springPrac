package com.spring.ex02;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller("loginController")
public class LoginController {
	
	@RequestMapping(value= {"/test/loginForm.do", "test/loginForm2.do"}, method = {RequestMethod.GET})
	public ModelAndView loginForm(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		ModelAndView mav = new ModelAndView();
		mav.setViewName("loginForm");
		return mav;
	}
	@RequestMapping(value= "/test/login.do", method = {RequestMethod.POST})
	public ModelAndView login(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		ModelAndView mav = new ModelAndView();
		mav.setViewName("result");
	    String userID = request.getParameter("userID");
	    String userName = request.getParameter("userName");
	    mav.addObject("userID",userID);
	    mav.addObject("userName",userName);
	
	    return mav;
	}
	
	/*  1.@Requestparam("userID") String userID
	    2. @Requestparam("userID") String userID  ==  String userID 
	  = request.getParameter(value="userID", required =true) @은 매개변수 안에 넣어야 함! 
	                                   required =true는 받을 값이 무조건 있어야함 기본이 true ,
	                                    false면 받던지 안받던지 오류나도 넘어감
	                                    
	   3. @Requestparam Map<String,String> info(참조변수)
	   4. @ModelAttribute("info") LoginVO loginVO -> 개발자가 만든 저장소 객체로 보낼땐 ModelAttribute로!
	   5. Model은 저장만 할 수 있음. 저장을 할 땐 addAttribute로 저장한다.  
	      리턴할땐 return "result" action- servlet : prefix, suffix 에 /뒤에 붙여준다.             */
	
	@RequestMapping(value= "/test/login2.do", method = {RequestMethod.POST, RequestMethod.GET})
	public ModelAndView login2(@RequestParam("userID") String userID, @RequestParam("userName") String userName, HttpServletRequest request, HttpServletResponse response ) throws Exception{
		request.setCharacterEncoding("utf-8");
		ModelAndView mav = new ModelAndView();
		mav.setViewName("result");
		System.out.println("userID:" + userID);
		System.out.println("userName:" + userName);
		mav.addObject("userID",userID);
		mav.addObject("userName",userName);
		
		return mav;
	}
	
	@RequestMapping(value= "/test/login2.do", method = {RequestMethod.POST, RequestMethod.GET})
	public ModelAndView login2(@RequestParam("userID") String userID, @RequestParam(value = "userName", required=true) String userName, @RequestParam(value = "email", required=false) String email, HttpServletRequest request, HttpServletResponse response ) throws Exception{
		request.setCharacterEncoding("utf-8");
		ModelAndView mav = new ModelAndView();
		mav.setViewName("result");
		System.out.println("userID:" + userID);
		System.out.println("userName:" + userName);
		System.out.println("email" + email);
		mav.addObject("userID",userID);
		mav.addObject("userName",userName);
		
		return mav;
	}
	
	@RequestMapping(value= "/test/login3.do", method = {RequestMethod.POST, RequestMethod.GET})
	public ModelAndView login3(@RequestParam Map<String,String> info, HttpServletRequest request, HttpServletResponse response ) throws Exception{
		request.setCharacterEncoding("utf-8");
		ModelAndView mav = new ModelAndView();
		String userID = info.get("userID");
		String userName = info.get("userName");
		System.out.println("userID:" + userID);
		System.out.println("userName:" + userName);
		
		mav.addObject("info",info);
		
		return mav;
	}
	
	@RequestMapping(value= "/test/login4.do", method = {RequestMethod.POST, RequestMethod.GET})
	public ModelAndView login4(@ModelAttribute("info") LoginVO loginVO, HttpServletRequest request, HttpServletResponse response ) throws Exception{
		request.setCharacterEncoding("utf-8");
		ModelAndView mav = new ModelAndView();
		System.out.println("userID:" + loginVO.getUserID());
		System.out.println("userName:" + loginVO.getUserName());
		mav.setViewName("result");
		
		return mav;
	}
	
	@RequestMapping(value= "/test/login5.do", method = {RequestMethod.POST, RequestMethod.GET})
	public String login5(Model model,HttpServletRequest request, HttpServletResponse response ) throws Exception{
		request.setCharacterEncoding("utf-8");
		model.addAttribute("userID","aminii");
		model.addAttribute("userName","최민아");
		return "result";
	}
}
