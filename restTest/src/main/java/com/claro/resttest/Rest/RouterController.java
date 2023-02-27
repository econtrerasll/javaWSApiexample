package com.claro.resttest.Rest;

import com.claro.resttest.Entities.Router;
import com.claro.resttest.ErrorHandlers.RouterNotFoundException;
import com.claro.resttest.Repository.RouterRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;

@RestController
public class RouterController {
    private final RouterRepository repository;

    RouterController(RouterRepository repo) {
        this.repository = repo;
    }

    @GetMapping("/Routers")
    ResponseEntity<List<Router>> todos() {
        List<Router> routers = new ArrayList<>();
        repository.findAll().forEach(routers::add);

        return ResponseEntity.ok(routers);
    }

    @PostMapping("/Routers")
    ResponseEntity<Router> crearRouter(@Valid @RequestBody Router nuevoRouter) {
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().build().toUri();
        Router user = repository.save(nuevoRouter);

        return ResponseEntity.created(uri).body(user);
    }

    @PutMapping("/Routers/{id}")
    ResponseEntity<Router> actualizarRouter(@PathVariable Long id, @Valid @RequestBody Router nuevoRouter) {
        Router result = repository.findById(id).get();

        if (result != null) {
            result.setMarca(nuevoRouter.getMarca());
            result.setModelo(nuevoRouter.getModelo());
        } else {
            nuevoRouter.setId(id);
            result = repository.save(nuevoRouter);
        }

        return ResponseEntity.ok(result);
    }

    @GetMapping("/Routers/{id}")
    ResponseEntity<Router> buscarRouter(@PathVariable Long id) {
        return ResponseEntity.ok(findRouter(id));

    }

    @DeleteMapping("/Routers/{id}")
    ResponseEntity<Router> deleteRouter(@PathVariable Long id) {
        Router user = findRouter(id);
        repository.delete(user);
        return ResponseEntity.noContent().build();
    }

    private Router findRouter(Long id) {
        Router Router = repository.findById(id).orElseThrow(() -> new RouterNotFoundException(id));
        return Router;
    }

}