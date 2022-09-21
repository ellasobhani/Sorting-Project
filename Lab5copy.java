//I am the sole author of the work in this repository.

import structure5.*;
import java.util.Scanner;
import java.util.Comparator;
public class Lab5copy {

  /**
  * Takes a scanner object and returns a vector of students.
  * @param sc a scanner object
  * @return a vector of students
  * @pre must take a scanner object
  * @post returns a vector with student objects in it
  */
  public static MyVector<Student> storeText(Scanner sc) {
    //construct an empty vector vec
    MyVector<Student> vec = new MyVector<Student>();
    //read and store text from text file inputted by user in the command line
    while (sc.hasNextLine()) {
      String name = sc.nextLine();
      String address = sc.nextLine();
      long campNum = sc.nextLong();
      int boxNum = sc.nextInt();
      long cellNum = sc.nextLong();
      //move to the next line and skip the --------- line
      sc.nextLine();
      sc.nextLine();

      //add a student object to the vector
      vec.add(new Student(name, address, boxNum, campNum, cellNum));
    }
    return vec;
  }



  /**
  * Takes a vector of students and returns a vector of associations between addresses (Strings) and vectors of students
  * storing each address a student lives at along with a vector of all the students who live at this address
  * @param vec a vector of student objects
  * @return vector of associations between addresses (Strings) and vectors of students living at address
  * @pre must take a vector of students
  * @post returns a vector of associations between addresses (Strings) and vectors of students
  */
  public static MyVector<Association<String, MyVector<Student>>> fillAdVec(MyVector<Student> vec) {
    //construct new vector of associations between area codes (string) and vectors of students
    MyVector<Association<String, MyVector<Student>>> rooms = new MyVector<Association<String, MyVector<Student>>>();

    //step through vector of students
    for (int i = 0; i < vec.size(); i++) {
      Student student = vec.get(i);
      String address = student.getAddress();
      //create new null association between address and vector of students
      Association<String, MyVector<Student>> room = null;
      //step through vector of associations
      for (int j = 0; j < rooms.size(); j++) {
        //if address exists in the vector of associations already
        if (address.equals(rooms.get(j).getKey())) {
          //set null association equal to existing association found in vector of associations
          room = rooms.get(j);
        }
      }
      //if the association is still null (so not found in vector of associations)
      if (room == null) {
        //create an empty vector of ints
        MyVector<Student> temp = new MyVector<Student>();
        //set null association to an association btwn address and temp vector of students
        room = new Association<String, MyVector<Student>>(address, temp);
        //add student to vector in assoc
        room.getValue().add(student);
        //add assoc to vector of assoc
        rooms.add(room);
      } else {
        //if not null add student to assoc in vec of assoc
        room.getValue().add(student);
      }
    }
    return rooms;
  }

  /**
  * Takes a vector of students and returns a vector of associations between addresses (Strings) and vectors of students
  * storing each address a student lives at along with a vector of all the students who live at this address
  * @param vec a vector of student objects
  * @return vector of associations between addresses (Strings) and vectors of students living at address
  * @pre must take a vector of students
  * @post returns a vector of associations between addresses (Strings) and vectors of students
  */
  public static MyVector<Association<String, MyVector<Integer>>> fillAcVec(MyVector<Student> vec) {
    //construct new vector of associations between area codes (string) and vectors of integers
    MyVector<Association<String, MyVector<Integer>>> areaCodeFreq = new MyVector<Association<String, MyVector<Integer>>>();

    //step through vector of students
    for (int i = 0; i < vec.size(); i++) {
      Student student = vec.get(i);
      String cellNum = String.valueOf(student.getCellNumber());
      // if student does not have a valid cell number on record, continue onto next student
      if (cellNum.length() < 10) {
        continue;
      }

      //take substring of cell num to get area code
      String areaCode = cellNum.substring(0, 3);
      //create new null association between area code and vector of ints
      Association<String, MyVector<Integer>> aC = null;
      //step through vector of associations
      for (int j = 0; j < areaCodeFreq.size(); j++) {
        //if area code exists in the vector of associations already
        if (areaCode.equals(areaCodeFreq.get(j).getKey())) {
          //set null association equal to existing association found in vector of associations
          aC = areaCodeFreq.get(j);
        }
      }
      //if the association is still null (so not found in vector of associations)
      if (aC == null) {
        //create an empty vector of ints
        MyVector<Integer> temp = new MyVector<Integer>();
        //set null association to an association btwn area code and temp vector of ints
        aC = new Association<String, MyVector<Integer>>(areaCode, temp);
        //add 1 to vector within association
        aC.getValue().add(1);
        ///add association to vector of associations
        areaCodeFreq.add(aC);
      } else {
        ///add association to vector of associations if aC was not null
        aC.getValue().add(1);
      }
    }
    return areaCodeFreq;
  }

