import {Personagem} from "../personagem/personagem.model";

export interface Partida {
  id: string;
  heroiMutante: Personagem;
  ganhador: Personagem;
}
