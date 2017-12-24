/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

/**
 *
 * @author Serph
 */

public class Robot {
    
    public Robot(int id, Weapon weapon, int canKillXHipsters) {
        this.id = id;
        this.weapon = weapon;
        this.canKillXHipsters = canKillXHipsters;
    }
    
    private int id;
    private Weapon weapon;
    private int canKillXHipsters;

    public Robot() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    public int getCanKillXHipsters() {
        return canKillXHipsters;
    }

    public void setCanKillXHipsters(int canKillXHipsters) {
        this.canKillXHipsters = canKillXHipsters;
    }

    @Override
    public String toString() {
        return "Robot{" + "id=" + id + ", weapon=" + weapon + ", canKillXHipsters=" + canKillXHipsters + '}';
    }
    
}
