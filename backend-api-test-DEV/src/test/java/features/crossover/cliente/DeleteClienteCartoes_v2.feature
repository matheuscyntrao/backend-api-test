#language: pt
@cliente-service @plataforma
Funcionalidade: Cliente-v2-GetClientesCartao

  Esquema do Cenario: Delete Clientes Cartao v2 - <fluxo>
    Dado que efetuo Authorization - Token - Login para "<usuario>"
    E efetuo Cliente - v2 - PostClientesIdclienteCartoes para "<usuario>"


    @FB @regressao
    Exemplos:
      | fluxo | usuario                      |
      | FB    | neusinha_santos@yahoo.com.br |
