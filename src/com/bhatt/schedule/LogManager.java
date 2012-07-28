package com.bhatt.schedule;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.bhatt.dao.HttpRequestEntityDAO;


/**
 * http://stackoverflow.com/questions/6154741/why-isnt-spring-running-my-scheduled-method/11632536#11632536
 */
@Service
public class LogManager {

	
	// @Scheduled(cron="*/5 * * * * MON-FRI")
	@Scheduled(fixedDelay = 10000)
	public void doTasks() {
		System.out
				.println("SCHEDULER Working boy!! _______________________________________________");
		
		
		HttpRequestEntityDAO dao = HttpRequestEntityDAO.getInstance();
		dao.
	}
}
