package ru.netology.rest;

import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

class MobileBankApiTestCurrency {
    @Test
    void shouldCheckCurrency() {
        // Given - When - Then
        // Предусловия
        given()
                .baseUri("http://localhost:9999/api/v1")
                // Выполняемые действия
                .when()
                .get("/demo/accounts")
                // Проверки
                .then()
                .statusCode(200)
                // специализированные проверки - лучше
                .contentType(ContentType.JSON)
                .body("", hasSize(3))
                .body("[0].currency", equalTo("RUB"))
                .body("[0].balance", greaterThanOrEqualTo(0))

                // Проверка на соответсвие валют
                .body("[0].currency", equalTo("RUB"))
                .body("[1].currency", equalTo("USD"))
                .body("[2].currency", equalTo("RUB"))
        ;
    }
}
