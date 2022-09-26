package stepDefinitions;

import static io.restassured.RestAssured.given;


import static org.junit.Assert.*;
import RCB.Counter;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;




public class Definition 
{
	  int foreignplayer=0;
	    int wicketkeeper=0;
	    int i;
	    Counter counter=new Counter();

	    String response="{\r\n"
				+ "  \"name\": \"Royal Challengers Bangalore\",\r\n"
				+ "  \"location\": \"Bangalore\",\r\n"
				+ "  \"player\": [\r\n"
				+ "    {\r\n"
				+ "      \"name\": \"Faf Du Plessis\",\r\n"
				+ "      \"country\": \"South Africa\",\r\n"
				+ "      \"role\": \"Batsman\",\r\n"
				+ "      \"price-in-crores\": \"7\"\r\n"
				+ "    },\r\n"
				+ "    {\r\n"
				+ "      \"name\": \"Virat Kohli\",\r\n"
				+ "      \"country\": \"India\",\r\n"
				+ "      \"role\": \"Batsman\",\r\n"
				+ "      \"price-in-crores\": \"15\"\r\n"
				+ "    },\r\n"
				+ "    {\r\n"
				+ "      \"name\": \"Glenn Maxwell\",\r\n"
				+ "      \"country\": \"Australia\",\r\n"
				+ "      \"role\": \"Batsman\",\r\n"
				+ "      \"price-in-crores\": \"11\"\r\n"
				+ "    },\r\n"
				+ "    {\r\n"
				+ "      \"name\": \"Mohammad Siraj\",\r\n"
				+ "      \"country\": \"India\",\r\n"
				+ "      \"role\": \"Bowler\",\r\n"
				+ "      \"price-in-crores\": \"7\"\r\n"
				+ "    },\r\n"
				+ "    {\r\n"
				+ "      \"name\": \"Harshal Patel\",\r\n"
				+ "      \"country\": \"India\",\r\n"
				+ "      \"role\": \"Bowler\",\r\n"
				+ "      \"price-in-crores\": \"10.75\"\r\n"
				+ "    },\r\n"
				+ "    {\r\n"
				+ "      \"name\": \"Wanindu Hasaranga\",\r\n"
				+ "      \"country\": \"Srilanka\",\r\n"
				+ "      \"role\": \"Bowler\",\r\n"
				+ "      \"price-in-crores\": \"10.75\"\r\n"
				+ "    },\r\n"
				+ "    {\r\n"
				+ "      \"name\": \"Dinesh Karthik\",\r\n"
				+ "      \"country\": \"India\",\r\n"
				+ "      \"role\": \"Wicket-keeper\",\r\n"
				+ "      \"price-in-crores\": \"5.5\"\r\n"
				+ "    },\r\n"
				+ "    {\r\n"
				+ "      \"name\": \"Shahbaz Ahmed\",\r\n"
				+ "      \"country\": \"India\",\r\n"
				+ "      \"role\": \"All-Rounder\",\r\n"
				+ "      \"price-in-crores\": \"2.4\"\r\n"
				+ "    },\r\n"
				+ "    {\r\n"
				+ "      \"name\": \"Rajat Patidar\",\r\n"
				+ "      \"country\": \"India\",\r\n"
				+ "      \"role\": \"Batsman\",\r\n"
				+ "      \"price-in-crores\": \"0.20\"\r\n"
				+ "    },\r\n"
				+ "    {\r\n"
				+ "      \"name\": \"Josh Hazlewood\",\r\n"
				+ "      \"country\": \"Australia\",\r\n"
				+ "      \"role\": \"Bowler\",\r\n"
				+ "      \"price-in-crores\": \"7.75\"\r\n"
				+ "    },\r\n"
				+ "    {\r\n"
				+ "      \"name\": \"Mahipal Lomror\",\r\n"
				+ "      \"country\": \"India\",\r\n"
				+ "      \"role\": \"Bowler\",\r\n"
				+ "      \"price-in-crores\": \"7.75\"\r\n"
				+ "    }\r\n"
				+ "  ]\r\n"
				+ "}";
		JsonPath js= new JsonPath(response);
		String name=js.getString("name");
	    //get the size of the array 
		 int s=js.getInt("player.size()");
     @Given("Verify if team has only four forignplayers")
	public void verify_if_team_has_only_four_forignplayers() 
	{
    	
	    //iterate till the size
	    for ( i=0;i<s;i++)
	{
	 		String country=js.getString("player["+i+"].country");

//write a test to validate that the team has only 4 foreign players
	if(!country.equals("India")) {
		String playername=js.getString("player["+i+"].name");
		System.out.println( playername+ " " +country);
	    foreignplayer++;
	}
	
	}
	    System.out.println(counter.foreignplayer(foreignplayer));
	}

 	//write a test to validate that there is atleast one wicket keeper
	@Then("Verify the team has atleast one wicket keeper")
	public void verify_the_team_has_atleast_one_wicket_keeper() {
	
		  for ( i=0;i<s;i++)
		  {
		String role=js.getString("player["+i+"].role");
		if(role.equals("Wicket-keeper")) {
			String playername=js.getString("player["+i+"].name");
			System.out.println(playername);
		    wicketkeeper++;
		}
	}
		  System.out.println(counter.wicketkeeper(wicketkeeper));



	  
}
	


}

