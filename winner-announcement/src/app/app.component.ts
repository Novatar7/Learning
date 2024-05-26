import { Component } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  file: File | null = null;
  winner: any = null;

  constructor(private http: HttpClient) {}

  onFileChange(event: any) {
    this.file = event.target.files[0];
  }

  uploadFile() {
    if (this.file) {
      const formData = new FormData();
      formData.append('file', this.file);

      this.http.post('http://localhost:8080/api/upload', formData)
        .subscribe(response => {
          console.log('File uploaded successfully', response);
        }, error => {
          console.error('Failed to upload file', error);
        });
    }
  }

  getWinner() {
    this.http.get('http://localhost:8080/api/winner')
      .subscribe(response => {
        this.winner = response;
      }, error => {
        console.error('Failed to get winner', error);
      });
  }

}
