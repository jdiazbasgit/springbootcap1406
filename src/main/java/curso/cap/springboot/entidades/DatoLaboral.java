package curso.cap.springboot.entidades;

import java.util.GregorianCalendar;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "datos_laborales")
@Data
public class DatoLaboral {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	private int salario;
	
	private GregorianCalendar fechaAlta;
	
	@ManyToOne
	@JoinColumn(name = "cargos_id")
	private Cargo cargo;

}



