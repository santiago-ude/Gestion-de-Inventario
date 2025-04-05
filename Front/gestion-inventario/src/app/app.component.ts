import { HttpClientModule } from '@angular/common/http';
import { Component } from '@angular/core';
import { Router, RouterOutlet } from '@angular/router';
import { MenuComponent } from "./landingPage/menu/menu.component";
import { ProductAddComponent } from './products/components/product-add/product-add.component';
import { ProductUpdateComponent } from './products/components/product-update/product-update.component';

@Component({
  selector: 'app-root',
  imports: [MenuComponent, HttpClientModule,RouterOutlet],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  title = 'gestion-inventario';
}
