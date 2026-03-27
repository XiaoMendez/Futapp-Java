package com.futapp.futappweb.service;
import com.futapp.futappweb.entity.Campeonato;
import com.futapp.futappweb.repository.CampeonatoRepository;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class CampeonatoService {
    private final CampeonatoRepository repo;
    public CampeonatoService(CampeonatoRepository repo) { this.repo = repo; }
    public List<Campeonato> listar() { var result = repo.findAll(); return result != null ? result : java.util.Collections.emptyList(); }
    public Campeonato obtener(Integer id) { return repo.findById(id).orElse(null); }
    public Campeonato guardar(Campeonato c) { return repo.save(c); }
    public void eliminar(Integer id) { repo.deleteById(id); }
}