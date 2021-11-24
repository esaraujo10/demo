package br.com.accenture.report.demo.repository;

import br.com.accenture.report.demo.entity.Conta;
import br.com.accenture.report.demo.vo.RelatorioContaVO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RelatorioContaRepository extends JpaRepository<Conta, Integer> {

}
