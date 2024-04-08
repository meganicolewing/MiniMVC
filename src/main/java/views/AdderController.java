package views;
import javafx.beans.binding.Bindings;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.util.StringConverter;
import javafx.util.converter.NumberStringConverter;
import model.AdderModel;

public class AdderController {
		private AdderModel model;
		
		public void setModel(AdderModel newModel) {
			model = newModel;
			//bind sum label
			StringConverter<Number> fmt = new NumberStringConverter();
			Bindings.bindBidirectional(sum.textProperty(), model.getNum(),fmt);
		}
	    @FXML
	    private Button addButton;

	    @FXML
	    private TextField num1;

	    @FXML
	    private TextField num2;

	    @FXML
	    private Label sum;

	    @FXML
	    void onAddClick(ActionEvent event) {
	    	double number1 = getNum1();
	    	double number2 = getNum2();
    		num1.textProperty().set("");
    		num2.textProperty().set("");
	    	if(number1 == -1 || number2 == -1) {
	    		model.add(0, 0);
	    	}
	    	else {
	    		model.add(number1, number2);
	    	}
	    }
	    private double getNum1(){
	    	String val = num1.textProperty().get();
	    	double amt = 0;
	    	try {
	    		amt = Double.parseDouble(val);
	    	}
	    	catch(NumberFormatException e) {
	    		return -1;
	    	}

	    	return amt;
	    }
	    private double getNum2(){
	    	String val = num2.textProperty().get();
	    	double amt = 0;
	    	try {
	    		amt = Double.parseDouble(val);
	    	}
	    	catch(NumberFormatException e) {
	    		return -1;
	    	}

	    	return amt;
	    }

}
