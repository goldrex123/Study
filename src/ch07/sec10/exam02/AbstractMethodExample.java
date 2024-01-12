package ch07.sec10.exam02;

public class AbstractMethodExample {
	public static void main(String[] args) {
		Dog dog = new Dog();
		dog.sound();
		
		Cat cat = new Cat();
		cat.breathe();
		cat.sound();
		
		AbstractMethodExample.animalSound(new Dog());
		AbstractMethodExample.animalSound(new Cat());
	}

	public static void animalSound(Animal animal) {
		if(animal instanceof Cat) {
			animal.sound();
			
		}
	}
}
