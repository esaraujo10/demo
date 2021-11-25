package br.com.accenture.report.demo.service;

import br.com.accenture.report.demo.entity.Conta;
import br.com.accenture.report.demo.repository.ContaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.awt.print.Pageable;

@Service
public class ContaService {
    @Autowired
    ContaRepository contaRepository;

    public Page<Conta> search(
            String searchTerm,
            int page,
            int size) {
        PageRequest pageRequest = PageRequest.of(
                page,
                size,
                Sort.Direction.ASC,
                "dataInicio");

        return contaRepository.search(
                searchTerm.toLowerCase(),
                 pageRequest);
    }

    public Page<Conta> findAll() {
        int page = 0;
        int size = 10;
        PageRequest pageRequest = PageRequest.of(
                page,
                size,
                Sort.Direction.ASC,
                "dataInicio");
        return new PageImpl<>(
                contaRepository.findAll(),
                pageRequest, size);
    }
}
