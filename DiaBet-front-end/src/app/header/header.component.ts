import { HttpClient } from '@angular/common/http';

import { Component, OnInit } from '@angular/core';
import { FormsModule,ReactiveFormsModule } from '@angular/forms';
import { data } from 'jquery';
import { FormGroup, FormControl, Validators, FormArray} from '@angular/forms'

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {

  ngOnInit(): void {

  }


  contestForm = new FormGroup({

    name: new FormControl(''),

    teams: new FormArray([

      new FormGroup({

          name : new FormControl(''),
          wins : new FormControl(''),
          losses : new FormControl('')


      })
      ,
      new FormGroup({

          name : new FormControl(''),
          wins : new FormControl(''),
          losses : new FormControl('')

      })

    ])




  })


  getTeamsControls() { return (<FormArray>this.contestForm.get('teams')).controls;}


  email : any;

  object: any;


  url='http://localhost:8082';
  contests='/contests';
  users='/users';
  usersUrl=this.url+this.users;

  constructor(private http : HttpClient) {}


  logged(){



    this.http.get(this.usersUrl+'/email/'+this.email).subscribe(data =>{
       this.object=data;
    });


    let password = prompt("input passsword");

    if(password==this.object.password){

    alert('logged in');

    }else  {

      this.object.password = password;
      this.object.email = this.email;

      this.http.post(this.usersUrl, this.object).subscribe(result=>console.log(result));

      alert('created user & logged in');

    }

    this.object.loggedIn=true;


  }

  addNewContest(data : any){

   this.http.post(this.url+this.contests, data).subscribe(result=>console.log(result));

   alert('contest aded');

  }

  alert(){

    console.log(this.contestForm.value);

    this.http.post(this.url, this.contestForm.value).subscribe(result=>console.log(result));

  }


}
