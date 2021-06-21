package curso.cap.springboot.entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.springframework.hateoas.ResourceSupport;

import lombok.Data;

@Entity
@Table(name = "datos_personales")
@Data
public class DatoPersonal extends ResourceSupport{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private int idDatoPersonal;
	
	
	private String estadoCivil;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "hijos_id")
	@Fetch(FetchMode.JOIN)
	private Hijo hijo;
	

}
