import {NgModule} from '@angular/core';
import {PagesComponent} from './pages.component';
import {PagesRoutingModule} from './pages-routing.module';
import {SharedModule} from '../shared/shared.module';
import {ClrDropdownModule, ClrLayoutModule} from '@clr/angular';

@NgModule({
  imports: [
    SharedModule,
    ClrLayoutModule,
    ClrDropdownModule,
    PagesRoutingModule,
  ],
  declarations: [PagesComponent],
})
export class PagesModule { }
