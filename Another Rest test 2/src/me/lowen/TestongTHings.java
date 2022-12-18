package me.lowen;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

import org.json.JSONArray;
import org.json.JSONObject;

public class TestongTHings {
	public static void main(String args[]) {
		String line;
		try {
			File dir = new File("/");
			 System.out.println(dir.exists());
			File[] directoryListing = dir.listFiles();
			  if (directoryListing != null) {
			    for (File child : directoryListing) {
			    	String thing = Files.readString(Path.of(child.getPath()), StandardCharsets.UTF_8);
			    	System.out.println("/api/cards/" + child.getName().replaceFirst("[.][^.]+$", ""));
			      API.method("/api/cards/" + child.getName().replaceFirst("[.][^.]+$", ""), thing);
			    }
			  } else {
			    // Handle the case where dir is not really a directory.
			    // Checking dir.isDirectory() above would not be sufficient
			    // to avoid race conditions with another process that deletes
			    // directories.
			  }
			/*BufferedReader br = new BufferedReader(new FileReader("input.txt"));
			while ((line = br.readLine()) != null) {
				API.method("/api/" + line, line);
			}
		}  catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} */
		JSONObject mickey = new JSONObject();
		mickey.put("name", "mickey");
		mickey.put("age", "minrt");
		mickey.put("city", "ohio");
		JSONObject dragon = new JSONObject();
		dragon.put("name", "dragon"); 
		dragon.put("age", "minrtdragon");
		dragon.put("city", "ohiodragon");
		JSONArray ja = new JSONArray();
		ja.put(mickey);
		ja.put(dragon);
		System.out.println(ja);
		
		
	} catch (IOException e) {
		e.printStackTrace();
	}
}
}