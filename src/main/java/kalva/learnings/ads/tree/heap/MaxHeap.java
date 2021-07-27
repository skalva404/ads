package kalva.learnings.ads.tree.heap;

import java.util.Vector;

public class MaxHeap {

    private Vector<Integer> data;

    public MaxHeap(int capacity) {
        this.data = new Vector<>(capacity);
    }

    int parent(int i) {
        if (0 == i) {
            return 0;
        }
        return (i - 1) / 2;
    }

    int left(int i) {
        return (2 * i + 1);
    }

    int right(int i) {
        return (2 * i + 2);
    }

    void swap(int x, int y) {
        int temp = data.get(x);
        data.set(x, data.get(y));
        data.set(y, temp);
    }

    void heapifyUp(int i) {
        if (i > 0 && data.get(i) > data.get(parent(i))) {
            swap(i, parent(i));
            heapifyUp(parent(i));
        }
    }

    void add(int key) {
        data.addElement(key);
        heapifyUp(data.size() - 1);
    }

    private void heapifyDown(int i) {
        int left = left(i);
        int right = left(i);
        int largest = i;
        if (left < data.size() && data.get(left) > data.get(i)) {
            largest = left;
        }
        if (right < data.size() && data.get(right) > data.get(i)) {
            largest = right;
        }
        if (largest != i) {
            swap(i, largest);
            heapifyDown(largest);
        }
    }

    int poll() {
        if (0 == data.size()) {
            return 0;
        }

        int root = data.firstElement();
        data.setElementAt(data.lastElement(), 0);
        data.remove(data.size() - 1);
        heapifyDown(0);
        return root;
    }


    public static void main(String[] args) {
        MaxHeap heap = new MaxHeap(3);
        heap.add(3);
        heap.add(2);
        heap.add(15);
        System.out.println(heap.data);
        heap.poll();
        System.out.println(heap.data);
    }
}
