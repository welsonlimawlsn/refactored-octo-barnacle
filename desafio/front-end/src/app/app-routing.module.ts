import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';


const routes: Routes = [
  {path: 'partida', loadChildren: './partida/partida.module#PartidaModule'},
  {path: 'personagem', loadChildren: './personagem/personagem.module#PersonagemModule'},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
