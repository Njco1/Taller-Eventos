package com.example.riwi.Taller.Eventos.Services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.example.riwi.Taller.Eventos.Entities.Events;
import com.example.riwi.Taller.Eventos.Repositories.EventRepository;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

public class EventService {
    
    @Autowired
    private EventRepository eventoRepository;

    public Events crearEvento(Events evento) {
        return eventoRepository.save(evento);
    }

    public Optional<Events> obtenerEventoPorId(String id) {
        return eventoRepository.findById(id);
    }

    public Page<Events> obtenerTodosLosEventos(Pageable pageable) {
        return eventoRepository.findAll(pageable);
    }

    public Events actualizarEvento(String id, Events evento) {
        return eventoRepository.findById(id)
                .map(existingEvento -> {
                    existingEvento.setNombre(evento.getNombre());
                    existingEvento.setFecha(evento.getFecha());
                    existingEvento.setUbicacion(evento.getUbicacion());
                    existingEvento.setCapacidad(evento.getCapacidad());
                    return eventoRepository.save(existingEvento);
                })
                .orElseThrow(() -> new RuntimeException("Evento no encontrado"));
    }

    public void eliminarEvento(String id) {
        eventoRepository.deleteById(id);
    }
}
