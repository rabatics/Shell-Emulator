import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class sort implements Command {

	private String sort;

	
	
	
	public sort(String s){
		this.sort=s;
	}
@Override
public void execute() {
	// TODO Auto-generated method stub
	FileSystem fs=FileSystem.getFileSystem();
	ArrayList<FSElement> f=fs.getCurrent().getChildren();
	if(this.getParam().contentEquals("")){
		Collections.sort(f,new AlphabeticalComparator());
		fs.getCurrent().setChildren(f);
	}
	else if(this.getParam().contentEquals("reversealphabetical")){
		Collections.sort(f,new ReverseAlphabeticalComparator());
		fs.getCurrent().setChildren(f);
	}
	else if(this.getParam().contentEquals("timestamp")){
		Collections.sort(f,new TimeStampComparator());
		fs.getCurrent().setChildren(f);
	}
	else if(this.getParam().contentEquals("reversetimestamp")){
		Collections.sort(f,new ReverseTimeStampComparator());
		fs.getCurrent().setChildren(f);
	}
	else{
		System.out.println("Invalid Sorting Strategy");
	}
}

@Override
public void execute(String s) {
	// TODO Auto-generated method stub
	
}

@Override
public String getParam() {
	// TODO Auto-generated method stub
	return sort;
}

@Override
public String getName() {
	// TODO Auto-generated method stub
	return "sort";
}




}
