import {Component, OnInit} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {MatSnackBar} from "@angular/material/snack-bar";

@Component({
  selector: 'root-component',
  templateUrl: './index.component.html',
  styleUrls: ['./index.component.less'],
  providers: [],
})
export class IndexComponent implements OnInit {
  title = "web"
  constructor(private http: HttpClient, private _snackBar: MatSnackBar) {
  }

  ngOnInit(): void {
    //init
  }

  submitRequest(): void {
    this.http.post('/api/hello', {name: "name"})
      .subscribe(
        () => {
          //erfolg
        },
        () => {
          alert("Fehler bei der Datenübertragung")
        }
      );
  }
}
