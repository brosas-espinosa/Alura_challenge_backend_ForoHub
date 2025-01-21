package com.forohub.controller;

import com.forohub.model.Topico;
import com.forohub.service.TopicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/topicos")
@Validated
public class TopicoController {

    private final TopicoService topicoService;

    @Autowired
    public TopicoController(TopicoService topicoService) {
        this.topicoService = topicoService;
    }

    // Crear un nuevo tópico
    @PostMapping
    public ResponseEntity<Topico> crearTopico(@Valid @RequestBody Topico topico) {
        Topico topicoCreado = topicoService.crearTopico(topico);
        return new ResponseEntity<>(topicoCreado, HttpStatus.CREATED);
    }

    // Obtener todos los tópicos
    @GetMapping
    public ResponseEntity<List<Topico>> obtenerTodosTopicos() {
        List<Topico> topicos = topicoService.obtenerTodosTopicos();
        return new ResponseEntity<>(topicos, HttpStatus.OK);
    }

    // Obtener un tópico específico
    @GetMapping("/{id}")
    public ResponseEntity<Topico> obtenerTopicoPorId(@PathVariable Long id) {
        Topico topico = topicoService.obtenerTopicoPorId(id);
        return topico != null ? new ResponseEntity<>(topico, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    // Actualizar un tópico
    @PutMapping("/{id}")
    public ResponseEntity<Topico> actualizarTopico(@PathVariable Long id, @Valid @RequestBody Topico topico) {
        Topico topicoActualizado = topicoService.actualizarTopico(id, topico);
        return topicoActualizado != null ? new ResponseEntity<>(topicoActualizado, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    // Eliminar un tópico
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarTopico(@PathVariable Long id) {
        boolean eliminado = topicoService.eliminarTopico(id);
        return eliminado ? new ResponseEntity<>(HttpStatus.NO_CONTENT)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
