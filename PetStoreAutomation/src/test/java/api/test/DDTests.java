package api.test;

import org.testng.Assert;
import org.testng.annotations.Test;



import api.endpoints.UserEndpoints;
import api.payload.User;
import api.utilities.DataProviders;
import io.restassured.response.Response;

public class DDTests {
	
    @Test(priority = 1, dataProvider = "Data", dataProviderClass=DataProviders.class)
	public void testPostUser(String userID, String userName, String fname,String lname, String userEmail, String pwd, String ph) 
	{
		
		User userPayload = new User();
		userPayload.setId(Integer.parseInt(userID));
		userPayload.setUsername(userName);
		userPayload.setFirstName(fname);
		userPayload.setLastName(lname);
		userPayload.setEmail(userEmail);
		userPayload.setPassword(ph);
		userPayload.setPhone(ph);
		
		Response response = UserEndpoints.createUser(userPayload);
		Assert.assertEquals(response.getStatusCode(), 200);
	
	}
    
    
    
    @Test(priority = 2, dataProvider = "UserNames", dataProviderClass=DataProviders.class)
    public void testDeleteUserByName(String userName)
    {
    	Response response = UserEndpoints.deleteUser(userName);
    	Assert.assertEquals(response.getStatusCode(), 200);
    }

}
