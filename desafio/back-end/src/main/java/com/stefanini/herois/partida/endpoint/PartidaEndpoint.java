package com.stefanini.herois.partida.endpoint;

import com.stefanini.herois.duelo.dto.DueloDTO;
import com.stefanini.herois.duelo.entity.Duelo;
import com.stefanini.herois.excecao.NotFoundException;
import com.stefanini.herois.generico.dto.ConversorDTO;
import com.stefanini.herois.partida.dto.PartidaDTO;
import com.stefanini.herois.partida.entity.Partida;
import com.stefanini.herois.partida.service.PartidaService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import java.util.List;
import java.util.stream.Collectors;

@Path("partida")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class PartidaEndpoint {

    @Inject
    private ConversorDTO<Partida, PartidaDTO> partidaDTOConversor;

    @Inject
    private ConversorDTO<Duelo, DueloDTO> dueloDTOConversor;

    @Inject
    private PartidaService partidaService;

    @POST
    public Response novoPartida() {
        return Response.created(UriBuilder.fromPath("partida/{id}").build(partidaService.novaPartida().getId())).build();
    }

    @GET
    @Path("{id}")
    public Response procuraPeloId(@PathParam("id") String id) throws NotFoundException {
        return Response.ok(partidaDTOConversor.convertToDTO(partidaService.procuraPorId(id))).build();
    }

    @GET
    @Path("{id}/duelos")
    public Response listaDueloPorPartida(@PathParam("id") String id) throws NotFoundException {
        List<DueloDTO> duelos = partidaService.duelosPorPartida(id).stream()
                .map(duelo -> dueloDTOConversor.convertToDTO(duelo))
                .collect(Collectors.toList());
        return Response.ok(duelos).build();
    }

    @GET
    public Response listaPartidas() {
        List<PartidaDTO> partidaDTOS = partidaService.listaTodas().stream()
                .map(partida -> partidaDTOConversor.convertToDTO(partida))
                .collect(Collectors.toList());
        return Response.ok(partidaDTOS).build();
    }
}
