
Feature: Operaciones sobre usuarios

    Background:
        Given El manager ha sido creado
        And tengo usuarios cargados en el sistema

    Scenario: Busco un usuario existente por ID
        Given tengo un usuario con ID 1
        When quiero buscar si existe un usuario con ID 1
        Then deberia encontrarlo
        And el usuario debe tener nombre juan
    
    Scenario: Busco un usuario inexistente por ID
        Given tengo un usuario con ID 999 que no existe
        When quiero buscar si existe el usuario con ID 999
        Then no deberia encontrarlo
        
    Scenario: Busco usuarios en rangos de edad existentes
        Given tengo un usuario con edad 10
        And tengo un usuario con edad 20
        When quiero buscar si existen usuarios entre 10 y 20 años
        Then deberia encontrarlos
        And la lista resultante debe tener tamaño 2
        And mis usuarios se deben llamar juan y pedro

    Scenario: Busco usuarios en rangos de edad inexistentes
        Given tengo un usuario con edad 40 inexistente
        And tengo un usuario con edad 80 inexistente
        When quiero buscar si existen usuarios entre 40 y 80
        Then no deberia encontrarlos y lista tamaño 0

    Scenario: Quiero eliminar un usuario existente
        Given tengo un usuario con ID 1
        And tengo un usuario con ID 2
        When quiero eliminar el usuario con ID 1
        Then el usuario se deberia eliminar lanzando true
        And el contador de usuarios debe ser 1

    Scenario: Quiero eliminar un usuario inexistente
        Given tengo un usuario con ID 999 que no existe
        When quiero eliminar el usuario con ID 999
        Then el usuario no debe eliminarse y lanzar false