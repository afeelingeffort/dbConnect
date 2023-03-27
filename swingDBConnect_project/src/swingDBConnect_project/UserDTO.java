package swingDBConnect_project;

import java.sql.Date;

public class UserDTO {
	private int id;
	private String inputDate;
	private int userMoney;
	private int userDeposit;
	private int userWithdraw;
	private String userMemo;

	public UserDTO() {
	}

	public UserDTO(int id, String inputDate, int userMoney, int userDeposit, int userWithdraw, String userMemo) {
		this.id = id;
		this.inputDate = inputDate;
		this.userMoney = userMoney;
		this.userDeposit = userDeposit;
		this.userWithdraw = userWithdraw;
		this.userMemo = userMemo;
	}

	@Override
	public String toString() {
		return "UserDTO [id=" + id + ", inputDate=" + inputDate + ", userMoney=" + userMoney + ", userDeposit="
				+ userDeposit + ", userWithdraw=" + userWithdraw + ", userMemo=" + userMemo + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getInputDate() {
		return inputDate;
	}

	public void setInputDate(String inputDate) {
		this.inputDate = inputDate;
	}

	public int getUserMoney() {
		return userMoney;
	}

	public void setUserMoney(int userMoney) {
		this.userMoney = userMoney;
	}

	public int getUserDeposit() {
		return userDeposit;
	}

	public void setUserDeposit(int userDeposit) {
		this.userDeposit = userDeposit;
	}

	public int getUserWithdraw() {
		return userWithdraw;
	}

	public void setUserWithdraw(int userWithdraw) {
		this.userWithdraw = userWithdraw;
	}

	public String getUserMemo() {
		return userMemo;
	}

	public void setUserMemo(String userMemo) {
		this.userMemo = userMemo;
	}

}
