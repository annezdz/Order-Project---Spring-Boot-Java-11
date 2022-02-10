package com.educandoweb.course.services;

import com.educandoweb.course.entities.User;
import com.educandoweb.course.repositories.UserRepository;
import com.educandoweb.course.services.exceptions.DatabaseException;
import com.educandoweb.course.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User findById(Long id) {
        Optional<User> obj =  userRepository.findById(id);
        return obj.orElseThrow(() -> new ResourceNotFoundException(id)); // o método get lança uma e
    }

    public User insert(User obj) {
        return userRepository.save(obj);
    }

    public void delete(Long id) {
        try {
            userRepository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new ResourceNotFoundException(id);
        } catch (DataIntegrityViolationException exception) {
            throw new DatabaseException(exception.getMessage());
        }
    }
    public User update(Long id, User obj) {
        //Com o getOne ele instancia o usuário mas não vai para o DB,
        // ele apenas passa a ser monitorado com o JPA. É melhor usar o getOne do que o findById, que
        //vai no banco de dados e tras o objeto para a gente. O getOne apenas prepara o objeto monitorado
        //para efetuarmos operações com o DB, é mais eficiente

        User entity = userRepository.getOne(id);
        updateData(entity, obj);
        return userRepository.save(entity);
    }

    private void updateData(User entity, User obj) {
        entity.setName(obj.getName());
        entity.setEmail(obj.getEmail());
        entity.setPhone(obj.getPhone());
    }


}
