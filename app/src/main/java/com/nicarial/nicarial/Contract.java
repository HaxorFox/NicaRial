package com.nicarial.nicarial;

/**
 * Created by USUARIO on 27/11/2016.
 */

public class Contract {

    int _id;
    String _nombre;
    String _comentario;

    public Contract(){}

    public Contract(int id, String name, String _comentario){
        this._id = id;
        this._nombre = name;
        this._comentario= _comentario;
    }
    public Contract( String name, String _comentario){

        this._nombre = name;
        this._comentario= _comentario;
    }



    // getting ID
    public int getID(){
        return this._id;
    }

    // setting id
    public void setID(int id){
        this._id = id;
    }

    // getting name
    public String getName(){
        return this._nombre;
    }

    // setting name
    public void setName(String name){
        this._nombre = name;
    }

    // getting phone number
    public String getComment(){
        return this._comentario;
    }

    // setting phone number
    public void setComment(String phone_number){
        this._comentario = phone_number;
    }


}
