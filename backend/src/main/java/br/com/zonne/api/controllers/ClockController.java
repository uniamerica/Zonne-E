package br.com.zonne.api.controllers;

import br.com.zonne.api.models.ClockModel;
import br.com.zonne.api.models.DeviceModel;
import br.com.zonne.api.repositories.ClockRepository;
import br.com.zonne.api.repositories.DeviceRepository;
import br.com.zonne.api.services.ClockService;
import br.com.zonne.api.services.DeviceService;
import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;


import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/clock")
public class ClockController {

    @Autowired
    private ClockService service;
    private ClockRepository repository;

    @GetMapping
    public ResponseEntity<List<ClockModel>> findAll() {
        List<ClockModel> list = service.findAll();
        return ResponseEntity.ok(list);
    }

    @PostMapping
    public ResponseEntity<ClockModel> insert(@RequestBody ClockModel entity) {
        try {
            ClockModel obj = service.insert(entity);
            URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                    .buildAndExpand(obj.getIdClock()).toUri();
            return ResponseEntity.created(uri).body(obj);
        } catch (ServiceException e) {
            return ResponseEntity.unprocessableEntity().build();
        }
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<ClockModel> findById(@PathVariable Long id) {
        return ResponseEntity.ok(service.findById(id));
    }
}
