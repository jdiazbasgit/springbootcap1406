package curso.cap.springboot.batch;

import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.List;

import org.springframework.batch.item.ItemWriter;

public class CursoWriter implements ItemWriter<List<Integer>>{

	@Override
	public void write(List<? extends List<Integer>> items) throws Exception {
		try (PrintWriter pw= new PrintWriter(new FileOutputStream("resultado.txt"))){
			for (List<Integer> numero : items) {
				pw.println(numero);
			}
			pw.flush();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
