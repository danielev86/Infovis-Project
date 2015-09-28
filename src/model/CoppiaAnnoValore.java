/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author daniele
 */
public class CoppiaAnnoValore {
    
    private int anno;
    private int valore;

    public CoppiaAnnoValore(int anno, int valore) {
        this.anno = anno;
        this.valore = valore;
    }

    public int getAnno() {
        return anno;
    }

    public void setAnno(int anno) {
        this.anno = anno;
    }

    public int getValore() {
        return valore;
    }

    public void setValore(int valore) {
        this.valore = valore;
    }

    @Override
    public String toString() {
        return "CoppiaAnnoValore{" + "anno=" + anno + ", valore=" + valore + '}';
    }
    
    
    
    
}
