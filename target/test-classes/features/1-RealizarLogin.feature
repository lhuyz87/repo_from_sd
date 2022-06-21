@tag
Feature: Feature para el acceso a la aplicacion SeguriSign

  @Login
  Scenario Outline: Validar el correcto acceso al portal SeguriSign
    Given inicio  la pagina del portal
    When ingreso el usuario "<usuario>"
    And selecciono continuar "continuar"
    When ingreso password "<password>"
    And selecciono opcion "Ingresar"

    # Then se valida el correcto acceso
    Examples: 
      | usuario                           | password   |
      | usuariopruebaitera@seguridata.com | 1T3ra.2022 |
