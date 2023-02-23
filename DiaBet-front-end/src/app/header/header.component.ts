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

  userForm = new FormGroup({

    email : new FormControl(''),
    password : new FormControl('')
  })


  getTeamsControls() { return (<FormArray>this.contestForm.get('teams')).controls;}


  user: any;

  isLoggedIn : boolean = false;

  isAdmin : boolean = false;


  url='http://localhost:8082';
  contests='/contests';
  users='/users';

  usersUrl=this.url+this.users;
  contestsUrl=this.url+this.contests;

  constructor(private http : HttpClient) {}


  logged(){

    let email = this.userForm.get('email')?.value;
    let password = this.userForm.get('password')?.value;

    if(email!=null)
    this.http.get(this.usersUrl+'/email/'+email).subscribe(data =>{

      this.user=data;

      if(this.user!=null && password !=null && password == this.user.password){

        alert('logged in');

      }else  {

        console.log(this.userForm.value);

        this.http.post(this.usersUrl, this.userForm.value).subscribe(result=>console.log(result));

        alert('created user & logged in');

      }

      //this.http.patch(this.usersUrl+'/email/'+email+'/true', email).subscribe(result=>console.log(result));

      this.isLoggedIn = true;

      if(this.user.isAdmin==true)
      this.isAdmin = true;
      else
      this.isAdmin = false;




    });






  }

  addNewContest(data : any){

   this.http.post(this.url+this.contests, data).subscribe(result=>console.log(result));

   alert('contest aded');

  }

  alert(){

    console.log(this.contestForm.value);

    this.http.post(this.contestsUrl, this.contestForm.value).subscribe(result=>console.log(result));

  }


}
