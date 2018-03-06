package pl.mazurek.dm;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

//@Profile("!hsql")
@Component
public class SpringApplicationContext  implements ApplicationContextAware{

	private static ApplicationContext CONTEXT;
	
	@Override
	public void setApplicationContext(ApplicationContext context) throws BeansException {
		
		CONTEXT = context;
	}

	public static <T> T getBean(Class<T> clazz) { 
		
		if(CONTEXT != null) {
			
			return CONTEXT.getBean(clazz); 
		}
		
		return null;
	}
}
