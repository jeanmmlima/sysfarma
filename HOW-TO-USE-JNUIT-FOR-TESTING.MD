## JUnit for testing

### Dependencia
https://mvnrepository.com/artifact/junit/junit/4.12

```html
<!-- https://mvnrepository.com/artifact/junit/junit -->
<dependency>
    <groupId>junit</groupId>
    <artifactId>junit</artifactId>
    <version>4.12</version>
   <scope>test</scope>
</dependency>
```

- Criar pacote classe de teste em: **src/test/java**. Pacote com o mesmo nome e classe com a palavra "Test" no final, por exemplo

```javascript
package br.com.sysfarma.util;

import org.hibernate.Session;
import org.junit.Test;

//Testes: Se retornar verde - OK!
public class HibernateUtilTest {
	@Test
	public void conectar() {
		//Teste se é possível conectar e desconectar do banco
		Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();
		sessao.close();
		HibernateUtil.getFabricaDeSessoes().close();
	}
}

```

- Para rodar: Clicar com o direito na classe Test --> **Runs as --> JUnit**
- Annotation Test para espeficiar que o método é de teste