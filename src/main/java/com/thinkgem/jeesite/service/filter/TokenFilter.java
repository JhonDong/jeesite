package com.thinkgem.jeesite.service.filter;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.druid.support.json.JSONUtils;
import com.thinkgem.jeesite.service.bean.Result;
import com.thinkgem.jeesite.service.utils.CryptUtil;

public class TokenFilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		// 获得请求参数的token令牌
		String token = (String) req.getParameter("token");
		if (token != null) {
			if (CheckToken(req)) {
				Map parameterMap = req.getParameterMap();
				// 获得所有请求参数参数个数
				if (parameterMap.size() != 6) {
					retrunCode(res, Result.FALSE_REQUEST_CODE, Result.FALSE_REQUEST_MSG);
				}
				// 获取请求参数验证token
				String role = (String) parameterMap.get("role");
				String timestamp = (String) parameterMap.get("timestamp");
				try {
					String t = CryptUtil.hexMd5(role + timestamp);
					// 令牌通过
					if (token.equals(t)) {
						String params = (String) parameterMap.get("params");
						String key = (String) parameterMap.get("key");
						// 判断请求参数是否被篡改
						String p = CryptUtil.hexMd5(params + timestamp);
						if(p.equals(key)){
							// 放行
							chain.doFilter(request, response);
						}else{
							retrunCode(res, Result.PARAM_ERROR_CODE, Result.PARAM_ERROR_MSG);
						}

					} else {
						retrunCode(res, Result.TOKEN_ERROE_CODE, Result.TOKEN_ERROE_MSG);
					}
				} catch (Exception e) {
					retrunCode(res, Result.INNER_ERROR_CODE, Result.INNER_ERROR_MSG);
				}

				
			}

		} else {
			retrunCode(res, Result.TOKEN_ERROE_CODE, Result.TOKEN_ERROE_MSG);
		}

	}

	/**
	 * 校验token
	 * 
	 * @param req
	 * @return
	 */
	private boolean CheckToken(HttpServletRequest req) {

		return false;
	}

	@Override
	public void destroy() {

	}

	@SuppressWarnings("unused")
	private void retrunCode(HttpServletResponse response, int code, String msg) {
		response.setHeader("Content-type", "text/html;charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = null;
		Result r = new Result(code, msg, null);
		try {
			out = response.getWriter();
			out.write(JSONUtils.toJSONString(r));
		} catch (Exception e) {
		} finally {
			out.close();
		}
		return;
	}

}
