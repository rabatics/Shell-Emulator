import java.util.ArrayList;
import java.util.Arrays;

public class Cd implements Command{
private String param;

public Cd(String s){
	this.param=s;
}

public Cd(){
	
}
	@Override
	public void execute() {
		FileSystem fs=FileSystem.getFileSystem();
		if(this.getParam()==null){
			
			Directory d=fs.getRoot();
			fs.setCurrent(d);
			
		}
		else{
		
		
		if(this.getParam().contains("/")){
			ArrayList<String> path=new ArrayList<String>(Arrays.asList(this.getParam().split("/")));
			for(String n:path){
				if(n.contains("..")){
					Directory d=fs.getCurrent().getParent();
					if(d!=null){
						fs.setCurrent(d);
						}
						else{
							System.out.println("No Such Directory Exists");
						}
				}
				else{
					Directory d=fs.getCurrent().getDirectory(n);
				/*	System.out.println(d.getName()+"----"+n);
					Directory d1=d.getDirectory(n.toString());*/
					if(d!=null){
						fs.setCurrent(d);
						}
						else{
							System.out.println("No Such Directory Exists");
						}
				}
				
				
				
				
				
			}
			
			
}
		else{
			if(this.getParam().contains("..")){
				Directory d=fs.getCurrent().getParent();
				if(d!=null){
					fs.setCurrent(d);
					}
					else{
						System.out.println("No Such Directory Exists");
					}
			}
			else{
		Directory d=fs.getCurrent().getDirectory(this.getParam());
		if(d!=null){
		fs.setCurrent(d);
		}
		else{
			System.out.println("No Such Directory Exists");
		}
			}
	}	
		}
	}

	public String getParam() {
		return param;
	}

	public void setParam(String param) {
		this.param = param;
	}

	@Override
	public void execute(String s) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "cd";
	}
	
	
}
