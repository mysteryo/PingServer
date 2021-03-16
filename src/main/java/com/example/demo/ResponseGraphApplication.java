package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.net.InetAddress;
import java.util.GregorianCalendar;
import java.util.Timer;
import java.util.TimerTask;

@SpringBootApplication
public class ResponseGraphApplication {

	public static ResponseRepo repo;

	public static void main(String[] args) {
		ConfigurableApplicationContext configurableApplicationContext = SpringApplication.run(ResponseGraphApplication.class, args);
		repo = configurableApplicationContext.getBean(ResponseRepo.class);

		Timer timer = new Timer();
		DbService db = new DbService();

		//timer scheduled for every minute
		timer.schedule(new TimerTask() {
			@Override
			public void run() {
				try{
					Long finish = 0l;
					Long start = 0l;

					InetAddress address = InetAddress.getByName("217.16.184.115");
					start = new GregorianCalendar().getTimeInMillis();
					if(address.isReachable(10000)){
						finish = new GregorianCalendar().getTimeInMillis();
						System.out.println("Response in : "+(finish-start) + "ms");
						db.saveToDb(System.currentTimeMillis(), (finish-start));
					}
					else {
						db.saveToDb(System.currentTimeMillis(), 0l);
						System.out.println("NOT RESPONDING");

					}

				} catch (Exception e){
					e.printStackTrace();
				}
			}
		},0,5*1000);

	}

}
