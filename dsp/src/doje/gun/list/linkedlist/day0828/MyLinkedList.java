package doje.gun.list.linkedlist.day0828;

import java.util.List;

/**
 * @author kimgun
 * @date 2018.08.28
 */
public class MyLinkedList {

	// 리스트의 첫 번째 노드
	private Node first;
	// 리스트의 사이즈
	int size;

	/** 전연 변수의 초기화를 담당함  
	 * @author kimgun
	 * */
	public MyLinkedList() {
		first = null;
		size = 0;
	}

	/**
	 * (노드 객체)
	 * 데이터와 다음 객체의 주소를 가짐
	 * @author kimgun
	 */
	private class Node {

		//데이터
		private String data;

		//다음 노드의 주소
		private Node next;

		/** data를 넣어서 생성하도록 함
		 * @param data 노드 안에 들어올 값 
		 */
		private Node(String data) {
			this.data = data;
		}
	}

	/** 파라미터의 값이 0보다 작거나 size보다 큰 지 판별함.
	 * @param index 인덱스 참조 판별을 위한 변수
	 * @author kimgun
	 */
	private void checkIndexBounds(int index, int max) {
		if (max < index || index < 0) {
			throw new ArrayIndexOutOfBoundsException("인덱스를 확인하세요.");
		}
	}

	/** 전달된 index번째 노드를 반환해준다.
	 * @param index 찾고자 하는 노드의 index
	 * @return
	 * @author kimgun
	 */
	private Node searchIndexNode(int index) {
		Node myNode = first;

		for (int i = 0; i < index; i++) {
			myNode = myNode.next;
		}
		return myNode;
	}

	/** 배열의 마지막에 값을 넣는 기능을 함.
	 * @author kimgun
	 * @param str 배열에 넣을 값
	 * @return 성공 여부를 true/false로 반환
	 * @author kimgun
	 */
	public boolean add(String str) {
		try {
			Node newNode = new Node(str);
			if (first == null) {
				first = newNode;
			} else {
				Node current = searchIndexNode(size - 1);
				current.next = newNode;
			}
		} catch (Exception e) {
			return false;
		}
		size++;
		return true;
	}

	/** 원하는 index자리에 str값을 넣는 기능
	 * @param index 값을 넣을 위치를 나타내는 변수
	 * @param element 배열에 추가할 값
	 * @author kimgun
	 */
	public void add(int index, String str) {

		checkIndexBounds(index, size);
		Node newNode = new Node(str);
		if (index == 0) {
			newNode.next = first;
			first = newNode;
		} else {
			Node myNode = searchIndexNode(index - 1);
			newNode.next = myNode.next;
			myNode.next = newNode;
		}
		size++;
	}

