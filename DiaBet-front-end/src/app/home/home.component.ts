import { data } from 'jquery';
import { DataService } from '../services/data.service';
import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { FormArray, FormControl } from '@angular/forms';
import { FormGroup } from '@angular/forms';
import { FormBuilder } from '@angular/forms';

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

  bidUrl = this.url + '/bidPerContest'

  bidForm = this.fb.group({

      bid : 0,

      team: this.fb.group({

       name  : [''],
       wins  : [''],
       loses : ['']

      }),

      contest : this.fb.group({
        name:['']
      }),

      user: this.fb.group({

      email : [''],

      password : [''],

      isAdmin : false

    })


  })






  constructor(private http: HttpClient, private data: DataService, private fb: FormBuilder) {}

  ngOnInit(): void {
    this.getProjects();
    this.data.currentIsAdmin.subscribe((state) => (this.isAdmin = state));
    this.data.currentUserName.subscribe((name) => (this.userName = name));
  }

  prepareBetObjectForPut(){

     let objectToSend = this.returnBidFormValue

  }


  returnBidFormValue() {

    return this.bidForm.value;

  }

  addBetOnTeam() {

            //this.http.put((this.bidUrl + '/set/'),);

  }

  getTeamByName(teamName:string){
    return this.http.get(this.teamUrl+ '/' +teamName);
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

  getUser(){
    return this.data.currentUserObject;
  }

  getChosenTeam(){

       let team = document.getElementById('team');
       return team;

  }


}
