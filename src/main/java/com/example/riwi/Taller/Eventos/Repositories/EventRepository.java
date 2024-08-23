package com.example.riwi.Taller.Eventos.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.riwi.Taller.Eventos.Entities.Events;

public interface EventRepository extends JpaRepository <Events, String> {
    
}
