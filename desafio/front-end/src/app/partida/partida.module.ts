import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {NovaPartidaComponent} from './nova-partida/nova-partida.component';
import {RouterModule} from "@angular/router";
import {HttpClientModule} from "@angular/common/http";
import {PartidaService} from "./partida.service";
import {DetalhesPartidaComponent} from './detalhes-partida/detalhes-partida.component';
import {PartidaComponent} from './partida/partida.component';
import {DueloModule} from "../duelo/duelo.module";
import {PersonagemModule} from "../personagem/personagem.module";
import {TodasPartidasComponent} from './todas-partidas/todas-partidas.component';


@NgModule({
  declarations: [
    NovaPartidaComponent,
    DetalhesPartidaComponent,
    PartidaComponent,
    TodasPartidasComponent
  ],
  imports: [
    CommonModule,
    HttpClientModule,
    DueloModule,
    RouterModule.forChild([
      {path: 'nova', component: NovaPartidaComponent},
      {path: 'todas', component: TodasPartidasComponent},
      {path: ':id', component: DetalhesPartidaComponent}
    ]),
    PersonagemModule,
  ],
  providers: [
    PartidaService
  ]
})
export class PartidaModule {
}
