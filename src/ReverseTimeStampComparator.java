import java.util.Comparator;

public class ReverseTimeStampComparator implements Comparator<FSElement>  {

	@Override
	public int compare(FSElement o1, FSElement o2) {
		// TODO Auto-generated method stub
		return o2.getCreated().compareTo(o1.getCreated());
	}

}