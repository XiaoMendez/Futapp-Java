package com.futapp.futappweb.controller;
import com.futapp.futappweb.entity.Partido;
import com.futapp.futappweb.service.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.Collections;

@Controller
@RequestMapping("/partidos")
public class PartidoController {
    private final PartidoService service;
    private final EquipoService equipoService;
    private final ArbitroService arbitroService;
    private final CampeonatoService campeonatoService;

    public PartidoController(PartidoService service, EquipoService equipoService,
                              ArbitroService arbitroService, CampeonatoService campeonatoService) {
        this.service = service;
        this.equipoService = equipoService;
        this.arbitroService = arbitroService;
        this.campeonatoService = campeonatoService;
    }

    @GetMapping
    public String listar(Model model) {
        try { model.addAttribute("partidos", service.listar()); }
        catch (Exception e) { model.addAttribute("partidos", Collections.emptyList()); }
        return "partido/lista";
    }

    @GetMapping("/nuevo")
    public String nuevo(Model model) {
        model.addAttribute("partido", new Partido());
        try { model.addAttribute("equipos", equipoService.listar()); }
        catch (Exception e) { model.addAttribute("equipos", Collections.emptyList()); }
        try { model.addAttribute("arbitros", arbitroService.listar()); }
        catch (Exception e) { model.addAttribute("arbitros", Collections.emptyList()); }
        try { model.addAttribute("campeonatos", campeonatoService.listar()); }
        catch (Exception e) { model.addAttribute("campeonatos", Collections.emptyList()); }
        return "partido/formulario";
    }

    @PostMapping("/guardar")
    public String guardar(@ModelAttribute Partido p) {
        service.guardar(p);
        return "redirect:/partidos";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Integer id, Model model) {
        model.addAttribute("partido", service.obtener(id));
        try { model.addAttribute("equipos", equipoService.listar()); }
        catch (Exception e) { model.addAttribute("equipos", Collections.emptyList()); }
        try { model.addAttribute("arbitros", arbitroService.listar()); }
        catch (Exception e) { model.addAttribute("arbitros", Collections.emptyList()); }
        try { model.addAttribute("campeonatos", campeonatoService.listar()); }
        catch (Exception e) { model.addAttribute("campeonatos", Collections.emptyList()); }
        return "partido/formulario";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable Integer id) {
        service.eliminar(id);
        return "redirect:/partidos";
    }
}