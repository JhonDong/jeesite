<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>医疗详情管理</title>
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
			
			/**
			 * 商品 模糊查询下拉列表
			 */
			$("#c01-select").select2({
				ajax : {
					type : 'GET',
					url : "${ctx}/product/product/search",
					dataType : 'json',
					delay : 250,
					data : function(term) {
						return query = { // 请求的参数, 关键字和搜索条件之类的
							// select搜索框里面的value
							q : term

						}
					},
					results : function(data) {
						// notice we return the value of more so Select2 knows if more
						// results can be loaded
						return {
							results : data
						};
					},
					cache : true
				},
				placeholder : '请选择',// 默认文字提示
				language : "zh-CN",
				allowClear : true,// 允许清空
				minimumInputLength : 1,// 最少输入多少个字符后开始查询
				dropdownCssClass : "bigdrop", // apply css that makes the dropdown
												// taller
				formatResult : function formatRepo(repo) {
					return repo.text;
				}, // 函数用来渲染结果
				formatSelection : function formatRepoSelection(repo) {
					return repo.text;
				},// 函数用于呈现当前的选择
				initSelection : function(element, callback) {
					var id = $(element).val();
					$.ajax({
						url : "${ctx}/product/product/callback.json?id=" + id,
						type : 'GET',
						dataType : 'json',
						success : function(data) {
							callback(data);
						}
					});
				}
			});
		});
	</script>
</head>
<body>
	<ul class="nav nav-tabs">
		<li><a href="${ctx}/product_medical/productMedical/">医疗详情列表</a></li>
		<li class="active"><a href="${ctx}/product_medical/productMedical/form?id=${productMedical.id}">医疗详情<shiro:hasPermission name="product_medical:productMedical:edit">${not empty productMedical.id?'修改':'添加'}</shiro:hasPermission><shiro:lacksPermission name="product_medical:productMedical:edit">查看</shiro:lacksPermission></a></li>
	</ul><br/>
	<form:form id="inputForm" modelAttribute="productMedical" action="${ctx}/product_medical/productMedical/save" method="post" class="form-horizontal">
		<form:hidden path="id"/>
		<sys:message content="${message}"/>		
		<div class="control-group">
			<label class="control-label">高济商品：</label>
			<div class="controls">
				<form:input path="gjId" htmlEscape="false" maxlength="20"
					class="input-xlarge required digits" id="c01-select"/>
				<span class="help-inline"><font color="red">*</font> </span>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">是否外用商品：</label>
			<div class="controls">
				<form:radiobuttons path="isSpecialExternalUse" items="${fns:getDictList('pm_enmu')}" itemLabel="label" itemValue="value" htmlEscape="false" class="required"/>
				<span class="help-inline"><font color="red">*</font> </span>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">是否兴奋剂：</label>
			<div class="controls">
				<form:radiobuttons path="isSpecialStimulant" items="${fns:getDictList('pm_enmu')}" itemLabel="label" itemValue="value" htmlEscape="false" class="required"/>
				<span class="help-inline"><font color="red">*</font> </span>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">是否精神类药物：</label>
			<div class="controls">
				<form:radiobuttons path="isSpecialPsychotropicDrugs" items="${fns:getDictList('pm_enmu')}" itemLabel="label" itemValue="value" htmlEscape="false" class="required"/>
				<span class="help-inline"><font color="red">*</font> </span>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">是否三类医疗器械：</label>
			<div class="controls">
				<form:radiobuttons path="isSpecialMedicalInstruments" items="${fns:getDictList('pm_enmu')}" itemLabel="label" itemValue="value" htmlEscape="false" class="required"/>
				<span class="help-inline"><font color="red">*</font> </span>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">是否麻黄碱：</label>
			<div class="controls">
				<form:radiobuttons path="isSpecialEfedrina" items="${fns:getDictList('pm_enmu')}" itemLabel="label" itemValue="value" htmlEscape="false" class="required"/>
				<span class="help-inline"><font color="red">*</font> </span>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">是否基药目录：</label>
			<div class="controls">
				<form:radiobuttons path="isBaseDrugList" items="${fns:getDictList('pm_enmu')}" itemLabel="label" itemValue="value" htmlEscape="false" class="required"/>
				<span class="help-inline"><font color="red">*</font> </span>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">是否医保目录：</label>
			<div class="controls">
				<form:radiobuttons path="isMedicalInsurance" items="${fns:getDictList('pm_enmu')}" itemLabel="label" itemValue="value" htmlEscape="false" class="required"/>
				<span class="help-inline"><font color="red">*</font> </span>
			</div>
		</div>
		<div class="form-actions">
			<shiro:hasPermission name="product_medical:productMedical:edit"><input id="btnSubmit" class="btn btn-primary" type="submit" value="保 存"/>&nbsp;</shiro:hasPermission>
			<input id="btnCancel" class="btn" type="button" value="返 回" onclick="history.go(-1)"/>
		</div>
	</form:form>
</body>
</html>