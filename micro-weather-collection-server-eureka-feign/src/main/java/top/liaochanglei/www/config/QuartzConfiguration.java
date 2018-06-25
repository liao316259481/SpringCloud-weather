package top.liaochanglei.www.config;

import top.liaochanglei.www.job.WeatherDataSycJob;
import org.quartz.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Quartz Configuration 配置类
 * Created by lcl on 2018/5/18.
 */
@Configuration
public class QuartzConfiguration {
	
	private static final Integer TIME = 180;
	
	//JodDtail
	@Bean
	public JobDetail weaterDataSycJodDtail(){
		return 	JobBuilder.newJob(WeatherDataSycJob.class)
				.withIdentity("WeatherDataSycJob")//定义一个任务名称;
				.storeDurably()
				.build();
	}
	
	//Trigger(触发)
	@Bean
	public Trigger weaterDataSycTrigger(){
		
		//定义触发
		return TriggerBuilder.newTrigger()
				.forJob(weaterDataSycJodDtail())
				.withIdentity("WeatherDataSycTrigger")
				.withSchedule(scheduleBuilder())
				.build();
	}
	@Bean
	public SimpleScheduleBuilder  scheduleBuilder(){
		//定义调度
		return  SimpleScheduleBuilder
				.simpleSchedule()
				.withIntervalInSeconds(TIME)//2秒执行一次
				.repeatForever();
	}
	
}
