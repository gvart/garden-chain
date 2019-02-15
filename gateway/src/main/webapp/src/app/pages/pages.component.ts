import { Component, OnInit } from '@angular/core';
import {MENU} from './pages-menu';
@Component({
  selector: 'app-pages',
  template: `
    <div class="main-container">
      <header class="header header-6">
        ...
      </header>
      <nav class="subnav">
        ...
      </nav>
      <div class="content-container">
        <div class="content-area">
          <router-outlet></router-outlet>
        </div>
        <nav class="sidenav">
          ...
        </nav>
      </div>
    </div>
  `,
  styleUrls: ['./pages.component.scss']
})
export class PagesComponent implements OnInit {
  menu = MENU;
  constructor() { }

  ngOnInit() {
  }

}
