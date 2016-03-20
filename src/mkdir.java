
public class mkdir implements Command {
	private String param;
	
	public String getParam() {
		return param;
	}

	public void setParam(String param) {
		this.param = param;
	}
	
	
	
	public mkdir(String s){
		this.param=s;
	}
	
	public void execute(String s){
	
		
	}
	
	public void execute(){
		FileSystem fs=FileSystem.getFileSystem();
		Directory d=fs.getCurrent();
		fs.addChild(new Directory(d,this.getParam(),0,d.getOwner()));
		fs.setCurrent(d);
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "mkdir";
	}

}
