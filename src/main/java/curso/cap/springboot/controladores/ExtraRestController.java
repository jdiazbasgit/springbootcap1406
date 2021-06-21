package curso.cap.springboot.controladores;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URL;
import java.util.List;

import org.apache.tomcat.util.json.JSONParser;
import org.apache.tomcat.util.json.ParseException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExtraRestController {

	
	@GetMapping("/paises")
	public String getPaisesByName(){
		
		
		try {
			
			InputStream inputStream= new URL("https://restcountries.eu/rest/v2/region/europe").openStream();
			InputStreamReader inputStreamReader= new InputStreamReader(inputStream);
			BufferedReader bufferedReader= new BufferedReader(inputStreamReader);		
			JSONParser parser= new JSONParser(bufferedReader);
			
			for(Object obj:parser.list()) 
			System.out.println(obj);
			
			
		} catch (IOException | ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "a";
	}
}
