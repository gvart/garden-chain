import {Component, OnInit, ViewChild} from '@angular/core';
import {ELEMENT_DATA} from './temp-data';
import {MatSort, MatTableDataSource} from '@angular/material';

@Component({
  selector: 'app-device-list',
  templateUrl: './device-list.component.html',
  styleUrls: ['./device-list.component.scss']
})
export class DeviceListComponent implements OnInit {
  @ViewChild(MatSort) sort: MatSort;

  /** Columns displayed in the table. Columns IDs can be added, removed, or reordered. */
  displayedColumns: string[] = ['name', 'owner', 'registeredAt', 'hostname', 'softwareInstalled'];
  dataSource = new MatTableDataSource(ELEMENT_DATA);

  ngOnInit() {
    this.dataSource.sort = this.sort;
  }

  onRowClick(id: string) {
    alert(`Not implemented yet ${id}`);
  }
}
