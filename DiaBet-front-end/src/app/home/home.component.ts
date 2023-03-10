import { DataService } from '../services/data.service';
import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css'],
})
export class HomeComponent implements OnInit {
  objectList: any;
  isAdmin: boolean = false;
  teamToBet: any;
  userName = '';

  url = 'http://localhost:8082';

  contestUrl = this.url + '/contests';

  teamUrl = this.url + '/teams';

  constructor(private http: HttpClient, private data: DataService) {}

  ngOnInit(): void {
    this.getProjects();
    this.data.currentIsAdmin.subscribe((state) => (this.isAdmin = state));
    this.data.currentUserName.subscribe((name) => (this.userName = name));
  }

  betOnTeam(object: any) {
    this.http.patch(this.teamUrl + '/' + this.teamToBet.name, this.userName);
  }

  getProjects() {
    this.http.get(this.contestUrl).subscribe((data) => {
      this.objectList = data;
      console.log(data);
    });
  }

  deleteContest(object: any) {
    this.http
      .delete(this.contestUrl + '/' + object.name)
      .subscribe((result) => console.log(result));
  }
}
