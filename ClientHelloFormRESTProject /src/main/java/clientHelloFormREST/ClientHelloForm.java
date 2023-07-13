package clientHelloFormREST;

//import java.util.*;
import jakarta.ws.rs.client.*;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.core.MediaType;
import org.glassfish.jersey.client.*;
public class ClientHelloForm 
{
	
	public static void main(String[] args)
	{
		String url = "http://localhost:8080/WebHelloFormRESTProject/rest/WebHelloForm";
		ClientConfig config = new ClientConfig();
		Client client  = ClientBuilder.newClient(config);
		WebTarget target =  client.target(url);
		
		String response = target.request()
				.accept(MediaType.TEXT_PLAIN)
				.get(String.class);
		System.out.println(response +"\n");
		
		
		
		target =  client.target(url).path("/addName")
							.queryParam("Name", "Ali")
							.queryParam("Year", "2015");
		
		response = target.request()
				.accept(MediaType.TEXT_HTML)
				.get()
				.readEntity(String.class);
		
		System.out.println(response + "\n");
		
		
		target =  client.target(url).path("/updateName")
				.queryParam("Name", "Bob")
				.queryParam("Year", "2015");

		response = target.request()
			.accept(MediaType.TEXT_HTML)
			.put(Entity.text(""))
			.readEntity(String.class);
		
		System.out.println(response + "\n");
		
		
		target =  client.target(url).path("/removeName")
				.queryParam("Name", "Bob")
				.queryParam("Year", "2015");

		response = target.request()
			.accept(MediaType.TEXT_HTML)
			.delete()
			.readEntity(String.class);
		
		System.out.println(response + "\n");
		
	}

}
