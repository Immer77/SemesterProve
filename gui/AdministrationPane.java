package gui;


import application.model.Område;
import application.model.Plads;
import javafx.application.Application;

import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import application.controller.Controller;

import javafx.geometry.Insets;

import javafx.scene.control.*;

import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class AdministrationPane extends Application {
    @Override
    public void init(){
        Controller.init();
    }
    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("Netcafe Administration");
        GridPane pane = new GridPane();
        this.initContent(pane);

        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.show();

    }

    private TextField txfNummer;
    private TextArea txaPladser;
    private ListView<Plads> lvwPladser;
    private final ToggleGroup group = new ToggleGroup();


    private void initContent(GridPane pane){
        pane.setPadding(new Insets(20));
        pane.setHgap(20);
        pane.setVgap(10);
        pane.setGridLinesVisible(false);

        Label lblPladser = new Label("Pladser");
        pane.add(lblPladser,1,0);

        lvwPladser = new ListView<>();
        pane.add(lvwPladser,1,1);
        lvwPladser.getItems().setAll(Controller.getPladser());



        VBox vBoxområder = new VBox();
        pane.add(vBoxområder,1,4);

        Label lblOmråde = new Label("Område");
        pane.add(lblOmråde,0,4);

        String[] områdeStrings = {"STANDARD", "VIP", "BØRNE", "TURNERING"};
        for (String områdeString : områdeStrings) {
            RadioButton rb = new RadioButton();
            vBoxområder.getChildren().add(rb);
            rb.setText(områdeString);
            rb.setToggleGroup(group);
        }

        Label lblnummer = new Label("Nummer:");
        pane.add(lblnummer,0,6);


        txfNummer = new TextField();
        pane.add(txfNummer,1,6);


        Button btnOpret = new Button("Opret");
        pane.add(btnOpret,1,7);
        btnOpret.setOnAction(event -> CreateAction());

    }

    private void CreateAction() {
        String nr = txfNummer.getText().trim();
        if(nr != null) {
            RadioButton rb = (RadioButton) group.getSelectedToggle();
            try {
                Controller.createPlads(Integer.parseInt(nr), Område.valueOf(rb.getText()));
            }catch (NumberFormatException e){
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Wrong input, try again");
                alert.setHeaderText("That was not a number you silly goof");
                alert.show();
            }

        }
        updateAction();

    }

    private void updateAction(){
        txfNummer.clear();
        lvwPladser.getItems().setAll(Controller.getPladser());

    }


}
