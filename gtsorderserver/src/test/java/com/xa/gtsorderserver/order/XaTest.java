package com.xa.gtsorderserver.order;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.xa.gtsorderserver.bootstrap.GTSOrderServerApplication;
import com.xa.gtsorderserver.xa.XAService;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes=GTSOrderServerApplication.class)
public class XaTest {

	@Autowired
	private XAService xaService;
	
	@Test
	public void testGetConnection() throws Exception{
		xaService.getXaConnection();
	}
	
	@Test
	public void testCommit() throws Exception{
		xaService.commit();
	}
	
	@Test
	public void rollback() throws Exception{
		xaService.rollback();
	}
}
