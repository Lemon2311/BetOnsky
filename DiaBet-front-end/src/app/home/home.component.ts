import { DataService } from './../services/data.service';
import { data } from 'jquery';
import { Component, OnInit } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { FormArray, FormControl } from '@angular/forms';
import { FormGroup } from '@angular/forms';
import { FormBuilder } from '@angular/forms';
import { JsonPipe } from '@angular/common';
import { catchError, throwError } from 'rxjs';

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

  count = 0;

  date: any;

  url = 'http://localhost:8082';

  userUrl = this.url + '/users';

  contestUrl = this.url + '/contests';

  teamUrl = this.url + '/teams';

  bidUrl = this.url + '/bidPerContest';

  bidForm = this.fb.group({
    bid: 0,

    team: this.fb.group({
      name: [''],
      wins: [''],
      loses: [''],
    }),

    contest: this.fb.group({
      name: [''],
    }),

    user: this.fb.group({
      email: [''],

      password: [''],

      isAdmin: false,
    }),
  });

  bidCreateForm = this.fb.group({
    bid: 0,

    team: this.fb.group,

    user: this.getUser,

    contest: this.fb.group,
  });

  changeTeam(team: any) {
    this.Team?.setValue(team.value);
  }

  get Team() {
    return this.bidCreateForm.get('team');
  }

  changeUser(user: any) {
    this.User?.setValue(user.value);
  }

  get User() {
    return this.bidCreateForm.get('user');
  }

  changeContest(contest: any) {
    this.Contest?.setValue(contest.value);
  }

  get Contest() {
    return this.bidCreateForm.get('contest');
  }

  constructor(
    private http: HttpClient,
    private data: DataService,
    private fb: FormBuilder
  ) {}

  ngOnInit(): void {
    this.getProjects();

    this.data.currentIsAdmin.subscribe((state) => (this.isAdmin = state));

    this.data.currentUserEmail.subscribe((name) => (this.userName = name));
  }

  prepareBetObjectForPut() {
    let objectToSend = this.returnBidFormValue;
  }

  returnBidFormValue() {
    return this.bidForm.value;
  }

  bidFormValue() {
    /*this.bidCreateForm.controls['team']
   this.bidCreateForm.controls['contest'].setValue(this.data.currentContest);
   this.bidCreateForm.controls['user'].setValue(this.getUser);
   */
  }

  objectus: any;

  lastBid: any;

  last: any;

  getObjectByName(url: string, name: string) {
    this.http.get(url + '/' + name).subscribe((result) => {
      return result;
    });
  }

  addBetOnTeam() {
    let teamN = 'team';
    let userN = 'user';
    let contestN = 'contest';
    let team: any;
    let user: any;
    let contest: any;

    teamN = this.objectList[0].teams[0].name;
    contestN = this.objectList[0].name;
    userN = this.getUser();

    console.log(teamN, contestN, userN);

    this.http.get(this.url + '/teams/name/1').subscribe((results1) => {
      console.log(results1);


      this.http.get(this.url + '/users/email/mih').subscribe((results2) => {
        console.log(results2);



      this.http.get(this.url + '/contests/name/n').subscribe((results3) => {
        console.log(results3);


      team = results1;
      user = results2;
      contest = results3;


      console.log(team);
      console.log(user);
      console.log(contest);

      this.bidCreateForm.get('team')?.setValue(team);
      this.bidCreateForm.get('user')?.setValue(user);
      this.bidCreateForm.get('contest')?.setValue(contest);

      console.log(this.bidCreateForm.value);

      this.http
      .post(this.bidUrl, this.bidCreateForm.value)
      .subscribe((result) => {
        console.log(result);
        console.log(this.bidCreateForm.value);
      })


    });

    });

  });

  }

  addBetStackOv() {
    console.log(this.bidUrl);
    this.http
      .post(this.bidUrl, this.bidCreateForm.value)
      .pipe(
        catchError((err) => {
          console.error(err);
          return throwError(() => err);
        })
      )
      .subscribe((result1) => {
        console.log(result1);
        console.log(this.bidCreateForm.value);

        const request2Url = `${this.bidUrl}/last`;
        console.log(request2Url);
        this.http
          .get(request2Url)
          .pipe(
            catchError((err) => {
              console.error(err);
              return throwError(() => err);
            })
          )
          .subscribe((result2) => {
            console.log(result2);
            this.last = result2;

            console.log(this.last.id);

            console.log(this.getUser());

            const request3Url = `${this.bidUrl}/patch/${this.last.id}/${
              this.objectList[0].teams[0].name
            }/${this.getUser()}/${this.objectList[0].name}`;

            console.log(request3Url);

            this.http
              .patch(request3Url, null)
              .pipe(
                catchError((err) => {
                  console.error(err);
                  return throwError(() => err);
                })
              )
              .subscribe((result3) => console.log(result3));
          });
      });
  }

  addBetOnTeamOld() {
    this.http
      .post(this.bidUrl, this.bidCreateForm.value)
      .subscribe((result) => {
        console.log(result);
        console.log(this.bidCreateForm.value);
      });

    this.http.get(this.bidUrl + '/last').subscribe((result) => {
      console.log(result);
      this.last = result;

      console.log(this.last.id);

      console.log(this.getUser());

      this.http
        .patch(
          this.bidUrl +
            '/patch/' +
            this.last.id +
            '/' +
            this.objectList[0].teams[0].name +
            '/' +
            this.getUser() +
            '/' +
            this.objectList[0].name,
          null
        )
        .subscribe((result) => console.log(result));
    });

    console.log(this.http.get(this.bidUrl + '/last').subscribe);

    //user&lastBidNotWorking
  }

  getLastBid() {}

  getTeamByName(teamName: string) {
    return this.http.get(this.teamUrl + '/' + teamName);
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

  getUser() {
    console.log(this.data.userEmailEasy);

    return this.data.userEmailEasy;
  }

  getChosenTeam() {
    /* let team = document.getElementById('team');
       return team;*/
  }
}
