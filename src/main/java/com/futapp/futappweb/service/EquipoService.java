package com.futapp.futappweb.service;
import com.futapp.futappweb.entity.Equipo;
import com.futapp.futappweb.repository.EquipoRepository;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class EquipoService {
    private final EquipoRepository repo;
    public EquipoService(EquipoRepository repo) { this.repo = repo; }
    public List<Equipo> listar() { var result = repo.findAll(); return result != null ? result : java.util.Collections.emptyList(); }
    public Equipo obtener(Integer id) { return repo.findById(id).orElse(null); }
    public Equipo guardar(Equipo e) { return repo.save(e); }
    public void eliminar(Integer id) { repo.deleteById(id); }
}