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
  isAdmin: boolean = false ;

  constructor(private http: HttpClient, private data: DataService) {}

  ngOnInit(): void {
    this.getProjects();
    this.data.currentState.subscribe(message=>this.isAdmin=message);

  }

  getProjects() {
    let url = 'http://localhost:8082/contests';

    this.http.get(url).subscribe((data) => {
      this.objectList = data;
      console.log(data);
    });
  }
}
