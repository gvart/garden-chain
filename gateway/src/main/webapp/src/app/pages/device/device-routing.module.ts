import {RouterModule, Routes} from '@angular/router';
import {NgModule} from '@angular/core';
import {DeviceComponent} from './device.component';


const routes: Routes = [
  {
    path: '',
    component: DeviceComponent,
  }
];

export const routedComponents = [
  DeviceComponent,
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
})
export class DeviceRoutingModule {
}
