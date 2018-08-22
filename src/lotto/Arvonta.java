/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lotto;
import java.util.ArrayList;
import java.util.Random;
/**
 *
 * @author kinggi
 */
public class Arvonta {
    private Random arpoja = new Random();
    private int luku;
    private final int arvottavienMaara = 40;
    private int[] numerot = new int[arvottavienMaara];
    private ArrayList<Integer> arvotut = new ArrayList();
    private int arvottuLisa;
    
    public Arvonta() {
        for(int i = 0; i < arvottavienMaara; i++) {
            numerot[i] = i;
        }
    } 
    
    public void arvo() {
        arvotut.clear();
        int i = 0;
        while(i < 7) {            
            luku = arpoja.nextInt(arvottavienMaara) + 1;
            if(!arvotut.contains(luku)) {
                arvotut.add(luku);
                i++;
            }
        }
        i = 0; 
        while(true) {
            luku = arpoja.nextInt(arvottavienMaara) + 1;
            if(!(arvotut.contains(luku))) {
                arvottuLisa = luku;
                break;
            }
        }
    }
    
    public ArrayList<Integer> get7() {
        return arvotut;
    }
    
    public int get1() {
        return arvottuLisa;
    }
    
    
    
}
