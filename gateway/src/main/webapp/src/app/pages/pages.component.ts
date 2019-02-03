import { Component, OnInit } from '@angular/core';
import {MENU} from './pages-menu';
@Component({
  selector: 'app-pages',
  template: `
    <div fxFlex>
      <mat-toolbar color="primary">
          <button fxHide fxShow.sm fxShow.xs mat-icon-button (click)="snav.toggle()">
            <mat-icon>menu</mat-icon>
          </button>
        <h1>Garden Chain</h1>
      </mat-toolbar>
      <mat-sidenav-container>
        <mat-sidenav #snav mode="side" opened>
          <div fxFlex>
            <mat-nav-list>
              <mat-list-item *ngFor="let item of menu" [routerLink]="item.route" routerLinkActive="active">
                <mat-icon>{{item.icon}}</mat-icon> <span class="mat-h2 mb-0">{{item.title}}</span></mat-list-item>
            </mat-nav-list>
          </div>
        </mat-sidenav>
        <mat-sidenav-content>
          <router-outlet></router-outlet>
        </mat-sidenav-content>
      </mat-sidenav-container>
      <footer>
        <div>
        </div>
      </footer>
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
