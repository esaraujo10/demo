package br.com.accenture.report.demo.repository;

import br.com.accenture.report.demo.entity.Conta;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import org.springframework.data.domain.Pageable;
import java.util.Date;
import java.util.List;

@Repository
public interface ContaRepository extends JpaRepository<Conta, Integer> {
    @Query("FROM Conta c WHERE c.dataInicio = :dataSearch ")
    Page<Conta> search(
            @Param("dataSearch") String dataSearch,
            Pageable pageable);
}
