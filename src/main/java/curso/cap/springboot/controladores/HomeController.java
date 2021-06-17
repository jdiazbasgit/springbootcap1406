package curso.cap.springboot.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import curso.cap.springboot.beans.Login;
import curso.cap.springboot.entidades.Usuario;
import curso.cap.springboot.repositorios.UsuarioCRUDRepository;
import lombok.Data;

@Controller
@Data
public class HomeController {
	
	@Autowired
	private UsuarioCRUDRepository usarioCRUDRepositury;
	
	@RequestMapping("/")
	public String home() {
		return "home";
	}
	
	@RequestMapping("/login")
	public ModelAndView login() {
		ModelAndView modelAndView= new ModelAndView("login");
		Login login= new Login();
		login.setUsuario("federico");
		modelAndView.addObject("login",login );
		return modelAndView;
	}
	
	@RequestMapping(value="/verLogin",method = RequestMethod.POST)
	public ModelAndView verLogin(Login login) {
		
		ModelAndView modelAndView=new ModelAndView();
		Usuario usuario= getUsarioCRUDRepositury().findByUsername(login.getUsuario());
		if(usuario==null) {
			modelAndView.setViewName("ko");
			return modelAndView;
		}
		BCryptPasswordEncoder encoder= new BCryptPasswordEncoder(4);
		
		if(login.getUsuario().equals(usuario.getUsername()) && encoder.matches(login.getClave(), usuario.getPassword()))
				modelAndView.setViewName("ok");
		else
			modelAndView.setViewName("ko");
		return modelAndView;
				
	}
	
	@RequestMapping("/mayusculas")
	public ModelAndView mayusculas(@RequestParam String texto) {
		
		ModelAndView modelAndView= new ModelAndView("mayusculas");
		
		String salida="Has escrito "+texto.toUpperCase()+" y tiene "+texto.length()+" letras";
		
		modelAndView.addObject("respuesta", salida);
		
		
		return modelAndView;
	}
	
	@RequestMapping("/mayusculas/{texto}")
	public ModelAndView mayusculasPathVariable(@PathVariable String texto) {
		
		ModelAndView modelAndView= new ModelAndView("mayusculas");
		
		String salida="Has escrito "+texto.toUpperCase()+" y tiene "+texto.length()+" letras en pathVariable";
		
		modelAndView.addObject("respuesta", salida);
		
		
		return modelAndView;
	}
	
	
	

}
