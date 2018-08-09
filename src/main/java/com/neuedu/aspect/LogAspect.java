package com.neuedu.aspect;

import com.neuedu.entity.Logrecord;
import org.apache.ibatis.session.SqlSession;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@Component
@Aspect
public class LogAspect {
    @Resource(name="sqlSession")
    private SqlSession sqlSession;
    @Pointcut("execution(* com.neuedu.service.*.*(..))")
    public  void text(){}
    @Around(value = "text()")
    public Object around (ProceedingJoinPoint proceedingJoinPoint) {

        Object o = null;
        try {
//            Object obj=proceedingJoinPoint.getTarget();//原对象
//            System.out.println("obj==="+obj);
//            System.out.println("第一个参数"+proceedingJoinPoint.getArgs()[0]);
//            System.out.println("第2个参数"+proceedingJoinPoint.getArgs()[1]);

            System.out.println("---------1111-----------");
//            执行原对象方法
            Object obj = proceedingJoinPoint.getTarget();
            o = proceedingJoinPoint.proceed();
//            System.out.println(obj);
            String obj_method = proceedingJoinPoint.getSignature().getName();
            System.out.println(obj_method);
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("user_id", 2);
            map.put("operation", obj.getClass().getName() + obj_method);
//            Logrecord l= new Logrecord();
//            l.setUser_id(2);
//            System.out.println();
//            l.setOperation(obj.getClass().getName()+obj_method);
            int i = sqlSession.insert("com.neuedu.entity.Logrecord.add", map);
            System.out.println(i);
//            System.out.println("result="+result);
            System.out.println("---------2222-----------");

        } catch (Throwable throwable) {
            throwable.printStackTrace();
            System.out.println("---------3333-----------");
        }
        System.out.println("---------4444-----------");
        return o;
    }
}
