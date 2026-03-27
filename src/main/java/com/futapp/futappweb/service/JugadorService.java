package com.futapp.futappweb.service;
import com.futapp.futappweb.entity.Jugador;
import com.futapp.futappweb.repository.JugadorRepository;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class JugadorService {
    private final JugadorRepository repo;
    public JugadorService(JugadorRepository repo) { this.repo = repo; }
    public List<Jugador> listar() { var result = repo.findAll(); return result != null ? result : java.util.Collections.emptyList(); }
    public Jugador obtener(Integer id) { return repo.findById(id).orElse(null); }
    public Jugador guardar(Jugador j) { return repo.save(j); }
    public void eliminar(Integer id) { repo.deleteById(id); }
}