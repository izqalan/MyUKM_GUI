/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dev.izqalan.myukm.models;

/*
 * @author Lam Wei Long
 */
public class LibraryModel {
    
    String id;
    String name;
    String ISBN;
    String author;
    String availability;
    
    public String[][] seed() {
        String[][] data = {
            {"1","Code: The Hidden Language of Computer Hardware and Software 1st Edition","978-0735611313","Charles Petzold","Yes"},
            {"2","Introduction to Algorithms Fourth Edition","9780262046305","Thomas H. Cormen","Yes"},
            {"3","Clean Code: A Handbook of Agile Software Craftsmanship","978-3-16-148410-0","Robert C. Martin","Yes"},
            {"4","Code Complete: A Practical Handbook of Software Construction, Second Edition","978-0735619678","Steve McConnnell","Yes"},
            {"5","Structure and Interpretation of Computer Programs","90-262-51087-1","Harold Abelson","No"},
            {"6","Designing Data-Intensive Applications: The Big Ideas Behind Reliable, Scalable, and Maintainable Systems","978-1449373320","Martin Kleppmann","Yes"},
            {"7","The Pragmatic Programmer, 20th Anniversary Edition","9780135957059","David Thomas","No"},
            {"8","Python Crash Course, 2nd Edition: A Hands-On, Project-Based Introduction to Programming 2nd Edition","978-1593279288","Eric Matthes","Yes"},
            {"9","Algorithms to Live By: The Computer Science of Human Decisions","9781627790369","Brian Christian","Yes"},
            {"10","Grokking Algorithms: An Illustrated Guide for Programmers and Other Curious People 1st Edition","978-1617292231","Aditya Bhargava","Yes"},
            {"11","Superintelligence: Paths, Dangers, Strategies","978-0199678112","Nick Bostrom","No"},
            {"12","Hands-On Machine Learning with Scikit-Learn, Keras, and TensorFlow,2nd Edition","9781492032649","Aurelien Geron","No"}
        };
        return data;
    }
    
    // Data to be displayed in the JTable,simulating the database
	public String[] data= {"1","Code: The Hidden Language of Computer Hardware and Software 1st Edition","978-0735611313","Charles Petzold","Yes"};
	public String[] data2= {"2","Introduction to Algorithms Fourth Edition","9780262046305","Thomas H. Cormen","Yes"};
	public String[] data3= {"3","Clean Code: A Handbook of Agile Software Craftsmanship","978-3-16-148410-0","Robert C. Martin","Yes"};
	public String[] data4= {"4","Code Complete: A Practical Handbook of Software Construction, Second Edition","978-0735619678","Steve McConnnell","Yes"};
	public String[] data5= {"5","Structure and Interpretation of Computer Programs","90-262-51087-1","Harold Abelson","No"};
	public String[] data6= {"6","Designing Data-Intensive Applications: The Big Ideas Behind Reliable, Scalable, and Maintainable Systems","978-1449373320","Martin Kleppmann","Yes"};
	public String[] data7= {"7","The Pragmatic Programmer, 20th Anniversary Edition","9780135957059","David Thomas","No"};
	public String[] data8= {"8","Python Crash Course, 2nd Edition: A Hands-On, Project-Based Introduction to Programming 2nd Edition","978-1593279288","Eric Matthes","Yes"};
	public String[] data9= {"9","Algorithms to Live By: The Computer Science of Human Decisions","9781627790369","Brian Christian","Yes"};
	public String[] data10= {"10","Grokking Algorithms: An Illustrated Guide for Programmers and Other Curious People 1st Edition","978-1617292231","Aditya Bhargava","Yes"};
	public String[] data11= {"11","Superintelligence: Paths, Dangers, Strategies","978-0199678112","Nick Bostrom","No"};
	public String[] data12= {"12","Hands-On Machine Learning with Scikit-Learn, Keras, and TensorFlow,2nd Edition","9781492032649","Aurelien Geron","No"};
	
	
	// Column Names
	public String[] columnNames = {"ID","Name","ISBN","Author","Availability"};
	
	public String[] ShortColumn = {"ID","Name","ISBN","Author"};    

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String isAvailability() {
        return availability;
    }

    public void setAvailability(String availability) {
        this.availability = availability;
    }

    public String[] getShortColumn() {
        return ShortColumn;
    }

    public void setShortColumn(String[] ShortColumn) {
        this.ShortColumn = ShortColumn;
    }
        
        
}
