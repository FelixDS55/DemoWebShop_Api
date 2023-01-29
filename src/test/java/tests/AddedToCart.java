package tests;

import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.hamcrest.Matchers.is;

import static io.restassured.RestAssured.given;

public class AddedToCart {
    @BeforeAll
    public static void setUp(){
        RestAssured.baseURI = "https://demowebshop.tricentis.com";
    }

    @Test
    void addedToCartTest(){
        String cookieValue = "16E6178BA7BC2E3E0114AC361733F947A2A706" +
                "4C152D3E5D6CC3C0F7BFE1768DCDC5A0997C2D9AC" +
                "8BE2B47D1EAC5BC4FB32287A34F86DC888C03C9F2" +
                "C2472F58B6C09BDB2C762E87CF304C9F31730662" +
                "7E778EE38E66E9BCB34CBE9B305715736050330921" +
                "6DACF18DA200772156770B33F7C09866B4020FEA3656EAE5618D54A09142108BE3F9230D77F9ECC0959E6C";
        String body = "addtocart_45.EnteredQuantity = 1";
        given()
                .contentType("application/x-www-form-urlencoded; charset=UTF-8")
                .cookie("NOPCOMMERCE.AUTH", cookieValue)
                .body(body)
                .when()
                .post("/addproducttocart/details/45/1")
                .then()
                .statusCode(200)
                .log().all()
                .body("success", is(true))
                .body("message", is("The product has been added to your <a href=\\\"/cart\\\">shopping cart</a>"));
    }
}
