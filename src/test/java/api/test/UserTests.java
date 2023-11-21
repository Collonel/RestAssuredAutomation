package api.test;

import api.endpoints.UserEndPoints;
import api.payload.User;
import com.github.javafaker.Faker;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class UserTests {

    Faker faker;
    User userpayload;

    //generating data and passing the data to the pojo class. We pass the generated data in the post requests
    @BeforeClass
     public void setupData () {

        faker=new Faker();
        userpayload =new User();

        userpayload.setId(faker.idNumber().hashCode());
        userpayload.setUsername(faker.name().username());
        userpayload.setFirstName(faker.name().firstName());
        userpayload.setLastName(faker.name().lastName());
        userpayload.setEmail(faker.internet().safeEmailAddress());
        userpayload.setPassword(faker.internet().password(5,10));
        userpayload.setPhone(faker.phoneNumber().cellPhone());


     }

     @Test(priority = 1)
    public void testPostUser(){

        Response response= UserEndPoints.createUser(userpayload); // Call createUser method from userEndpoints by Parsing the payload
         response.then().log().all(); //print logs
         Assert.assertEquals(response.getStatusCode(),200); //add assertion

     }


    @Test(priority = 2)
    public void testGetUserByName(){

        Response response=   UserEndPoints.readUser(this.userpayload.getUsername());
        response.then().log().all();
        Assert.assertEquals(response.getStatusCode(),200);

    }

    @Test(priority = 3)
    public void testUpdateUserByName()
    {
    //Update data using payload
        userpayload.setUsername(faker.name().username());
        userpayload.setFirstName(faker.name().firstName());

        Response response= UserEndPoints.updateUser(this.userpayload.getUsername(),userpayload);
        response.then().log().all();
        response.then().log().body();
        response.then().log().body().statusCode(200); //chai assertion that comes with RestAssured library

        Assert.assertEquals(response.getStatusCode(),200); //TestNG Assertion

        //Check data after Update
        Response updatedResponse=   UserEndPoints.readUser(this.userpayload.getUsername());
        response.then().log().body();
        Assert.assertEquals(updatedResponse.getStatusCode(),200);

    }

 /*   @Test(priority = 4)
    public void testDeleteUserByName()
    {
        Response response= UserEndPoints.deleteUser(this.userpayload.getUsername());
        Assert.assertEquals(response.getStatusCode(),200);
    }*/

}
