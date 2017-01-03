<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/page/share/taglib.jsp" %>
<html>
<head>
<title>修改产品品牌</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="/shopping/css/vip.css" type="text/css">
<SCRIPT language=JavaScript src="/shopping/js/FoshanRen.js"></SCRIPT>
<script language="JavaScript">
function checkfm(form){
	if (trim(form.name.value)==""){
		alert("品牌名称不能为空！");
		form.name.focus();
		return false;
	}
	return true;
}
</script>
</head>
<body bgcolor="#FFFFFF" text="#000000" leftmargin="0" topmargin="0" marginwidth="0" marginheight="0">
<s:form action="brandAction_edit"  namespace="/control" method="post" enctype="multipart/form-data" onsubmit="return checkfm(this)">
<s:hidden name="method" value="edit" />
<s:hidden name="code" />
<s:hidden name="logopath" />
<br>
  <table width="90%" border="0" cellspacing="2" cellpadding="3" align="center">
    <tr bgcolor="6f8ac4"><td colspan="2"  > <font color="#FFFFFF">修改品牌信息：</font></td>
    </tr>
    <tr bgcolor="f5f5f5"> 
      <td width="22%" > <div align="right">品牌名称：</div></td>
      <td width="78%"> <input type="text" name="name" value="${name}" size="50" maxlength="40"/>
        <font color="#FF0000">*</font></td>
    </tr>
	<tr bgcolor="f5f5f5"> 
      <td width="22%" > <div align="right">Logo图片： <c:if test="${empty logopath}"><font color=red>没有logo</font></c:if> 
      <c:if test="${!empty logopath}"><img src="${logopath}" width="100"></c:if></div></td>
      <td width="78%"> <s:file name="logofile" size="50" /><br/></td>
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