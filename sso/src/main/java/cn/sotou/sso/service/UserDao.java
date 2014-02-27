package cn.sotou.sso.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

public class UserDao {

	private DataSource dataSource;

	private Connection connection;

	public boolean emailRegisted(String email) {
		try {
			Connection connection = getConnection();
			String sql = "select count(*) from loginInfo where email = ?";
			PreparedStatement preparedStatement = connection
					.prepareStatement(sql);
			preparedStatement.setString(1, email);
			ResultSet resultSet = preparedStatement.executeQuery();
			resultSet.next();
			return resultSet.getInt(1) > 0;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return true;
	}

	public boolean userNameRegisted(String username) {
		try {
			Connection connection = getConnection();
			String sql = "select count(*) from user where username = ?";
			PreparedStatement preparedStatement = connection
					.prepareStatement(sql);
			preparedStatement.setString(1, username);
			ResultSet resultSet = preparedStatement.executeQuery();
			resultSet.next();
			return resultSet.getInt(1) > 0;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return true;
	}

	public void addUser(String email, String username, String password) {
		try {
			Connection connection = getConnection();

			String sql = "INSERT INTO user (email,username) VALUES (?,?)";
			PreparedStatement preparedStatement = connection.prepareStatement(
					sql, Statement.RETURN_GENERATED_KEYS);
			preparedStatement.setString(1, email);
			preparedStatement.setString(2, username);
			preparedStatement.executeUpdate();
			ResultSet rs = preparedStatement.getGeneratedKeys();
			rs.next();
			int generateId = rs.getInt(1);

			sql = "INSERT INTO loginInfo (password,userId,email) VALUES (?,?,?)";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, password);
			preparedStatement.setInt(2, generateId);
			preparedStatement.setString(3, email);
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public DataSource getDataSource() {
		return dataSource;
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	private Connection getConnection() throws SQLException {
		if (connection == null || connection.isClosed()) {
			connection = dataSource.getConnection();
		}
		return connection;
	}
}
