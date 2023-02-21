package nl.capital.yc2209fsvrijdag.integrationtest;

import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;

import nl.capital.yc2209fsvrijdag.domein.Chat;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("integrationtest")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ChatIntegrationTest {
    @Autowired
    private TestRestTemplate restTemplate;

    private static long lastId = -1;

    @Test
    @Order(1)
    public void testPost() {

        // Given
        Chat presentationToBePosted = new Chat();
        presentationToBePosted.setText("Java for us");

        // When
        ResponseEntity<Chat> result = this.restTemplate.postForEntity("/ditgaanweopslaan", presentationToBePosted, Chat.class);

        // Then
        assertEquals(200, result.getStatusCode().value());

        // And
        Chat presentation = result.getBody();
        assertEquals("Java for us", presentation.getText());
        System.err.println(presentation.getId());

       lastId = presentation.getId();
    }
    @Test
    @Order(2)
    public void testList() {

        // Arrange
        HttpHeaders headers = new HttpHeaders();
        headers.set("accept", "application/json");
        HttpEntity requestEntity = new HttpEntity<>(null, headers);

        // Act
        ResponseEntity<List<Chat>> response = restTemplate.exchange("/EenHeleLijst",
                HttpMethod.GET,
                requestEntity,
                new ParameterizedTypeReference<List<Chat>>() {
                });
        List<Chat> responseBodyAsList = response.getBody();

        // Assert
        assertEquals(1, responseBodyAsList.size());
        assertEquals("Java for us", responseBodyAsList.get(0).getText());
    }

    @Test
    @Order(3)
    public void testFindById() {

        // Given

        // When
        ResponseEntity<Chat> resultFromGet = this.restTemplate.getForEntity("/specifieke/"+lastId, Chat.class);

        // Then
        assertEquals(200, resultFromGet.getStatusCode().value());
        Chat presentationFromGetById = resultFromGet.getBody();

        assertEquals("Java for us", presentationFromGetById.getText());
    }

    


}

/*

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("integrationtest")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class PresentationApiIT {

    @Autowired
    private TestRestTemplate restTemplate;

    private static long lastId = -1;

    @Test
    @Order(1)
    public void testPost() {

        // Given
        Presentation presentationToBePosted = new Presentation();
        presentationToBePosted.setTitle("Java for us");

        // When
        ResponseEntity<Presentation> result = this.restTemplate.postForEntity("/api/presentations", presentationToBePosted, Presentation.class);

        // Then
        assertEquals(200, result.getStatusCode().value());

        // And
        Presentation presentation = result.getBody();
        assertEquals("Java for us", presentation.getTitle());
        System.err.println(presentation.getId());

       lastId = presentation.getId();
    }

    @Test
    @Order(2)
    public void testList() {

        // Arrange
        HttpHeaders headers = new HttpHeaders();
        headers.set("accept", "application/json");
        HttpEntity requestEntity = new HttpEntity<>(null, headers);

        // Act
        ResponseEntity<List<Presentation>> response = restTemplate.exchange("/api/presentations",
                HttpMethod.GET,
                requestEntity,
                new ParameterizedTypeReference<List<Presentation>>() {
                });
        List<Presentation> responseBodyAsList = response.getBody();

        // Assert
        assertEquals(1, responseBodyAsList.size());
        assertEquals("Java for us", responseBodyAsList.get(0).getTitle());
    }

    @Test
    @Order(3)
    public void testFindById() {

        // Given

        // When
        ResponseEntity<Presentation> resultFromGet = this.restTemplate.getForEntity("/api/presentations/"+lastId, Presentation.class);

        // Then
        assertEquals(200, resultFromGet.getStatusCode().value());
        Presentation presentationFromGetById = resultFromGet.getBody();

        assertEquals("Java for us", presentationFromGetById.getTitle());
    }
    
    
*/
