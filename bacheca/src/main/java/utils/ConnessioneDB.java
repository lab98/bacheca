package utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class ConnessioneDB {
	private Context ctx = null;
    private DataSource ds = null;
    private  Connection connection = null;
    private PreparedStatement statement = null;
    private ResultSet rs = null;
    
    public Connection apriConnessione() throws NamingException, SQLException {
    	try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        ctx = new InitialContext();
        ds = (DataSource) this.ctx.lookup("java:comp/env/jdbc/bacheca");
        return connection  = this.ds.getConnection();
		
    }
    
    public void chiudiConnessione() throws SQLException {
        if(rs != null)
            this.rs.close();
        
        statement.close();
        connection.close();
    }
}