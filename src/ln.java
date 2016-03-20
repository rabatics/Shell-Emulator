import java.util.ArrayList;
import java.util.Arrays;

public class ln implements Command {
    private String param;
    private String name;
    
    
    public ln(String s,String name){
    	this.param=s;
    	this.name=name;
    }
	@Override
	public void execute() {
		// TODO Auto-generated method stub
		System.out.println(this.getParam()+"  "+name);
		System.out.println(name);
		FileSystem fs=FileSystem.getFileSystem();
		Link l=null;
		Directory d1=fs.getCurrent();
		
		if(this.getParam()==null){
			
			System.out.println("Invalid ln command");
			return;
		}
		else{
		
		
		if(this.getParam().contains("/")){
			ArrayList<String> path=new ArrayList<String>(Arrays.asList(this.getParam().split("/")));
			
			
			
			System.out.println(path.get(0)+" -- "+path.get(1));
			for(String n:path){
			
				if(n.contains("..")){
					Directory d=d1.getParent();
					if(d!=null){
						d1=d;
						}
						else{
							System.out.println("No Such Directory Exists");
						}
				}
				else{
					Directory d=d1.getDirectory(n);
					
				/*	System.out.println(d.getName()+"----"+n);
					Directory d1=d.getDirectory(n.toString());*/
					if(d!=null){
						d1=d;
						}
						else{
							System.out.println("No Such Directory Exists");
						}
				}
			
			
				
				
				
			}
			l=new Link(fs.getCurrent(),name+".lnk",0,fs.getCurrent().getOwner());
			System.out.println(d1.getName());
			
			l.addLink(d1);
			l.getLnkTo();
			fs.addChild(l);
			return;
			
			
			
}
		else{
			if(this.getParam().contains("..")){
				Directory d=fs.getCurrent().getParent();
				if(d!=null){
					d1=d;
					}
					else{
						System.out.println("No Such Directory Exists");
					}
			}
			else{
		/*Directory d=fs.getCurrent().getDirectory(this.getParam());
		if(d!=null){
		fs.setCurrent(d);
		}
		else{
			System.out.println("No Such Directory Exists");
		}*/
				System.out.println("Invalid ln Command");
				return;
			}
			l=new Link(fs.getCurrent(),name+".lnk",0,fs.getCurrent().getOwner());
			l.addLink(d1);
			l.getLnkTo();
			fs.addChild(l);
	}	
		}
	}

	@Override
	public void execute(String s) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getParam() {
		// TODO Auto-generated method stub
		return this.param;
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "ln";
	}

}
