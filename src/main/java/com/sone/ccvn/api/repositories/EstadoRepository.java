package com.sone.ccvn.api.repositories;

import com.sone.ccvn.api.entities.Estado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Repository
public interface EstadoRepository extends JpaRepository<Estado, Long> {

    @Transactional
    List<Estado> findAllByOrderByNome();

    Optional<Estado> findById(Long id);
}
