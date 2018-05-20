<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<TITLE>添加客户</TITLE> 
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<LINK href="${pageContext.request.contextPath }/css/Style.css" type=text/css rel=stylesheet>
<LINK href="${pageContext.request.contextPath }/css/Manage.css" type=text/css
	rel=stylesheet>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-1.11.3.min.js"></script>
<script type="text/javascript">
	// 页面的加载
	$(function(){
		// 发送ajax的请求
		alert("加载完成");
		var url = "${ pageContext.request.contextPath }/school_getSchoolNames.action";
		var param = {"schoolName":"计算机学院"};
		$.post(url,param,function(data){
			// 遍历
			$(data).each(function(i,n){
				//alert(n);
				//=============为了保持用户选择
				//从值栈中获取当前值
				var vsSchoolId = "${model.schoolName}";
				//如果相同，则保持
				if (vsSchoolId == n){
					$("#schoolName").append("<option value='"+n+"' selected>"+n+"</option>");
				}else{
					$("#schoolName").append("<option value='"+n+"'>"+n+"</option>");
				}
			});
		},"json");
	});
	
	$(document).ready(
	function(){
		var schoolName = $("#schoolName").val();
		alert("加载完成....为什么我不被执行"+schoolName+"空的");
		if (schooleName == "" || schoolName.trim() == ""){
		alert("我空了....为什么我不被执行"+schoolName);
			$("#teacherInfo").empty().append('<option value="" >- 请先选择学院 -</option>');
		}else{
		alert("我都非空了....为什么我不被执行"+schoolName);
			var url = "${ pageContext.request.contextPath }/teacher_getTeacherBySchool.action";
			var param = {"schoolName":schoolName};
			//alert("feikong "+schoolType);
			$("#teacherInfo").empty().append('<option value="" >- 请选择 -</option>');
			$.post(url,param,function(data){
				$(data).each(function(i,n){
						alert(n);
						$("#teacherInfo").append("<option value='"+n.teacherId+"'>"+n.teacherName+"("+n.teacherId+")"+"</option>");
				});
			},"json");
		}
	}
	);
</script>

<META content="MSHTML 6.00.2900.3492" name=GENERATOR>
</HEAD>
<BODY>
	<FORM id=form1 name=form1
		action="${pageContext.request.contextPath }/course_update.action"
		method=post>
		<input type="hidden" name="UID" value="${model.UID }"/>

		<TABLE cellSpacing=0 cellPadding=0 width="98%" border=0>
			<TBODY>
				<TR>
					<TD width=15><IMG src="${pageContext.request.contextPath }/images/new_019.jpg"
						border=0></TD>
					<TD width="100%" background=${pageContext.request.contextPath }/images/new_020.jpg
						height=20></TD>
					<TD width=15><IMG src="${pageContext.request.contextPath }/images/new_021.jpg"
						border=0></TD>
				</TR>
			</TBODY>
		</TABLE>
		<TABLE cellSpacing=0 cellPadding=0 width="98%" border=0>
			<TBODY>
				<TR>
					<TD width=15 background=${pageContext.request.contextPath }/images/new_022.jpg><IMG
						src="${pageContext.request.contextPath }/images/new_022.jpg" border=0></TD>
					<TD vAlign=top width="100%" bgColor=#ffffff>
						<TABLE cellSpacing=0 cellPadding=5 width="100%" border=0>
							<TR>
								<TD class=manageHead>当前位置：课程管理 &gt; 修改课程</TD>
							</TR>
							<TR>
								<TD height=2></TD>
							</TR>
						</TABLE>
						<TABLE cellSpacing=0 cellPadding=5  border=0>
							<TR>
								<td>学院名称：</td>
								<td>
									<select style="WIDTH: 100px" maxLength=80 name="schoolName" id="schoolName">
											<option value="">--请选择--</option>
									</select>
								</td>
								<td>授课教师 ：</td>
								<td>
									<select style="WIDTH: 100px" maxLength=80 name="teacherId" id="teacherInfo">
											<option value="${model.teacherId }">${model.teacherId }</option>
									</select>
								</td>
							</TR>
							
							<TR>
								<td>课程名称：</td>
								<td>
								<INPUT class=textbox id=sChannel2 readonly="readonly"
														style="WIDTH: 180px" maxLength=50 name="courseName" value="${model.courseName }">

								</td>
								<td>课程ID：</td>
								<td>
								<INPUT class=textbox id=sChannel2 readonly="readonly"
														style="WIDTH: 180px" maxLength=50 name="courseId" value="${model.courseId }">

								</td>
							</TR>
							<TR>
	
								<td>学分 ：</td>
								<td>
									<select style="WIDTH: 100px" maxLength=80 name="credit" id="credit">
											<option value="${model.credit }">${model.credit }</option>
									</select>
								</td>
								<td>操作人：</td>
								<td>
								<INPUT class=textbox id=sChannel2 
														style="WIDTH: 180px" maxLength=50 name="managerName" value="${model.managerName }">

								</td>
							</TR>
							<tr>
								<td rowspan=2>
								<INPUT class=button id=sButton2 type=submit
														value=" 保存 " name=sButton2>
								</td>
							</tr>
						</TABLE>
						
						
					</TD>
					<TD width=15 background="${pageContext.request.contextPath }/images/new_023.jpg">
					<IMG src="${pageContext.request.contextPath }/images/new_023.jpg" border=0></TD>
				</TR>
			</TBODY>
		</TABLE>
		<TABLE cellSpacing=0 cellPadding=0 width="98%" border=0>
			<TBODY>
				<TR>
					<TD width=15><IMG src="${pageContext.request.contextPath }/images/new_024.jpg"
						border=0></TD>
					<TD align=middle width="100%"
						background="${pageContext.request.contextPath }/images/new_025.jpg" height=15></TD>
					<TD width=15><IMG src="${pageContext.request.contextPath }/images/new_026.jpg"
						border=0></TD>
				</TR>
			</TBODY>
		</TABLE>
	</FORM>
</BODY>
</HTML>
