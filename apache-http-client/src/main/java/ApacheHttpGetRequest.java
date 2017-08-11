import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

public class ApacheHttpGetRequest
{
	public static void main(String[] args) throws Exception {
		DefaultHttpClient httpClient = new DefaultHttpClient();
		HttpGet get = new HttpGet("http://codeyeti.api.woodoo.co:8080/woodoo/shopping/doo-list?my_user_id=1&current_page_no=0&max_results=1000");
		get.addHeader("accept", "application/json");
		HttpResponse response = httpClient.execute(get);
		
		if(response.getStatusLine().getStatusCode() != 200)
		{
			throw new Exception("Status code is "+response.getStatusLine().getStatusCode());
		}
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
	
		String output;
		System.out.println("Output : ");
		
		while((output = reader.readLine()) != null)
		{
			System.out.println(output);
		}
	}
}
