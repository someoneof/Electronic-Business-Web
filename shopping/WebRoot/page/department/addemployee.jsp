<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/page/share/taglib.jsp" %>
<html>
<head>
<title>添加员工</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="/shopping/css/vip.css" type="text/css">
<SCRIPT language=JavaScript src="/shopping/js/FoshanRen.js"></SCRIPT>
<SCRIPT language=JavaScript src="/shopping/js/xmlhttp.js"></SCRIPT>
<script language="JavaScript">
function validateUsernameExsit(username){
	if(username.trim()!=""){
		var usernameview = document.getElementById('usernameview');		
		if(usernameview){
			send_request(function(value){usernameview.innerHTML=value},
					 '<s:url action="employeeManagerAction_exist" />?username='+ username, true);
		}
	}
}

function Formfield(name, label){
	this.name=name;
	this.label=label;
}
function checkfm(form){
	var list  = new Array(new Formfield("username", "登录账号"),new Formfield("password", "登录密码"),
	new Formfield("realname", "员工姓名"),new Formfield("cardno", "身份证号码")
	,new Formfield("birthday", "身份证出生日期"),new Formfield("address", "身份证地址"),new Formfield("phone", "联系电话"));
	for(var i=0;i<list.length;i++){
		var objfield = eval("form."+ list[i].name);
		if(trim(objfield.value)==""){
			alert(list[i].label+ "不能为空");
			if(objfield.type!="hidden" && objfield.focus()) objfield.focus();
			return false;
		}
	}
	if(form.username.value.length<6){
		alert("登录账号的长度应大于或等于6位");
		return false;
	}
	if(form.password.value.length<6){
		alert("密码的长度应大于或等于6位");
		return false;
	}
	if(form.password.value!=form.password2.value){
		alert("您两次输入的密码不一致");
		return false;
	}
	if(form.cardno.value.length!=15 && form.cardno.value.length!=18){
		alert("身份证号码的长度应该是15位或者18位");
		return false;
	}

	var picture = form.picture.value;
	if(trim(picture)!=""){
		var ext = picture.substring(picture.length-3).toLowerCase();
		if (ext!="jpg" && ext!="gif" && ext!="bmp" && ext!="png"){
			alert("只允许上传gif、jpg、bmp、png！");
			return false; 
		}
	}
	return true;
}
</script>
</head>
<body bgcolor="#FFFFFF" text="#000000" leftmargin="0" topmargin="0" marginwidth="0" marginheight="0">
<s:form action="employeeAction_add" namespace="/control" method="post" enctype="multipart/form-data" onsubmit="return checkfm(this)">
<input type="hidden" name="method" value="regEmployee">
  <table width="90%" border="0" cellspacing="2" cellpadding="3" align="center">
    <tr bgcolor="6f8ac4"><td colspan="2"  > <font color="#FFFFFF">添加员工：</font></td>
    </tr>
    <tr bgcolor="f5f5f5"> 
      <td width="22%" > <div align="right">登录账号：</div></td>
      <td width="78%"> <input type="text" name="logoname" size="32" maxlength="32" onblur="javascript:validateUsernameExsit(this.value)"/>(账号的长度应大于或等于6,不能用中文)<font color="#FF0000">*</font>
       <div id="usernameview"></div></td>
    </tr>
    <tr bgcolor="f5f5f5"> 
      <td width="22%" > <div align="right">登录密码：</div></td>
      <td width="78%"> <input type="text" name="password" size="32" maxlength="32"/>(密码的长度应大于或等于6,不能用中文)
        <font color="#FF0000">*</font></td>
    </tr>
    <tr bgcolor="f5f5f5"> 
      <td width="22%" > <div align="right">再次输入登录密码：</div></td>
      <td width="78%"> <input type="password" name="password2" size="32" maxlength="32"/>
        <font color="#FF0000">*</font></td>
    </tr>
    <tr bgcolor="f5f5f5"> 
      <td width="22%" > <div align="right">员工姓名：</div></td>
      <td width="78%"> <input type="text" name="realname" size="10" maxlength="10"/>
        <font color="#FF0000">*</font></td>
    </tr>
    <tr bgcolor="f5f5f5"> 
      <td width="22%" > <div align="right">性别：</div></td>
      <td width="78%"> <input type="radio" name="sex" value="MAN">男</html:radio>
      <input type="radio" name="sex" value="WOMEN">女</html:radio></td>
    </tr> 
	<tr bgcolor="f5f5f5"> 
      <td width="22%" > <div align="right">员工照片：</div></td>
      <td width="78%"> <s:file  name="imagefile" size="50"/>
      </td>
    </tr>
    <tr bgcolor="f5f5f5"> 
      <td width="22%" > <div align="right">身份证号码：</div></td>
      <td width="78%"> <input type="text" name="idNo" size="20" maxlength="18"/>
        <font color="#FF0000">*</font></td>
    </tr>
    <tr bgcolor="f5f5f5"> 
      <td width="22%" > <div align="right">身份证出生日期：</div></td>
      <td width="78%"> <input type="text" name="birthday" size="20" maxlength="18"/>
        <font color="#FF0000">*</font></td>
    </tr>
    <tr bgcolor="f5f5f5"> 
      <td width="22%" > <div align="right">身份证地址：</div></td>
      <td width="78%"> <input type="text" name="address" size="60" maxlength="100"/>
        <font color="#FF0000">*</font></td>
    </tr>  
    <tr bgcolor="f5f5f5"> 
      <td width="22%" > <div align="right">联系电话：</div></td>
      <td width="78%"> <input type="text" name="phone" size="20" maxlength="18"/><font color="#FF0000">*</font></td>
    </tr> 
    <tr bgcolor="f5f5f5"> 
      <td width="22%" > <div align="right">电子邮件：</div></td>
      <td width="78%"> <input type="text" name="email" size="20" maxlength="18"/></td>
    </tr> 
    <tr bgcolor="f5f5f5"> 
      <td width="22%" > <div align="right">学历：</div></td>
      <td width="78%"> <input type="text" name="degree" size="10" maxlength="5"/></td>
    </tr>
     <tr bgcolor="f5f5f5"> 
      <td width="22%" > <div align="right">毕业院校：</div></td>
      <td width="78%"> <input type="text" name="school" size="20" maxlength="20"/></td>
    </tr>
		<tr bgcolor="f5f5f5">
			<td width="25%"><div align="right">所在部门 ：</div></td>
			<td width="75%"><select name="did">
					<c:forEach items="${requestScope.departmentList}" var="department">
						<option value="${department.did}">${department.name}</option>
					</c:forEach>
			</select>
			</td>
		</tr>
	<tr bgcolor="f5f5f5">
		<td width="22%"><div align="right">选择权限组：</div></td>
		<td width="78%">
		<select name="groupid">
				<c:forEach items="${requestScope.privilegegroups}" var="group">
					<option value="${group.groupid}">${group.name}</option>
				</c:forEach>
		</select></td>
	</tr>
    <tr bgcolor="f5f5f5"> 
      <td colspan="2"> <div align="center"> 
          <input type="submit" name="SYS_SET" value=" 确 定 " class="frm_btn">
        </div></td>
    </tr>
  </table>
</s:form>
<br>
</body>
</html>