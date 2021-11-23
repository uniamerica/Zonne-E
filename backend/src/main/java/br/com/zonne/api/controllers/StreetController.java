package br.com.zonne.api.controllers;

import br.com.zonne.api.models.StreetModel;
import br.com.zonne.api.repositories.StreetRepository;
import br.com.zonne.api.services.StreetService;
import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/street")
public class StreetController {

    @Autowired
    private StreetService service;
    private StreetRepository repository;

    @GetMapping
    public ResponseEntity<List<StreetModel>> findAll() {
        List<StreetModel> list = service.findAll();
        return ResponseEntity.ok(list);
    }

    @PostMapping
    public ResponseEntity<StreetModel> insert(@RequestBody StreetModel entity) {
        try {
            StreetModel obj = service.insert(entity);
            URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                    .buildAndExpand(obj.getIdStreet()).toUri();
            return ResponseEntity.created(uri).body(obj);
        } catch (ServiceException e) {
            return ResponseEntity.unprocessableEntity().build();
        }
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<StreetModel> findById(@PathVariable Long id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<String> deleteById(@PathVariable Long id ){
        service.deleteById(id);
        return ResponseEntity.ok("Street " + id + " deleted!");
    }
}