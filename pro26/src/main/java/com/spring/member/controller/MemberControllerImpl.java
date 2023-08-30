package com.spring.member.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import com.spring.member.service.MemberService;
import com.spring.member.vo.MemberVO;


/*3. @Controller 
-> 컨트롤러일땐 (컨트롤러 일을 하는 객체를 생성하고 @에 값을 넣음)
    MemberServiceImpl 객체 주소가 들어간 어노테이션 memberService
    객체생성 의존성주입은 @Autowired!!!*/
@Controller("memberController")
public class MemberControllerImpl extends MultiActionController implements MemberController {
	
	@Autowired
	private MemberService memberService;
	@Autowired
	private MemberVO memberVO;



	@Override
	@RequestMapping(value="/member/listMembers.do", method = RequestMethod.GET)
	public ModelAndView listMembers(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String viewname = getViewName(request);
		List membersList = memberService.listMembers();
		ModelAndView mav = new ModelAndView(viewname);
		mav.addObject("membersList",membersList);
		return mav;
	}
	
	@Override
	@RequestMapping(value="/member/addMember.do", method = RequestMethod.POST)
	public ModelAndView addMember(@ModelAttribute("member") MemberVO member, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		System.out.println("addMember");
		request.setCharacterEncoding("utf-8");
		int result = 0;
		result = memberService.addMember(member);
		ModelAndView mav = new ModelAndView("redirect:/member/listMembers.do");
		return mav;
	}
	
	

	@Override
	@RequestMapping(value="/member/removeMember.do", method = RequestMethod.GET)
	public ModelAndView removeMember(@RequestParam("id") String id, HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		memberService.removeMember(id);
		ModelAndView mav = new ModelAndView("redirect:/member/listMembers.do");
		return mav;
	}


	
	  @Override
	  @RequestMapping(value="/member/modMemberForm.do", method = RequestMethod.GET)
	  public ModelAndView modMemberForm(
			  @RequestParam("id") String id, HttpServletRequest request, HttpServletResponse response) throws Exception {
	  request.setCharacterEncoding("utf-8"); 
	  memberVO =memberService.modMemberForm(id); 
	  String viewName = getViewName(request);
	  ModelAndView mav = new ModelAndView(viewName); 
	  mav.addObject("memberVO", memberVO);
	  return mav; 
	  }
	 
	
	@Override
	@RequestMapping(value="/member/modMember.do", method = RequestMethod.POST)
	public ModelAndView modMember
	(@ModelAttribute("member") MemberVO member, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		System.out.println("modMember");
		request.setCharacterEncoding("utf-8");
		int result = 0;
		result = memberService.modMember(member);
		ModelAndView mav = new ModelAndView("redirect:/member/listMembers.do");
		return mav;
	}
	
	@RequestMapping(value="/member/*Form.do", method = RequestMethod.GET)
	public ModelAndView form(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("Form");
		String viewName = getViewName(request);
		ModelAndView mav = new ModelAndView();
		mav.setViewName(viewName);
		return mav;
	}
	
/*  1.@Requestparam("userID") String userID
 * 
    2. @Requestparam("userID") String userID  ==
      String userID  = request.getParameter(value="userID", required =true) @은 매개변수 안에 넣어야 함! 
                                   required =true는 받을 값이 무조건 있어야함 기본이 true ,
                                    false면 받던지 안받던지 오류나도 넘어감
                                    
   3. @Requestparam Map<String,String> info(참조변수)
   
   4. @ModelAttribute("info") LoginVO loginVO -> 개발자가 만든 저장소 객체로 보낼땐 ModelAttribute로!
   
   5. Model은 저장만 할 수 있음. 저장을 할 땐 addAttribute로 저장한다.  
   
      리턴할땐 return "result" action- servlet : prefix, suffix 에 /뒤에 붙여준다.             */
	
	
	public String getViewName(HttpServletRequest request) throws Exception {
		
		String contextPath = request.getContextPath();
		String uri = (String)request.getAttribute("javac.servlet.include.request_uri");
		if(uri == null || uri.trim().equals("")) {
			uri = request.getRequestURI();
		}
		int begin = 0;
		if(!((contextPath == null ) || ("".equals(contextPath)))) {
			begin = contextPath.length();
		}
		int end;
		if(uri.indexOf(";") != -1) {
			end = uri.indexOf(";");
		}else if(uri.indexOf("?") != -1) {
			end = uri.indexOf("?");
		}else {
			end = uri.length();
		}
		
		String fileName = uri.substring(begin, end);
		if (fileName.indexOf(".") != -1) {
			fileName = fileName.substring(0,fileName.lastIndexOf("."));
		}
		
		if (fileName.indexOf("/") != -1) {
			fileName = fileName.substring(fileName.lastIndexOf("/"),fileName.length());
		}
		return fileName;
		
		
	}


}
