package curso.cap.springboot.musicos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import curso.cap.springboot.anotaciones.ConnectionManager;
import curso.cap.springboot.anotaciones.Vigilado;
import curso.cap.springboot.excepciones.InstrumentoRotoException;
import curso.cap.springboot.instrumentos.Instrumento;
import lombok.Data;

@Component
@Data

public class Solista extends Musico {

	@Autowired
	@Qualifier("tambor")
	private Instrumento instrumento;

	private Connection conection;

	@Override
	@Vigilado
	@ConnectionManager
	public void tocar() throws InstrumentoRotoException {
		System.out.println(getInstrumento().sonar());

		try {
			Statement statement = getConection().createStatement();
			ResultSet resultSet = statement.executeQuery("select descripcion from cargos");
			while (resultSet.next())
				System.out.println(resultSet.getString(1));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
