import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.Test;

import utility.DataBaseConnection;

public class DataBaseConnectionTest {

	@Test
	public void test() {

		try (Connection connexion = DataBaseConnection.connect();
				PreparedStatement preparedStatement = connexion.prepareStatement("SELECT * FROM player");
				ResultSet rs = preparedStatement.executeQuery()) {

			while (rs.next() ) {
			   System.out.println("ID[" + rs.getInt("id") + "] LOGIN[" + rs.getString("login")
			   + "] EMAIL[" + rs.getString("email") + "] AGE[" + rs.getInt("age") + "] BEST-SCORE[" + 
					   rs.getInt("best_score") + "]");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
