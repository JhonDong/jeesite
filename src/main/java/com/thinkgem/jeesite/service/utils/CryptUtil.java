/**
 * 
 */
package com.thinkgem.jeesite.service.utils;

import java.security.MessageDigest;
import java.security.SecureRandom;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Base64;
/**   
* Title: CryptUtil.java   
* Description: 加密解密工具类  
* @author zqdong    @date 2018年3月28日   
*/
public class CryptUtil {
	public static void main(String[] args) throws Exception {
		String hexMd5 = hexMd5("qwncdsakwnjc");
		System.out.println(hexMd5);
		System.out.println("81e099f1f86baa518765ef193d89a923");
	}
	
	/**
	 * Base64编码, URL不安全
	 */
	public static String base64Encode(byte[] bytes){
		return Base64.encodeBase64String(bytes);
	}
	/**
	 * Base64编码, UR安全
	 */
	public static String base64URLSafeEncode(byte[] bytes){
		return Base64.encodeBase64URLSafeString(bytes);
	}
	/**
	 * Base64解码
	 */
	public static byte[] base64Decode(String base64Code) {
		return isEmpty(base64Code) ? null : Base64.decodeBase64(base64Code);
	}
	
	/**
	 * 转为十六进制字符串
	 */
	public static String hexString(byte[] bs) {
		if (bs == null || bs.length <= 0) {
			return null;
		}
		StringBuilder buff = new StringBuilder();
		for (byte b : bs) {
			if ((b & 0xff) >> 4 == 0) {
				buff.append("0").append(Integer.toHexString(b & 0xff));
			} else {
				buff.append(Integer.toHexString(b & 0xff));
			}
		}
		return buff.toString();
	}
	
	/**
	 * SHA1
	 */
	public static byte[] sha1(byte[] bytes) throws Exception {
		MessageDigest md = MessageDigest.getInstance("SHA-1");
		md.update(bytes);
		return md.digest();
	}
	/**
	 * SHA1
	 */
	public static byte[] sha1(String msg) throws Exception {
		return isEmpty(msg) ? null : sha1(msg.getBytes("UTF-8"));
	}
	/**
	 * SHA1, 然后转为十六进制字符串
	 */
	public static String hexSha1(String msg) throws Exception {
		return hexString(sha1(msg));
	}
	
	/**
	 * MD5
	 */
	public static byte[] md5(byte[] bytes) throws Exception {
		MessageDigest md = MessageDigest.getInstance("MD5");
		md.update(bytes);
		return md.digest();
	}
	/**
	 * MD5
	 */
	public static byte[] md5(String msg) throws Exception {
		return isEmpty(msg) ? null : md5(msg.getBytes("UTF-8"));
	}
	/**
	 * MD5, 然后转为十六进制字符串
	 */
	public static String hexMd5(String msg) throws Exception {
		return hexString(md5(msg));
	}
	/**
	 * MD5, 然后Base64
	 */
	public static String base64Md5(String msg) throws Exception{
		return isEmpty(msg) ? null : base64Encode(md5(msg));
	}
	
	/**
	 * AES加密
	 * @param content 待加密的内容
	 * @param encryptKey 加密密钥
	 */
	public static byte[] aesEncrypt(String content, String encryptKey) throws Exception {
		KeyGenerator kgen = KeyGenerator.getInstance("AES");
		SecureRandom sr = SecureRandom.getInstance("SHA1PRNG");
		sr.setSeed(encryptKey.getBytes());
		kgen.init(128, sr);

		Cipher cipher = Cipher.getInstance("AES");
		cipher.init(Cipher.ENCRYPT_MODE, new SecretKeySpec(kgen.generateKey().getEncoded(), "AES"));
		
		return cipher.doFinal(content.getBytes("utf-8"));
	}
	
	/**
	 * AES加密, 然后Base64
	 * @param content 待加密的内容
	 * @param encryptKey 加密密钥
	 */
	public static String base64AesEncrypt(String content, String encryptKey) throws Exception {
		return base64Encode(aesEncrypt(content, encryptKey));
	}
	
	/**
	 * AES解密
	 * @param encryptBytes 待解密的byte[]
	 * @param decryptKey 解密密钥
	 */
	public static String aesDecrypt(byte[] encryptBytes, String decryptKey) throws Exception {
		KeyGenerator kgen = KeyGenerator.getInstance("AES");
		SecureRandom sr = SecureRandom.getInstance("SHA1PRNG");
		sr.setSeed(decryptKey.getBytes());
		kgen.init(128, sr);
		
		Cipher cipher = Cipher.getInstance("AES");
		cipher.init(Cipher.DECRYPT_MODE, new SecretKeySpec(kgen.generateKey().getEncoded(), "AES"));
		byte[] decryptBytes = cipher.doFinal(encryptBytes);
		
		return new String(decryptBytes);
	}
	
	/**
	 * AES解密Base64编码字符串
	 * @param encryptStr 待解密的base 64 code
	 * @param decryptKey 解密密钥
	 */
	public static String base64AesDecrypt(String encryptStr, String decryptKey) throws Exception {
		return isEmpty(encryptStr) ? null : aesDecrypt(base64Decode(encryptStr), decryptKey);
	}
	
	/**
	 * DES加密, 然后Base64
	 * @param data
	 * @param password
	 */
	public static String base64DesEncrypt(byte[] data, String password) {
		try {
			// 生成一个可信任的随机数源
			SecureRandom random = new SecureRandom();
			// 从原始密钥数据创建DESKeySpec对象
			DESKeySpec desKey = new DESKeySpec(password.getBytes());
			// 创建一个密匙工厂，然后用它把DESKeySpec转换成
			SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
			SecretKey securekey = keyFactory.generateSecret(desKey);
			// Cipher对象实际完成加密操作
			Cipher cipher = Cipher.getInstance("DES");
			// 用密匙初始化Cipher对象
			cipher.init(Cipher.ENCRYPT_MODE, securekey, random);
			// 获取数据并加密
			// 加密后base64
			return base64Encode(cipher.doFinal(data));
		} catch (Throwable e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * DES解密Base64编码字符串
	 * @param src
	 * @param password
	 */
	public static byte[] base64DesDecrypt(String src, String password) throws Exception {
		//base64
		byte[] byteData = base64Decode(src);
		// DES算法要求有一个可信任的随机数源
		SecureRandom random = new SecureRandom();
		// 创建一个DESKeySpec对象
		DESKeySpec desKey = new DESKeySpec(password.getBytes());
		// 创建一个密匙工厂
		SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
		// 将DESKeySpec对象转换成SecretKey对象
		SecretKey securekey = keyFactory.generateSecret(desKey);
		// Cipher对象实际完成解密操作
		Cipher cipher = Cipher.getInstance("DES");
		// 用密匙初始化Cipher对象
		cipher.init(Cipher.DECRYPT_MODE, securekey, random);
		// 解密数据并返回
		return cipher.doFinal(byteData);
	}
	
	public static boolean isEmpty(String str){
		if(str == null || "".equals(str)){
			return true;
		}else{
			return false;
		}
	}

}
