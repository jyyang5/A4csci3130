package com.acme.a3csci3130;

import com.google.firebase.database.Exclude;
import com.google.firebase.database.IgnoreExtraProperties;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * Class that defines how the data will be stored in the
 * Firebase databse. This is converted to a JSON format
 */


public class Contact implements Serializable {


    //public  String name;
    //public  String email;


    public String uid;
    public String businessNum;
    public String name;
    public String primrayBusiness;
    public String address;
    public String provience;



    public Contact() {
        // Default constructor required for calls to DataSnapshot.getValue
    }
    /**
     * Initialization of Contact with parameters
     *
     * @param uid   unique identify of that instance
     * @param businessNum  name of the business
     * @para primrayBusiness  primrayBusiness name
     * @param primrayBusiness primrayBusiness  name
     * @param address  address of the contact
     * @parm provience  province of the business contact
     */
    public Contact(String uid,String businessNum, String name, String primrayBusiness, String address, String provience){

        //this.name = name;
        //this.email = email;

        this.uid = uid;
        this.businessNum = businessNum;
        this.name = name;
        this.primrayBusiness = primrayBusiness;
        this.address = address;
        this.provience = provience;


    }

    @Exclude
    public Map<String, Object> toMap(){
        HashMap<String, Object> result = new HashMap<>();

        result.put("uid", uid);

        //result.put("email", email);

        result.put("businessNum", businessNum);
        result.put("name", name);
        result.put("primrayBusiness", primrayBusiness);
        result.put("address", address);
        result.put("provience", provience);

        return result;
    }
}
