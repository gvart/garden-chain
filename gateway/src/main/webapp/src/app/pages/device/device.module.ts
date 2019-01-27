import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {DeviceRoutingModule, routedComponents} from './device-routing.module';

@NgModule({
  declarations: [...routedComponents],
  imports: [
    CommonModule,
    DeviceRoutingModule,
  ]
})
export class DeviceModule { }
