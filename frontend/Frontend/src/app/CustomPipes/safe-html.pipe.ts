import { Pipe, PipeTransform } from '@angular/core';
import {DomSanitizer} from '@angular/platform-browser';

@Pipe({
  name: 'safeHtml'
})
export class SafeHtmlPipe implements PipeTransform {
  constructor(private sanitized: DomSanitizer) {}
  transform(html: string): unknown {
    return this.sanitized.bypassSecurityTrustHtml(html);
  }

}
