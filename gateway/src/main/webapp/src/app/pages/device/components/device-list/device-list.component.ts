import {Component, OnInit} from '@angular/core';
import {Device} from '../../../../shared/service/device/device.model';
import {DeviceService} from '../../../../shared/service/device/device.service';

@Component({
  selector: 'app-device-list',
  templateUrl: './device-list.component.html',
  styleUrls: ['./device-list.component.scss']
})
export class DeviceListComponent implements OnInit {
  devices: Device[];

  constructor(private deviceService: DeviceService) {}

  ngOnInit() {
    this.deviceService.findAll().subscribe(data => this.devices = data);
  }
}
