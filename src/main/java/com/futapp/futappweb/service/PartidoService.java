package com.futapp.futappweb.service;
import com.futapp.futappweb.entity.Partido;
import com.futapp.futappweb.repository.PartidoRepository;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class PartidoService {
    private final PartidoRepository repo;
    public PartidoService(PartidoRepository repo) { this.repo = repo; }
    public List<Partido> listar() { var result = repo.findAll(); return result != null ? result : java.util.Collections.emptyList(); }
    public List<Partido> listarPorCampeonato(Integer idCampeonato) { return repo.findByCampeonatoId(idCampeonato); }
    public Partido obtener(Integer id) { return repo.findById(id).orElse(null); }
    public Partido guardar(Partido p) { return repo.save(p); }
    public void eliminar(Integer id) { repo.deleteById(id); }
}