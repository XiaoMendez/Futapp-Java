package com.futapp.futappweb.controller;
import com.futapp.futappweb.entity.Jugador;
import com.futapp.futappweb.service.JugadorService;
import com.futapp.futappweb.service.EquipoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.Collections;

@Controller
@RequestMapping("/jugadores")
public class JugadorController {
    private final JugadorService service;
    private final EquipoService equipoService;

    public JugadorController(JugadorService service, EquipoService equipoService) {
        this.service = service;
        this.equipoService = equipoService;
    }

    @GetMapping
    public String listar(Model model) {
        try { model.addAttribute("jugadores", service.listar()); }
        catch (Exception e) { model.addAttribute("jugadores", Collections.emptyList()); }
        return "jugador/lista";
    }

    @GetMapping("/nuevo")
    public String nuevo(Model model) {
        model.addAttribute("jugador", new Jugador());
        try { model.addAttribute("equipos", equipoService.listar()); }
        catch (Exception e) { model.addAttribute("equipos", Collections.emptyList()); }
        return "jugador/formulario";
    }

    @PostMapping("/guardar")
    public String guardar(@ModelAttribute Jugador j) {
        service.guardar(j);
        return "redirect:/jugadores";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Integer id, Model model) {
        model.addAttribute("jugador", service.obtener(id));
        try { model.addAttribute("equipos", equipoService.listar()); }
        catch (Exception e) { model.addAttribute("equipos", Collections.emptyList()); }
        return "jugador/formulario";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable Integer id) {
        service.eliminar(id);
        return "redirect:/jugadores";
    }
}