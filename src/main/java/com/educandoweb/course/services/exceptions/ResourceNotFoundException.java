package com.educandoweb.course.services.exceptions;

import org.springframework.http.ResponseEntity;

//subclasse do Runtime Exception (não obriga a trata-la)
public class ResourceNotFoundException extends RuntimeException{

    private static final Long serialVersionUID = 1L;

    //recebe o id do objeto que tentamos encontrar (mas não encontramos)
    public ResourceNotFoundException(Object id) {
        super("Resource not found. Id " + id );
    }


}
