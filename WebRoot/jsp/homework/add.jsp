<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<TITLE>客户列表</TITLE> 
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<LINK href="${pageContext.request.contextPath }/css/Style.css" type=text/css rel=stylesheet>
<LINK href="${pageContext.request.contextPath }/css/Manage.css" type=text/css
	rel=stylesheet>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-1.11.3.min.js"></script>
<SCRIPT language=javascript>
	// 提交分页的查询的表单
	function to_page(page){
		if(page){
			$("#page").val(page);
		}
		document.customerForm.submit();
	}
	
	// 页面的加载,获得学院名称
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
	
	$(function(){
		var url = "${ pageContext.request.contextPath }/course_coursesByTeacher.action";
		var teacherid = "${existTeacher.teacherId}"; 
		//alert(teacherid);
		var param = {"teacherId":teacherid};
		$("#courseId").empty().append('<option value="" >- 请选择 -</option>');
		//alert("1234");
		var selectCourse = $(this).val();
		$.post(url,param,function(data){
			$(data).each(function(i,n){
				//alert(n.getCourseId());
				//alert("12222222");
				if (selectCourse == n){
					$("#courseId").append("<option value='"+n.courseId+"' selected>"+n.courseName+"("+n.courseId+")</option>");
				}
				else{
					$("#courseId").append("<option value='"+n.courseId+"'>"+n.courseName+"("+n.courseId+")</option>");
				}
				
			});
		},"json");
		//alert("结束了");
	});
	
	//根据用户类型显示不同的界面
	$(function(){
	     var usertype = "${userType}";
	     //alert("wtttrejgpwiogjwip:"+usertype);
	     if (usertype == "manager"){
	     	var tableT = document.getElementById("design4Teacher");
	     	tableT.style.display="none";
	     	var tableM = document.getElementById("design4Manager");
	     	tableM.style.display="";

	     }
	     if (usertype == "teacher"){
	     	var tableM = document.getElementById("design4Manager");
	     	tableM.style.display="none";
	     	var tableT = document.getElementById("design4Teacher");
	     	tableT.style.display="";
	     	//var formCus = document.getElementById("customerForm")
	     	//var options=$("#courseId  option:selected"); //获取选中的项
			//var courseid = $("#courseId option:selected").val();
			//alert("courseid:"+courseid);
	     	//formCus.action = "${pageContext.request.contextPath }/score_getStudentsByCourse.action?courseId="+courseid;
	     	//var teacherid = "${existTeacher.teacherName}";    	
	     	//getCoursesByTeacher(teacherid);
	     	
	     }
	});
	

	
	//管理员模式
	//school rollyear clazz 联动
		$(document).ready(function(){
		//绑定学院下拉框变化事件
		$("#rollYear").on("change",
			function(){
				var schoolName = $("#schoolName").val();
		        var rollYear = $("#rollYear").val();
				//var schoolType = $(this).val();
				$("#clazzId").val("").trigger("change");
				 //alert("有变动"+schoolName+".."+rollYear);
				if (schoolName == "" || rollYear == ""){
				     //alter("什么鬼");
					 $("#clazzId").empty().append('<option value="" >- 请选择 -</option>');
					 return;
				}else{
					var url = "${ pageContext.request.contextPath }/clazz_getClazzBySchoolAndYear.action";
					var param = {"schoolName":schoolName,"rollYear":rollYear};
					//alert("feikong "+schoolType);
					//$("#clazzId").empty().append('<option value="" >- 请选择 -</option>');
					$.post(url,param,function(data){
					   //alert("datazhi"+data);
						$(data).each(function(i,n){
							$("#clazzId").append("<option value='"+n.clazzId+"'>"+n.clazzName+"</option>");
						})
					},"json")
				}
			})
		
	})
	function changeActionUrl(){
		var form = document.getElementById("customerForm");
		var usertype = "${userType}";
		if(usertype == "teacher"){
			var courseid = $("#courseId option:selected").val();
			form.action = "${pageContext.request.contextPath }/score_getStudentsByCourse.action?courseId="+courseid;
			//document.customerForm.submit();
		}else if(usertype == "manager"){
			form.action = "${pageContext.request.contextPath }/student_list.action";
			//document.customerForm.submit();
		}
	}
	    
    
</SCRIPT>

<META content="MSHTML 6.00.2900.3492" name=GENERATOR>
</HEAD>
<BODY>
	<FORM id="customerForm" name="customerForm"
		action="#"
		method=post onclick="changeActionUrl()"> 
		
		<TABLE cellSpacing=0 cellPadding=0 width="98%" border=0>
			<TBODY>
				<TR>
					<TD width=15><IMG src="${pageContext.request.contextPath }/images/new_019.jpg"
						border=0></TD>
					<TD width="100%" background="${pageContext.request.contextPath }/images/new_020.jpg"
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
								<TD class=manageHead>当前位置：学生管理 &gt; 学生维护</TD>
							</TR>
							<TR>
								<TD height=2></TD>
							</TR>
						</TABLE>
						<TABLE borderColor=#cccccc cellSpacing=0 cellPadding=0
							width="100%" align=center border=0>
							<TBODY>
								<TR>
									<TD height=25>
										
										<TABLE cellSpacing=0 cellPadding=2 border=0 id="design4Teacher">
											<TBODY>
												<TR>
													<TD>选择课程：</TD>
													<TD>
														<select style="WIDTH: 200px" maxLength=150 name="courseId" id="courseId">
															<option value="123">- 请选择 -</option>
														</select>
													</TD>
												</TR>
											</TBODY>
										</TABLE>
									</TD>
								</TR>
							    
								<TR>
									<TD>
										<TABLE cellSpacing=0 cellPadding=5  border=0>
						  
						   <TR>
								<td>作业标题：</td>
								<td>
								<INPUT class=textbox id=sChannel2
														style="WIDTH: 180px" maxLength=50 name="courseName">
								</td>
							</TR>
														<TR>
								<td>截止时间 ：</td>
								<td>
									<INPUT class=textbox id=sChannel2
														style="WIDTH: 180px" maxLength=50 name="courseId">
								</td>

							</TR>	
							<TR>
							<td>上传附件：</td>
							  <td>
								<INPUT type="file" name="myfile">

								</td>

							</TR>
							<TR>
								<td colspan="2">作业说明 ：</td>
								<td>

								</td>

							</TR>	
							<tr>
								<td colspan="2">
							 		<input type="textbox" style="WIDTH: 380px" maxLength=50>
							 	</td>
							</tr>
							<tr>
								<td></td>
								<td rowspan=2>
								<INPUT class=button id=sButton2 type=submit
														value=" 保存 " name=sButton2>
								</td>
							</tr>
						</TABLE>
									</TD>
								</TR>
								
								<TR>
									
								</TR>
							</TBODY>
						</TABLE>
					</TD>
					<TD width=15 background="${pageContext.request.contextPath }/images/new_023.jpg"><IMG
						src="${pageContext.request.contextPath }/images/new_023.jpg" border=0></TD>
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
