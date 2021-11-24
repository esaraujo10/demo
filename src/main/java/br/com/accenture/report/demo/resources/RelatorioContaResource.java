package br.com.accenture.report.demo.resources;

import br.com.accenture.report.demo.entity.Conta;
import br.com.accenture.report.demo.repository.ContaRepository;
import br.com.accenture.report.demo.repository.RelatorioContaRepository;
import br.com.accenture.report.demo.vo.RelatorioContaVO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(path="/relaorioMensal")
public class RelatorioContaResource {
    private RelatorioContaRepository relatorioContaRepository;
    private ContaRepository contaRepository;

    public RelatorioContaResource(ContaRepository contaRepository) {
        super();
        //this.relatorioContaRepository = relatorioContaRepository;
        this.contaRepository = contaRepository;
    }

    @GetMapping
    public ResponseEntity<List<Conta>> getAll() {
        List<Conta> contas = new ArrayList<>();
        contas = contaRepository.findAll();

        for (int i = 0; i < contas.size(); i++) {
            contaRepository.save(contas.get(i));
        }

        return  new ResponseEntity<>(contas, HttpStatus.OK);
    }
}
