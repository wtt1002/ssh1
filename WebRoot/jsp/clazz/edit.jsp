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
		//alert("加载完成");
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
	
		$(document).ready(function(){
		//绑定学院下拉框变化事件
		$("#schoolName").on("change",
			function(){
				var schoolType = $(this).val();
				$("#rollYear").val("").trigger("change");
				 //alert("有变动"+schoolType);
				if (schoolType == ""){
					 $("#rollYear").empty().append('<option value="" >- 请选择 -</option>');
					 return;
				}else{
					var url = "${ pageContext.request.contextPath }/clazz_getYearBySchool.action";
					var param = {"schoolName":schoolType};
					//alert("feikong "+schoolType);
					$("#rollYear").empty().append('<option value="" >- 请选择 -</option>');
					$.post(url,param,function(data){
						$(data).each(function(i,n){
							$("#rollYear").append("<option value='"+n+"'>"+n+"</option>");
						})
					},"json")
				}
			})
	})


</script>

<META content="MSHTML 6.00.2900.3492" name=GENERATOR>
</HEAD>
<BODY>
	<FORM id=form1 name=form1
		action="${pageContext.request.contextPath }/clazz_update.action"
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
								<TD class=manageHead>当前位置：班级管理 &gt; 修改班级</TD>
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
								<td>入学年份 ：</td>
								<td>
									<select style="WIDTH: 100px" maxLength=80 name="rollYear" id="rollYear">
											<option value="${model.rollYear }">${model.rollYear }</option>
									</select>
								</td>
							</TR>
							
							<TR>
								<td>班级序号：</td>
								<td>
								<INPUT class=textbox id=sChannel2
														style="WIDTH: 180px" maxLength=50 name="clazzNum" value="${model.clazzNum }">
								</td>
								<td>班级代号：</td>
								<td>
								<INPUT class=textbox id=sChannel2 readonly="readonly"
														style="WIDTH: 180px" maxLength=50 name="clazzId" value="${model.clazzId }">

								</td>
							</TR>
							<TR>
								
								
								<td>班级名称 ：</td>
								<td>
								<INPUT class=textbox id=sChannel2
														style="WIDTH: 180px" maxLength=50 name="clazzName" value="${model.clazzName }">
								</td>
								<td>操作人 ：</td>
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
