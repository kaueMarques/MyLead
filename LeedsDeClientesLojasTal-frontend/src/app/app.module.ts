// app.module.ts
import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { PoModule } from '@po-ui/ng-components';
import { HttpClientModule } from '@angular/common/http';
import { RouterModule } from '@angular/router';
import { PoTemplatesModule } from '@po-ui/ng-templates';
import { TelefoneFormComponent } from './telefone-form/telefone-form.component';
import { FormsModule } from '@angular/forms';
import { NovoLeedFormComponent } from './novo-leed-form/novo-leed-form.component';
import { ClienteService } from './cliente.service';


@NgModule({
  declarations: [
    AppComponent,
    TelefoneFormComponent,
    NovoLeedFormComponent
  ],
  imports: [
    [FormsModule],
    BrowserModule,
    AppRoutingModule,
    PoModule,
    HttpClientModule,
    RouterModule.forRoot([]),
    PoTemplatesModule,
    FormsModule,
  ],
  providers: [[ClienteService],],
  bootstrap: [AppComponent]
})
export class AppModule { }
