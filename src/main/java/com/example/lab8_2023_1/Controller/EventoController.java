package com.example.lab8_2023_1.Controller;

import com.example.lab8_2023_1.Entity.Evento;
import com.example.lab8_2023_1.Repository.EventoRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/evento")
public class EventoController {

    final EventoRepository eventoRepository;

    public  EventoController(EventoRepository eventoRepository){
        this.eventoRepository=eventoRepository;
    }

    @GetMapping("")
    public List<Evento> listar(){
        List<Evento> list = eventoRepository.findAll();
        return  list;
    }
}
