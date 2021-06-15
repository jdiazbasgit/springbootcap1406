package curso.cap.springboot.configuracion;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import curso.cap.springboot.instrumentos.Tambor;
import curso.cap.springboot.musicos.Solista;

@Configuration
@ComponentScan("curso.cap.springboot")
public class Configuracion {

	
	@Bean
	public Solista solista() {
		Solista solista= new Solista();
		solista.setInstrumento(tambor());
		return solista;
	}
	
	@Bean
	public Tambor tambor() {
		
		Tambor tambor= new Tambor();
		tambor.setSonido(getSonido());
		return tambor;
	}
	
	
	public String getSonido() {
		return "federico toca el tambor";
	}
	
}
