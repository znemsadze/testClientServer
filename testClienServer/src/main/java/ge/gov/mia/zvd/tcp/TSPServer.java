package ge.gov.mia.zvd.tcp;

import java.io.*;
import java.net.*;

public class TSPServer {

	/**
	 * @param args
	 */
	 public static void main(String argv[]) throws Exception
     {
        String clientSentence;
        String capitalizedSentence;
        ServerSocket welcomeSocket = new ServerSocket(6789);

        while(true)
        {
           Socket clientSocket = welcomeSocket.accept();
           PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
	        BufferedReader in = new BufferedReader(
	                new InputStreamReader(
	                clientSocket.getInputStream()));
	        String inputLine, outputLine;
           while ((inputLine = in.readLine()) != null) {
	             outputLine ="sssssss"+inputLine;
	             out.println(outputLine);
	             if (outputLine.equals("Bye."))
	                break;
	        }
      
        }
     }
}
