package mocks.ejercicio1;

import org.junit.jupiter.api.Test;

import static org.easymock.EasyMock.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestEjercicio1 {

    //Test1: if(fileName.length()<8) = true, filename.length() = 7.
    @Test
    public void test1(){
        IEmailService emailService = createMock(IEmailService.class);
        IWebService webService = createMock(IWebService.class);
        LogAnalyzer logAnalyzer = new LogAnalyzer();
        logAnalyzer.setEmailService(emailService);
        logAnalyzer.setWebService(webService);

        logAnalyzer.analyze("Hola :)");
    }

    //Test2: if(fileName.length() >= 8) = false, filename.length() = 10.
    @Test
    public void test2(){
        IEmailService emailService = createMock(IEmailService.class);
        IWebService webService = createMock(IWebService.class);
        LogAnalyzer logAnalyzer = new LogAnalyzer();
        logAnalyzer.setEmailService(emailService);
        logAnalyzer.setWebService(webService);

        logAnalyzer.analyze("Hola mundo");
    }

    //Test con clase fake mock de IWebService, para que se ejecute el metodo de email.sendEmail(),
    //le hice override a el metodo logError y puse que tire una exception, asi el catch la atrapaba.
    @Test
    public void test3(){
        IEmailService emailService = createMock(IEmailService.class);
        IWebService webService = new FakeIWebService();
        LogAnalyzer logAnalyzer = new LogAnalyzer();
        logAnalyzer.setEmailService(emailService);
        logAnalyzer.setWebService(webService);

        logAnalyzer.analyze("Hola :)");
    }

}
