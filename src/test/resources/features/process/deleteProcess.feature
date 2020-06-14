Feature:

  Background:
    Given the user is on the Agapito webpage
    And the user fills "vara" with value "<vara>"
    And the user fills "numero_processo" with value "2599"
    And the user fills "natureza" with value "Gasto"
    And the user fills "partes" with value "Gasto x Planejado"
    And the user fills "urgente" with value "N"
    And the user fills "arbitramento" with value "S"
    And the user fills "assistente_social" with value "Maria"
    And the user fills "data_entrada" with value "20-10-2019"
    And the user fills "data_saida" with value "20-10-2020"
    And the user fills "data_agendamento" with value ""
    And the user fills "status" with value "Em andamento"
    And the user fills "observacao" with value "Agendado com sucesso"
    And the user clicks on save button
    And the user update "observacao" with value "Atualizado com sucesso"

  Scenario: Delete as simple process
    Given the user clicks on update button
    When the user clicks on delete button
    Then user should see "no content" message

  Scenario: Delete with non-existent id.
    Given the user clicks on save button
    When the user clicks on delete button with invalid id
    Then user should see "not found" message

  Scenario: Delete as simple process with read after delete
    Given the user clicks on save button
    And the user clicks on delete button
    When the user clicks on read button
    Then user should see "not found" message