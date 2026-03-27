package com.futapp.futappweb.controller;
import com.futapp.futappweb.entity.Entrenador;
import com.futapp.futappweb.service.EntrenadorService;
import com.futapp.futappweb.service.EquipoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
@Controller
@RequestMapping("/entrenadores")
public class EntrenadorController {
    private final EntrenadorService service;
    private final EquipoService equipoService;
    public EntrenadorController(EntrenadorService service, EquipoService equipoService) {
        this.service = service;
        this.equipoService = equipoService;
    }
    @GetMapping
    public String listar(Model model) {
        model.addAttribute("entrenadores", service.listar());
        return "entrenador/lista";
    }
    @GetMapping("/nuevo")
    public String nuevo(Model model) {
        model.addAttribute("entrenador", new Entrenador());
        model.addAttribute("equipos", equipoService.listar());
        return "entrenador/formulario";
    }
    @PostMapping("/guardar")
    public String guardar(@ModelAttribute Entrenador e) {
        service.guardar(e);
        return "redirect:/entrenadores";
    }
    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Integer id, Model model) {
        model.addAttribute("entrenador", service.obtener(id));
        model.addAttribute("equipos", equipoService.listar());
        return "entrenador/formulario";
    }
    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable Integer id) {
        service.eliminar(id);
        return "redirect:/entrenadores";
    }
}
