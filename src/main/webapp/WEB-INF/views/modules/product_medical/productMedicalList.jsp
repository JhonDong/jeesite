<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>医疗详情管理</title>
	<meta name="decorator" content="default"/>
	<script type="text/javascript">
	$(document).ready(function() {
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
		function page(n,s){
			$("#pageNo").val(n);
			$("#pageSize").val(s);
			$("#searchForm").submit();
        	return false;
        }
		
		
	</script>
</head>
<body>
	<ul class="nav nav-tabs">
		<li class="active"><a href="${ctx}/product_medical/productMedical/">医疗详情列表</a></li>
		<shiro:hasPermission name="product_medical:productMedical:edit"><li><a href="${ctx}/product_medical/productMedical/form">医疗详情添加</a></li></shiro:hasPermission>
	</ul>
	<form:form id="searchForm" modelAttribute="productMedical" action="${ctx}/product_medical/productMedical/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
			<li><label>高济商品名：</label>
				<form:input id="c01-select" path="gjId" htmlEscape="false" maxlength="20" class="input-medium"/>
			</li>
			<li class="btns"><input id="btnSubmit" class="btn btn-primary" type="submit" value="查询"/></li>
			<li class="clearfix"></li>
		</ul>
	</form:form>
	<sys:message content="${message}"/>
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead>
			<tr>
				<th>高济商品</th>
				<th>是否外用商品</th>
				<th>是否兴奋剂</th>
				<th>是否精神类药物</th>
				<th>是否三类医疗器械</th>
				<th>是否麻黄碱</th>
				<th>是否基药目录</th>
				<th>是否医保目录</th>
				<th>创建时间</th>
				<th>更新时间</th>
				<shiro:hasPermission name="product_medical:productMedical:edit"><th>操作</th></shiro:hasPermission>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="productMedical">
			<tr>
				<td><a href="${ctx}/product_medical/productMedical/form1?id=${productMedical.id}">
					${productMedical.gjName}
				</a></td>
				<td>
					${productMedical.isSpecialExternalUse}
				</td>
				<td>
					${productMedical.isSpecialStimulant}
				</td>
				<td>
					${productMedical.isSpecialPsychotropicDrugs}
				</td>
				<td>
					${productMedical.isSpecialMedicalInstruments}
				</td>
				<td>
					${productMedical.isSpecialEfedrina}
				</td>
				<td>
					${productMedical.isBaseDrugList}
				</td>
				<td>
					${productMedical.isMedicalInsurance}
				</td>
				<td>
					<fmt:formatDate value="${productMedical.createTime}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>
				<td>
					<fmt:formatDate value="${productMedical.updateTime}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>
				<shiro:hasPermission name="product_medical:productMedical:edit"><td>
    				<a href="${ctx}/product_medical/productMedical/form1?id=${productMedical.id}">修改</a>
					<a href="${ctx}/product_medical/productMedical/delete?id=${productMedical.id}" onclick="return confirmx('确认要删除该医疗详情吗？', this.href)">删除</a>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>