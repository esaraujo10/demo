package br.com.accenture.report.demo.resources;

import br.com.accenture.report.demo.entity.Conta;
import br.com.accenture.report.demo.repository.ContaRepository;
import br.com.accenture.report.demo.service.ContaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@RestController
@RequestMapping(path="/contas")
public class ContaResourse {
    private ContaRepository contaRepository;

    @Autowired
    ContaService contaService;

    public ContaResourse(ContaRepository contaRepository) {
        super();
        this.contaRepository = contaRepository;
    }

    @PostMapping
    public ResponseEntity<Conta> save(@RequestBody Conta conta) {
        if (conta.qtdParcela.signum() > 0) {
            atribuiValorParcela(conta);
        }

        contaRepository.save(conta);
        return new ResponseEntity<>(conta, HttpStatus.OK);
    }

    @PostMapping(path = "/cadastrarContas")
    public ResponseEntity<List<Conta>> saveList(@RequestBody ArrayList<Conta> contas) {
        for (int i = 0; i < contas.size(); i++) {
            if (contas.get(i).qtdParcela != null && contas.get(i).qtdParcela.intValue() > 0) {
                atribuiValorParcela(contas.get(i));
            }

            contaRepository.save(contas.get(i));
        }
        return new ResponseEntity<List<Conta>>((List<Conta>) contas, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Conta>> getAll() {
        List<Conta> contas = new ArrayList<>();
        contas = contaRepository.findAll();
        return new ResponseEntity<>(contas, HttpStatus.OK);
    }

//    @GetMapping(path = "/relatorioMensal")
//    public ResponseEntity<List<Conta>> geraRelatorio() {
//        List<Conta> contas = new ArrayList<>();
//        contas = contaRepository.findAll();
//        return new ResponseEntity<>(contas, HttpStatus.OK);
//    }

    @GetMapping(path ="/{id}")
    public ResponseEntity<Optional<Conta>> getById(@PathVariable Integer id) {
        Optional<Conta> conta;
        try {
            conta = contaRepository.findById(id);
            return new ResponseEntity<Optional<Conta>>(conta, HttpStatus.OK);
        } catch (NoSuchElementException nsee) {
            return new ResponseEntity<Optional<Conta>>(HttpStatus.NOT_FOUND);
        }
     }

    @GetMapping("/search")
    public Page<Conta> search(
            @RequestParam("dataSearch") String dataSearch,
            @RequestParam(
                    value = "page",
                    required = false,
                    defaultValue = "0") int page,
            @RequestParam(
                    value = "size",
                    required = false,
                    defaultValue = "10") int size) {
        return contaService.search(dataSearch, page, size);
    }

    @GetMapping(path = "/buscaRel")
    public Page<Conta> getRelatorio() {
        return contaService.findAll();
    }

    @DeleteMapping(path ="/{id}")
    public ResponseEntity<Optional<Conta>> deleteById(@PathVariable Integer id) {
        try {
            contaRepository.deleteById(id);
            return new ResponseEntity<Optional<Conta>>(HttpStatus.OK);
        } catch (NoSuchElementException nsee) {
            return new ResponseEntity<Optional<Conta>>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Conta> update(@PathVariable Integer id, @RequestBody Conta newConta) {
        return contaRepository.findById(id)
                .map(conta -> {
                    conta.setDescricao(newConta.getDescricao());
                    conta.setValor(new BigDecimal(String.valueOf((newConta.getValor()))));
                    conta.setTipoConta(newConta.getTipoConta());
                    conta.setQtdParcela(newConta.getQtdParcela());
                    Conta contaUpdate = contaRepository.save(conta);
                    return ResponseEntity.ok().body(contaUpdate);
                }).orElse(ResponseEntity.notFound().build());
    }

    public void atribuiValorParcela(Conta conta) {
        conta.setValorParcela((conta.getValor().divide(conta.getQtdParcela())));
    }
}