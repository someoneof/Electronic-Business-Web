<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/page/share/taglib.jsp" %>
<html>
<head>
<title>修改员工信息</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="/css/vip.css" type="text/css">
<SCRIPT language=JavaScript src="/js/FoshanRen.js"></SCRIPT>
<SCRIPT language=JavaScript src="/js/xmlhttp.js"></SCRIPT>
<script language="JavaScript">
function Formfield(name, label){
	this.name=name;
	this.label=label;
}
function checkfm(form){
	var list  = new Array(new Formfield("realname", "员工姓名"),new Formfield("idNo", "身份证号码")
	,new Formfield("birthday", "身份证出生日期"),new Formfield("address", "身份证地址"),new Formfield("phone", "联系电话"));
	for(var i=0;i<list.length;i++){
		var objfield = eval("form."+ list[i].name);
		if(trim(objfield.value)==""){
			alert(list[i].label+ "不能为空");
			if(objfield.type!="hidden" && objfield.focus()) objfield.focus();
			return false;
		}
	}
	if(form.idNo.value.length!=15 && form.idNo.value.length!=18){
		alert("身份证号码的长度应该是15位或者18位");
		return false;
	}
	
	var picture = form.imagefile.value;
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
<s:form action="employeeAction_edit" namespace="/control" method="post" enctype="multipart/form-data" onsubmit="return checkfm(this)">
<s:hidden name="eid" />
<s:hidden name="method" value="edit"/>
<s:hidden name="groupid"/>
  <table width="90%" border="0" cellspacing="2" cellpadding="3" align="center">
    <tr bgcolor="6f8ac4"><td colspan="2"  > <font color="#FFFFFF">修改员工信息：</font></td>
    </tr>
    <tr bgcolor="f5f5f5"> 
      <td width="22%" > <div align="right">员工姓名：</div></td>
      <td><input type="text" name="realname"  value="${realname}" size="10" maxlength="10"/>
        <font color="#FF0000">*</font></td>
    </tr>
    <tr bgcolor="f5f5f5"> 
      <td width="22%" > <div align="right">性别：</div></td>
      <td><input <c:if test="${sex=='MAN'}">checked</c:if> type="radio" name="sex" value="MAN"/>男
      <input <c:if test="${sex=='WOMAN'}">checked</c:if> type="radio" name="sex" value="WOMAN"/>女
      </td>
    </tr> 
	<tr bgcolor="f5f5f5"> 
      <td width="22%" > <div align="right">员工照片：</div></td>
      <td width="78%"> <input type="file" name="imagefile" size="50" />
     <c:if test="${!empty photopath}"><img src="${photopath}" border="0" height="50" width="50"></c:if> </td>
    </tr>
    <tr bgcolor="f5f5f5"> 
      <td width="22%" > <div align="right">身份证号码：</div></td>
      <td width="78%"> <input type="text" name="idNo"  value="${idNo }" size="20" maxlength="18"/>
        <font color="#FF0000">*</font></td>
    </tr>
    <tr bgcolor="f5f5f5"> 
      <td width="22%" > <div align="right">身份证出生日期：</div></td>
      <td width="78%"> <input type="text" name="birthday" value="${birthday }"   size="20" maxlength="18"/>
        <font color="#FF0000">*</font></td>
    </tr>
    <tr bgcolor="f5f5f5"> 
      <td width="22%" > <div align="right">身份证地址：</div></td>
      <td width="78%"> <input type="text" name="address" value="${address }"  size="60" maxlength="100"/>
        <font color="#FF0000">*</font></td>
    </tr>  
    <tr bgcolor="f5f5f5"> 
      <td width="22%" > <div align="right">联系电话：</div></td>
      <td width="78%"> <input type="text" name="phone" value="${phone }"  size="20" maxlength="18"/><font color="#FF0000">*</font></td>
    </tr> 
    <tr bgcolor="f5f5f5"> 
      <td width="22%" > <div align="right">电子邮件：</div></td>
      <td width="78%"> <input type="text" name="email" value="${email }" size="20" maxlength="18"/></td>
    </tr> 
    <tr bgcolor="f5f5f5"> 
      <td width="22%" > <div align="right">学历：</div></td>
      <td width="78%"> <input type="text" name="degree" value="${degree }" size="10" maxlength="5"/></td>
    </tr>
     <tr bgcolor="f5f5f5"> 
      <td width="22%" > <div align="right">毕业院校：</div></td>
      <td width="78%"> <input type="text" name="school" value="${school }" size="20" maxlength="20"/></td>
    </tr>
    <tr bgcolor="f5f5f5"> 
      <td width="22%" > <div align="right">所在部门：</div></td>
      <td><!-- 每四个部门,用<br>进行分行 --> 
      <c:forEach items="${departments}" var="department" varStatus="statu">
			<input <c:if test="${selectdepartmentid==department.did}">checked</c:if>
			type="radio" name="did" value="${department.did}">${department.name}	
      	<c:if test="${statu.count%4==0}"><br>
				</c:if>
			</c:forEach>
		</td>
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