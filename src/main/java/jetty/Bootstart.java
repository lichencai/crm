package jetty;

import org.mortbay.jetty.Server;

public class Bootstart {
	public static void main(String[] args) throws Exception {
		
		Server service = new Server();

		service.start();
	}

}
