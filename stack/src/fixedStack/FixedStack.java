package fixedStack;

public class FixedStack {
	int stackSize = 100;
	int[] buffer = new int[stackSize * 3];
	int[] stackPointer = { -1, -1, -1 };

	void push(int stackNum, int value) throws Exception {
		if (stackPointer[stackNum] + 1 >= stackSize) {
			throw new Exception("Out of space");
		}
		stackPointer[stackNum]++;
		buffer[absTopOfStack(stackNum)] = value;
	}

	int pop(int stackNum) throws Exception {
		if (stackPointer[stackNum] == -1) {
			throw new Exception("Trying to pop an empty stack.");
		}
		int value = buffer[absTopOfStack(stackNum)];
		buffer[absTopOfStack(stackNum)] = 0;
		stackPointer[stackNum]--;
		return value;
	}

	int peek(int stackNum) {
		int index = absTopOfStack(stackNum);
		return buffer[index];
	}

	boolean isEmpty(int stackNum) {
		return stackPointer[stackNum] == -1;
	}

	private int absTopOfStack(int stackNum) {
		return stackSize * stackNum + stackPointer[stackNum];
	}
}
