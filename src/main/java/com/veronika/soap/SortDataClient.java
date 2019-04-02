package com.veronika.soap;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;

public class SortDataClient {
    public static void main(String[] args) throws MalformedURLException {
        URL url = new URL("http://localhost:7779/ws/test?wsdl");

        QName qname = new QName("http://soap.veronika.com/", "SortDataImplService");
        Service service = Service.create(url, qname);
        SortData sortData = service.getPort(SortData.class);

        System.out.println("Please enter sentence. Example: aaa, cvf, dfr, vgct, aadf");

        Scanner in = new Scanner(System.in);
        String input = in.nextLine();
        String sortedData = sortData.getSortedData(input);

        System.out.println("input: " + input);
        System.out.println("output: " + sortedData);
    }
}