package model;

public class PasswordCheck {
	
	private String original;
	
	
	public static boolean checkWindow1(String box) {
		
		boolean answer= false;
		
		if(box.length()==1 && box.matches("[0-9]*"))
			answer=true;
		
		return answer;
	}


	public String getOriginal() {
		return original;
	}


	public void setOriginal(String original) {
		this.original = original;
	}
	
	
}
