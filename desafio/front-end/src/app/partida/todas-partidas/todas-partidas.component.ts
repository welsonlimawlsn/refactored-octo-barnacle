import {Component, OnInit} from '@angular/core';
import {Partida} from "../partida.model";
import {PartidaService} from "../partida.service";

@Component({
  selector: 'hr-todas-partidas',
  templateUrl: './todas-partidas.component.html',
  styleUrls: ['./todas-partidas.component.css']
})
export class TodasPartidasComponent implements OnInit {

  partidas: Partida[];

  constructor(private partidaService: PartidaService) {
  }

  ngOnInit() {
    this.partidaService.listaTodas().subscribe(partidas => this.partidas = partidas);
  }

}
