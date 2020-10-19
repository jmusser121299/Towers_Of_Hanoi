
public class Stack<Item> {
	private Item[] stack;
	  private int size;
	  private int count;
	  
	  @SuppressWarnings("unchecked")
	  public Stack() {
		  this.setArray((Item[])new Object[10]);
		  this.setSize(0);
		  this.setCount(0);
	  }

	  public void push(Item item) {
		  this.stack[this.size()] = item;
	      this.setCount(this.getCount()+1);
		  this.setSize(this.size() + 1);
	      if (this.size() == this.getArray().length) 
			  this.resize(this.size()*2);
	  }
	  
	  public Item pop() throws EmptyStackException {
		  if(this.isEmpty()) 
			  throw new EmptyStackException();
		  else {
			  Item item = this.getArray()[this.size()-1];
			  this.setSize(this.size()-1);
			  this.setCount(this.getCount()+1);
			  if(this.size()< Math.floor((this.getArray().length/4)) 
					  && Math.floor((this.getArray().length/2)) >= 10)
				  this.resize(this.getArray().length/2);
			  return item;
		  }
	  }
	  
	  public Item peek() throws EmptyStackException {
		  if(this.isEmpty()) 
			  throw new EmptyStackException();
		  else {
			  Item item = this.getArray()[this.size()-1];
			  this.setCount(this.getCount()+1);
			  return item;
		  }
	  }
	  
	  public boolean isEmpty() {
		if(this.size() == 0)
			return true;
		return false;
	  }

	  private void resize(int max) {
		@SuppressWarnings("unchecked")
		Item[] resized = (Item[])new Object[max];
		for(int i = 0; i < this.size(); i++)
			resized[i] = this.getArray()[i];
		this.setCount(this.getCount() + (this.size()*2));
		this.setArray(resized);
	  }

	  public Item[] getArray() {
		return stack;
	  }

	  private void setArray(Item[] stack) {
		this.stack = stack;
	  }

	  public int size() {
		return size;
	  }

	  private void setSize(int size) {
		this.size = size;
	  }

	  public int getCount() {
		return count;
	  }

	  private void setCount(int count) {
		this.count = count;
	  }
}
