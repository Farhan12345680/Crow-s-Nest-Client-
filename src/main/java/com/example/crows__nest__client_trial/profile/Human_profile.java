package com.example.crows__nest__client_trial.profile;

public class Human_profile {
    public String profile_id;
    public String profile_password;

    public Human_profile(){
        this.profile_id="";
        this.profile_password="";
    }
    public Human_profile(String profile_id , String profile_password){
        this.profile_id=profile_id;
        this.profile_password=profile_password;

    }
    public boolean check_correct_Profile(Human_profile profile){

        // make some dbms call
        // make some dbms call

        return true;
    }
}
