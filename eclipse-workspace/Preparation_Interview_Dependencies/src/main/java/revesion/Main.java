package revesion;

import java.util.Date;

public class Main {
	
	public static void main(String[] args) {
		
		Date date = new Date();
		
		String timeStamp = date.toString().substring(11, 19).replace(":", "");
		System.out.println(timeStamp);
	}

}
