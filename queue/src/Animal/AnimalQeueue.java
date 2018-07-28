package Animal;

import java.util.LinkedList;

public class AnimalQeueue {
	LinkedList<Dog> dogs = new LinkedList<Dog>();
	LinkedList<Cat> cats = new LinkedList<Cat>();
	private int order = 0;

	public void enqueue(Animal a) {
		a.setOrder(order);
		order++;

		if (a instanceof Dog) {
			dogs.addLast((Dog) a);
		} else if (a instanceof Cat) {
			cats.addLast((Cat) a);
		}
	}

	public Animal dequeueAny() {
		if (dogs.size() == 0) {
			return cats.poll();
		} else if (cats.size() == 0) {
			return dogs.poll();
		}
		Dog dog = dogs.peek();
		Cat cat = cats.peek();

		if (dog.isOlderThan(cat)) {
			return dequeueDogs();
		} else {
			return dequeueCats();
		}
	}

	private Animal dequeueCats() {
		return cats.poll();
	}

	private Dog dequeueDogs() {
		return dogs.poll();
	}
}
