<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>商品安全质量信息管理</title>
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
		<li class="active"><a href="${ctx}/medicine_qs/medicineQs/">商品安全质量信息列表</a></li>
		<shiro:hasPermission name="medicine_qs:medicineQs:edit"><li><a href="${ctx}/medicine_qs/medicineQs/form">商品安全质量信息添加</a></li></shiro:hasPermission>
	</ul>
	<form:form id="searchForm" modelAttribute="medicineQs" action="${ctx}/medicine_qs/medicineQs/" method="post" class="breadcrumb form-search">
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
				<th>行业标准</th>
				<th>国家本位码/追溯码</th>
				<th>国际条形码</th>
				<th>处方标示</th>
				<th>使用期长（天）</th>
				<th>疗程（天）</th>
				<th>有效期（天）</th>
				<shiro:hasPermission name="medicine_qs:medicineQs:edit"><th>操作</th></shiro:hasPermission>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="medicineQs">
			<tr>
				<td><a href="${ctx}/medicine_qs/medicineQs/form1?id=${medicineQs.id}">
					${medicineQs.gjName}
				</a></td>
				<td>
					${medicineQs.industryStandard}
				</td>
				<td>
					${medicineQs.nationalStandardCode}
				</td>
				<td>
					${medicineQs.internationalBarCode}
				</td>
				<td>
					${fns:getDictLabel(medicineQs.prescriptionLabel, 'prescription_label', '')}
				</td>
				<td>
					${medicineQs.useDays}
				</td>
				<td>
					${medicineQs.courseDays}
				</td>
				<td>
					${medicineQs.validityPeriod}
				</td>
				<shiro:hasPermission name="medicine_qs:medicineQs:edit"><td>
    				<a href="${ctx}/medicine_qs/medicineQs/form1?id=${medicineQs.id}">修改</a>
					<a href="${ctx}/medicine_qs/medicineQs/delete?id=${medicineQs.id}" onclick="return confirmx('确认要删除该商品安全质量信息吗？', this.href)">删除</a>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>