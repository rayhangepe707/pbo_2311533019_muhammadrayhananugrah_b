package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import confg.Database;
import Model.Costumer;

public class CostumerRepo implements CostumerDAO {
	
	private Connection connection;
	final String insert = "INSERT INTO user (name, alamat, nomorhp) VALUES (?,?,?);";
	final String select = "SELECT * FROM user;";
	final String delete = "DELETE FROM user WHERE id=?;";
	final String update = "UPDATE user SET name=?, username=?, password=? WHERE id=?;";

public CostumerRepo() {
	connection = ((Database) connection).koneksi();



}

	@Override
	public void save(Costumer customer) {
		// TODO Auto-generated method stub
		PreparedStatement st = null;
		try {
			st = connection.prepareStatement(insert);
			st.setString(1,  customer.getNama());
			st.setString(2, customer.getAlamat());
			st.setString(3,  customer.getNomorhp());
			st.executeUpdate();
		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				st.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public List<Costumer> show() {
		// TODO Auto-generated method stub
		List<Costumer> ls=null;
		try {
			ls = new ArrayList<Costumer>();
			Statement st = connection.createStatement();
			ResultSet rs = st.executeQuery(select);
			while(rs.next()) {
				Costumer customer = new Costumer();
				customer.setId(rs.getString("id"));
				customer.setNama(rs.getString("name"));
				customer.setAlamat(rs.getString("Address"));
				customer.setNomorhp(rs.getString("phone number"));
				ls.add(customer);
			}
		}catch(SQLException e) {
			Logger.getLogger(CostumerDAO.class.getName()).log(Level.SEVERE, null,e);
		}
		return ls;
	}

	@Override
	public void delete(String id) {
		// TODO Auto-generated method stub
		PreparedStatement st = null;
		try {
			st = connection.prepareStatement(delete);
			st.setString(1, id);
			st.executeUpdate();
			
		}catch(SQLException e) {
			e.printStackTrace();
			
		}finally {
			try {
				st.close();
				
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		
	}

	@Override
	public void update(Costumer costumer) {
		// TODO Auto-generated method stub
		PreparedStatement st = null;
		try {
			st = connection.prepareStatement(update);
			st.setString(1, costumer.getNama());
			st.setString(2, costumer.getAlamat());
			st.setString(3, costumer.getNomorhp());
			st.setString(4, costumer.getId());
			st.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
			
		}finally {
			try {
				st.close();
				
			}catch(SQLException e) {
				e.printStackTrace();
			}	
		}
	}
	
}