package it.objectmethod.webappMondo.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import it.objectmethod.webappMondo.config.ConnectionManager;
import it.objectmethod.webappMondo.dao.IDaoCitta;
import it.objectmethod.webappMondo.model.Citta;

public class DaoCittaImpl implements IDaoCitta{

	@Override
	public List<Citta> getAllCitiesByNation(String countrycode) {
		// TODO Auto-generated method stub
		List<Citta> list = null;
		Connection conn = ConnectionManager.getConnection();
		PreparedStatement prepStat = null;
		try{

			String sql = "SELECT id,name, district, population, countrycode from city where countrycode= ?";
			prepStat= conn.prepareStatement(sql);
			prepStat.setString(1, countrycode);
			ResultSet rs = prepStat.executeQuery();
			list = new ArrayList<>();
			//STEP 5: Extract data from result set
			while(rs.next()){
				Citta city= new Citta();
				//Retrieve by column name
				int id= rs.getInt("id");
				String name = rs.getString("name");
				String district = rs.getString("district");
				int population = rs.getInt("population");
				String countryCode = rs.getString("countrycode");
				city.setId(id);
				city.setNomeCitta(name);
				city.setDistretto(district);
				city.setPopolazione(population);
				city.setCountryCode(countryCode);
				list.add(city);
			}

			//STEP 6: Clean-up environment
			rs.close();
			prepStat.close();
			conn.close();
		}catch(SQLException se){
			//Handle errors for JDBC
			se.printStackTrace();
		}catch(Exception e){
			//Handle errors for Class.forName
			e.printStackTrace();
		}finally{
			//finally block used to close resources
			try{
				if(prepStat!=null)
					prepStat.close();
			}catch(SQLException se2){
			}// nothing we can do
			try{
				if(conn!=null)
					conn.close();
			}catch(SQLException se){
				se.printStackTrace();
			}//end finally try
		}//end try
		System.out.println("Goodbye!");
		return list;
	}

	@Override
	public List<Citta> cercaCitta(String cittaCercata) {
		// TODO Auto-generated method stub
		List<Citta> list = null;
		Connection conn = ConnectionManager.getConnection();
		PreparedStatement prepStat = null;
		try{

			String sql = "SELECT id, name, district, population, countrycode from city where name like ?";
			prepStat= conn.prepareStatement(sql);
			prepStat.setString(1, cittaCercata+ "%");
			ResultSet rs =prepStat.executeQuery();
			list = new ArrayList<>();
			//STEP 5: Extract data from result set
			while(rs.next()){
				Citta city= new Citta();
				//Retrieve by column name
				int id= rs.getInt("id");
				String name = rs.getString("name");
				String district = rs.getString("district");
				int population = rs.getInt("population");
				String countryCode = rs.getString("countrycode");
				city.setId(id);
				city.setNomeCitta(name);
				city.setDistretto(district);
				city.setPopolazione(population);
				city.setCountryCode(countryCode);
				list.add(city);
			}

			//STEP 6: Clean-up environment
			rs.close();
			prepStat.close();
			conn.close();
		}catch(SQLException se){
			//Handle errors for JDBC
			se.printStackTrace();
		}catch(Exception e){
			//Handle errors for Class.forName
			e.printStackTrace();
		}finally{
			//finally block used to close resources
			try{
				if(prepStat!=null)
					prepStat.close();
			}catch(SQLException se2){
			}// nothing we can do
			try{
				if(conn!=null)
					conn.close();
			}catch(SQLException se){
				se.printStackTrace();
			}//end finally try
		}//end try
		System.out.println("Goodbye!");
		return list;
	}

}
