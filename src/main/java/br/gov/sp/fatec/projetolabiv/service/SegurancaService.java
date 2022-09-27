package br.gov.sp.fatec.projetolabiv.service;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetailsService;

import br.gov.sp.fatec.projetolabiv.entity.Usuario;

public interface SegurancaService extends UserDetailsService{
    
    public Usuario novoUsuario(Usuario usuario);

    public Usuario novoUsuario(String nome, String senha);

    public List<Usuario> listarTodosUsuarios();

    public Usuario buscarUsuarioPorId(Long id);

}
