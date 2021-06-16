package curso.cap.springboot.entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "cargos")
@Data
public class Cargo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	
	//@GeneratedValue(strategy = GenerationType.SEQUENCE)
	//@SequenceGenerator(name = "nombre de secuencia")
	private Integer id;
	
	
	private String descripcion;

}
