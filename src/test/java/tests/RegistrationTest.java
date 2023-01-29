package tests;

import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;
import static io.restassured.RestAssured.given;
import static spec.Spec.request;

public class RegistrationTest {
    @Test
    void registrationNewAccount(){
        step("Check registration new user", ()->{
            given()
                    .spec(request)
                    .formParam("Gender", "M")
                    .formParam("FirstName", "Mike")
                    .formParam("LastName", "Maers")
                    .formParam("Email", "159753zaq@mail.ru")
                    .formParam("Password", "qwerty123")
                    .formParam("ConfirmPassword", "qwerty123")
                    .formParam("register-button", "Register")
                    .when()
                    .post("/register")
                    .then().statusCode(302)
                    .log().headers()
                    .log().cookies()
                    .log().body()
                    .extract()
                    .cookie("NOPCOMMERCE.AUTH");
        });

        step("Login account", ()->{
            given()
                    .spec(request)
                    .formParam("Email", "159753zaq@mail.ru")
                    .formParam("Password", "qwerty123")
                    .when()
                    .post("/login")
                    .then().statusCode(302)
                    .log().all()
                    .extract()
                    .response();
        });
    }
}
