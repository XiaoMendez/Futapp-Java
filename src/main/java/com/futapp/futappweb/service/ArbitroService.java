package com.futapp.futappweb.service;
import com.futapp.futappweb.entity.Arbitro;
import com.futapp.futappweb.repository.ArbitroRepository;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class ArbitroService {
    private final ArbitroRepository repo;
    public ArbitroService(ArbitroRepository repo) { this.repo = repo; }
    public List<Arbitro> listar() { var result = repo.findAll(); return result != null ? result : java.util.Collections.emptyList(); }
    public Arbitro obtener(Integer id) { return repo.findById(id).orElse(null); }
    public Arbitro guardar(Arbitro a) { return repo.save(a); }
    public void eliminar(Integer id) { repo.deleteById(id); }
}