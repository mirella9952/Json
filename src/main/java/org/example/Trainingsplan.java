package org.example;

import javafx.beans.property.SimpleStringProperty;

public class Trainingsplan {
    private String uebung;
    private int kg;
    private int wdhl;
    private int pause;
    private int zeit;
    private int intensitaet;
    private String beschreibung;

    public Trainingsplan(String uebung, int kg, int wdhl, int pause, int zeit, int intensitaet, String beschreibung){
        this.uebung = uebung;
        this.kg = kg;
        this.wdhl = wdhl;
        this.pause = pause;
        this.zeit = zeit;
        this.intensitaet = intensitaet;
        this.beschreibung=beschreibung;
    }

    public Trainingsplan(int kg, int wdhl, int pause, int zeit, int intensitaet, String beschreibung){
        //this.uebung = uebung;
        this.kg = kg;
        this.wdhl = wdhl;
        this.pause = pause;
        this.zeit = zeit;
        this.intensitaet = intensitaet;
        this.beschreibung=beschreibung;
    }



    public String getUebung() {
        return uebung;
    }

    public int getKg() {
        return kg;
    }

    public int getWdhl() {
        return wdhl;
    }

    public int getPause() {
        return pause;
    }

    public int getZeit() {
        return zeit;
    }

    public int getIntensitaet() {
        return intensitaet;
    }

    public String getBeschreibung() {
        return beschreibung;
    }


    //----------------------------------------------------


}
