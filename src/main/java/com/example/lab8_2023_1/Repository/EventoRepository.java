package com.example.lab8_2023_1.Repository;

import com.example.lab8_2023_1.Entity.Evento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RestController;

@Repository
public interface EventoRepository extends JpaRepository<Evento, Integer> {
}
