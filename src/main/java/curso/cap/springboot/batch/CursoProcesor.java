package curso.cap.springboot.batch;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import org.springframework.batch.item.ItemProcessor;

public class CursoProcesor implements ItemProcessor<List<String>, List<Integer>> {

	@Override
	public List<Integer> process(List<String> item) throws Exception {
		List<Integer> salida= new ArrayList<Integer>();
		for (String string : item) {
			StringTokenizer st= new StringTokenizer(";");
			while(st.hasMoreTokens()) {
				salida.add(Integer.parseInt(st.nextToken()+Integer.parseInt(st.nextToken())));
			}
		}
		return salida;
	}

}
