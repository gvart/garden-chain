import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {FlexLayoutModule} from '@angular/flex-layout';
import {WaitForDirective} from './directives/wait-for/wait-for.directive';
import {WaitForComponent} from './directives/wait-for/wait-for.component';
import {JsonPropertyPipe} from './pipes/json-property.pipe';
import {ClrIconModule} from '@clr/angular';

@NgModule({
  imports: [
    CommonModule,
    ClrIconModule,
    FlexLayoutModule,
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
    ClrIconModule,
    FlexLayoutModule,
    WaitForDirective,
    WaitForComponent,
    JsonPropertyPipe,
  ],
})
export class SharedModule { }
