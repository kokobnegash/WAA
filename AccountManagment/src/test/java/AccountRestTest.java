import Account.service.AccountService;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import Account.domain.Account;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.*;

public class AccountRestTest {

    @BeforeClass
    public static void setup() {
        RestAssured.port = Integer.valueOf(6060);
        RestAssured.baseURI = "http://localhost";
        RestAssured.basePath = "";
    }

    @Autowired
    AccountService accountService;

    @Test
    public void testgetAccounts() {
        // add the contact to be fetched
     //   Account account = new Account("2304c", "Karl",0);
        given()
                .contentType("application/json")
                .when().post("/account/2304c/Karl").then()
                .statusCode(200);

        given()
                .contentType("application/json")
                .when().post("/account/2304d/jack").then()
                .statusCode(200);

        // test getting the contact
        given()
                .when()
                .get("/account")
                .then()
                .contentType(ContentType.JSON)
                .and()
                .body("accountNumber",hasItems("2304c" , "2304d"))
                .body("accountHolder",hasItems("Karl" , "jack"));

        //cleanup
        given()
                .when()
                .delete("account/2304c");
        given()
                .when()
                .delete("account/2304d");



    }


    @Test
    public void CreateAccounts() {
        // add the contact to be fetched
        //   Account account = new Account("2304c", "Karl",0);
        given()
                .contentType("application/json")
                .when().post("/account/2304c/Karl").then()
                .statusCode(200);
        // test getting the contact

        given()
                .when()
                .get("account/2304c")
                .then()
                .contentType(ContentType.JSON)
                .and()
                .body("accountNumber",equalTo("2304c"))
                .body("accountHolder",equalTo("Karl"));

        //cleanup
        given()
                .when()
                .delete("account/2304c");
    }






    @Test
    public void testcreateTranaction() {
        // add the contact to be fetched
        //   Account account = new Account("2304c", "Karl",0);
        given()
                .contentType("application/json")
                .when().post("/account/2304c/Karl").then()
                .statusCode(200);
        // test getting the contact
        given()
                 .contentType("application/json")
                .when().post("/transaction/2304c/2000/deposit");
        //cleanup
        given()
                .when()
                .delete("account/2304c");
    }
    @Test
    public void testDeposit() {

        float   balance= 2000;
        given()
                .contentType("application/json")
                .when().post("/account/2304c/Karl").then()
                .statusCode(200);
        // test getting the contact

        given()
                .contentType("application/json")

                .when().post("/deposit/2304c/2000").then()
                .statusCode(200);
        // test getting the contac

        given()
                .contentType("application/json")

                .when().post("/deposit/2304c/4000").then()
                .statusCode(200);
        // test getting the contac



        given()
                .when()

                .get("account/2304c")
                .then()
                .contentType(ContentType.JSON)
                .and()
                .body("balance",equalTo(6000F))
                .body("accountNumber",equalTo("2304c"))
              ;
        //cleanup
//        given()
//                .when()
//                .delete("account/2304c");
    }


    @Test
    public void testwithDraw() {
        // add the contact to be fetched
        Account account = new Account("2304c", "Karl",0);

        float   balance= 2000;
        given()
                .contentType("application/json")
                .when().post("/account/2304c/Karl").then()

                .statusCode(200);
        // test getting the contact

        given()
                .contentType("application/json")

                .when().post("/deposit/2304c/2000").then()
                .statusCode(200);
        // test getting the contac


        given()
                .contentType("application/json")
                .body(account.getAccountNumber())
                .when().post("/withdraw/2304c/1000").then()
                .statusCode(200);



        given()
                .when()

                .get("account/2304c")
                .then()
                .contentType(ContentType.JSON)
                .and()
                .body("balance",equalTo(1000F));

        //cleanup
        given()
                .when()
                .delete("account/2304c");
    }




    @Test
    public void testBalance() {
        // add the contact to be fetched

        float   balance= 2000;
        given()
                .contentType("application/json")

                .when().post("/account/2304c/Karl").then()

                .statusCode(200);
        // test getting the contact

        given()
                .contentType("application/json")

                .when().post("/deposit/2304c/2000").then()
                .statusCode(200);
        // test getting the contac


        given()
                .contentType("application/json")

                .when().post("/withdraw/2304c/1000").then()
                .statusCode(200);



        given()
                .when()

                .get("/balance/2304c")
                .then()
                .contentType(ContentType.JSON)
                .and()
                .body("balance",equalTo(1000F));

        //cleanup
        given()
                .when()
                .delete("account/2304c");
    }


    @Test
    public void testTransaction() {
        // add the contact to be fetched
        Account account = new Account("2304c", "Karl",0);

        float   balance= 2000;
        given()
                .contentType("application/json")

                .when().post("/account/2304c/Karl").then()

                .statusCode(200);
        // test getting the contact

        given()
                .contentType("application/json")

                .when().post("/deposit/2304c/2000").then()
                .statusCode(200);
        // test getting the contac


        given()
                .contentType("application/json")

                .when().post("/withdraw/2304c/1000").then()
                .statusCode(200);



        given()
                .when()

                .get("/account/2304c")
                .then()
                .contentType(ContentType.JSON)
                .and()
                .body("balance",equalTo(1000F));




        //cleanup
        given()
                .when()
                .delete("account/2304c");
    }



    @Test
    public void testRemoveAccount() {
        // add the contact to be fetched
        Account account = new Account("2304c", "Karl",0);
        given()
                .contentType("application/json")

                .when().post("/account/2304c/Karl").then()
                .statusCode(200);
        // test getting the contact
        given()
                .when()
                .delete("/account/2304c");


       given()

         .when()
                .get("account/2304c")
                .then()
                .statusCode(200);

        //cleanup
        given()
                .when()
                .delete("account/2304c");
    }

}
