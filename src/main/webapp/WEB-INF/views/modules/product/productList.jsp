<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
<title>高济商品管理</title>
<meta name="decorator" content="default" />
<script type="text/javascript">
	$(document).ready(function() {
	});
	function page(n, s) {
		$("#pageNo").val(n);
		$("#pageSize").val(s);
		$("#searchForm").submit();
		return false;
	}
</script>
</head>
<body>
	<ul class="nav nav-tabs">
		<li class="active"><a href="${ctx}/product/product/">高济商品列表</a></li>
		<shiro:hasPermission name="product:product:edit">
			<li><a href="${ctx}/product/product/form">高济商品添加</a></li>
		</shiro:hasPermission>
	</ul>
	<form:form id="searchForm" modelAttribute="product"
		action="${ctx}/product/product/" method="post"
		class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}" />
		<input id="pageSize" name="pageSize" type="hidden"
			value="${page.pageSize}" />
		<ul class="ul-form">
			<li><label>通用名：</label> <form:input path="name"
					htmlEscape="false" maxlength="120" class="input-medium" /></li>
			<li><label>商品名：</label> <form:input path="productName"
					htmlEscape="false" maxlength="120" class="input-medium" /></li>
			<li><label>英文名：</label> <form:input path="productNameEn"
					htmlEscape="false" maxlength="120" class="input-medium" /></li>
			<li><label>高济四级名：</label> <sys:treeselect id="gj4thCid"
					name="gj4thCid" value="${product.gj4thCid}"
					labelName="gj4thCidName" labelValue="${product.gj4thCidName}"
					title="高济四级分类" url="/category/gaojiCategory/treeData" cssClass=""
					allowClear="true" notAllowSelectParent="true" /></li>
			<li><label>是否删除：</label> <form:radiobuttons path="isDelete"
					items="${fns:getDictList('del_flag')}" itemLabel="label"
					itemValue="value" htmlEscape="false" /></li>
			<li class="btns"><input id="btnSubmit" class="btn btn-primary"
				type="submit" value="查询" /></li>
			<li class="clearfix"></li>
		</ul>
	</form:form>
	<sys:message content="${message}" />
	<table id="contentTable"
		class="table table-striped table-bordered table-condensed">
		<thead>
			<tr>
				<th><div style="width:80px;" align="center">商品名</div></th>
				<th><div style="width:80px;" align="center">通用名</div></th>
				<th><div style="width:80px;" align="center">英文名</div></th>
				<th><div style="width:80px;" align="center">规格</div></th>
				<th><div style="width:50px;" align="center">剂型</div></th>
				<th><div style="width:60px;" align="center">批准文号</div></th>
				<th>商品编码</th>
				<th>国家本位码</th>
				<th>单位</th>
				<th><div style="width:120px;" align="center">生产厂家</div></th>
				<th><div style="width:120px;" align="center">产地</div></th>
				<!-- <th>适应症</th> -->
				<th>商品状态</th>
				<th><div style="width:80px;" align="center">批准日期</div></th>
				<th>营销级别</th>
				<th>型号</th>
				<th>高济四级分类</th>
				<th>是否删除</th>
				<th><div style="width:80px;" align="center">创建时间</div></th>
				<th><div style="width:80px;" align="center">更新时间</div></th>
				<th>预留备注字段</th>
				<shiro:hasPermission name="product:product:edit">
					<th>操作</th>
				</shiro:hasPermission>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${page.list}" var="product">
				<tr>
					<td><a href="${ctx}/product/product/form?id=${product.id}">
							${product.productName} </a></td>
					<td>${product.name}</td>
					<td>${product.productNameEn}</td>
					<td>${product.specification}</td>
					<td>${product.dosage}</td>
					<td>${product.approvalNumber}</td>
					<td>${product.barcode}</td>
					<td>${product.nationalStandardCode}</td>
					<td>${product.unit}</td>
					<td>${product.productFactory}</td>
					<td>${product.productAddress}</td>
					<%-- <td>${product.adaptationDisease}</td> --%>
					<td>${fns:getDictLabel(product.status, 'product_status', '')}
					</td>
					<td><fmt:formatDate value="${product.approvalDate}"
							pattern="yyyy-MM-dd" /></td>
					<td>${product.marketingLevel}</td>
					<td>${product.model}</td>
					<td>${product.gj4thCidName}</td>
					<td>${fns:getDictLabel(product.isDelete, 'del_flag', '')}</td>
					<td><fmt:formatDate value="${product.createTime}"
							pattern="yyyy-MM-dd HH:mm:ss" /></td>
					<td><fmt:formatDate value="${product.updateTime}"
							pattern="yyyy-MM-dd HH:mm:ss" /></td>
					<td>${product.mark}</td>
					<shiro:hasPermission name="product:product:edit">
						<td><a href="${ctx}/product/product/form?id=${product.id}">修改</a>
							<a href="${ctx}/product/product/delete?id=${product.id}"
							onclick="return confirmx('确认要删除该高济商品吗？', this.href)">删除</a></td>
					</shiro:hasPermission>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>