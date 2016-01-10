package com.alwaysRun.sh_market.util;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import com.alibaba.fastjson.JSONObject;

public class HttpUtil {
	
	public String doGetStr(String url) {
		DefaultHttpClient httpClient=new DefaultHttpClient();
		HttpGet get=new HttpGet(url);
		JSONObject json=null;
		String result="";
		try {
			HttpResponse response=httpClient.execute(get);
			HttpEntity entity=response.getEntity();
			if(entity!=null){
				result=EntityUtils.toString(entity,"UTF-8");
			}
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	public String doPostStr(String url,String outStr){
		DefaultHttpClient httpClient=new DefaultHttpClient();
		HttpPost post=new HttpPost(url);
		JSONObject jsonObject=null;
		String result="";
		try {
			post.setEntity(new StringEntity(outStr, "UTF-8"));
			HttpResponse response=httpClient.execute(post);
			result=EntityUtils.toString(response.getEntity(),"UTF-8");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	
	public static void  downLoadFromUrl(String urlStr,String fileName,String savePath) throws IOException{  
        URL url = new URL(urlStr);    
        HttpURLConnection conn = (HttpURLConnection)url.openConnection();    
                //设置超时间为3秒  
        conn.setConnectTimeout(3*1000);  
        //防止屏蔽程序抓取而返回403错误  
        conn.setRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 5.0; Windows NT; DigExt)");  
  
        //得到输入流  
        InputStream inputStream = conn.getInputStream();    
        //获取自己数组  
        byte[] getData = readInputStream(inputStream);      
  
        //文件保存位置  
        File saveDir = new File(savePath);  
        /*if(!saveDir.exists()){  
            saveDir.mkdir();  
        } */ 
        File file = new File(saveDir+File.separator+fileName);      
        FileOutputStream fos = new FileOutputStream(file);       
        fos.write(getData);   
        if(fos!=null){  
            fos.close();    
        }  
        if(inputStream!=null){  
            inputStream.close();  
        }  
  
  
        System.out.println("info:"+url+" download success");   
  
    }
	
	 /** 
     * 从输入流中获取字节数组 
     * @param inputStream 
     * @return 
     * @throws IOException 
     */  
    public static  byte[] readInputStream(InputStream inputStream) throws IOException {    
        byte[] buffer = new byte[1024];    
        int len = 0;    
        ByteArrayOutputStream bos = new ByteArrayOutputStream();    
        while((len = inputStream.read(buffer)) != -1) {    
            bos.write(buffer, 0, len);    
        }    
        bos.close();    
        return bos.toByteArray();    
    }
    
    public static void main(String[] args) {  
        try{  
            downLoadFromUrl("http://file.api.weixin.qq.com/cgi-bin/media/get?access_token=5r5deVYfLl5zOLoM1JeeGBdg4orLhWrc6_YeKVIcntoKcbOhC1BLccA3ZqLXDJCL25Rs2Rl8cJQRo7Zx1Y146htEYMS42n8n45dXDI0NjGMWWUhADADDB&media_id=6V4Vr6TAG6VlvuRKzYDBFbRqqUeRMD4O9IJXI5vQ4E4zm51ng4qzihSUvEPTIqnR",  
                    "百度.jpg","F:/resource/");  
        }catch (Exception e) {  
            // TODO: handle exception  
        }  
    }  
}
