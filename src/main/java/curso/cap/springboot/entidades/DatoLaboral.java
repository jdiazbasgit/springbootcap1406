package curso.cap.springboot.entidades;

import java.util.GregorianCalendar;

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
@Table(name = "datos_laborales")
@Data
public class DatoLaboral extends ResourceSupport{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private int idDatoLaboral;
	
	private int salario;
	
	private GregorianCalendar fechaAlta;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "cargos_id")
	@Fetch(FetchMode.SELECT)
	private Cargo cargo;

}



