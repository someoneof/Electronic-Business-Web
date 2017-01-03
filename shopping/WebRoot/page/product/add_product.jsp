<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/page/share/taglib.jsp"%>
<html>
	<head>
		<title>添加产品</title>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link rel="stylesheet" href="/css/vip.css" type="text/css">
		<SCRIPT language=JavaScript src="/shopping/js/FoshanRen.js"></SCRIPT>
		<script type="text/javascript" src="/shopping/js/jscripts/tiny_mce/tiny_mce.js"></script>
		<script language="javascript" type="text/javascript">
	tinyMCE
			.init( {
				language :"zh_cn",
				mode :"textareas",
				theme :"advanced",
				//width : "500",
				plugins :"table,save,advhr,advimage,advlink,emotions,iespell,insertdatetime,preview,zoom,flash,searchreplace,print,contextmenu",
				theme_advanced_buttons1_add_before :"save,separator",
				theme_advanced_buttons1_add :"fontselect,fontsizeselect",
				theme_advanced_buttons2_add :"separator,insertdate,inserttime,preview,zoom,separator,forecolor,backcolor",
				theme_advanced_buttons2_add_before :"cut,copy,paste,separator,search,replace,separator",
				theme_advanced_buttons3_add_before :"tablecontrols,separator",
				theme_advanced_buttons3_add :"emotions,iespell,flash,advhr,separator,print",
				theme_advanced_toolbar_location :"top",
				theme_advanced_toolbar_align :"left",
				theme_advanced_path_location :"bottom",
				plugin_insertdate_dateFormat :"%Y-%m-%d",
				plugin_insertdate_timeFormat :"%H:%M:%S",
				extended_valid_elements :"a[name|href|target|title|onclick],img[class|src|border=0|alt|title|hspace|vspace|width|height|align|onmouseover|onmouseout|name],hr[class|width|size|noshade],font[face|size|color|style],span[class|align|style]",
				external_link_list_url :"example_data/example_link_list.js",
				external_image_list_url :"example_data/example_image_list.js",
				flash_external_list_url :"example_data/example_flash_list.js"
			});

	function Formfield(name, label) {
		this.name = name;
		this.label = label;
	}
	function verifyForm(objForm) {
		tinyMCE.triggerSave();//手动把iframe的值赋给textarea表单元素
		var list = new Array(new Formfield("name", "产品名称"), new Formfield(
				"typeid", "产品类型"), new Formfield("baseprice", "产品底价"),
				new Formfield("marketprice", "产品市场价"), new Formfield(
						"sellprice", "产品销售价"), new Formfield("description",
						"产品描述"), new Formfield("stylename", "产品图片的样式"),
				new Formfield("imagefile", "产品图片"));
		for ( var i = 0; i < list.length; i++) {
			var objfield = eval("objForm." + list[i].name);
			if (trim(objfield.value) == "") {
				alert(list[i].label + "不能为空");
				if (objfield.type != "hidden" && objfield.focus())
					objfield.focus();
				return false;
			}
		}
		var imagefile = objForm.imagefile.value;
		var ext = imagefile.substring(imagefile.length - 3).toLowerCase();
		if (ext != "jpg" && ext != "gif" && ext != "bmp" && ext != "png") {
			alert("只允许上传gif、jpg、bmp、png！");
			return false;
		}
		return true;
	}
	function SureSubmit(objForm) {
		if (verifyForm(objForm))
			objForm.submit();
	}
