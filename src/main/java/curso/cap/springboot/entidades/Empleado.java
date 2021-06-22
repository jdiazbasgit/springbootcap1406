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

import lombok.Data;

@Entity
@Table(name = "empleados")
@Data
public class Empleado {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private int id;
	
	private String nombre;
	
	private String dni;
	
	private String telefono;
	
	private GregorianCalendar fechaNacimiento;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "datos_laborales_id")
	@Fetch(FetchMode.JOIN)
	private DatoLaboral datoLaboral;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "datos_personales_id")
	@Fetch(FetchMode.JOIN)
	private DatoPersonal datoPersonal;

}
