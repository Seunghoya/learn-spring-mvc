<%@ page import="learnspringmvc.servlet.domain.member.MemberRepository" %>
<%@ page import="learnspringmvc.servlet.domain.member.Member" %>
<%--자바의 import와 같다.--%>
<%--
  Created by IntelliJ IDEA.
  User: NTL
  Date: 2022-08-08
  Time: 오후 4:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%--자바코드는 <% ~~ %>로 입력--%>
<%--자바코드는 <%= ~~ %>로 출력--%>
<%
  MemberRepository memberRepository = MemberRepository.getInstance();

  System.out.println("JspClass.jsp_service_method");
  String username = request.getParameter("username");
  int age = Integer.parseInt(request.getParameter("age"));

  Member member = new Member(username, age);
  memberRepository.save(member);
%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<ul>
  <li>id=<%=member.getId()%></li>
  <li>id=<%=member.getUsername()%></li>
  <li>id=<%=member.getAge()%></li>
</ul>
<a href="/index.html">메인</a>
</body>
</html>
