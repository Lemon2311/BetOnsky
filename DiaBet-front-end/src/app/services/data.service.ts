import { Injectable } from '@angular/core';
import { BehaviorSubject } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class DataService {

  private stateIsAdmin = new BehaviorSubject<boolean>(false);
  currentIsAdmin = this.stateIsAdmin.asObservable();

  private stateUserName = new BehaviorSubject<string>('');
  currentUserName = this.stateUserName.asObservable();

  constructor() {}

  changeIsAdmin(isAdmin: boolean) {
    this.stateIsAdmin.next(isAdmin);
  }

  changeUserName(name: string) {
    this.stateUserName.next(name);
  }
}
