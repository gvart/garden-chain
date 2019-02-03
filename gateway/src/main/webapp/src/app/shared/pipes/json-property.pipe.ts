import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'gcJsonProperty'
})
export class JsonPropertyPipe implements PipeTransform {
  transform(value: string, args?: any): any {
      value = value.replace(/([a-z](?=[A-Z]))/g, '$1 ').toLowerCase();
      return value.substr(0, 1).toUpperCase() + value.substr(1);
  }

}
