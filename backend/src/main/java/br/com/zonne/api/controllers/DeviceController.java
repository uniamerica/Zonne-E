package br.com.zonne.api.controllers;

import br.com.zonne.api.models.DeviceModel;
import br.com.zonne.api.repositories.DeviceRepository;
import br.com.zonne.api.services.DeviceService;
import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;


import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/device")
public class DeviceController {

        @Autowired
        private DeviceService service;
        private DeviceRepository repository;

        @GetMapping
        public ResponseEntity<List<DeviceModel>> findAll() {
                List<DeviceModel> list = service.findAll();
                return ResponseEntity.ok(list);
        }

        @PostMapping
        public ResponseEntity<DeviceModel> insert(@RequestBody DeviceModel entity) {
                try {
                        DeviceModel obj = service.insert(entity);
                        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                                .buildAndExpand(obj.getIdDevice()).toUri();
                        return ResponseEntity.created(uri).body(obj);
                } catch (ServiceException e) {
                        return ResponseEntity.unprocessableEntity().build();
                }
        }

        @GetMapping(path = "/{id}")
        public ResponseEntity<DeviceModel> findById(@PathVariable Long id) {
                return ResponseEntity.ok(service.findById(id));
        }
}

