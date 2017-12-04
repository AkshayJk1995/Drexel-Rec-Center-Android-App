package com.example.akshayjk.attempt1.Helper;

/**
 * Created by AkshayJk on 01-Dec-17.
 */

public class GroupData {

    String first_name;
    String last_name;
    String email_id;
    String doe;
    String group_name;
    int timing;
    String part_of_day;
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    String password;

    public GroupData(){

    }

    public GroupData( String first_name, String  last_name, String email_id, String phone_number, String  dob, String group_name, String part_of_day, int timing){
        this.first_name = first_name;
        this.last_name = last_name;
        this.email_id=email_id;
        this.doe=dob;
        this.group_name=group_name;
        this.part_of_day=part_of_day;
        this.timing=timing;
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
        return doe;
    }

    public void setDoB(String dob){
        this.doe=dob;
    }

    public String getgroup() {
        return group_name;
    }

    public void setgroup(String groups) {
        this.group_name=groups;
    }

    public int gettiming() {
        return timing;
    }

    public void settiming(int timing) {
        this.timing=timing;
    }
    public String get_part_of_day() {
        return part_of_day;
    }

    public void set_part_of_day(String part_of_day) {
        this.part_of_day=part_of_day ;
    }

}

