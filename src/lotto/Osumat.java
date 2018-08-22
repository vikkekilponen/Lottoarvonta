/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lotto;

import java.util.ArrayList;

/**
 *
 * @author kinggi
 */
public class Osumat {
    private ArrayList<Integer> numerot = new ArrayList();
    private ArrayList<Integer> arvotut = new ArrayList();
    private Integer arvottuLisa;
    private Integer osumat;
    private Integer lisaOsuma;
    
    public Osumat(ArrayList<Integer> num) {
        for(int i : num) {
            numerot.add(i);
        }
    }
    
    public void setViikonNumerot(ArrayList<Integer> arvo, Integer lisa) {
        arvotut = arvo;
        arvottuLisa = lisa;
    }
    
    public void setOsumat() {
        osumat = 0;
        lisaOsuma = 0;
        for(int arvottu : arvotut) {
            if(numerot.contains(arvottu)) {
                osumat++;
            }
        }
        if(numerot.contains(arvottuLisa)) {
            lisaOsuma++;
        }
    }
    
    public int getOsumat() {
        return osumat;
    }
    
    public int getLisaOsuma() {
        return lisaOsuma;
    }
}
