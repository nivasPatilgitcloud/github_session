package githubdemo.dbtables;

import java.sql.Connection;
import java.sql.Statement;

import githubdemo.globalconnection.GlobalConnection;

public class PersonVotingDetailsTb {
	public static void personVotingReg() {
		Connection con = null;

		try {
			con=GlobalConnection.getConnection();
			String query = "create table personvotingreg(pid int NOT NULL AUTO_INCREMENT, pname varchar(255), page int, PRIMARY KEY(id))";
			Statement statement = con.createStatement();
			statement.executeUpdate(query);
			System.out.println("Table created successfully");

		} catch (Exception e) {
			System.out.println("Exception occured while creating table of method personVotingReg()");
			e.printStackTrace();
		} finally {
			if (con != null) {
				try {
					con.close();
				} catch (Exception e2) {
					System.out.println("Exception occured while clossing connection of personVotingReg() method ");
					e2.printStackTrace();
				}
			}
		}

	}

}
