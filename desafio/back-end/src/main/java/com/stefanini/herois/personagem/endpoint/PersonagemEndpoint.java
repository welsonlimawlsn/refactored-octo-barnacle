package com.stefanini.herois.personagem.endpoint;

import com.stefanini.herois.generico.dto.ConversorDTO;
import com.stefanini.herois.personagem.dto.NovoPersonagemDTO;
import com.stefanini.herois.personagem.entity.Personagem;
import com.stefanini.herois.personagem.service.PersonagemService;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import java.io.IOException;

@Path("personagem")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Stateless
public class PersonagemEndpoint {

    @Inject
    private ConversorDTO<Personagem, NovoPersonagemDTO> dtoConversorDTO;

    @EJB
    private PersonagemService personagemService;

    @GET
    public Response getPersonagens() {
        return Response.ok(personagemService.listaTodos()).build();
    }

    @POST
    @Path("carrega")
    public Response persisteDadosCSV() throws IOException {
        personagemService.persisteDadosCSV();
        return Response.created(UriBuilder.fromPath("personagem").build()).build();
    }

    @POST
    public Response novoPersonagem(NovoPersonagemDTO personagem) {
        Personagem personagemCadastrado = personagemService.novoPersonagem(dtoConversorDTO.convertToObject(personagem));
        return Response.created(UriBuilder.fromPath("personagem/{id}").build(personagemCadastrado.getId())).build();
    }
}
