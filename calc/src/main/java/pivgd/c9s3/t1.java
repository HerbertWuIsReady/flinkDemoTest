package pivgd.c9s3;

class t1 {
	
	public static void main (String[] args) {
		
		Stack3<Integer> stack = new Stack3<Integer>();
		
		stack.push(1,0);
		stack.push(1,1);
		stack.push(1,2);
		stack.push(1,3);
		stack.push(1,4);
		stack.push(1,5);
		stack.push(1,6);
		stack.push(1,7);
		stack.push(1,8);
		stack.push(1,9);
		stack.push(1,10);

		stack.pop(0);
		stack.pop(1);
		stack.pop(1);
		stack.pop(1);
		stack.pop(1);
		stack.pop(1);
		stack.pop(1);
		stack.pop(1);
		stack.pop(1);
		stack.pop(1);
		stack.pop(1);
		stack.pop(1);

		for (Object array : stack.arrays) {
			
		}


		for (int i = 0; i < stack.arrays.length; i++) {
			System.out.print(stack.arrays[i] + "");
		}
		
	}
	
}


class Stack3<T> {
	
	T[] arrays = (T[])new Object[30];
	
	int length1 = 0;
	int length2 = 0;
	int length3 = 0;
	
	public boolean push (int num, T t) {

		
		if (num == 1 && length1 < arrays.length/3) {
			arrays[length1 * 3 + num] = t;
			length1++;
		} else if (num == 2 && length2 < arrays.length/3)  {
			arrays[length2 * 3 + num] = t;
			length2++;
		} else if (num == 3 && length3 < arrays.length/3)  {
			arrays[length3 * 3 + num] = t;
			length3++;
		} else {
			return false;
		}
		return true;
		
	}
	
	public T pop(int num) {
		if (length1 > 0 && num == 1) {
			length1--;
			return arrays[length1 * 3 + num];
		} else if (length2 > 0 && num == 2) {
			length2--;
			return arrays[length2 * 3 + num];
		} else if (length3 > 0 && num == 3) {
			length3--;
			return arrays[length3 * 3 + num];
		}
		return null;
	}
}
