package com.thinkgem.jeesite.modules.sys.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.Map;

import com.alibaba.druid.support.json.JSONUtils;
import com.thinkgem.jeesite.common.config.Global;

/**
 * 主键id生成工具类
 * 
 * @author 董志强
 *
 */
public class IDUtils {

	public static String getpPrimaryKey() {
		String sendGetRequest = sendGetRequest(Global.getConfig("ID_IP"));
		Map<String, String> map = (Map<String, String>) JSONUtils.parse(sendGetRequest);
		if ("success".equals(map.get("message"))) {
			return map.get("id");
		} else {
			return null;
		}
	}

	public static void main(String[] args) {
		String sendGetRequest = sendGetRequest(Global.getConfig("ID_IP"));
		Map<String, String> map = (Map<String, String>) JSONUtils.parse(sendGetRequest);
		System.out.println(map.get("id"));

	}

	/**
	 * 发送http get请求
	 * 
	 * @param getUrl
	 * @return
	 */
	public static String sendGetRequest(String getUrl) {
		StringBuffer sb = new StringBuffer();
		InputStreamReader isr = null;
		BufferedReader br = null;
		try {
			URL url = new URL(getUrl);
			URLConnection urlConnection = url.openConnection();
			urlConnection.setAllowUserInteraction(false);
			isr = new InputStreamReader(url.openStream());
			br = new BufferedReader(isr);
			String line;
			while ((line = br.readLine()) != null) {
				sb.append(line);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (isr != null) {
					isr.close();
					isr = null;
				}
				if (br != null) {
					br.close();
					br = null;
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return sb.toString();
	}
}