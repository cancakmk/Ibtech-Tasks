package com.ibtech.dbo;



import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.ibtech.model.SpecialAccount;
import com.ibtech.util.HibernateUtil;



public class SpecialAccountDbo {

	public void create(SpecialAccount SpecialAccount) {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();
			session.save(SpecialAccount);
			transaction.commit();
			System.out.println("SpecialAccount: " + SpecialAccount.getId());
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
	}
	
	public SpecialAccount getSpecialAccount(int SpecialAccountId) {
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			SpecialAccount SpecialAccount = (SpecialAccount) session.get(SpecialAccount.class, SpecialAccountId);
			return SpecialAccount;
		}
	}
	
	public void updateBalance(int SpecialAccountId, double balance) {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			try {
				transaction = session.beginTransaction();
				SpecialAccount SpecialAccount = (SpecialAccount) session.get(SpecialAccount.class, SpecialAccountId);
				SpecialAccount.setBalance(balance);
				session.update(SpecialAccount);
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