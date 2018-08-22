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
public class Ajatar {
    private Integer nyt = 1;
    private Integer tavoiteAika;
    private Integer pelatut;
    private Arvonta arvonta;
    private ArrayList<Integer> viikonNumerot;
    private Integer lisaNumero;
    private Osumat osumat;
    private ArrayList<Integer> numerot;
    private Tulokset tulokset;
           
    public Ajatar(int tAika, Arvonta aa, ArrayList<Integer> num) {
        tavoiteAika = tAika;
        arvonta = aa;
        viikonNumerot = new ArrayList();
        osumat = new Osumat(num);
        tulokset = new Tulokset(tAika);
    }   
    
    public void ajanKulku() {
        while(nyt <= tavoiteAika) {
            arvonta.arvo();
            viikonNumerot = arvonta.get7();
            lisaNumero = arvonta.get1();
            osumat.setViikonNumerot(viikonNumerot, lisaNumero);
            osumat.setOsumat();
            tulokset.paivitaTilastot(osumat.getOsumat(), osumat.getLisaOsuma());
            nyt++;
        }
    }
    
    public int[] haeTilastot() {
        return tulokset.getTilastot();
    }
    
    public int pelienMaara() {
        return tavoiteAika;
    }
}
