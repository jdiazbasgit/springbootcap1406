package curso.cap.springboot.servicios;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import curso.cap.springboot.entidades.Rol;
import curso.cap.springboot.entidades.Usuario;
import curso.cap.springboot.repositorios.UsuarioCRUDRepository;
import lombok.Data;

@Service
@Data
public class UserDetailCursoService implements UserDetailsService{

	@Autowired
	private UsuarioCRUDRepository repository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
	
		Usuario usuario= getRepository().findByUsername(username);
		
		Set<GrantedAuthority> roles= new HashSet<GrantedAuthority>();
		for (Rol rol : usuario.getRoles()) {
			roles.add(new SimpleGrantedAuthority(rol.getRol()));
			
		}
		
		
		return new User(usuario.getUsername(),usuario.getPassword(),usuario.isEnabled(),true,true,true,roles);
	}
	
	

}
