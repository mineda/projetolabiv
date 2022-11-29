package br.gov.sp.fatec.projetolabiv.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import br.gov.sp.fatec.projetolabiv.entity.Lance;
import br.gov.sp.fatec.projetolabiv.repository.LanceRepository;

@Service
public class LanceServiceImpl implements LanceService{

    @Autowired
    private LanceRepository repo;

    @Override
    @PreAuthorize("isAuthenticated()")
    public Lance novoLance(Lance lance) {
        lance.setDataHora(new Date());
        return repo.save(lance);
    }

    @Override
    public List<Lance> listarTodos() {
        return repo.findAll();
    }
    
}
