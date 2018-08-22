/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lotto;
import Todennakoisyydet.Odotusarvo;

import javafx.scene.control.TextField;
import javafx.scene.control.Label;
import java.util.ArrayList;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Screen;
import javafx.stage.Stage;


/**
 *
 * @author kinggi
 */
public class Kayttis  extends Application{


    private Button alkuNappi;
    private Pane alkuPaneeli;
    private Pane lottoPaneeli;
    private final Screen naytto = Screen.getPrimary();
    private final Rectangle2D naytonKoko = naytto.getVisualBounds();
    private ComboBox menu1 = new ComboBox();
    private ComboBox menu2 = new ComboBox();
    private ComboBox menu3 = new ComboBox();
    private ComboBox menu4 = new ComboBox();
    private ComboBox menu5 = new ComboBox();
    private ComboBox menu6 = new ComboBox();
    private ComboBox menu7 = new ComboBox();
    private ArrayList<ComboBox> menut = new ArrayList();
    private ArrayList<Integer> lottoNumerot = new ArrayList();
    private Integer luku;
    private GridPane gridTulokset = new GridPane();
    private boolean ekaPainallus = true;
    
    public Kayttis() {
    }
    
    @Override
    public void start(Stage stage) {
        lottoPaneeli = new Pane();
        luoAlkuNappi(stage);
        asetaStageKuntoon(stage);
        asetaLottonumerotKuntoon();
        aloitaLottoNappi(pelimaaraNappi());
    }
    
    public void luoAlkuNappi(Stage stage) {
        alkuNappi = new Button();
        alkuNappi.setPrefSize(280,150);
        alkuNappi.setText("Ja ei muuta kuin lottoamaan!");
        alkuNappi.setStyle("-fx-font-size: 1.3em; ");
        alkuPaneeli = new Pane();
        alkuPaneeli.getChildren().add(alkuNappi);
        alkuNappi.setLayoutX(naytonKoko.getWidth()/2-140);
        alkuNappi.setLayoutY(naytonKoko.getHeight()/2-150);
        alkuNappi.setOnAction(e -> stage.setScene(new Scene(lottoPaneeli,naytonKoko.getWidth(),naytonKoko.getHeight())));  
    }
    
    public void asetaStageKuntoon(Stage stage) {
        stage.setX(naytonKoko.getMinX());
        stage.setY(naytonKoko.getMinY());
        stage.setWidth(naytonKoko.getWidth());
        stage.setHeight(naytonKoko.getHeight());
        stage.setTitle("Lotto");
        stage.setScene(new Scene(alkuPaneeli,naytonKoko.getWidth(),naytonKoko.getHeight()));
        stage.show();
    }
    
    public void asetaLottonumerotKuntoon() {;
        menut.add(menu1);
        menut.add(menu2);
        menut.add(menu3);
        menut.add(menu4);
        menut.add(menu5);
        menut.add(menu6);
        menut.add(menu7);
        menut.forEach((c) -> {
            c.setMinWidth(75);
        });
        for(ComboBox box : menut) {
            for(int i = 0; i < 40; i++) {
                box.getItems().add(i+1);
                box.setOnAction(e -> {
                    lottoNumerot.add((Integer) box.getValue());
                });
            }
        }
        GridPane grid = new GridPane();
        FlowPane paneeli = new FlowPane();
        Label valitseNumerot = new Label("Valitse lottonumerot: ");
        valitseNumerot.setStyle("-fx-font-size: 1.3em; ");
        paneeli.getChildren().add(valitseNumerot);
        int index = 0;
        for(ComboBox box : menut) {
            grid.add(box, index, 0);
            index++;
        }
        lottoPaneeli.getChildren().add(grid);
        lottoPaneeli.getChildren().add(paneeli);
        paneeli.setLayoutX(215);
        paneeli.setLayoutY(180);
        grid.setLayoutX(45);
        grid.setLayoutY(220);
        grid.setHgap(5);
    }
    
