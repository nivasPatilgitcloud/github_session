package githubdemo.main;


import githubdemo.votingcrud.VotingApp;

public class PersonVotingMain {

	public static void main(String[] args) {

//		VotingApp app = new VotingApp();
//		app.createPersonVotingReg();

		VotingApp app = new VotingApp();
		app.createPersonVotingReg();
		
		app.retrivePersonVotinRegDetails();
		app.deletePersonVotinRegDetails();
	}
}
