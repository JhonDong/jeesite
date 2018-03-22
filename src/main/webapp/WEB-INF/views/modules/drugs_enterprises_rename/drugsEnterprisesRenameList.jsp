<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>药品生产企业管理</title>
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
		<li class="active"><a href="${ctx}/drugs_enterprises_rename/drugsEnterprisesRename/">药品生产企业列表</a></li>
		<shiro:hasPermission name="drugs_enterprises_rename:drugsEnterprisesRename:edit"><li><a href="${ctx}/drugs_enterprises_rename/drugsEnterprisesRename/form">药品生产企业添加</a></li></shiro:hasPermission>
	</ul>
	<form:form id="searchForm" modelAttribute="drugsEnterprisesRename" action="${ctx}/drugs_enterprises_rename/drugsEnterprisesRename/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
			<li><label>厂家名：</label>
				<form:input path="title" htmlEscape="false" maxlength="1000" class="input-medium"/>
			</li>
			<li class="btns"><input id="btnSubmit" class="btn btn-primary" type="submit" value="查询"/></li>
			<li class="clearfix"></li>
		</ul>
	</form:form>
	<sys:message content="${message}"/>
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead>
			<tr>
				<th>厂家名</th>
				<th>描述</th>
				<th>商品编码</th>
				<th>状态</th>
				<th>编号</th>
				<th>社会信用代码</th>
				<th>分类码</th>
				<th>省市</th>
				<th>企业名称</th>
				<th>法定代表人</th>
				<th>企业负责人</th>
				<th>质量负责人</th>
				<th>注册地址</th>
				<th>生产地址</th>
				<th>生产范围</th>
				<th>有效期至</th>
				<th>发证机关</th>
				<th>签发人</th>
				<th>日常监管机构</th>
				<th>日常监管人员</th>
				<th>监督举报电话</th>
				<th>备注</th>
				<th>发证日期</th>
				<shiro:hasPermission name="drugs_enterprises_rename:drugsEnterprisesRename:edit"><th>操作</th></shiro:hasPermission>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="drugsEnterprisesRename">
			<tr>
				<td><a href="${ctx}/drugs_enterprises_rename/drugsEnterprisesRename/form?id=${drugsEnterprisesRename.id}">
					${drugsEnterprisesRename.title}
				</a></td>
				<td>
					${drugsEnterprisesRename.description}
				</td>
				<td>
					${drugsEnterprisesRename.MId}
				</td>
				<td>
					${drugsEnterprisesRename.status}
				</td>
				<td>
					${drugsEnterprisesRename.serialNumber}
				</td>
				<td>
					${drugsEnterprisesRename.socialCreditCode}
				</td>
				<td>
					${drugsEnterprisesRename.classificationCode}
				</td>
				<td>
					${drugsEnterprisesRename.provinceCity}
				</td>
				<td>
					${drugsEnterprisesRename.firmName}
				</td>
				<td>
					${drugsEnterprisesRename.legalRepresentative}
				</td>
				<td>
					${drugsEnterprisesRename.responsiblePersons}
				</td>
				<td>
					${drugsEnterprisesRename.qualityDirecter}
				</td>
				<td>
					${drugsEnterprisesRename.registeredAddress}
				</td>
				<td>
					${drugsEnterprisesRename.productionAddress}
				</td>
				<td>
					${drugsEnterprisesRename.productionRange}
				</td>
				<td>
					${drugsEnterprisesRename.dateOfExpiry}
				</td>
				<td>
					${drugsEnterprisesRename.licenceIssuingAuthority}
				</td>
				<td>
					${drugsEnterprisesRename.signer}
				</td>
				<td>
					${drugsEnterprisesRename.dailyOrganization}
				</td>
				<td>
					${drugsEnterprisesRename.dailyPeople}
				</td>
				<td>
					${drugsEnterprisesRename.reportTelphone}
				</td>
				<td>
					${drugsEnterprisesRename.remarks}
				</td>
				<td>
					${drugsEnterprisesRename.certificate}
				</td>
				<shiro:hasPermission name="drugs_enterprises_rename:drugsEnterprisesRename:edit"><td>
    				<a href="${ctx}/drugs_enterprises_rename/drugsEnterprisesRename/form?id=${drugsEnterprisesRename.id}">修改</a>
					<a href="${ctx}/drugs_enterprises_rename/drugsEnterprisesRename/delete?id=${drugsEnterprisesRename.id}" onclick="return confirmx('确认要删除该药品生产企业吗？', this.href)">删除</a>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>