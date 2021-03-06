package com.firoj.shabnaz.database.model;


import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;



@DatabaseTable(tableName = "Shabnaz")
public class Shabnaz {

    public Shabnaz(){

    }

    @DatabaseField(generatedId = true)
    int ShabnazID;
    @DatabaseField
    String senderNum;
    @DatabaseField
    String message;
   // @DatabaseField
//    int lastId;
//
//    public int getLastId() {
//        return lastId;
//    }
//
//    public void setLastId(int lastId) {
//        this.lastId = lastId;
//    }

    public String getSenderNum() {
        return senderNum;
    }

    public void setSenderNum(String senderNum) {
        this.senderNum = senderNum;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getShabnazID() {
        return ShabnazID;
    }

    public void setShabnazID(int ShabnazID) {
        this.ShabnazID = ShabnazID;
    }

}
