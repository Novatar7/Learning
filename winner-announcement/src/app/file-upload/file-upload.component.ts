import { Component,Output,EventEmitter } from '@angular/core';
import { WinnerService } from '../winner.service';
import {WinnerDataService} from "../winner-data.service";

@Component({
  selector: 'app-file-upload',
  templateUrl: './file-upload.component.html',
  styleUrls: ['./file-upload.component.css']
})
export class FileUploadComponent {
  selectedFile: File | null = null;
  @Output() winnerSelected = new EventEmitter<any>();

  constructor(private winnerService: WinnerService) { }

  onFileSelected(event: any): void {
    this.selectedFile = event.target.files[0];
  }

  onUpload(): void {
    if (this.selectedFile) {
      this.winnerService.uploadFile(this.selectedFile).subscribe(response => {
        // Handle the response, possibly emit an event or use a service to pass data to the slot machine component
        this.winnerDataService.setWinnerData(response);
      });
    }
  }
}
