import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']

})
export class HomeComponent implements OnInit {

  objectList : any;

  constructor(private http: HttpClient) {

  }

  ngOnInit(): void {
    this.getProjects();
  }

  getProjects(){

    let url = 'http://localhost:8082/contests';

    this.http.get(url).subscribe(data =>
    {
      this.objectList = data;
      console.log(data);

    });

  }

}
