package reponsitory;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Utils.JDBCUtil;
import model.Drug;

public class DrugRepository {
	private List<Drug> drugs = new ArrayList<>();

    public DrugRepository() {
        loadDrugsFromDatabase();
    }

    private void loadDrugsFromDatabase() {
        try (Connection conn = JDBCUtil.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM drugs")) {
            while (rs.next()) {
                drugs.add(new Drug(rs.getString("id"), rs.getString("name"), rs.getString("description"), rs.getDouble("price"), rs.getInt("stock_quantity")));
            }
        } catch (SQLException | IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
