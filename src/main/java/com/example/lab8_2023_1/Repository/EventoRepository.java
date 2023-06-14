package com.example.lab8_2023_1.Repository;

import com.example.lab8_2023_1.Entity.Evento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@Repository
public interface EventoRepository extends JpaRepository<Evento, Integer> {

    @Query(nativeQuery = true, value = "SELECT e.id, e.nombre, e.descripcion,e.idLocal, e.fecha,t.id as ticketsId, t.cantidad, t.precio  From evento e Join tipo_ticket_evento t on e.id = t.idEvento where idEvento = ?1 \n")
    Optional<Evento> eventosTickets(Integer id);


}
