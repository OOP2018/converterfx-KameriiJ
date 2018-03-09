package converter;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

public class ConverterController {
	private String defaultStyle;
	@FXML
    TextField textfield1;
    @FXML
    TextField textfield2;
    @FXML
    private ComboBox<Length> combobox1;
    @FXML
    private ComboBox<Length> combobox2;
	
    /**
     * Convert a distance from one unit to another.
     */
    public void handleConvert(ActionEvent event) {
    	 	TextField field1 = textfield1;
    		TextField field2 = textfield2;
    		
    		if(textfield1.getText().length() != 0) {
    			field1 = textfield1;
    			field2 = textfield2;
    		}
    		if(textfield2.getText().length() != 0) {
    			field1 = textfield2;
    			field2 = textfield1;
    		}
    		
    		String text = field1.getText().trim();
    		defaultStyle = field1.getStyle();
    		Length unit1 = combobox1.getValue();
    		Length unit2 = combobox2.getValue();
    		try {
    			double number = Double.parseDouble(text);
    			double meter = number*unit1.getValue();
    			double result = meter/unit2.getValue();
    			String text2 = String.format("%.4g", result);
    			field2.setText(text2);
    		}catch (Exception e) {
    			field1.setStyle("-fx-background-color: red");	
    		}
    }
    
    public void handleClear() {
    		TextField field1 = textfield1;
    		TextField field2 = textfield2;
    		
    		if(textfield1.getText().length() != 0) {
    			field1 = textfield1;
    			field2 = textfield2;
    		}
    		if(textfield2.getText().length() != 0) {
    			field1 = textfield2;
    			field2 = textfield1;
    		}
    		textfield1.clear();
    		textfield2.clear();
    		field1.setStyle(defaultStyle);
    }
    
    /**
     * JavaFX calls the initialize() method of your controller when
     * it creates the UI form, after the components have been created
     * and @FXML annotated attributes have been set.
     *
     * This is a hook to initialize anything your controller or UI needs.
     */
    @FXML
    public void initialize() {
        if (combobox1 != null) {
        		combobox1.getItems().addAll( Length.values() );
        		combobox1.getSelectionModel().select(combobox1.getSelectionModel().getSelectedItem());
        }
        if (combobox2 != null) {
        		combobox2.getItems().addAll( Length.values() );
        		combobox2.getSelectionModel().select(combobox2.getSelectionModel().getSelectedItem());
        }
    }
}
