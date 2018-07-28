package Animal;

public class App {
	public static void main(String[] args) {
		AnimalQeueue animalQeueue = new AnimalQeueue();
		Dog dog1 = new Dog("dog1");
		Dog dog2 = new Dog("dog2");

		Cat cat1 = new Cat("cat1");
		Cat cat2 = new Cat("cat2");
		animalQeueue.enqueue(dog1);
		animalQeueue.enqueue(cat1);
		animalQeueue.enqueue(dog2);
		animalQeueue.enqueue(cat2);

		Animal animal = animalQeueue.dequeueAny();
		System.out.println(animal.name);
		System.out.println(animal.getOrder());
	}
}
