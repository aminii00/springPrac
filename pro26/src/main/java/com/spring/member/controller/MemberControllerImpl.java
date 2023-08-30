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
-> ��Ʈ�ѷ��϶� (��Ʈ�ѷ� ���� �ϴ� ��ü�� �����ϰ� @�� ���� ����)
    MemberServiceImpl ��ü �ּҰ� �� ������̼� memberService
    ��ü���� ������������ @Autowired!!!*/
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
      String userID  = request.getParameter(value="userID", required =true) @�� �Ű����� �ȿ� �־�� ��! 
                                   required =true�� ���� ���� ������ �־���� �⺻�� true ,
                                    false�� �޴��� �ȹ޴��� �������� �Ѿ
                                    
   3. @Requestparam Map<String,String> info(��������)
   
   4. @ModelAttribute("info") LoginVO loginVO -> �����ڰ� ���� ����� ��ü�� ������ ModelAttribute��!
   
   5. Model�� ���常 �� �� ����. ������ �� �� addAttribute�� �����Ѵ�.  
   
      �����Ҷ� return "result" action- servlet : prefix, suffix �� /�ڿ� �ٿ��ش�.             */
	
	
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
