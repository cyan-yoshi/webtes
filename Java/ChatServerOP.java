import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;


public class ChatServerOP {

	   static final int PORT = 12345;
	   static int clientCount = 0;
	   static ClientThread3 clients[] = new ClientThread3[100];
	   static List<String> Online = new ArrayList<>();

	   public static void main(String[] args){
	      try{
	         ServerSocket ss = new ServerSocket(PORT);
	         System.out.println("Waiting for connection ...");
	         while(true){
	               Socket sc = ss.accept();
	               clientCount++;
	               String clientInfo = sc.getRemoteSocketAddress().toString();
	               for (int i=0;i<clients.length;i++){
	            	   if(clients[i] == null){
	            		   clients[i]  = new ClientThread3(sc, clientCount,clientInfo);
	            		   clients[i].start();
	            		   break;
	            	   }
	               }
	         	}
	      	}
	      	catch(Exception e){
	    	  e.printStackTrace();
	      	}
	   	}

	   public static void sendAll(String str1,String str2){
		   for(int i=0;i< clients.length;i++){
			   if(clients[i] !=null){
				   clients[i].send(str1,str2);
			   }
		   }
	   }

	   public static void NamesendAll(){
		   for(int i=0;i< clients.length;i++){
			   if(clients[i] !=null){
				   clients[i].Namesend();
			   }
		   }
	   }

	   public static void remove(String str1,int num){
		   Online.remove(Online.indexOf(str1));
		   NamesendAll();

		   clients[num-1]=null;
		   sendAll(str1+" is disconnected.","Connect");
/*
		   for(int i=0;i< clients.length;i++){
			   if(clients[i] !=null){
//				   clients[i].Namesend();
			   }
		   }*/
	   }

	   public static void ConnectsendAll(String name){
		   for(int i=0;i< clients.length;i++){
			   if(clients[i] !=null){
				   clients[i].send(name+" is connected.","Connect");
			   }
		   }
	   }

	   static class ClientThread3 extends Thread {
		   private Socket sc;
		   private String clientID,info,name;
		   private BufferedReader br;
		   private PrintWriter pw;
		   private int clientnumber=0;

		   public ClientThread3(Socket s, int id,String clientinfo){
			   try{
			         sc = s;
				     clientID = "Client" + id + " Name: ";// + br1.readLine();
				     info = clientinfo;
				     clientnumber=id;
			   }catch(Exception e){
			         e.printStackTrace();
			   }
		   }

		   public void run(){
		      try{
		         br = new BufferedReader
		            (new InputStreamReader(sc.getInputStream()));
		         pw = new PrintWriter
		            (new BufferedWriter(new OutputStreamWriter(sc.getOutputStream())), true);
		      }
		      catch(Exception e){
		         e.printStackTrace();
		      }

	          try {
	        	  name = br.readLine();
	        	  ConnectNamesend();
	        	  Online.add(name);
	        	  NamesendAll();
	          }
	    	  catch(Exception e){}

	          //info.substring(2);
	          String replaceinfo = info.replaceFirst("/", " ");

              System.out.println(clientID + name + " IP: " + replaceinfo);
		      pw.println(clientID + name + " IP: " + replaceinfo);
		      pw.println("First");
	          pw.flush();

        	  sendAll(name+" is connected.","Connect");

	   	      while(true){
		    	  try {
		               String clientMsg = br.readLine();

		               if(clientMsg.equals("Disconnected")){
		                   String DisplayMsg = name + ": " + clientMsg;
			               System.out.println(DisplayMsg);
			               System.out.println("Bye");
			               remove(name, clientnumber);
			               pw.println(DisplayMsg);
			               pw.println("Bye");
			               pw.flush();

		               }else{
			               String DisplayMsg = name + ": " + clientMsg;
			               System.out.println(DisplayMsg);
			               sendAll(DisplayMsg,"Connect");
		            	   /*pw.println(DisplayMsg);
		            	   pw.println("Connect");
		            	   pw.flush();*/
		               }
		          }
		    	  catch(Exception e){
		    		  try{
		                  br.close();
		                  pw.close();
		                  sc.close();
		                  break;
		                 }
		               catch(Exception ex){
		                  ex.printStackTrace();
		               }
		          }
		      }
		   }

	   	   public void send (String str1,String str2){
   	    	   pw.println(str1);
         	   pw.println(str2);
         	   pw.flush();
	   	   }

	   	   public void Namesend (){
		   		String namelist="";
		   		for(int i=0;i<Online.size();i++){
	      		  if(i!=0){
	      			  namelist += ",";
	      		  }
	      		  namelist += Online.get(i);
		   		}
		   		pw.println(namelist);
			    pw.println("Name");
			    pw.flush();
	   	   }

	   	   public void ConnectNamesend (){
		   		String namelist="";
		   		for(int i=0;i<Online.size();i++){
	      		  if(i!=0){
	      			  namelist += ",";
	      		  }
	      		  namelist += Online.get(i);
		   		}
		   		pw.println(namelist);
			    pw.println("ConnectedName");
			    pw.flush();
	   	   }
	}
}
