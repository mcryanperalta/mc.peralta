package com.DiarylistInterface;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;


import diarylist.diary;
public class DiaryImpl implements diaryDataAccess {

	private DataSource dataSource;

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	@Override
	public String insertDiary(diary diary1, byte[] urlHolder) {
		 
		 
		  
		String sql = "INSERT INTO diarylist " +
				"(entryname, date_created, text_note, ImageUpload) VALUES (?, ?, ?,?)";
		Connection conn = null;
	
		
		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setString(1,diary1.getName());
			ps.setString(2,diary1.getDate());
			ps.setString(3,diary1.getText());
			ps.setBytes(4,urlHolder);
			ps.executeUpdate();
			ps.close();
			return "ok";
		} catch (SQLException e) {
			return e.getMessage();
		}
		
	}
	
	
	@Override
	public ArrayList<diary> selectAllDiary() {
		
		String sql = "SELECT * FROM diarylist ";

		Connection conn = null;
		ArrayList<diary> result = new ArrayList<>();
		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ResultSet rs = ps.executeQuery();
			
			ResultSet resultset = ps.executeQuery();

			ResultSetMetaData metadata = (ResultSetMetaData) resultset.getMetaData();
			int numcols = metadata.getColumnCount();

			while (resultset.next()) {
				 List<String> row = new ArrayList<>(numcols); // new list per row
				    int i = 1;
				    while (i <= numcols) {  // don't skip the last column, use <=
				        row.add(resultset.getString(i++));
				    }
				    diary diary1 = new diary();
				    diary1.setName(row.get(0).toString());
				    diary1.setDate(row.get(1).toString());
				    diary1.setText(row.get(2).toString());
				    result.add(diary1);
			}
			rs.close();
			ps.close();
			return result;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			if (conn != null) {
				try {
				conn.close();
				return result;
				} catch (SQLException e) {
					}
				}
			}
		
		}
	
	



	@Override
	public String deleteDiary(String name1) {
		  
				String sql = "Delete from diarylist " +
						"where entryname = ?";
				Connection conn = null;
			
				
				try {
					conn = dataSource.getConnection();
					PreparedStatement ps = conn.prepareStatement(sql);
					
					ps.setString(1,name1);
					
					ps.executeUpdate();
					ps.close();
					return "ok";
				} catch (SQLException e) {
					return e.getMessage();
				}	
		
	}
	
	@Override
	public ArrayList<diary> selectADiary (String name2) {
		String sql = "SELECT * FROM diarylist Where entryname = ?";

		Connection conn = null;
		ArrayList<diary> result = new ArrayList<>();
		 diary diary1 = new diary();
		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1,name2);
			ResultSet rs = ps.executeQuery();
			
			ResultSet resultset = ps.executeQuery();

			ResultSetMetaData metadata = (ResultSetMetaData) resultset.getMetaData();
			int numcols = metadata.getColumnCount();
			
			if (resultset.next()) {
				 List<String> row = new ArrayList<>(numcols); // new list per row
				    int i = 1;
				    while (i <= numcols) {  // don't skip the last column, use <=
				        row.add(resultset.getString(i++));
				    }
				   
				    diary1.setName(row.get(0).toString());
				    diary1.setDate(row.get(1).toString());
				    diary1.setText(row.get(2).toString());
				    result.add(diary1);
			}
			rs.close();
			ps.close();
			return result;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			if (conn != null) {
				try {
				conn.close();
				return result;
				} catch (SQLException e) {
					}
				}
			}
		
	}
}
