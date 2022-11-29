package br.gov.sp.fatec.projetolabiv.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.gov.sp.fatec.projetolabiv.entity.Localidade;
import br.gov.sp.fatec.projetolabiv.service.LocalidadeService;

@RestController
@CrossOrigin
@RequestMapping(value = "/localidade")
public class LocalidadeController {

    @Autowired
    private LocalidadeService service;

    @GetMapping
    public List<Localidade> todas() {
        return service.listarTodas();
    }

    @PostMapping
    public Localidade nova(@RequestBody Localidade localidade) {
        return service.novaLocalidade(localidade);
    }
    
}
