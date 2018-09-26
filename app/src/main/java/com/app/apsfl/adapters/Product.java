package com.app.apsfl.adapters;

/**
 * Created by User on 05-04-2018.
 */


public class Product {
    public String cafNo;
    public String price;
    int image;
    public boolean box;
    String custName;
    String mobNo;


    public Product(String _describe, String custname, String mobno, String _price, int _image, boolean _box) {
        cafNo = _describe;
        custName=custname;
        mobNo=mobno;
        price = _price;
        image = _image;
        box = _box;
    }
}
