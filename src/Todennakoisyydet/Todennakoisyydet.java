package Todennakoisyydet;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author kinggi
 */
public class Todennakoisyydet {
    
    public Todennakoisyydet() {
        
    }
    
    public long factorial(int n) {
        long tulo = 1;
        if(n < 2) {
            return 1;
        }
        for(int i = 2; i <= n; i++) {
            tulo *= i;
        }
        return tulo;
    }
    
    public long factorialMinus(int n, int k) {
        if(k == n) {
            return 1;
        }
        if(k > n) {
            return -1;
        }
        long tulo = 1;
        for(int i = k+1; i <= n; i++) {
            tulo *= i;
        }
        return tulo;
    }
    
    public long kombinaatiot(int n, int k) {
        if(k >= n-k) {
           return factorialMinus(n,k)/factorial(n-k); 
        } 
        return factorialMinus(n,n-k)/factorial(k);
    }
    
    public long laskeOsuvatKombinaatiot(int n, boolean lisaNumero) {
        long halututRivit = kombinaatiot(7,n)*kombinaatiot(33,7-n);
        if(lisaNumero == true && n == 6) {
            return (halututRivit)/33;
        }
        if(lisaNumero == true && n == 3) {
            return (halututRivit*4)/33;
        }
        return halututRivit;
    }
    
     public double[] laskeTodennakoisyydet() {
        double[] todennakoisyydet = new double[7];
        long[] osumat = new long[7];
        long osuma = 0;
        long kaikki = kombinaatiot(40,7);
        osumat[0] = laskeOsuvatKombinaatiot(7,false);
        osumat[1] = laskeOsuvatKombinaatiot(6,true);
        osumat[2] = laskeOsuvatKombinaatiot(6,false);
        osumat[3] = laskeOsuvatKombinaatiot(5,false);
        osumat[4] = laskeOsuvatKombinaatiot(4,false);
        osumat[5] = laskeOsuvatKombinaatiot(3,true);
        for(int i = 0; i < 6; i++) {
            osuma += osumat[i];
        }
        osumat[6] = kaikki-osuma;
        for(int i = 0; i < 7; i++) {
            todennakoisyydet[i] = (double) osumat[i]/kaikki;
        }
        return todennakoisyydet;
    } 
}
