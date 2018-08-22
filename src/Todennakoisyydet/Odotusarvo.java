package Todennakoisyydet;


import static java.lang.Math.round;
import javafx.scene.chart.AreaChart;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
 

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author kinggi
 */
public class Odotusarvo {
    
    Todennakoisyydet todari = new Todennakoisyydet();
    double[] odotusarvot = new double[7];;
    int[] tilastot;
    int pelienMaara;
    AreaChart<Number,Number> nakyma;
            
    public Odotusarvo(int[] tila, int maara) {
        tilastot = tila;
        pelienMaara = maara;
    }
    
    public void laskeOdotusarvot() {
        odotusarvot = todari.laskeTodennakoisyydet();
    }
    
    public double[] normalisoiOdotusarvot() {
        double[] odari = new double[7];
        laskeOdotusarvot();
        for(int i = 0; i < 7; i++) {
            odari[i] = odotusarvot[i]*pelienMaara;
        } 
        return odari;
    }
   
    public Pane luoTauluNakymaIso() {
        CategoryAxis xAxis = new CategoryAxis();
        NumberAxis yAxis = new NumberAxis();
        BarChart<String,Number> chart = new BarChart<>(xAxis,yAxis);
        chart.setTitle("Osumat/keskimääräiset tulokset");
        chart.setMinSize(300, 300);
        XYChart.Series odotusarvo = new XYChart.Series();
        double[] odari = normalisoiOdotusarvot(); 
        odotusarvo.setName("Keskimääräiset tulokset");
        XYChart.Series osumat = new XYChart.Series();
        osumat.setName("Osumat");
        osumat.getData().add(new XYChart.Data("6", tilastot[2]));
        odotusarvo.getData().add(new XYChart.Data("6", odari[2]));
        osumat.getData().add(new XYChart.Data("6+1", tilastot[1]));
        odotusarvo.getData().add(new XYChart.Data("6+1", odari[1]));
        osumat.getData().add(new XYChart.Data("7", tilastot[0]));
        odotusarvo.getData().add(new XYChart.Data("7", odari[0]));
        chart.getData().addAll(osumat,odotusarvo);
        Pane pane = new Pane();
        pane.getChildren().add(chart);
        yAxis.setAutoRanging(false);
        yAxis.setLowerBound(0);
        yAxis.setUpperBound(Math.round(Math.max(tilastot[2],odari[2])+1));
        yAxis.setTickUnit(1);
        yAxis.setMinorTickVisible(false);
        return pane;
    }
    
    public Pane luoTauluNakymaPieni() {
        CategoryAxis xAxis = new CategoryAxis();
        NumberAxis yAxis = new NumberAxis();
        BarChart<String,Number> chart = new BarChart<>(xAxis,yAxis);
        chart.setTitle("Osumat/keskimääräiset tulokset");
        chart.setMinSize(300, 300);
        XYChart.Series odotusarvo = new XYChart.Series();
        double[] odari = normalisoiOdotusarvot(); 
        odotusarvo.setName("Keskimääräiset tulokset");
        XYChart.Series osumat = new XYChart.Series();
        osumat.setName("Osumat");
        odotusarvo.getData().add(new XYChart.Data("3+1", odari[5]));
        osumat.getData().add(new XYChart.Data("3+1", tilastot[5]));
        osumat.getData().add(new XYChart.Data("4", tilastot[4]));
        odotusarvo.getData().add(new XYChart.Data("4", odari[4]));
        osumat.getData().add(new XYChart.Data("5", tilastot[3]));
        odotusarvo.getData().add(new XYChart.Data("5", odari[3]));
        chart.getData().addAll(osumat,odotusarvo);
        Pane pane = new Pane();
        pane.getChildren().add(chart);
        return pane;
    }
    
    
    
    public GridPane luoLukuNakyma() {
        double[] odari = normalisoiOdotusarvot(); 
        GridPane grid = new GridPane();
        grid.add(new Label("7 oikein "), 0, 0);
        grid.add(new Label("6 ja lisänumero oikein     "  ), 0, 1);
        grid.add(new Label("6 oikein " ), 0, 2);
        grid.add(new Label("5 oikein " ), 0, 3);
        grid.add(new Label("4 oikein " ), 0, 4);
        grid.add(new Label("3 ja lisänumero oikein    " ), 0, 5);
        grid.add(new Label("Ei voittoa " ), 0, 6);
        for(int i = 0; i < 7; i++) {
            grid.add(new Label(round(odotusarvot[i]*pelienMaara)+""), 1, i);
        }
        grid.setStyle("-fx-font-size: 1.3em; ");
        return grid;
    } 
    
    public Label luoOtsikko() {
        Label otsikko = new Label("Keskimääräiset tulokset");
        otsikko.setStyle("-fx-font-size: 1.7em; ");
        return otsikko;       
    }
}
