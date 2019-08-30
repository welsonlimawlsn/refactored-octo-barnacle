package com.stefanini.herois.personagem.dto.conversor;

import com.stefanini.herois.generico.dto.ConversorDTO;
import com.stefanini.herois.personagem.dto.NovoPersonagemDTO;
import com.stefanini.herois.personagem.entity.Personagem;

public class NovoPersonagemDTOConversor implements ConversorDTO<Personagem, NovoPersonagemDTO> {
    @Override
    public NovoPersonagemDTO convertToDTO(Personagem personagem) {
        return null;
    }

    @Override
    public Personagem convertToObject(NovoPersonagemDTO dto) {
        return new Personagem(dto.getNome(), dto.getAlinhamento(), dto.getInteligencia(), dto.getForca(), dto.getDestreza(), dto.getPoder(), dto.getCombate(), dto.getDefesa(), null);
    }
}
