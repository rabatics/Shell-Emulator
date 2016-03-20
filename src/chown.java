import java.util.ArrayList;
import java.util.Arrays;

public class chown implements Command{
private String param;
	
public chown(String s){
	this.param=s;
}



@Override
	public void execute() {
	FileSystem fs=FileSystem.getFileSystem();
		if(this.param==null){
			System.out.println("Invalid chown command");
		}
		else{
			ArrayList<String> ownfile=new ArrayList<String>(Arrays.asList(this.param.split("\\s+")));
			String owner=ownfile.get(0);
			for(int i=1;i<ownfile.size();i++){
				fs.getCurrent().getDirectory(ownfile.get(i)).setOwner(owner);
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
		return null;
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "chown";
	}

}
