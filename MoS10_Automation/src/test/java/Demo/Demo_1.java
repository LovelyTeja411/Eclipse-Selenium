package Demo;

import org.testng.annotations.Test;


public class Demo_1 {
@Test (priority = 2, dependsOnMethods = "Homepage2",invocationCount = 2)
void Homepage(){
	System.out.println("Hello2");
}
@Test (priority = 1, invocationCount = 3)
void Homepage2(){
	System.out.println("Hello1");
}
}
