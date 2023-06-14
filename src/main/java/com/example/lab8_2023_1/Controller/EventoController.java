package com.example.lab8_2023_1.Controller;

import com.example.lab8_2023_1.Entity.Evento;
import com.example.lab8_2023_1.Repository.EventoRepository;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

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

    @GetMapping("/{id}")
    public ResponseEntity<HashMap<String,Object >>  obtenerEventoPorId(@PathVariable("id") String idStr) {
        HashMap<String, Object> responseJson = new HashMap<>();

        try {
            Optional<Evento> optionalEvento = eventoRepository.findById(Integer.parseInt(idStr));
            if (optionalEvento.isPresent()) {
                responseJson.put("evento", optionalEvento.get());
                responseJson.put("resultado", "exitoso");
                return ResponseEntity.ok(responseJson);
            } else {
                responseJson.put("msg", "Evento no encontrado");

            }
        } catch (NumberFormatException e) {
            responseJson.put("msg", "El ID debe ser un numero entero positivo");
        }
        responseJson.put("resultado", "Falla");
        return ResponseEntity.badRequest().body(responseJson);
    }

    @PostMapping("")
    public ResponseEntity<HashMap<String, Object>> guardarEvento(
            @RequestBody Evento evento,
            @RequestParam(value = "fetchId", required = false) boolean fetchId) {

        HashMap<String, Object> responseJson = new HashMap<>();
        if(fetchId){
            responseJson.put("id ya creado",evento.getId());
        }
        eventoRepository.save(evento);

        int id = evento.getId();
        responseJson.put("estado", "creado");
        responseJson.put("id creado", id);
        return ResponseEntity.status(HttpStatus.CREATED).body(responseJson);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<HashMap<String,String>> gestionException(HttpServletRequest request){
        HashMap<String,String> responseMap = new HashMap<>();
        if(request.getMethod().equals("POST")){
            responseMap.put("msg","Debe enviar un evento");

            responseMap.put("estado","error");
        }
        return ResponseEntity.badRequest().body(responseMap);
    }


}
