package br.gov.sp.fatec.projetolabiv.controller;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.gov.sp.fatec.projetolabiv.entity.Gasto;
import br.gov.sp.fatec.projetolabiv.service.GastoService;

@RestController
@CrossOrigin
@RequestMapping(value = "/gasto")
public class GastoController {

    @Autowired
    private GastoService service;

    @GetMapping
    public List<Gasto> todos() {
        return service.todos();
    }

    @GetMapping(value = "/{valor}")
    public List<Gasto> buscarValorMaior(@PathVariable("valor") BigDecimal valor) {
        return service.buscarValorMaior(valor);
    }

    @PostMapping
    public Gasto salvar(@RequestBody Gasto gasto) {
        return service.salvar(gasto);
    }
    
}
