package com.futapp.futappweb.repository;
import com.futapp.futappweb.entity.Campeonato;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
public interface CampeonatoRepository extends JpaRepository<Campeonato, Integer> {
    List<Campeonato> findByFederacionId(Integer idFederacion);
}
