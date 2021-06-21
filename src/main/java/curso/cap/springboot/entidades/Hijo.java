package curso.cap.springboot.entidades;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.rest.core.annotation.RestResource;

import lombok.Data;

@Entity
@Table(name = "hijos")
@Data
@RestResource(rel = "hijos",path ="/cap/hijos")
public class Hijo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int id;
	int chicos;
	int chicas;

}
