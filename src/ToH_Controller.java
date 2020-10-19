
public class ToH_Controller {
	private int level;
	private Tower[] towers;
	private int moves;
	private int[] last_move;
	
	public ToH_Controller(int level) {
		this.setLevel(level);
		this.setTowers(3);
		this.setMoves(0);
	}
	
	public ToH_Controller(int level, int num_towers) {
		this.setLevel(level);
		this.setTowers(num_towers);
		this.setMoves(0);
	}
	
	public void move(int from, int to) {
		//TODO move the top ring from the "from" tower to the "to" tower
	}
	
	public int level() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}

	public Tower[] getTowers() {
		return towers;
	}

	public void setTowers(int num_towers) {
		this.towers = new Tower[num_towers];
		for(int i = 0; i < num_towers; i++) {
			if(i == 0)
				this.towers[i] = new Tower(this.level);
			else
				this.towers[i] = new Tower();
		}
			
	}

	public int getMoves() {
		return moves;
	}

	public void setMoves(int moves) {
		this.moves = moves;
	}

	public int[] last_move() {
		return last_move;
	}

	public void setLast_move(int from, int to) {
		this.last_move = new int[]{from, to};
	}
	
	public void printTowers() {
		
		for(int i = 0; i < this.towers.length; i++)
			this.towers[i].printTower(i+1, this.level);
		
	}
}
