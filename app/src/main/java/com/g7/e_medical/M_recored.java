package com.g7.e_medical;


import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity( tableName = "m_recored")
public class M_recored {

    @PrimaryKey(autoGenerate = true)
    private int id ;
    @ColumnInfo(name = "blood")
    private String blood;
    @ColumnInfo(name = "name")
    private String name;
    @ColumnInfo(name = "asthma")
    private String asthma;
    @ColumnInfo(name = "blood_pressure")
    private String blood_pressure;
    @ColumnInfo(name = "heart_disease")
    private String heart_disease;
    @ColumnInfo(name = "diabetes")
    private String diabetes;
    @ColumnInfo(name = "other")
    private String other;
    @ColumnInfo(name = "none")
    private String none;

    public M_recored(String blood, String name, String asthma, String blood_pressure, String heart_disease, String diabetes, String other, String none) {
        this.blood = blood;
        this.name = name;
        this.asthma = asthma;
        this.blood_pressure = blood_pressure;
        this.heart_disease = heart_disease;
        this.diabetes = diabetes;
        this.other = other;
        this.none = none;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getBlood() {
        return blood;
    }

    public String getName() {
        return name;
    }

    public String getAsthma() {
        return asthma;
    }

    public String getBlood_pressure() {
        return blood_pressure;
    }

    public String getHeart_disease() {
        return heart_disease;
    }

    public String getDiabetes() {
        return diabetes;
    }

    public String getOther() {
        return other;
    }

    public String getNone() {
        return none;
    }
}
