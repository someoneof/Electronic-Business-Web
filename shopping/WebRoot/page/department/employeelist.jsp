<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/page/share/taglib.jsp" %>
<html>
<head>
<title>员工显示</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="/shopping/css/vip.css" type="text/css">
<script language="JavaScript">
<!--
	//到指定的分页页面
	function topage(page){
		var form = document.forms[0];
		form.currpage.value=page;
		form.submit();
	}
//-->
</script>
<SCRIPT language=JavaScript src="/shopping/js/FoshanRen.js"></SCRIPT>
</head>

<body bgcolor="#FFFFFF" text="#000000" marginwidth="0" marginheight="0">
<s:form action="employeeAction_add" namespace="/control" method="post">
<input type="hidden" name="currpage"/>
<input type="hidden" name="query"/>
<input type="hidden" name="logoname"/>
<input type="hidden" name="realname"/>
<input type="hidden" name="did"/>
  <table width="98%" border="0" cellspacing="1" cellpadding="2" align="center">
    <tr ><td colspan="11" bgcolor="6f8ac4" align="right">
    	<%@ include file="/page/share/fenye.jsp" %>
   </td></tr>
    <tr>
      <td width="5%" nowrap bgcolor="6f8ac4"> <div align="center"><font color="#FFFFFF">修改</font></div></td>
      <td width="10%" bgcolor="6f8ac4"> <div align="center"><font color="#FFFFFF">用户名</font></div></td>
      <td width="8%" bgcolor="6f8ac4"> <div align="center"><font color="#FFFFFF">设置权限</font></div></td>
      <td width="10%" bgcolor="6f8ac4"> <div align="center"><font color="#FFFFFF">姓名</font></div></td>
      <td width="5%" bgcolor="6f8ac4"> <div align="center"><font color="#FFFFFF">性别</font></div></td>
      <td width="12%" bgcolor="6f8ac4"> <div align="center"><font color="#FFFFFF">联系电话</font></div></td>
      <td width="10%" bgcolor="6f8ac4"> <div align="center"><font color="#FFFFFF">电子邮件</font></div></td>
      <td width="10%" bgcolor="6f8ac4"> <div align="center"><font color="#FFFFFF">身份证号</font></div></td>
      <td width="10%" bgcolor="6f8ac4"> <div align="center"><font color="#FFFFFF">照片</font></div></td>
      <td bgcolor="6f8ac4"><div align="center"><font color="#FFFFFF">所属部门</font></div></td>

      <td width="9%" bgcolor="6f8ac4"></td>
    </tr>
<!---------------------------LOOP START------------------------------>
<c:forEach items="${pageView.record}" var="entry">
    <tr>
      <td bgcolor="f5f5f5"> <div align="center"><a href="<s:url action="employeeAction_editUI"/>?eid=${entry.eid}">
	  <img src="/shopping/images/edit.gif" width="15" height="16" border="0"></a></div></td>
	  <td bgcolor="f5f5f5"> <div align="center">${entry.logoname}</div></td>
      <td bgcolor="f5f5f5"> <div align="center"><a href="<s:url action="employeeAction_SetUI"/>?eid=${entry.eid}">设置权限</a></div></td>
      <td bgcolor="f5f5f5"> <div align="center">${entry.employeename}</div></td>
      <td bgcolor="f5f5f5"> <div align="center">${entry.sex.name}</div></td>
      <td bgcolor="f5f5f5"> <div align="center">${entry.phone}</div></td>
      <td bgcolor="f5f5f5"> <div align="center">${entry.email}</div></td>
      <td bgcolor="f5f5f5"> <div align="center">${entry.idCard.idNo}</div></td>
      <td bgcolor="f5f5f5"> <div align="center"><c:if test="${!empty entry.photopath}"><img src="${entry.photopath}" width="80" border="0"></c:if></div></td>
      <td bgcolor="f5f5f5"> <div align="center">${entry.department.name}</div></td>
      <td bgcolor="f5f5f5"> <div align="center">
      <c:if test="${entry.visible}">
      <a href="<s:url action="employeeAction_delete"/>?eid=${entry.eid}">标志为离职</a>
      </c:if> <c:if test="${!entry.visible}"><font color=red>已离职</font></c:if>
      </div></td>
	</tr>
</c:forEach>
    <!----------------------LOOP END------------------------------->
    <tr> 
      <td bgcolor="f5f5f5" colspan="11" align="center"><table width="100%" border="0" cellspacing="1" cellpadding="3">
          <tr> 
            <td width="5%"></td>
              <td width="85%">
              <input type="button" class="frm_btn" onClick="javascript:window.location.href='<s:url action="employeeAction_addUI" namespace="/control" />'" value="添加员工"> &nbsp;&nbsp;
            </td>
          </tr>
        </table></td>
    </tr>
  </table>
</s:form>
</body>
</html>