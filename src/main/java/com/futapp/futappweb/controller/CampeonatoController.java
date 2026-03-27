package com.futapp.futappweb.controller;
import com.futapp.futappweb.entity.Campeonato;
import com.futapp.futappweb.service.CampeonatoService;
import com.futapp.futappweb.service.FederacionService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
@Controller
@RequestMapping("/campeonatos")
public class CampeonatoController {
    private final CampeonatoService service;
    private final FederacionService federacionService;
    public CampeonatoController(CampeonatoService service, FederacionService federacionService) {
        this.service = service;
        this.federacionService = federacionService;
    }
    @GetMapping
    public String listar(Model model) {
        model.addAttribute("campeonatos", service.listar());
        return "campeonato/lista";
    }
    @GetMapping("/nuevo")
    public String nuevo(Model model) {
        model.addAttribute("campeonato", new Campeonato());
        model.addAttribute("federaciones", federacionService.listar());
        return "campeonato/formulario";
    }
    @PostMapping("/guardar")
    public String guardar(@ModelAttribute Campeonato c) {
        service.guardar(c);
        return "redirect:/campeonatos";
    }
    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Integer id, Model model) {
        model.addAttribute("campeonato", service.obtener(id));
        model.addAttribute("federaciones", federacionService.listar());
        return "campeonato/formulario";
    }
    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable Integer id) {
        service.eliminar(id);
        return "redirect:/campeonatos";
    }
}
