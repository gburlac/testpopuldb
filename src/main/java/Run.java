import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Run {
    public static void main(String[] args) {
        try {
            String url = "jdbc:sqlserver://MDCH-QA-TRAIN2:1433;database=GBurlacDBS";
            Connection conn = DriverManager.getConnection(url, "sa", "MDCH-TRAIN2SA");
            Statement st = conn.createStatement();

            String querySelectAll = "Select * from PATIENT";
            String querySelectCount = "Select COUNT(1) from PATIENT";

            ResultSet resultSet = st.executeQuery(querySelectAll);
            while (resultSet.next()) {
                int ID_PATIENT = resultSet.getInt("ID_PATIENT");
                String FIRST_NAME = resultSet.getString("FIRST_NAME");
                String LAST_NAME = resultSet.getString("LAST_NAME");
                int AGE = resultSet.getInt("AGE");
                String GENDER = resultSet.getString("GENDER");
                String PHONE_NUMBER = resultSet.getString("PHONE_NUMBER");

                System.out.format("%s, %s, %s, %s, %s, %s\n", ID_PATIENT, FIRST_NAME, LAST_NAME, AGE, GENDER, PHONE_NUMBER);
            }
            st.close();

            st.executeQuery("INSERT INTO PATIENT " + "VALUES (16, 'Simpsons', 'Toler', 29, 'Male','207-254-4799')");
            conn.close();
        } catch (Exception e) {
            System.err.println("An exception! ");
            System.err.println(e.getMessage());
        }
    }
}
