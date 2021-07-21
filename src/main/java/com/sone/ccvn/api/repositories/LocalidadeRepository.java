package com.sone.ccvn.api.repositories;

import com.sone.ccvn.api.entities.Localidade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface LocalidadeRepository extends JpaRepository<Localidade, Long> {

    @Transactional
    @Query("SELECT obj FROM Localidade obj WHERE obj.estado.id = :localidade_id ORDER BY obj.nome")
    List<Localidade> findByLocalidades(@Param("localidade_id") Long localidade_id);
}
