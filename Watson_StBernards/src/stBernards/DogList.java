package stBernards;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class DogList implements List{
	private int count;
	private Node<DogInfo> head;
	private Node<DogInfo> tail;

	
	public boolean isEmpty(){
		return head == null;
	}
	
	public int size(){
		return count;
	}
	public void add(DogInfo data){
		Node<DogInfo> node = new Node<DogInfo>();
		node.setData(data);
		if (head == null) {
			head = node;
		}else{
			tail.setNext(node);
		}
		tail = node;
		count++;
	}
	public DogInfo get(String search){
		Node<DogInfo> pointer = head;
		while (pointer != null) {
			if( pointer.getData().toString().contains((CharSequence) search)){
				return pointer.getData();
			}
			pointer = pointer.getNext();
		}
		return null;
	}
	public DogInfo remove(String regNumber){
		if(isEmpty()){
			return null;
		}
		if(head.getData().toString().equals(regNumber)){
			Node<DogInfo> toRemove = head;
			head = head.getNext();
			count--;
			return toRemove.getData();
		}
		Node<DogInfo> pointer = head;
		while(!pointer.getData().toString().equals(regNumber)){
			pointer = pointer.getNext();
			if(pointer == null){
				return null;
			}
		}	
		Node<DogInfo> toRemove = pointer.getNext();
		if(toRemove.equals(tail)){
			tail = pointer;
		}
		pointer.setNext(toRemove.getNext());
		count--;
		return  toRemove.getData();
	}
	public void nameArray() {
		String[] nameArray;
		nameArray = new String[count];
		Node<DogInfo> pointer = head;
		
			for(int i = 0; i < count; i++){
				nameArray[i] = pointer.getData().getName();
				pointer = pointer.getNext();
			}
			
		
		System.out.println(Arrays.toString(nameArray));
		}

	@Override
	public boolean add(Object e) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void add(int index, Object element) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean addAll(Collection c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addAll(int index, Collection c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean contains(Object o) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean containsAll(Collection c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public DogInfo get(int index) {
		Node<DogInfo> pointer = head;
		for(int i = 0; i < index; i ++){
				pointer = pointer.getNext();
			}			
		return pointer.getData();
		
	}

	@Override
	public int indexOf(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Iterator iterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int lastIndexOf(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ListIterator listIterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ListIterator listIterator(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean remove(Object o) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Object remove(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean removeAll(Collection c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean retainAll(Collection c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Object set(int index, Object element) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List subList(int fromIndex, int toIndex) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object[] toArray() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object[] toArray(Object[] a) {
		// TODO Auto-generated method stub
		return null;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public Node<DogInfo> getHead() {
		return head;
	}

	public void setHead(Node<DogInfo> head) {
		this.head = head;
	}

	public Node<DogInfo> getTail() {
		return tail;
	}

	public void setTail(Node<DogInfo> tail) {
		this.tail = tail;
	}
	
//	public String getDamName(String search) {
//		Node<DogInfo> pointer = head;
//		while (pointer != null) {
//			if( pointer.getData().toString().contains(search)){
//				return pointer.getData().getDam().getName();
//			}
//			pointer = pointer.getNext();
//		}
//		return null;
//	}
//	public String getSireName(String search) {
//		Node<DogInfo> pointer = head;
//		while (pointer != null) {
//			if( pointer.getData().getName().contains(search)|| pointer.getData().getRegNumber().contains(search)){
//				return pointer.getData().getSire().getName();
//			}
//			pointer = pointer.getNext();
//		}
//		return null;
//	}


	
}


//method in dog list that returns a string array of the names,  
//take the string array and pass into constructor spinner list model, 
//use the spinner list model to cast into the constructor of JSpinner.

