import { Component, OnInit } from '@angular/core';
import { OktaAuthService } from '@okta/okta-angular';
import { MatButtonModule, MatCardModule, MatToolbarModule } from '@angular/material';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {
  constructor() {
  }

  async ngOnInit() {

  }
}
