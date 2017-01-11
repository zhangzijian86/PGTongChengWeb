package com.pg.test;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;

import com.pg.daoimpl.DaoImpl;

public class Test {

	 //默认传输编码
    public static String ENCODING = "UTF8";	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DaoImpl daoImpl=new DaoImpl();
		daoImpl.login("zhangzijian", "123456");
//		 String postUrl="http://sms.jiangukj.com/SendSms.aspx";
//		 Map<String,String> map = new HashMap<String,String>();
//		 map.put("action","code");
//		 map.put("username","zwzfj2");
//		 map.put("userpass","lglp112522");
//		 map.put("mobiles","13581905786");
//		 map.put("content","111222333444555666");
//		 map.put("codeid", "3907");
//		 String aa = httpPost(postUrl, map);
//		 System.out.println("=====Check===doPost====11===yanzhengma=11="+aa);
	}

	 /**
     * Http Post 封装
     * @param url 请求的url地址
     * @param paras 参数集合
     * @return String 返回结果:字符串
     *
     */
    public static String httpPost(String url,Map<String,String> paras){

        //初始化返回结果
        String resultStr = null;
        try{
            //创建安全的httpClient
            CloseableHttpClient httpClient = HttpClients.createDefault();

            //根据参数集合构造表单列表
            List<NameValuePair> formParas = new ArrayList<NameValuePair>();
            if(paras != null){
                for(String key :paras.keySet()){
                    formParas.add(new BasicNameValuePair(key,paras.get(key)));
                }
            }

            //对表单进行编码格式化
            UrlEncodedFormEntity entity = new UrlEncodedFormEntity(formParas, ENCODING);

            //初始化post
            HttpPost httpPost = new HttpPost(url);

            //设置post内容
            httpPost.setEntity(entity);

            //初始化安全的HttpResponse
            CloseableHttpResponse httpResponse = httpClient.execute(httpPost);
            try{
                //执行请求
                HttpEntity httpEntity = httpResponse.getEntity();

                //获取请求结果
                if(httpEntity!= null){
                    //利用缓冲区,获取返回结果输入流并读取
                    InputStream inputStream = httpEntity.getContent();
                    ByteArrayOutputStream bos = new ByteArrayOutputStream();
                    try{
                        byte[] buffer = new byte[1024];
                        int length;
                        while((length = inputStream.read(buffer))!= -1){
                            bos.write(buffer,0,length);
                        }
                        byte[] result = bos.toByteArray();

                        //将获取到的字节数据结果转换为字符串
                        resultStr = new String(result,ENCODING);
                        System.out.println(resultStr);
                    }catch (Exception e){
                        System.out.println(e.getMessage());
                    }finally {
                        //关闭输入流
                        inputStream.close();
                    }
                }
            }catch (Exception e){
                System.out.println(e.getMessage());
            }finally {
                httpResponse.close();
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return  resultStr;
    }
	
}
