package se.home.controller;

import org.hamcrest.Matchers;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;

import static io.restassured.RestAssured.when;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class PersonControllerTest {

    @LocalServerPort
    private Integer port;

    @Test
    public void log_persons_body() throws Exception {
        when()
                .get("http://localhost:" + port + "/person")
                .then()
                .log();
    }

    @Test
    public void verify_that_first_person_is_named_anders_andersson() throws Exception {
        when()
                .get("http://localhost:" + port + "/person")
                .then()
                .assertThat()
                .body("lastname[0]", Matchers.equalTo("Andersson"))
                .body("firstname[0]", Matchers.equalTo("Anders"));
    }

    @Test
    public void verify_that_second_person_is_named_anna_annason() throws Exception {
        when()
                .get("http://localhost:" + port + "/person")
                .then()
                .assertThat()
                .body("lastname[1]", Matchers.equalTo("Annason"))
                .body("firstname[1]", Matchers.equalTo("Anna"));
    }
}