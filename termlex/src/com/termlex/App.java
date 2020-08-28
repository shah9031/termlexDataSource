package com.termlex;

import java.util.Collection;

//Test class to test the program manually
public class App {

    public static void main( String[] args ){
        DataService dataService = new DataService();
        System.out.println( "Number of terms : " + dataService.getAllTerm().size());
        Collection<TermsData> l=dataService.getAllTerm();
        l.stream().forEach(System.out::println);
        dataService.saveTerm("Term from app");
        dataService.saveTerm("Term from app again");
        dataService.saveTerm("Term from app once again");
        dataService.saveTerm("Seems like working now");
        dataService.saveTerm("Trying one more time");
        System.out.println( "Number of terms : " + dataService.getAllTerm().size());
        System.out.println(dataService.getTermForId(1004));
    }
}
