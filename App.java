import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.SwingUtilities;

class App{
    public static void main(String[] args) {
      JFrame frame = new JFrame("Anganwadi Menagment");
      frame.setVisible(true);
      frame.setBounds(500, 100, 700, 600);
      
      JMenuBar Anganwadi = new JMenuBar();
     JMenu Student=new JMenu("Student");
      JMenuItem Add=new JMenuItem("Add");
      JMenuItem Update=new JMenuItem("Update");
      JMenuItem Delete=new JMenuItem("Delete");
      JMenuItem Veiw=new JMenuItem("View");
      Student.add(Add);
      Student.add(Update);
      Student.add(Delete);
      Student.add(Veiw);

      Anganwadi.add(Student);
      frame.setJMenuBar(Anganwadi);

      JMenu Teacher=new JMenu("Teacher");
      JMenuItem Addteacher=new JMenuItem("Add");
      JMenuItem Updateteaher=new JMenuItem("Update");
      JMenuItem Deleteteacher=new JMenuItem("Delete");
      JMenuItem Veiwteacher=new JMenuItem("View");
      Teacher.add(Addteacher);
      Teacher.add(Updateteaher);
      Teacher.add(Deleteteacher);
      Teacher.add(Veiwteacher);

      Anganwadi.add(Teacher);


       JMenu Attandance=new JMenu("Attandance");
      JMenuItem MarkAttandance=new JMenuItem("MarkAttandance");
      JMenuItem showAttandance=new JMenuItem("showAttandance");
     
      Attandance.add(MarkAttandance);
      Attandance.add(showAttandance);
     
      Anganwadi.add(Attandance);

    Add.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e)
      {
        new addStudent();
      }
    });
     Delete.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e)
      {
        new DeleteStudent();
      }
    });

    Update.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e)
      {
        new studentUpdate();
      }
    });
   Addteacher.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent ob)
      {
        new AddTeacher();
      }
    });

    Updateteaher.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent ob)
      {
        new updateTeacher();
      }
    });
   Deleteteacher.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent ob)
      {
        new DeleteTeacher();
      }
    });
    
     MarkAttandance.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent ob)
      {
        new MarkAttendance();
      }
    }); 
    
  


    Veiw.addActionListener(new ActionListener() {
    @Override
    
    public void actionPerformed(ActionEvent eg) {
        String url = "jdbc:mysql://localhost:3306/jagruti_anganwadi";
        String username = "root"; 
       String passwords="";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(url,username,passwords);
            String query = "SELECT * FROM student";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            
            DefaultTableModel tableModel = new DefaultTableModel();
            tableModel.addColumn("First Name");
            tableModel.addColumn("Last Name");
            tableModel.addColumn("Phone");
            tableModel.addColumn("Class");
            tableModel.addColumn("Date Of Birth");
            
            while (resultSet.next())
             {
                String l1 = resultSet.getString("Firstname");
                String l2 = resultSet.getString("Lastname");
                String l3 = resultSet.getString("Phone");
                String l4 = resultSet.getString("Class");
                String l5 = resultSet.getString("Dateofbirth");
                
                tableModel.addRow(new Object[]{l1, l2, l3, l4, l5});
            }
            
            JTable readerTable = new JTable(tableModel);
            JScrollPane scrollPane = new JScrollPane(readerTable);
            
            SwingUtilities.invokeLater(() -> {
                frame.getContentPane().removeAll();
                frame.getContentPane().add(scrollPane);
                frame.revalidate();
            });
            
            resultSet.close();
            preparedStatement.close();
            connection.close();
        } catch (ClassNotFoundException | SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(frame, "Error: Unable to retrieve reader information.");
        }
    }
});

/******************************* */
 Veiwteacher.addActionListener(new ActionListener() {
    @Override
    
    public void actionPerformed(ActionEvent eg) {
        String url = "jdbc:mysql://localhost:3306/jagruti_anganwadi";
        String username = "root"; 
       String passwords="";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(url,username,passwords);
            String query = "SELECT * FROM teacher";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            
            DefaultTableModel tableModel = new DefaultTableModel();
            tableModel.addColumn("First Name");
            tableModel.addColumn("Last Name");
            tableModel.addColumn("Phone");
            tableModel.addColumn("Subject");
            tableModel.addColumn("E_mail");
            
            while (resultSet.next())
             {
                String l1 = resultSet.getString("Firstname");
                String l2 = resultSet.getString("Lastname");
                String l3 = resultSet.getString("Phone");
                String l4 = resultSet.getString("Subject");
                String l5 = resultSet.getString("E-mail");
                
                tableModel.addRow(new Object[]{l1, l2, l3, l4, l5});
            }
            
            JTable readerTable = new JTable(tableModel);
            JScrollPane scrollPane = new JScrollPane(readerTable);
            
            SwingUtilities.invokeLater(() -> {
                frame.getContentPane().removeAll();
                frame.getContentPane().add(scrollPane);
                frame.revalidate();
            });
            
            resultSet.close();
            preparedStatement.close();
            connection.close();
        } catch (ClassNotFoundException | SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(frame, "Error: Unable to retrieve reader information.");
        }
    }
});

/**********9999999999999999999999999999*******/
showAttandance.addActionListener(new ActionListener() {
    @Override
    
    public void actionPerformed(ActionEvent eg) {
        String url = "jdbc:mysql://localhost:3306/jagruti_anganwadi";
        String username = "root"; 
       String passwords="";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(url,username,passwords);
            String query = "SELECT * FROM attendance";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            
            DefaultTableModel tableModel = new DefaultTableModel();
            tableModel.addColumn("First Name");
            tableModel.addColumn("Last Name");
            tableModel.addColumn("Date");
            tableModel.addColumn("MarkAttenance");
            
            while (resultSet.next())
             {
                String l1 = resultSet.getString("Firstname");
                String l2 = resultSet.getString("Lastname");
                String l3 = resultSet.getString("Date");
                String l4 = resultSet.getString("MarkAttenance");
                
                tableModel.addRow(new Object[]{l1, l2, l3, l4});
            }
            
            JTable readerTable = new JTable(tableModel);
            JScrollPane scrollPane = new JScrollPane(readerTable);
            
            SwingUtilities.invokeLater(() -> {
                frame.getContentPane().removeAll();
                frame.getContentPane().add(scrollPane);
                frame.revalidate();
            });
            
            resultSet.close();
            preparedStatement.close();
            connection.close();
        } catch (ClassNotFoundException | SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(frame, "Error: Unable to retrieve reader information.");
        }
    }
}); 


}
}


   
          
        
      
          
    

  
