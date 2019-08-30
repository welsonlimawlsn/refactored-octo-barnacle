import {Component, OnInit} from '@angular/core';
import {ActivatedRoute} from "@angular/router";
import {DueloService} from "../../duelo/duelo.service";
import {PartidaService} from "../partida.service";
import {Partida} from "../partida.model";
import {Duelo} from "../../duelo/duelo.model";

@Component({
  selector: 'hr-detalhes-partida',
  templateUrl: './detalhes-partida.component.html',
  styleUrls: ['./detalhes-partida.component.css']
})
export class DetalhesPartidaComponent implements OnInit {

  partida: Partida;

  duelos: Duelo[];

  constructor(private activateRoute: ActivatedRoute, private dueloService: DueloService, private partidaService: PartidaService) {
  }

  ngOnInit() {
    let partidaId = this.activateRoute.snapshot.params.id;
    this.partidaService.consultaPartidaPorId(partidaId).subscribe(partida => this.partida = partida);
    this.dueloService.consultaDueloPorPartida(partidaId).subscribe(duelos => this.duelos = duelos);
  }

}
