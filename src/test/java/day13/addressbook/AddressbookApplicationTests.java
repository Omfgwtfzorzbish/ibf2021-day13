package day13.addressbook;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import day13.addressbook.data.ContactDetails;

@SpringBootTest
class AddressbookApplicationTests {

	@Test
	void contextLoads() {
		ContactDetails contact = new ContactDetails();
		contact.setEmail("hotmail");
		contact.setName("Brian");
		contact.setPhone("912195219");
		assertTrue(contact.getEmail().equals("hotmail"));
		assertTrue(contact.getName().equals("Brian"));
		assertTrue(contact.getPhone().equals("912195219"));
	}

}
