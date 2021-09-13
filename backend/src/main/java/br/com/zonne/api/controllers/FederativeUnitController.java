package br.com.zonne.api.controllers;

import br.com.zonne.api.models.FederativeUnitModel;
import br.com.zonne.api.repositories.FederativeUnitRepository;
import br.com.zonne.api.services.FederativeUnitService;
import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/district")
public class FederativeUnitController {

    @Autowired
    private FederativeUnitService service;
    private FederativeUnitRepository repository;

    @GetMapping
    public ResponseEntity<List<FederativeUnitModel>> findAll(){
        List<FederativeUnitModel> list = service.findAll();
        return ResponseEntity.ok(list);
    }

    @PostMapping
    public ResponseEntity<FederativeUnitModel> insert(@RequestBody FederativeUnitModel entity) {
        try{
            FederativeUnitModel obj = service.insert(entity);
            URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                    .buildAndExpand(obj.getIdFederativeUnit()).toUri();
            return ResponseEntity.created(uri).body(obj);
        } catch (ServiceException e){
            return ResponseEntity.unprocessableEntity().build();
        }
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<FederativeUnitModel> findById(@PathVariable Long id) {
        return ResponseEntity.ok(service.findById(id));
    }
}
