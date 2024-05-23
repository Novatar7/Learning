import { Component, Input, OnInit } from '@angular/core';
import { trigger, state, style, animate, transition } from '@angular/animations';

@Component({
  selector: 'app-slot-machine',
  templateUrl: './slot-machine.component.html',
  styleUrls: ['./slot-machine.component.css'],
  animations: [
    trigger('slotMachine', [
      transition('* => *', [
        animate('2s ease-in-out', style({ transform: 'translateY(0)' }))
      ])
    ])
  ]
})
export class SlotMachineComponent implements OnInit {
  @Input() winnerData: any={};
  @Input() maskedData: string = '';

  ngOnInit(): void {
    this.runSlotMachine();
  }

  runSlotMachine(): void {
    setTimeout(() => {
      // Add logic to animate the slot machine effect
      // Update the displayed winner data after the animation completes
    }, 2000); // Adjust timing as needed
  }
}
