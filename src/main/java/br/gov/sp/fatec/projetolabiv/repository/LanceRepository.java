package br.gov.sp.fatec.projetolabiv.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.gov.sp.fatec.projetolabiv.entity.Lance;

public interface LanceRepository extends JpaRepository<Lance, Long>{
    
}
