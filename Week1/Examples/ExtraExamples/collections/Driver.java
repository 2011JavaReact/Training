package com.revature.collections;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ArrayBlockingQueue;

public class Driver {

	public static void main(String[] args) {
		System.out.println("====LISTS=====");
		ArrayList l1 = new ArrayList();
		l1.add(1);
		l1.add("string");
		l1.add(true);
		
		System.out.println(l1);
		//note that you can add any object you want to an arraylist.
		//also note that an item must be an object to add it to the arraylist,
		//so in the example above, the 1 and the true are actually being autoboxed
		//into their wrapper classes
		
		/*
		 * Genereics
		 * -Enforces a type for a collection
		 * 		-you can also make the enforced type variable, allow for the
		 * 		type to be determined at the time of insertion.
		 * 		-allows for dynamic classes and collections during runtime
		 * -Generics aim to enforce compile time safety
		 */
		
		System.out.println("=====GENERIC LIST=====");
		List<Integer> nums = new ArrayList<>();
		nums.add(15);
		nums.add(new Integer(20));
		nums.add(5);
		nums.add(2);
		System.out.println(nums);
		
		System.out.println(nums.get(2));//retrieve specific index
		System.out.println(nums.remove(new Integer(5))); //remove an object based
		//on value; returns true or false depending on whether or not something
		//was removed
		System.out.println(nums.remove(0));//removed based on index; returns object
		//that was removed
		
		System.out.println(nums);
		
		nums.set(1, 9999); //change an existing index to a new value
		System.out.println(nums);
		
		System.out.println("========Iterating=======");
		for(Integer i : nums) {
			System.out.println(i);
		}
		
		Iterator it = nums.iterator();
		System.out.println(it.next());
		System.out.println(it.next());
//		System.out.println(it.next()); //NoSuchElementException
		
		//Iterators can only go forward, if you want to reset an iterator,
		//you need to grab a new one
		
		/*
		 * The List hierarchy provides another type of iterator. This one can go
		 * both forwards and backwards
		 */
		System.out.println("=====LIST ITERATOR====");
		ListIterator<Integer> li = nums.listIterator();
		while(li.hasNext()) {
			System.out.println(li.next());
		}
		while(li.hasPrevious()) {
			System.out.println(li.previous());
		}
		/*
	 * Core methods for ArrayLists
	 * -add
	 * -remove
	 * -get
	 * -set
	 */
		System.out.println("====SET====");
		Set<Integer> set = new HashSet<>();
		System.out.println(set.add(5));
		set.add(3);
		set.add(7);
		set.add(1);
		set.add(999999);
		set.add(345654);
		set.add(34723498);
		System.out.println(set.add(5)); //note that sets dont allow duplicates
		System.out.println(set);
		
		set.remove(7);
		System.out.println(set);
		
		//you can loop through a set with an enhanced for loop
		//note that there is a contains method for sets:
		System.out.println(set.contains(3));
		System.out.println(set.contains(6000));
		
		//core mehtods for set:
		/*
		 * -add
		 * -remove
		 * -contains
		 */
		System.out.println("=====QUEUE====");
		ArrayBlockingQueue<Integer> q = new ArrayBlockingQueue<>(4);
		q.offer(5); //offer inserts from the back of a queue
		q.offer(2);
		q.offer(7);
		q.offer(8);
		System.out.println(q);
		
		System.out.println("====Testing boundaries ====");
		System.out.println(q.offer(9));
		System.out.println(q.poll());
		System.out.println(q.poll());
//		System.out.println(q.poll());
//		System.out.println(q.poll());
//		System.out.println(q.poll());
		//poll will remove from the queue. it will also return the object
		
		System.out.println(q.peek());
		System.out.println(q.poll());
		//peek will allow you to look at the next item without removal
		
		/*
		 * Core methods:
		 * -offer/add
		 * -poll/remove
		 * -peek/element
		 * 
		 * note that the methods on the left are preferable to use
		 * because they are specific to queues
		 */
		
		System.out.println("===Maps===");
		Map<Integer, Object> map = new HashMap<>();
		map.put(1,"Camel");
		map.put(2, "Apple");
		map.put(3, "Mt. Everest");
		map.put(4, "The Road to El Dorado");
		map.put(null,null);
		System.out.println(map.size());
		System.out.println(map);
		//in maps, all of the keys are a set
		
		//iterating through a map:
		System.out.println(map.entrySet());
		for(Integer i:map.keySet()){
			System.out.println(i + "->" + map.get(i)); //the get method allows you
			//to refer to a value by its key
		}
		
		//Note that there is such another type of map called a Hashtable
		//the main difference between a Hashtable and a Hashmap is
		//1) Hashtable is considered to be a legacy class (its not quite depricated)
		//2)Hash tables cannot have null as a key
		//3)Hash tables are synchronized and hashmaps are not.
	}
}
