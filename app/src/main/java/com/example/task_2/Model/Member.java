package com.example.task_2.Model;

import android.text.BoringLayout;

import androidx.annotation.NonNull;

public class Member {
        int profile;
        String name;
        String surname;
        Boolean avialable;

        public Member(int profile, String name, String surname,Boolean avialable){
            this.profile = profile;
            this.name = name;
            this.surname = surname;
            this.avialable = avialable;
        }

        public int getProfile(){ return profile; }
        public String getName(){
            return name;
        }
        public String getSurname(){
            return surname;
        }
        public Boolean isAvialable(){ return avialable;}

        @NonNull
        public String toString(){
            return profile+" : "+name+" "+surname+" "+avialable;

        }

}
