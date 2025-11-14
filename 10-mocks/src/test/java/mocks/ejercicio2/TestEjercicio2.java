package mocks.ejercicio2;


import org.junit.jupiter.api.Test;

import static org.easymock.EasyMock.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class TestEjercicio2 {
    
    //a) Defina un test en el que se realice el login correctamente al segundo intento.
    @Test
    public void test1(){
        String ip = "1000";
        String userName = "lucas";
        String password = "lol123";
        String passwordHash = Utils.getPasswordHashMD5(password);
        
        IPBlacklist ipBlacklist = new IPBlacklist();
        LoginService loginService = createMock(LoginService.class);
        
        expect(loginService.login(ip, userName, passwordHash)).andReturn(false);

        expect(loginService.login(ip, userName, passwordHash))
            .andReturn(true);
        
        replay(loginService);
        ipBlacklist.setService(loginService);

        boolean primerResultado = ipBlacklist.login(ip, userName, password);
        
        boolean segundoResultado = ipBlacklist.login(ip, userName, password);

        assertFalse(primerResultado);
        assertTrue(segundoResultado);
        verify(loginService);
    }

    /**
     *   b) Defina un test en el que, después de 3 intentos fallidos con el mismo IP, se verifique que el
        IP figura en la lista negra.
     */
    @Test
    public void test2(){
        String ip = "1000";
        String userName = "lucas";
        String password = "lol123";
        String passwordHash = Utils.getPasswordHashMD5(password); 
        
        IPBlacklist ipBlacklist = new IPBlacklist();
        LoginService loginService = createMock(LoginService.class);
        
        expect(loginService.login(ip, userName, passwordHash))
            .andReturn(false);

        expect(loginService.login(ip, userName, passwordHash))
            .andReturn(false);

        expect(loginService.login(ip, userName, passwordHash))
            .andReturn(false);
        
        replay(loginService);
        ipBlacklist.setService(loginService);

        boolean primerResultado = ipBlacklist.login(ip, userName, password);
        
        boolean segundoResultado = ipBlacklist.login(ip, userName, password);

        boolean tercerResultado = ipBlacklist.login(ip,userName,password);

        assertFalse(primerResultado);
        assertFalse(segundoResultado);
        assertFalse(tercerResultado);

        assertTrue(ipBlacklist.blacklisted(ip));

        verify(loginService);
    }
    
    /*
     *  c) Cree un test en el que se verifique que si un mismo IP intenta loguearse menos de 3 veces,
        el IP no figura en la lista negra.
     */
    @Test
    public void test3(){    
        String ip = "1000";
        String userName = "lucas";
        String password = "lol123";
        String passwordHash = Utils.getPasswordHashMD5(password); 
        
        IPBlacklist ipBlacklist = new IPBlacklist();
        LoginService loginService = createMock(LoginService.class);
        
        expect(loginService.login(ip, userName, passwordHash))
            .andReturn(true);

        replay(loginService);

        ipBlacklist.setService(loginService);

        ipBlacklist.login(ip, userName, password);

        assertFalse(ipBlacklist.blacklisted(ip));
        
        verify(loginService);
    }

    @Test
    public void test4(){
        String ip = "1000";
        String userName = "lucas";
        String password = "lol123";
        String passwordHash = Utils.getPasswordHashMD5(password); 
        
        IPBlacklist ipBlacklist = new IPBlacklist();
        LoginService loginService = createMock(LoginService.class);
        
        expect(loginService.login(ip, userName, passwordHash))
            .andReturn(false);

        expect(loginService.login(ip, userName, passwordHash))
            .andReturn(false);

        expect(loginService.login(ip, userName, passwordHash))
            .andReturn(false);
        
        replay(loginService);
        ipBlacklist.setService(loginService);

        boolean primerResultado = ipBlacklist.login(ip, userName, password);
        
        boolean segundoResultado = ipBlacklist.login(ip, userName, password);

        boolean tercerResultado = ipBlacklist.login(ip,userName,password);

        boolean cuartoResultado = ipBlacklist.login(ip, userName, password);

        assertFalse(primerResultado);
        assertFalse(segundoResultado);
        assertFalse(tercerResultado);
        assertFalse(cuartoResultado);

        assertTrue(ipBlacklist.blacklisted(ip));

        verify(loginService);
    }

}
