
package com.sap.mdm.prd.configuration;

import com.sap.mdm.prd.service.TicketBookingService;
import com.sap.mdm.prd.service.impl.TicketBookingServiceImplementation;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Aspect
@Configuration
public class AspectConfiguration {

	private static final Logger log = LoggerFactory.getLogger(AspectConfiguration.class);

	@Pointcut(value = "execution(* com.sap.mdm.prd.*.*.*(..))")
	public void allMethods() {}


	@Pointcut(value = "execution(* com.sap.mdm.prd.*.*.get*(..)) || execution(* com.sap.mdm.prd.*.*.set*(..))")
	public void allGetterAndSetterMethods() {}
	
	@Before(value="allMethods() && !allGetterAndSetterMethods()")
	public void beforeAllMethods(JoinPoint jointPoint) {
		System.out.println("Inside method "+jointPoint.getClass()+"."+jointPoint.getSignature());
		
		StringBuilder argsString= new StringBuilder();
		int count=0;
		for(Object arg:jointPoint.getArgs()) {
			argsString.append(arg.toString());
			
			if(count<jointPoint.getArgs().length)
			argsString.append(", ");
		}
		
		System.out.println("Parameters passed - "+argsString.toString());
	}
	

	@After(value="allMethods() && !allGetterAndSetterMethods()")
	public void afterAllMethods(JoinPoint jointPoint) {
		System.out.println("Exiting method "+jointPoint.getClass()+"."+jointPoint.getSignature());
	}

	@Bean
	public TicketBookingService ticketBookingService(){
		return new TicketBookingServiceImplementation();
	}

}

