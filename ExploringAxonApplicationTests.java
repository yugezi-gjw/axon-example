package exploringaxon;

import com.varian.ois.sample.ExploringAxonApplication;
import com.varian.ois.sample.exploringaxon.api.command.CreditAccountCommand;
import com.varian.ois.sample.exploringaxon.api.command.DebitAccountCommand;
import com.varian.ois.sample.exploringaxon.api.event.AccountCreatedEvent;
import com.varian.ois.sample.exploringaxon.api.event.AccountCreditedEvent;
import com.varian.ois.sample.exploringaxon.api.event.AccountDebitedEvent;
import com.varian.ois.sample.exploringaxon.commandhandler.CreditAccountHandler;
import com.varian.ois.sample.exploringaxon.commandhandler.DebitAccountHandler;
import com.varian.ois.sample.exploringaxon.model.Account;
import org.axonframework.test.FixtureConfiguration;
import org.axonframework.test.Fixtures;
import org.junit.*;
import org.junit.runner.*;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = ExploringAxonApplication.class)
@WebAppConfiguration
public class ExploringAxonApplicationTests {

	private FixtureConfiguration fixture;
	private String accountNo;

	@Before
	public void setUp() {
		fixture = Fixtures.newGivenWhenThenFixture(Account.class);
//		fixture.registerAnnotatedCommandHandler(new CreditAccountHandler(fixture.getRepository()))
//			   .registerAnnotatedCommandHandler(new DebitAccountHandler(fixture.getRepository()));
		CreditAccountHandler creditAccountHandler = new CreditAccountHandler();
		creditAccountHandler.setRepository(fixture.getRepository());
		fixture.registerAnnotatedCommandHandler(creditAccountHandler);

		DebitAccountHandler debitAccountHandler = new DebitAccountHandler();
		debitAccountHandler.setRepository(fixture.getRepository());
		fixture.registerAnnotatedCommandHandler(debitAccountHandler);
		accountNo = "test-acc";
	}

	@Test
	public void testFirstDeposit() {
		fixture.given(new AccountCreatedEvent(accountNo))
			   .when(new CreditAccountCommand(accountNo, 100.00))
			   .expectEvents(new AccountCreditedEvent(accountNo, 100.00, 0.0));

	}

	@Test
	public void testFirstSecondDeposit() {
		fixture.given(new AccountCreatedEvent(accountNo),
					  new AccountCreditedEvent(accountNo, 100.00, 0.0))
			   .when(new CreditAccountCommand(accountNo, 40.00))
			   .expectEvents(new AccountCreditedEvent(accountNo, 40.00, 100.00));
	}

	@Test
	public void testCreditingDebitingAndCrediting() {
		fixture.given(new AccountCreatedEvent(accountNo),
					  new AccountCreditedEvent(accountNo, 100.00, 0.0),
					  new AccountDebitedEvent(accountNo, 40.00, 100.0))
			   .when(new CreditAccountCommand(accountNo, 40.00))
			   .expectEvents(new AccountCreditedEvent(accountNo, 40.00, 60.00));
	}

	@Test
	public void cannotCreditWithAMoreThanMillion() {
		fixture.given(new AccountCreatedEvent(accountNo))
			   .when(new CreditAccountCommand(accountNo, 10000000.00))
			   .expectException(IllegalArgumentException.class);
	}

	@Test
	public void cannotDebitAccountWithZeroBalance() {
		fixture.given(new AccountCreatedEvent(accountNo))
			   .when(new DebitAccountCommand(accountNo, 1.0))
			   .expectException(IllegalArgumentException.class);
	}

}
