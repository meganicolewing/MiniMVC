package main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import model.AdderModel;
import views.AdderController;

public class AdderApp extends Application {

	@Override
	public void start(Stage stage) throws Exception {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(AdderApp.class.getResource("/views/view.fxml"));
		BorderPane view = loader.load();
		AdderController cont = loader.getController();
		cont.setModel(new AdderModel());
		Scene s = new Scene(view);
		stage.setScene(s);
		stage.show();
	}
	public static void main(String[] args) {
		launch(args);
	}

}
