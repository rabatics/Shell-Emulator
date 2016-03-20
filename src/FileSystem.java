import java.util.ArrayList;
import java.util.Collections;

public class FileSystem {
	
	private Directory dir;
	private Directory current;
	private static FileSystem instance = null;
	
	private FileSystem(){
		this.dir = new Directory(null, "root", 0, "Rajesh");
	this.current=dir;
	};
	
	public static FileSystem getFileSystem(){
		if(instance == null){
			instance = new FileSystem();
		}
		return instance;
	}
	
	public Directory getRoot(){
		return this.dir;
	}
	
	public ArrayList<FSElement> getChildren(){
		return this.getCurrent().getChildren();
	}
	
	public void addChild(FSElement f){
		Collections.sort(this.getChildren(), new AlphabeticalComparator());
		int i=0;
		int s=this.getChildren().size();
		System.out.println(s);
		for(FSElement f1:this.getChildren()){
		AlphabeticalComparator ac=new AlphabeticalComparator();
		int res=ac.compare(f1, f);
	
		if(res>0){	
		this.getCurrent().addChild(f,i);
		return;
		}
	
		
		
		i++;
		//System.out.println(i);
		}
		if(i==s){
			this.getCurrent().appendChild(f);
		}
	}
	
	
	
	
	public void showAllElements(){
		/*for(FSElement fs : dir.getChildren()){
			System.out.print(fs.getName() + "-->");
			fs.showAllElements();
		}*/
		System.out.println(dir.getName());
		dir.showAllElements();
	}
	
	
	public void setCurrent(Directory dir){
		this.current=dir;
	}
	
	
	public Directory getCurrent(){
		return this.current;
	}
	
	
	public void init(){
		FileSystem fs=FileSystem.getFileSystem();
		//FSVisitor visit= new CountingVisitor();
		Directory system=new Directory(fs.getRoot(),"system",0,fs.getRoot().getOwner());
		Directory home=new Directory(fs.getRoot(),"home",0,fs.getRoot().getOwner());
		
		system.appendChild(new File(system,"a.exe",1,system.getOwner()));
		system.appendChild(new File(system,"b.bat",1,system.getOwner()));
		system.appendChild(new File(system,"c.exe",1,system.getOwner()));
		home.appendChild(new File(system, "d.bash", 1, home.getOwner()));
		Directory pictures = new Directory(home, "pictures", 0, home.getOwner());
		File e=new File(pictures, "e.exe", 1, home.getOwner());
		pictures.appendChild(e);
		
		pictures.appendChild(new File(pictures, "f.bat", 1, home.getOwner()));
		home.appendChild(pictures);
		Link x =new Link(home,"x.lnk",0,home.getOwner());
		x.addLink(system);
		home.appendChild(x);
		Link y =new Link(pictures,"y.lnk",0,pictures.getOwner());
	y.addLink(e);
	pictures.appendChild(y);

		
		fs.getRoot().appendChild(system);
		fs.getRoot().appendChild(home);
		
		fs.showAllElements();
		
		

	}
	
	
	
	
	
	
}
