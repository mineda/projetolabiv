package br.gov.sp.fatec.projetolabiv.service;

import java.util.List;

import br.gov.sp.fatec.projetolabiv.entity.Localidade;

public interface LocalidadeService {

    public Localidade novaLocalidade(Localidade localidade);

    public List<Localidade> listarTodas();
    
}
