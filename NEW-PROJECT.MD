## HOW TO CREATE A NEW MAVEN PROJECT

1. File -> New -> Maven Project
2. Check "Create Simple Project"
3. Artifact:
    - Group Id: **br.com.sysfarma** (Normalmente o Dominío ao Contrário)
    - Artifact Id: **Sysfarma** (Normalmente o Último Nome do Projeto)
    - Version: Usar o número de versão de desejar. Ex: 1.0
    - Packaging: (jar, pom, war) -> WAR arquivo compactado com seu projeto WEB.

![MainDirectories](/imgs/important_files_project_explorer.png)

4. Configurar arquivo __pom.xml__

<!-- Codificação de Caracteres -->
	<properties>
		<project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
	</properties>
	
	<!--  Parâmetros de execucao -->
	<build>
		<!-- Nome do Projeto empacotado -->
		<finalName>Sysfarma</finalName>
		
		<!-- Plugins -->
		<plugins>
			<!-- Compilador -->
			<plugin>
				<groupId>org.apache.maven.plugins</groupId>
				<artifactId>maven-compiler-plugin</artifactId>
				<version>3.3</version>
				<configuration>
					<!--  versão do Java -->
					<source>10</source>
					<target>10</target>
				</configuration>
			</plugin>
		</plugins>
		
		
	</build>
<!--fim dodigo-->


5. Criar arquivo **web.xml**: 
 
 - src --> webapps --> NEW FOLDER: __WEB-INF__
 - Clicar com o direito em **WEB-INF** --> New --> Other --> __XML File__
 - Name: **web.xml** (O nome precisa ser exatamente assim)

6. Botao dirieto no projeto --> Runs as --> Maven Clean

7. Hibernate: Inserir dependencia no pom.xml:

https://mvnrepository.com/

http://docs.jboss.org/hibernate/orm/5.3/userguide/html_single/Hibernate_User_Guide.html

8. Configurar **hibernate.cfg.xml** em src/main/resources

9. Inserir **dependecia MYSQL** no pom.xml

10. Criar Classe **HibernateUtil** para criar Sessoes e testar junto a banco

```javascript

package br.com.sysfarma.util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HibernateUtil {

	private static SessionFactory fabricaDeSessoes = criarFabricaDeSessoes();

    public static SessionFactory getFabricaDeSessoes() {
		return fabricaDeSessoes;
	}
    
    private static SessionFactory criarFabricaDeSessoes() {
    	try {
    		//Configuration.configure -> serve para ler o arquivo hibernate.cfg.xml 
    		Configuration configuracao = new Configuration().configure();
    		//Registro de Serviço Passando as Configurações
    		ServiceRegistry registro = new StandardServiceRegistryBuilder().applySettings(configuracao.getProperties()).build();
    		
    		//Agora é possível construir a fábrica de sessões
    		SessionFactory fabrica = configuracao.buildSessionFactory(registro);
    		
    		//Por fim, retorna a fábrica
    		return fabrica;
    	}
    	catch(Throwable ex){
    		System.err.println("Criacao da fabrica de Sessão falhou!" + ex);
    		throw new ExceptionInInitializerError(ex);
    	}
    }
}

```



