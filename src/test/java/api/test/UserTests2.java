package api.test;


import api.endpoints.UserEndPoints2;
import api.payload.User;
import com.github.javafaker.Faker;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class UserTests2 {

    Faker faker;
    User userPayload;

    @BeforeClass
    public void setupData()
    {    faker= new Faker();
        userPayload = new User();

        userPayload.setEmail(faker.internet().emailAddress());
        userPayload.setFirstName(faker.name().firstName());
        userPayload.setLastName(faker.name().lastName());
        userPayload.setId(faker.idNumber().hashCode());
        userPayload.setPassword(faker.internet().password());
        userPayload.setPhone(faker.phoneNumber().cellPhone());
        userPayload.setUsername(faker.name().username());


    }

    @Test(priority=1)
    public void testPostUser(){

        Response response= UserEndPoints2.createUser(userPayload);
        response.then().log().all();
        Assert.assertEquals(response.getStatusCode(),200);
    }

    @Test(priority=2)
    public void testGetUser(){

        Response response= UserEndPoints2.readUser(this.userPayload.getUsername());
        response.then().log().all();
        Assert.assertEquals(response.getStatusCode(),200);
    }

    @Test(priority=3)
    public void testUpdateUser(){

        //Update data using payload
        userPayload.setEmail(faker.internet().emailAddress());
        userPayload.setFirstName(faker.name().firstName());
        userPayload.setLastName(faker.name().lastName());

        Response response= UserEndPoints2.updateUser(this.userPayload.getUsername(),userPayload);
        response.then().log().all();
        Assert.assertEquals(response.getStatusCode(),200);

        //Checking data after update
        Response responseAfterUpdate= UserEndPoints2.readUser(this.userPayload.getUsername());
        response.then().log().all();
        Assert.assertEquals(responseAfterUpdate.getStatusCode(),200);

    }

    @Test(priority=4)
    public void testDeleteUser(){

        Response response= UserEndPoints2.deleteUser(this.userPayload.getUsername());
        response.then().log().all();
        Assert.assertEquals(response.getStatusCode(),200);


    }

}
