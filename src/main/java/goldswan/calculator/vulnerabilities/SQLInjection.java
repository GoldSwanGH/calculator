// This is a personal academic project. Dear PVS-Studio, please check it.
// PVS-Studio Static Code Analyzer for C, C++, C#, and Java: https://pvs-studio.com
package goldswan.calculator.vulnerabilities;

import java.sql.*;

public class SQLInjection {

    public void getUserById(Connection connection, String bar) throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery("SELECT * FROM users WHERE id = '" + bar + "'");

        if (rs.next()) {
            System.out.printf("User: %s, %s, %s%n",
                    rs.getInt("id"), rs.getString("name"), rs.getString("email"));
        }
    }
}
