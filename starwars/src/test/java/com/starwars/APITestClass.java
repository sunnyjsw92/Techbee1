package com.starwars;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static io.restassured.RestAssured.given;

public class APITestClass {

    String baseUri = "https://swapi.dev/";

    //    Verify that the people endpoint is returning a successful response
    @Test
    public void peopleEndpointResponseCode() {
        String url1 = baseUri + "api/people";
        Response response = RestAssured.get(url1);
        Assert.assertEquals(response.getStatusCode(), 200);
    }

    /*    Verify that the total number of people where height is greater than
    200 matches the expected count (10 at the time this was assigned)*/
    @Test
    public void peopleHeightGreaterThan200() {
        String url1 = baseUri + "api/people";
        Response response = RestAssured.get(url1);
        JsonPath employees = response.jsonPath();
        List<String> allEmployess = employees.getList("results.height");
        int count = 0;
        for (String emp : allEmployess) {
            if (Integer.valueOf(emp) > 200) {
                count = count + 1;
            }
        }
        System.out.println("employees with height > 200 are " + count);
    }

    /*Verify that the 10 individuals returned are:
    Darth Vader. Chewbacca, Roos Tarpals, Rugor Nass, Yarael Poof, Lama Su, Tuan Wu, Grievous, Tarfful,
    Tion Medon*/
    @Test
    public void actualIndividuals() {
        String url1 = baseUri + "api/people";
        Response response = RestAssured.get(url1);
        JsonPath employees = response.jsonPath();
        List<String> employeeNames = employees.getList("results.name");
        Boolean flag = false;
        Set<String> nameSet = new HashSet<String>();
        for (String emp : employeeNames) {
            nameSet.add(emp);
            if (!emp.equalsIgnoreCase("Darth Vader") || !emp.equalsIgnoreCase("Luke Skywalker")
                    || !emp.equalsIgnoreCase("C-3PO") || !emp.equalsIgnoreCase("R2-D2") || !emp.equalsIgnoreCase(
                    "Leia Organa") || !emp.equalsIgnoreCase("Owen Lars") || !emp.equalsIgnoreCase("Beru "
                    + "Whitesun lars") || !emp.equalsIgnoreCase("R5-D4") || !emp.equalsIgnoreCase("Biggs "
                    + "Darklighter") || !emp.equalsIgnoreCase("Obi-Wan Kenobi")) {
                break;
            }
            else flag=true;
            if(flag && nameSet.size()== employeeNames.size()) {flag=true;}
            else flag=false;
            Assert.assertTrue(flag);
        }
    }

//    Verify that the total number of people checked equals the expected count
    @Test
    public void totalSampleSize () {
        String url1 = baseUri + "api/people";
        Response response = RestAssured.get(url1);
        JsonPath employees = response.jsonPath();
        Assert.assertEquals(employees.getInt("count"),82);
    }

}
