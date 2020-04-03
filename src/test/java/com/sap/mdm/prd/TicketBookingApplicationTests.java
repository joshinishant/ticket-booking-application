package com.sap.mdm.prd;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class TicketBookingApplicationTests {

	@Test
	public void sampleTest(){
	    Assert.assertTrue(true);
    }


	@Test
	public void sampleFailureTest(){
		Assert.assertFalse(false);
	}



}
