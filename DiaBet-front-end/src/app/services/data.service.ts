import { Injectable } from '@angular/core';
import { BehaviorSubject, ReplaySubject, Subject } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class DataService {

  private stateIsAdmin = new BehaviorSubject<boolean>(false);
  currentIsAdmin = this.stateIsAdmin.asObservable();

  private stateUserName = new BehaviorSubject<string>('');
  currentUserName = this.stateUserName.asObservable();

  private stateUserObject = new Subject<any>;
  currentUserObject = this.stateUserObject.asObservable();

  private stateContest = new Subject<any>;
  currentContest = this.stateContest.asObservable();


  constructor() {}

  updateContest(user : object){
    this.stateContest.next(Object);

  }

  updateUser(user : object){
    this.stateUserObject.next(Object);

  }

  changeIsAdmin(isAdmin: boolean) {
    this.stateIsAdmin.next(isAdmin);
  }

  changeUserName(name: string) {
    this.stateUserName.next(name);
  }


}
