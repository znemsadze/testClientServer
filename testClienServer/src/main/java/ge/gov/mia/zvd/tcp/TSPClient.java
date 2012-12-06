package ge.gov.mia.zvd.tcp;
import java.io.*;
import java.net.*;

public class TSPClient {

	/**
	 * @param args
	 */
	public static void main(String argv[]) throws Exception
	 {
	  Socket echoSocket = null;
      PrintWriter out = null;
      BufferedReader in = null;
	  while(true){
		    echoSocket = new Socket("localhost", 6789);
		    in = new BufferedReader(new InputStreamReader(
                    echoSocket.getInputStream()));
		    BufferedReader stdIn = new BufferedReader(
                    new InputStreamReader(System.in));
		    out = new PrintWriter(echoSocket.getOutputStream(), true);
			String userInput;
			
			while ((userInput = stdIn.readLine()) != null) {
			out.println(userInput);
			System.out.println("echo: " + in.readLine());
			}
			out.close();
			in.close();
			stdIn.close();
		  echoSocket.close();
	  }
	 }

}
