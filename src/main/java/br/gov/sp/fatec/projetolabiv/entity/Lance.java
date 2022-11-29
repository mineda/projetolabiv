package br.gov.sp.fatec.projetolabiv.entity;

import java.util.Date;

import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Table(name = "lnc_lance")
public class Lance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "lnc_id")
    private Long id;

    @Column(name = "lnc_data_hora")
    private Date dataHora;

    @Column(name = "lnc_jogador")
    private String jogador;

    @Column(name = "lnc_descricao")
    private String descricao;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDataHora() {
        return dataHora;
    }

    public void setDataHora(Date dataHora) {
        this.dataHora = dataHora;
    }

    public String getJogador() {
        return jogador;
    }

    public void setJogador(String jogador) {
        this.jogador = jogador;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
}
