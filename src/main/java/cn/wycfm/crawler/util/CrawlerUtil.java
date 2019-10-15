package cn.wycfm.crawler.util;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.apache.http.HttpEntity;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class CrawlerUtil {

	/*
     * 爬取网页信息 返回抓取的页面全部内容
     */
    public static String crawlerData(String url) {
        //CloseableHttpClient httpclient = createSSLClientDefault();
    	
        CloseableHttpClient httpclient = HttpClients.createDefault();
        //HttpClients.
        try {
        	
            HttpGet httpget = new HttpGet(url);
            
            httpget.setHeader("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3");
             httpget.setHeader("Accept-Encoding","gzip, deflate, br");
			httpget.setHeader("Accept-Language", "zh-CN,zh;q=0.9");
			httpget.setHeader("Cache-Control", "no-cache");
			httpget.setHeader("Connection", "keep-alive");
			httpget.setHeader("Cookie","_lx_utm=utm_source%3DBaidu%26utm_medium%3Dorganic; _lxsdk_cuid=16db4cb15c3c8-0e0fcd895554f2-67e1b3f-100200-16db4cb15c4c8; _lxsdk=16db4cb15c3c8-0e0fcd895554f2-67e1b3f-100200-16db4cb15c4c8; _hc.v=ee745293-bd6f-0f51-26b8-fbc16c8344bd.1570696272; cy=6; cye=suzhou; aburl=1; Hm_lvt_dbeeb675516927da776beeb1d9802bd4=1570696364; Hm_lpvt_dbeeb675516927da776beeb1d9802bd4=1570696522; wed_user_path=34203|0; _lxsdk_s=16db4cb15c4-37e-5ae-e3c%7C%7C69");
			httpget.setHeader("Host", "www.dianping.com");
			httpget.setHeader("Pragma", "no-cache");
			httpget.setHeader("Upgrade-Insecure-Requests", "1");
			httpget.setHeader("User-Agent","Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/77.0.3865.90 Safari/537.36");
			
            //System.out.println(httpget.getURI());
            CloseableHttpResponse response = httpclient.execute(httpget);
            try {
                // 获取响应实体
                HttpEntity entity = response.getEntity();
               
                // 打印响应状态
                if (entity != null) {
                    return EntityUtils.toString(entity);
                }
            } finally {
                response.close();
            }
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 关闭连接,释放资源
            try {
                httpclient.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
    
    public static String crawlerData(String url, Map<String,String> header) {
        //CloseableHttpClient httpclient = createSSLClientDefault();
    	
        CloseableHttpClient httpclient = HttpClients.createDefault();
        //HttpClients.
        try {
        	
            HttpGet httpget = new HttpGet(url);
            
           if(header!=null && header.size()>0) {
        	  Set<Entry<String,String>> entrySet = header.entrySet();
        	  Iterator<Entry<String, String>> iterator = entrySet.iterator();
        	  while(iterator.hasNext()) {
        		  Entry<String, String> next = iterator.next();
        		  httpget.setHeader(next.getKey(), next.getValue());
        	  }
           }
            //System.out.println(httpget.getURI());
            CloseableHttpResponse response = httpclient.execute(httpget);
            try {
                // 获取响应实体
                HttpEntity entity = response.getEntity();
               
                // 打印响应状态
                if (entity != null) {
                    return EntityUtils.toString(entity);
                }
            } finally {
                response.close();
            }
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 关闭连接,释放资源
            try {
                httpclient.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
    
    
    
    
}
