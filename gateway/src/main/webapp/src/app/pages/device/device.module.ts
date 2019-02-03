import {NgModule} from '@angular/core';
import {DeviceRoutingModule, routedComponents} from './device-routing.module';
import {DeviceListComponent} from './components/device-list/device-list.component';
import {SharedModule} from '../../shared/shared.module';
import {MatPaginatorModule, MatSortModule, MatTableModule} from '@angular/material';

@NgModule({
  declarations: [...routedComponents, DeviceListComponent],
  imports: [
    SharedModule,
    MatTableModule,
    DeviceRoutingModule,
    MatPaginatorModule,
    MatSortModule,
    MatTableModule,
  ]
})
export class DeviceModule { }
