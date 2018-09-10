package firstPackage;

import java.util.*;

public class ZephirTest {

	static String TestId;
	static String OverallStatus;
	List<step> Steps=new ArrayList<step>();
	
	static jiraClient myConection = new jiraClient();
	
	public void InitCreateOperation() { 
		TestId = "11036";
		
		step s1=new step("78435");
		step s2=new step("78436");
		step s3=new step("78437");
		step s4=new step("78438");
		step s5=new step("78439");
		step s6=new step("78440");
		step s7=new step("78441");
		step s8=new step("78442");
		step s9=new step("78443");
		step s10=new step("78444");
		
		Steps.add(s1);
		Steps.add(s2);
		Steps.add(s3);
		Steps.add(s4);
		Steps.add(s5);
		Steps.add(s6);
		Steps.add(s7);
		Steps.add(s8);
		Steps.add(s9);
		Steps.add(s10);
		
	}
	
	public void SetStepAsFail(int index, String errMsg) {		
		
		OverallStatus = "Fail";
		int arrCounter = 0;
		System.out.println("---Failed on: "+index);
		
		for(step b:Steps){
			
			if(arrCounter < index) {
				b.status = "Pass";
				b.comment = "";
			}
			
			if(arrCounter > index) {
				b.status = "Unexecuted";
				b.comment = "";
			}
			if(arrCounter == index) {
				b.status = "Fail";
				b.comment = errMsg;				
			}
			System.out.println("--Index " + arrCounter + "Set " + b.status);
			Steps.set(arrCounter,b);	
			arrCounter++;
	    }
		SendUpdatedTest();
	}
	
	public void TestSucceded() {		
		OverallStatus = "Pass";
		int arrCounter = 0;
		for(step b:Steps){
			b.status = "Pass";
			b.comment = "";		
		Steps.set(arrCounter,b);	
		arrCounter++;
	    }
		SendUpdatedTest();
	}
	
	public void SendUpdatedTest() {		
		myConection.UpdateTestExecution(TestId, OverallStatus);
		
		for(step b:Steps){
			myConection.UpdateStepExecution(b.id, b.status, b.comment);
	    }
		
	}
}
