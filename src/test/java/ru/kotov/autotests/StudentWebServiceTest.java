package ru.kotov.autotests;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import lombok.SneakyThrows;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Set;

public class StudentWebServiceTest {
    String host = "http://localhost:8080";

    @Test
    @DisplayName("Задание №1")
    @SneakyThrows
    void Test1() {
        Student student = new Student();
        student.setName("Bob");
        student.setId(1);
        ObjectMapper mapper = new ObjectMapper();
        RestAssured.given()
                .baseUri(host + "/student/")
                .contentType(ContentType.JSON)
                .body(mapper.writeValueAsString(student))
                .when()
                .post();

        Student studentFromRequest = RestAssured.given()
                .baseUri(host + "/student/" + 1)
                .contentType(ContentType.JSON)
                .when()
                .get()
                .then()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .extract()
                .as(Student.class);
        Assertions.assertEquals(studentFromRequest, student);

        RestAssured.given()
                .baseUri(host + "/student/" + 1)
                .contentType(ContentType.JSON)
                .body(mapper.writeValueAsString(student))
                .when()
                .delete();
    }

    @Test
    @DisplayName("Задание №2")
    void Test2() {
        RestAssured.given()
                .baseUri(host + "/student/" + 100)
                .contentType(ContentType.JSON)
                .when()
                .get()
                .then()
                .statusCode(404);
    }

    @Test
    @DisplayName("Задание №3")
    @SneakyThrows
    void Test3() {
        Student student = new Student();
        student.setName("Bob");
        student.setId(1);
        ObjectMapper mapper = new ObjectMapper();
        RestAssured.given()
                .baseUri(host + "/student/")
                .contentType(ContentType.JSON)
                .body(mapper.writeValueAsString(student))
                .when()
                .post()
                .then()
                .statusCode(201);
        RestAssured.given()
                .baseUri(host + "/student/" + 1)
                .contentType(ContentType.JSON)
                .body(mapper.writeValueAsString(student))
                .when()
                .delete();
    }

    @Test
    @DisplayName("Задание №4")
    @SneakyThrows
    void Test4() {
        Student student = new Student();
        student.setName("Andrew");
        student.setId(1);
        ObjectMapper mapper = new ObjectMapper();
        RestAssured.given()
                .baseUri(host + "/student/")
                .contentType(ContentType.JSON)
                .body(mapper.writeValueAsString(student))
                .when()
                .post()
                .then()
                .statusCode(201);
        RestAssured.given()
                .baseUri(host + "/student/" + 1)
                .contentType(ContentType.JSON)
                .body(mapper.writeValueAsString(student))
                .when()
                .delete();
    }
    @Test
    @DisplayName("Задание №4.1")
    @SneakyThrows
    void Test4_1() {
        Student student = new Student();
        student.setName(null);
        student.setId(50);
        ObjectMapper mapper = new ObjectMapper();
        RestAssured.given()
                .baseUri(host + "/student/")
                .contentType(ContentType.JSON)
                .body(mapper.writeValueAsString(student))
                .when()
                .post()
                .then()
                .statusCode(400);
        RestAssured.given()
                .baseUri(host + "/student/" + 50)
                .contentType(ContentType.JSON)
                .body(mapper.writeValueAsString(student))
                .when()
                .delete();
    }
    @Test
    @DisplayName("Задание №5")
    @SneakyThrows
    void Test5() {
        Student student = new Student();
        student.setName("Andrew");
        student.setId(null);
        ObjectMapper mapper = new ObjectMapper();
        String body = RestAssured.given()
                .baseUri(host + "/student/")
                .contentType(ContentType.JSON)
                .body(mapper.writeValueAsString(student))
                .when()
                .post()
                .then()
                .statusCode(201)
                .extract()
                .body()
                .as(String.class);

        try {
            int id = Integer.valueOf(body);
            Assertions.assertEquals(1, id);

        } catch (NumberFormatException e) {
            Assertions.fail("В теле ответа нет числа: " + e.getMessage());
        }
        RestAssured.given()
                .baseUri(host + "/student/" + 1)
                .contentType(ContentType.JSON)
                .body(mapper.writeValueAsString(student))
                .when()
                .delete()
                .then();
    }

    @Test
    @DisplayName("Задание №6")
    @SneakyThrows
    void Test6() {
        Student student = new Student();
        ObjectMapper mapper = new ObjectMapper();
        RestAssured.given()
                .baseUri(host + "/student/")
                .contentType(ContentType.JSON)
                .body(mapper.writeValueAsString(student))
                .when()
                .post()
                .then()
                .statusCode(400);
    }

