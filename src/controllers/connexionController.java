package controllers;

import javafx.event.ActionEvent;
import java.io.IOException;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;


public class connexionController{

    @FXML
    private Button nextPage;

    @FXML
    void nextpage(ActionEvent event) {
    	try {
			Parent root = FXMLLoader.load(getClass().getResource("/interfaces/creerCompte.fxml"));
			Scene scene = new Scene(root);
			Stage stage = new Stage();
			stage.setScene(scene);
			stage.show();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    };

};
