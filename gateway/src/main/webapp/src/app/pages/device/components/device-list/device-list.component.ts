import {Component, OnInit, ViewChild} from '@angular/core';
import {ELEMENT_DATA} from './temp-data';

@Component({
  selector: 'app-device-list',
  templateUrl: './device-list.component.html',
  styleUrls: ['./device-list.component.scss']
})
export class DeviceListComponent implements OnInit {
  /** Columns displayed in the table. Columns IDs can be added, removed, or reordered. */
  displayedColumns: string[] = ['name', 'owner', 'registeredAt', 'hostname', 'softwareInstalled'];

  ngOnInit() {
  }

  onRowClick(id: string) {
    alert(`Not implemented yet ${id}`);
  }
}
