package br.gov.sp.fatec.projetolabiv.service;

import java.math.BigDecimal;
import java.util.List;

import br.gov.sp.fatec.projetolabiv.entity.Gasto;

public interface GastoService {

    public List<Gasto> buscarValorMaior(BigDecimal valor);

    public List<Gasto> todos();

    public Gasto salvar(Gasto gasto);
    
}
