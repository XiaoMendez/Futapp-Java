package com.futapp.futappweb.repository;
import com.futapp.futappweb.entity.Partido;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
public interface PartidoRepository extends JpaRepository<Partido, Integer> {
    List<Partido> findByCampeonatoId(Integer idCampeonato);
}
