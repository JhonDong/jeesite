<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
<title>门户管理管理</title>
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
		<li class="active"><a href="${ctx}/pharmacy/pharmacy/">门户管理列表</a></li>
		<shiro:hasPermission name="pharmacy:pharmacy:edit">
			<li><a href="${ctx}/pharmacy/pharmacy/form">门户管理添加</a></li>
		</shiro:hasPermission>
	</ul>
	<form:form id="searchForm" modelAttribute="pharmacy"
		action="${ctx}/pharmacy/pharmacy/" method="post"
		class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}" />
		<input id="pageSize" name="pageSize" type="hidden"
			value="${page.pageSize}" />
		<ul class="ul-form">
			<li><label>门店编码：</label> <form:input path="code"
					htmlEscape="false" maxlength="20" class="input-medium" /></li>
			<li><label>门店名称：</label> <form:input path="name"
					htmlEscape="false" maxlength="255" class="input-medium" /></li>
			<li><label>企业名称：</label> <form:input path="companyName"
					htmlEscape="false" maxlength="60" class="input-medium" /></li>
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
				<th>门店编码</th>
				<th><div style="width: 200px" align="center">门店名称</div></th>
				<th>企业名称</th>
				<th><div style="width: 80px" align="center">开业时间</div></th>
				<th><div style="width: 80px" align="center">关店时间</div></th>
				<th>门店性质</th>
				<th>门店性质</th>
				<th>获得方式</th>
				<th><div style="width: 80px" align="center">收购时间</div></th>
				<th><div style="width: 100px" align="center">门店地址</div></th>
				<th>行政区划</th>
				<th>房屋性质</th>
				<th>是否有房产证</th>
				<th>是否签订房租合同</th>
				<th>是否直接与房东签约</th>
				<th><div style="width: 100px" align="center">出租方</div></th>
				<th><div style="width: 100px" align="center">承租方</div></th>
				<th><div style="width: 80px" align="center">租赁开始日</div></th>
				<th><div style="width: 80px" align="center">租赁结束日</div></th>
				<th>是否医保</th>
				<th>是否取得房租发票</th>
				<th>是否转租</th>
				<th>当月转租收入</th>
				<th>租赁面积</th>
				<th>经营面积</th>
				<th>纳税人资质</th>
				<shiro:hasPermission name="pharmacy:pharmacy:edit">
					<th>操作</th>
				</shiro:hasPermission>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${page.list}" var="pharmacy">
				<tr>
					<td><a href="${ctx}/pharmacy/pharmacy/form?id=${pharmacy.id}">
							${pharmacy.code} </a></td>
					<td>${pharmacy.name}</td>
					<td>${pharmacy.companyName}</td>
					<td><fmt:formatDate value="${pharmacy.openingTime}"
							pattern="yyyy-MM-dd " /></td>
					<td><fmt:formatDate value="${pharmacy.closeTime}"
							pattern="yyyy-MM-dd " /></td>
					<td>${pharmacy.storeNature1}</td>
					<td>${pharmacy.storeNature2}</td>
					<td>${pharmacy.getway}</td>
					<td><fmt:formatDate value="${pharmacy.acquisition}"
							pattern="yyyy-MM-dd" /></td>
					<td>${pharmacy.address}</td>
					<td>${pharmacy.partition}</td>
					<td>${pharmacy.housesNature}</td>
					<td>${fns:getDictLabel(pharmacy.isDeed, 'yes_no', '')}</td>
					<td>${fns:getDictLabel(pharmacy.isRentalContract, 'yes_no', '')}
					</td>
					<td>${fns:getDictLabel(pharmacy.isLandlordRents, 'yes_no', '')}
					</td>
					<td>${pharmacy.lessor}</td>
					<td>${pharmacy.lessee}</td>
					<td><fmt:formatDate value="${pharmacy.leaseStartDate}"
							pattern="yyyy-MM-dd" /></td>
					<td><fmt:formatDate value="${pharmacy.leaseEndDate}"
							pattern="yyyy-MM-dd" /></td>
					<td>${fns:getDictLabel(pharmacy.isMedicalInsurance, 'yes_no', '')}
					</td>
					<td>${fns:getDictLabel(pharmacy.isInvoice, 'yes_no', '')}</td>
					<td>${fns:getDictLabel(pharmacy.isSublet, 'yes_no', '')}</td>
					<td>${pharmacy.monthSubletIncome}</td>
					<td>${pharmacy.rentalArea}</td>
					<td>${pharmacy.businessArea}</td>
					<td>${pharmacy.taxpayerQualification}</td>
					<shiro:hasPermission name="pharmacy:pharmacy:edit">
						<td><a href="${ctx}/pharmacy/pharmacy/form?id=${pharmacy.id}">修改</a>
							<a href="${ctx}/pharmacy/pharmacy/delete?id=${pharmacy.id}"
							onclick="return confirmx('确认要删除该门户管理吗？', this.href)">删除</a></td>
					</shiro:hasPermission>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>