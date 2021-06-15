package curso.cap.springboot.aspectos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import com.mysql.cj.jdbc.Driver;

import curso.cap.springboot.musicos.Solista;

@Component
@Aspect
public class GestorDeConexiones {

	@Pointcut("execution(@curso.cap.springboot.anotaciones.ConnectionManager * *.*(..))")
	public void sujetador() {

	}
	
	@Around("sujetador()")
	public Object crearConexion(ProceedingJoinPoint joinPoint) throws SQLException {
		Object salida=null;
		Solista solista= (Solista) joinPoint.getTarget();
		try {
			DriverManager.registerDriver(new Driver());
			Connection conexion=DriverManager.getConnection("jdbc:mysql://localhost:3306/empleados?useSSL=false","curso","Cursocurso1;");
			solista.setConection(conexion);
			salida=joinPoint.proceed();
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			solista.getConection().close();
		}
		return salida;
	}
}
