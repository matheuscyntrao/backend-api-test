#language: pt
@marketplace @skyhub-token
Funcionalidade: Marketplace validacao integracao de filial


  Esquema do Cenario: Integracao de Filiais

    Dado que efetuo MarketplaceSeller - v1 - PutFiliais:
      | filialCode | <filialcode> |
      | field      | <field>      |
      | value      | <value>      |
    Quando executo MarketplaceSeller - v1 - Filiais
    Então valido MarketplaceSeller - v1 - Filiais <filialcode>

    @FB @regressao
    Exemplos:
      | filialcode | field | value            |
      | 31         | name  | Teste integracao |
    @FA @regressao
    Exemplos:
      | filialcode | field                     | value            |
      | 31         | email                     | Teste integracao |
      | 31         | open_hours                | Teste integracao |
      | 31         | phone                     | Teste integracao |
      | 31         | latitude                  | 1                |
      | 31         | longitude                 | 2                |
      | 31         | max_delivery_distance     | 1.5              |
      | 31         | address.street            | Teste integracao |
      | 31         | address.number            | Teste integracao |
      | 31         | address.detail            | Teste integracao |
      | 31         | address.neighborhood      | Teste integracao |
      | 31         | address.city              | Teste integracao |
      | 31         | address.region            | Teste integracao |
      | 31         | address.post_code         | 96700000         |
      | 31         | address.reference         | Teste integracao |
      | 31         | schedules.monday.start    | 08:07            |
      | 31         | schedules.monday.end      | 09:40            |
      | 31         | schedules.tuesday.start   | 08:07            |
      | 31         | schedules.tuesday.end     | 09:40            |
      | 31         | schedules.wednesday.start | 08:07            |
      | 31         | schedules.wednesday.end   | 09:40            |
      | 31         | schedules.thursday.start  | 08:07            |
      | 31         | schedules.thursday.end    | 09:40            |
      | 31         | schedules.friday.start    | 08:07            |
      | 31         | schedules.friday.end      | 09:40            |
      | 31         | schedules.saturday.start  | 08:07            |
      | 31         | schedules.saturday.end    | 09:40            |
      | 31         | schedules.sunday.start    | 08:07            |
      | 31         | schedules.sunday.end      | 09:40            |
