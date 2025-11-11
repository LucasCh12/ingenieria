package tutorial;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

public class StepDefinitions {

	private Calendar calendar;	
	private boolean res;
	
	@Given("Today is Sunday")
	public void today_is_sunday() {
		calendar = new Calendar();
		calendar.setDay(Day.SUNDAY);
	}

	@Given("Today is Friday")
	public void today_is_friday(){
		calendar = new Calendar();
		calendar.setDay(Day.FRIDAY);
	}

	@Given("Today is Monday")
	public void today_is_monday(){
		calendar = new Calendar();
		calendar.setDay(Day.MONDAY);
	}

	@When("I ask the system whether it's Wednesday")
	public void i_ask_the_system_whether_it_s_wednesday() {
		res = calendar.askTodayIs(Day.WEDNESDAY);
	}

	@When("I ask the system whether it's Friday")
	public void i_ask_the_system_whether_it_s_friday() {
		res = calendar.askTodayIs(Day.FRIDAY);
	}

	@Then("The answer should be true")
	public void the_answer_should_be_true() {
		assertThat(res).isTrue();
	}

	@Then("The answer should be false")
	public void the_answer_should_be_false() {
		assertThat(res).isFalse();
	}

	/*------------------------------------------------------------------------------------------------------------- */
	/*Parte repaso */

	/**
	 * Consejo: 
		// En tus steps, asegúrate de:
		private Exception exception;  // Para capturar excepciones

		@When("intento carga el user")
		public void intento_carga_user(){
			try {
				manager.addUserRepaso(nombre, email, edad);
				exception = null;
			} catch (IllegalArgumentException e) {
				exception = e;
			}
		}

		@Then("debe lanzar IllegalArgumentException con mensaje {string}")
		public void verificar_excepcion(String mensajeEsperado) {
			assertNotNull(exception);
			assertEquals(mensajeEsperado, exception.getMessage());
		}
	 */

	private UserManagerRepaso manager;
	private UserRepaso user;
	private String nombreUsuario;
	private String email;
	private int edad;
	private Exception exception;
	private int id;
	private List<UserRepaso> lista;

	@Given("El manager ha sido creado")
	public void manager_creado(){
		manager = new UserManagerRepaso();
	}

	@And("el nombre usuario es null")
	public void nombre_usuario_null(){
		nombreUsuario = null;
	}

	@And("un email valido test@mail.com")
	public void email_valido(){
		email = "test@mail.com";
	}

	@And("una edad valida de 25")
	public void edad_valida(){
		edad = 25;
	}

	@And("tengo un usuario con nombre juan")
	public void nombre_juan(){
		nombreUsuario = "juan";
	}

	@And("tengo una edad de -1")
	public void edad_negativa(){
		edad = -1;
	}

	@And("tengo un email invalido sin @ testmail.com")
	public void email_sin_arroba(){
		email = "testmail.com";
	}

	@When("intento carga el user")
	public void intento_carga_user(){
		try{
			user = manager.addUserRepaso(nombreUsuario, email, edad);	
			exception = null;
		} catch (IllegalArgumentException e){
			this.exception = e;
		}
	}

	@Then("debe lanzar IllegalArgumentException con mensaje El nombre no puede estar vacío")
	public void exception_user(){
		assertNotNull(exception, "Debería haberse lanzado una excepción");
		assertEquals("El nombre no puede estar vacío", exception.getMessage());
	}

	@Then("debe lanzar IllegalArgumentException con mensaje Email inválido")
	public void exception_email(){
		assertNotNull(exception, "Debería haberse lanzado una excepción");
		assertEquals("Email inválido", exception.getMessage());
	}

	@Then("debe lanzar IllegalArgumentException con mensaje Edad inválida")
	public void exception_edad(){
		assertNotNull(exception, "Debería haberse lanzado una excepción");
		assertEquals("Edad inválida", exception.getMessage());
	}

	@Then("Se carga correctamente el user en el manager")
	public void user_cargado_correctamente(){
		assertNull(exception);
	}

	@And("debe tener un Id asignado")
	public void id_asignado(){
		assertEquals(1,user.getId());
	}

	/*************************************************************************************************** */

	@And("tengo usuarios cargados en el sistema")
	public void usuarios_cargados(){
		manager.addUserRepaso("juan", "juan@mail.com", 10);
		manager.addUserRepaso("pedro", "pedro@mail.com", 20);
	}

	@Given("tengo un usuario con ID 1")
	public void usuario_id_1(){
		return;
	}

	@When("quiero buscar si existe un usuario con ID 1")
	public void usuario_existe_id_1(){
		id = 1;
		user = manager.findUserRepasoById(id);
	}

	@Then("deberia encontrarlo")
	public void user_encontrado(){
		assertNotNull(user);
	}

	@And("el usuario debe tener nombre juan")
	public void usuario_juan(){
		assertEquals("juan",user.getName());
	}

	@Given("tengo un usuario con ID 999 que no existe")
	public void user_id_999(){
		return;
	}

	@When("quiero buscar si existe el usuario con ID 999")
	public void busco_id_999(){
		user = manager.findUserRepasoById(999);
	}

	@Then("no deberia encontrarlo")
	public void no_encuentra_user_999(){
		assertNull(user);
	}

	@Given("tengo un usuario con edad 10")
	public void usuario_edad_10(){
		return;
	}

	@And("tengo un usuario con edad 20")
	public void usuario_edad_20(){
		return;
	}

	@When("quiero buscar si existen usuarios entre 10 y 20 años")
	public void busco_range_10_20(){
		lista = manager.findUserRepasosByAgeRange(10,20);
	}

	@Then("deberia encontrarlos")
	public void encuentra_range_10_20(){
		assertNotNull(lista);
	}

	@And("la lista resultante debe tener tamaño 2")
	public void lista_tamaño_2(){
		assertEquals(2,lista.size());
	}

	@And("mis usuarios se deben llamar juan y pedro")
	public void usuarios_juan_y_pedro(){
		assertEquals("juan",lista.get(0).getName());
		assertEquals("pedro",lista.get(1).getName());
	}

	@Given("tengo un usuario con edad 40 inexistente")
	public void usuario_edad_40(){
		return;
	}

	@And("tengo un usuario con edad 80 inexistente")
	public void usuario_edad_80(){
		return;
	}

	@When("quiero buscar si existen usuarios entre 40 y 80")
	public void busco_range_40_80(){
		lista = manager.findUserRepasosByAgeRange(40,80);
	}

	@Then("no deberia encontrarlos y lista tamaño 0")
	public void lista_no_range_40_80(){
		assertEquals(0,lista.size());
	}

	@And("tengo un usuario con ID 2")
	public void user_id_2(){
		return;
	}

	@When("quiero eliminar el usuario con ID 1")
	public void elimino_user_id_1(){
		res = manager.deleteUserRepaso(1);
	}

	@Then("el usuario se deberia eliminar lanzando true")
	public void elimina_user_id__1(){
		assertTrue(res);
	}

	@And("el contador de usuarios debe ser 1")
	public void contador_users_1(){
		assertEquals(1,manager.getUserRepasoCount());
	}

	@When("quiero eliminar el usuario con ID 999")
	public void eliminar_user_999(){
		res = manager.deleteUserRepaso(999);
	}

	@Then("el usuario no debe eliminarse y lanzar false")
	public void user_999_no_eliminado(){
		assertFalse(res);
	}

	
}
