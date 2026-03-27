package com.futapp.futappweb.controller;
import com.futapp.futappweb.entity.Equipo;
import com.futapp.futappweb.service.EquipoService;
import com.futapp.futappweb.service.FederacionService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
@Controller
@RequestMapping("/equipos")
public class EquipoController {
    private final EquipoService service;
    private final FederacionService federacionService;
    public EquipoController(EquipoService service, FederacionService federacionService) {
        this.service = service;
        this.federacionService = federacionService;
    }
    @GetMapping
    public String listar(Model model) {
        model.addAttribute("equipos", service.listar());
        return "equipo/lista";
    }
    @GetMapping("/nuevo")
    public String nuevo(Model model) {
        model.addAttribute("equipo", new Equipo());
        model.addAttribute("federaciones", federacionService.listar());
        return "equipo/formulario";
    }
    @PostMapping("/guardar")
    public String guardar(@ModelAttribute Equipo e) {
        service.guardar(e);
        return "redirect:/equipos";
    }
    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Integer id, Model model) {
        model.addAttribute("equipo", service.obtener(id));
        model.addAttribute("federaciones", federacionService.listar());
        return "equipo/formulario";
    }
    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable Integer id) {
        service.eliminar(id);
        return "redirect:/equipos";
    }
}
