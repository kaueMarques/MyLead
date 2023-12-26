// novo-leed-form.component.ts
import { Component } from '@angular/core';
import { ClienteService } from '../cliente.service';
import { PoNotificationService } from '@po-ui/ng-components';

@Component({
  selector: 'app-novo-leed-form',
  templateUrl: './novo-leed-form.component.html',
  styleUrls: ['./novo-leed-form.component.css']
})
export class NovoLeedFormComponent {
  cliente = {
    nome: '',
    endereco: {
      estado: '',
      cidade: '',
      bairro: '',
      rua: '',
      numero: ''
    },
    contatos: [
      {
        numeroTelefone: '',
        email: ''
      }
    ]
  };
  
  sucessoMensagem: string | undefined;

  constructor(
    private clienteService: ClienteService,
    private notificationService: PoNotificationService
  ) {}

  enviarFormulario() {
    this.clienteService.cadastrarCliente(this.cliente).subscribe(
      (response) => {
        console.log('Cliente cadastrado com sucesso:', response);
        this.sucessoMensagem = 'Cliente cadastrado com sucesso!';
      },
      (error) => {
        console.error('Erro ao cadastrar cliente:', error);
        
        if (error.status === 406) {
          this.notificationService.error('Verifique os dados, caso um dos campos criados já existam nos cadastros, não será aceita a inclusão na base');
        }

      }
    );
  }

  getContatoValue(key: 'numeroTelefone' | 'email'): string {
    return this.cliente.contatos.length > 0 ? this.cliente.contatos[0][key] : '';
  }
}
