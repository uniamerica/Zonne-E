package br.com.zonne.api.controllers;

import br.com.zonne.api.models.DistrictModel;
import br.com.zonne.api.repositories.DistrictRepository;
import br.com.zonne.api.services.DistrictService;
import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/district")
public class DistrictController {

    @Autowired
    private DistrictService service;
    private DistrictRepository repository;

    @GetMapping
    public ResponseEntity<List<DistrictModel>> findAll() {
        List<DistrictModel> list = service.findAll();
        return ResponseEntity.ok(list);
    }

    @PostMapping
    public ResponseEntity<DistrictModel> insert(@RequestBody DistrictModel entity) {
        try {
            DistrictModel obj = service.insert(entity);
            URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                    .buildAndExpand(obj.getIdDistrict()).toUri();
            return ResponseEntity.created(uri).body(obj);
        } catch (ServiceException e) {
            return ResponseEntity.unprocessableEntity().build();
        }
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<DistrictModel> findById(@PathVariable String id) {
        return ResponseEntity.ok(service.findById(id));
    }
}