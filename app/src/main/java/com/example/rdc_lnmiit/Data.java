package com.example.rdc_lnmiit;

public class Data {

    String /*id, */ scheme, year, motive, bene, mile, rg_value;

    public Data(){

    }

    public Data(/*String id, */ String scheme, String year, String motive, String bene, String mile, String rg_value) {
        //this.id = id;
        this.scheme = scheme;
        this.year = year;
        this.motive = motive;
        this.bene = bene;
        this.mile = mile;
        this.rg_value = rg_value;
    }

    /*public String getId() {
        return id;
    }*/

    public String getScheme() {
        return scheme;
    }

    public String getYear() {
        return year;
    }

    public String getMotive() {
        return motive;
    }

    public String getBene() {
        return bene;
    }

    public String getMile() {
        return mile;
    }

    public String getRg_value() {
        return rg_value;
    }
}
