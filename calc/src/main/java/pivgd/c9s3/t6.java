package pivgd.c9s3;

import java.util.*;

public class t6 {
    public static void main(String[] args) {

        final AnimalQuene animalQuene = new AnimalQuene();

        animalQuene.enqueue(10012, 1);
        animalQuene.enqueue(1002, 1);
        animalQuene.enqueue(1003, 1);
        animalQuene.enqueue(1004, 1);
        animalQuene.enqueue(1001, 1);
        animalQuene.enqueue(1001, 2);
        animalQuene.enqueue(1002, 2);
        animalQuene.enqueue(1003, 2);
        animalQuene.enqueue(1004, 2);

        System.out.println(animalQuene.dequeoueDog());
        System.out.println(animalQuene.dequeueCat());
        System.out.println(animalQuene.dequeueAny());

    }
}

class AnimalQuene {
	
	// 1代表猫，2代表狗
	LinkedList<Integer> cats = new LinkedList<>();
	
	LinkedList<Integer> dogs = new LinkedList<>();
	
	public void enqueue(int age, int animal) {
		if(animal == 1) {
			cats.push(age);
		} else if (animal == 2) {
			dogs.push(age);
		}
		
	}
	
	public int dequeoueDog() {
		
		return dogs.removeLast();
	}
	
	public int dequeueCat() {
		return cats.removeLast();
	}
	
	public int dequeueAny() {
		return dogs.getLast() > cats.getLast() ? dogs.removeLast() : cats.removeLast();
	}

}
