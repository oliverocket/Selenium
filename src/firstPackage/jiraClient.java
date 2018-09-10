package firstPackage;

import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

public class jiraClient {
	
	private final String baseUrl;
    private final String username;
    private final String password;
    private final String UpdateExecStatus;
    private final String URLUpdateStepExec;
    private final String authorizationHeaderValue;

    public jiraClient() {
        this.baseUrl = "http://hqtajira01:8080/";
    	this.username = "MyUserName";
        this.password = "MyPassword";
        this.UpdateExecStatus = "rest/zapi/latest/execution/";
        this.URLUpdateStepExec = "rest/zapi/latest/stepResult/";
        
        String usernameAndPassword = username + ":" + password;
        this.authorizationHeaderValue = "Basic " + java.util.Base64.getEncoder().encodeToString(usernameAndPassword.getBytes());
    }
    
    public String UpdateTestExecution(String TestId, String ExStatus){
    	
    	String targetUrl = baseUrl + UpdateExecStatus + TestId + "/execute";
    	
    	String StatusNumber;
    	switch (ExStatus) {
        case "Unexecuted":  StatusNumber = "-1";
            break;
        case "Pass":  StatusNumber = "1";
        	break;
        case "Fail":  StatusNumber = "2";
    		break;
        default: StatusNumber = "3"; //WIP
            break;
    }
    	
    	Response response;
		
			Entity payload = Entity.json("{  \"status\": \""+StatusNumber+"\"}");
			
			response = ClientBuilder.newClient()
			         .target(targetUrl)
			         .request(MediaType.APPLICATION_JSON)
			         .header("Authorization", authorizationHeaderValue)
			         .put(payload);
			
			System.out.println("status: " + response.getStatus());
			System.out.println("headers: " + response.getHeaders());
			System.out.println("body:" + response.readEntity(String.class));
		 	    	   
 
		
		return Integer.toString(response.getStatus());
		         
 	
    }
    
    public String UpdateStepExecution(String SteptId, String ExStatus, String Message){
    	
    	String targetUrl = baseUrl + URLUpdateStepExec + SteptId ;
    	
    	String StatusNumber;
    	switch (ExStatus) {
        case "Unexecuted":  StatusNumber = "-1";
            break;
        case "Pass":  StatusNumber = "1";
        	break;
        case "Fail":  StatusNumber = "2";
    		break;
        default: StatusNumber = "3"; //WIP
            break;
    }
    	
    	Response response;
    	
    	String StrBody = "{";
    	
    	StrBody += "\"status\": \""+StatusNumber+"\"";
    	StrBody += ",\"comment\": \""+Message+"\"";
    	StrBody += "}";
		
			Entity payload = Entity.json(StrBody);
			
			response = ClientBuilder.newClient()
			         .target(targetUrl)
			         .request(MediaType.APPLICATION_JSON)
			         .header("Authorization", authorizationHeaderValue)
			         .put(payload);
			
			System.out.println("status: " + response.getStatus());
			System.out.println("headers: " + response.getHeaders());
			System.out.println("body:" + response.readEntity(String.class));
		 	    	   
 
		
		return Integer.toString(response.getStatus());
		         
 	
    }
    
    
    
}
