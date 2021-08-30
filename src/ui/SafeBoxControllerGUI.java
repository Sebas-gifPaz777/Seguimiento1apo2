package ui;

import java.awt.TextField;
import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextArea;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import model.PasswordCheck;

public class SafeBoxControllerGUI {
	
	    @FXML
	    private TextField dPassword1;
	
	    @FXML
	    private TextField dPassword4;
	
	    @FXML
	    private TextField dPassword3;
	
	    @FXML
	    private TextField dPassword2;
	
	    @FXML
	    private TextField dPassword5;
	
	    @FXML
	    private TextField dPassword6;
	    
	    @FXML
	    private TextArea textSpace;

	    @FXML
	    private TextField oPassword1;

	    @FXML
	    private TextField oPassword4;

	    @FXML
	    private TextField oPassword3;

	    @FXML
	    private TextField oPassword2;

	    @FXML
	    private TextField oPassword5;

	    @FXML
	    private TextField oPassword6;

	    @FXML
	    private TextField nPassword6;

	    @FXML
	    private TextField nPassword5;

	    @FXML
	    private TextField nPassword4;

	    @FXML
	    private TextField nPassword3;

	    @FXML
	    private TextField nPassword2;

	    @FXML
	    private TextField nPassword1;

	    
	    
    private Stage mainStage;
    
    private PasswordCheck allReady;
    
    private PasswordCheck field;
	
	public Stage getMainStage() {
			return mainStage;
	}
	
	public void setMainStage(Stage mainStage) {
			this.mainStage = mainStage;
	}
	
	@FXML
    public void switchWindow(ActionEvent event) throws IOException {
		
		String[] textPas= new String [6];
		TextField[] passSpaces= {dPassword1,dPassword2,dPassword3,dPassword4,dPassword5,dPassword6};
		boolean [] checkPas= new boolean [6];
		int count=0;
		String check="";
		
		for(int i=1;i<6;i++) {
			textPas[i]=passSpaces[i].getText();
			checkPas[i]=PasswordCheck.checkWindow1(textPas[i]);
			check+=textPas[i];
			
			if(checkPas[i]==false)
				count++;
		}
		
		if(count>0) {
			
			Alert alert = new Alert(AlertType.INFORMATION);
    		alert.setTitle("Information Dialog");
    		alert.setHeaderText(null);
    		alert.setContentText("You can only put a number per space");
    		alert.showAndWait();
		}
		else {
			
			allReady.setOriginal("000000");
			
			if(allReady.getOriginal().equals(check)) {
				FXMLLoader fxmlLoader=new FXMLLoader(getClass().getResource("SafeBox2.fxml"));
				fxmlLoader.setController(this);
				Parent root=fxmlLoader.load();
				Scene scene=new Scene(root);
					
				mainStage.setScene(scene);
				mainStage.setTitle("Window 2");
				mainStage.show();
				
				textSpace.setText(field.getOriginal());
			}
			else {
					
				Alert alert = new Alert(AlertType.INFORMATION);
		    	alert.setTitle("Information Dialog");
		    	alert.setHeaderText(null);
		    	alert.setContentText("The combination is incorrect");
		    	alert.showAndWait();
			}
		}
	}
		
	 @FXML
	 public void switchWindow2(ActionEvent event) throws IOException {
		 
		FXMLLoader fxmlLoader=new FXMLLoader(getClass().getResource("SafeBox3.fxml"));
		fxmlLoader.setController(this);
		Parent root=fxmlLoader.load();
		Scene scene=new Scene(root);
			
		mainStage.setScene(scene);
		mainStage.setTitle("Window 3");
		mainStage.show();
	 }
	 
	 @FXML
	 public  void returnMenu(ActionEvent event) throws IOException {
		 
		 field.setOriginal(textSpace.getText());
		 
		 FXMLLoader fxmlLoader=new FXMLLoader(getClass().getResource("SafeBox1.fxml"));
		 fxmlLoader.setController(this);
		 Parent root=fxmlLoader.load();
		 Scene scene=new Scene(root);
				
		 mainStage.setScene(scene);
		 mainStage.setTitle("Window 1");
		 mainStage.show();
		 
	    }
	  
	 @FXML
	 public void returnMenu2(ActionEvent event) throws IOException {
		 FXMLLoader fxmlLoader=new FXMLLoader(getClass().getResource("SafeBox1.fxml"));
		 fxmlLoader.setController(this);
		 Parent root=fxmlLoader.load();
		 Scene scene=new Scene(root);
				
		 mainStage.setScene(scene);
		 mainStage.setTitle("Window 1");
		 mainStage.show();
		
	 }

	 @FXML
	 public void switchPassword(ActionEvent event) throws IOException {
		 
		String[] textPasOld= new String [6];
		String[] textPasNew= new String [6];
		TextField[] passSpacesOld= {oPassword1,oPassword2,oPassword3,oPassword4,oPassword5,oPassword6};
		TextField[] passSpacesNew= {nPassword1,nPassword2,nPassword3,nPassword4,nPassword5,nPassword6};
		boolean [] checkPasOld= new boolean [6];
		boolean [] checkPasNew= new boolean [6];
		int countOld=0;
		int countNew=0;
		String checkOld="";
		String checkNew="";
			
		for(int i=1;i<6;i++) {
			textPasOld[i]=passSpacesOld[i].getText();
			checkPasOld[i]=PasswordCheck.checkWindow1(textPasOld[i]);
			checkOld+=textPasOld[i];
			
			textPasNew[i]=passSpacesNew[i].getText();
			checkPasNew[i]=PasswordCheck.checkWindow1(textPasNew[i]);
			checkNew+=textPasNew[i];
				
			if(checkPasOld[i]==false)
				countOld++;
			
			if(checkPasNew[i]==false)
				countNew++;
		}
			
		if(countOld>0 || countNew>0) {
				
			Alert alert = new Alert(AlertType.INFORMATION);
	    	alert.setTitle("Information Dialog");
	   		alert.setHeaderText(null);
	   		alert.setContentText("You can only put a number per space");
	   		alert.showAndWait();
		}
		
		else {
			
			if(allReady.getOriginal().equals(checkOld)) {
				allReady.setOriginal(checkNew);
				
				Alert alert = new Alert(AlertType.INFORMATION);
		    	alert.setTitle("Information Dialog");
		    	alert.setHeaderText(null);
		    	alert.setContentText("Has been correctly saved");
		    	alert.showAndWait();
			}
			else {
					
				Alert alert = new Alert(AlertType.INFORMATION);
		    	alert.setTitle("Information Dialog");
		    	alert.setHeaderText(null);
		    	alert.setContentText("The initial combination is not correct");
		    	alert.showAndWait();
			}
		}
	 }
}

