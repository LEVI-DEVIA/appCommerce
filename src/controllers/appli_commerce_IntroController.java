package controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.concurrent.Task;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class appli_commerce_IntroController implements Initializable{
	
	@FXML
    private Pane pane;
	
	 @FXML
	 private ProgressBar pbar;
	 
	 public void initialize(URL url, ResourceBundle rb) {
		 Task<?> task = taskWorker(10);
		 pbar.progressProperty().unbind();
		 pbar.progressProperty().bind(task.progressProperty());
		 task.setOnSucceeded( e -> {
			 Stage stage = (Stage) pane.getScene().getWindow();
			 stage.close();
			 
			 try {
				Parent root = FXMLLoader.load(getClass().getResource("/interfaces/connexion.fxml"));
				Stage stage2 = new Stage();
				Scene scene = new Scene(root);
				stage2.setScene(scene);
				stage2.show();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			 
		 });
		 Thread thread = new Thread(task);
		 thread.start();
	 }
	 private Task<?> taskWorker(int seconds) {
		 return new Task<Object>() { 
			@Override
			protected Object call() throws Exception {
				for(int i = 0; i < seconds; i++) {
					 updateProgress(i+1, seconds);
					 Thread.sleep(1000);
				}
				return true;
			};
			 
		 };
	 }
}
