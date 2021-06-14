package curso.cap.springboot.instrumentos;

public class Instrumento implements InstrumentoInteface{

	private String sonido;
	
	public String sonar() {
		
		return getSonido();
	}

	public String getSonido() {
		return sonido;
	}

	public void setSonido(String sonido) {
		this.sonido = sonido;
	}

}
