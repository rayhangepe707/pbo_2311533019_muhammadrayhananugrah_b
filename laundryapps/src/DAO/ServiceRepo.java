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
import Model.Service;

public class ServiceRepo implements ServiceDAO {
	
	private Connection connection;
	final String insert = "INSERT INTO user (jenis, harga, status) VALUES (?,?,?);";
	final String select = "SELECT * FROM user;";
	final String delete = "DELETE FROM user WHERE id=?;";
	final String update = "UPDATE user SET name=?, username=?, password=? WHERE id=?;";

public ServiceRepo() {
	connection = Database.koneksi();



}

	public void save(Service service) {
		// TODO Auto-generated method stub
		PreparedStatement st = null;
		try {
			st = connection.prepareStatement(insert);
			st.setString(1,  service.getJenis());
			st.setInt(2, service.getHarga());
			st.setString(3,  service.getStatus());
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

	public List<Service> show() {
		// TODO Auto-generated method stub
		List<Service> ls=null;
		try {
			ls = new ArrayList<Service>();
			Statement st = connection.createStatement();
			ResultSet rs = st.executeQuery(select);
			while(rs.next()) {
				Service service = new Service();
				service.setId(rs.getString("id"));
				service.setJenis(rs.getString("Jenis"));
				service.setStatus(rs.getString("Status"));
				service.setHarga(rs.getInt("Harga"));
				ls.add(service);
			}
		}catch(SQLException e) {
			Logger.getLogger(CostumerDAO.class.getName()).log(Level.SEVERE, null,e);
		}
		return ls;
	}

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

	public void update(Service service) {
		// TODO Auto-generated method stub
		PreparedStatement st = null;
		try {
			st = connection.prepareStatement(update);
			st.setString(1, service.getJenis());
			st.setString(2, service.getStatus());
			st.setInt(3, service.getHarga());
			st.setString(4, service.getId());
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

