package br.gov.sp.fatec.projetolabiv.service;

import java.util.List;

import br.gov.sp.fatec.projetolabiv.entity.Anotacao;

public interface AnotacaoService {

    public List<Anotacao> todas();

    public List<Anotacao> buscarNoTexto(String texto);

    public Anotacao salvar(Anotacao anotacao, String nomeUsuario);
    
}