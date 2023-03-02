package com.ibtech.task5.multithread;



import java.util.List;

import com.ibtech.dbo.BatchDataDbo;
import com.ibtech.dbo.SpecialAccountDbo;
import com.ibtech.model.BatchData;
import com.ibtech.model.SpecialAccount;



public class ThreadOperation implements Runnable {

	private int startNumber;
	private int endNumber;
	private List<BatchData> batchDatas;

	public ThreadOperation(int startNumber, int endNumber, List<BatchData> batchDatas) {
		super();
		this.startNumber = startNumber;
		this.endNumber = endNumber;
		this.batchDatas = batchDatas;
	}

	@Override
	public void run() {

		BatchDataDbo batchDataDao = new BatchDataDbo();
		SpecialAccountDbo accountDao = new SpecialAccountDbo();

		for (int i = startNumber; i < endNumber; i++) {
			BatchData batchData = batchDatas.get(i);
			SpecialAccount account = accountDao.getSpecialAccount(batchData.getAccountNo());

			if (batchData.getTransactionType() == 'A') {
				accountDao.updateBalance(account.getId(), account.getBalance() + batchData.getAmount());
			} else {
				accountDao.updateBalance(account.getId(), account.getBalance() - batchData.getAmount());
			}
			batchDataDao.updateStatus(batchData.getSiraNo(), true);

			System.out.println("--> " + i + ". batch data completed -->> " + Thread.currentThread().getName());
		}
	}
}