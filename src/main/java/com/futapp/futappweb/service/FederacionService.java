package com.futapp.futappweb.service;
import com.futapp.futappweb.entity.Federacion;
import com.futapp.futappweb.repository.FederacionRepository;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class FederacionService {
    private final FederacionRepository repo;
    public FederacionService(FederacionRepository repo) { this.repo = repo; }
    public List<Federacion> listar() { var result = repo.findAll(); return result != null ? result : java.util.Collections.emptyList(); }
    public Federacion obtener(Integer id) { return repo.findById(id).orElse(null); }
    public Federacion guardar(Federacion f) { return repo.save(f); }
    public void eliminar(Integer id) { repo.deleteById(id); }
}