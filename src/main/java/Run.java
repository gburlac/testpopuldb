import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Run {
    public static void main(String[] args) {
        try {
    String url = "jdbc:sqlserver://MDCH-QA-TRAIN2:1433;database=GBurlacDBS";
            Connection conn = DriverManager.getConnection(url,"sa","MDCH-TRAIN2SA");
            Statement st = conn.createStatement();
            st.executeQuery("INSERT INTO PATIENT " + "VALUES (16, 'Simpsons', 'Toler', 29, 'Male','207-254-4799')");
        conn.close();
        }catch (Exception e){
            System.err.println("An exception! ");
            System.err.println(e.getMessage());
        }
    }
}
