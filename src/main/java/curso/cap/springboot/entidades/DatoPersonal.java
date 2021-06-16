package curso.cap.springboot.entidades;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "datos_personales")
@Data
public class DatoPersonal {
	
	@Id
	private int Id;
	
	
	private String estadoCivil;
	
	@ManyToOne
	@JoinColumn(name = "hijos_id")
	private Hijo hijo;
	

}
