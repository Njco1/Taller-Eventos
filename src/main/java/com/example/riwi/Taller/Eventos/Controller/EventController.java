package com.example.riwi.Taller.Eventos.Controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.riwi.Taller.Eventos.Entities.Events;
import com.example.riwi.Taller.Eventos.Services.EventService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/events")
public class EventController {
    @Autowired
    private EventService eventoService;

    @PostMapping
    public ResponseEntity<Events> crearEvento(@Valid @RequestBody Events evento) {
        return ResponseEntity.ok(eventoService.crearEvento(evento));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Events> obtenerEventoPorId(@PathVariable String id) {
        Optional<Events> evento = eventoService.obtenerEventoPorId(id);
        return evento.map(ResponseEntity::ok)
                     .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public Page<Events> obtenerTodosLosEventos(@RequestParam(defaultValue = "0") int page,
                                               @RequestParam(defaultValue = "10") int size) {
        Pageable pageable = PageRequest.of(page, size);
        return eventoService.obtenerTodosLosEventos(pageable);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Events> actualizarEvento(@PathVariable String id,
                                                   @Valid @RequestBody Events evento) {
        return ResponseEntity.ok(eventoService.actualizarEvento(id, evento));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarEvento(@PathVariable String id) {
        eventoService.eliminarEvento(id);
        return ResponseEntity.noContent().build();
    }
}
