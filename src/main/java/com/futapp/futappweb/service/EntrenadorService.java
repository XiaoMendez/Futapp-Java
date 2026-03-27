package com.futapp.futappweb.service;
import com.futapp.futappweb.entity.Entrenador;
import com.futapp.futappweb.repository.EntrenadorRepository;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class EntrenadorService {
    private final EntrenadorRepository repo;
    public EntrenadorService(EntrenadorRepository repo) { this.repo = repo; }
    public List<Entrenador> listar() { var result = repo.findAll(); return result != null ? result : java.util.Collections.emptyList(); }
    public Entrenador obtener(Integer id) { return repo.findById(id).orElse(null); }
    public Entrenador guardar(Entrenador e) { return repo.save(e); }
    public void eliminar(Integer id) { repo.deleteById(id); }
}