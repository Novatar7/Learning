// winner.service.ts
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

export interface Winner {
  name: string;
  email: string;
}

@Injectable({
  providedIn: 'root'
})
export class WinnerService {
  private apiUrl = 'http://localhost:8080/api';

  constructor(private http: HttpClient) {}

  uploadCSV(file: File): Observable<void> {
    const formData = new FormData();
    formData.append('file', file);
    return this.http.post<void>(`${this.apiUrl}/upload`, formData);
  }

  getWinner(): Observable<Winner> {
    return this.http.get<Winner>(`${this.apiUrl}/winner`);
  }
}
