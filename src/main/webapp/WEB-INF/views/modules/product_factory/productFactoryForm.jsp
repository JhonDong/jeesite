<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
<title>商品厂家管理</title>
<meta name="decorator" content="default" />
<script type="text/javascript">
	$(document).ready(
			function() {
				//$("#name").focus();
				$("#inputForm")
						.validate(
								{
									submitHandler : function(form) {
										loading('正在提交，请稍等...');
										form.submit();
									},
									errorContainer : "#messageBox",
									errorPlacement : function(error, element) {
										$("#messageBox").text("输入有误，请先更正。");
										if (element.is(":checkbox")
												|| element.is(":radio")
												|| element.parent().is(
														".input-append")) {
											error.appendTo(element.parent()
													.parent());
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
		<li><a href="${ctx}/product_factory/productFactory/">商品厂家列表</a></li>
		<li class="active"><a
			href="${ctx}/product_factory/productFactory/form?id=${productFactory.id}">商品厂家<shiro:hasPermission
					name="product_factory:productFactory:edit">${not empty productFactory.id?'修改':'添加'}</shiro:hasPermission>
				<shiro:lacksPermission name="product_factory:productFactory:edit">查看</shiro:lacksPermission></a></li>
	</ul>
	<br />
	<form:form id="inputForm" modelAttribute="productFactory"
		action="${ctx}/product_factory/productFactory/save" method="post"
		class="form-horizontal">
		<form:hidden path="id" />
		<sys:message content="${message}" />
		<div class="control-group">
			<label class="control-label">高济商品：</label>
			<div class="controls">
				<form:input path="gjId" htmlEscape="false" maxlength="20"
					class="input-xlarge required digits" id="c01-select"/>
				<span class="help-inline"><font color="red">*</font> </span>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">编码：</label>
			<div class="controls">
				<form:input path="code" htmlEscape="false" maxlength="50"
					class="input-xlarge required" />
				<span class="help-inline"><font color="red">*</font> </span>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">社会信用代码/组织机构代码：</label>
			<div class="controls">
				<form:input path="socialCreditCode" htmlEscape="false"
					maxlength="120" class="input-xlarge required" />
				<span class="help-inline"><font color="red">*</font> </span>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">分类码：</label>
			<div class="controls">
				<form:input path="cateCode" htmlEscape="false" maxlength="40"
					class="input-xlarge required" />
				<span class="help-inline"><font color="red">*</font> </span>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">省市：</label>
			<div class="controls">
				<%-- <sys:treeselect id="province" name="province"
					value="${productFactory.province}" labelName=""
					labelValue="${productFactory.province.name}" title="区域"
					url="/sys/area/treeData" cssClass="required" allowClear="true"
					notAllowSelectParent="true" /> --%>
					<form:input path="province" htmlEscape="false" maxlength="35"
					class="input-xlarge required" />
				<span class="help-inline"><font color="red">*</font> </span>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">生产企业名称：</label>
			<div class="controls">
				<form:input path="companyName" htmlEscape="false" maxlength="255"
					class="input-xlarge required" />
				<span class="help-inline"><font color="red">*</font> </span>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">法定代表人：</label>
			<div class="controls">
				<form:input path="legalManger" htmlEscape="false" maxlength="35"
					class="input-xlarge required" />
				<span class="help-inline"><font color="red">*</font> </span>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">企业负责人：</label>
			<div class="controls">
				<form:input path="companyManger" htmlEscape="false" maxlength="255"
					class="input-xlarge required" />
				<span class="help-inline"><font color="red">*</font> </span>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">质量负责人：</label>
			<div class="controls">
				<form:input path="qaManger" htmlEscape="false" maxlength="35"
					class="input-xlarge required" />
				<span class="help-inline"><font color="red">*</font> </span>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">注册地址：</label>
			<div class="controls">
				<form:input path="regAddress" htmlEscape="false" maxlength="255"
					class="input-xlarge required" />
				<span class="help-inline"><font color="red">*</font> </span>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">生产地址：</label>
			<div class="controls">
				<form:input path="address" htmlEscape="false" maxlength="255"
					class="input-xlarge required" />
				<span class="help-inline"><font color="red">*</font> </span>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">生产范围：</label>
			<div class="controls">
				<form:input path="productionRange" htmlEscape="false"
					maxlength="255" class="input-xlarge required" />
				<span class="help-inline"><font color="red">*</font> </span>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">发证日期：</label>
			<div class="controls">
				<input name="openingDate" type="text" readonly="readonly"
					maxlength="20" class="input-medium Wdate required"
					value="<fmt:formatDate value="${productFactory.openingDate}" pattern="yyyy-MM-dd HH:mm:ss"/>"
					onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss',isShowClear:false});" />
				<span class="help-inline"><font color="red">*</font> </span>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">有效期：</label>
			<div class="controls">
				<input name="indate" type="text" readonly="readonly" maxlength="20"
					class="input-medium Wdate required"
					value="<fmt:formatDate value="${productFactory.indate}" pattern="yyyy-MM-dd HH:mm:ss"/>"
					onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss',isShowClear:false});" />
				<span class="help-inline"><font color="red">*</font> </span>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">发证机关：</label>
			<div class="controls">
				<form:input path="issuingAuthority" htmlEscape="false"
					maxlength="120" class="input-xlarge required" />
				<span class="help-inline"><font color="red">*</font> </span>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">签发人：</label>
			<div class="controls">
				<form:input path="signer" htmlEscape="false" maxlength="50"
					class="input-xlarge required" />
				<span class="help-inline"><font color="red">*</font> </span>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">日常监管机构：</label>
			<div class="controls">
				<form:input path="dailyRegulators" htmlEscape="false"
					maxlength="120" class="input-xlarge required" />
				<span class="help-inline"><font color="red">*</font> </span>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">日常监管人员：</label>
			<div class="controls">
				<form:input path="dailySupervisor" htmlEscape="false" maxlength="50"
					class="input-xlarge required" />
				<span class="help-inline"><font color="red">*</font> </span>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">是否删除：</label>
			<div class="controls">
				<form:radiobuttons path="isDelete"
					items="${fns:getDictList('del_flag')}" itemLabel="label"
					itemValue="value" htmlEscape="false" class="required" />
				<span class="help-inline"><font color="red">*</font> </span>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">备注：</label>
			<div class="controls">
				<form:input path="mark" htmlEscape="false" maxlength="255"
					class="input-xlarge " />
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">主要成分：</label>
			<div class="controls">
				<form:input path="basis" htmlEscape="false"
					class="input-xlarge required" />
				<span class="help-inline"><font color="red">*</font> </span>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">生产厂家营业执照号：</label>
			<div class="controls">
				<form:input path="factoryLicenseNum" htmlEscape="false"
					maxlength="100" class="input-xlarge required" />
				<span class="help-inline"><font color="red">*</font> </span>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">生产厂家营业执照有效期至：</label>
			<div class="controls">
					<input name="factoryLicenseIndate" type="text" readonly="readonly" maxlength="20"
					class="input-medium Wdate required"
					value="<fmt:formatDate value="${productFactory.factoryLicenseIndate}" pattern="yyyy-MM-dd HH:mm:ss"/>"
					onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss',isShowClear:false});" />
				<span class="help-inline"><font color="red">*</font> </span>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">厂家所属集团（中文）：</label>
			<div class="controls">
				<form:input path="manufacturersGroup" htmlEscape="false"
					maxlength="80" class="input-xlarge required" />
				<span class="help-inline"><font color="red">*</font> </span>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">厂家所属集团（英文）：</label>
			<div class="controls">
				<form:input path="manufacturersGroupEn" htmlEscape="false"
					maxlength="80" class="input-xlarge required" />
				<span class="help-inline"><font color="red">*</font> </span>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">生产厂家：</label>
			<div class="controls">
				<form:input path="manufacturersFactory" htmlEscape="false"
					maxlength="255" class="input-xlarge required" />
				<span class="help-inline"><font color="red">*</font> </span>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">注册商标（中文）：</label>
			<div class="controls">
				<form:input path="registeredTrademark" htmlEscape="false"
					maxlength="255" class="input-xlarge required" />
				<span class="help-inline"><font color="red">*</font> </span>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">注册商标（英文）：</label>
			<div class="controls">
				<form:input path="registeredTrademarkEn" htmlEscape="false"
					maxlength="255" class="input-xlarge required" />
				<span class="help-inline"><font color="red">*</font> </span>
			</div>
		</div>
		<div class="form-actions">
			<shiro:hasPermission name="product_factory:productFactory:edit">
				<input id="btnSubmit" class="btn btn-primary" type="submit"
					value="保 存" />&nbsp;</shiro:hasPermission>
			<input id="btnCancel" class="btn" type="button" value="返 回"
				onclick="history.go(-1)" />
		</div>
	</form:form>
</body>
</html>