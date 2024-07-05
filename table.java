import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.*;

		public class table {

		    public static void main(String[] args) {
		        String imagePath = "C:\\Users\\Admin\\OneDrive\\Desktop\\Visual Studio\\html\\Mini project\\Images\\images1.jpeg.jpg";
		        uploadImage(imagePath);
		        String imagePath1 = "C:\\Users\\Admin\\OneDrive\\Desktop\\Visual Studio\\html\\Mini project\\Images\\images2.jpeg.jpg";
		        uploadImage(imagePath1);
		        String imagePath2 = "C:\\Users\\Admin\\OneDrive\\Desktop\\Visual Studio\\html\\Mini project\\Images\\images7.jpg";
		        uploadImage(imagePath2);
		        String imagePath3 = "C:\\Users\\Admin\\OneDrive\\Desktop\\Visual Studio\\html\\Mini project\\Images\\images4.jpg";
		        uploadImage(imagePath3);
		        String imagePath4 = "C:\\Users\\Admin\\OneDrive\\Desktop\\Visual Studio\\html\\Mini project\\Images\\images5.jpeg.jpg";
		        uploadImage(imagePath4);
		        String imagePath5 = "C:\\Users\\Admin\\OneDrive\\Desktop\\Visual Studio\\html\\Mini project\\Images\\images6.jpeg.jpg";
		        uploadImage(imagePath5);
		        String imagePath6 = "C:\\Users\\Admin\\OneDrive\\Desktop\\Visual Studio\\html\\Mini project\\Images\\images3.jpeg.jpg";
		        uploadImage(imagePath6);
		        String imagePath7 = "C:\\Users\\Admin\\OneDrive\\Desktop\\Visual Studio\\html\\Mini project\\Images\\images8.jpg";
		        uploadImage(imagePath7);
		        String imagePath8= "C:\\Users\\Admin\\OneDrive\\Desktop\\Visual Studio\\html\\Mini project\\Images\\Event11.webp";
		        uploadImage(imagePath8);
		        
		    }

		    public static void uploadImage(String imagePath) {
		        String jdbcUrl = "jdbc:mysql://localhost:3306/practice";
		        String username = "root";
		        String password = "root";

		        try
		        {
		            Connection con = DriverManager.getConnection(jdbcUrl, username, password);
		            PreparedStatement ps = con.prepareStatement("INSERT INTO image(name, image) VALUES (?, ?)");
		            FileInputStream fin = new FileInputStream(imagePath);
		            File imageFile = new File(imagePath);
		            ps.setString(1, imageFile.getName());
		            ps.setBinaryStream(2, fin, (int) imageFile.length());

		            int rowsAffected = ps.executeUpdate();
		            System.out.println(rowsAffected + " Row(s) affected");
		        } catch (SQLException | IOException e) {
		            e.printStackTrace();
		        }
		    }


	}