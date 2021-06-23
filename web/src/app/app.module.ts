import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';

import {IndexComponent} from './index/index.component';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import {MatFormFieldModule} from "@angular/material/form-field";
import {MatIconModule} from "@angular/material/icon";
import {MatInputModule} from "@angular/material/input";
import {MatCardModule} from "@angular/material/card";
import {MatButtonModule} from "@angular/material/button";
import {MatStepperModule} from "@angular/material/stepper";
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import {MatOptionModule} from "@angular/material/core";
import {MatSelectModule} from "@angular/material/select";
import {HttpClientModule} from "@angular/common/http";
import {MatAutocompleteModule} from "@angular/material/autocomplete";
import {MatTableModule} from "@angular/material/table";
import {MatExpansionModule} from "@angular/material/expansion";
import {MatDatepickerModule} from "@angular/material/datepicker";
import {MatDividerModule} from "@angular/material/divider";
import {MatListModule} from "@angular/material/list";
import {MatProgressSpinnerModule} from "@angular/material/progress-spinner";
import {NgxMatSelectSearchModule} from "ngx-mat-select-search";
import {MatSlideToggleModule} from '@angular/material/slide-toggle';
import {MatCheckboxModule} from "@angular/material/checkbox";
import {MatButtonToggleModule} from "@angular/material/button-toggle";
import {appRoutingModule} from "./app.routing";
import { AppComponent } from './app.component';
import {MatSnackBarModule} from "@angular/material/snack-bar";

@NgModule({
  declarations: [
    IndexComponent,
    AppComponent
  ],
  imports: [
    BrowserModule,
    BrowserAnimationsModule,
    HttpClientModule,
    MatFormFieldModule,
    MatIconModule,
    MatInputModule,
    MatCardModule,
    MatButtonModule,
    MatStepperModule,
    MatButtonToggleModule,
    FormsModule,
    MatOptionModule,
    MatSelectModule,
    MatAutocompleteModule,
    ReactiveFormsModule,
    MatTableModule,
    MatExpansionModule,
    MatDatepickerModule,
    MatDividerModule,
    MatListModule,
    MatProgressSpinnerModule,
    NgxMatSelectSearchModule,
    MatSlideToggleModule,
    MatCheckboxModule,
    MatSnackBarModule,
    appRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule {
}
