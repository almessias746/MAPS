import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { DashboardComponent } from './dashboard/dashboard.component';
import { ContaCorrenteComponent } from './conta-corrente/conta-corrente.component';
import { AtivosComponent } from './ativos/ativos.component';

import { TabViewModule  } from 'primeng/tabview';

@NgModule({
  declarations: [
    AppComponent,
    DashboardComponent,
    ContaCorrenteComponent,
    AtivosComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    TabViewModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
