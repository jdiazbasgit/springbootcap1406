package curso.cap.springboot.teatros;

import curso.cap.springboot.instrumentos.Instrumento;
import curso.cap.springboot.musicos.Solista;

public class ConciertoSolista {

	public static void main(String[] args) {
	
		Instrumento instrumento= new Instrumento();
		instrumento.setSonido("pom ,pom, pom");
		Solista solista= new Solista();
		solista.setInstrumento(instrumento);
		solista.tocar();

	}

}
