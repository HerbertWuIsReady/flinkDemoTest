package pivgd.c9s3;

import java.util.*;
public class t3 {

	public static void main(String[] args) {
		final SetOfStack setOfStack = new SetOfStack();

		setOfStack.push(0);
		setOfStack.push(1);
		setOfStack.push(2);
		setOfStack.push(3);
		setOfStack.push(4);
		setOfStack.push(5);
		setOfStack.push(6);
		setOfStack.push(7);
		setOfStack.push(8);
		setOfStack.push(9);

		setOfStack.pop(0);
		setOfStack.pop(0);
		setOfStack.pop(0);
		setOfStack.pop();
		setOfStack.pop();
		setOfStack.pop();
		setOfStack.pop();
		setOfStack.pop();
		setOfStack.pop();
		setOfStack.pop();


	}
}

class SetOfStack {
	
	int maxLength = 5;
	
	// 2 dim
	ArrayList<Integer[]> list = new ArrayList<>();
	
	// length
	ArrayList<Integer> lengthList = new ArrayList<>();

	int cur = -1;
	
	public void push(int i) {
		if (cur == -1 || (cur != -1 && lengthList.get(cur) == maxLength) ) {
			Integer[] temp = new Integer[maxLength];
            temp[0] = i;
			list.add(temp);
			lengthList.add(1);
			cur++;
		} else if (cur != -1 && lengthList.get(cur) < maxLength) {
			list.get(cur)[lengthList.get(cur)] = i;
			lengthList.set(cur, lengthList.get(cur) + 1);
		}
	}
	
	public int pop () {
		if(lengthList.get(cur) > 0 && cur != -1) {
            lengthList.set(cur, lengthList.get(cur) - 1);
            return list.get(cur)[lengthList.get(cur)] ;
		} else if (cur != -1) {
			cur--;
			return pop();
		}
		return Integer.MAX_VALUE;
	}
	
	//进阶：实现一个popAt(int index)方法，根据指定的子栈，执行pop 操作
 	public int pop (int index) {
		if(lengthList.get(index) > 0 && index > -1) {
			lengthList.set(index, lengthList.get(index) - 1);
            return list.get(index)[lengthList.get(index)];
		} 
		return Integer.MAX_VALUE;
	}
}
