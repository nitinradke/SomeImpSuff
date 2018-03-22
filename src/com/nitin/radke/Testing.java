package com.nitin.radke;

public class Testing {
	long getTesting(String name) throws Exception {
		Testingjdbc testingjdbc =new Testingjdbc();
		return(testingjdbc.getInfo("nitin"));
		
	}

}
