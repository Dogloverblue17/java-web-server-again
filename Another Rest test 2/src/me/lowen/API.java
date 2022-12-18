package me.lowen;
import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;

import org.json.JSONObject;

import com.sun.net.httpserver.HttpServer;

public class API {
	private static HttpServer server = null;
	private static OutputStream output;
	private static boolean doIt = true;
	private static JSONObject jo = null;
	public static void setupServer() {
		try {
			server = HttpServer.create(new InetSocketAddress(8080), 0);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void setupPart2() {
		server.setExecutor(null); // creates a default executor
        server.start();
	}
	public static void method(String path, String thing) {
		if (jo == null) {
			jo = new JSONObject();
			jo.put("hieght", "4'5");
			jo.put("age", "43");
			jo.put("obesity-level", "depends");
		}
		if (server == null) {
		try {
			server = HttpServer.create(new InetSocketAddress(8080), 0);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}}
        server.createContext(path, (exchange -> {

            if ("GET".equals(exchange.getRequestMethod())) {
                String responseText = thing;
                
                exchange.sendResponseHeaders(200, responseText.getBytes().length);
                OutputStream output = exchange.getResponseBody();
                output.write(responseText.getBytes());
                output.flush();
            } else {
                exchange.sendResponseHeaders(405, -1);// 405 Method Not Allowed
            }
            exchange.close();
        }));

        if (doIt) {
        server.setExecutor(null); // creates a default executor
        server.start();
        doIt = false;
        }

	}
    public static void addThing(String path, String Value) {

    	System.out.println("sd");
        server.createContext(path, (exchange -> {

            if ("GET".equals(exchange.getRequestMethod())) {
            	System.out.println("sdfsdf");
                String responseText = "Hello World! from our framework-less REST API\n";
                exchange.sendResponseHeaders(200, responseText.getBytes().length);
                output = exchange.getResponseBody();
                output.write(responseText.getBytes());
                output.flush();
            } else {
            	System.out.println("else");
                exchange.sendResponseHeaders(405, -1);// 405 Method Not Allowed
            }
            exchange.close();
        }));

        
        

    }
}