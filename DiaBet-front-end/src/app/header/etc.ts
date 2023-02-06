
<div class="form-group">
<label for="Team2">Team 2 :</label>
<br><br>
<input type="Name" [(ngModel)]="name2" class="form-control" id="exampleInputEmail1" placeholder="Name">
</div>
<br>
<div class="form-group">
<input type="Wins" [(ngModel)]="wins2" class="form-control" id="exampleInputPassword1" placeholder="Wins">
</div>
<br>
<div class="form-group">
<input type="Loses" [(ngModel)]="loses2" class="form-control" id="exampleInputPassword1" placeholder="Loses">
</div>



<div class="form-group" [(ngModel)]="contest" >


<form id="form" #ContestForm="ngForm"  (ngSubmit)="addNewContest(ContestForm.value)">
<div class="form-group" [(ngModel)]="contest" >
  <input type="Contest Name" [(ngModel)]="name"  class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Contest Name">

<br>

<div class="form-group" [(ngModel)]="teams"  *ngFor="let i of [].constructor(2)">
  <br>
  <label>Team {{i}} :</label>
  <br><br>
  <input type="Name" [(ngModel)]="name"  class="form-control" id="exampleInputEmail1" placeholder="Name">

<br>
<div class="form-group">
  <input type="Wins" [(ngModel)]="wins"  class="form-control" id="exampleInputPassword1" placeholder="Wins">
</div>
<br>
<div class="form-group">
  <input type="Loses" [(ngModel)]="loses"  class="form-control" id="exampleInputPassword1" placeholder="Loses">
</div>
</div>

<br>

</div>


</form>


<div class="modal-footer">
<button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Cancel</button>
<button type="submit" class="btn btn-primary" data-bs-dismiss="modal">Next</button>
</div>
