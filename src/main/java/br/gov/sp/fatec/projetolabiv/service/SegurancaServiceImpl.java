package br.gov.sp.fatec.projetolabiv.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import br.gov.sp.fatec.projetolabiv.entity.Usuario;
import br.gov.sp.fatec.projetolabiv.repository.UsuarioRepository;

@Service
public class SegurancaServiceImpl implements SegurancaService {

    @Autowired
    private UsuarioRepository usuarioRepo;

    private PasswordEncoder encoder = new BCryptPasswordEncoder();

    //public SegurancaServiceImpl(UsuarioRepository usuarioRepo) {
    //    this.usuarioRepo = usuarioRepo;
    //}

    @Override
    @PreAuthorize("hasRole('ADMIN')")
    public Usuario novoUsuario(Usuario usuario) {
        if(usuario.getNome() == null || usuario.getNome().trim().isEmpty() ||
                usuario.getSenha() == null || usuario.getSenha().trim().isEmpty() ||
                usuario.getAutorizacao() == null || usuario.getAutorizacao().trim().isEmpty()) {
            throw new IllegalArgumentException("Algum atributo em branco!");
        }
        usuario.setSenha(encoder.encode(usuario.getSenha()));
        return usuarioRepo.save(usuario);
    }

    @Override
    public Usuario novoUsuario(String nome, String senha) {
        Usuario usuario = new Usuario();
        usuario.setNome(nome);
        usuario.setSenha(senha);
        usuario.setAutorizacao("ROLE_USER");
        return novoUsuario(usuario);
    }

    @Override
    @PreAuthorize("isAuthenticated()")
    public List<Usuario> listarTodosUsuarios() {
        return usuarioRepo.findAll();
    }

    @Override
    @PreAuthorize("isAuthenticated()")
    public Usuario buscarUsuarioPorId(Long id) {
        Optional<Usuario> usuarioOp = usuarioRepo.findById(id);
        if(usuarioOp.isEmpty()) {
            throw new IllegalArgumentException("Id inválido!");
        }
        return usuarioOp.get();
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario usuario = usuarioRepo.buscarPorNome(username);
        if(usuario == null) {
            throw new UsernameNotFoundException("Usuário não encontrado!");
        }
        return User.builder()
            .username(username)
            .password(usuario.getSenha())
            .authorities(usuario.getAutorizacao())
            .build();
    }
    
}
