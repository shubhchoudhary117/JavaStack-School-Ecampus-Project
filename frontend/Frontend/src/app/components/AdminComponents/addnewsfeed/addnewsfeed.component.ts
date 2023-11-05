import { Component, OnInit } from '@angular/core';


import { PostnewsserviceService } from 'src/app/services/newsServices/postnewsservice.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-addnewsfeed',
  templateUrl: './addnewsfeed.component.html',
  styleUrls: ['./addnewsfeed.component.css']
})
export class AddnewsfeedComponent implements OnInit {
  constructor(private newsService: PostnewsserviceService) { }
  ngOnInit() {
    
  }



  editorContent = {
    content: ""
  }
  // declare the form handler
  htmlContent: any;
  newsContent = {
    content: ""
  }

  // create validation object
  validation = {
    contentFieldIsEmpty: false,
    allFieldsEmpty: false
  }
  addNews() {
    console.log(this.editorContent)
    if (this.editorContent.content != "") {
      // update the validation object
      this.validation.allFieldsEmpty = false;
      this.validation.contentFieldIsEmpty = false;
      // everything is ok call the api and send news content

      this.newsService.addNewsApi(this.editorContent).subscribe(
        (response: any) => {
          console.log(response)
          // check the news is added or not
          if (response.newsIsAdded) {
            Swal.fire({
              target: ".fees-success-alert",
              icon: 'success',
              title: 'new is added successfully',
              showConfirmButton: false,
              timer: 1500
            })
            // clear the texteditor
            this.newsContent.content = ""
          }
          // if something went wrok than
          if (response.somethingWentWrong) {
            Swal.fire({
              icon: 'error',
              title: 'Oops...',
              text: 'Something went wrong!',
              footer: '<a href="">Why do I have this issue?</a>'
            })
          }
        }, (error: any) => {
          Swal.fire({
            icon: 'error',
            title: 'Oops...',
            text: 'Something went wrong!',
            footer: '<a href="">Why do I have this issue?</a>'
          })
          console.log(error)
        }
      )
    } else {
      if (this.editorContent.content == "") {
        this.validation.allFieldsEmpty = true;
      } else {
        if (this.editorContent.content == "") { this.validation.contentFieldIsEmpty = true } else { this.validation.contentFieldIsEmpty = true }
      }
    }
  }



  // ckeditor configuration ------------------------------------------------



}