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
<script type="text/javascript" charset="utf-8" src="${pageContext.request.contextPath }/js/ueditor.config.js"></script>
<script type="text/javascript" charset="utf-8" src="${pageContext.request.contextPath }/js/ueditor.all.min.js"> </script>
    <!--建议手动加在语言，避免在ie下有时因为加载语言失败导致编辑器加载失败-->
    <!--这里加载的语言文件会覆盖你在配置项目里添加的语言类型，比如你在配置项目里配置的是英文，这里加载的中文，那最后就是中文-->
<script type="text/javascript" charset="utf-8" src="${pageContext.request.contextPath }/lang/zh-cn/zh-cn.js"></script>

<style type="text/css">
        div{
            width:100%;
        }
</style>
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
		action="${pageContext.request.contextPath }/homework_add.action"
		method=post> 
		<input type="hidden" name="teacherId" value="${existTeacher.teacherId }"/>
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
								<TD class=manageHead>当前位置：发布作业 &gt; 布置作业</TD>
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
									<label>作业标题：</label>
											<INPUT class=textbox id="homeworkName" style="WIDTH: 180px" maxLength=50 name="homeworkName">
									<label>截止时间：</label>
											<INPUT class=textbox id="deadlineDate" style="WIDTH: 180px" maxLength=50 name="deadlineDate">
						  			<label>上传附件：</label>
											<INPUT type="file" name="myfile">
									<INPUT class=button id=sButton2 type=submit
														value=" 保存 " name=sButton2>
									</TD>
								</TR>
								<tr>
									<td>
										<label>作业要求：</label>
									</td>
								</tr>

			</TBODY>
		</TABLE>
		<table>
			<div>
   					<script id="editor" type="text/plain" style="width:1024px;height:500px;"></script>
			</div>
		</table>
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
	
	<script type="text/javascript">

    //实例化编辑器
    //建议使用工厂方法getEditor创建和引用编辑器实例，如果在某个闭包下引用该编辑器，直接调用UE.getEditor('editor')就能拿到相关的实例
    var ue = UE.getEditor('editor');
    function isFocus(e){
        alert(UE.getEditor('editor').isFocus());
        UE.dom.domUtils.preventDefault(e)
    }
    function setblur(e){
        UE.getEditor('editor').blur();
        UE.dom.domUtils.preventDefault(e)
    }
    function insertHtml() {
        var value = prompt('插入html代码', '');
        UE.getEditor('editor').execCommand('insertHtml', value)
    }
    function createEditor() {
        enableBtn();
        UE.getEditor('editor');
    }
    function getAllHtml() {
        alert(UE.getEditor('editor').getAllHtml())
    }
    function getContent() {
        var arr = [];
        arr.push("使用editor.getContent()方法可以获得编辑器的内容");
        arr.push("内容为：");
        arr.push(UE.getEditor('editor').getContent());
        alert(arr.join("\n"));
    }
    function getPlainTxt() {
        var arr = [];
        arr.push("使用editor.getPlainTxt()方法可以获得编辑器的带格式的纯文本内容");
        arr.push("内容为：");
        arr.push(UE.getEditor('editor').getPlainTxt());
        alert(arr.join('\n'))
    }
    function setContent(isAppendTo) {
        var arr = [];
        arr.push("使用editor.setContent('欢迎使用ueditor')方法可以设置编辑器的内容");
        UE.getEditor('editor').setContent('欢迎使用ueditor', isAppendTo);
        alert(arr.join("\n"));
    }
    function setDisabled() {
        UE.getEditor('editor').setDisabled('fullscreen');
        disableBtn("enable");
    }

    function setEnabled() {
        UE.getEditor('editor').setEnabled();
        enableBtn();
    }

    function getText() {
        //当你点击按钮时编辑区域已经失去了焦点，如果直接用getText将不会得到内容，所以要在选回来，然后取得内容
        var range = UE.getEditor('editor').selection.getRange();
        range.select();
        var txt = UE.getEditor('editor').selection.getText();
        alert(txt)
    }

    function getContentTxt() {
        var arr = [];
        arr.push("使用editor.getContentTxt()方法可以获得编辑器的纯文本内容");
        arr.push("编辑器的纯文本内容为：");
        arr.push(UE.getEditor('editor').getContentTxt());
        alert(arr.join("\n"));
    }
    function hasContent() {
        var arr = [];
        arr.push("使用editor.hasContents()方法判断编辑器里是否有内容");
        arr.push("判断结果为：");
        arr.push(UE.getEditor('editor').hasContents());
        alert(arr.join("\n"));
    }
    function setFocus() {
        UE.getEditor('editor').focus();
    }
    function deleteEditor() {
        disableBtn();
        UE.getEditor('editor').destroy();
    }
    function disableBtn(str) {
        var div = document.getElementById('btns');
        var btns = UE.dom.domUtils.getElementsByTagName(div, "button");
        for (var i = 0, btn; btn = btns[i++];) {
            if (btn.id == str) {
                UE.dom.domUtils.removeAttributes(btn, ["disabled"]);
            } else {
                btn.setAttribute("disabled", "true");
            }
        }
    }
    function enableBtn() {
        var div = document.getElementById('btns');
        var btns = UE.dom.domUtils.getElementsByTagName(div, "button");
        for (var i = 0, btn; btn = btns[i++];) {
            UE.dom.domUtils.removeAttributes(btn, ["disabled"]);
        }
    }

    function getLocalData () {
        alert(UE.getEditor('editor').execCommand( "getlocaldata" ));
    }

    function clearLocalData () {
        UE.getEditor('editor').execCommand( "clearlocaldata" );
        alert("已清空草稿箱")
    }
</script>
</BODY>
</HTML>
