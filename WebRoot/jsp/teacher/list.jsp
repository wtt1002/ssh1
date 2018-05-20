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
		
		
		
	});
	
	
	$(document).ready(function(){
		//绑定学院下拉框变化事件
		$("#selectSchoolId").on("change",
			function(){
				var schoolType = $(this).val();
				$("#selectYearId").val("").trigger("change");
				 
				if (schoolType = ""){
					 $("#selectYearId").empty().append('<option value="" >- 请选择 -</option>');
					 return;
				}
				
			})
	})
	
	
	//显示下拉菜单  显示所属这个流程的节点  
    //初始化  
    $(document).ready(function() {     
        $.ajax({    
            url: "showNodesByFlowNameOption",//调用方法    
            type: "GET",    
            data: {flowid:$("#flowid").val()},//参数    
            dataType: "json",//类型    
    
            success: function(data) {    
              var tbHtml = "";//定义HTML    
              tbHtml += "<option></option>";    
              $.each(data, function(key, value) {//循环    
                  tbHtml+="<option value="+value.nid+">"+value.label+"</option>"//显示查询出来的结果内容    
              });    
                  
              $('#endid').html(tbHtml);//显示HTML    
          }    
              
           });  
     });    
    
</SCRIPT>

<META content="MSHTML 6.00.2900.3492" name=GENERATOR>
</HEAD>
<BODY>
	<FORM id="customerForm" name="customerForm"
		action="${pageContext.request.contextPath }/teacher_list.action"
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
								<TD class=manageHead>当前位置：教师管理 &gt; 教师维护</TD>
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
										<TABLE cellSpacing=0 cellPadding=2 border=0>
											<TBODY>
												<TR>
													<TD>所属院系：</TD>
													<TD>
														<select style="WIDTH: 100px" maxLength=80 name="schoolName" id="selectSchoolId">
															<option value="">- 请选择 -</option>
														</select>
													</TD>
													<TD>入校年份：</TD>
													<TD>
														<select style="WIDTH: 80px" maxLength=50 name="rollYear" id="selectYearId">
															<option value="">- 请选择 -</option>
															<option value="2013">  2013  </option>
															<option value="2014">  2014  </option>
															<option value="2015">  2015  </option>
															<option value="2016">  2016  </option>
															<option value="2017">  2017  </option>
														</select>
													</TD>
													<TD>教师姓名：</TD>
													<TD><INPUT class=textbox id=sChannel2
														style="WIDTH: 80px" maxLength=50 name="teacherName" value="${model.teacherName}"></TD>
													<TD>性别：</TD>
													<TD>
														<select style="WIDTH: 80px" maxLength=50 name="gender" id="gender">
															<option value="">- 请选择 -</option>
															<option value="男">  男    </option>
															<option value="女">  女    </option>
														</select></TD>
													<TD>教师号：</TD>
													<TD><INPUT class=textbox id=sChannel2
														style="WIDTH: 80px" maxLength=50 name="teacherId" value="${model.teacherId}"></TD>
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
													<TD>入学年份</TD>
													<TD>教师号</TD>
													<TD>教师姓名</TD>
													<TD>教师性别</TD>
													<TD>操作人</TD>
													<TD>操作</TD>
												</TR>
												<c:forEach items="${page.beanList }" var="teacher">
												<TR
													style="FONT-WEIGHT: normal; FONT-STYLE: normal; BACKGROUND-COLOR: white; TEXT-DECORATION: none">
													<TD>${teacher.schoolName }</TD>
													<TD>${teacher.rollYear }</TD>
													<TD>${teacher.teacherId }</TD>
													<TD>${teacher.teacherName }</TD>
													<TD>${teacher.gender }</TD>
													<TD>${teacher.managerName }</TD>
													<TD>
													<a href="${pageContext.request.contextPath }/teacher_initUpdate?teacherId=${teacher.teacherId}">修改</a>
													&nbsp;&nbsp;
													<a href="${pageContext.request.contextPath }/teacher_delete?teacherId=${teacher.teacherId}" onclick="return window.confirm('确定删除吗？')">删除</a>
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
