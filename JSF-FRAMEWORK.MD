## JSF-FRAMEWORK

__0. Conceitos__

Especificação da Oracle sobre como um framework MVC deve ser implementado

Ex: Mojarra e Myfaces

Objetivos: Modelo visão-controle. 

Mini-tutorial: https://docs.oracle.com/javaee/7/tutorial/webapp003.htm

__1. Configuração Mínima__

1. Baixar o JSF Mojarra (repositório do Maven): https://search.maven.org/

    1.1 Procurar por: javax faces

    1.2 Group ID: org.glassfish | Artifact IF: javax.faces
    
    1.3 https://search.maven.org/artifact/org.glassfish/javax.faces/2.2.8-30/jar
2. Alterar o web.xml (src-->webapp-->WEB-INF)

    2.1 https://docs.oracle.com/javaee/7/tutorial/webapp003.htm

    2.2 Item 8 do link - estagio do projeto (Develpment ou Production)
    
```html
<context-param>
        <param-name>javax.faces.PROJECT_STAGE</param-name>
        <param-value>Development</param-value>
</context-param>
```

2.3  Configurando o Servlet: 

```html
<servlet>
    <servlet-name>Faces Servlet</servlet-name>
    <servlet-class>javax.faces.webapp.FacesServlet</servlet-class>
    <load-on-startup>1</load-on-startup>
</servlet>
<servlet-mapping>
    <servlet-name>Faces Servlet</servlet-name>
    <url-pattern>*.xhtml</url-pattern>
</servlet-mapping>
```

3. Criando a Primeira Página

    3.1 Deve ser criada em src --> main --> webapp
    
    3.2 Folder Pages --> File testJSF.xhtml
    
    3.3 xhtml 1.0 transitional 


