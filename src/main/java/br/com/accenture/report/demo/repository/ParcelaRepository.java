package br.com.accenture.report.demo.repository;

import br.com.accenture.report.demo.entity.Parcela;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParcelaRepository extends JpaRepository<Parcela, Integer> {

}
