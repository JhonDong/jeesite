<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>商品采购管理</title>
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
		<li class="active"><a href="${ctx}/medicine_purchase/medicinePurchase/">商品采购列表</a></li>
		<shiro:hasPermission name="medicine_purchase:medicinePurchase:edit"><li><a href="${ctx}/medicine_purchase/medicinePurchase/form">商品采购添加</a></li></shiro:hasPermission>
	</ul>
	<form:form id="searchForm" modelAttribute="medicinePurchase" action="${ctx}/medicine_purchase/medicinePurchase/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
			<li><label>高济商品id：</label>
				<form:input path="gjId" htmlEscape="false" maxlength="20" class="input-medium"/>
			</li>
			<li class="btns"><input id="btnSubmit" class="btn btn-primary" type="submit" value="查询"/></li>
			<li class="clearfix"></li>
		</ul>
	</form:form>
	<sys:message content="${message}"/>
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead>
			<tr>
				<th>高济商品id</th>
				<th>结算方式</th>
				<th>采购属性</th>
				<th>铺底数量</th>
				<th>铺底金额（元）</th>
				<th>是否自有品牌</th>
				<th>配送方式</th>
				<th>退货识别</th>
				<th>采购员编号</th>
				<th>采购员姓名</th>
				<th>税控编码</th>
				<th>税率</th>
				<th>供应商编码</th>
				<th>供应商名称</th>
				<th>create_time</th>
				<th>update_time</th>
				<shiro:hasPermission name="medicine_purchase:medicinePurchase:edit"><th>操作</th></shiro:hasPermission>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="medicinePurchase">
			<tr>
				<td><a href="${ctx}/medicine_purchase/medicinePurchase/form?id=${medicinePurchase.id}">
					${medicinePurchase.gjId}
				</a></td>
				<td>
					${fns:getDictLabel(medicinePurchase.settlementMethod, 'settlement_method', '')}
				</td>
				<td>
					${medicinePurchase.purchasingAttr}
				</td>
				<td>
					${medicinePurchase.vmiMinNum}
				</td>
				<td>
					${medicinePurchase.vmiMinMoney}
				</td>
				<td>
					${fns:getDictLabel(medicinePurchase.ownBrand, 'yes_no', '')}
				</td>
				<td>
					${fns:getDictLabel(medicinePurchase.deliveryMethod, 'delivery_method', '')}
				</td>
				<td>
					${medicinePurchase.returnsCode}
				</td>
				<td>
					${medicinePurchase.purchaserId}
				</td>
				<td>
					${medicinePurchase.purchaserName}
				</td>
				<td>
					${medicinePurchase.taxControlCode}
				</td>
				<td>
					${medicinePurchase.taxRate}
				</td>
				<td>
					${medicinePurchase.supplierCode}
				</td>
				<td>
					${medicinePurchase.supplierName}
				</td>
				<td>
					<fmt:formatDate value="${medicinePurchase.createTime}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>
				<td>
					<fmt:formatDate value="${medicinePurchase.updateTime}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>
				<shiro:hasPermission name="medicine_purchase:medicinePurchase:edit"><td>
    				<a href="${ctx}/medicine_purchase/medicinePurchase/form?id=${medicinePurchase.id}">修改</a>
					<a href="${ctx}/medicine_purchase/medicinePurchase/delete?id=${medicinePurchase.id}" onclick="return confirmx('确认要删除该商品采购吗？', this.href)">删除</a>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>