import { NgModule, NO_ERRORS_SCHEMA } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { SigneupComponent } from './components/signeup/signeup.component';
import { FormsModule,ReactiveFormsModule } from '@angular/forms';
import { SignupService } from './services/signup.service';
import { HttpClientModule,HttpClient } from '@angular/common/http';
import { LoginComponent } from './components/login/login.component';
import { LoginService } from './services/login.service';
import { DashboardComponent } from './components/dashboard/dashboard.component';
import { NavbarComponent } from './components/navbar/navbar.component';
import { IndexComponent } from './components/index/index.component';
import { JwtauthenticationService } from './services/jwtauthentication.service';
import { TokenService } from './services/token.service';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import {MatIconModule} from '@angular/material/icon';
import { BynotesComponent } from './components/bynotes/bynotes.component';
import { CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import {MatMenuModule} from '@angular/material/menu';
import { AddcategoryComponent } from './components/addcategory/addcategory.component';
import {MatButtonModule} from '@angular/material/button';
import {MatInputModule} from '@angular/material/input';
import { ShowcategoriesComponent } from './components/showcategories/showcategories.component';
import {MatCardModule} from '@angular/material/card';
import { AddquizesComponent } from './components/addquizes/addquizes.component';
import { AddquestionsComponent } from './components/addquestions/addquestions.component';
import { ShowquizesComponent } from './components/showquizes/showquizes.component';
import {MatSlideToggleModule} from '@angular/material/slide-toggle';
import {MatSelectModule} from '@angular/material/select';
import { ShowquestionsComponent } from './components/showquestions/showquestions.component';
import { ProfileComponent } from './components/profile/profile.component';
import { HomeComponent } from './components/home/home.component';
import { CategoryService } from './services/QuizeService/category.service';
import { CommonModule } from '@angular/common';
import { QuizeService } from './services/QuizeService/quize.service';
import { QuestionService } from './services/QuizeService/question.service';
import { AdminProfileService } from './services/ProfileServices/adminprofile.service';
import { UsernavbarComponent } from './components/UserComponents/usernavbar/usernavbar.component';
import { UsersidebarComponent } from './components/UserComponents/usersidebar/usersidebar.component';
import { UserdashboardComponent } from './components/UserComponents/userdashboard/userdashboard.component';
import { StudentfeesComponent } from './components/UserComponents/studentfees/studentfees.component';
import { PayFeesComponent } from './components/UserComponents/pay-fees/pay-fees.component';
import { PayFessOnlineService } from './services/PaymentsServices/pay-fess-online.service';
import { WindowRefService } from './services/PaymentsServices/window-ref.service';
import { UserloginComponent } from './components/authenticationComponents/userlogin/userlogin.component';
import { CreateaccountComponent } from './components/authenticationComponents/createaccount/createaccount.component';
import { TeachersComponent } from './components/UserComponents/teachers/teachers.component';
import { FeesreceiptComponent } from './components/UserComponents/feesreceipt/feesreceipt.component';
import { StudentprofileComponent } from './components/UserComponents/studentprofile/studentprofile.component';
import { PersonalprofileComponent } from './components/UserComponents/StudentProfileFormsComponetns/personalprofile/personalprofile.component';
import { StudentprofileService } from './services/EcampusServices/StudentProfileServices/studentprofile.service';
import { BusrouteComponent } from './components/UserComponents/busroute/busroute.component';
import { GoogleMapsModule } from '@angular/google-maps';
import { NewsFeedComponent } from './components/UserComponents/news-feed/news-feed.component';
import { AddnewsfeedComponent } from './components/AdminComponents/addnewsfeed/addnewsfeed.component'

import { TeacherServicesService } from './services/TeachersServices/teacher-services.service';
import { QuizetestComponent } from './components/UserComponents/quizetest/quizetest.component';
import { DoemailComponent } from './components/UserComponents/doemail/doemail.component';
import {MatDatepickerModule} from '@angular/material/datepicker';
import { PostnewsserviceService } from './services/newsServices/postnewsservice.service';
import { AddstudentComponent } from './components/AdminComponents/addstudent/addstudent.component';
import { AdminSidebarComponent } from './components/AdminComponents/admin-sidebar/admin-sidebar.component';
import { AdminNavbarComponent } from './components/AdminComponents/admin-navbar/admin-navbar.component';
import { AdminDashboardComponent } from './components/AdminComponents/admin-dashboard/admin-dashboard.component';
import { MatNativeDateModule } from '@angular/material/core';
import { AddStudentServiceService } from './services/adminservices/add-student-service.service';
import { StartquizeComponent } from './components/UserComponents/QuizeComponents/startquize/startquize.component';
import { QuizequestionsComponent } from './components/UserComponents/QuizeComponents/quizequestions/quizequestions.component';
import { StudentreletedService } from './services/StudentServices/studentreleted.service';
import { CKEditorModule } from 'ng2-ckeditor';
import { SafeHtmlPipe } from './CustomPipes/safe-html.pipe';
import { JoditAngularModule } from 'jodit-angular';
import { NgxSpinnerModule } from "ngx-spinner";
import { AboutteacherComponent } from './components/UserComponents/aboutteacher/aboutteacher.component';
import { CommanStudentServiceService } from './services/CommanServices/comman-student-service.service';
import { FeesReciptPdfComponent } from './components/UserComponents/fees-recipt-pdf/fees-recipt-pdf.component';
import { NgxPrintModule } from 'ngx-print';
@NgModule({
  declarations: [
    AppComponent,
    SigneupComponent,
    LoginComponent,
    DashboardComponent,
    NavbarComponent,
    IndexComponent,
    BynotesComponent,
    AddcategoryComponent,
    AddcategoryComponent,
    ShowcategoriesComponent,
    AddquizesComponent,
    AddquestionsComponent,
    ShowquizesComponent,
    ShowquestionsComponent,
    ProfileComponent,
    HomeComponent,
    UsernavbarComponent,
    UsersidebarComponent,
    UserdashboardComponent,
    StudentfeesComponent,
    PayFeesComponent,
    UserloginComponent,
    CreateaccountComponent,
    TeachersComponent,
    FeesreceiptComponent,
    StudentprofileComponent,
    PersonalprofileComponent,
    BusrouteComponent,
    NewsFeedComponent,
    AddnewsfeedComponent,
    QuizetestComponent,
    DoemailComponent,
    AddstudentComponent,
    AdminSidebarComponent,
    AdminNavbarComponent,
    AdminDashboardComponent,
    StartquizeComponent,
    QuizequestionsComponent,
    SafeHtmlPipe,
    AboutteacherComponent,
    FeesReciptPdfComponent
   
  
  ],

  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule,
    BrowserAnimationsModule,
    MatIconModule,
    MatMenuModule,
    MatInputModule,
    MatButtonModule,
    MatCardModule,
    MatSlideToggleModule,
    MatSelectModule,
    FormsModule,
    ReactiveFormsModule,
    CommonModule,
    GoogleMapsModule,
    MatDatepickerModule,
    MatNativeDateModule,
    CKEditorModule,
    NgxPrintModule,
    NgxSpinnerModule
  ],
  schemas: [ CUSTOM_ELEMENTS_SCHEMA,NO_ERRORS_SCHEMA],

  providers: [SignupService,HttpClient,LoginService,JwtauthenticationService,
    TokenService,CategoryService,QuizeService,QuestionService,AdminProfileService,
    PayFessOnlineService,WindowRefService,StudentprofileService,TeacherServicesService,
  PostnewsserviceService,AddStudentServiceService,StudentreletedService,CommanStudentServiceService],
  bootstrap: [AppComponent]
})
export class AppModule { }
