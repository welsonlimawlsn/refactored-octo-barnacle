import {Personagem} from "../personagem/personagem.model";

export interface Duelo {
  personagemUm: Personagem;
  personagemDois: Personagem;
  ganhador: Personagem;
  habilidadeComparada: string;
}
