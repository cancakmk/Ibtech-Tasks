package com.ibtech.dbo;



import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.ibtech.model.BatchData;
import com.ibtech.model.Command;
import com.ibtech.util.HibernateUtil;

	

public class BatchDataDbo {

	public void create(BatchData batchData) {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();
			session.save(batchData);
			transaction.commit();
			System.out.println("BatchData: " + batchData.getSiraNo());
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
	}
	
	public List<BatchData> getList() {
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			return  session.createCriteria(BatchData.class).list();
		}
	}
	
	public void updateStatus(int batchDataId, boolean status) {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			try {
				transaction = session.beginTransaction();
				BatchData batchData = (BatchData) session.get(BatchData.class, batchDataId);			
				batchData.setStatus(status);
				session.update(batchData);
				transaction.commit();
			} catch (HibernateException e) {
				if (transaction != null)
					transaction.rollback();
				e.printStackTrace();
			} finally {
				session.close();
			}
		}
	}
}