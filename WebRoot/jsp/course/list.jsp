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
					$("#selectSchoolId").append("<option value='"+n+"' selected>"+n+"</option>");
				}else{
					$("#selectSchoolId").append("<option value='"+n+"'>"+n+"</option>");
				}
			});
		},"json");

	var formCus = document.getElementById("customerForm")
	var usertype = "${userType}";
		if(usertype == "manager"){
			formCus.action = "${pageContext.request.contextPath }/course_list.action?managerId=${existManager.managerId}";
		}
		if(usertype == "teacher"){
			formCus.action = "${pageContext.request.contextPath }/course_listByTeacher.action?teacherId=${existTeacher.teacherId}";
			console.log(page);
		}
		if(usertype == "student"){
			formCus.action = "${pageContext.request.contextPath }/course_listByStudent.action?studentId=${existStudent.studentId}";
		}
	});

</SCRIPT>

<META content="MSHTML 6.00.2900.3492" name=GENERATOR>
</HEAD>
<BODY>
	<FORM id="customerForm" name="customerForm"
		action="#"
		method=post>
		
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
								<TD class=manageHead>当前位置：课程管理 &gt; 课程维护</TD>
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
										<TABLE class="changeByRole" cellSpacing=0 cellPadding=2 border=0>
											<TBODY>
												<TR>
													<TD>所属院系：</TD>
													<TD>
														<select style="WIDTH: 100px" maxLength=80 name="schoolName" id="selectSchoolId">
															<option value="">--请选择--</option>
														</select>
													</TD>
													<TD>课程名称：</TD>
													<TD>
														<INPUT class=textbox id=sChannel2
														style="WIDTH: 80px" maxLength=50 name="courseName" value="${model.courseName}">

													<TD><INPUT class=button id=sButton2 type=submit
														value=" 筛选 " name=sButton2></TD>
												</TR>
											</TBODY>
										</TABLE>
									</TD>
								</TR>
							    
								<TR>
									<TD>
										<TABLE id=grid
											style="BORDER-TOP-WIDTH: 0px; FONT-WEIGHT: normal; BORDER-LEFT-WIDTH: 0px; BORDER-LEFT-COLOR: #cccccc; BORDER-BOTTOM-WIDTH: 0px; BORDER-BOTTOM-COLOR: #cccccc; WIDTH: 100%; BORDER-TOP-COLOR: #cccccc; FONT-STYLE: normal; BACKGROUND-COLOR: #cccccc; BORDER-RIGHT-WIDTH: 0px; TEXT-DECORATION: none; BORDER-RIGHT-COLOR: #cccccc"
											cellSpacing=1 cellPadding=2 rules=all border=0>
											<TBODY>
												<TR
													style="FONT-WEIGHT: bold; FONT-STYLE: normal; BACKGROUND-COLOR: #eeeeee; TEXT-DECORATION: none">
													<TD>所属院系</TD>
													<TD>课程名称</TD>
													<TD>课程ID</TD>
													<TD>授课教师</TD>
													<TD>学分</TD>
													<TD>操作人</TD>
													<TD>操作</TD>
												</TR>
												<c:forEach items="${page.beanList }" var="course">
												<TR
													style="FONT-WEIGHT: normal; FONT-STYLE: normal; BACKGROUND-COLOR: white; TEXT-DECORATION: none">
													<TD>${course.schoolName }</TD>
													<TD>${course.courseName }</TD>
													<TD>${course.courseId }</TD>
													<TD>${course.teacherId }</TD>
													<TD>${course.credit }</TD>
													<TD>${course.managerName }</TD>
													<TD>
													<a href="${pageContext.request.contextPath }/course_initUpdate?courseId=${course.courseId}">修改</a>
													&nbsp;&nbsp;
													<a class="changeByRole" href="${pageContext.request.contextPath }/course_delete?courseId=${course.courseId}" onclick="return window.confirm('确定删除吗？')">删除</a>
													</TD>
												</TR>
												
												</c:forEach>

											</TBODY>
										</TABLE>
									</TD>
								</TR>
								
								<TR>
									<TD><SPAN id=pagelink>
											<DIV style="LINE-HEIGHT: 20px; HEIGHT: 20px; TEXT-ALIGN: right">
												共[<B>${page.totalCount}</B>]条记录,[<B>${page.totalPage}</B>]页,每页显示
												<select name="pageSize">
													<option value="5" <c:if test="${pageSize==5 }">selected</c:if>>5</option>
													<option value="10" <c:if test="${pageSize==10 }">selected</c:if>>10</option>
												</select>
												条,
												<c:if test="${ page.pageCode > 1 }">
													[<A href="javascript:to_page(${page.pageCode-1})">前一页</A>]
												</c:if>
												
												<B>${page.pageCode}</B>
												
												<c:if test="${ page.pageCode < page.totalPage }">
													[<A href="javascript:to_page(${page.pageCode+1})">后一页</A>] 
												</c:if>
												
												到
												<input type="text" size="3" id="page" name="pageCode" />
												页
												<input type="button" value="Go" onclick="to_page()"/>
											</DIV>
									</SPAN></TD>
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
