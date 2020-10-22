
public class ToH_Controller {
	
	// FIELDS
	
	private int level;
	private Tower[] towers;
	private int move_counter;
	private Stack<int[]> moves;
	
	
	// CONSTRUCTORS
	
	public ToH_Controller(int level) {
		this.setLevel(level);
		this.setTowers(3);
		this.setMoveCounter(0);
	}
	
	public ToH_Controller(int level, int num_towers) {
		this.setLevel(level);
		this.setTowers(num_towers);
		this.setMoveCounter(0);
	}
	
	// STATE CHANGING METHODS
	
	public boolean move(int from, int to) {
		//TODO move the top ring from the "from" tower to the "to" tower
		if(from < this.towers.length && from >= 0 && from != to)
			if(to < this.towers.length && to >= 0) {
				try {
					Ring r = this.towers[from].pop();
					if(this.towers[to].add(r) == null) { // tried to add on top of a smaller ring
						this.towers[from].add(r);
						return false;
					} else {
						this.moves.push(new int[] {from, to});
						this.move_counter ++;
						return true;
					}	
				} catch (EmptyTowerException e) {
					System.out.println("Tower " + from + " is empty.\n");
					return false;
				}
			}	
			return false;
		}

	public boolean undo() {
		//TODO pop last move from moves and make a move that reverses 
		//from and to
		int[] last_move = this.last_move();
		if(last_move == null)
			return false;
		
		if(this.move(last_move[1], last_move[0])) {
			// -1 for undoing the move() keeping the counter where it was 
			// before undo() was called
			this.move_counter --; 
			this.last_move(); // pop off what move() added to the moves stack
			return true;
		} else {
			// this should not be reached
			System.out.println("umm... this is awkward\n");
			return false;
		}
		
	}
	
	public boolean checkWin() {
		return this.towers[this.towers.length-1].getTower().size() == this.level;
	}
	
	public void printTowers() {
		
		for(int i = 0; i < this.towers.length; i++)
			this.towers[i].printTower(i+1, this.level);
		
	}
	
	// GETTERS AND SETTERS
	
	private int level() {
		return level;
	}
	
	private void setLevel(int level) {
		this.level = level;
	}

	private Tower[] getTowers() {
		return towers;
	}

	private void setTowers(int num_towers) {
		this.towers = new Tower[num_towers];
		for(int i = 0; i < num_towers; i++) {
			if(i == 0)
				this.towers[i] = new Tower(this.level);
			else
				this.towers[i] = new Tower();
		}
			
	}

	public int getMoveCounter() {
		return move_counter;
	}

	private void setMoveCounter(int moves) {
		this.move_counter = moves;
	}

	private int[] last_move() {
		try {
			return this.moves.pop();
		} catch (EmptyStackException e) {
			return null;
		}
	}

	private Stack<int[]> getMoves() {
		return moves;
	}

	private void setMoves() {
		this.moves = new Stack<int[]>();
	}
}
