<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>商品厂家管理</title>
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
		<li class="active"><a href="${ctx}/product_factory/productFactory/">商品厂家列表</a></li>
		<shiro:hasPermission name="product_factory:productFactory:edit"><li><a href="${ctx}/product_factory/productFactory/form">商品厂家添加</a></li></shiro:hasPermission>
	</ul>
	<form:form id="searchForm" modelAttribute="productFactory" action="${ctx}/product_factory/productFactory/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
			<%-- <li><label>省市：</label>
				<sys:treeselect id="province" name="province" value="${productFactory.province}" labelName="" labelValue="${productFactory.province}"
					title="区域" url="/sys/area/treeData" cssClass="input-small" allowClear="true" notAllowSelectParent="true"/>
			</li> --%>
			<li><label>高济商品名：</label>
				<form:input id="c01-select" path="gjId" htmlEscape="false" maxlength="20" class="input-medium"/>
			</li>
			<li><label>生产企业：</label>
				<form:input path="companyName" htmlEscape="false" maxlength="255" class="input-medium"/>
			</li>
			<li><label>生产地址：</label>
				<form:input path="address" htmlEscape="false" maxlength="255" class="input-medium"/>
			</li>
			<li><label>生产厂家：</label>
				<form:input path="manufacturersFactory" htmlEscape="false" maxlength="255" class="input-medium"/>
			</li>
			<li><label>是否删除：</label>
				<form:radiobuttons path="isDelete" items="${fns:getDictList('del_flag')}" itemLabel="label" itemValue="value" htmlEscape="false"/>
			</li>
			<li class="btns"><input id="btnSubmit" class="btn btn-primary" type="submit" value="查询"/></li>
			<li class="clearfix"></li>
		</ul>
	</form:form>
	<sys:message content="${message}"/>
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead>
			<tr>
			    <th>商品名</th>
				<th>编码</th>
				<th>社会信用代码/组织机构代码</th>
				<th>分类码</th>
				<th>省市</th>
				<th>生产企业名称</th>
				<th>法定代表人</th>
				<th>企业负责人</th>
				<th>质量负责人</th>
				<th>注册地址</th>
				<th>生产地址</th>
				<th>生产范围</th>
				<th>发证日期</th>
				<th>有效期</th>
				<th>发证机关</th>
				<th>签发人</th>
				<th>日常监管机构</th>
				<th>日常监管人员</th>
				<th>是否删除</th>
				<th>备注</th>
				<th>主要成分</th>
				<th>生产厂家营业执照号</th>
				<th>生产厂家营业执照有效期至</th>
				<th>厂家所属集团（中文）</th>
				<th>厂家所属集团（英文）</th>
				<th>生产厂家</th>
				<th>注册商标（中文）</th>
				<th>注册商标（英文）</th>
				<th>创建时间</th>
				<th>更新时间</th>
				<shiro:hasPermission name="product_factory:productFactory:edit"><th>操作</th></shiro:hasPermission>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="productFactory">
			<tr>
				<td><a href="${ctx}/product_factory/productFactory/form1?id=${productFactory.id}">
					${productFactory.gjName}
				</a></td>
				<td>
					${productFactory.code}
				</td>
				<td>
					${productFactory.socialCreditCode}
				</td>
				<td>
					${productFactory.cateCode}
				</td>
				<td>
					${productFactory.province}
				</td>
				<td>
					${productFactory.companyName}
				</td>
				<td>
					${productFactory.legalManger}
				</td>
				<td>
					${productFactory.companyManger}
				</td>
				<td>
					${productFactory.qaManger}
				</td>
				<td>
					${productFactory.regAddress}
				</td>
				<td>
					${productFactory.address}
				</td>
				<td>
					${productFactory.productionRange}
				</td>
				<td>
					<fmt:formatDate value="${productFactory.openingDate}" pattern="yyyy-MM-dd"/>
				</td>
				<td>
					<fmt:formatDate value="${productFactory.indate}" pattern="yyyy-MM-dd"/>
				</td>
				<td>
					${productFactory.issuingAuthority}
				</td>
				<td>
					${productFactory.signer}
				</td>
				<td>
					${productFactory.dailyRegulators}
				</td>
				<td>
					${productFactory.dailySupervisor}
				</td>
				<td>
					${fns:getDictLabel(productFactory.isDelete, 'del_flag', '')}
				</td>
				<td>
					${productFactory.mark}
				</td>
				<td>
					${productFactory.basis}
				</td>
				<td>
					${productFactory.factoryLicenseNum}
				</td>
				<td>
				<fmt:formatDate value="${productFactory.factoryLicenseIndate}" pattern="yyyy-MM-dd"/>
				</td>
				<td>
					${productFactory.manufacturersGroup}
				</td>
				<td>
					${productFactory.manufacturersGroupEn}
				</td>
				<td>
					${productFactory.manufacturersFactory}
				</td>
				<td>
					${productFactory.registeredTrademark}
				</td>
				<td>
					${productFactory.registeredTrademarkEn}
				</td>
				<td>
					<fmt:formatDate value="${productFactory.createTime}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>
				<td>
					<fmt:formatDate value="${productFactory.updateTime}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>
				<shiro:hasPermission name="product_factory:productFactory:edit"><td>
    				<a href="${ctx}/product_factory/productFactory/form?id=${productFactory.id}">修改</a>
					<a href="${ctx}/product_factory/productFactory/delete?id=${productFactory.id}" onclick="return confirmx('确认要删除该商品厂家吗？', this.href)">删除</a>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>