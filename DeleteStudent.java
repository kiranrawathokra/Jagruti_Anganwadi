//import javax.naming.directory.SearchControls;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
class DeleteStudent {
  JFrame frame = new JFrame("DeleteStudent");
  JLabel FirstNamelable, lastNameLabel,IDlable, freelbl;
  JTextField firstname, Lastname, ID;

  DeleteStudent() {
    frame.setTitle("Delete Student");
    frame.setVisible(true);
    frame.setBounds(100, 100, 600, 600);
    frame.setLayout(null);
    JButton SearchID= new JButton("SerchID");
    JButton Delete= new JButton("Delete");
    JButton Cancel=new JButton("Cancel");



    IDlable =new JLabel("ID");
    FirstNamelable = new JLabel("First Name :");
    lastNameLabel = new JLabel("Last Name :");

    // freelbl = new JLabel();
    ID =new JTextField();
    firstname = new JTextField();
    Lastname = new JTextField();

   // SearchID.setBounds(320, 50,90, 30);
    IDlable.setBounds(60, 50, 150, 30);
    SearchID.setBounds(450, 50,90, 30);
    FirstNamelable.setBounds(60, 100, 150, 30);
    lastNameLabel.setBounds(320, 100, 200, 30);
    Delete.setBounds(350, 300, 100, 30);
    Cancel.setBounds(180,300,90,30);
    
    ID.setBounds(150,50,160,30);
    firstname.setBounds(150, 100, 160, 30);
    Lastname.setBounds(400, 100, 150, 30);

    
    frame.add(IDlable);
    frame.add(ID);
    frame.add(SearchID);
    frame.add(Delete);
    frame.add(Cancel);
    frame.add(FirstNamelable);
    frame.add(firstname);
    frame.add(lastNameLabel);
    frame.add(Lastname);
   
    // frame.add(freelbl);
    frame.setLayout(null);
    Delete.addActionListener(new ActionListener() { 
        @Override   public void actionPerformed(ActionEvent e) {  
           String url = "jdbc:mysql://localhost:3306/jagruti_anganwadi";  
            String username = "root";   String password = "";  
      try {    Class.forName("com.mysql.cj.jdbc.Driver"); 
           Connection connection = DriverManager.getConnection(url, username, password);     
           Statement statement = connection.createStatement();    
           String query = "DELETE FROM student WHERE Id=?";   
            PreparedStatement preparedStatement = connection.prepareStatement(query);   
             preparedStatement.setString(1, ID.getText());
int rowsDeleted = preparedStatement.executeUpdate();    
if (rowsDeleted > 0) {     
  JOptionPane.showMessageDialog(frame, "record deleted successfully.");  
  } else
   {     JOptionPane.showMessageDialog(frame, "Error: Unable to update the record."); 
     }        preparedStatement.close(); 
        connection.close();  
       } catch (ClassNotFoundException | SQLException ex) {
        ex.printStackTrace(); 
           // Handle database errors and display an error message  
             JOptionPane.showMessageDialog(frame, "Error: Unable to update the record.");  
             }  }  });   SearchID.addActionListener(new ActionListener() {  
               @Override   public void actionPerformed(ActionEvent e) { 
                  String url = "jdbc:mysql://localhost:3306/jagruti_anganwadi";  
                   String username = "root";  
                    String password = "";   
                    try {    Class.forName("com.mysql.cj.jdbc.Driver");   
                     Connection connection = DriverManager.getConnection(url, username, password);  
                        String query = "SELECT * FROM student WHERE Id=?";   
                         PreparedStatement preparedStatement = connection.prepareStatement(query); 
                            preparedStatement.setString(1, ID.getText());    
                             ResultSet resultSet = preparedStatement.executeQuery();     
                             if (resultSet.next()) {     
                              firstname.setText(resultSet.getString("FirstName"));     
                              Lastname.setText(resultSet.getString("LastName"));   
                             } else 
                             {     
                              JOptionPane.showMessageDialog(frame, "record not found.");  
                              }     
                              resultSet.close();    
                              preparedStatement.close();    
                              connection.close();   
                            } catch (ClassNotFoundException | SQLException ex) {   
                               ex.printStackTrace();    
                              JOptionPane.showMessageDialog(frame, "Error: Unable to search for the record."); 
                              } }  
                            }); 
                             } 
                            }

  //}

//public static void main(String[] args) {
  
//}
//}
