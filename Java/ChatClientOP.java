import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ChatClientOP extends Application implements Runnable{
   public String HOST="";
   public int PORT=0;

   private TextField tf1,tf2,tf3,tf4;
   private TextArea ta1,ta2;
   private Button bt1,bt2,bt3;
   private Label lb1,lb2,lb3,lb4;

   private Thread th;

   private Socket sc;
   private BufferedReader br;
   private PrintWriter pw,out;

   int clientcount=0;

   public static void main(String[] args){
      launch(args);
   }

   public void start(Stage stage)throws Exception{
      ta1 = new TextArea();
      ta1.setMaxSize(450, 400);
      ta1.setEditable(false);
      ta2 = new TextArea();
      ta2.setMaxSize(100, 400);
      ta2.setEditable(false);

      bt1 = new Button("Connect");
      bt2 = new Button("Disconnect");
      bt3 = new Button("Clear");

	  tf1 = new TextField();
	  tf2 = new TextField();
	  tf3 = new TextField();
	  tf4 = new TextField();
	  tf1.setPrefWidth(85);
	  tf2.setPrefWidth(75);
	  tf3.setPrefWidth(85);
	  tf4.setPrefWidth(400);

	  lb1 = new Label("IP Address");
	  lb2 = new Label("Port");
	  lb3 = new Label("Name");
	  lb4 = new Label("Text: ");

	  VBox vb1 = new VBox();
	  VBox vb2 = new VBox();
	  VBox vb3 = new VBox();
	  vb1.getChildren().addAll(lb1,tf1);
	  vb1.setAlignment(Pos.CENTER);
      vb2.getChildren().addAll(lb2,tf2);
	  vb2.setAlignment(Pos.CENTER);
      vb3.getChildren().addAll(lb3,tf3);
	  vb3.setAlignment(Pos.CENTER);

      HBox hb1 = new HBox();
      HBox hb2 = new HBox();
      HBox hb3 = new HBox();
      hb1.getChildren().addAll(bt1,bt2,vb1,vb2,vb3);
      hb1.setAlignment(Pos.CENTER);
      hb1.setSpacing(20);
      hb2.setAlignment(Pos.CENTER);
      hb2.getChildren().addAll(bt3,lb4,tf4);
      hb2.setSpacing(10);
      hb3.setAlignment(Pos.CENTER);
      hb3.getChildren().addAll(ta2,ta1);

      VBox vb = new VBox();
      vb.getChildren().addAll(hb1,hb2);
      vb.setSpacing(5);

      BorderPane bp = new BorderPane();

      bp.setCenter(hb3);
      bp.setBottom(vb);

      bt1.setOnAction(new ConnectEventHandler());
      bt2.setOnAction(new ConnectEventHandler());
      bt3.setOnAction(new ConnectEventHandler());
      tf4.setOnAction(new MsgEventHandler());

      Scene sc = new Scene(bp, 550, 450);
      stage.setScene(sc);
      stage.setTitle("ChatClientOP");
      stage.show();

      th = new Thread(this);
   }

   public void run(){
      try{
         sc = new Socket(HOST, PORT);
         br = new BufferedReader
            (new InputStreamReader(sc.getInputStream()));
         pw = new PrintWriter
            (new BufferedWriter(new OutputStreamWriter(sc.getOutputStream())));
         ta1.appendText("Connected\n");

         pw.println(th.getName());
         pw.flush();

         while(true){
            try{
               String str = br.readLine();
               String str1 = br.readLine();

               if(str1.equals("Bye")){
            	   ta1.appendText("Disconnected\n");
            	   ta2.clear();
            	   th.stop();
               }else if(str1.equals("Name")){
            	   ta2.clear();
            	   String[] namelist = str.split(",");
            	   for(int i=0;i<namelist.length;i++){
            		   ta2.appendText(namelist[i]+"\n");
            	   }
               }else if(str1.equals("ConnectedName")){
            	   ta2.clear();
            	   String[] namelist = str.split(",");
            	   for(int i=0;i<namelist.length;i++){
            		   ta2.appendText(namelist[i]+" is connected.\n");
            	   }
               }else{
            	  ta1.appendText(str + "\n");
               }

            }
            catch(Exception e){
               br.close();
               pw.close();
               sc.close();
               break;
            }
         }
      }
      catch(Exception e){
         e.printStackTrace();
      }
   }

   class ConnectEventHandler implements EventHandler<ActionEvent>{
      public void handle(ActionEvent e){
          if (e.getSource() == bt1){

        	  if(!tf3.getText().equals("")){
	                  HOST = tf1.getText();
	                  PORT = Integer.parseInt(tf2.getText());
	                  th.setName(tf3.getText());
	                  th.start();
        	  }else{
        		  ta1.appendText("Please Name\n");
        	  }
          }else if (e.getSource() == bt2){

        	  //for(int i=0;i<list.size();i++){
        		  //System.out.println(Online.size());
        		  //Online.remove(Online.indexOf(th.getName()));
        	  //}
        	  ta2.clear();
              pw.println("Disconnected");
              pw.flush();
          }else if (e.getSource() == bt3){
        	  ta1.clear();
          }
      }
   }

   class MsgEventHandler implements EventHandler<ActionEvent>{
      public void handle(ActionEvent e){
         if (th.isAlive()){
           try {
             String str = tf4.getText();
             pw.println(str);
             pw.flush();
             tf4.setText("");
            }
           catch(Exception ex){
            ex.printStackTrace();
           }
         }
         else ta1.appendText("Not connect to server! Click <接続>\n");
      }
   }
}
