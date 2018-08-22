/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lotto;

/**
 *
 * @author kinggi
 */
public class Tulokset {
    private int[] tilastot;
    private int peliMaara;
    private int voittoLuokat = 7;
    
    public Tulokset(int maara) {
        tilastot = new int[voittoLuokat];
        for(int i = 0; i < voittoLuokat; i++) {
            tilastot[i] = 0;
        }
        peliMaara = maara;
    }
    
    public void paivitaTilastot(int osu, int lisa) {
        if(osu == 7) {
            tilastot[0]++;
        } else if(osu == 6 && lisa == 1) {
            tilastot[1]++;
        } else if(osu == 6) {
            tilastot[2]++;
        } else if(osu == 5) {
            tilastot[3]++;
        } else if(osu == 4) {
            tilastot[4]++;
        } else if(osu == 3 && (lisa == 1)){            
            tilastot[5]++;
        } else {
            tilastot[6]++;
        }
    }
    
    public int[] getTilastot() {
        return tilastot;
    }
}
