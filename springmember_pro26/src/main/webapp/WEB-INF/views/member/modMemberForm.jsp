<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
	
	isELIgnored="false"	%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath }" />
<%
request.setCharacterEncoding("utf-8");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form method = "post" action ="${contextPath}/member/modMember.do&id=${memberInfo.id}">
  <h1 class ="text_center">회원정보 수정창</h1>
  <table align="center" >
    <tr>
      <td width="200"><p align="right">아이디</p></td>
      <td width="400"><input type="text" name="id" value ="${memberInfo.id}" disabled></td>
   </tr>
   <tr>
      <td width="200"><p align="right">비밀번호</p></td>
      <td width="400"><input type="password" name="pwd" value ="${memberInfo.pwd}"></td>
   </tr>
   <tr>
      <td width="200"><p align="right">이름</p></td>
      <td width="400"><input type="text" name="name" value ="${memberInfo.name}"></td>
   </tr>
   <tr>
      <td width="200"><p align="right">이메일</p></td>
      <td width="400"><input type="email" name="email" value ="${memberInfo.email}"></td>
   </tr>

   <tr>
   <td width="200"><p align="right">
     <td width="400"><input type="submit" class="btn btn-warning" value="수정하기">
                     <input type="reset" class="btn btn-warning" value="다시입력"></td>
   </tr>
   </table>
</form>
</body>
</html>