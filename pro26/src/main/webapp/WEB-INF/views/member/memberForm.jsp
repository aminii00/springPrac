<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
	
	isELIgnored="false"	%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath }" />
<%
request.setCharacterEncoding("utf-8");
%>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
 <form class="border border-warning" method = "post" action ="${contextPath}/member/addMember.do">
  <h1 class ="text_center" align ="center">회원가입창</h1>
  <table align="center">
    <tr>
      <td width="200"><p align="right">아이디</p></td>
      <td width="400"><input type="text" name="id"></td>
   </tr>
   <tr>
      <td width="200"><p align="right">비밀번호</p></td>
      <td width="400"><input type="password" name="pwd"></td>
   </tr>
   <tr>
      <td width="200"><p align="right">이름</p></td>
      <td width="400"><input type="text" name="name"></td>
   </tr>
   <tr>
      <td width="200"><p align="right">이메일</p></td>
      <td width="400"><input type="email" name="email"></td>
   </tr>
   <tr>
   <td width="200"><p align="right">
     <td width="400"><input type="submit" class="btn btn-light" value="회원가입">
                     <input type="reset" class="btn btn-light" value="다시"></td>
   </tr>
   </table>
</form>
</body>
</html>