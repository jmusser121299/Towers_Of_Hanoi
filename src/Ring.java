import javafx.scene.paint.Color;

public class Ring {
	private Integer value;
	private Color color;
	
	public Ring() {
		this.setValue(0);
		this.setColor(new Color(Math.random(), Math.random(), Math.random(), 1));
	}

	public Ring(int n) {
		this.setValue(n);
		this.setColor(new Color(Math.random(), Math.random(), Math.random(), 1));
	}
	
	public int compareTo(Ring otherRing) {
		if(this.value < otherRing.value())
			return -1;
		else
			return 1;
	}
	
	public Integer value() {
		return value;
	}

	public void setValue(Integer value) {
		this.value = value;
	}

	public Color color() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}
	
	public void printRing() {
		System.out.print("[");
		for(int i = 1; i < this.value * 2; i++) {
			System.out.print(" ");
			if(i == this.value)
				System.out.print(i);
		}
		System.out.println("]");
	}
}
