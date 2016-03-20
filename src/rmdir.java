
public class rmdir implements Command {
	private String param;
	public String getParam() {
		return param;
	}
	
	
	public rmdir(String s){
		this.param=s;
	}

	public void setParam(String param) {
		this.param = param;
	}
public void execute(String s){
	
	}
	
	public void execute(){
		FileSystem fs=FileSystem.getFileSystem();
		Directory d=fs.getCurrent();
	   d.removeChild(this.getParam());
		fs.setCurrent(d);
			
	}


	public String getName() {
		// TODO Auto-generated method stub
		return "rmdir";
	}

}