</script>
	</head>
	<body bgcolor="#FFFFFF" text="#000000" leftmargin="0" topmargin="0" vmarginwidth="0" marginheight="0">
		<s:form action="productAction_add" namespace="/control" enctype="multipart/form-data" method="post">
			<s:hidden name="typeid" />
			<table width="98%" border="0" cellspacing="1" cellpadding="3" align="center">
				<tr bgcolor="6f8ac4">
					<td colspan="2"><font color="#FFFFFF">添加产品：</font></td>
				</tr>
				<tr bgcolor="f5f5f5">
					<td width="25%"><div align="right">产品名称 ：</div></td>
					<td width="75%">
						<input name="name" type="text" size="50" maxlength="40" /><font color="#FF0000">*</font>
					</td>
				</tr>
				<tr bgcolor="f5f5f5">
					<td width="25%"><div align="right">产品类别<font color="#FF0000">*</font> ：</div></td>
					<td width="75%">
						<input type="text" name="typename" disabled="disabled" size="30" />
						<input type="button" name="select" value="选择..." onClick="javaScript:winOpen('<s:url action="productTypeAction_select" namespace="/control"/>','列表',600,400)">
						(<a href="<s:url action="productTypeAction_findAllType" namespace="/control" />">添加产品类别</a>)
					</td>
				</tr>
				<tr bgcolor="f5f5f5">
					<td width="25%"><div align="right">底(采购)价 ：</div></td>
					<td width="75%">
						<input type="text" name="baseprice" size="10" maxlength="10" onkeypress="javascript:InputLongNumberCheck()" />元<font color="#FF0000">*</font>
					</td>
				</tr>
				<tr bgcolor="f5f5f5">
					<td width="25%"><div align="right">市场价 ：</div></td>
					<td width="75%">
						<input type="text" name="marketprice" size="10" maxlength="10" onkeypress="javascript:InputLongNumberCheck()" />元<font color="#FF0000">*</font>
					</td>
				</tr>
				<tr bgcolor="f5f5f5">
					<td width="25%"><div align="right">销售价 ：</div></td>
					<td width="75%">
						<input type="text" name="sellprice" size="10" maxlength="10" onkeypress="javascript:InputLongNumberCheck()" />
						元
						<font color="#FF0000">*</font>
					</td>
				</tr>
				<tr bgcolor="f5f5f5">
					<td width="25%"><div align="right">货号 ：</div></td>
					<td width="75%">
						<input type="text" name="productcode" size="20" maxlength="30" />(注:供货商提供的便于产品查找的编号)
					</td>
				</tr>
				<tr bgcolor="f5f5f5">
					<td width="25%"><div align="right">样式名称 ：</div></td><td>
						<input name="stylename" type="text" size="10">样式图片
						<input type="file" name="imagefile" size="30">
					</td>
				</tr>
				<tr bgcolor="f5f5f5">
					<td width="25%"><div align="right">品牌 ：</div></td>
					<td width="75%">
						<select name="code" >
								<c:forEach items="${requestScope.brandList}" var="brands">
									<option value="${brands.code}">${brands.name}</option>
								</c:forEach>
						</select>
						(<a href="<s:url action="brandAction_addUI" namespace="/control" />">添加品牌</a>)
					</td>
				</tr>
				<tr bgcolor="f5f5f5">
					<td width="25%"><div align="right">适用性别 ：</div></td>
					<td width="75%">
						<select name="sex">
							<option value="NONE">男女不限</option>
							<option value="MAN">男士</option>
							<option value="WOMEN">女士</option>
						</select>
					</td>
				</tr>
				<tr bgcolor="f5f5f5">
					<td width="25%"><div align="right">型号 ：</div></td>
					<td width="75%"><input type="text" name="model" size="35" maxlength="30" /></td>
				</tr>
				<tr bgcolor="f5f5f5">
					<td width="25%"><div align="right">重量 ：</div></td>
					<td width="75%">
						<input type="text" name="weight" size="10" maxlength="10" onkeypress="javascript:InputIntNumberCheck()" />克
					</td>
				</tr>
				<tr bgcolor="f5f5f5">
					<td width="25%"><div align="right">购买说明 ：</div></td>
					<td width="75%">
						<input type="text" name="buyexplain" size="35" maxlength="30" />
					</td>
				</tr>
				<tr bgcolor="f5f5f5">
					<td width="25%" valign="top">
						<div align="right">产品简介<font color="#FF0000">*</font> ：
						</div>
					</td>
					<td width="75%">
						<textarea name="description" cols="80" rows="23"></textarea>
					</td>
				</tr>
				<tr bgcolor="f5f5f5">
					<td colspan="2">
						<div align="center">
							<input type="button" name="Add" value=" 确 认 " class="frm_btn" onClick="javascript:SureSubmit(this.form)">&nbsp;&nbsp;
							<input type="button" name="Button" value=" 返 回 " class="frm_btn" onclick="javascript:history.back()">
						</div>
					</td>
				</tr>
			</table>
		</s:form>
		<br>
	</body>
</html>