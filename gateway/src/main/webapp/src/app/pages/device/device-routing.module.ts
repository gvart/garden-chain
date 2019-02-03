import {RouterModule, Routes} from '@angular/router';
import {NgModule} from '@angular/core';
import {DeviceComponent} from './device.component';
import {DeviceListComponent} from './components/device-list/device-list.component';


const routes: Routes = [
  {
    path: '',
    component: DeviceComponent,
    children: [
      {
        path: '',
        component: DeviceListComponent,
      }
    ]
  }
];

export const routedComponents = [
  DeviceComponent,
  DeviceListComponent,
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
})
export class DeviceRoutingModule {
}
