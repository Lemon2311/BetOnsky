import { Injectable } from '@angular/core';
import { BehaviorSubject } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class DataService {

  private stateSource = new BehaviorSubject<boolean>(false);
  currentState = this.stateSource.asObservable();

  constructor() {}

  changeMessage(message: boolean) {
    this.stateSource.next(message);
  }
}
