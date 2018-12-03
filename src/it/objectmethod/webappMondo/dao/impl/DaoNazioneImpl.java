package it.objectmethod.webappMondo.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


import it.objectmethod.webappMondo.config.ConnectionManager;
import it.objectmethod.webappMondo.dao.IDaoNazione;
import it.objectmethod.webappMondo.model.Nazione;

public class DaoNazioneImpl implements IDaoNazione{

	@Override
	public List<String> getAllContinents() {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
				Statement stmt = null;
				List<String> list = null;
				Connection conn = ConnectionManager.getConnection();
				try{
					

					//STEP 4: Execute a query
					System.out.println("Creating statement...");
					stmt = conn.createStatement();
					String sql;
					sql = "SELECT distinct continent FROM country";
					ResultSet rs = stmt.executeQuery(sql);
		            list = new ArrayList<>();
					//STEP 5: Extract data from result set
					while(rs.next()){
						//String temp= "";
						//Retrieve by column name
						String cont = rs.getString("Continent");
						
						list.add(cont);
					}
					
					//STEP 6: Clean-up environment
					rs.close();
					stmt.close();
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
						if(stmt!=null)
							stmt.close();
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
	public List<Nazione> getAllNationsByContinent(String continente) {
		// TODO Auto-generated method stub
		
				List<Nazione> list = null;
				Connection conn = ConnectionManager.getConnection();
				PreparedStatement prepStat = null;
				try{
					
					String sql = "SELECT code,name,population from country where continent= ?";
					prepStat= conn.prepareStatement(sql);
					prepStat.setString(1, continente);
					ResultSet rs = prepStat.executeQuery();
		            list = new ArrayList<>();
					//STEP 5: Extract data from result set
					while(rs.next()){
						Nazione nation= new Nazione();
						//Retrieve by column name
						String name = rs.getString("name");
						String code = rs.getString("code");
						int population = rs.getInt("population");
						nation.setNomeNazione(name);
						nation.setCode(code);
						nation.setPopolazione(population);
						list.add(nation);
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
