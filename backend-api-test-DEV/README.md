# dimed-api-test
Automacao de testes de API

## 🛠️ Construído com
```
      JDK11
      Gradle
      ReportPortal 
```

## ⚙️ Executando os testes

- Executar tudo
```
  gradle clean test
 ```
   
- Executar um cenario
```
  Exemplo mostruario-service
  ./gradlew report -Plauncher=filial-service -Pambiente=HLG -Ptag="ambiente:HLG;regressao" -Plocal=false test -Dcucumber.filter.tags="@filial-service and @regressao" clean test
```
