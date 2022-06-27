package dev.izqalan.myukm.controllers;

import dev.izqalan.myukm.models.LibraryModel;
import dev.izqalan.myukm.views.MainMenu;
import java.util.ArrayList;
import javax.swing.JFrame;

public class LibraryController {

    String[] data;
    String[] Columnname;
    String query;
    String[] shortcolumn;
    String[][] booksData = {
        {"1", "Code: The Hidden Language of Computer Hardware and Software 1st Edition", "978-0735611313", "Charles Petzold", "Yes"},
        {"2", "Introduction to Algorithms Fourth Edition", "9780262046305", "Thomas H. Cormen", "Yes"},
        {"3", "Clean Code: A Handbook of Agile Software Craftsmanship", "978-3-16-148410-0", "Robert C. Martin", "Yes"},
        {"4", "Code Complete: A Practical Handbook of Software Construction, Second Edition", "978-0735619678", "Steve McConnnell", "Yes"},
        {"5", "Structure and Interpretation of Computer Programs", "90-262-51087-1", "Harold Abelson", "No"},
        {"6", "Designing Data-Intensive Applications: The Big Ideas Behind Reliable, Scalable, and Maintainable Systems", "978-1449373320", "Martin Kleppmann", "Yes"},
        {"7", "The Pragmatic Programmer, 20th Anniversary Edition", "9780135957059", "David Thomas", "No"},
        {"8", "Python Crash Course, 2nd Edition: A Hands-On, Project-Based Introduction to Programming 2nd Edition", "978-1593279288", "Eric Matthes", "Yes"},
        {"9", "Algorithms to Live By: The Computer Science of Human Decisions", "9781627790369", "Brian Christian", "Yes"},
        {"10", "Grokking Algorithms: An Illustrated Guide for Programmers and Other Curious People 1st Edition", "978-1617292231", "Aditya Bhargava", "Yes"},
        {"11", "Superintelligence: Paths, Dangers, Strategies", "978-0199678112", "Nick Bostrom", "No"},
        {"12", "Hands-On Machine Learning with Scikit-Learn, Keras, and TensorFlow,2nd Edition", "9781492032649", "Aurelien Geron", "No"}
    };

    LibraryModel LM = new LibraryModel();

    public void viewMainMenu(JFrame currentFrame, AppController app) {
        currentFrame.dispose();
        new MainMenu(app);
    }
    
    public LibraryController() {
    }

    public String[][] getBooksData() {
        return booksData;
    }

    public void setshortC() {
        shortcolumn = LM.ShortColumn;

    }

    public String[] returnshortC() {
        setshortC();
        return shortcolumn;

    }

    public void setquery(String Vquery) {
        query = Vquery;
    }

    public String getquery(String Vquery) {
        setquery(Vquery);
        return query;
    }

    void setCname() {
        Columnname = LM.columnNames;
    }

    public String[] getCname() {
        setCname();
        return Columnname;
    }
}//end of class

