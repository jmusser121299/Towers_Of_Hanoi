
public class Towers_Of_Hanoi {

	public static void main(String[] args) {
		if(Integer.parseInt(args[0]) == 1)
			ToH_GUI_View.start();
		else
			ToH_Text_View.start();
	}
}
