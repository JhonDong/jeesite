<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>门店映射管理</title>
	<meta name="decorator" content="default"/>
	<script type="text/javascript">
		$(document).ready(function() {
			
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
		<li class="active"><a href="${ctx}/nc_pharmacy/ncPharmacy/">门店映射列表</a></li>
		<shiro:hasPermission name="nc_pharmacy:ncPharmacy:edit"><li><a href="${ctx}/nc_pharmacy/ncPharmacy/form">门店映射添加</a></li></shiro:hasPermission>
	</ul>
	<form:form id="searchForm" modelAttribute="ncPharmacy" action="${ctx}/nc_pharmacy/ncPharmacy/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
			<li><label>门店名称：</label>
				<form:input path="pharmacyName" htmlEscape="false" maxlength="80" class="input-medium"/>
			</li>
			<li><label>企业名：</label>
				<form:input path="corpName" htmlEscape="false" maxlength="20" class="input-medium"/>
			</li>
			<li class="btns"><input id="btnSubmit" class="btn btn-primary" type="submit" value="查询"/></li>
			<li class="clearfix"></li>
		</ul>
	</form:form>
	<sys:message content="${message}"/>
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead>
			<tr>
				<th>NCID</th>
				<th>企业门店id</th>
				<th>门店名称</th>
				<th>企业名</th>
				<shiro:hasPermission name="nc_pharmacy:ncPharmacy:edit"><th>操作</th></shiro:hasPermission>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="ncPharmacy">
			<tr>
				<td><a href="${ctx}/nc_pharmacy/ncPharmacy/form?id=${ncPharmacy.id}">
					${ncPharmacy.ncId}
				</a></td>
				<td>
					${ncPharmacy.pharmacyId}
				</td>
				<td>
					${ncPharmacy.pharmacyName}
				</td>
				<td>
					${ncPharmacy.corpName}
				</td>
				<shiro:hasPermission name="nc_pharmacy:ncPharmacy:edit"><td>
    				<a href="${ctx}/nc_pharmacy/ncPharmacy/form?id=${ncPharmacy.id}">修改</a>
					<a href="${ctx}/nc_pharmacy/ncPharmacy/delete?id=${ncPharmacy.id}" onclick="return confirmx('确认要删除该门店映射吗？', this.href)">删除</a>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>