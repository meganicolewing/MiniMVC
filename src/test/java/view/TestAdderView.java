package view;

import java.io.IOException;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.testfx.assertions.api.Assertions;
import org.testfx.api.FxRobot;
import org.testfx.framework.junit5.ApplicationExtension;
import org.testfx.framework.junit5.Start;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import main.AdderApp;
import model.AdderModel;
import views.AdderController;


@ExtendWith(ApplicationExtension.class)
public class TestAdderView {

	@Start //before
	private void start(Stage stage) {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(AdderApp.class.getResource("/views/view.fxml"));
		try {
			BorderPane view = loader.load();
			AdderController cont = loader.getController();
			cont.setModel(new AdderModel());
			Scene s = new Scene(view);
			stage.setScene(s);
			stage.show();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Test
	public void testButton(FxRobot robot) {
		checkAdd(robot,"0","10.5","30.25","40.75");
		checkAdd(robot,"40.75","7","29","36");
		checkAdd(robot,"36",".4",".2","0.6");
		checkAdd(robot,"0.6","30","hello","0");
		checkAdd(robot,"0",".4",".2","0.6");
		checkAdd(robot,"0.6","hello","57","0");
	}
	
	private void enterNum1(FxRobot robot,String amt) {
		robot.clickOn("#num1Field");
		robot.write(amt);
	}
	
	private void enterNum2(FxRobot robot,String amt) {
		robot.clickOn("#num2Field");
		robot.write(amt);
	}
	
	private void checkSum(FxRobot robot, String sum) {
		Assertions.assertThat(robot.lookup("#sumLabel").queryAs(Label.class))
			.hasText(sum);
	}
	
	private void checkAdd(FxRobot robot, String currSum, String num1, String num2, String sum) {
		checkSum(robot, currSum);
		enterNum1(robot, num1);
		enterNum2(robot, num2);
		robot.clickOn("#addButton");
		checkSum(robot, sum);
	}
	
}
