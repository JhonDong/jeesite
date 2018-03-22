<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>数据字典管理</title>
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
		<li class="active"><a href="${ctx}/product_temp/productTemp/">数据字典列表</a></li>
		<shiro:hasPermission name="product_temp:productTemp:edit"><li><a href="${ctx}/product_temp/productTemp/form">数据字典添加</a></li></shiro:hasPermission>
	</ul>
	<form:form id="searchForm" modelAttribute="productTemp" action="${ctx}/product_temp/productTemp/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
			<li><label>批准文号：</label>
				<form:input path="approvalNumber" htmlEscape="false" maxlength="80" class="input-medium"/>
			</li>
			<li><label>产品名称：</label>
				<form:input path="productName" htmlEscape="false" maxlength="120" class="input-medium"/>
			</li>
			<li><label>生产单位：</label>
				<form:input path="manufacturer" htmlEscape="false" maxlength="150" class="input-medium"/>
			</li>
			<li><label>产品类别</label>
				<form:radiobuttons path="productType" items="${fns:getDictList('product_type')}" itemLabel="label" itemValue="value" htmlEscape="false"/>
			</li>
			<li class="btns"><input id="btnSubmit" class="btn btn-primary" type="submit" value="查询"/></li>
			<li class="clearfix"></li>
		</ul>
	</form:form>
	<sys:message content="${message}"/>
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead>
			<tr>
				<th>批准文号</th>
				<th>产品名称</th>
				<th>英文名称</th>
				<th>商品名</th>
				<th>英文名称</th>
				<th>剂型</th>
				<th>规格</th>
				<th>生产单位名称</th>
				<th>生产单位英文名</th>
				<th>生产地址</th>
				<th>产地英文</th>
				<th>药品类别</th>
				<th>批准日期</th>
				<th>有效期截止</th>
				<th>原批准文号</th>
				<th>药品本位码</th>
				<th>药品本位码</th>
				<th>更新时间</th>
				<th>创建时间</th>
				<th>产品类别</th>
				<th>国际条形码</th>
				<shiro:hasPermission name="product_temp:productTemp:edit"><th>操作</th></shiro:hasPermission>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="productTemp">
			<tr>
				<td><a href="${ctx}/product_temp/productTemp/form?id=${productTemp.id}">
					${productTemp.approvalNumber}
				</a></td>
				<td>
					${productTemp.productName}
				</td>
				<td>
					${productTemp.productNameEn}
				</td>
				<td>
					${productTemp.commodityName}
				</td>
				<td>
					${productTemp.commodityNameEn}
				</td>
				<td>
					${productTemp.dosage}
				</td>
				<td>
					${productTemp.specification}
				</td>
				<td>
					${productTemp.manufacturer}
				</td>
				<td>
					${productTemp.manufacturerEn}
				</td>
				<td>
					${productTemp.manufacturingAddress}
				</td>
				<td>
					${productTemp.manufacturingAddressEn}
				</td>
				<td>
					${productTemp.medType}
				</td>
				<td>
					${productTemp.verifyDate}
				</td>
				<td>
					${productTemp.validDate}
				</td>
				<td>
					${productTemp.oldApprovalNumber}
				</td>
				<td>
					${productTemp.medCode}
				</td>
				<td>
					${productTemp.medCodeMark}
				</td>
				<td>
					${productTemp.updateTime}
				</td>
				<td>
					${productTemp.createTime}
				</td>
				<td>
					${fns:getDictLabel(productTemp.productType, 'product_type', '')}
				</td>
				<td>
					${productTemp.internationalBarCode}
				</td>
				<shiro:hasPermission name="product_temp:productTemp:edit"><td>
    				<a href="${ctx}/product_temp/productTemp/form?id=${productTemp.id}">修改</a>
					<a href="${ctx}/product_temp/productTemp/delete?id=${productTemp.id}" onclick="return confirmx('确认要删除该数据字典吗？', this.href)">删除</a>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>