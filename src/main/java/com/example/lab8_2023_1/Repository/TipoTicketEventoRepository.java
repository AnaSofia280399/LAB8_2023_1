package com.example.lab8_2023_1.Repository;

import com.example.lab8_2023_1.Entity.Evento;
import com.example.lab8_2023_1.Entity.TipoTicketEvento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TipoTicketEventoRepository extends JpaRepository<TipoTicketEvento, Integer> {
    @Query(nativeQuery = true, value = "SELECT * FROM lahaces.tipo_ticket_evento where idEvento = ?1 ")
    List<TipoTicketEvento> eventosTickets(Integer id);
}
