package br.com.accenture.report.demo.resources;

import br.com.accenture.report.demo.entity.TipoConta;
import br.com.accenture.report.demo.repository.TipoContaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(path = "/tipoContas")
public class TipoContaResource {
    private TipoContaRepository tipoContaRepository;

    @GetMapping
    public ResponseEntity<List<TipoConta>> getAll() {
        List<TipoConta> tipoContas = new ArrayList<>();
        tipoContas = tipoContaRepository.findAll();
        return new ResponseEntity<>(tipoContas, HttpStatus.OK);
    }
}
