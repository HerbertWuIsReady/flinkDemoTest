package pivgd.c9s3;

public class t2 {
	public static void  main(String[] args) {
		Stack stack = new Stack();
		stack.push(1);
		System.out.println(stack.min());
		stack.push(2);
		System.out.println(stack.min());
		stack.push(3);
		System.out.println(stack.min());
		stack.push(4);
		System.out.println(stack.min());
		stack.push(5);
		System.out.println(stack.min());
		stack.push(0);
		System.out.println(stack.min());
		stack.push(-1);
		System.out.println(stack.min());
		stack.push(-2);
		System.out.println(stack.min());
		stack.push(-3);
		System.out.println(stack.min());
	}
}

class Stack {
	int[] arrays = new int[30];
	int[] minArrays = new int[30];
	
	int length = 0;
	
	public boolean push(int number) {
		
		if(length < arrays.length) {
			arrays[length] = number;
		} else {
			return true;
		}
		if(length == 0) {
			minArrays[length] = number;
		} else {
			minArrays[length] = minArrays[length - 1] < number ? minArrays[length - 1] : number;
		}
		length++;
		return true;
	}
	
	public int pop() {
		if(length > 0 ) {
			length--;
			return arrays[length];
		}
		return 0;
	}
	
	public int min() {
		return minArrays[length - 1];
	}
	
}