    /**
    * A series of calls to answer questions using comparators
    * @param an array of Strings
    * @return Strings that answer questions
    * @pre takes a String, can be empty
    * @post prints outputs to several 5 questions about textfile inputted through command line
    */
  public static void main(String[] args) {
    //Create scanner object sc
    Scanner sc = new Scanner(System.in);
    //Create vector of students vec
    MyVector<Student> vec = storeText(sc);

    //Question 1
    //Create new String Comparator obj stringComp
    StringComparator stringComp = new StringComparator();
    //call insertionSort on vec, passing in stringComp
    // System.out.println(vec);
    vec.insertionSort(stringComp);
    // System.out.println(vec);
    //print first element of sorted vec
    System.out.println("First student in phonebook: " + vec.firstElement().getName());

    //Question 2
    //Create new SUBoxComparator obj boxComp
		SUBoxComparator boxComp = new SUBoxComparator();
    //call insertionSort on vec, passing in boxComp
    vec.insertionSort(boxComp);
    // System.out.println(vec);
    //print first element of sorted vec for student with largest SU box num and last element for student with smallest SU box num
    System.out.println("Student with largest SU Box Number: " + vec.lastElement().getName());
    System.out.println("Student with smallest SU Box Number: " + vec.firstElement().getName());

    //Question 3
    //Create new VowelCountComparator obj vowelComp
    VowelCountComparator vowelComp = new VowelCountComparator();
    //call insertionSort on vec, passing in vowelComp
    vec.insertionSort(vowelComp);
    //print first element of sorted vec
    System.out.println("Student with the most vowels in their full name: " + vec.lastElement().getName());

    //Question 4
    //Create new AddressFrequencyComparator obj adFreqComp
    AddressFrequencyComparator adFreqComp = new AddressFrequencyComparator();
    //build empty vec of associations and fill it with fillAdVec method, passing in vec
    MyVector<Association<String, MyVector<Student>>> adVec = fillAdVec(vec);
    //call insertionSort on vec, passing in adFreqComp
    adVec.insertionSort(adFreqComp);
    //print first association's key (first address) in vec of associations and its corresponding vector of students living at first address
    System.out.println("Most common address: " + adVec.get(adVec.size() - 2).getKey());
    System.out.println("Students living at the most common address: ");
    //step through vector of associations and print students from association with most frequent address
    for (int i = 0; i < adVec.get(adVec.size() - 2).getValue().size(); i++) {
      Student stud = adVec.get(adVec.size() - 2).getValue().get(i);
      System.out.println(stud.getName() + " ");
    }

    //Question 5
    //Create new AreaCodeFrequencyComparator obj acComp
    AreaCodeFrequencyComparator acComp = new AreaCodeFrequencyComparator();
    //build empty vec of associations and fill it with fillAdVec method, passing in vec
    MyVector<Association<String, MyVector<Integer>>> acVec = fillAcVec(vec);
    //call insertionSort on acVec, passing in adFreqComp
    acVec.insertionSort(acComp);

    System.out.println("Most common area codes: ");
    for (int i = acVec.size() - 1; i > acVec.size() - 11; i--) {
      System.out.println(acVec.get(i).getKey() + ": " + acVec.get(i).getValue().size());
    }
	}

}
