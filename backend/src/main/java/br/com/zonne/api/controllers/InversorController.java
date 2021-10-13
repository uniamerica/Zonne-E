package br.com.zonne.api.controllers;

import br.com.zonne.api.models.DeviceModel;
import br.com.zonne.api.models.InversorModel;
import br.com.zonne.api.repositories.DeviceRepository;
import br.com.zonne.api.repositories.InversorRepository;
import br.com.zonne.api.services.DeviceService;
import br.com.zonne.api.services.InversorService;
import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;


import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/inversor")
public class InversorController {

    @Autowired
    private InversorService service;
    private InversorRepository repository;

    @GetMapping
    public ResponseEntity<List<InversorModel>> findAll() {
        List<InversorModel> list = service.findAll();
        return ResponseEntity.ok(list);
    }

    @PostMapping
    public ResponseEntity<InversorModel> insert(@RequestBody InversorModel entity) {
        try {
            InversorModel obj = service.insert(entity);
            URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                    .buildAndExpand(obj.getIdInversor()).toUri();
            return ResponseEntity.created(uri).body(obj);
        } catch (ServiceException e) {
            return ResponseEntity.unprocessableEntity().build();
        }
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<InversorModel> findById(@PathVariable Long id) {
        return ResponseEntity.ok(service.findById(id));
    }
}
