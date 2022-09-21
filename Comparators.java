//I am the sole author of the work in this repository.

import structure5.*;
import java.util.Comparator;

class StringComparator implements Comparator<Student> {
  /**
  * Compares two strings based on alphabetic order.
  * @param s1 student object
  * @param s2 student object
  * @return an int eithe 1, -1, or 0
  * @pre must take student objects as s1 and s2
  * @post returns an integer indicating whether s1 is bigger or smaller than s2
  */
  public int compare(Student s1, Student s2) {
    if (s1.getName().compareTo(s2.getName()) > 0) {
      return 1;
    }
    if (s1.getName().compareTo(s2.getName()) < 0) {
      return -1;
    }
    return 0;
  }
}


class SUBoxComparator implements Comparator<Student> {
  /**
  * Compares two student SU box numbers.
  * @param s1 student object
  * @param s2 student object
  * @return an int eithe 1, -1, or 0
  * @pre must take student objects as s1 and s2
  * @post returns an integer indicating whether s1's box number  is bigger or smaller than s2's box num
  */
  public int compare(Student s1, Student s2) {
    if (s1.getSUBoxNumber() > s2.getSUBoxNumber()) {
      return 1;
    }
    if (s1.getSUBoxNumber() < s2.getSUBoxNumber()) {
      return -1;
    }
    return 0;
  }
}

class VowelCountComparator implements Comparator<Student> {
  /**
  * Counts the vowels in a student's name
  * @param s1 student object
  * @return an int storing the count of vowels in the s1's name
  * @pre must take student object as s1
  * @post returns an integer representing the number of vowels in s1's name
  */
  public int countVowels(Student s1) {
    int count = 0;
    for (int i = 0; i < s1.getName().length(); i++) {
      char c = s1.getName().charAt(i);
      String s = Character.toString(c);
      if (s.equals("a") || s.equals("e") || s.equals("i") || s.equals("o") || s.equals("u")) {
        count++;
      }
    }
    return count;
  }

  /**
  * Compares two students based on the number of vowels in their names.
  * @param s1 student object
  * @param s2 student object
  * @return an int eithe 1, -1, or 0
  * @pre must take student objects as s1 and s2
  * @post returns an integer indicating whether s1 has a bigger or smaller vowel count than s2
  */
  public int compare(Student s1, Student s2) {
    if (countVowels(s1) > countVowels(s2)) {
      return 1;
    }
    if (countVowels(s1) < countVowels(s2)) {
      return -1;
    }
    return 0;
  }
}

class AddressFrequencyComparator implements Comparator<Association<String, MyVector<Student>>> {
  /**
  * Compares two associations of Strings and vectors of Strings based on the size of their value vectors of students.
  * @param a1 association of strings and vectors of student objects
  * @param a2 association of strings and vectors of student objects
  * @return an int, the difference of the sizes of values (vectors of students) of the two associations
  * @pre must two associations storing strings and vectors of student objects
  * @post returns an integer (can be neg) indicating whether the size of a1's value is bigger or smaller than a2's value
  */
  public int compare(Association<String, MyVector<Student>> a1, Association<String, MyVector<Student>> a2) {
    return a1.getValue().size() - a2.getValue().size();
  }
}


/**
* Compares two associations of Strings and vectors of ints based on the size of their value vectors of ints.
* @param a1 association of strings and vectors of ints
* @param a2 association of strings and vectors of ints
* @return an int, the difference of the sizes of values (vectors of ints) of the two associations
* @pre must two associations storing strings and vectors of ints
* @post returns an integer (can be neg) indicating whether the size of a1's value is bigger or smaller than a2's value
*/
class AreaCodeFrequencyComparator implements Comparator<Association<String, MyVector<Integer>>> {
  public int compare(Association<String, MyVector<Integer>> a1, Association<String, MyVector<Integer>> a2) {
    return a1.getValue().size() - a2.getValue().size();
  }

}
