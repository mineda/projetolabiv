package br.gov.sp.fatec.projetolabiv.service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import br.gov.sp.fatec.projetolabiv.entity.Gasto;
import br.gov.sp.fatec.projetolabiv.repository.GastoRepository;

@Service
public class GastoServiceImpl implements GastoService{

    @Autowired
    private GastoRepository repo;

    @Override
    public List<Gasto> buscarValorMaior(BigDecimal valor) {
        return repo.findByValorGreaterThan(valor);
    }

    @Override
    public List<Gasto> todos() {
        return repo.findAll();
    }

    @PreAuthorize("isAuthenticated()")
    @Override
    public Gasto salvar(Gasto gasto) {
        return repo.save(gasto);
    }
    
}
