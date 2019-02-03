import {Component} from '@angular/core';

@Component({
  selector: 'gc-wait-for',
  template: `
    <mat-spinner
      [diameter]="250"
      [strokeWidth]="10">
    </mat-spinner>
  `,
})
export class WaitForComponent {

}
