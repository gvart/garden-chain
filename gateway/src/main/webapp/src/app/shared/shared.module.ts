import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {FlexLayoutModule} from '@angular/flex-layout';
import {MatButtonModule, MatCardModule, MatIconModule, MatProgressSpinnerModule} from '@angular/material';
import { WaitForDirective } from './directives/wait-for/wait-for.directive';
import {WaitForComponent} from './directives/wait-for/wait-for.component';
import { JsonPropertyPipe } from './pipes/json-property.pipe';

@NgModule({
  imports: [
    CommonModule,
    FlexLayoutModule,
    MatCardModule,
    MatIconModule,
    MatButtonModule,
    MatProgressSpinnerModule,
  ],
  declarations: [
    WaitForDirective,
    WaitForComponent,
    JsonPropertyPipe,
  ],
  entryComponents: [
    WaitForComponent,
  ],
  exports: [
    CommonModule,
    FlexLayoutModule,
    MatCardModule,
    MatIconModule,
    MatButtonModule,
    MatProgressSpinnerModule,
    WaitForDirective,
    WaitForComponent,
    JsonPropertyPipe,
  ],
})
export class SharedModule { }
