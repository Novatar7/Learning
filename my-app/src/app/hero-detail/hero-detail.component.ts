import {Component, Input} from '@angular/core';
import {NgIf, UpperCasePipe} from '@angular/common';
import {FormsModule} from '@angular/forms';
import {Hero} from '../hero';
import { ActivatedRoute } from '@angular/router';
import { Location } from '@angular/common';
import { Router } from '@angular/router';
import { HeroService } from '../hero.service';

@Component({
  standalone: true,
  selector: 'app-hero-detail',
  templateUrl: './hero-detail.component.html',
  styleUrls: ['./hero-detail.component.css'],
  imports: [FormsModule, NgIf, UpperCasePipe],
})
export class HeroDetailComponent {

  constructor(
    private route:ActivatedRoute,
    private heroservice:HeroService,
    public  location: Location,
    private router:Router,
  ){}

ngOnInit(): void {
  this .getHero();
}

getHero():void{
  const id= Number(this.route.snapshot.paramMap.get('id'));
  this.heroservice.getHero(id)
  .subscribe(hero => this.hero =hero);
}

goBack():void{
  console.log("go bsck")
  this.location.back;

}
  @Input() hero?: Hero;
}