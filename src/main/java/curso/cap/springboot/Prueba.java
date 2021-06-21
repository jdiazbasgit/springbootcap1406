package curso.cap.springboot;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class Prueba {

	public static void main(String[] args) {
		
		BCryptPasswordEncoder encoder= new BCryptPasswordEncoder(4);
	
		for (int i = 0; i < 10; i++) {
			System.out.println(encoder.encode("123456"));
		}
		
		System.out.println(encoder.matches("1234","$2a$04$nOPQU0dZaSpvvjKl63unkO4DsNGiWXQOQTJULJB33fkh9A96K/38G"));

	}

}