    public void aloitaLottoNappi(TextField kentta) {
        Button nappi = new Button("Aloita lottoaminen");
        Label teksti = new Label("Numerot eivät kelpaa! Syötä joka kohtaan eri numero.");
        Label teksti2 = new Label("Syötä kenttään 'Montako kierrosta pelataan?' positiivinen kokonaisluku.");
        teksti.setVisible(false);
        teksti2.setVisible(false);
        nappi.setStyle("-fx-font-size: 1.3em; ");
        lottoPaneeli.getChildren().add(gridTulokset);
        gridTulokset.setLayoutX(785);
        gridTulokset.setLayoutY(165);
        ArrayList<Node> poistettavat = new ArrayList();
//          testejä
//        for(int i = 0; i < 7; i++) {
//            lottoNumerot.add(i+1);
//        }
//        gridTulokset.getChildren().clear();
//        Ajatar ajatar = new Ajatar(1000000, new Arvonta(), lottoNumerot);
//        ajatar.ajanKulku();
//        int[] tilastot = ajatar.haeTilastot();
//        Label otsikko = new Label("Osumat ");
//        lottoPaneeli.getChildren().add(otsikko);
//        otsikko.setLayoutX(860);
//        otsikko.setLayoutY(92);
//        otsikko.setStyle("-fx-font-size: 1.7em; ");
//        gridTulokset.add(new Label("7 oikein " ), 0, 0);
//        gridTulokset.add(new Label("6 ja lisänumero oikein   " ), 0, 1);
//        gridTulokset.add(new Label("6 oikein " ), 0, 2);
//        gridTulokset.add(new Label("5 oikein " ), 0, 3);
//        gridTulokset.add(new Label("4 oikein " ), 0, 4);
//        gridTulokset.add(new Label("3 ja lisänumero oikein    " ), 0, 5);
//        gridTulokset.add(new Label("Ei voittoa " ), 0, 6);
//        for(int i = 0; i < 7; i++) {
//            gridTulokset.add(new Label(""+tilastot[i]), 1, i);
//        }
//        for(int i = 0; i < 14; i++) {
//            gridTulokset.getChildren().get(i).setStyle("-fx-font-size: 1.3em; ");
//        }
//        Odotusarvo odotusarvo = new Odotusarvo(tilastot, ajatar.pelienMaara());
//        Label odariOtsikko = odotusarvo.luoOtsikko();
//        Pane odariPaneI = odotusarvo.luoTauluNakymaIso();
//        Pane odariPaneP = odotusarvo.luoTauluNakymaPieni();
//        GridPane grid = odotusarvo.luoLukuNakyma();
//        lottoPaneeli.getChildren().add(odariPaneI);
//        odariPaneI.setLayoutX(1235);
//        odariPaneI.setLayoutY(515);
//        lottoPaneeli.getChildren().add(odariPaneP);
//        odariPaneP.setLayoutX(715);
//        odariPaneP.setLayoutY(515);
//        odariOtsikko.setLayoutX(1280);
//        odariOtsikko.setLayoutY(92);
//        lottoPaneeli.getChildren().add(odariOtsikko);
//        lottoPaneeli.getChildren().add(grid);
//        grid.setLayoutX(1280);
//        grid.setLayoutY(165);
//        
        nappi.setOnAction((event)  -> {
            boolean numerotSopivat;
            lottoNumerot.clear();
            menut.forEach((box) -> {
                lottoNumerot.add((Integer) box.getValue());
            });
            numerotSopivat = true;
            for(int i = 0; i < 7; i++) {
                for(int j = 0; j <7; j++) {
                    if(i != j && lottoNumerot.get(i) == lottoNumerot.get(j)) {
                        numerotSopivat = false;
                    }
                }
            }
            if(onkoNumero(kentta.getText())) {
                teksti2.setVisible(false);
                if(numerotSopivat == false) {
                    teksti.setVisible(true);
                } else {
                    teksti.setVisible(false);
                } 
            } else {
                teksti.setVisible(false);
                teksti2.setVisible(true);
            }
            if(onkoNumero(kentta.getText()) && numerotSopivat == true) {
                if(!poistettavat.isEmpty()) {
                    for(Node n : poistettavat) {
                        lottoPaneeli.getChildren().remove(n);
                    }
                }
                gridTulokset.getChildren().clear();
                Ajatar ajatar = new Ajatar(Integer.parseInt(kentta.getText()), new Arvonta(), lottoNumerot);
                ajatar.ajanKulku();
                int[] tilastot = ajatar.haeTilastot();
                gridTulokset.add(new Label("7 oikein " ), 0, 0);
                gridTulokset.add(new Label("6 ja lisänumero oikein   " ), 0, 1);
                gridTulokset.add(new Label("6 oikein " ), 0, 2);
                gridTulokset.add(new Label("5 oikein " ), 0, 3);
                gridTulokset.add(new Label("4 oikein " ), 0, 4);
                gridTulokset.add(new Label("3 ja lisänumero oikein    " ), 0, 5);
                gridTulokset.add(new Label("Ei voittoa " ), 0, 6);
                for(int i = 0; i < 7; i++) {
                    gridTulokset.add(new Label(""+tilastot[i]), 1, i);
                }
                for(int i = 0; i < 14; i++) {
                    gridTulokset.getChildren().get(i).setStyle("-fx-font-size: 1.3em; ");
                }
                Odotusarvo odotusarvo = new Odotusarvo(tilastot, ajatar.pelienMaara());
                Pane odariPaneI = odotusarvo.luoTauluNakymaIso();
                Pane odariPaneP = odotusarvo.luoTauluNakymaPieni();
                GridPane grid = odotusarvo.luoLukuNakyma();
                lottoPaneeli.getChildren().add(odariPaneI);
                odariPaneI.setLayoutX(1235);
                odariPaneI.setLayoutY(515);
                lottoPaneeli.getChildren().add(odariPaneP);
                odariPaneP.setLayoutX(715);
                odariPaneP.setLayoutY(515);
                lottoPaneeli.getChildren().add(grid);
                grid.setLayoutX(1280);
                grid.setLayoutY(165);
                poistettavat.add(grid);
                poistettavat.add(odariPaneI);
                poistettavat.add(odariPaneP);
                if(ekaPainallus == true) {
                    ekaPainallus = false;
                    Label otsikko = new Label("Osumat ");
                    lottoPaneeli.getChildren().add(otsikko);
                    otsikko.setLayoutX(860);
                    otsikko.setLayoutY(92);
                    otsikko.setStyle("-fx-font-size: 1.7em; ");
                    Label odariOtsikko = odotusarvo.luoOtsikko();
                    odariOtsikko.setLayoutX(1280);
                    odariOtsikko.setLayoutY(92);
                    lottoPaneeli.getChildren().add(odariOtsikko);
                }
            }
        });  
        lottoPaneeli.getChildren().add(nappi);
        lottoPaneeli.getChildren().add(teksti);
        lottoPaneeli.getChildren().add(teksti2);       
        nappi.setLayoutX(222);
        nappi.setLayoutY(300);
        teksti.setLayoutX(140);
        teksti.setLayoutY(350);
        teksti2.setLayoutX(115);
        teksti2.setLayoutY(350);
    }
    
    public TextField pelimaaraNappi() {
        VBox box = new VBox();
        TextField kentta = new TextField();
        Label teksti = new Label("       Montako kierrosta pelataan?   ");
        teksti.setStyle("-fx-font-size: 1.3em; ");
        kentta.setMaxWidth(100);
        kentta.setLayoutX(220);
        box.getChildren().add(teksti);
        box.getChildren().add(kentta);
        lottoPaneeli.getChildren().add(box);
        box.setLayoutX(160);
        box.setLayoutY(40);
        box.setSpacing(20);
        box.setAlignment(Pos.CENTER);
        return kentta;
    }
    
    public boolean onkoNumero(String s) {
        if(s.length() == 0) {
            return false;
        }
        for(int i = 0; i < s.length(); i++) {
            if (!Character.toString(s.charAt(i)).matches("[0123456789]")) {
                return false;
            }
        }
        return true;
    }
    
}
