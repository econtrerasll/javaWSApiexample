package com.claro.resttest.Rest;

import com.claro.resttest.Entities.Usuario;
import com.claro.resttest.ErrorHandlers.UsuarioNotFoundException;
import com.claro.resttest.Repository.UsuarioRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;

@RestController
public class UsuarioController {
    private final UsuarioRepository repository;

    UsuarioController(UsuarioRepository repo) {
        this.repository = repo;
    }

    @GetMapping("/Usuarios")
    ResponseEntity<List<Usuario>> todos() {
        List<Usuario> usuarios = new ArrayList<>();
        repository.findAll().forEach(usuarios::add);

        return ResponseEntity.ok(usuarios);
    }

    @PostMapping("/Usuarios")
    ResponseEntity<Usuario> crearUsuario(@Valid @RequestBody Usuario nuevoUsuario) {
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().build().toUri();
        Usuario user = repository.save(nuevoUsuario);

        return ResponseEntity.created(uri).body(user);
    }

    @PutMapping("/Usuarios/{id}")
    ResponseEntity<Usuario> actualizarUsuario(@PathVariable Long id, @Valid @RequestBody Usuario nuevoUsuario) {
        Usuario result = repository.findById(id).get();

        if (result != null) {
            result.setNombre(nuevoUsuario.getNombre());
            result.setApellido(nuevoUsuario.getApellido());
        } else {
            nuevoUsuario.setId(id);
            result = repository.save(nuevoUsuario);
        }

        return ResponseEntity.ok(result);
    }

    @GetMapping("/Usuarios/{id}")
    ResponseEntity<Usuario> buscarUsuario(@PathVariable Long id) {
        return ResponseEntity.ok(findUser(id));

    }

    @DeleteMapping("/Usuarios/{id}")
    ResponseEntity<Usuario> deleteUsuario(@PathVariable Long id) {
        Usuario user = findUser(id);
        repository.delete(user);
        return ResponseEntity.noContent().build();
    }

    private Usuario findUser(Long id) {
        Usuario usuario = repository.findById(id).orElseThrow(() -> new UsuarioNotFoundException(id));
        return usuario;
    }

}
