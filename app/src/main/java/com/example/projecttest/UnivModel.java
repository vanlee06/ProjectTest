package com.example.projecttest;

public class UnivModel {
    private int UnivID;
    private String namaUniv;
    private String Akre;
    private String status;

    public UnivModel(int UnivID, String namaUniv, String Akre, String status) {
        this.UnivID = UnivID;
        this.namaUniv = namaUniv;
        this.Akre = Akre;
        this.status = status;
    }

    public UnivModel(int UnivID, String namaUniv, String Akre) {
        this.UnivID = UnivID;
        this.namaUniv = namaUniv;
        this.Akre = Akre;
    }

    public UnivModel(String namaUniv, String Akre, String status) {
        this.namaUniv = namaUniv;
        this.Akre = Akre;
        this.status = status;
    }

    public int getUnivID() {
        return UnivID;
    }

    public void setUnivID(int UnivID) {
        this.UnivID = UnivID;
    }

    public String getNamaUniv() {
        return namaUniv;
    }

    public void setNamaUniv(String namaUniv) {
        this.namaUniv = namaUniv;
    }

    public String getAkre() {
        return Akre;
    }

    public void setAkre(String Akre) {
        this.Akre = Akre;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}

