import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'noteSort'
})
export class NoteSortPipe implements PipeTransform {

  // transform(value: unknown, ...args: unknown[]): unknown {
  //   return null;
  // }

  transform(notes: any[], field: any): any[] {
    let sortedNotesDesc = notes.sort((first, second) => 0 - (first.field < second.field ? -1 : 1));
    return sortedNotesDesc;
  }
}
