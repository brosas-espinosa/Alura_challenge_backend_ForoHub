package com.forohub.service;

import com.forohub.model.Topico;
import com.forohub.repository.TopicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TopicoService {

    private final TopicoRepository topicoRepository;

    @Autowired
    public TopicoService(TopicoRepository topicoRepository) {
        this.topicoRepository = topicoRepository;
    }

    // Crear un nuevo tópico
    public Topico crearTopico(Topico topico) {
        // Validar si el tópico ya existe (por título y mensaje)
        if (topicoRepository.existsByTituloAndMensaje(topico.getTitulo(), topico.getMensaje())) {
            throw new IllegalArgumentException("El tópico con el mismo título y mensaje ya existe.");
        }
        return topicoRepository.save(topico);
    }

    // Obtener todos los tópicos
    public List<Topico> obtenerTodosTopicos() {
        return topicoRepository.findAll();
    }

    // Obtener un tópico específico
    public Topico obtenerTopicoPorId(Long id) {
        Optional<Topico> topico = topicoRepository.findById(id);
        return topico.orElse(null); // Retorna el tópico si lo encuentra, o null si no lo encuentra.
    }

    // Actualizar un tópico
    public Topico actualizarTopico(Long id, Topico topico) {
        Optional<Topico> topicoExistente = topicoRepository.findById(id);
        if (topicoExistente.isPresent()) {
            topico.setId(id);
            return topicoRepository.save(topico);
        }
        return null;
    }

    // Eliminar un tópico
    public boolean eliminarTopico(Long id) {
        Optional<Topico> topicoExistente = topicoRepository.findById(id);
        if (topicoExistente.isPresent()) {
            topicoRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
