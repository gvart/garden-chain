import { Component, OnInit } from '@angular/core';
import {MENU} from './pages-menu';
@Component({
  selector: 'app-pages',
  templateUrl: 'pages.component.html',
  styleUrls: ['./pages.component.scss']
})
export class PagesComponent implements OnInit {
  menu = MENU;
  constructor() { }

  ngOnInit() {
  }

}
