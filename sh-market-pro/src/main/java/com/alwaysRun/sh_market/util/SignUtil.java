package com.alwaysRun.sh_market.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class SignUtil {
	
	  /**
	   * 随机生成16位字符串
	   *
	   * @return
	   */
	  public String genRandomStr() {
	    String base = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
	    Random random = new Random();
	    StringBuffer sb = new StringBuffer();
	    for (int i = 0; i < 16; i++) {
	      int number = random.nextInt(base.length());
	      sb.append(base.charAt(number));
	    }
	    return sb.toString();
	  }
	  
	  /**
	   * 生成时间戳
	   * @return
	   */
	  public long timeStamp(){
		  return new Date().getTime();
	  }
	  
	  /**
	   * 组装前端所需的参数
	   * @param jsapiTicket
	   * @return
	   */
	  public Map<String, String> makeParams(String jsapiTicket,String url){
		  Map<String, String> map=new HashMap<String, String>();
		  String nonceStr=genRandomStr();
		  String timeStamp=timeStamp()+"";
		  //String url="http://wxdv.berbon.com/sh-market-web/addGoods.html";
		  map.put("jsapi_ticket", jsapiTicket);
		  map.put("noncestr", nonceStr);
		  map.put("timestamp", timeStamp);
		  map.put("url", url);
		  List<String> keys = new ArrayList<String>(map.keySet());
	      Collections.sort(keys);
	      
	      StringBuffer toSign = new StringBuffer();
	        for (String key : keys) {
	            String value = map.get(key);
	            if (null != value && !"".equals(value)) {
	                toSign.append(key + "=" + value + "&");
	            }
	        }
	       String result=toSign.toString().substring(0, toSign.length()-1);
	      String sign=SHA1.SHA1(result);
	      map.put("sign", sign);
	      return map;
	  }
	  
//	  public static void main(String[] args) {
//		  SignUtil util=new SignUtil();
//		  util.makeParams("-FRPiODOM4PjRMYfJVwfR0-eA-nBqOvEZB4kTIDVWj9ZMfLjcJZYgwiChUTZV1hNPGJnWIPj3CBFEpyKpelJz6bnZouNeglE3TgMiccHcdYMLGgACASRM");
//	}
}
