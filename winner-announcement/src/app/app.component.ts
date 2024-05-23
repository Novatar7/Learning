import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'Winner-announcement';

  winnerData: any;

  onWinnerSelected(winnerData: any): void {
    this.winnerData = winnerData;
  }
}
