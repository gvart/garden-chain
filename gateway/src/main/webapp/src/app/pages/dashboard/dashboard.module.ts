import {NgModule} from '@angular/core';
import {DashboardRoutingModule, routedComponents} from './dashboard-routing.module';
import {SharedModule} from '../../shared/shared.module';

@NgModule({
  imports: [
    SharedModule,
    DashboardRoutingModule,
  ],
  declarations: [...routedComponents],
})
export class DashboardModule { }
