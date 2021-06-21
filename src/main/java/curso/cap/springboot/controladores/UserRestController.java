package curso.cap.springboot.controladores;


import java.util.Date;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import curso.cap.springboot.dtos.UserDto;
import curso.cap.springboot.entidades.Rol;
import curso.cap.springboot.entidades.Usuario;
import curso.cap.springboot.repositorios.UsuarioCRUDRepository;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.Data;

@RestController
@Data
public class UserRestController {


    @Autowired
    private UsuarioCRUDRepository repository;

    @PostMapping("/user")
    public UserDto gettoken(@RequestParam String username, @RequestParam String password){

        System.out.println("estoy dentro");
        UserDto salida= new UserDto();

        Usuario usuario=getRepository().findByUsername(username);

        BCryptPasswordEncoder encoder= new BCryptPasswordEncoder(4);

        if(usuario.getUsername().equals(username) &&  encoder.matches(password,usuario.getPassword())){

            String token=getToken(username,usuario.getRoles());
            salida.setToken(token);
            salida.setUser(username);
            salida.setRoles(usuario.getRoles());
        }




        return salida;
    }

    private String getToken(String username, Set<Rol> roles){
        String securityKey="liberty";

        String token= Jwts.builder().setId(securityKey).setSubject(username).claim("roles",roles).
                setIssuedAt(new Date(System.currentTimeMillis())).
                setExpiration(new Date(System.currentTimeMillis()+600000)).
                signWith(SignatureAlgorithm.HS512,securityKey.getBytes()).compact();
        return "Bearer "+token;
    }
}