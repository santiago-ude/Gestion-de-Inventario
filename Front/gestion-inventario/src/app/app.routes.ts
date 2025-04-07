import { Routes } from '@angular/router';
import { ProductAddComponent } from './products/components/product-add/product-add.component';
import { ProductListComponent } from './products/components/product-list/product-list.component';
import { ProductUpdateComponent } from './products/components/product-update/product-update.component';

export const routes: Routes = [

    {path: '', component: ProductListComponent},
    {path: 'addProduct', component: ProductAddComponent},
    {path: 'listProducts', component: ProductListComponent},
    {path: 'updateProduct', component: ProductUpdateComponent},
];
