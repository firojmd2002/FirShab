package com.firoj.shabnaz.database;


import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.stmt.PreparedQuery;
import com.j256.ormlite.stmt.QueryBuilder;
import com.j256.ormlite.stmt.Where;
import com.firoj.shabnaz.database.model.Shabnaz;

import java.sql.SQLException;
import java.util.List;


public class RepoShabnaz {

	Dao<Shabnaz, String> shabnazDao;
	
	public RepoShabnaz(DatabaseNGISHelper db) throws SQLException
	{
		shabnazDao = db.getshabnazDao();
	}
	public int create(Shabnaz Shabnaz)
	{


		try {
			
			return shabnazDao.create(Shabnaz);
		} catch (SQLException e) {
			// TODO: Exception Handling
			e.printStackTrace();
		}
		return 0;
	}
	public int update(Shabnaz Shabnaz)
	{
		try {
			return shabnazDao.update(Shabnaz);
		} catch (SQLException e) {
			// TODO: Exception Handling
			e.printStackTrace();
		}
		return 0;
	}
	public int delete(Shabnaz Shabnaz)
	{
		try {
			return shabnazDao.delete(Shabnaz);
		} catch (SQLException e) {
			// TODO: Exception Handling
			e.printStackTrace();
		}
		return 0;
	}

	public void delAll()
	{
		try {

			QueryBuilder<Shabnaz, String> qb = shabnazDao.queryBuilder();
			Where<Shabnaz, String> where = qb.where();
			where.gt("ShabnazID", 0);
			PreparedQuery<Shabnaz> pq = qb.prepare();
			List<Shabnaz> s = shabnazDao.query(pq);
			for (int i =0; i<s.size();i++)
			{
				delete(s.get(i));
			}

		} catch (SQLException e) {
			// TODO: Exception Handling
			e.printStackTrace();
		}
	}
	
	public int delete_soft(Shabnaz Shabnaz)
	{
		//Shabnaz.setRowStatus("D");
		return update(Shabnaz);

	}
	
	public List<Shabnaz> getAllWorkOrders(int assets)
	{		
		try {
            QueryBuilder<Shabnaz, String> qb = shabnazDao.queryBuilder();
			Where<Shabnaz, String> where = qb.where();
			where.gt("ShabnazID", assets);
			PreparedQuery<Shabnaz> pq = qb.prepare();
			return shabnazDao.query(pq);
		} catch (SQLException e) {
			// TODO: Exception Handling
			e.printStackTrace();
		}
		return null;
	}

	public List<Shabnaz> getAllByAssetsID(int assets) {
		try {
			List<Shabnaz> returnVals =  shabnazDao.queryForEq("ShabnazID", assets);
			return returnVals;
		} catch (SQLException e) {
			// TODO: Exception Handling
			e.printStackTrace();
		}
		return null;
	}



	public Shabnaz getByMobWorkOrderID2( int mobWorkOrderID)
	{
		try {
			QueryBuilder<Shabnaz, String> qb = shabnazDao.queryBuilder();
			Where<Shabnaz, String> where = qb.where();
			where.eq("ShabnazID", mobWorkOrderID);
			PreparedQuery<Shabnaz> pq = qb.prepare();
			return shabnazDao.queryForFirst(pq);
		} catch (SQLException e) {
			// TODO: Exception Handling
			e.printStackTrace();
		}
		return null;
	}

	public int save(Shabnaz obj)
	{
		return this.create(obj);
		//return this.save(obj);
//		Shabnaz queryObj = this.getByMobWorkOrderID2(obj.getShabnazID());
//
//		if(queryObj == null)
//		{
//			return this.create(obj);
//		}
//		else
//		{
//			return this.update(obj);
//		}

	}
	
}
