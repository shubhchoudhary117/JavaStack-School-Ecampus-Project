import { Component, OnInit } from '@angular/core';
import { NgxSpinnerService } from 'ngx-spinner';
import { PayFessOnlineService } from 'src/app/services/PaymentsServices/pay-fess-online.service';
import { TokenService } from 'src/app/services/token.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-feesreceipt',
  templateUrl: './feesreceipt.component.html',
  styleUrls: ['./feesreceipt.component.css']
})
export class FeesreceiptComponent implements OnInit {
  constructor(private FeesServices: PayFessOnlineService,
    private tokenService: TokenService,
    private spinner: NgxSpinnerService) { }

  spinnerName: any;
  spinnerType: any;
  activeLoader:boolean=false;
  ngOnInit() {



    // loader animation
    this.spinnerName = "sp1";
    this.spinnerType = "ball-atom";
    this.spinner.show(this.spinnerName);
    this.activeLoader=true;

    setTimeout(() => {
      this.activeLoader=false;
      this.spinner.hide(this.spinnerName)
      // call the get student service
      this.getFeesRecipts();
    }, 5000);

  }

  // get the all fees recipts of the current login student
  feesRecipts: any = [];
  getFeesRecipts() {
    this.FeesServices.getFeesRecipts(this.tokenService.getToken()).subscribe(
      (response: any) => {
        console.log(response)
        this.feesRecipts = response.feesRecipts;
        if (response.somethingWentWrong) {
          Swal.fire(
            'Server down?',
            'Server side error ? ',
            'question'
          )
        }
      },
      (error: any) => {
        console.log(error);
      }
    )
  }

  // print the fees recipt
  reciptDetails: any;
  printFeesRecipt(sfid: any) {
    this.reciptDetails = this.feesRecipts.find((curr: any) => {
      if (curr.sfid == sfid) {
        return curr;
      }
    });
  }

  // go back history
  goBack(){
    window.history.back();
  }

}
