package br.gov.sp.fatec.projetolabiv.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.gov.sp.fatec.projetolabiv.entity.Localidade;

public interface LocalidadeRepository extends JpaRepository<Localidade, Long>{
    
}
