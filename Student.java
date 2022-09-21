//I am the sole author of the work in this repository.
import structure5.*;

//class for student object
public class Student {
  private String name;
  private String address;
  private int sUBoxNumber;
	private long campusNumber;
	private long cellNumber;

  /**
  * Takes a student name (String), student address (String), SUbox num (int), campus and cell nums (longs) and returns student object
  * @param theName a nonempty string
  * @param theAddress a nonempty string
  * @param theSUBoxNumber as a non-negative integer
  * @param theCampusNumber as a non-negative long
  * @param theCellNumber as a non-negative long
  * @return student object
  * @pre must take nonnegative ints/longs and nonempty strings
  * @post returns a student object
  */
  public Student(String theName, String theAddress, int theSUBoxNumber, long theCampusNumber, long theCellNumber) {
    name = theName;
    address = theAddress;
    sUBoxNumber = theSUBoxNumber;
		campusNumber = theCampusNumber;
		cellNumber = theCellNumber;
  }

  /**
   * This method retrieve's the student object's name.
   */
  public String getName() {
    return name;
  }

  /**
   * This method retrieve's the student object's campus address.
   */
  public String getAddress() {
    return address;
  }

  /**
   * This method retrieve's the student object's SU box number.
   */
  public int getSUBoxNumber() {
    return sUBoxNumber;
  }

  /**
   * This method retrieve's the student object's campus number.
   */
	public long getCampusNumber() {
		return campusNumber;
	}

  /**
   * This method retrieve's the student object's cell number.
   */
	public long getCellNumber() {
		return cellNumber;
	}

}
