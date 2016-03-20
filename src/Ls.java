
public class Ls implements Command {
private String param;


	
	public void execute(){
		FileSystem fs=FileSystem.getFileSystem();
	Directory d=fs.getCurrent();
	System.out.println();
	for(FSElement f:d.getChildren()){
		
		System.out.println(f.getName());
	}
	}

	@Override
	public void execute(String s) {
		// TODO Auto-generated method stub
		
	}
	
	
	public String getParam() {
		return "";
	}

	public void setParam(String param) {
		this.param = param;
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "ls";
	}
	
	
}