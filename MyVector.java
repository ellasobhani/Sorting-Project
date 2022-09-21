//I am the sole author of the work in this repository.

import structure5.*;
import java.util.Comparator;

public class MyVector<E> extends Vector<E> {

  /** Construct an empty vector */
  public MyVector() {
    super();
  }

  /**
  * Takes in a comparator and sorts according to comparator
  * @param comp a comparator of generic type
  * @return nothing but vector it is called on is sorted
  * @pre must be of type comparator
  * @post returns nothing
  */
  public void insertionSort(Comparator<E> comp) {
    int numSorted = 1; // number of values in place
    while (numSorted < size()) {
      E temp = get(numSorted); // first unsorted value
      int index = numSorted;
      //while(index > 0 && temp < data[index - 1]) {
      while (index > 0 && comp.compare(temp, get(index - 1)) < 0) {
        set(index, get(index - 1));
        index--;
      }
      set(index, temp);
      numSorted++;
    }
  }

//simple method to test insertionSort capabilities
  // public static void main(String[] args) {
  //   MyVector<Integer> vec = new MyVector<Integer>();
  //   for (int i = 0; i < 10; i++) {
  //     vec.addFirst(i);
  //   }
  //   System.out.println(vec);
  //   vec.insertionSort((x, y) -> x - y);
  //   System.out.println(vec);
  // }
}
