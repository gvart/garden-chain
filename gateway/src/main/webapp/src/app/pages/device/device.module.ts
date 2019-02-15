import {NgModule} from '@angular/core';
import {DeviceRoutingModule, routedComponents} from './device-routing.module';
import {SharedModule} from '../../shared/shared.module';
import {ClrDatagridModule} from '@clr/angular';

@NgModule({
  declarations: [...routedComponents],
  imports: [
    SharedModule,
    ClrDatagridModule,
    DeviceRoutingModule,
  ]
})
export class DeviceModule { }
