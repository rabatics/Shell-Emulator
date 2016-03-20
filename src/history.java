
public class history implements Command {
private String param;



public history(){
	
}
	public void execute(){
		CommandHistory ch=CommandHistory.getCommandHistory();
		ch.printCommands();
	}

	@Override
	public void execute(String s) {
		// TODO Auto-generated method stub
		
	}
	
	
	public String getParam(){
		return "";
	}
	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "history";
	}
}
