import java.util.ArrayList;
import java.util.Date;

public class FSElement {
private String name;
private Directory parent;

private int size;
private Date created;
private Date modified;
private String owner;
private Boolean isLeaf;

public FSElement(Directory parent,String n,int s,String own){
	this.parent=parent;
	this.name=n;
	this.size=s;
	this.owner=own;
	this.created=new Date();
	this.modified=new Date();
	this.isLeaf=true;
}

public Boolean getIsLeaf(){
	return isLeaf;
}

public String getName() {
	return name;
}

public void setIsLeaf(Boolean leaf){
	this.isLeaf=leaf;
}

public Directory getParent() {
	return parent;
}

public int getSize() {
	return size;
}
public Date getCreated() {
	return new Date(created.getTime());
}
public Date getModified() {
	return new Date(modified.getTime());
}
public String getOwner() {
	return owner;
}

public void setOwner(String n) {
this.owner=n;
}
public void showAllElements(){}

public FSElement(){
	
}


/*public void accept(FSVisitor v){
	
}*/

public static void main(String[] args){
	FileSystem fs=FileSystem.getFileSystem();
	//FSVisitor visit= new CountingVisitor();
	/*Directory system=new Directory(fs.getRoot(),"system",0,fs.getRoot().getOwner());
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
	System.out.println(fs.getRoot().getSize());
	fs.showAllElements();
	
	//System.out.println(system.getName().compareTo(home.getName()));
	fs.setCurrent(pictures);
   Command c=new Ls();
   c.execute();
   c=new Cd();
   c.execute();
  c=new Ls();
   c.execute();
   c=new Pwd();
   c.execute();
 //  System.out.println(fs.getCurrent().getDirectory("home").getName());
   c=new Cd();
   c.execute("home/pictures");
 
   c=new Ls();
   c.execute();
   c=new Pwd();
   c.execute();
   c=new Cd();
   c.execute("../../system");
   c=new Ls();
   c.execute();
   c=new Pwd();
   c.execute();
   c=new dir();
   c.execute();
/*  fs.getRoot().accept(visit);
  System.out.println();
System.out.println("Number of Directories:"+visit.getDirNum());
System.out.println("Number of Files:"+visit.getFileNum());
System.out.println("Number of Links:"+visit.getLinkNum());

FSVisitor fsv=new FileSearchVisitor(".");
fs.getRoot().accept(fsv);
ArrayList<File> afs=fsv.getFoundFiles();
System.out.println("The names of Files found are:");
	for(File f:afs){
		System.out.println(f.getName());
	}
fsv=new SizeCountingVisitor();
fs.getRoot().accept(fsv);
System.out.println("Total Size of Root: "+fsv.getTotalSize());
	*/
fs.init();
}


}
