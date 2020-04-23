package cl.mobdev.dog.service;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.mockserver.integration.ClientAndServer;
import static org.mockserver.integration.ClientAndServer.startClientAndServer;

public class BaseTest {
	private static ClientAndServer mockServer;
    
    @BeforeEach
    void startMockServer() {
    	mockServer = startClientAndServer(7000);
        Expectations.createDefaultExpectations(mockServer);
    }

    @AfterEach
    void after() {
        mockServer.stop();
    }
}
