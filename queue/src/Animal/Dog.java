package Animal;

public class Dog extends Animal {

	public Dog(String n) {
		super(n);
	}

	public boolean isOlderThan(Cat cat) {
		return this.getOrder() >= cat.getOrder();
	}

}
