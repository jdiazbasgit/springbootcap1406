package curso.cap.springboot.entidades;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "hijos")
@Data
public class Hijo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int id;
	int chicos;
	int chicas;

}
