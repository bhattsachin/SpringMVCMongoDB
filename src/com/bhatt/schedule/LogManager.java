package com.bhatt.schedule;

import java.util.Calendar;

import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.bhatt.dao.HttpRequestEntityDAO;


/**
 * http://stackoverflow.com/questions/6154741/why-isnt-spring-running-my-scheduled-method/11632536#11632536
 */
@Service
public class LogManager {

	private final long DELETE_IF_LOGS_OLD_BY = 60*1000;
	
	// @Scheduled(cron="*/5 * * * * MON-FRI")
	@Scheduled(fixedDelay = 30000)
	public void doTasks() {
		System.out
				.println("SCHEDULER Working boy!! _______________________________________________");
		
		Calendar now = Calendar.getInstance();
		long seconds = now.getTimeInMillis() - DELETE_IF_LOGS_OLD_BY;
		now.setTimeInMillis(seconds);
		
		/**
		 * TODO: MOVE THIS BLOCK TO ASYNC BLOCK
		 */
		
		Query query = new Query(Criteria.where("creationdate").lte(now.getTime()));
		HttpRequestEntityDAO dao = HttpRequestEntityDAO.getInstance();
		dao.delete(query);
		System.out.println("DELETED---------------");
		
	}
}
