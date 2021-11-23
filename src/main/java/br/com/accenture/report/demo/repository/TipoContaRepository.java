package br.com.accenture.report.demo.repository;

import br.com.accenture.report.demo.entity.TipoConta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoContaRepository extends JpaRepository<TipoConta, Integer> {

}
