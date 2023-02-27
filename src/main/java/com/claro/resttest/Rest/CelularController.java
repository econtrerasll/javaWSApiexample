package com.claro.resttest.Rest;

import com.claro.resttest.Entities.Celular;
import com.claro.resttest.ErrorHandlers.CelularNotFoundException;
import com.claro.resttest.Repository.CelularRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;


@RestController
public class CelularController {
    private final CelularRepository repository;

    CelularController(CelularRepository repo) {
        this.repository = repo;
    }

    @GetMapping("/Celulares")
    ResponseEntity<List<Celular>> todos() {
        List<Celular> celulares = new ArrayList<>();
        repository.findAll().forEach(celulares::add);

        return ResponseEntity.ok(celulares);
    }

    @PostMapping("/Celulares")
    ResponseEntity<Celular> crearCelular(@Valid @RequestBody Celular nuevoCelular) {
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().build().toUri();
        Celular user = repository.save(nuevoCelular);

        return ResponseEntity.created(uri).body(user);
    }

    @PutMapping("/Celulares/{id}")
    ResponseEntity<Celular> actualizarCelular(@PathVariable Long id, @Valid @RequestBody Celular nuevoCelular) {
        Celular result = repository.findById(id).get();

        if (result != null) {
            result.setMarca(nuevoCelular.getMarca());
            result.setModelo(nuevoCelular.getModelo());
        } else {
            nuevoCelular.setId(id);
            result = repository.save(nuevoCelular);
        }

        return ResponseEntity.ok(result);
    }

    @GetMapping("/Celulares/{id}")
    ResponseEntity<Celular> buscarCelular(@PathVariable Long id) {
        return ResponseEntity.ok(findUser(id));

    }

    @DeleteMapping("/Celulares/{id}")
    ResponseEntity<Celular> deleteCelular(@PathVariable Long id) {
        Celular user = findUser(id);
        repository.delete(user);
        return ResponseEntity.noContent().build();
    }

    private Celular findUser(Long id) {
        Celular Celular = repository.findById(id).orElseThrow(() -> new CelularNotFoundException(id));
        return Celular;
    }
}
