package test;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

public class test {

	 public static void main(String[] args) throws Exception {
	        CloseableHttpClient httpclient = HttpClients.createDefault();
	        try {
	            HttpGet httpGet = new HttpGet("http://qt.gtimg.cn/q=sh600785");
	            while(true)
	            {
	            	Thread.sleep(1000);
	            	CloseableHttpResponse response1 = httpclient.execute(httpGet);
		            try {	            	
		                //System.out.println(response1.getStatusLine());
		                HttpEntity entity1 = response1.getEntity();	                
		                String stock = EntityUtils.toString(entity1);
		                EntityUtils.consume(entity1);
		                
		                //System.out.println(stock);≤‚ ‘
		                String[] datas = stock.split("~");
		                System.out.println(datas[1] + ":" + datas[3] + " " + datas[32] + "%");
		                  String buy = "buy: " + datas[9] + '[' + datas[10] + "] " + 
		                		  datas[11] + '[' + datas[12]+ "] " + 
		                		  datas[13] + '[' + datas[14]+ "] " +
		                		  datas[15] + '[' + datas[16]+ "] " +
		                		  datas[17] + '[' + datas[18] + ']';
		                  
		                  String sell = "sell: " + datas[19] + '[' + datas[20] + "] " + 
		                		  datas[21] + '[' + datas[22]+ "] " + 
		                		  datas[23] + '[' + datas[24]+ "] " +
		                		  datas[25] + '[' + datas[26]+ "] " +
		                		  datas[27] + '[' + datas[28]+ ']';		                  
		                  System.out.println(sell);
		                  System.out.println(buy);
		            } finally {
		                response1.close();
		            }
	            }	            
	        } finally {
	            httpclient.close();
	        }
	    }


}
