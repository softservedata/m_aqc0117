package com.softserve.edu;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ApplJDBC {
	private static Connection con = null;
	//private static String username = "ssu-oms";
	//private static String password = "ssu-oms";
	//private static String username = "mqcaqc";
	//private static String password = "mqcaqc";
	private static String username = "root";
	 private static String password = "root";
	// Microsoft
	//private static String URL = "jdbc:sqlserver://CLASS86.training.local\\SQLEXPRESS2;databasename=mqcaqc16;";
	// private static String URL =
	// "jdbc:sqlserver://CLASS02.training.local\\SQLEXPRESS;databasename=Lv169OMS;";
	//private static String URL =	"jdbc:sqlserver://ssu-sql12\\tc;databasename=ssu-oms;";
	//private static String URL =	"jdbc:jtds:sqlserver://ssu-sql12/ssu-oms;instance=tc;";
	// Sybase
	//private static String URL = "jdbc:jtds:sqlserver://CLASS86/mqcaqc16;instance=SQLEXPRESS2;";  // Port 1433
	// private static String URL =
	// "jdbc:jtds:sqlserver://ssu-sql12/ssu-oms;instance=tc;";
	// private static String URL =
	// "jdbc:jtds:sqlserver://CLASS02/Lv169OMS;instance=SQLEXPRESS;";
	// MySQL
	// private static String URL =
	// "jdbc:mysql://localhost:3306/measurement_devices";
	// private static String URL = "jdbc:mysql://localhost:3306/registrator_db";
	// private static String URL = "jdbc:mysql://localhost:3306/mqcaqc16";
	//private static String URL = "jdbc:mysql://localhost:1100/emp";
	//private static String URL = "jdbc:mysql://127.0.0.1:1100/emp";
	private static String URL = "jdbc:mysql://127.0.0.1:1100/users";

	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		System.out.println("Start...");
		//DriverManager.registerDriver(new com.microsoft.sqlserver.jdbc.SQLServerDriver());
		//DriverManager.registerDriver(new net.sourceforge.jtds.jdbc.Driver());
		//
		// DriverManager.registerDriver(new net.sourceforge.jtds.jdbc.Driver());
		// Class.forName("net.sourceforge.jtds.jdbc.Driver");
		//
		DriverManager.registerDriver(new com.mysql.jdbc.Driver());
		// Class.forName("com.mysql.jdbc.Driver");
		// Load the driver
		con = DriverManager.getConnection(URL, username, password);
		if (con != null) {
			System.out.println("Connection Successful! \n");
		} else {
			System.exit(0);
		}
		Statement st = con.createStatement();
		// Statement allows you to send inquiries database
		// ResultSet rs = st.executeQuery("select * from TUser");
		//ResultSet rs = st.executeQuery("select * from Users");
		// ResultSet rs = st.executeQuery("SELECT ID, Login, Password,
		// FirstName, LastName, Email, RegionRef, RoleRef FROM dbo.Users WHERE
		// Login = 'aaai';");
		// ResultSet rs = st.executeQuery("SELECT * FROM dbo.Users;");
		//
		// st.execute("INSERT INTO dbo.Users (Login, Password, FirstName,
		// LastName, Email, RegionRef, RoleRef, IsUserActive) VALUES ('iva123',
		// 'qwerty', 'ivanka', 'horoshko', 'mail@gmail.com', '1', '1', '1');");
		// ResultSet rs = st.executeQuery("SELECT * FROM users WHERE
		// Login='iva';");
		// ResultSet rs = st.executeQuery("SELECT * FROM Users;");
		// ResultSet rs = st.executeQuery("SELECT * FROM Users WHERE Login LIKE
		// 'iv%';");
		// MySQL
		// ResultSet rs = st.executeQuery("SELECT * FROM User;");
		// st.execute("INSERT INTO user
		// (username,isAvailable,password,firstName,lastName,organizationId)
		// VALUES
		// ('verificator-lv2',1,'$2a$10$59Mv7tEUrVH8iBeDsm9y7.zUcJoPHnnyOvMnC4zKRV8.wlnugQ2G2','first-lv2','last-lv2',7);");
		// st.execute("INSERT INTO user_role (username,value) VALUES
		// ('verificator-lv2','STATE_VERIFICATOR_ADMIN');");
		// st.execute("INSERT INTO users (name,age) VALUES ('stepan',123);");
		//
		// ResultSet rs = st.executeQuery("SELECT * FROM User WHERE username
		// LIKE 'verifi%';");
		// ResultSet gets the result table
		//
		// st.execute("INSERT INTO TUser (name,age) VALUES ('Taras','22');");
		// ResultSet rs = st.executeQuery("select * from TUser");
		//// st.execute("INSERT INTO Empl (name,email) VALUES
		// ('Tolik','tol@yahhoo.com');");
		//// st.execute("INSERT INTO Empl (name,email) VALUES
		// ('Taras','tar@mail.com');");
		// st.execute("DELETE Empl WHERE name='Tolik';");
		//// st.execute("UPDATE Empl SET name='SuperTaras' WHERE name LIKE
		// 'Tar%';");
		// st.execute("UPDATE Empl SET email='a@google.com' WHERE firstname LIKE 'registrator%';");
		//st.execute("INSERT INTO Users (userName) VALUES ('TOLIK');");
		//st.execute("DELETE FROM Users WHERE userName='Tolik';");
		//ResultSet rs = st.executeQuery("select * from Users;");
		//st.execute("DELETE FROM Empl WHERE firstname='Ivan11';");
		//
		//st.execute("CREATE TABLE empl (id INT PRIMARY KEY IDENTITY(1,1), firstname nvarchar(10), email nvarchar(10));");
		//st.execute("INSERT INTO empl (firstname, email) VALUES ('Ivan11', 'ivan11@i.ua');");
		//st.execute("INSERT INTO employee_data (name) VALUES ('Taras');");
		//st.execute("INSERT INTO empl (firstname, email) VALUES ('Petro', 'petro@i.ua');");
		//st.execute("ALTER TABLE empl ALTER COLUMN firstname nvarchar(50);");
		//st.execute("ALTER TABLE empl ALTER COLUMN email nvarchar(50);");
		//
		//ResultSet rs = st.executeQuery("select * from empl;");
		//ResultSet rs = st.executeQuery("select * from employee_data;");
		ResultSet rs = st.executeQuery("select * from newusers;");
		//
		int columnCount = rs.getMetaData().getColumnCount();
		// Resultset.getMetaData () get the information
		// output file
		while (rs.next()) {
			for (int i = 1; i <= columnCount; i++) {
				System.out.print(rs.getString(i) + "\t");
			}
			System.out.println();
		}
		System.out.println();
		if (rs != null) {
			rs.close();
		}
		if (st != null) {
			st.close();
		}
		if (con != null) {
			con.close();
		}
	}
}
