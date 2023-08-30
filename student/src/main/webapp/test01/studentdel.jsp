<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import = "java.util.*" isELIgnored="false"%>
<%@ taglib prefix ="fmt" uri ="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix ="c" uri ="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value = "${pageContext.request.contextPath}" />
<%
request.setCharacterEncoding("UTF-8");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
 .cls1 {
      font-size:40px;
      text-align:center;
 }
</style>
</head>
<body>
<h1 class ="cls1">회원 정보 수정창</h1>
<form method ="post" action ="${contextPath}/member152/modMember.do?id=${memInfo.username}">
<table align ="center">
  <tr>
    <td width="200"><p align ="right">이름</td>
    <td width="400"><input type ="text" name ="username" value = "${memInfo.username }"disabled > </td>
  </tr>
  <tr>
    <td width="200"><p align ="right">대학</td>
    <td width="400"><input type ="text" name ="univ" value = "${memInfo.univ }"></td>
  </tr>
  <tr>
    <td width="200"><p align ="right">생년월일</td>
    <td width="400"><input type ="text" name ="birth" value = "${memInfo.birth }"></td>
  </tr>
  <tr>
    <td width="200"><p align ="right">이메일</td>
    <td width="400"><input type ="email" name ="email" value = "${memInfo.email }"></td>
  </tr>
  <tr>
    <td width="200"><p>&nbsp;</p></td>
    <td colspan="2" width="400"><input type ="submit" value="수정하기">
    <input type ="reset" value="다시입력">
    </td>
  </tr>
</table>
</form>
</body>
</html>