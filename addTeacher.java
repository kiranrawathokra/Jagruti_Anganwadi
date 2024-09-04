import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.sql.*;
class AddTeacher {
  JFrame frame = new JFrame("AddTeacher");
  JLabel FirstNamelable, lastNameLabel, subjectlable, e_maillable, Phonelable, freelbl;
  JTextField firstname, Lastname, subject, e_mail, Phone1;

  AddTeacher() {
    frame.setTitle("AddTeacher");
    frame.setVisible(true);
    frame.setBounds(100, 100, 600, 600);
    frame.setLayout(null);
    JButton Cancel= new JButton("Cancel");
    JButton Save= new JButton("Save");
    FirstNamelable = new JLabel("First Name :");
    lastNameLabel = new JLabel("Last Name :");
    subjectlable = new JLabel("Subject");
    Phonelable = new JLabel("Phone No:");
    e_maillable=new JLabel("E-mail");
    firstname = new JTextField();
    Lastname = new JTextField();
    subject = new JTextField();
    Phone1 = new JTextField();
    e_mail=new JTextField();
    FirstNamelable.setBounds(60, 50, 150, 30);
    lastNameLabel.setBounds(320, 50, 200, 30);
    subjectlable.setBounds(60, 100, 90, 30);
    Phonelable.setBounds(320, 100, 100, 30);
   e_maillable.setBounds(60, 150, 90, 30);
   Save.setBounds(150, 300, 100, 30);
   Cancel.setBounds(350, 300, 100, 30);
    firstname.setBounds(150, 50, 160, 30);
    Lastname.setBounds(400, 50, 150, 30);
    subject.setBounds(150, 100, 160, 30);
    Phone1.setBounds(400, 100, 160, 30);
   e_mail.setBounds(150, 150, 160, 30);
    frame.add(FirstNamelable);
    frame.add(firstname);
    frame.add(lastNameLabel);
    frame.add(Lastname);
    frame.add(subjectlable);
    frame.add(subject);
    frame.add(Phonelable);
    frame.add(Phone1);
    frame.add(e_maillable);
    frame.add(e_mail);
    frame.add(Save);
    frame.add(Cancel);
    frame.setLayout(null);
  

Save.addActionListener(new ActionListener() {
   @Override
public void actionPerformed(ActionEvent e) {
       String url = "jdbc:mysql://localhost:3306/jagruti_anganwadi";
 
String username = "root";
 String password = "";
try { 
 // Class.forName("com.mysql.cj.jdbc.Driver");
 Connection connection = DriverManager.getConnection(url, username, password);

 String sql="insert into `jagruti_anganwadi`.`teacher`"+"(`FirstName`,`LastName`,`Phone`,`E-mail`,`Subject`)"
 + "values('" + firstname.getText() + "','" + Lastname.getText() + "','" + Long.parseLong(Phone1.getText()) + "','" +e_mail.getText() + "','" + subject.getText() + "')";
 
 Statement statement = connection.createStatement();
 int rowsinsert = statement.executeUpdate(sql);
 //"' ,F_Name='"+fname_t.getText()
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
