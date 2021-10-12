package base;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

public class MySqlReader {

    public static Connection connect = null;
    public static Statement statement = null;
    public static PreparedStatement ps = null;
    public static ResultSet resultSet = null;

    public static Properties loadProperties() throws IOException {
        Properties prop = new Properties();
        String systemPath = System.getProperty("user.dir");
        String PROP_RELATIVE_PATH = "/src/test/resources/credentials.properties";
        InputStream ism = new FileInputStream(systemPath+PROP_RELATIVE_PATH);
        prop.load(ism);
        ism.close();
        return prop;
    }

    public static Connection connectToSqlDatabase() throws IOException, SQLException, ClassNotFoundException {
        Properties prop = loadProperties();
        String driverClass = prop.getProperty("MYSQLJDBC.driver");
        String url = prop.getProperty("MYSQLJDBC.url");
        String userName = prop.getProperty("MYSQLJDBC.username");
        String password = prop.getProperty("MYSQLJDBC.password");
        Class.forName(driverClass);
        connect = DriverManager.getConnection(url, userName, password);
        return connect;
    }

    private void close() {
        try {
            if (resultSet != null) {
                resultSet.close();
            }
            if (statement != null) {
                statement.close();
            }
            if (connect != null) {
                connect.close();
            }
        } catch (Exception e) {

        }
    }

    private List<String> getResultSetData(ResultSet resultSet2, String columnName) throws SQLException {
        List<String> dataList = new ArrayList<String>();
        while (resultSet.next()) {
            String itemName = resultSet.getString(columnName);
            dataList.add(itemName);
        }
        return dataList;
    }

    public void insertDataFromArrayToSqlTable(int[] ArrayData, String tableName, String columnName) {
        try {
            connectToSqlDatabase();
            ps = connect.prepareStatement("DROP TABLE IF EXISTS `" + tableName + "`;");
            ps.executeUpdate();

            ps = connect.prepareStatement(
                    "CREATE TABLE `" + tableName + "` (`ID` int(11) NOT NULL AUTO_INCREMENT,`SortingNumbers` bigint(20) DEFAULT NULL,  PRIMARY KEY (`ID`) );");
            ps.executeUpdate();

            for (int n = 0; n < ArrayData.length; n++) {
                ps = connect.prepareStatement("INSERT INTO " + tableName + " ( " + columnName + " ) VALUES(?)");
                ps.setInt(1, ArrayData[n]);
                ps.executeUpdate();
            }

        } catch (IOException | SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void insertDataFromStringToSqlTable(String ArrayData, String tableName, String columnName) {
        try {
            connectToSqlDatabase();
            ps = connect.prepareStatement("INSERT INTO " + tableName + " ( " + columnName + " ) VALUES(?)");
            ps.setString(1, ArrayData);
            ps.executeUpdate();
        } catch (IOException | SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public List<String> directDatabaseQueryExecute(String passQuery, String dataColumn) throws Exception {
        List<String> data = new ArrayList<String>();

        try {
            connectToSqlDatabase();
            statement = connect.createStatement();
            resultSet = statement.executeQuery(passQuery);
            data = getResultSetData(resultSet, dataColumn);
        } catch (ClassNotFoundException e) {
            throw e;
        } finally {
            close();
        }
        return data;
    }

    public void insertDataFromHashMapToSqlTable(HashMap<Object, Object> hashMap, String tableName) {
        try {
            connectToSqlDatabase();
            ps = connect.prepareStatement("DROP TABLE IF EXISTS " + tableName + ";");
            ps.executeUpdate();

            ps = connect.prepareStatement("CREATE TABLE " + tableName + " (`keys` VARCHAR(45) NOT NULL AUTO_INCREMENT, `values` VARCHAR(45) NULL);");
            ps.executeUpdate();

            for (Object obj : hashMap.keySet()) {

                ps = connect.prepareStatement("INSERT INTO " + tableName + " (`keys`) VALUES(?)");
                ps.setObject(1, obj);
                ps.executeUpdate();

                ps = connect.prepareStatement("INSERT INTO " + tableName + " (`values`) VALUES(?)");
                ps.setObject(1, hashMap.get(obj));
                ps.executeUpdate();
            }

        } catch (IOException | SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }


    public void insertProfileToSqlTable(String tableName, String columnName1, String columnName2) {
        try {
            connectToSqlDatabase();
            ps = connect.prepareStatement("INSERT INTO " + tableName + " ( " + columnName1 + "," + columnName2 + " ) VALUES(?,?)");
            ps.setString(1, "Ankita Sing");
            ps.setInt(2, 3590);
            ps.executeUpdate();

        } catch (IOException | SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
