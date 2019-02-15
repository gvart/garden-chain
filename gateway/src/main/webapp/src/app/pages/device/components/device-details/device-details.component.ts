import {Component, OnInit} from '@angular/core';
import {DeviceService} from '../../../../shared/service/device/device.service';
import {ActivatedRoute, Router} from '@angular/router';
import {Device} from '../../../../shared/service/device/device.model';

@Component({
  selector: 'app-device-details',
  templateUrl: './device-details.component.html',
  styleUrls: ['./device-details.component.scss']
})
export class DeviceDetailsComponent implements OnInit {

  device: Device;

  constructor (
    private deviceService: DeviceService,
    private router: Router,
    private activatedRoute: ActivatedRoute
  ) { }

  ngOnInit() {
    this.activatedRoute.params.subscribe(params => {
      const id = params['id'];
      this.deviceService.findOne(id).subscribe(data => this.device = data);
    });
  }

}
