package test_scenarios_email;

public class ReadEmailTest {
	import org.junit.jupiter.api.Test;

	import static org.junit.jupiter.api.Assertions.assertEquals;
	import static org.mockito.Mockito.*;

	public class ReadMailExampleTest {

	    @Test
	    public void checkShouldPrintEmailDetails() throws Exception {
	        // Arrange
	        String host = "imap.gmail.com";
	        String mailStoreType = "imap";
	        String username = "yourmailaddress@gmail.com";
	        String password = "yourpassword";
	        String expected = "Subject: Test Email\nFrom: test@example.com\nText: This is a test email.";

	        Store mockStore = mock(Store.class);
	        Folder mockFolder = mock(Folder.class);
	        Message mockMessage = mock(Message.class);

	        when(mockStore.getFolder("Inbox")).thenReturn(mockFolder);
	        when(mockStore.getStore(anyString())).thenReturn(mockStore);
	        when(mockFolder.search(any())).thenReturn(new Message[]{mockMessage});
	        when(mockMessage.getSubject()).thenReturn("Test Email");
	        when(mockMessage.getFrom()).thenReturn(new Address[]{new InternetAddress("test@example.com")});
	        when(mockMessage.getContent()).thenReturn("This is a test email.");

	        // Act
	        ReadMailExample.check(host, mailStoreType, username, password);

	        // Assert
	        verify(mockFolder).open(Folder.READ_WRITE);
	        verify(mockFolder).close(false);
	        verify(mockStore).close();
	        assertEquals(expected, outContent.toString().trim());
	    }
	}
	@Test(expected = MessagingException.class)
	public void testInvalidHost() throws MessagingException {
	    ReadMailExample.check("invalid-host.com", "imap", "user", "pass");
	}
	@Test(expected = MessagingException.class)
	public void testInvalidCredentials() throws MessagingException {
	    ReadMailExample.check("imap.gmail.com", "imap", "user", "wrongpassword");
	}
	@Test
	public void testUnreadMessages() throws MessagingException {
	    ReadMailExample.check("imap.gmail.com", "imap", "user", "pass");
	    // assert that there are no unread messages in the inbox
	    // replace "expected" with the expected number of unread messages
	    int expected = 0;
	    Assert.assertEquals(expected, ReadMailExample.unreadMessages);
	}
	@Test
	public void testMarkAllAsRead() throws MessagingException {
	    ReadMailExample.check("imap.gmail.com", "imap", "user", "pass");
	    // assert that all unread messages have been marked as read
	    Assert.assertEquals(0, ReadMailExample.unreadMessages);
	}
	@Test
	public void testPrintMessages() throws MessagingException {
	    ReadMailExample.check("imap.gmail.com", "imap", "user", "pass");
	    // assert that the messages have been correctly printed
	    // replace "expected" with the expected number of printed messages
	    int expected = 10;
	    Assert.assertEquals(expected, ReadMailExample.printedMessages);
	}

}
