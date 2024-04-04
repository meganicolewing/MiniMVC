package model;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;

public class AdderModel {
	private DoubleProperty num = new SimpleDoubleProperty();
	public AdderModel(){
		
	}
	public DoubleProperty getNum() {
		return num;
	}
	public void add(double num1, double num2) {
		num.set(num1+num2);
	}
}



