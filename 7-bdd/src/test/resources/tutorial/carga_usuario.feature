Feature: Validacion de carga de usuarios

    Scenario: Campo nombre usuario null - debe fallar
        Given El manager ha sido creado
        And el nombre usuario es null
        And un email valido test@mail.com
        And una edad valida de 25
        When intento carga el user
        Then debe lanzar IllegalArgumentException con mensaje El nombre no puede estar vacío

    Scenario: Campo email sin @ - debe fallar
        Given El manager ha sido creado
        And tengo un usuario con nombre juan
        And tengo un email invalido sin @ testmail.com
        And una edad valida de 25
        When intento carga el user
        Then debe lanzar IllegalArgumentException con mensaje Email inválido

    Scenario: Campo edad fuera de 0 y 150 - debe fallar
        Given El manager ha sido creado
        And tengo un usuario con nombre juan
        And un email valido test@mail.com
        And tengo una edad de -1
        When intento carga el user
        Then debe lanzar IllegalArgumentException con mensaje Edad inválida

    Scenario: Todos los campos bien
        Given El manager ha sido creado
        And tengo un usuario con nombre juan
        And un email valido test@mail.com
        And una edad valida de 25
        When intento carga el user
        Then Se carga correctamente el user en el manager
        And debe tener un Id asignado