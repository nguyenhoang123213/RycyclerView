package com.example.rycyclerview.utils;

import com.example.rycyclerview.R;

public abstract class StudentUtils {
    public static final String DATE_FORMAT ="dd/MM/yyyy" ;

    public static int fidDrawableres(String gender) {
        String target=gender.toLowerCase().trim();
        if(target.compareTo("nam")==0){
            return R.drawable.ic_man;
        }else{
            return R.drawable.ic_woman;
        }
    }
}
