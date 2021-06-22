package curso.cap.springboot.batch;

import java.util.ArrayList;
import java.util.List;

import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import curso.cap.springboot.entidades.Hijo;
import curso.cap.springboot.repositorios.HijoCRUDRepository;
import lombok.Data;

@Component
@Data
public class CursoReader implements ItemReader<List<String>> {
	
	@Autowired
	private HijoCRUDRepository repository;
	
	boolean fin=false;

	@Override
	public List<String> read() throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {
		if(!fin) {
		Iterable<Hijo>  hijos=getRepository().findAll();
		List<String> salida= new ArrayList<String>();
		for (Hijo hijo : hijos) {
			salida.add(String.valueOf(hijo.getChicos()+";"+hijo.getChicas()));
		}
		
		
			fin=true;
			return salida;
		}
		return null;
	}

}
