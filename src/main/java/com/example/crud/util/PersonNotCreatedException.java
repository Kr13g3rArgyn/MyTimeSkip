package com.example.crud.util;

public class PersonNotCreatedException extends RuntimeException{
    public PersonNotCreatedException(String msg){
         super(msg);
    }
}
