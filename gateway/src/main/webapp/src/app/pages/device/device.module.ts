import {NgModule} from '@angular/core';
import {DeviceRoutingModule, routedComponents} from './device-routing.module';
import {DeviceListComponent} from './components/device-list/device-list.component';
import {SharedModule} from '../../shared/shared.module';

@NgModule({
  declarations: [...routedComponents, DeviceListComponent],
  imports: [
    SharedModule,
    DeviceRoutingModule,
  ]
})
export class DeviceModule { }