    @Test
    @DisplayName("Задание №7")
    @SneakyThrows
    void Test7() {
        Student student = new Student();
        student.setName("Andrew");
        student.setId(1);
        ObjectMapper mapper = new ObjectMapper();
        RestAssured.given()
                .baseUri(host + "/student/")
                .contentType(ContentType.JSON)
                .body(mapper.writeValueAsString(student))
                .when()
                .post();

        RestAssured.given()
                .baseUri(host + "/student/" + 1)
                .contentType(ContentType.JSON)
                .body(mapper.writeValueAsString(student))
                .when()
                .delete()
                .then()
                .statusCode(200);
    }

    @Test
    @DisplayName("Задание №8")
    @SneakyThrows
    void Test8() {
        Student student = new Student();
        ObjectMapper mapper = new ObjectMapper();
        RestAssured.given()
                .baseUri(host + "/student/" + 200)
                .contentType(ContentType.JSON)
                .body(mapper.writeValueAsString(student))
                .when()
                .delete()
                .then()
                .statusCode(404);
    }

    @Test
    @DisplayName("Задание №9")
    @SneakyThrows
    void Test9() {
        RestAssured.given()
                .baseUri(host + "/topStudent")
                .contentType(ContentType.JSON)
                .when()
                .get()
                .then()
                .statusCode(200)
                .body(Matchers.equalToObject(new String("")));
    }

    @Test
    @DisplayName("Задание №10")
    @SneakyThrows
    void Test_10() {
        Student student1 = new Student();
        student1.setName("Bob");
        student1.setId(1);
        Student student2 = new Student();
        student2.setName("Alice");
        student2.setId(2);

        ObjectMapper mapper = new ObjectMapper();
        RestAssured.given()
                .baseUri(host + "/student/")
                .contentType(ContentType.JSON)
                .body(mapper.writeValueAsString(student1))
                .when()
                .post();
        RestAssured.given()
                .baseUri(host + "/student/")
                .contentType(ContentType.JSON)
                .body(mapper.writeValueAsString(student2))
                .when()
                .post();

        RestAssured.given()
                .baseUri(host + "/topStudent")
                .contentType(ContentType.JSON)
                .when()
                .get()
                .then()
                .statusCode(200)
                .body(Matchers.equalToObject(new String("")));

        RestAssured.given()
                .baseUri(host + "/student/" + 1)
                .contentType(ContentType.JSON)
                .when()
                .delete();
        RestAssured.given()
                .baseUri(host + "/student/" + 2)
                .contentType(ContentType.JSON)
                .when()
                .delete();
    }

    @Test
    @DisplayName("Задание №11")
    @SneakyThrows
    void Test_11() {
        Student student1 = new Student();
        student1.setName("Bob");
        student1.setId(1);
        student1.setMarks(List.of(2, 3, 4));
        Student student2 = new Student();
        student2.setName("Alice");
        student2.setId(2);
        student2.setMarks(List.of(2, 3, 5));

        ObjectMapper mapper = new ObjectMapper();
        RestAssured.given()
                .baseUri(host + "/student/")
                .contentType(ContentType.JSON)
                .body(mapper.writeValueAsString(student1))
                .when()
                .post();
        RestAssured.given()
                .baseUri(host + "/student/")
                .contentType(ContentType.JSON)
                .body(mapper.writeValueAsString(student2))
                .when()
                .post();

        List responseBody = RestAssured.given()
                .baseUri(host + "/topStudent")
                .contentType(ContentType.JSON)
                .when()
                .get()
                .then()
                .statusCode(200)
                .extract()
                .as(List.class);
        List<Student> studentsList = mapper.convertValue(responseBody, new TypeReference<List<Student>>() {
        });

        Assertions.assertEquals(List.of(student2), studentsList);

        RestAssured.given()
                .baseUri(host + "/student/" + 1)
                .contentType(ContentType.JSON)
                .when()
                .delete();
        RestAssured.given()
                .baseUri(host + "/student/" + 2)
                .contentType(ContentType.JSON)
                .when()
                .delete();
    }

