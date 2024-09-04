import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.sql.*;
class addStudent {
  JFrame frame = new JFrame("AddStudent");
  JLabel FirstNamelable, lastNameLabel, Classlable, DateofBirthlable, Phonelable, freelbl;
  JTextField firstname, Lastname, Class, Dateofbirth1, Phone1;

  addStudent() {
    frame.setTitle("Add Student");
    frame.setVisible(true);
    frame.setBounds(100, 100, 600, 600);
    frame.setLayout(null);
    JButton Cancel= new JButton("Cancel");
    JButton Save= new JButton("Save");
    FirstNamelable = new JLabel("First Name :");
    lastNameLabel = new JLabel("Last Name :");
    Classlable = new JLabel("Class");
    Phonelable = new JLabel("Phone No:");
    DateofBirthlable=new JLabel("Date of Birth");
    firstname = new JTextField();
    Lastname = new JTextField();
    Class = new JTextField();
    Phone1 = new JTextField();
    Dateofbirth1=new JTextField();
    FirstNamelable.setBounds(60, 50, 150, 30);
    lastNameLabel.setBounds(320, 50, 200, 30);
    Classlable.setBounds(60, 100, 90, 30);
    Phonelable.setBounds(320, 100, 100, 30);
   DateofBirthlable.setBounds(60, 150, 90, 30);
   Save.setBounds(150, 300, 100, 30);
   Cancel.setBounds(350, 300, 100, 30);
    firstname.setBounds(150, 50, 160, 30);
    Lastname.setBounds(400, 50, 150, 30);
    Class.setBounds(150, 100, 160, 30);
    Phone1.setBounds(400, 100, 160, 30);
   Dateofbirth1.setBounds(150, 150, 160, 30);
    frame.add(FirstNamelable);
    frame.add(firstname);
    frame.add(lastNameLabel);
    frame.add(Lastname);
    frame.add(Classlable);
    frame.add(Class);
    frame.add(Phonelable);
    frame.add(Phone1);
    frame.add(DateofBirthlable);
    frame.add(Dateofbirth1);
    frame.add(Save);
    frame.add(Cancel);
    frame.setLayout(null);
  

Save.addActionListener(new ActionListener() {
   @Override
public void actionPerformed(ActionEvent e) {
       String url = "jdbc:mysql://localhost:3306/jagruti_anganwadi";
 //http://localhost/phpmyadmin/index.php?route=/database/structure&db=gyansinghrawat
String username = "root";
 String password = "";
try { 
 // Class.forName("com.mysql.cj.jdbc.Driver");
 Connection connection = DriverManager.getConnection(url, username, password);

 String sql="insert into `jagruti_anganwadi`.`student`"+"(`FirstName`,`LastName`,`phone`,`DateofBirth`,`Class`)"
 + "values('" + firstname.getText() + "','" + Lastname.getText() + "','" + Long.parseLong(Phone1.getText()) + "','" +Dateofbirth1.getText() + "','" + Class.getText() + "')";
 
 Statement statement = connection.createStatement();
 int rowsinsert = statement.executeUpdate(sql);//"' ,F_Name='"+fname_t.getText()
 if (rowsinsert > 0) {
  System.out.println("All fields were insert successfully!");
 JOptionPane.showMessageDialog(frame,"Insert Student successful");
 frame.dispose();

 }
 } catch (Exception Student) {
System.out.print(Student);

 }
 }
}); 

Cancel.addActionListener(event->{
 frame.dispose();
});
}
public static void main(String[] args) {
  
}
}
