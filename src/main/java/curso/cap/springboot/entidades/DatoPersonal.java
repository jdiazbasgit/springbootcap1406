package curso.cap.springboot.entidades;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import lombok.Data;

@Entity
@Table(name = "datos_personales")
@Data
public class DatoPersonal {
	
	@Id
	private int Id;
	
	
	private String estadoCivil;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "hijos_id")
	@Fetch(FetchMode.SELECT)
	private Hijo hijo;
	

}
