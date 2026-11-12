
package app;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ContactRepositroy {
    private Connection conn;
    
    public ContactRepositroy(Connect db){
        conn = db.getConnection();
        
    }
    public int count() throws SQLException {
 String sql = """
              Select count (*) as count from customers
              """;
 int count=0;
 
 
 try (PreparedStatement stmt = conn.prepareStatement(sql);
       ResultSet rs = stmt.executeQuery();) { 
while(rs.next()){
    count = rs.getInt(1);

}
}return count;
}
public List<Contact> loadAll() throws SQLException{
 String sql = """
 SELECT FIRSTNAME, LASTNAME, CITY, COUNTRY, EMAIL ,CustomerID
                           FROM Customers
              ORDER BY LastName asc
 """;
List<Contact> result = new ArrayList<>();
try(PreparedStatement stmt = conn.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();
    
  ){ while(rs.next()){
      Contact c = new Contact(
        rs.getInt("CustomerId"),
 rs.getString("FirstName"),
 rs.getString("LastName"),
 rs.getString("City"),
 rs.getString("Country"),
 rs.getString("Email")
      );
   result.add(c);

  }
    
}
        return result;


}
private Contact readContact(ResultSet rs) throws SQLException {
    return new Contact(
        rs.getInt("CustomerId"),
        rs.getString("FirstName"),
        rs.getString("LastName"),
        rs.getString("City"),
        rs.getString("Country"),
        rs.getString("Email")
    );
}
public List<Contact> searchByName(String text) throws SQLException {
        String sql = """
                     SELECT CustomerId, FirstName, LastName, City, Country, Email
                     FROM Customers
                     WHERE FirstName LIKE ? OR LastName LIKE ?
                     ORDER BY LastName, FirstName
                     """;
        // TODO 1: the % signs go around the text, not around ? in the query
        String pattern = "%" + text + "%";
 
        List<Contact> list = new ArrayList<>();
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            // TODO 2: the same pattern for both ?
            stmt.setString(1, pattern);   // FirstName
            stmt.setString(2, pattern);   // LastName
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    list.add(readContact(rs));
                }
            }
        }
        return list;
    }
}
