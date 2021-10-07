package br.com.zonne.api.controllers;

import br.com.zonne.api.models.DealershipModel;
import br.com.zonne.api.repositories.DealershipRepository;
import br.com.zonne.api.services.DealershipService;
import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/dealership")
public class DealershipController {

    @Autowired
    private DealershipService service;
    private DealershipRepository repository;

    @GetMapping
    public ResponseEntity<List<DealershipModel>> findAll(){
        List<DealershipModel> list = service.findAll();
        return ResponseEntity.ok(list);
    }
//    @GetMapping(path = "/{name}")
//    public ResponseEntity<DealershipModel> findByDealershipName(@PathVariable String name){
//        return ResponseEntity.ok(service.findById(name));
//    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<DealershipModel> findById(@PathVariable Long id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @PostMapping
    public ResponseEntity<DealershipModel> insert(@RequestBody DealershipModel entity) {
        try {
            DealershipModel obj = service.insert(entity);
            URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                    .buildAndExpand(obj.getIdDealership()).toUri();
            return ResponseEntity.created(uri).body(obj);
        } catch (ServiceException e){
        return ResponseEntity.unprocessableEntity().build();
    }
}

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<String> deleteById(@PathVariable Long id ){
        service.deleteById(id);
        return ResponseEntity.ok("Dealership " + id + " deleted!");
    }
}

