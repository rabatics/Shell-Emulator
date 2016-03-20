import java.util.ArrayList;

public class Pwd implements Command{
private String param;

public String getParam() {
	return "";
}

public void setParam(String param) {
	this.param = param;
}

public Pwd(){
	
}
	@Override
	public void execute() {
		FileSystem fs=FileSystem.getFileSystem();
		Directory cur=fs.getCurrent();
		Directory par=new Directory();
		ArrayList<String> path=new ArrayList<String>();
		//System.out.println(name);
		while(par!=null){
			par=cur.getParent();
			path.add(cur.getName());
			cur=par;
		}
		for(int i=path.size()-1;i>=0;i--){
			System.out.print("/"+path.get(i));
		}
	}

	@Override
	public void execute(String s) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "pwd";
	}

	
}
