#language: pt
@gateway-pagamento-service
Funcionalidade: Plataforma - Payment Hash

  Esquema do Cenario: Payment Hash <fluxo>
    Dado possuo dados para Plataforma - Payment - Hash:
      | autoConfirmation   | channel   | customerId | filial | isAnalyzer   | origin    |
      | <autoConfirmation> | <channel> | 8280052    | 701    | <isAnalyzer> | ECOMMERCE |
    Dado possuo dados para Plataforma - Payment - Hash creditCard:
      | cardId | installmentType | installments |
      | 90013  | 4               | 1            |
    Dado possuo dados para Plataforma - Payment - Hash order:
      | amount   | externalOrderId   | telephone   |
      | <amount> | <externalOrderId> | 51996765432 |
    Dado possuo dados para Plataforma - Payment - Hash order antiFraudClient:
      | cpf         | mail        | name          |
      | 84018685050 | x@gmail.com | Carlos Xavier |
    Dado possuo dados para Plataforma - Payment - Hash order billingAddress:
      | city         | complement | district | number | street | uf | zipcode  |
      | Porto Alegre | apto       | Centro   | 100    | Rua A  | RS | 91350132 |
    Dado possuo dados para Plataforma - Payment - Hash order deliveryAddress:
      | city         | complement | district | number | street | uf | zipcode  |
      | Porto Alegre | apto       | Centro   | 100    | Rua A  | RS | 91350132 |
    Dado possuo dados para Plataforma - Payment - Hash order itens:
      | description | itemCode | name          | quantity | valueDiscountUnitary | valueUnitary |
      | Medical PRO | 1590860  | Product498586 | 4        | 0                    | 1            |
    Quando executo Plataforma - Payment - Hash
    Entao sistema processa Plataforma - Payment - Hash:
      | statusCode | 201 |


    @FB @regressao
    Exemplos:
      | fluxo             | autoConfirmation | isAnalyzer | channel | externalOrderId | amount |
      | FB - 2 = INTERNET | false            | true       | 2       | 8212212         | 4      |
      | FB - 2 = INTERNET | false            | true       | 2       | 8212215         | 4.80   |
      | FB - 2 = INTERNET | false            | true       | 2       | 8212213         | 4.30   |
