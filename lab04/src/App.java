import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class App {
    public static void main(String[] args) throws Exception {
        Class.forName("org.postgresql.Driver");
        String url = "jdbc:postgresql://aws-1-sa-east-1.pooler.supabase.com:6543/postgres?user=postgres.bwhmjlaqsndctdrgxclu&password=GiCz8El9K0UfQFTU";
        Connection con = DriverManager.getConnection(url);

        Statement stmt = con.createStatement();

        // SELECT
        ResultSet rs = stmt.executeQuery("SELECT * FROM contas");

        while (rs.next()) {
            System.out.println("Nro Conta: " + rs.getInt("nro_conta") +
                    ", Saldo: " + rs.getDouble("saldo"));
        }
        rs.close();
        stmt.close();

        // INSERT
        String sql_insert = "INSERT INTO contas (nro_conta, saldo) VALUES (?, ?)";
        PreparedStatement pstmt = con.prepareStatement(sql_insert);
        pstmt.setInt(1, 1);
        pstmt.setDouble(2, 1000.00);

        int qte = pstmt.executeUpdate();
        if (qte >= 1) {
            System.out.println("Inserido com sucesso");
        }
        pstmt.close();

        // UPDATE
        String sql_update = "UPDATE contas SET saldo = ? WHERE nro_conta = ?";
        PreparedStatement pstmtUpdate = con.prepareStatement(sql_update);
        pstmtUpdate.setDouble(1, 1);
        pstmtUpdate.setInt(2, 500);

        int rowsUpdated = pstmtUpdate.executeUpdate();
        if (rowsUpdated >= 1) {
            System.out.println("Atualizado com sucesso");
        }
        pstmtUpdate.close();

        // DELETE
        String sql_delete = "DELETE FROM contas WHERE nro_conta = ?";
        PreparedStatement pstmtDelete = con.prepareStatement(sql_delete);
        pstmtDelete.setInt(1, 1);

        int rowsDeleted = pstmtDelete.executeUpdate();
        if (rowsDeleted >= 1) {
            System.out.println("Deletado com sucesso");
        }
        pstmtDelete.close();
    }
}
