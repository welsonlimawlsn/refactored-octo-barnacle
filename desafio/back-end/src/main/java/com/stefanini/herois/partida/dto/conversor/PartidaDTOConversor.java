package com.stefanini.herois.partida.dto.conversor;

import com.stefanini.herois.generico.dto.ConversorDTO;
import com.stefanini.herois.partida.dto.PartidaDTO;
import com.stefanini.herois.partida.entity.Partida;

public class PartidaDTOConversor implements ConversorDTO<Partida, PartidaDTO> {
    @Override
    public PartidaDTO convertToDTO(Partida partida) {
        PartidaDTO partidaDTO = new PartidaDTO();
        partidaDTO.setHeroiMutante(partida.getHeroiMutante());
        partidaDTO.setId(partida.getId());
        partidaDTO.setGanhador(partida.getGanhador());
        return partidaDTO;
    }

    @Override
    public Partida convertToObject(PartidaDTO partidaDTO) {
        return null;
    }
}
