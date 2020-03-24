package gameHandler;

import java.io.*; 

public class FileManager {


	public String Path() {
		File file = new File(".");
		return file.getAbsolutePath();
	}
	public void Write(String filename,String content) {
		try {
			FileOutputStream fos = new FileOutputStream(filename);			
			try {
				byte[] b = content.getBytes();
				fos.write(b);
			}
			finally {
				fos.close();
			}
		}
		catch(Exception e) {
			
		}
	}
	public String Read(String FileName) {
		StringBuilder content = new StringBuilder("");
		try {
			FileInputStream fis = new FileInputStream(FileName);
			InputStreamReader isr = new InputStreamReader(fis);
			
			BufferedReader br = new BufferedReader(isr);
			try {
				String line;
				while( (line = br.readLine()) != null) {
					content.append(line);
					content.append("\n");
				}
			}
			finally {
				br.close();
			}
		}
		catch(Exception e) {
			
		}
		return content.toString();
	}
	
	public String Mkdir() {
		IdManager im = new IdManager();
		String DirName = im.UniqueId();
		
		File theDir = new File(DirName,"");
		
		if (!theDir.exists()) {

		    try{
		        theDir.mkdir();
		        Write(String.format("%s/player1.json", DirName),"");
		        Write(String.format("%s/player2.json", DirName),"");
		        Write(String.format("%s/Deck.json", DirName),"");
		        Write(String.format("%s/graveyard.json", DirName),"");
		        
		        return DirName;
		    } 
		    catch(SecurityException se){
		    	return null;
		    }        
		    
		}
		else return null;
	}
	public String Folders() {
		StringBuilder ls = new StringBuilder("");

		File file = new File(".");
		for (var a: file.listFiles()) {
			if(a.getName().matches("((\\d){4}[a-z])(\\d){3}.*")) {
				ls.append("<section>");
				ls.append(String.format("<h3>%s</h3><ul>",  a.getName()));
				for (var b: a.listFiles()) {
					ls.append(String.format("<li>%s</li>",  b.getName()));
				}				
				ls.append("</ul></section>");
			}
		}
		return ls.toString();
	}
	public String Games() {
		StringBuilder ls = new StringBuilder("");

		File file = new File(".");
		for (var a: file.listFiles()) {
			if(a.getName().matches("((\\d){4}[a-z])(\\d){3}.*")) {
				ls.append("<section>");
				ls.append(String.format("<h3>%s</h3>",  a.getName()));
				boolean gameover = false;
				for (var b: a.listFiles()) {
					if(b.getName().contains("finally")) gameover = true;						
				}				
				if (gameover) {
					ls.append(String.format("<p style=\"color:red\">Juego Finalizado: %s</>",  gameover));
				}
				else {
					ls.append(String.format("<p style=\"color:blue\">Juego Pausado: %s</>",  gameover));
				}
				ls.append("</section>");
			}
		}
		return ls.toString();
	}
}
