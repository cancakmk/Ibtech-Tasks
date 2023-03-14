package com.ibtech.task5.multithread;

import java.rmi.server.Operation;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;

import com.ibtech.dbo.BatchDataDbo;
import com.ibtech.dbo.SpecialAccountDbo;
import com.ibtech.model.BatchData;
import com.ibtech.model.SpecialAccount;

public class ThreadTesting {
	
	public static void main(String[] args) {
		//addDatas();
		execute(20);
	}
	
	
	public static void addDatas() {
		
		SpecialAccountDbo accountDao = new SpecialAccountDbo();
		BatchDataDbo batchDataDao = new BatchDataDbo();

		for (int i = 0; i < 100; i++) {
			SpecialAccount account = new SpecialAccount("Vadesiz" + i, (Math.random()*1000)+1);
			accountDao.create(account);

			for (int j = 0; j < 8; j++) {
				
				
				if (j % 2 == 0) {
					BatchData batchData = new BatchData(false, (int) account.getId(),(Math.random()*10)+1,'A' );
					batchDataDao.create(batchData);
					
					
				}else {
					BatchData batchData = new BatchData(false, (int) account.getId(),(Math.random()*10)+1,'B' );
					batchDataDao.create(batchData);	
				}}}}
	
	public static void execute(int threadcount) {

		BatchDataDbo batchDataDao = new BatchDataDbo();
		List<BatchData> batchDatas = batchDataDao.getList();
		
		System.out.println("-->> batchDatas Size: " + batchDatas.size());
		System.out.println("-->> batchDatas To Be Processed: " + batchDatas.stream().filter(x -> !(x.isStatus())).collect(Collectors.toList()).size());

		int commitCount = batchDatas.size() / threadcount;
		DateFormat dateformat = new SimpleDateFormat("dd MMM yyyy HH:mm:ss:SSS Z");
		ExecutorService executor = Executors.newFixedThreadPool(threadcount);
		for (int i = 0; i < threadcount; i++) {
			Runnable worker =  new ThreadOperation(i * commitCount, (i + 1) * commitCount, batchDatas);
			executor.execute(worker);
			
			System.out.println(i + " thread started. " + dateformat.format(new Date(System.currentTimeMillis())));
		}
		executor.shutdown();
		while (!executor.isTerminated()) {
		}
		System.out.println("SON");
	}

	
	
	
	
	

}
