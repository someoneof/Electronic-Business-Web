<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ include file="/page/share/taglib.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>产品类别管理</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="/shopping/css/vip.css" type="text/css">
<script language="JavaScript">
	function topage(page){
		var form = document.forms[0];
		form.currpage.value=page;
		form.submit();
	}
</script>
<SCRIPT language=JavaScript src="/shopping/js/FoshanRen.js"></SCRIPT>
</head>
<body bgcolor="#FFFFFF" text="#000000" marginwidth="0" marginheight="0">
<s:form action="productTypeAction_findAllType"  namespace="/control" method="post">
<s:hidden name="currpage" />
<s:hidden name="parentid" />
<s:hidden name="query"/>
  <table width="98%" border="0" cellspacing="1" cellpadding="2" align="center">
    <tr ><td colspan="6"  bgcolor="6f8ac4" align="right">
    <%@ include file="/page/share/fenye.jsp" %>
    <tr>
      <td width="8%" bgcolor="6f8ac4"> <div align="center"><font color="#FFFFFF">代号</font></div></td>
      <td width="5%" nowrap bgcolor="6f8ac4"> <div align="center"><font color="#FFFFFF">修改</font></div></td>
      <td width="20%" bgcolor="6f8ac4"> <div align="center"><font color="#FFFFFF">产品类别名称</font></div></td>
	  <td width="10%" nowrap bgcolor="6f8ac4"> <div align="center"><font color="#FFFFFF">创建下级类别</font></div></td>
	  <td width="15%" bgcolor="6f8ac4"><div align="center"><font color="#FFFFFF">所属父类</font></div></td>
	  <td nowrap bgcolor="6f8ac4"> <div align="center"><font color="#FFFFFF">备注</font></div></td>
    </tr>
<!---------------------------LOOP START		${pageContext.request.contextPath}/------------------------------>
<c:forEach items="${pageView.record}" var="entry" >
    <tr>
      <td bgcolor="f5f5f5"> <div align="center">${entry.typeid}</div></td>
      <td bgcolor="f5f5f5"> <div align="center"><a href="${pageContext.request.contextPath}/control/productTypeAction_editUI?typeid=${entry.typeid}">
	  <img src="/shopping/images/edit.gif" width="15" height="16" border="0"></a></div></td>
      <td bgcolor="f5f5f5"> <div align="center"><a href="${pageContext.request.contextPath}/control/productTypeAction_findAllType?parentid=${entry.typeid}">${entry.name}</a> <c:if test="${fn:length(entry.childtypes)>0}"><font color=red>(有${fn:length(entry.childtypes)}个子类)</font></c:if></div></td>
	  <td bgcolor="f5f5f5"> <div align="center"><a href="${pageContext.request.contextPath}/control/productTypeAction_addUI?parentid=${entry.typeid}">创建子类别</a></div></td>
	  <td bgcolor="f5f5f5" align="center"><c:if test="${!empty entry.parent}">${entry.parent.name}</c:if></td>
	  <td bgcolor="f5f5f5"><div align="center">${entry.note}</div></td>
	</tr>
</c:forEach>
    <!----------------------LOOP END------------------------------->
    <tr> 
      <td bgcolor="f5f5f5" colspan="6" align="center"><table width="100%" border="0" cellspacing="1" cellpadding="3">
          <tr> 
            <td width="5%"></td>
              <td width="85%">
              <input name="AddDic" type="button" class="frm_btn" id="AddDic" onClick="javascript:window.location.href='<s:url action="productTypeAction_addUI" namespace="/control"/>?parentid=${param.parentid}'" value="添加类别"> &nbsp;&nbsp;
              <input name="query" type="button" class="frm_btn" id="query" onClick="javascript:window.location.href='${pageContext.request.contextPath}/page/product/query_productType.jsp'" value="查 询"> &nbsp;&nbsp;
            </td>
          </tr>
        </table></td>
    </tr>
  </table>
</s:form>
</body>
</html>