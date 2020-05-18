package practico3_1;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.util.StopWatch;

Public aspect Aspecto1 {

private int cantidad=0;
pointcut contar(): call( public void estado());

after(): contar(){

cantidad ++;

system.out.println("cantidad de invocacionessssssssssssssss"+cantidad);
}
}