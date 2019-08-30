package com.stefanini.herois.generico.dto;

public interface ConversorDTO<OBJ, DTO> {

    DTO convertToDTO(OBJ obj);

    OBJ convertToObject(DTO dto);

}
