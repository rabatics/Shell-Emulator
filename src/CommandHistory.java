import java.util.ArrayList;

public class CommandHistory {
private ArrayList<Command> com;
private static CommandHistory instance;
private CommandHistory(){
	this.com=new ArrayList<Command>();
};

public static CommandHistory getCommandHistory(){
	if(instance == null){
		instance = new CommandHistory();
	}
	return instance;
}

public void push(Command c){
	this.com.add(c);
}

public Command pop(){
	return this.com.get(this.com.size()-1);
}



public void printCommands(){
	
	for(Command s:this.com){
		System.out.println();
	System.out.print(s.getName());
	if(s.getParam()!=null){
		System.out.print(" "+s.getParam());
	}
	
	}
}

}
