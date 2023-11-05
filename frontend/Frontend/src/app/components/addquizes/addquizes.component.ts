import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { QuizeService } from 'src/app/services/QuizeService/quize.service';

@Component({
  selector: 'app-addquizes',
  templateUrl: './addquizes.component.html',
  styleUrls: ['./addquizes.component.css']
})
export class AddquizesComponent implements OnInit {
  constructor(private quizeService: QuizeService, private router: Router) { }
  // declare categories data object
  allCategories: any = [];
  ngOnInit() {
    this.quizeService.getCategories().subscribe(
      (response: any) => {
        console.log(response)
        this.allCategories = response;
      },
      (err: any) => {
        console.log(err)
      }
    )
  }
  // declare the quize data storing data object
  quizeData = {
    title: "",
    description: "",
    maxmarks: "",
    numberofquestions: "",
    active: false,
    category: ""
  }
  Data: any;
  // declare the form validation variables
  titleFieldIsEmpty: Boolean = false;
  descriptionFieldIsEmpty: Boolean = false;
  maxmarksFieldIsEmpty: Boolean = false;
  numberofquestionsFieldIsEmpty: Boolean = false;
  optionsFieldIsEmpty: Boolean = false;
  allFieldsIsEmpty: Boolean = false;

  // define form handlers
  addQuize() {
    console.log(this.quizeData)
    if (this.quizeData.title != "" && this.quizeData.description != "" && this.quizeData.maxmarks != "" && this.quizeData.numberofquestions != "" && this.quizeData.category != "") {
      // set the validation variables
      this.allFieldsIsEmpty = false;
      this.titleFieldIsEmpty = false;
      this.descriptionFieldIsEmpty = false;
      this.maxmarksFieldIsEmpty = false;
      this.numberofquestionsFieldIsEmpty = false;
      this.optionsFieldIsEmpty = false;

      // create orignal data object
      this.Data = {
        title: this.quizeData.title,
        description: this.quizeData.description,
        maxmarks: this.quizeData.maxmarks,
        numberofquestions: this.quizeData.numberofquestions,
        active: this.quizeData.active,
        category: {
          cid: this.quizeData.category
        }

      }

      // post the quizes data 
      this.quizeService.addQuize(this.Data).subscribe(
        (response: any) => {
          if (response.quizeIsAdded) {
            this.quizeData.title = ""
            this.quizeData.description = ""
            this.quizeData.maxmarks = ""
            this.quizeData.numberofquestions = ""
            this.quizeData.category = ""
            // redirect on show quizes page
            this.router.navigateByUrl("/admin/show-quizes")
          }
        },
        (err: any) => {
          console.log(err)
        }
      )

    }
    else {
      if (this.quizeData.title == "" && this.quizeData.description == "" && this.quizeData.maxmarks == "" && this.quizeData.numberofquestions == "" && this.quizeData.category == "") {
        this.allFieldsIsEmpty = true;
      }
      else {
        this.allFieldsIsEmpty = false;
        if (this.quizeData.title == "") { this.titleFieldIsEmpty = true } else { this.titleFieldIsEmpty = false }
        if (this.quizeData.description == "") { this.descriptionFieldIsEmpty = true } else { this.descriptionFieldIsEmpty = false }
        if (this.quizeData.maxmarks == "") { this.maxmarksFieldIsEmpty = true } else { this.maxmarksFieldIsEmpty = false }
        if (this.quizeData.numberofquestions == "") { this.numberofquestionsFieldIsEmpty = true } else { this.numberofquestionsFieldIsEmpty = false }
        if (this.quizeData.category == "") { this.optionsFieldIsEmpty = true } else { this.optionsFieldIsEmpty = false }
      }
    }
  }

}
