package githubdemo.votingcrud;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


import githubdemo.globalconnection.GlobalConnection;

public class VotingApp {
	
	public static void createPersonVotingReg() {
		Connection con = null;
		try {
			con = GlobalConnection.getConnection();
			String create = "insert into personvotingreg values(?,?,?)";
			PreparedStatement ps = con.prepareStatement(create);
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			
			while(true) {
				System.out.println("Enter person id");
				int personId = Integer.parseInt(br.readLine());
				
				System.out.println("Enter voting person name");
				String nm = br.readLine();
				
				System.out.println("Enter voting person age");
				int age = Integer.parseInt(br.readLine());
				
				ps.setInt(1, personId);
				ps.setString(2, nm);
				ps.setInt(3, age);
				
				int data = ps.executeUpdate();
				// reduce this if statement
				if(data>0) {
					System.out.println(data+" records inserted successfully");
				}else {
					System.out.println("Please try again...");
				}
				System.out.println("Want to add another record for person voting reg yes / no");
				String check = br.readLine();
				if(check.equalsIgnoreCase("no")) {
					break;
				}
				
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(con!=null) {
				try {
					con.close();
				}catch(SQLException e) {
					System.out.println("Exception in createPersonVotingReg method");
					e.printStackTrace();
				}
			}
		}
	}

}
