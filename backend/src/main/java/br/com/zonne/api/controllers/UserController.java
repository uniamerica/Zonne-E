package br.com.zonne.api.controllers;

import br.com.zonne.api.models.UserModel;
import br.com.zonne.api.repositories.UserRepository;
import br.com.zonne.api.services.UserService;
import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private UserService service;

    @GetMapping
    public ResponseEntity<List<UserModel>> findAll(){
        List<UserModel> list = service.findAll();
        return ResponseEntity.ok(list);
    }

    @GetMapping(path = "/{cpf}")
    public ResponseEntity<UserModel> findByCpf(@PathVariable String cpf) {
        return ResponseEntity.ok(service.findByCpf(cpf));
    }

    @PostMapping
    public ResponseEntity<UserModel> insert(@RequestBody UserModel entity) {
        try {
            UserModel obj = service.insert(entity);
            URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                    .buildAndExpand(obj.getCpf()).toUri();
            return ResponseEntity.created(uri).body(obj);
        } catch (ServiceException e) {
            return ResponseEntity.unprocessableEntity().build();
        }
    }
}
