<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/page/share/taglib.jsp" %>
<html>
<head>
<title>注册用户列表</title>
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
	
	function allSelect(){
		var form = document.forms[0];
		var state = form.allselectbox.checked;
		var length = form.usernames.length;
		if(length){
			for(var i=0;i<length;i++){
				form.usernames[i].checked=state;
			}
		}else{
			form.usernames.checked=state;
		}
	}
	function _action(methodName){
		if(selectItem()){
			var form = document.forms[0];
			form.action='<s:url action="customerAction_setCustomerState"/>?usernames=form.usernames.value&method='+methodName;
			form.submit();
		}else{
			alert("请选择要操作的记录");
		}
	}
	function selectItem(){
		var form = document.forms[0];
		var length = form.usernames.length;
		if(length){
			for(var i=0;i<length;i++){
				if(form.usernames[i].checked) return true;
			}
		}else{
			return form.usernames.checked;
		}
		return false;
	}
//-->
</script>
<SCRIPT language=JavaScript src="/shopping/js/FoshanRen.js"></SCRIPT>
</head>

<body bgcolor="#FFFFFF" text="#000000" marginwidth="0" marginheight="0">
<s:form action="customerAction_setCustomerState" namespace="/control" method="post">
<input  type="hidden" name="currpage"/>
<input  type="hidden" name="query"/>
<input  type="hidden" name="realname"/>
<input  type="hidden" name="email"/>
<input  type="hidden" name="username"/>
<input name="method" type="hidden">
  <table width="98%" border="0" cellspacing="1" cellpadding="2" align="center">
    <tr ><td colspan="7" bgcolor="6f8ac4" align="right">
    	<%@ include file="/page/share/fenye.jsp" %>
   </td></tr>
    <tr>
      <td width="8%" bgcolor="6f8ac4">  <div align="center"><font color="#FFFFFF">选择</font></div></td>
      <td width="20%" bgcolor="6f8ac4"> <div align="center"><font color="#FFFFFF">用户名</font></div></td>
      <td width="15%" bgcolor="6f8ac4"> <div align="center"><font color="#FFFFFF">真实姓名</font></div></td>
	  <td width="10%" bgcolor="6f8ac4"> <div align="center"><font color="#FFFFFF">性别</font></div></td>
	  <td width="22%" bgcolor="6f8ac4"> <div align="center"><font color="#FFFFFF">电子邮箱</font></div></td>
	  <td width="20%" bgcolor="6f8ac4"> <div align="center"><font color="#FFFFFF">注册时间</font></div></td>
	  <td width="7%" bgcolor="6f8ac4">  <div align="center"><font color="#FFFFFF">状态</font></div></td>
    </tr>
<!---------------------------LOOP START------------------------------>
<c:forEach items="${pageView.record}" var="entry">
    <tr>
      <td bgcolor="f5f5f5"> <div align="center"><input type="checkbox" name="usernames" value="${entry.username}"></div></td>
      <td bgcolor="f5f5f5"> <div align="center">${entry.username}</div></td>
      <td bgcolor="f5f5f5"> <div align="center">${entry.customername }</div></td>
	  <td bgcolor="f5f5f5"> <div align="center"> ${entry.sex.name }</div></td>
	  <td bgcolor="f5f5f5"> <div align="center"> ${entry.email }</div></td>
	  <td bgcolor="f5f5f5"> <div align="center"> ${entry.registertime }</div></td>
	  <td bgcolor="f5f5f5"> <div align="center"><c:if test="${entry.state}">可用</c:if><c:if test="${!entry.state}">禁用</c:if></div></td>
	</tr>
</c:forEach>
    <!----------------------LOOP END------------------------------->
    <tr>
      <td bgcolor="f5f5f5" colspan="7" align="center"><table width="100%" border="0" cellspacing="1" cellpadding="3">
          <tr> 
            <td width="10%"><input type="checkbox" onclick="javascript:allSelect()" name="allselectbox">全选</td>
              <td width="85%">
				<input type="button" value=" 禁 用 " class="frm_btn" onclick="javascript:_action('delete')">&nbsp;&nbsp;
				<input type="button" value=" 启 用 " class="frm_btn" onclick="javascript:_action('enable')">
            </td>
          </tr>
        </table></td>
    </tr>
  </table>
</s:form>
</body>
</html>