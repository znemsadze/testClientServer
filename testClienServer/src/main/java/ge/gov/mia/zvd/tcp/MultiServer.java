package ge.gov.mia.zvd.tcp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

public class MultiServer {

	private static ExecutorService pool = Executors.newFixedThreadPool(5,
			new ThreadFactory() {

				public Thread newThread(Runnable runnable) {
					Thread thread = new Thread(runnable);
					thread.setName(String.format("MultiServer%s",
							thread.getId()));
					return thread;
				}
			});

 

	/**
	 * @param args
	 */
	public static void main(String[] args) throws IOException {
		ServerSocket serverSocket = null;
		boolean listening = true;

		try {
			serverSocket = new ServerSocket(6789);
		} catch (IOException ex) {
			System.err.println("Could not listen on port: 4444.");
			System.exit(-1);
		}
		while (listening) {
			pool.submit(new TSPScoketThread(serverSocket.accept()));
		}
	}

}
