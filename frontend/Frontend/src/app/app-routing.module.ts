import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AddcategoryComponent } from './components/addcategory/addcategory.component';
import { AddquestionsComponent } from './components/addquestions/addquestions.component';
import { AddquizesComponent } from './components/addquizes/addquizes.component';
import { AddnewsfeedComponent } from './components/AdminComponents/addnewsfeed/addnewsfeed.component';
import { AddstudentComponent } from './components/AdminComponents/addstudent/addstudent.component';
import { AdminDashboardComponent } from './components/AdminComponents/admin-dashboard/admin-dashboard.component';
import { CreateaccountComponent } from './components/authenticationComponents/createaccount/createaccount.component';
import { UserloginComponent } from './components/authenticationComponents/userlogin/userlogin.component';
import { BynotesComponent } from './components/bynotes/bynotes.component';
import { DashboardComponent } from './components/dashboard/dashboard.component';
import { HomeComponent } from './components/home/home.component';

import { IndexComponent } from './components/index/index.component';
import { LoginComponent } from './components/login/login.component';
import { NavbarComponent } from './components/navbar/navbar.component';
import { ProfileComponent } from './components/profile/profile.component';
import { ShowcategoriesComponent } from './components/showcategories/showcategories.component';
import { ShowquestionsComponent } from './components/showquestions/showquestions.component';
import { ShowquizesComponent } from './components/showquizes/showquizes.component';
import { SigneupComponent } from './components/signeup/signeup.component';
import { AboutteacherComponent } from './components/UserComponents/aboutteacher/aboutteacher.component';
import { BusrouteComponent } from './components/UserComponents/busroute/busroute.component';
import { DoemailComponent } from './components/UserComponents/doemail/doemail.component';
import { FeesReciptPdfComponent } from './components/UserComponents/fees-recipt-pdf/fees-recipt-pdf.component';
import { FeesreceiptComponent } from './components/UserComponents/feesreceipt/feesreceipt.component';
import { NewsFeedComponent } from './components/UserComponents/news-feed/news-feed.component';
import { PayFeesComponent } from './components/UserComponents/pay-fees/pay-fees.component';
import { QuizequestionsComponent } from './components/UserComponents/QuizeComponents/quizequestions/quizequestions.component';
import { StartquizeComponent } from './components/UserComponents/QuizeComponents/startquize/startquize.component';
import { QuizetestComponent } from './components/UserComponents/quizetest/quizetest.component';
import { StudentfeesComponent } from './components/UserComponents/studentfees/studentfees.component';
import { StudentprofileComponent } from './components/UserComponents/studentprofile/studentprofile.component';
import { PersonalprofileComponent } from './components/UserComponents/StudentProfileFormsComponetns/personalprofile/personalprofile.component';
import { TeachersComponent } from './components/UserComponents/teachers/teachers.component';
import { UserdashboardComponent } from './components/UserComponents/userdashboard/userdashboard.component';

const routes: Routes = [
  {
    path:"fees-recipt-pdf/:reciptid",
    component:FeesReciptPdfComponent,
    pathMatch:'full'
  },

  {
    path: "revaecampus/login",
    component: UserloginComponent,
    pathMatch: "full"
  },
  {
    path: "home",
    component: HomeComponent,
    pathMatch: 'full'
  },
  {
    path: "student/dashboard",
    component: UserdashboardComponent,

    children: [
      {

        path: 'news-feed',
        component: NewsFeedComponent,
        pathMatch: 'full',

      },
      {
        path: "fees",
        component: StudentfeesComponent,
        pathMatch: 'full'
      },
      {
        path: "payfees",
        component: PayFeesComponent,
        pathMatch: 'full'
      },
      {
        path: "teachers",
        component: TeachersComponent,
        pathMatch: 'full'
      },
      {
        path: "about-teacher/:tid",
        component: AboutteacherComponent,
        pathMatch: 'full'
      },
      {
        path: "feesreceipt",
        component: FeesreceiptComponent,
        pathMatch: 'full'
      },
      {
        path: "profile",
        component: StudentprofileComponent,
        pathMatch: 'full'
      },
      {
        path: "bus-route",
        component: BusrouteComponent,
        pathMatch: 'full'
      },
      {
        path: "quize-test",
        component: QuizetestComponent,
        pathMatch: 'full'
      },
      {
        path: "quize/start/:quize_id",
        component: StartquizeComponent,
        pathMatch: 'full'
      }, {
        path: "quize/start/questions/:quize_id",
        component: QuizequestionsComponent,
        pathMatch: 'full'
      },
      {
        path: "do-email",
        component: DoemailComponent,
        pathMatch: 'full'
      }
    ]

  },
  {
    path: "signup",
    component: SigneupComponent,
    pathMatch: "full"
  }
  , {
    path: "login",
    component: LoginComponent,
    pathMatch: 'full'
  }
  // ,{
  //   path:"admin",
  //   component:DashboardComponent,
  //   children:[
  //     {
  //       path:"notes",
  //       component:BynotesComponent,
  //       pathMatch:"full"
  //     }
  //     ,{
  //       path:"add-category",
  //       component:AddcategoryComponent,
  //       pathMatch:'full'
  //     }
  //     ,{
  //       path:"show-category",
  //       component:ShowcategoriesComponent,
  //       pathMatch:'full'
  //     }
  //     ,{
  //       path:"add-quize",
  //       component:AddquizesComponent,
  //       pathMatch:'full'
  //     },
  //     {
  //       path:"show-quizes",
  //       component:ShowquizesComponent,
  //       pathMatch:'full'
  //     }
  //     ,
  //     {
  //       path:"add-questions/:id",
  //       component:AddquestionsComponent,
  //       pathMatch:'full'
  //     }
  //     ,
  //     {
  //       path:"show-questions/:id",
  //       component:ShowquestionsComponent,
  //       pathMatch:'full'
  //     } ,
  //     {
  //       path:"profile",
  //       component:ProfileComponent,
  //       pathMatch:'full'
  //     }
  //     ,
  //     {
  //       path:"home",
  //       component:HomeComponent,
  //       pathMatch:'full'
  //     },
  //     {
  //       path:"add-student",
  //       component:AddstudentComponent,
  //       pathMatch:'full'
  //     },
  //     {
  //       path:"add-newsfeed",
  //       component:AddnewsfeedComponent,
  //       pathMatch:'full'
  //     }
  //   ]
  // }
  ,
  {
    path: "admin/dashboard",
    component: AdminDashboardComponent,
    children: [
      {
        path: 'profile',
        component: ProfileComponent,
        pathMatch: 'full'
      },
      {
        path: "add-news",
        component: AddnewsfeedComponent,
        pathMatch: 'full'
      }, {
        path: "add-student",
        component: AddstudentComponent,
        pathMatch: 'full'
      }
      , {
        path: "add-category",
        component: AddcategoryComponent,
        pathMatch: 'full'
      }
      , {
        path: "show-category",
        component: ShowcategoriesComponent,
        pathMatch: 'full'
      }
      , {
        path: "add-quize",
        component: AddquizesComponent,
        pathMatch: 'full'
      },
      {
        path: "show-quizes",
        component: ShowquizesComponent,
        pathMatch: 'full'
      }
      ,
      {
        path: "add-questions/:id",
        component: AddquestionsComponent,
        pathMatch: 'full'
      }
      ,
      {
        path: "show-questions/:id",
        component: ShowquestionsComponent,
        pathMatch: 'full'
      }

    ]

  },
  {
    path: "navbar",
    component: NavbarComponent,
    pathMatch: 'full'
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
