package br.com.accenture.report.demo.resources;

import br.com.accenture.report.demo.entity.Parcela;
import br.com.accenture.report.demo.entity.TipoConta;
import br.com.accenture.report.demo.repository.ParcelaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(path="/parcelas")
public class ParcelaResource {
    private ParcelaRepository parcelaRepository;

    @GetMapping
    public ResponseEntity<List<Parcela>> getAll() {
        List<Parcela> parcelas = new ArrayList<>();
        parcelas = parcelaRepository.findAll();
        return new ResponseEntity<>(parcelas, HttpStatus.OK);
    }
}
