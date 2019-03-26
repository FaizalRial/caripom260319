package com.izol.caripom.model;

import com.google.firebase.database.IgnoreExtraProperties;

import java.io.Serializable;

/**
 * Created by IZOL on 3/16/2019.
 */
@IgnoreExtraProperties
public class Requests implements Serializable{

    private String nama;
    private String jenis;
    private String jam;
    private String pertamax;
    private String pertalite;
    private String premium;
    private String solar;
    private String dexlite;
    private String pertamaxturbo;

    private String key;

    public Requests(){

    }

    public Requests (String nama, String jenis, String jam, String pertamax, String pertalite, String premium, String solar, String dexlite, String pertamaxturbo) {
        this.nama = nama;
        this.jenis = jenis;
        this.jam = jam;
        this.pertamax = pertamax;
        this.pertalite = pertalite;
        this.premium = premium;
        this.solar = solar;
        this.dexlite = dexlite;
        this.pertamaxturbo = pertamaxturbo;
    }

    public String getNama() {return nama; }
    public void setNama (String nama) {this.nama = nama; }
    public String getJenis() {return jenis; }
    public void setJenis (String jenis) {this.jenis = jenis; }
    public String getJam() {return jam; }
    public void setJam (String jam) {this.jam = jam; }
    public String getPertamax() {return pertamax; }
    public void setPertamax (String pertamax) {this.pertamax = pertamax; }
    public String getpertalite() {return pertalite; }
    public void setpertalite (String pertalite) {this.pertalite = pertalite; }
    public String getpremium() {return premium; }
    public void setPremium (String premium) {this.premium = premium; }
    public String getSolar() {return solar; }
    public void setSolar (String solar) {this.solar = solar; }
    public String getDexlite() {return dexlite; }
    public void setDexlite (String dexlite) {this.dexlite = dexlite; }
    public String getPertamaxturbo() {return pertamaxturbo; }
    public void setPertamaxturbo (String pertamaxturbo) {this.pertamaxturbo = pertamaxturbo; }
    public String getKey() {return key; }
    public void setKey (String key) {this.key = key; }

    @Override
    public String toString(){
        return " "+nama+"\n" +
                " "+jenis+
                " "+jam+
                " "+pertamax+
                " "+pertalite+
                " "+premium+
                " "+solar+
                " "+dexlite+
                " "+pertamaxturbo ;
    }
}
