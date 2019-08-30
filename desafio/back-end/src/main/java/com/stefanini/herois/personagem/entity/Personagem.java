package com.stefanini.herois.personagem.entity;

import com.stefanini.herois.excecao.DueloImpossivelException;
import com.stefanini.herois.excecao.EmpateException;
import com.stefanini.herois.generico.entity.AbstractEntity;
import com.stefanini.herois.personagem.Habilidade;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Transient;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Personagem extends AbstractEntity {

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private String alinhamento;

    @Column(nullable = false)
    private Integer inteligencia;

    @Column(nullable = false)
    private Integer forca;

    @Column(nullable = false)
    private Integer destreza;

    @Column(nullable = false)
    private Integer poder;

    @Column(nullable = false)
    private Integer combate;

    @Column(nullable = false)
    private Integer defesa;

    @Transient
    private Integer numeroDeVitorias = 0;

    @Transient
    public Integer getHabilidade(Habilidade habilidade) {
        switch (habilidade) {
            case INTELIGENCIA:
                return inteligencia;
            case FORCA:
                return forca;
            case DESTREZA:
                return destreza;
            case PODER:
                return poder;
            case COMBATE:
                return combate;
            case DEFESA:
                return defesa;
            default:
                return null;
        }
    }

    public Personagem duela(Personagem personagem, Habilidade habilidade) throws EmpateException, DueloImpossivelException {
        verificaPossibilidadeDeAlguemGanhar(personagem);

        Integer valorHabilidadePersonagem1 = this.getHabilidade(habilidade);
        Integer valorHabilidadePersonagem2 = personagem.getHabilidade(habilidade);

        int resultado = valorHabilidadePersonagem1.compareTo(valorHabilidadePersonagem2);

        verificaSeOuveEmpate(resultado);

        return processaGanhador(personagem, habilidade, resultado);
    }

    private Personagem processaGanhador(Personagem personagem, Habilidade habilidade, int resultado) {
        if (resultado > 0) {
            this.ganha(habilidade);
            personagem.perde(habilidade);
            return this;
        } else {
            this.perde(habilidade);
            personagem.ganha(habilidade);
            return personagem;
        }
    }

    private void verificaSeOuveEmpate(int resultado) throws EmpateException {
        if (resultado == 0) {
            throw new EmpateException("Empatou!");
        }
    }

    public void verificaPossibilidadeDeAlguemGanhar(Personagem personagem) throws DueloImpossivelException {
        int count = 0;
        for (Habilidade habilidade : Habilidade.values()) {
            if (this.getHabilidade(habilidade).equals(personagem.getHabilidade(habilidade))) {
                count++;
            }
        }

        if (count == 6) {
            throw new DueloImpossivelException("Impossivel algue ganhar esse duelo");
        }
    }

    private void ganha(Habilidade habilidade) {
        setHabilidade(habilidade, getHabilidade(habilidade) + 2);
        numeroDeVitorias++;
    }

    private void perde(Habilidade habilidade) {
        Integer habilidadeAtual = getHabilidade(habilidade);
        setHabilidade(habilidade, habilidadeAtual <= 2 ? 0 : habilidadeAtual - 2);
    }

    private void setHabilidade(Habilidade habilidade, int novoValor) {
        switch (habilidade) {
            case INTELIGENCIA:
                inteligencia = novoValor;
                break;
            case FORCA:
                forca = novoValor;
                break;
            case DESTREZA:
                destreza = novoValor;
                break;
            case PODER:
                poder = novoValor;
                break;
            case COMBATE:
                combate = novoValor;
                break;
            case DEFESA:
                defesa = novoValor;
                break;
        }
    }

    public void combinaHabilidades(Personagem personagem) {
        for (Habilidade habilidade : Habilidade.values()) {
            Integer habilidadePersonagem = personagem.getHabilidade(habilidade);
            if (habilidadePersonagem > this.getHabilidade(habilidade)) {
                this.setHabilidade(habilidade, habilidadePersonagem);
            }
        }
    }
}
