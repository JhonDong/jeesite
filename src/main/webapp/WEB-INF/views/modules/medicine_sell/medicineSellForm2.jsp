<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>商品销售管理</title>
	<meta name="decorator" content="default"/>
	<script type="text/javascript">
		$(document).ready(function() {
			//$("#name").focus();
			$("#inputForm").validate({
				submitHandler: function(form){
					loading('正在提交，请稍等...');
					form.submit();
				},
				errorContainer: "#messageBox",
				errorPlacement: function(error, element) {
					$("#messageBox").text("输入有误，请先更正。");
					if (element.is(":checkbox")||element.is(":radio")||element.parent().is(".input-append")){
						error.appendTo(element.parent().parent());
					} else {
						error.insertAfter(element);
					}
				}
			});
		});
	</script>
</head>
<body>
	<ul class="nav nav-tabs">
		<li><a href="${ctx}/medicine_sell/medicineSell/">商品销售列表</a></li>
		<li class="active"><a href="${ctx}/medicine_sell/medicineSell/form?id=${medicineSell.id}">商品销售<shiro:hasPermission name="medicine_sell:medicineSell:edit">${not empty medicineSell.id?'修改':'添加'}</shiro:hasPermission><shiro:lacksPermission name="medicine_sell:medicineSell:edit">查看</shiro:lacksPermission></a></li>
	</ul><br/>
	<form:form id="inputForm" modelAttribute="medicineSell" action="${ctx}/medicine_sell/medicineSell/save" method="post" class="form-horizontal">
		<form:hidden path="id"/>
		<sys:message content="${message}"/>		
		<div class="control-group">
			<label class="control-label">高济商品：</label>
			<div class="controls">
				<form:input path="gjId" htmlEscape="false" maxlength="20"
					class="input-xlarge required" type="hidden" />
				${medicineSell.gjName}
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">外包装建议零售价（元）：</label>
			<div class="controls">
				<form:input path="suggestedRetailPrice" htmlEscape="false" class="input-xlarge required number"/>
				<span class="help-inline"><font color="red">*</font> </span>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">采购价格（元）：</label>
			<div class="controls">
				<form:input path="procurementPrice" htmlEscape="false" class="input-xlarge required number"/>
				<span class="help-inline"><font color="red">*</font> </span>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">零售价（元）：</label>
			<div class="controls">
				<form:input path="retailPrice" htmlEscape="false" class="input-xlarge required number"/>
				<span class="help-inline"><font color="red">*</font> </span>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">会员价（元）：</label>
			<div class="controls">
				<form:input path="memberPrice" htmlEscape="false" class="input-xlarge required number"/>
				<span class="help-inline"><font color="red">*</font> </span>
			</div>
		</div>
		<div class="form-actions">
			<shiro:hasPermission name="medicine_sell:medicineSell:edit"><input id="btnSubmit" class="btn btn-primary" type="submit" value="保 存"/>&nbsp;</shiro:hasPermission>
			<input id="btnCancel" class="btn" type="button" value="返 回" onclick="history.go(-1)"/>
		</div>
	</form:form>
</body>
</html>