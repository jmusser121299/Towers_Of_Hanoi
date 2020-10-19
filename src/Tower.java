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
		for(int i = level; i >= 0; i--) {
			if(i >= this.tower.size() && !this.tower.isEmpty()) {
				for(int j = 0; j < level; j++)
					System.out.print(" ");
				System.out.println("|");
			} else {
				if(i == 0) {
					for(int j = 0; j < ((level + 1) * 2) + 1; j++)
						System.out.print("_");
					System.out.println();
				} else {
					for(int j = 0; j < level - (i + 1); j ++)
						System.out.print(" ");
					this.tower.get(i).printRing();
				}
			}
		}
	}
	public ArrayList<Ring> getTower() {
		return tower;
	}

	private void setTower(ArrayList<Ring> tower) {
		this.tower = tower;
	}
	
}
