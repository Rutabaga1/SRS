<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>首页</title>
<link rel="stylesheet" type="text/css" href="css/reset.css" >
<link rel="stylesheet" type="text/css" href="css/style.css" >
<link rel="stylesheet" type="text/css" href="css/superfish.css" >

<script type="text/javascript" src="js/jquery-1.11.3.js"></script>
</head>

<body>

 <div id="top-line"></div>
 
 
 <div id="menu-bar">
	<div class="center-block clearfix">
	  
    	
		<div id="menu" class="fix-fish-menu">
			<div class="white-fix-left"></div>
			<ul id="nav" class="sf-menu">

			 		<li > <a href="index.jsp">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;首页&nbsp;&nbsp;&nbsp;&nbsp;</a>

			    </li>
		 		<li class=""> <a href="enrollCourse.jsp">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;选课&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</a>

				    </li>
			 	<li class=""> <a href="Transcript.jsp">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;成绩查询&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</a>

				</li>
		 		<li class=""> <a href="course.jsp">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;所有课程&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</a>

			    </li>
                <li class=""><a href="teachers.jsp" class="active">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;所有教师&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</a>
               		 
	            </li>

	            <li class=""><a href="studentChoose.jsp">&nbsp;&nbsp;&nbsp;已选学生&nbsp;&nbsp;&nbsp;</a>
	   				
	            </li>
	            
	            <li class=""><a href="SignOut">&nbsp;&nbsp;&nbsp;退出&nbsp;&nbsp;&nbsp;</a>
	   				
	            </li>

		 	</ul>  
	 	</div>	
	</div>
</div>
<!-- END MENU SECTION -->
 

<!-- START WRAPPER SECTION -->
<div id="wrapper">

	<div id="separator">
		<div class="center-block">
			<h3>${sessionScope.userName }</h3>
			<span>: ${sessionScope.ssn }</span>
		</div>
	</div>

	<!-- START CONTENT -->
	<div class="center-block-page clearfix">
	<p>教师</p>
		<table>
			<tr><td colspan="3">添加教师</td></tr>
			<tr height="200px">
		   				<td >教师编号：<input type="text" name="addNo" ></td>
		   				 <td >教师名称：<input type="text" name="addName" ></td> 
		   				<td >教师部门：<input type="text" name="addDepartment" ></td>
		   		</tr>
		   		
		</table>
	  	<table>
	  		<tr><td colspan="4">修改教师</td></tr>
	  		<c:forEach var="oneResult" items="${requestScope.result }">
		   			
		   			<tr height="200px">
		   				<td><input type="checkbox" name="change" value='${oneResult.ssn}'></td>
		   				<td ><input type="text" name="changeNo" value='${oneResult.ssn}'></td>
		   				 <td ><input type="text" name="changeName" value='${oneResult.name}'></td> 
		   				<td ><input type="text" name="changeDepartment" value='${oneResult.department}'></td>
		   			</tr>
		   		</c:forEach>
		   </table>
		   
		   <table>
	  		<tr><td colspan="4">删除教师</td></tr>
	  		<c:forEach var="oneResult" items="${requestScope.result }">
		   			
		   			<tr height="200px">
		   				<td><input type="checkbox" name="delete" value='${oneResult.ssn}'></td>
		   				<td >${oneResult.ssn}</td>
		   				 <td >${oneResult.name}</td> 
		   				<td >${oneResult.department}</td>
		   			</tr>
		   		</c:forEach>
		   </table>
	</div>
	
</div><!--   width="120px"  #wrapper -->

<!-- END WRAPPER -->	    

<!-- START FOOTER -->
<div class="divider-100-2px"></div>

<!-- START FOOTER MENU  -->
<div id="footer-menu">
	<div class="center-block clearfix">
		<div class="copyright">&copy; Copyright &copy; Electronic Commerce 2013-2.</div>
	</div><!-- .center-block -->
</div><!-- #footer-menu -->
<!-- END FOOTER MENU  -->

</body>

</html>