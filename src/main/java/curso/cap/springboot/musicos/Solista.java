package curso.cap.springboot.musicos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import curso.cap.springboot.instrumentos.Instrumento;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

//@Component
@Data

public class Solista extends Musico {

	@Autowired
	@Qualifier("tambor")
	private Instrumento instrumento;
	
	@Override
	public void tocar() {
		System.out.println(getInstrumento().sonar());

	}
	
	


}
