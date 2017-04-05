/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;


public class Basketball {
    
    private int ballerID;
    private String playerName;
    private int age;
    private String college;
    private int ppg;
    private int rpg;
    private int apg;

    public Basketball() {
        this.ballerID = 0;
        this.playerName = "";
        this.age = 0;
        this.college = "";
        this.ppg = 0;
        this.rpg = 0;
        this.apg = 0;
    }
    

    
    public Basketball(int ballerID, String playerName, int age, String college, int ppg, int rpg, int apg) {
        this.ballerID = ballerID;
        this.playerName = playerName;
        this.age = age;
        this.college = college;
        this.ppg = ppg;
        this.rpg = rpg;
        this.apg = apg;
        
    }

 
    public int getBallerID() {
        return ballerID;
    }

    public void setBallerID(int ballerID) {
        this.ballerID = ballerID;
    }

    public String getPlayerName() {
        return playerName;
    }

    
    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getCollege() {
        return college;
    }

    public void setCollege(String college) {
        this.college = college;
    }

    public int getPpg() {
        return ppg;
    }

    public void setPpg(int ppg) {
        this.ppg = ppg;
    }

    public int getRpg() {
        return rpg;
    }

    public void setRpg(int rpg) {
        this.rpg = rpg;
    }

    public int getApg() {
        return apg;
    }

    public void setApg(int apg) {
        this.apg = apg;
    }
    
    
       @Override
    public String toString() {
        return "Basketball{" + "ballerID=" + ballerID + ", name=" + playerName + ", age=" + age + ", college=" + college + ", ppg=" + ppg + ", rpg=" + rpg + ", apg=" + apg + '}';
    }
    
}

   
    
    
    
    
    
    

