package br.gov.sp.fatec.projetolabiv.service;

import java.util.List;

import br.gov.sp.fatec.projetolabiv.entity.Lance;

public interface LanceService {

    public Lance novoLance(Lance lance);

    public List<Lance> listarTodos();
    
}
