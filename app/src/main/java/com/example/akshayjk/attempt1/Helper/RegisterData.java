package com.example.akshayjk.attempt1.Helper;

/**
 * Created by AkshayJk on 22-Nov-17.
 */

 public class RegisterData {


         //private variables
         String first_name;
         String last_name;
         String email_id;
         String do_b;
         String grad;
         String status;
         String gender;
        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
        this.password = password;
        }

        String password;

        public RegisterData(){

        }

        public RegisterData( String first_name, String  last_name, String email_id, String phone_number, String  dob, String Grad, String Status, String Gender){
            this.first_name = first_name;
            this.last_name = last_name;
            this.email_id=email_id;
            this.do_b=dob;
            this.grad=Grad;
            this.status=Status;
            this.gender=Gender;
        }


        public String getfirstName() {
        // TODO Auto-generated method stub
            return first_name;
        }

        public void setfirstName(String first_name){
            this.first_name =first_name;
        }

        public String getlastName() {
        // TODO Auto-generated method stub
            return last_name;
        }

        public void setlastName(String last_name){
            this.last_name =last_name;
        }

        public String getEmailId() {
        // TODO Auto-generated method stub
            return email_id;
        }

        public void setEmailId(String email_id){
            this.email_id =email_id;
        }

        public String getdOB() {
        // TODO Auto-generated method stub
            return do_b;
        }

        public void setDoB(String dob){
            this.do_b=dob;
        }

        public String getGrad() {
            return grad;
        }

        public void setGrad(String Grads) {
            this.grad=Grads;
        }

        public String getGender() {
            return gender;
       }

        public void setGender(String Gender) {
            this.gender=Gender;
        }
        public String get_Status() {
            return status;
        }

        public void set_Status(String Status) {
            this.status=Status ;
        }

}



