import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Common {
	static final String URL = "jdbc:mysql://localhost:3306/dbtest?serverTimezone=JST";
	static final String USERNAME = "root";
	static final String PASSWORD = "ishi1196";

	public static String getErr(String name, String address, String tel) {
		final String ERRMSG_NAME01 = "名前は全角20文字以内で入力してください";
		final String ERRMSG_NAME02 = "名前は必須項目です";
		final String ERRMSG_ADDRESS01 = "住所は全角40文字以内で入力してください";
		final String ERRMSG_ADDRESS02 = "住所は必須項目です";
		final String ERRMSG_TEL01 = "電話番号は「000-0000-0000」の形式で入力してください";
		String returnVal = "";
		if (name.length() > 40) {
			returnVal = ERRMSG_NAME01 + "<br>";
		} else if (name.length() == 0) {
			returnVal = ERRMSG_NAME02 + "<br>";
		} else if (address.length() > 80) {
			returnVal = ERRMSG_ADDRESS01 + "<br>";
		} else if (address.length() == 0) {
			returnVal = ERRMSG_ADDRESS02 + "<br>";
		} else if (!(tel.length() > 0 && tel.equals("000-0000-0000"))) {
			returnVal = ERRMSG_TEL01 + "<br>";
		}
		return returnVal;
	}

	public static ResultSet getCategoryAll() {
		PreparedStatement ps;
		ResultSet rs = null;
		String getQuery;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			Statement stmt = connect.createStatement();
			getQuery = "select categoryid,categoryname from category order by id asc;";
			rs = stmt.executeQuery(getQuery);

			return rs;

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		return rs;
	}

	public static String getCategoryName(String id) {
		Statement stmt;
		PreparedStatement ps;
		String getQuery;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			stmt = connect.createStatement();
			getQuery = "select categoryid,categoryname from category where categoryid=id;";
			ResultSet rs = stmt.executeQuery(getQuery);

			return rs.getString("categoryname");

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return "えらー";
	}
}
