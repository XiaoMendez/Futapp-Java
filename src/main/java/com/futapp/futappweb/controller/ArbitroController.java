package com.futapp.futappweb.controller;
import com.futapp.futappweb.entity.Arbitro;
import com.futapp.futappweb.service.ArbitroService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
@Controller
@RequestMapping("/arbitros")
public class ArbitroController {
    private final ArbitroService service;
    public ArbitroController(ArbitroService service) { this.service = service; }
    @GetMapping
    public String listar(Model model) {
        model.addAttribute("arbitros", service.listar());
        return "arbitro/lista";
    }
    @GetMapping("/nuevo")
    public String nuevo(Model model) {
        model.addAttribute("arbitro", new Arbitro());
        return "arbitro/formulario";
    }
    @PostMapping("/guardar")
    public String guardar(@ModelAttribute Arbitro a) {
        service.guardar(a);
        return "redirect:/arbitros";
    }
    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Integer id, Model model) {
        model.addAttribute("arbitro", service.obtener(id));
        return "arbitro/formulario";
    }
    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable Integer id) {
        service.eliminar(id);
        return "redirect:/arbitros";
    }
}
