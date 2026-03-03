package dao;

import datasource.MariaDbConnection;
import entity.Currency;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.List;

public class CurrencyDao {
    public double getRateByAbbreviation(String abbreviation) throws SQLException {
        String sql = "SELECT conversion_rate_to_usd FROM CURRENCY WHERE abbreviation = ?";

        Connection conn = MariaDbConnection.getConnection();
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, abbreviation);

        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            return rs.getDouble(1);
        } else {
            throw new SQLException("Currency not found");
        }
    }

    public List<Currency> getAllCurrencies() throws SQLException {

        String sql = "SELECT abbreviation, name, conversion_rate_to_usd FROM CURRENCY";
        List<Currency> currencies = new ArrayList<>();

        Connection conn = MariaDbConnection.getConnection();
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(sql);

        while (rs.next()) {
            String abbr = rs.getString("abbreviation");
            String name = rs.getString("name");
            double rate = rs.getDouble("conversion_rate_to_usd");

            currencies.add(new Currency(abbr, name, rate));
        }

        return currencies;
    }

}
