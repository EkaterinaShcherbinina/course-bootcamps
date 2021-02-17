package entity;
public class User {
	private String userName;
	private String password;
	private String email;
	private String seqQuestion;
	private String seqAnswer;
	
	public User(String userName, String password, String email,
			String seqQuestion, String seqAnswer) {
		this.userName = userName;
		this.password = password;
		this.email = email;
		this.seqQuestion = seqQuestion;
		this.seqAnswer = seqAnswer;
	}

	public void setUserName(String uName) {
		userName = uName;
	}
	
	public String getUserName() {
		return userName;
	}
	
	public void setPassword(String pwd) {
		password = pwd;
	}
	
	public String getPassword() {
		return password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSeqQuestion() {
		return seqQuestion;
	}

	public void setSeqQuestion(String seqQuestion) {
		this.seqQuestion = seqQuestion;
	}

	public String getSeqAnswer() {
		return seqAnswer;
	}

	public void setSeqAnswer(String seqAnswer) {
		this.seqAnswer = seqAnswer;
	}
}
