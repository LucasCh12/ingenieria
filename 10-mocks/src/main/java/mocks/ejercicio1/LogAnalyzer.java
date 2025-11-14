package mocks.ejercicio1;


public class LogAnalyzer {
	private IWebService service;

	private IEmailService email;

	public void setWebService(IWebService service) {
		this.service = service;
	}

	public void setEmailService(IEmailService email) {
		this.email = email;
	}

	public void analyze(String fileName) {
		if(fileName.length()<8) {
			try {
				service.logError("Filename too short:" + fileName);
			}
			//Este catch no se va a ejecutar a menos que se implemente logError tirando una exception.
			catch (Exception e) {
				email.sendEmail("a","subject",e.getMessage());
			}
		}
	}

	/*+
	 * Test para maximizar cobertura de ramas:
	 * Test1: if(fileName.length()<8) = true, filename.length() = 7.
	 * Test2: if(fileName.length() >= 8) = false, filename.length() = 10.
	 */
}

