import java.io.BufferedReader;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.validator.UrlValidator;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

import sun.net.www.URLConnection;

public class SimpleHttpPut { 
  public static void main(String[] args) {
    
	  String data = "message=123\n";
	  UrlValidator defaultValidator = new UrlValidator(); // default schemes
	  if (defaultValidator.isValid("http://www.apache.org")) {
	      System.out.println("valid");
	  }
	  if (!defaultValidator.isValid("http//www.oops.com")) {
	      System.out.println("INvalid");
	  }
	  
      try {

          // Send the request
          URL url = new URL("http://10.141.129.178:8888");
          java.net.URLConnection conn = url.openConnection();
          conn.setDoOutput(true);
          OutputStreamWriter writer = new OutputStreamWriter(conn.getOutputStream());

          //write parameters
          writer.write(data);

          writer.flush();
          writer.close();
          // Get the response
          StringBuffer answer = new StringBuffer();
          BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
          String line;
          while ((line = reader.readLine()) != null) {
              answer.append(line);
          }
         
          reader.close();

          //Output the response
          System.out.println(answer.toString());

      } catch (MalformedURLException ex) {
          ex.printStackTrace();
      } catch (IOException ex) {
          ex.printStackTrace();
      }

    
  }
} 

