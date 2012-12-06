package ge.gov.mia.zvd.tcp;

import java.net.*;
import java.io.*;

public class TSPScoketThread  implements Runnable {
	/**
	 * @param args
	 */
	private Socket socket = null;

	public TSPScoketThread(Socket socket ) {
		this.socket = socket;
	}

	public void run() {
		try {
			PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
			BufferedReader in = new BufferedReader(new InputStreamReader(
					socket.getInputStream()));

			String inputLine, outputLine;
			while ((inputLine = in.readLine()) != null) {
				outputLine = "sssssss" + inputLine;
				out.println(outputLine);
				if (outputLine.equals("Bye."))
					break;
			}
			out.close();
			in.close();
			socket.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
