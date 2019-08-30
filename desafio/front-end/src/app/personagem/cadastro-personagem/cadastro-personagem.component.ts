import {Component, OnInit} from '@angular/core';
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {PersonagemService} from "../personagem.service";

@Component({
  selector: 'hr-cadastro-personagem',
  templateUrl: './cadastro-personagem.component.html',
  styleUrls: ['./cadastro-personagem.component.css']
})
export class CadastroPersonagemComponent implements OnInit {

  form: FormGroup;

  constructor(private fb: FormBuilder, private personagemService: PersonagemService) {
  }

  ngOnInit() {
    this.form = this.fb.group({
      nome: this.fb.control('', Validators.required),
      alinhamento: this.fb.control('', Validators.required),
      inteligencia: this.fb.control('', Validators.required),
      forca: this.fb.control('', Validators.required),
      destreza: this.fb.control('', Validators.required),
      poder: this.fb.control('', Validators.required),
      combate: this.fb.control('', Validators.required),
      defesa: this.fb.control('', Validators.required)
    });
  }

  cadastra() {
    this.personagemService.cadastraNovoPersonagem(this.form.value).subscribe(() => alert('Cadastro realizado'));
  }

}
