package ds;
public interface Heap<E>
{
	boolean doesExist(int pos);

	void swap(int pos1,int pos2);

	void Heapify(int pos);

	int length();

	boolean isEmpty();

	void insert(E e);

	void buildHeap();

	E remove();

	E top();
}