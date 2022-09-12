package data;

import lombok.Data;
import lombok.SneakyThrows;
import lombok.Value;
import lombok.val;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.DriverManager;
import java.time.LocalDate;
import java.util.Random;
@Data
public class Helper {
    public Helper() {
    }

    @Value
    public static class DataValue {
        String cardNumber;
        String month;
        String year;
        String owner;
        String cvc;

        public DataValue(String cardNumber, String month, String year, String owner, String cvc) {
            this.cardNumber = cardNumber;
            this.month = month;
            this.year = year;
            this.owner = owner;
            this.cvc = cvc;
        }
    }

//    public static DataValue dataValue() {
//        String cardNumber = validCard();
//        String month = validMonth();
//        String year = validYear();
//        String owner = validOwner();
//        String cvc =validCvc();
//        return new DataValue(cardNumber, month, year, owner, cvc);
//    }

    public static String validCardApproved() {
        return  "1111 2222 3333 4444";
    }

    public static String validCardDeclined() {
        return  "5555 6666 7777 8888";
    }

    public static String validMonth() {
        String[] card = {"09 ", "09"};
        Random random = new Random();
        return card[random.nextInt(card.length)];
    }

    public static String validYear() {
        String localDate = String.valueOf(LocalDate.now().getYear());
        String[] card = {"22", "22"};
        Random random = new Random();
        return card[random.nextInt(card.length)];
    }

    public static String validOwner() {
        String[] card = {"Ivan", "Ivan"};
        Random random = new Random();
        return card[random.nextInt(card.length)];
    }

    public static String validCvc() {
        String[] card = {"999", "999"};
        Random random = new Random();
        return card[random.nextInt(card.length)];
    }

    public static String invalidCard() {
        String[] card = {"1111 2222 3333 4441", "5555 6666 7777 8880"};
        Random random = new Random();
        return card[random.nextInt(card.length)];
    }

    public static String invalidMonth() {
        String[] card = {"15", "-1"};
        Random random = new Random();
        return card[random.nextInt(card.length)];
    }

    public static String invalidYear() {
        String[] card = {"21", "96"};
        Random random = new Random();
        return card[random.nextInt(card.length)];
    }

    public static String invalidOwner() {
        String[] card = {" ", " "};
        Random random = new Random();
        return card[random.nextInt(card.length)];
    }

    public static String invalidCvc() {
        String[] card = {"fgfg", " "};
        Random random = new Random();
        return card[random.nextInt(card.length)];
    }

    @SneakyThrows
    public static String userStatus(String validCard) {
        String status;
        String[] codeSQL = {"SELECT ac.status FROM payment_entity ac  ORDER BY ac.created DESC LIMIT 1", "SELECT ac.status FROM credit_request_entity ac  ORDER BY ac.created DESC LIMIT 1"};
        String sqlQuery = validCard.equals("1111 2222 3333 4444") ? codeSQL[0] : codeSQL[1];
        val runner = new QueryRunner();

        try (
                val conn = DriverManager.getConnection(
                        "jdbc:mysql://localhost:3306/app?allowPublicKeyRetrieval=true&useSSL=false", "app", "pass"
                )
        ) {
            status = runner.query(conn, sqlQuery, new ScalarHandler<>());
        }

        return status;
    }

    @SneakyThrows
    public static void truncateTables() {
        val dataSQLAuth = "DELETE FROM order_entity;";
        val dataSQLUsers = "DELETE FROM credit_request_entity;";
        val dataSQLCards = "DELETE FROM payment_entity;";
        try (
                val conn = DriverManager.getConnection(
                        "jdbc:mysql://localhost:3306/app?allowPublicKeyRetrieval=true&useSSL=false", "app", "pass"
                );
                val dataStmtCards = conn.prepareStatement(dataSQLCards);
                val dataStmtAuth = conn.prepareStatement(dataSQLAuth);
                val dataStmtUsers = conn.prepareStatement(dataSQLUsers);
        ) {
            dataStmtCards.executeUpdate();
            dataStmtAuth.executeUpdate();
            dataStmtUsers.executeUpdate();
        }
    }

}
