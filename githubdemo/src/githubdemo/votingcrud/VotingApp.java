package githubdemo.votingcrud;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import githubdemo.globalconnection.GlobalConnection;

public class VotingApp {
	// method for inserting records
	public static void createPersonVotingReg() {
		Connection con = null;
		try {
			con = GlobalConnection.getConnection();
			String create = "insert into personvotingreg (pname,page)values(?,?)";
			PreparedStatement ps = con.prepareStatement(create);
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

			while (true) {

				System.out.println("Enter voting person name");
				String nm = br.readLine();

				System.out.println("Enter voting person age");
				int age = Integer.parseInt(br.readLine());

				ps.setString(1, nm);
				ps.setInt(2, age);

				int data = ps.executeUpdate();
				// reduce this if statement
				System.out.println((data > 0) ? data + "voting record inserted successfully" : "failed to insert");
				System.out.println("Want to add another record for person voting reg yes / no");
				String check = br.readLine();
				if (check.equalsIgnoreCase("no")) {
					break;
				}

			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					System.out.println("Exception in createPersonVotingReg method");
					e.printStackTrace();
				}
			}
		}
	}

	public void retrivePersonVotinRegDetails() {
		Connection con = null;

		try {
			con = GlobalConnection.getConnection();
			String query="select * from personvotingreg";
			PreparedStatement statement = con.prepareStatement(query);
			ResultSet resultSet = statement.executeQuery();
			
			while(resultSet.next()) {
				int id=resultSet.getInt("pid");
				String name=resultSet.getString("pname");
				int age=resultSet.getInt("page");
				
				System.out.println("Person id is : "+id+" And Person name is -> "+name+", Age is : "+age);
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(con!=null)
			try {
				con.close();
			} catch (Exception e2) {
				System.out.println("Exception in retrivePersonVotinRegDetails method");
				e2.printStackTrace();
			}
		}
	}

}
