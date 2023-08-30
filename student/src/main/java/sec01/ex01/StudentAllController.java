package sec01.ex01;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/member153/*")
public class StudentAllController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	StudentAllDAO memberDAO;

	public void init(ServletConfig config) throws ServletException {
		memberDAO = new StudentAllDAO();
		System.out.println("MemberDAO init 持失切 持失");
	}

	public void destroy() {
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandle(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandle(request, response);
	}

	protected void doHandle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nextPage = null;
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String action = request.getPathInfo();
		System.out.println("action : " + action);
		if (action == null || action.equals("/listMembers.do")) {
			List<StudentAllVO> membersList = memberDAO.listMembers();
			request.setAttribute("membersList", membersList);
			nextPage="/test01/studentresult.jsp";
		}else if (action.equals("/addMember.do")){
			String username = request.getParameter("username");
			String univ = request.getParameter("univ");
			String birth = request.getParameter("birth");
			String email = request.getParameter("email");
			StudentAllVO memberVO = new StudentAllVO(username,univ,birth,email);
			memberDAO.addMember(memberVO);
			nextPage = "/member153/listMembers.do";
		} else if (action.equals("/MemberForm.do")) {
			nextPage="/test01/studentInfo.jsp";
			
		}else if(action.equals("/modMemberForm.do")) {
			String id =request.getParameter("id");
			StudentAllVO memInfo = memberDAO.findMember(id);
			request.setAttribute("memInfo", memInfo);
			nextPage = "/test01/modMemberForm.jsp";
		}else if(action.equals("/modMember.do")) {
			String username = request.getParameter("username");
			String univ = request.getParameter("univ");
			String birth = request.getParameter("birth");
			String email = request.getParameter("email");
			StudentAllVO memberVO = new StudentAllVO(username,univ,birth,email);
			memberDAO.modMember(memberVO);
			request.setAttribute("msg","modified");
			nextPage = "/member153/listMembers.do";
		}else if(action.equals("/delMember.do")) {
			String id = request.getParameter("id");
			memberDAO.delMember(id);
			request.setAttribute("msg","deleted");
			nextPage= "/member153/listMembers.do";
		}else {
			List<StudentAllVO> membersList = memberDAO.listMembers();
			request.setAttribute("membersList", membersList);
			nextPage="/test01/studentresult.jsp";
		}
		RequestDispatcher dispatch = request.getRequestDispatcher(nextPage);
		dispatch.forward(request, response);
	}

}
