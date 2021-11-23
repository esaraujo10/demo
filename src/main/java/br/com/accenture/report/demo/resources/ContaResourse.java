package br.com.accenture.report.demo.resources;

import br.com.accenture.report.demo.entity.Conta;
import br.com.accenture.report.demo.repository.ContaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@RestController
@RequestMapping(path="/contas")
public class ContaResourse {
    private ContaRepository contaRepository;

    public ContaResourse(ContaRepository contaRepository) {
        super();
        this.contaRepository = contaRepository;
    }

    @PostMapping
    public ResponseEntity<Conta> save(@RequestBody Conta conta) {
        contaRepository.save(conta);
        return new ResponseEntity<>(conta, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Conta>> getAll() {
        List<Conta> contas = new ArrayList<>();
        contas = contaRepository.findAll();
        return new ResponseEntity<>(contas, HttpStatus.OK);
    }

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
                    conta.setValor(newConta.getValor());
                    Conta contaUpdate = contaRepository.save(conta);
                    return ResponseEntity.ok().body(contaUpdate);
                }).orElse(ResponseEntity.notFound().build());
    }
}
