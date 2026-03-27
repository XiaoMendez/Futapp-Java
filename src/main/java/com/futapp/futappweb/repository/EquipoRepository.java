package com.futapp.futappweb.repository;
import com.futapp.futappweb.entity.Equipo;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
public interface EquipoRepository extends JpaRepository<Equipo, Integer> {
    List<Equipo> findByFederacionId(Integer idFederacion);
}