	/** 들어온 배열의 값을 배열의 마지막 자리부터 넣는 기능.
	 * @param c 배열에 넣을 리스트
	 * @return 성공 여부를 true/false로 반환
	 * @author kimgun
	 */
	public boolean addAll(List<String> c) {
		try {
			for (int i = 0; i < c.size(); i++) {
				add(c.get(i));
			}
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	/**
	 * index번째 부터 배열에 값들을 추가한다.
	 * @param index List안의 값들을 넣기 시작할 index 위치를 나타내는 변수
	 * @param c 배열에 넣을 값들을 가지고 있는 List변수
	 * @return
	 * @author kimgun
	 */
	public boolean addAll(int index, List<String> c) {
		checkIndexBounds(index, size);

		for (int i = 0; i < c.size(); i++) {
			add(index, c.get(i));
			index++;
		}
		return false;
	}

	/**
	 * 배열안에 값을 초기화함.
	 * @author kimgun
	 */
	public void clear() {
		first = null;
		size = 0;
	}

	/** 배열 안에 str과 같은 값이 있나를 판별하는 기능을 함.
	 * @param str 검색을 위한 변수
	 * @return 성공하면 true/ 실패하면 false를 반환
	 * @author kimgun
	 */
	public boolean contains(String str) {
		return indexOf(str) > -1;
	}

	/** 배열 안에 List안에 값이 모두 있는지 판별하는 기능을 함.
	 * @param c List안에 값들의 검색을 위한 변수
	 * @return 성공하면 true/ 실패하면 false를 반환
	 * @author kimgun
	 */
	public boolean containsAll(List<String> c) {
		for (int i = 0; i < c.size(); i++) {
			if (contains(c.get(i)) == false) {
				return false;
			}
		}
		return true;
	}

	/** 빈 배열인지 판단하는 기능을 함
	 * @return size가 0이면 true/ 아니면 false
	 * @author kimgun
	 */
	public boolean isEmpty() {
		return size == 0;
	}

	/**
	 * 배열 내 0번째부터 찾아서 str과 같은 값이 처음으로 발견되면 그 index를 반환한다.
	 * @param str 자신과 같은 값을 찾기 위한 변수
	 * @return 발견된 str과 같은 값의 index를 반환한다. 없을 경우, -1를 반환한다.
	 * @author kimgun
	 */
	public int indexOf(String str) {
		for (int i = 0; i < size; i++) {
			if (get(i).equals(str)) {
				return i;
			}
		}
		return -1;
	}

	/**
	 * 배열 내 제일 뒤에서 부터 찾아서 str과 같은 값이 처음으로 발견되면 그 index를 반환한다.
	 * @param str 자신과 같은 값을 찾기 위한 변수
	 * @return 발견된 str과 같은 값의 index를 반환한다. 없을 경우, -1를 반환한다.
	 * @author kimgun
	 */
	public int lastIndexOf(String str) {
		for (int i = size - 1; i >= 0; i--) {
			if (get(i).equals(str)) {
				return i;
			}
		}
		return -1;
	}

	/**
	 * 넘어온 index번째에 들어있는 배열의 값을 삭제한다.
	 * @param index 삭제할 값의 위치를 나타내는 변수
	 * @return
	 * @author kimgun
	 */
	public String remove(int index) {
		checkIndexBounds(index, size - 1);

		if (index == 0) {
			first = first.next;
		} else {
			Node myNode;
			myNode = searchIndexNode(index - 1);
			myNode.next = myNode.next.next;
		}
		this.size--;
		return null;
	}

	/**
	 * 넘어온 str과 같은 값이 들어있는 배열의 값을 삭제한다.
	 * @param o 삭제할 값이 들어있는 변수
	 * @return
	 * @author kimgun
	 */
	public boolean remove(Object o) {
		if (lastIndexOf((String) o) > -1) {
			remove(lastIndexOf((String) o));
			return true;
		}
		return false;
	}

	/**
	 * 넘어온 List안에 값과 똑같은 값은 배열에서 모두 삭제한다.
	 * @param c 삭제할 값들이 들어있는 변수
	 * @return
	 * @author kimgun
	 */
	public boolean removeAll(List<String> c) {
		for (int i = 0; i < c.size(); i++) {
			for (int j = 0; j < size; j++) {
				remove(c.get(i));
			}
		}
		return false;
	}

	/**
	 * 넘어온 List안에 값과 똑같은 값만 남겨두고 나머지 값들은 배열에서 모두 삭제한다.
	 * @param c 남겨둘 값들이 들어있는 변수
	 * @return
	 * @author kimgun
	 */
	public boolean retainAll(List<String> c) {
		clear();
		return addAll(c);
	}

	/**
	 * 넘어온 index번째 값을 str로 변경한다.
	 * @param index 값을 바꿀 배열의 인덱스가 들어있는 변수
	 * @param str 바꿀 값이 들어있는 변수
	 * @return 값을 바꾸는 인덱스에 원래 있던 값을 반환한다.
	 * @author kimgun
	 */
	public String set(int index, String str) {
		checkIndexBounds(index, size - 1);
		Node myNode = searchIndexNode(index);
		myNode.data = str;
		String oldStr = myNode.data;
		return oldStr;
	}

	/**
	 * 배열 안에 index번째 값을 반환해준다.
	 * @param 배열의 index를 나타내는 변수
	 * @return arr배열의 index번째 값을 반환
	 * @author kimgun
	 */
	public String get(int index) {
		checkIndexBounds(index, size - 1);
		return searchIndexNode(index).data;
	}

	/**
	 * 배열의 크기를 반환한다.
	 * @return
	 * @author kimgun
	 */
	public int size() {
		return this.size;
	}
}