package love.cq.util;

import java.util.HashMap;

/**
 * 用map做的计数器.
 * @author ansj
 *
 * @param <T>
 */
public class MapCount<T> {
	private HashMap<T, Integer> hm = null;

	public MapCount() {
		hm = new HashMap<T, Integer>();
	}

	public MapCount(int initialCapacity) {
		hm = new HashMap<T, Integer>(initialCapacity);
	}

	/**
	 * 增加一个元素
	 * 
	 * @param t
	 * @param n
	 */
	public void add(T t, int n) {
		Integer integer = null;
		if ((integer = hm.get(t)) != null) {
			hm.put(t, integer + n);
		} else {
			hm.put(t, n);
		}
	}

	/**
	 * 计数增加.默认为1
	 * 
	 * @param t
	 */
	public void add(T t) {
		this.add(t, 1);
	}

	/**
	 * map的大小
	 * 
	 * @return
	 */
	public int size() {
		return hm.size();
	}

	/**
	 * 删除一个元素
	 * 
	 * @param t
	 */
	public void remove(T t) {
		hm.remove(t);
	}
	
	/**
	 * 得道内部的map
	 * @return
	 */
	public HashMap<T, Integer> get(){
		return this.hm ;
	}
}
