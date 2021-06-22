package curso.cap.springboot.dtos;


import java.util.Set;

import curso.cap.springboot.entidades.Rol;
import lombok.Data;

@Data
public class UserDto {


    private  String user;

    private String token;

    private Set<Rol> roles;
}