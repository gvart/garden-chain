import {RouterModule, Routes} from '@angular/router';
import {NgModule} from '@angular/core';
import {DeviceComponent} from './device.component';
import {DeviceListComponent} from './components/device-list/device-list.component';
import {DeviceDetailsComponent} from './components/device-details/device-details.component';


const routes: Routes = [
  {
    path: '',
    component: DeviceComponent,
    children: [
      {
        path: '',
        component: DeviceListComponent,
      },
      {
        path: ':id',
        component: DeviceDetailsComponent,
      },
    ]
  }
];

export const routedComponents = [
  DeviceComponent,
  DeviceListComponent,
  DeviceDetailsComponent,
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
})
export class DeviceRoutingModule {}
