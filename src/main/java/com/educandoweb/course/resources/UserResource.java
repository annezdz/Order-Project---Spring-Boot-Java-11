package com.educandoweb.course.resources;

import com.educandoweb.course.entities.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

    /**
     * Camada de Recursos (rest controllers)
     * Dependem da camada de serviço que por sua vez depende dos repositories
     * ResponseEntity = retorna um tipo específico para respostas de requisições web
     * */

    @GetMapping
    public ResponseEntity<User> findAll() {
        User user = new User(1L,"Maria","maria@gmail.com","9999","12345");
        return ResponseEntity.ok().body(user);
    }

}
