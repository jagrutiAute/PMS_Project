import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'noteIsurgent'
})
export class NoteIsurgentPipe implements PipeTransform {

  // transform(value: unknown, ...args: unknown[]): unknown {
  //   return null;
  // }

  transform(isUrgent: any): string {
    if (isUrgent)
      return "Urgent";
    else
      return "Not Urgent";
  }
}
