package application;
	
import java.io.FileInputStream;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			Image image = new Image(new FileInputStream("крестик.png")); 
			 ImageView imageView = new ImageView(image);
			 
			 Image image2 = new Image(new FileInputStream("нолик.png")); 
			 ImageView imageView2 = new ImageView(image2); 
			 
			 
			
			Text lbl00 = new Text("");
			lbl00.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 50)); 
			Text lbl10 = new Text("");
			lbl10.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 50)); 
			Text lbl20 = new Text("");
			lbl20.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 50)); 
			
			Text lbl01 = new Text("");
			lbl01.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 50)); 
			Text lbl11 = new Text("");
			lbl11.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 50)); 
			Text lbl21 = new Text("");
			lbl21.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 50)); 
			
			Text lbl02 = new Text("");
			lbl02.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 50)); 
			Text lbl12 = new Text("");
			lbl12.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 50)); 
			Text lbl22 = new Text("");
			lbl22.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 50)); 
			
			Text player = new Text("player");
			Button start = new Button("start");
			
			
			
			GridPane root = new GridPane();
			FlowPane main = new FlowPane(10, 10, root, player, start);
			
			String mass[][] = new String[3][3];
			
			 EventHandler<MouseEvent> gridHandler = new EventHandler<MouseEvent>() { 
		         	@Override 
		  		   public void handle(MouseEvent me) { 
		         		
		         	
		         	double x=me.getX();
		         	double y=me.getY();
		         	String c = player.getText();
		         	if ((0<=x) && (x<100))
		        	{
		         		if ((0<=y) && (y<100))
			        	{
		         			
			        		lbl00.setText(c);
			        		mass[0][0] = c;
			        	}
			        	
			        	if ((100<=y) && (y<200))
			        	{
			        		lbl01.setText(c);
			        		mass[0][1] = c;
			        	}
			        	
			        	if ((200<=y) && (y<300))
			        	{
			        		lbl02.setText(c);
			        		mass[0][2] = c;
			        	}
		        		
		        	}
		        	
		        	if ((100<=x) && (x<200))
		        	{
		        		if ((0<=y) && (y<100))
			        	{
		        			lbl10.setText(c);
		        			mass[1][0] = c;
			        	}
			        	
			        	if ((100<=y) && (y<200))
			        	{
			        		lbl11.setText(c);
			        		mass[1][1] = c;
			        	}
			        	
			        	if ((200<=y) && (y<300))
			        	{
			        		lbl12.setText(c);
			        		mass[1][2] = c;
			        	}
		        			
		        	}
		        	
		        	if ((200<=x) && (x<300))
		        	{
		        		if ((0<=y) && (y<100))
			        	{
		        			lbl20.setText(c);
		        			mass[2][0] = c;
			        	}
			        	
			        	if ((100<=y) && (y<200))
			        	{
			        		lbl21.setText(c);
			        		mass[2][1] = c;
			        	}
			        	
			        	if ((200<=y) && (y<300))
			        	{
			        		lbl22.setText(c);
			        		mass[2][2] = c;
			        	}
		        			
		        	}
		        	if(c=="X")
		        	{
		        		player.setText("O");
		        	}
		        	if(c=="O")
		        	{
		        		player.setText("X");
		        	}
		        	
		        	
		        	System.out.println();
		        	for (int i=0; i<3; i++)
		        	{
		        		for (int j=0; j<3; j++)
		        		{
		        			System.out.print(mass[i][j]);
		        		}
		        	}
		        	
		        	 String g =process.findWinner(mass);
		        	 if (g=="winner X" || g=="winner O" )
		        	 {
		        		 System.out.println(g);
		        		 Label secondLabel = new Label(g);
		        		 
		                 StackPane root2 = new StackPane(secondLabel);
		        		 Scene secondScene = new Scene(root2,150,50);
		        		 Stage newWindow = new Stage();
		        		 newWindow.setTitle("Second Stage");
		        		 newWindow.setScene(secondScene);

		        		 newWindow.show();
		        	 }
		         	
		         	
		         	}};
		         root.setOnMouseClicked(gridHandler);
		         
		         
		         
		         EventHandler<ActionEvent> playerHandler = new EventHandler<ActionEvent>() { 
			         	@Override 
			  		   public void handle(ActionEvent e) { 
			         		
		          
			  		   } 
			         	
			         };
			         
			         EventHandler<ActionEvent> startHandler = new EventHandler<ActionEvent>() { 
				         	@Override 
				  		   public void handle(ActionEvent e) { 
				         		player.setText("X");
				         		lbl00.setText("");
				         		lbl10.setText("");
				         		lbl20.setText("");
				         		
				         		lbl01.setText("");
				         		lbl11.setText("");
				         		lbl21.setText("");
				         		
				         		lbl02.setText("");
				         		lbl12.setText("");
				         		lbl22.setText("");
				         		
				         		for (int i=0; i<3; i++)
					        	{
					        		for (int j=0; j<3; j++)
					        		{
					        			mass[i][j]= null;
					        		}
					        	}
			          
				  		   } 
				         	
				         };
				         start.setOnAction(startHandler);
		         
			
			
			root.getColumnConstraints().add(new ColumnConstraints(100)); // столбец с шириной от 0 до 200
			root.getColumnConstraints().add(new ColumnConstraints(100)); // столбец с шириной от 0 до 200
			root.getColumnConstraints().add(new ColumnConstraints(100)); // столбец с шириной от 0 до 200
			
			 root.getRowConstraints().add(new RowConstraints(100));
			 root.getRowConstraints().add(new RowConstraints(100));
			 root.getRowConstraints().add(new RowConstraints(100));
		
			root.setGridLinesVisible(true);
			
			root.add(lbl00, 0, 0);
			root.add(lbl10, 1, 0);
			root.add(lbl20, 2, 0);
			
			root.add(lbl01, 0, 1);
			root.add(lbl11, 1, 1);
			root.add(lbl21, 2, 1);
			
			root.add(lbl02, 0, 2);
			root.add(lbl12, 1, 2);
			root.add(lbl22, 2, 2);
			Scene scene = new Scene(main,400,400);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
