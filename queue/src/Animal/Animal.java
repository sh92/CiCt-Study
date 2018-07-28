package Animal;

public abstract class Animal {
	private int order;
	protected String name;

	public Animal(String n) {
		name = n;
	}

	public void setOrder(int ord) {
		order = ord;
	}

	public int getOrder() {
		return order;
	}

}
