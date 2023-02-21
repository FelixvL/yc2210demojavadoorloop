package nl.capital.yc2209fsvrijdag.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import nl.capital.yc2209fsvrijdag.domein.Chat;
import nl.capital.yc2209fsvrijdag.persist.ChatRepository;
import nl.capital.yc2209fsvrijdag.persist.ChatService;

@SpringBootTest
public class ChatMockTest {
	@InjectMocks
	private ChatService chatService;
	
	@Mock
	private ChatRepository presentationRepository;
	
	public ChatMockTest() {
		MockitoAnnotations.openMocks(this);
		//this.presentationService = new PresentationService();
		
	}
	@Test
	public void testFindById() {
		String deTitel = "Wat een mooie Titel";
		Chat mockedPresentation = new Chat();
		mockedPresentation.setId(3L);
		mockedPresentation.setText(deTitel);
		
		// Given
		Optional<Chat> myoptional = Optional.of(mockedPresentation);
		Mockito.when(this.presentationRepository.findById(3L)).thenReturn(myoptional);
		
		// When
		Chat p = this.chatService.findById(3L);
		
		// Then
		assertNotNull(p);
		assertEquals(p.getId(), 3L);
		assertEquals(p.getText(), deTitel);
	}

}
