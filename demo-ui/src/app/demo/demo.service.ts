import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { TimeZoneItem } from './models/time-zone-item';
import { TimeItem } from './models/time-item';
import { TimeItemDto } from './models/time-item-dto';


@Injectable({
  providedIn: 'root'
})
export class DemoService {
  private url: string;
  private endPoint: string = '/time-zones'
  private endPointPost: string = '/events';
  constructor(private httpClient: HttpClient) {
    this.url = environment.apiUrl + environment.apiPort + this.endPoint;
  }

  getTimeZoneList(): Observable<Array<TimeZoneItem>> {
    return this.httpClient.get<Array<TimeZoneItem>>(this.url);
  }

  calculate(item: TimeItem): Observable<TimeItemDto> {
    return this.httpClient.post<TimeItemDto>(this.url + this.endPointPost, item)
  }
}
