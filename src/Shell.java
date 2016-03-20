


import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.Set;



/**
 * 
 *         This class tests the system.
 */
 public class Shell {
	
  
	public static void main(String[] args) {
		

			
			FileSystem fs=FileSystem.getFileSystem();
		fs.init();
		
			System.out.println("FileSystem initialized !");
			while(true){
				Scanner in =new Scanner(System.in);
			try {
				
	
					
				
				
				System.out.println();
				String command=readEntry(">",in);
				ArrayList<String> com=new ArrayList<String>(Arrays.asList(getTokens(command)));
				
				execute(com);
				/*if(!com.get(0).contentEquals("redo")){
				ch.push(command);
				}*/
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
				
				
				
				
			}
			
			
			
	
	}
	
	
	
	

	
	
	
	
	
	public static void execute(ArrayList<String> c){
		CommandHistory ch=CommandHistory.getCommandHistory();
		
		if(c.get(0).contentEquals("cd") && c.size()==1){
			Command co=new Cd();
			
			co.execute();
			ch.push(co);
		}
		else if(c.get(0).contentEquals("cd") && c.size()>1){
			
			String s=c.get(1);
			for(int i=2;i<c.size();i++){
				s=s+" "+c.get(i);
			}
			Command co=new Cd(s);
			
			co.execute();
			ch.push(co);
		}
		
		else if(c.get(0).contentEquals("dir") && c.size()>1){
			
			String s=c.get(1);
			for(int i=2;i<c.size();i++){
				s=s+" "+c.get(i);
			}
			Command co=new dir(s);
			co.execute();
			ch.push(co);
		}
		else if(c.get(0).contentEquals("dir")){
			Command co=new dir();
			co.execute();
			ch.push(co);
			}
		
		else if(c.get(0).contentEquals("pwd")){
			Command co=new Pwd();
			co.execute();
			ch.push(co);
		}
		else if(c.get(0).contentEquals("ls")){
			Command co=new Ls();
			co.execute();
			ch.push(co);
		}
		else if(c.get(0).contentEquals("mkdir") && c.size()>1){
			
			String s=c.get(1);
			for(int i=2;i<c.size();i++){
				s=s+" "+c.get(i);
			}
			Command co=new mkdir(s);
			co.execute();
			ch.push(co);
			
		}
		
		else if(c.get(0).contentEquals("rmdir") && c.size()>1){
			
			String s=c.get(1);
			for(int i=2;i<c.size();i++){
				s=s+" "+c.get(i);
			}
			Command co=new rmdir(s);
			co.execute();
			ch.push(co);
		}
		
else if(c.get(0).contentEquals("ln") && c.size()>2){
			
			String s=c.get(1);
			String name="";
			 for(int i=2;i<c.size();i++){
					if(i!=c.size()-1){
					s=s+" "+c.get(i);
					}
					else{
						name=c.get(i);
					}
			 }
			Command co=new ln(s,name);
			co.execute();
			ch.push(co);
		}
else if(c.get(0).contentEquals("ln") && c.size()>1){
			
			String s=c.get(1);
			String name=c.get(2);
			
			Command co=new ln(s,name);
			co.execute();
			ch.push(co);
		}
		
		
else if(c.get(0).contentEquals("chown") && c.size()>1){
	
	String s=c.get(1);
	for(int i=2;i<c.size();i++){
		s=s+" "+c.get(i);
	}
	
	
	Command co=new chown(s);
	co.execute();
	ch.push(co);
}
		
		
		/* 
				
					
				
			}*/
		
		else if(c.get(0).contentEquals("exit")){
			System.exit(0);
		}
		else if(c.get(0).contentEquals("redo")){
			Command co=new Redo();
			co.execute();
		}
		else if(c.get(0).contentEquals("history")){
			Command co=new history();
			co.execute();
			ch.push(co);
		}
		else if(c.get(0).contentEquals("sort") && c.size()>1){
			String s=c.get(1);
			for(int i=2;i<c.size();i++){
				s=s+" "+c.get(i);
			}
			Command co=new sort(s);
			co.execute();
			ch.push(co);
		}
		else if(c.get(0).contentEquals("sort")){
			String s=new String();
			
			Command co=new sort(s);
			co.execute();
			ch.push(co);
		}
		else{
			System.out.println("Invalid Command");
		}
	}
	

	// Return line or null if at end of file
	public String getNextCommand(Scanner in) throws IOException {
		String line = null;
		try {
			line = in.nextLine();
		} catch (NoSuchElementException e) { } // leave line null
		return (line != null) ? line.trim() : line;
	}
	
	// use powerful but somewhat mysterious split method of String
	public static String[] getTokens(String command) {
		return command.split("\\s+"); // white space
	}

	private int[] getIntTokens(String command) {
		String tokens[] = getTokens(command);
		int returnValue[] = new int[tokens.length];
		for (int i = 1; i < tokens.length; i++)
			// skipping 0th, not an int
			returnValue[i] = Integer.parseInt(tokens[i]);
		return returnValue;
	}
	
	public static String readEntry(String prompt,Scanner in)
			throws IOException {
		System.out.print(prompt);
		String out=in.nextLine().trim();
		return out;
		
	}





}
