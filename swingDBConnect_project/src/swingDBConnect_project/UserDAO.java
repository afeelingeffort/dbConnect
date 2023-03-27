package swingDBConnect_project;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class UserDAO implements IUserDAO {

	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;

	public UserDAO() {
		conn = DBHelper.getInstance().getConnection();
	}

	@Override
	public int insert(UserDTO userDTO) {
		int rowCount = 0;
		String sql = " INSERT INTO userAccountBook " + "	VALUES(?, ?, ?, ?, ?, ?) ";

		try {
			pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, userDTO.getId());
			pstmt.setString(2, userDTO.getInputDate());
			pstmt.setInt(3, userDTO.getUserMoney());
			pstmt.setInt(4, userDTO.getUserDeposit());
			pstmt.setInt(5, userDTO.getUserWithdraw());
			pstmt.setString(6, userDTO.getUserMemo());

			rowCount = pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("DAO insert에서 오류 발생");
			e.printStackTrace();
		}
		return rowCount;
	}

	@Override
	public UserDTO select(int id) {
		UserDTO userDTO = null;
		String sql = " SELECT * FROM userAccountBook " + " WHERE id = ? ";

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				userDTO = new UserDTO();

				userDTO.setId(rs.getInt("id"));
				userDTO.setInputDate(rs.getString("inputDate"));
				userDTO.setUserMoney(rs.getInt("userMoney"));
				userDTO.setUserDeposit(rs.getInt("userDeposit"));
				userDTO.setUserWithdraw(rs.getInt("userWithdraw"));
				userDTO.setUserMemo(rs.getString("userMemo"));
			}

		} catch (SQLException e) {
			System.out.println("DAO select에서 오류 발생");
			e.printStackTrace();
		}
		return userDTO;
	}

	@Override
	public int delete(int id) {
		int rowCount = 0;
		String sql = " DELETE FROM userAccountBook " + " WHERE id = ? ";

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);

			rowCount = pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("DAO delete에서 오류 발생");
			e.printStackTrace();
		}
		return rowCount;
	}

	//
	@Override
	public int update(int id, String targetDate, int targetUserMoney, int targetUserDeposit) {
		int rowCount = 0;
		String sql = " UPDATE userAccountBook " + " SET inputDate = ?, userMoney = ?, userDeposit = ? "
				+ " WHERE id = ? ";

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			pstmt.setString(2, targetDate);
			pstmt.setInt(3, targetUserMoney);
			pstmt.setInt(4, targetUserDeposit);

			rowCount = pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("DAO update에서 오류 발생");
			e.printStackTrace();
		}
		return rowCount;
	}

	@Override
	public ArrayList<UserDTO> select() {
		ArrayList<UserDTO> userDTOList = new ArrayList<>();
		String sql = " SELECT * FROM userAccountBook ";

		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				UserDTO userDTO = new UserDTO();

				userDTO.setId(rs.getInt("id"));
				userDTO.setInputDate(rs.getString("inputDate"));
				userDTO.setUserMoney(rs.getInt("userMoney"));
				userDTO.setUserDeposit(rs.getInt("userDeposit"));
				userDTO.setUserWithdraw(rs.getInt("userWithdraw"));
				userDTO.setUserMemo(rs.getString("userMemo"));
				
				userDTOList.add(userDTO);
			}
		} catch (SQLException e) {
			System.out.println("DAO select 전체출력 오류 발생");
			e.printStackTrace();
		}

		return userDTOList;
	}

	// 회원가입 기능
	@Override
	public int saveUser(UserJoinDTO userJoinDTO) {
		String query = " INSERT INTO `join`(id, username, password, email, address) " + "VALUES(?, ?, ?, ?, ?) ";
		int resultRow = 0;

		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, userJoinDTO.getId());
			pstmt.setString(2, userJoinDTO.getUsername());
			pstmt.setString(3, userJoinDTO.getPassword());
			pstmt.setString(4, userJoinDTO.getEmail());
			pstmt.setString(5, userJoinDTO.getAddress());

			resultRow = pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("DAO saveUser에서 오류");
			e.printStackTrace();
		}

		return resultRow;
	}


}
