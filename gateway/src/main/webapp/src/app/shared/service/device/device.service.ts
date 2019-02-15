import { Injectable } from '@angular/core';
import {Observable, of} from 'rxjs';
import {Device} from './device.model';

@Injectable({
  providedIn: 'root'
})
export class DeviceService {

  constructor() { }

  // todo remove
  private getDevice(): Device {
    const device = new Device();
    device.id = 'id';
    device.ipAddress = '10.10.10.10:8998';
    device.name = 'Device XXX';
    device.registeredAt = '10/10/2019 12:30';
    device.description = 'Device XX';
    device.owner = 'John Doe';
    device.status = 'ACTIVE';
    device.softwareVersion = '1.0.0';
    return device;
  }

  findAll(): Observable<Device[]> {
    const device = this.getDevice();
    return of([
      device,
      device,
      device,
      device,
      device,
      device,
      device,
      device,
      device,
      device,
      device,
      device,
      device,
      device,
      device,
      device,
      device
    ]);
  }

  findOne(id: string): Observable<Device> {
    return of(this.getDevice());
  }
}