    @Test
    @DisplayName("Задание №11.1 - еще один тест кейс")
    @SneakyThrows
    void Test_11_1() {
        Student student1 = new Student();
        student1.setName("Bob");
        student1.setId(1);
        student1.setMarks(List.of(2, 3));
        Student student2 = new Student();
        student2.setName("Alice");
        student2.setId(2);
        student2.setMarks(List.of(5));

        ObjectMapper mapper = new ObjectMapper();
        RestAssured.given()
                .baseUri(host + "/student/")
                .contentType(ContentType.JSON)
                .body(mapper.writeValueAsString(student1))
                .when()
                .post();
        RestAssured.given()
                .baseUri(host + "/student/")
                .contentType(ContentType.JSON)
                .body(mapper.writeValueAsString(student2))
                .when()
                .post();

        List responseBody = RestAssured.given()
                .baseUri(host + "/topStudent")
                .contentType(ContentType.JSON)
                .when()
                .get()
                .then()
                .statusCode(200)
                .extract()
                .as(List.class);
        List<Student> studentsList = mapper.convertValue(responseBody, new TypeReference<List<Student>>() {
        });

        Assertions.assertEquals(List.of(student2), studentsList);

        RestAssured.given()
                .baseUri(host + "/student/" + 1)
                .contentType(ContentType.JSON)
                .when()
                .delete();
        RestAssured.given()
                .baseUri(host + "/student/" + 2)
                .contentType(ContentType.JSON)
                .when()
                .delete();
    }

    @Test
    @DisplayName("Задание №12")
    @SneakyThrows
    void Test_12() {
        Student student1 = new Student();
        student1.setName("Bob");
        student1.setId(1);
        student1.setMarks(List.of(2, 3, 3, 3, 5));
        Student student2 = new Student();
        student2.setName("Alice");
        student2.setId(2);
        student2.setMarks(List.of(3, 3, 3, 3, 4));

        ObjectMapper mapper = new ObjectMapper();
        RestAssured.given()
                .baseUri(host + "/student/")
                .contentType(ContentType.JSON)
                .body(mapper.writeValueAsString(student1))
                .when()
                .post();
        RestAssured.given()
                .baseUri(host + "/student/")
                .contentType(ContentType.JSON)
                .body(mapper.writeValueAsString(student2))
                .when()
                .post();

        List responseBody = RestAssured.given()
                .baseUri(host + "/topStudent")
                .contentType(ContentType.JSON)
                .when()
                .get()
                .then()
                .statusCode(200)
                .extract()
                .as(List.class);
        Set<Student> studentsList = mapper.convertValue(responseBody, new TypeReference<Set<Student>>() {
        });
        System.out.println(studentsList);
        Assertions.assertEquals(Set.of(student1, student2), studentsList);

        RestAssured.given()
                .baseUri(host + "/student/" + 1)
                .contentType(ContentType.JSON)
                .when()
                .delete();
        RestAssured.given()
                .baseUri(host + "/student/" + 2)
                .contentType(ContentType.JSON)
                .when()
                .delete();
    }
    @Test
    @DisplayName("Задание №12.1")
    @SneakyThrows
    void Test_12_1() {
        Student student1 = new Student();
        student1.setName("Bob");
        student1.setId(1);
        student1.setMarks(List.of(5, 5, 5));
        Student student2 = new Student();
        student2.setName("Alice");
        student2.setId(2);
        student2.setMarks(List.of(3, 3, 3, 3, 3));

        ObjectMapper mapper = new ObjectMapper();
        RestAssured.given()
                .baseUri(host + "/student/")
                .contentType(ContentType.JSON)
                .body(mapper.writeValueAsString(student1))
                .when()
                .post();
        RestAssured.given()
                .baseUri(host + "/student/")
                .contentType(ContentType.JSON)
                .body(mapper.writeValueAsString(student2))
                .when()
                .post();

        List responseBody = RestAssured.given()
                .baseUri(host + "/topStudent")
                .contentType(ContentType.JSON)
                .when()
                .get()
                .then()
                .statusCode(200)
                .extract()
                .as(List.class);
        Set<Student> studentsList = mapper.convertValue(responseBody, new TypeReference<Set<Student>>() {
        });
        Assertions.assertEquals(Set.of(student1), studentsList);

        RestAssured.given()
                .baseUri(host + "/student/" + 1)
                .contentType(ContentType.JSON)
                .when()
                .delete();
        RestAssured.given()
                .baseUri(host + "/student/" + 2)
                .contentType(ContentType.JSON)
                .when()
                .delete();
    }
}
