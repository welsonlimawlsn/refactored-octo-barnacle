import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {PersonagemComponent} from './personagem/personagem.component';
import {CadastroPersonagemComponent} from './cadastro-personagem/cadastro-personagem.component';
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import {RouterModule} from "@angular/router";
import {HttpClientModule} from "@angular/common/http";
import {PersonagemService} from "./personagem.service";


@NgModule({
  declarations: [PersonagemComponent, CadastroPersonagemComponent],
  exports: [
    PersonagemComponent
  ],
  imports: [
    CommonModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule,
    RouterModule.forChild([
      {path: 'cadastro', component: CadastroPersonagemComponent}
    ])
  ],
  providers: [
    PersonagemService
  ]
})
export class PersonagemModule {
}
