package com.educandoweb.course.resources;

import com.educandoweb.course.entities.User;
import com.educandoweb.course.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

    /**
     * Camada de Recursos (rest controllers)
     * Dependem da camada de serviço que por sua vez depende dos repositories
     * ResponseEntity = retorna um tipo específico para respostas de requisições web
     * Maven - ferramenta de gerenciamento de dependências e build do Java.
     * JPA - ferramenta de mapeamento objeto relacional padrão do Java que faz a conversão entre o modelo
     * orientado a objetos e o paradigma relacional.
     *
     * */

    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<List<User>> findAll() {
        List<User> list = userService.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<User> findById(@PathVariable Long id) {
        User obj = userService.findById(id);
        return ResponseEntity.ok().body(obj);
    }

}
