import { Injectable } from '@angular/core';
import { BehaviorSubject } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class WinnerDataService {
  private winnerDataSource = new BehaviorSubject<any>(null);
  currentWinnerData = this.winnerDataSource.asObservable();

  setWinnerData(data: any): void {
    this.winnerDataSource.next(data);
  }
}
