package br.com.accenture.report.demo.repository;

import br.com.accenture.report.demo.entity.Conta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContaRepository extends JpaRepository<Conta, Integer> {

}
