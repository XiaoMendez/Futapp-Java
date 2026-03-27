package com.futapp.futappweb.repository;
import com.futapp.futappweb.entity.Jugador;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
public interface JugadorRepository extends JpaRepository<Jugador, Integer> {
    List<Jugador> findByEquipoId(Integer idEquipo);
}
