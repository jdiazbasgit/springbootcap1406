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
@Table(name = "empleados")
@Data
public class Empleado {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	private String nombre;
	
	private String dni;
	
	private String telefono;
	
	private GregorianCalendar fechaNacimiento;
	
	@ManyToOne
	@JoinColumn(name = "datos_laborales_id")
	private DatoLaboral datoLaboral;
	
	@ManyToOne
	@JoinColumn(name = "datos_personales_id")
	private DatoPersonal datoPersonal;

}
