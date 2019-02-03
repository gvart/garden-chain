import {NgModule} from '@angular/core';
import {PagesComponent} from './pages.component';
import {PagesRoutingModule} from './pages-routing.module';
import {MatListModule, MatSidenavModule, MatToolbarModule} from '@angular/material';
import {SharedModule} from '../shared/shared.module';

@NgModule({
  imports: [
    SharedModule,
    PagesRoutingModule,
    MatToolbarModule,
    MatSidenavModule,
    MatListModule,
  ],
  declarations: [PagesComponent],
})
export class PagesModule { }
