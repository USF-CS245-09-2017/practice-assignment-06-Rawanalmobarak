public class BinaryHeap {

	private int[] data;
	private int size;

	public BinaryHeap() {
		data = new int[1000000];
		size = 0;
	}

	public void add(int i) {
		int current = size;
		data[size++] = i;
		while (data[current] < data[parent(current)]) {
			swap(current, parent(current));
			current = parent(current);
		}

	}

	public int remove() {
		if (data == null) {
			try {
				throw new Exception("priority queue is empty!");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		int priority = data[0];
		swap(0, --size);
		if (size != 0) {
			siftdown(0);
		}
		return priority;
	}

	private void siftdown(int i) {
		if (left_child(i) >= size)
			return;
		int child = left_child(i);
		if (right_child(i) < size && data[right_child(i)] < data[child])
			child = right_child(i);
		if (data[child] < data[i]) {
			swap(child, i);
			siftdown(child);
		}
	}

	private void swap(int i1, int i2) {
		int tmp;
		tmp = data[i1];
		data[i1] = data[i2];
		data[i2] = tmp;

	}

	private int parent(int i) {
		return (int) Math.floor((i - 1) / 2);
	}

	private int right_child(int i) {
		return (2 * i) + 2;
	}

	private int left_child(int i) {
		return (2 * i) + 1;
	}

}
