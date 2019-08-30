package com.stefanini.herois.duelo.dto.conversor;

import com.stefanini.herois.duelo.dto.DueloDTO;
import com.stefanini.herois.duelo.entity.Duelo;
import com.stefanini.herois.generico.dto.ConversorDTO;

public class DueloDTOConversor implements ConversorDTO<Duelo, DueloDTO> {
    @Override
    public DueloDTO convertToDTO(Duelo duelo) {
        return new DueloDTO(duelo.getPersonagemUm(), duelo.getPersonagemDois(), duelo.getGanhador(), duelo.getHabilidadeComparada());
    }

    @Override
    public Duelo convertToObject(DueloDTO dueloDTO) {
        return null;
    }
}
