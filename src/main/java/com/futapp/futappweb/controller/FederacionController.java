package com.futapp.futappweb.controller;
import com.futapp.futappweb.entity.Federacion;
import com.futapp.futappweb.service.FederacionService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
@Controller
@RequestMapping("/federaciones")
public class FederacionController {
    private final FederacionService service;
    public FederacionController(FederacionService service) { this.service = service; }

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("federaciones", service.listar());
        return "federacion/lista";
    }
    @GetMapping("/nuevo")
    public String nuevo(Model model) {
        model.addAttribute("federacion", new Federacion());
        return "federacion/formulario";
    }
    @PostMapping("/guardar")
    public String guardar(@ModelAttribute Federacion f) {
        service.guardar(f);
        return "redirect:/federaciones";
    }
    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Integer id, Model model) {
        model.addAttribute("federacion", service.obtener(id));
        return "federacion/formulario";
    }
    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable Integer id) {
        service.eliminar(id);
        return "redirect:/federaciones";
    }
}
