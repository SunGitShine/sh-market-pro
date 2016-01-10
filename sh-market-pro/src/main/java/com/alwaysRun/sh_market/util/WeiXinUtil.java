package com.alwaysRun.sh_market.util;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import net.sf.json.JSONObject;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.springframework.beans.factory.annotation.Autowired;

import com.alwaysRun.sh_market.service.ConfigStorageService;
import com.alwaysRun.sh_market.weixin.bean.Button;
import com.alwaysRun.sh_market.weixin.bean.Menu;
import com.alwaysRun.sh_market.weixin.bean.TextMessage;
import com.alwaysRun.sh_market.weixin.bean.ViewButton;
import com.thoughtworks.xstream.XStream;

public class WeiXinUtil {

	@Autowired
	private ConfigStorageService configStorageService;
	
	public boolean chack(String signature, String timestamp,String nonce) {
		String token="weixin";
		String arr[]=new String[]{token,timestamp,nonce};
		//排序
		Arrays.sort(arr);
		//拼接字符串
		StringBuffer sb=new StringBuffer();
		for(int i=0;i<arr.length;i++){
			sb.append(arr[i]);
		}
		return signature.equals(SHA1.SHA1(sb.toString()));
	}
	
	public static String sha1(String input) throws NoSuchAlgorithmException {
        MessageDigest mDigest = MessageDigest.getInstance("SHA1");
        byte[] result = mDigest.digest(input.getBytes());
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < result.length; i++) {
            sb.append(Integer.toString((result[i] & 0xff) + 0x100, 16).substring(1));
        }
         
        return sb.toString();
    }
	
	/**
	 * XML转map
	 * 
	 * @param request
	 * @return
	 * @throws DocumentException
	 * @throws IOException
	 */
	public static Map<String, String> XMLToMap(HttpServletRequest request)
			throws DocumentException, IOException {
		Map<String, String> map = new HashMap<String, String>();
		SAXReader reader = new SAXReader();

		InputStream is = request.getInputStream();
		Document doc = reader.read(is);

		Element root = doc.getRootElement();

		List<Element> list = root.elements();
		for (Element e : list) {
			map.put(e.getName(), e.getText());
		}
		is.close();
		return map;
	}
	
	public String textToXml(TextMessage textMessage) {
		XStream xStream = new XStream();
		xStream.alias("xml", textMessage.getClass());
		String xml = xStream.toXML(textMessage);
		return xml;
	}
	
}
