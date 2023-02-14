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


  url='http://localhost:8082/contests';

  constructor(private http : HttpClient) { }


  logged(){

    prompt("input passsword");
  }

  addNewContest(data : any){

   this.http.post(this.url, data).subscribe(result=>console.log(result));

   alert('contest aded');

  }

  alert(){

    console.log(this.contestForm.value);

    this.http.post(this.url, this.contestForm.value).subscribe(result=>console.log(result));

  }


}
