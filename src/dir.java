import java.util.ArrayList;
import java.util.Arrays;

public class dir implements Command{
	private String param;

	public dir(String s){
		this.param=s;
	}

	public dir(){
		
	}
	public void execute(){
		FileSystem fs=FileSystem.getFileSystem();
		Directory d=fs.getCurrent();
		
      if(this.getParam()==null){
			
			
			fs.setCurrent(d);
			System.out.println();
			for(FSElement f:d.getChildren()){
				
				if(f instanceof Directory){
				System.out.println(f.getName()+" - Directory  - "+f.getSize()+" - "+f.getCreated()+" - "+f.getOwner());
				}
				if(f instanceof Link){
					System.out.println(f.getName()+" - Link  - "+f.getSize()+" - "+f.getCreated()+" - "+f.getOwner());
					}
				if(f instanceof File){
					System.out.println(f.getName()+" - File  - "+f.getSize()+" - "+f.getCreated()+" - "+f.getOwner());
					}
			}
			
			
		}
		else{
		

		
		
		if(this.getParam().contains("/")){
			ArrayList<String> path=new ArrayList<String>(Arrays.asList(this.getParam().split("/")));
			for(String n:path){
				if(n.contains("..")){
					Directory p=d.getParent();
					if(p!=null){
					d=p;
					
						}
						else{
							System.out.println("No Such Directory Exists");
						}
				}
				else{
					Directory p=d.getDirectory(n);
				/*	System.out.println(d.getName()+"----"+n);
					Directory d1=d.getDirectory(n.toString());*/
					if(p!=null){
					 d=p;
						}
						else{
							System.out.println("No Such Directory Exists");
						}
				}
				
				
				
				
				
			}
			for(FSElement f:d.getChildren()){
				
				if(f instanceof Directory){
				System.out.println(f.getName()+" - Directory  - "+f.getSize()+" - "+f.getCreated()+" - "+f.getOwner());
				}
				if(f instanceof Link){
					System.out.println(f.getName()+" - Link  - "+f.getSize()+" - "+f.getCreated()+" - "+f.getOwner());
					}
				if(f instanceof File){
					System.out.println(f.getName()+" - File  - "+f.getSize()+" - "+f.getCreated()+" - "+f.getOwner());
					}
			}
			
			
}
		else{
			if(this.getParam().contains("..")){
				Directory p= d.getParent();
				if(p!=null){
					d=p;
					}
					else{
						System.out.println("No Such Directory Exists");
					}
			}
			else{
		Directory p=d.getDirectory(this.getParam());
		if(p!=null){
		d=p;
		}
		else{
			System.out.println("No Such Directory Exists");
		}
			}
for(FSElement f:d.getChildren()){
				
				if(f instanceof Directory){
				System.out.println(f.getName()+" - Directory  - "+f.getSize()+" - "+f.getCreated()+" - "+f.getOwner());
				}
				if(f instanceof Link){
					System.out.println(f.getName()+" - Link  - "+f.getSize()+" - "+f.getCreated()+" - "+f.getOwner());
					}
				if(f instanceof File){
					System.out.println(f.getName()+" - File  - "+f.getSize()+" - "+f.getCreated()+" - "+f.getOwner());
					}
			}
	}	
		}
		
		
		
	}
	
	public void execute(String s){
		
	}
	
	public String getParam() {
		return param;
	}

	public void setParam(String param) {
		this.param = param;
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "dir";
	}
}
