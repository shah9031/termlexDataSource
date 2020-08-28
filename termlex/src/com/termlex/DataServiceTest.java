package com.termlex;

import java.util.Collection;

import org.junit.jupiter.api.Test;

class DataServiceTest {
	DataService dataService;

	@Test
	void testDataService() {
		dataService = new DataService();
		System.out.println("working constructor");
	}

	@Test
	void testGetTermForId() {
		dataService = new DataService();
		System.out.println(dataService.getTermForId(1004));
		System.out.println("working getTermForId");
	}

	@Test
	void testSaveTerm() {
		dataService = new DataService();
		dataService.saveTerm("Term from app");
        dataService.saveTerm("Term from app again");
        dataService.saveTerm("Term from app once again");
        dataService.saveTerm("Seems like working now");
        System.out.println("working saveTerm");
	}

	@Test
	void testGetAllTerm() {
		dataService = new DataService();
		Collection<TermsData> l=dataService.getAllTerm();
        l.stream().forEach(System.out::println);
        System.out.println( "Number of terms : " + dataService.getAllTerm().size());
        System.out.println("working getAllTerm");
	}

}
