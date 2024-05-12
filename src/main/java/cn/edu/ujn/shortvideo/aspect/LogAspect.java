package cn.edu.ujn.shortvideo.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Aspect
@Component
public class LogAspect {
	public static Logger log = Logger.getLogger(LogAspect.class.toString());
	@Pointcut("execution(* cn.edu.ujn.*.*.*.*(..))")
	public void myPointcut() {	}

	@Around("myPointcut()")
	public Object myAround(ProceedingJoinPoint pjp) throws Throwable{
		log.info("@@@@@@@@@@【环绕前置通知】【"+ pjp.getSignature().getName()+"方法开始】");
		Object proceed = pjp.proceed();
		log.info("@@@@@@@@@@【环绕返回通知】【"+pjp.getSignature().getName()+"方法返回，返回值："+proceed+"】");
		return proceed;
	}
}