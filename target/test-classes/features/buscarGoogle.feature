Feature: Buscar en Google
  Scenario: Ingresar y buscar algo en google
    Given Ingresar a la web de Google.com
    When Ingresar la palabra 'Gatitos' en el campo de busqueda
    And Presionar el boton de busqueda
    Then Validar Resultados