import java.util.ArrayList;

public class Tower {
	private ArrayList<Ring> tower;
	
	public Tower() {
		this.setTower(new ArrayList<Ring>());
	}

	public Tower(int n) {
		this.setTower(new ArrayList<Ring>());
		for(int i = 1; i <= n; i++)
			this.tower.add(new Ring(i));
	}
	
	public Ring pop() throws EmptyTowerException {
		if(this.isEmpty())
			throw new EmptyTowerException();
		return this.tower.remove(0);
	}
	
	public Ring add(Ring r) {
		if(this.isEmpty()) {
			this.tower.add(0, r);
			return r;
		} else if(r.compareTo(this.tower.get(0)) == -1) {
			this.tower.add(0, r);
			return r;
		} else
			return null;		
	}
	
	private boolean isEmpty() {
		return this.tower.isEmpty();
	}
	
	public void printTower(int tower_number, int level) {
		System.out.println("Tower " + tower_number + ":\n");
		printPadding(level+1);
		System.out.println("|");
		for(int i = 0; i < level; i++) {
			if(i >= level - tower.size()) {
				Ring r = this.tower.get(i-(level - tower.size()));
				printPadding(level - r.value());
				r.printRing();
			} else {
				printPadding(level+1);
				System.out.println("|");
			}
		}
		System.out.print("<");
		for(int i = 0; i < ((level)*2) + 1; i++) {
			if(i%2==0)
				System.out.print("/");
			else
				System.out.print("\\");
		}
		System.out.println(">\n");
	}
	private void printPadding(int n) {
		for(int i = 0; i < n; i++)
			System.out.print(" ");
	}

	public ArrayList<Ring> getTower() {
		return tower;
	}

	private void setTower(ArrayList<Ring> tower) {
		this.tower = tower;
	}
	
}
