import java.util.ArrayList;
import java.util.Arrays;

public class Redo  implements Command{

	@Override
	public void execute() {
		CommandHistory ch=CommandHistory.getCommandHistory();
		Command c=ch.pop();
		
		c.execute();
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
		return "Redo";
	}

}
