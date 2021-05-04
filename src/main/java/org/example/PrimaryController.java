package org.example;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import javax.json.*;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PrimaryController {

    //private TableView<Trainingsplan> tableView;
    //@FXML
    //private ComboBox eingabe_geraet;
    @FXML
    private TextField eingabe_kg;
    @FXML
    private TextField eingabe_wdhl;
    @FXML
    private TextField eingabe_pause;
    @FXML
    private TextField eingabe_zeit;
    @FXML
    private TextField eingabe_intensitaet;
    @FXML
    private TextField einagbe_beschreibung;

    @FXML
    public TableView<Trainingsplan> table;
    //@FXML
    //private TableColumn<Trainingsplan, String> table_geraet;
    @FXML
    private TableColumn<Trainingsplan, Integer> table_kg;
    @FXML
    private TableColumn<Trainingsplan, Integer> table_wdhl;
    @FXML
    private TableColumn<Trainingsplan, Integer> table_pause;
    @FXML
    private TableColumn<Trainingsplan, Integer> table_zeit;
    @FXML
    private TableColumn<Trainingsplan, Integer> table_intensitaet;
    @FXML
    private TableColumn<Trainingsplan, String> table_beschreibung;

    private List<Trainingsplan> verwaltung = new ArrayList<>();

    public void initialize() {
        //table_geraet.setCellValueFactory(new PropertyValueFactory<>("geraet"));
        table_kg.setCellValueFactory(new PropertyValueFactory<>("kg"));
        table_wdhl.setCellValueFactory(new PropertyValueFactory<>("wdhl"));
        table_pause.setCellValueFactory(new PropertyValueFactory<>("pause"));
        table_zeit.setCellValueFactory(new PropertyValueFactory<>("zeit"));
        table_intensitaet.setCellValueFactory(new PropertyValueFactory<>("intensitaet"));
        table_beschreibung.setCellValueFactory(new PropertyValueFactory<>("beschreibung"));

    }

    @FXML
    private void handle_btn_tabelle(ActionEvent event) {
        //Trainingsplan t1 = new Trainingsplan((String)eingabe_geraet.getValue(),Integer.parseInt(eingabe_kg.getText()),Integer.parseInt(eingabe_wdhl.getText()),Integer.parseInt(eingabe_pause.getText()),Integer.parseInt(eingabe_zeit.getText()),Integer.parseInt(eingabe_intensitaet.getText()),einagbe_beschreibung.getText());
        Trainingsplan t1 = new Trainingsplan(Integer.parseInt(eingabe_kg.getText()), Integer.parseInt(eingabe_wdhl.getText()), Integer.parseInt(eingabe_pause.getText()), Integer.parseInt(eingabe_zeit.getText()), Integer.parseInt(eingabe_intensitaet.getText()), einagbe_beschreibung.getText());

        table.getItems().add(t1);
    }

    @FXML
    private void handle_btn_konvertieren(ActionEvent event) {
        JsonObjectBuilder builder = Json.createObjectBuilder();
        for (Trainingsplan t : table.getItems()) {
            //builder.add("Gerät", t.getGeraet());
            builder.add("Gewicht", t.getKg());
            builder.add("Wiederholungen", t.getWdhl());
            builder.add("Pause", t.getPause());
            builder.add("Zeit", t.getZeit());
            builder.add("Intensitaet", t.getIntensitaet());
            builder.add("Beschreibung", t.getBeschreibung());


            JsonObject jo = builder.build();
            try {
                FileWriter fw = new FileWriter("Trainingsplan.json");
                JsonWriter jsonWriter = Json.createWriter(fw);
                jsonWriter.writeObject(jo);
                jsonWriter.close();
                fw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println("Success");
        }
    }
}









