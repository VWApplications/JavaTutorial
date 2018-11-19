package br.com.vwapp.basico;

/*
 * TUTORIAL DE JAVA SE (JAVA STANDARD EDITION)
 * Classe com o famoso Hello World para iniciar o tutorial.
 *
 * Siglas comuns do Java:
 *
 * JDK: Java Developer Kit. É o kit de desenvolvimento Java oferecido gratuitamente pela Sun.
 * JRE: Java Runtime Enviroment. É o ambiente de execução Java oferecido gratuitamente pela Sun.
 * JVM: Java Virtual Machine - Máquina Virtual Java. É o programa que faz um .class java poder ser executado
 * J2ME: Java 2 Micro Edition. Conjunto de bilbiotecas para desenvolvimento voltado aos dispositívos móveis
 * J2SE: Java 2 Standard Editon. É o java padrão, utilizado para desenvolvimento desktop
 * J2EE: Java 2 Enterprise Edition. É um extensão ao J2SE para servidores, implementando várias bibliotecas para
 *       facilitar a computação distribuída, como os EJBs
 * JSP: Java Server Pages. É uma tecnologia para desenvolvimento de aplicações WEB semelhante ao PHP
 * XML: Extensible Markup Language. Linguagem como o HTML utilizada para armazenamento e troca de informações
 * EJB: Enterprise JavaBeans. Define um modelo para aplicações com servidores criando componentes reusáveis.
 * JCA: Java Connector Architecture - uma arquitetura desenvolvida de modo a facilitar a comunicacao entre servidores J2EE e EIS's.
 * JMS: Java Messaging System - uma arquitetura existe dentro do universo J2EE que permite troca de mensagens de maneira assíncrona.
 * MOM: Message Oriented Middleware - é o software que age como um Mediator na arquitetura de mensagens assíncronas.
 * MDB: Nao, nao é a extensao do banco de dados do Access. É Message-Driven-Bean, ou seja, um EJB capaz de processar mensagens assincronamente.
 * JDO: Java Data Objects - uma extensao sob o JSR-000012 que regula métodos de persistência de objetos Java em bancos de dados relacionais.
 * WSDL: Web Service Description Language - uma linguagem (ou melhor, uma estrutura em XML) usada para definir uma descricao para um servico WEB.
 * WML: Wireless Markup Language - uma linguagem como a HTML, para celulares e outros dispositivos móveis.
 * UML: Unified Modeling Language - uma linguagem utilizada durante o processo de análise e desenvolvimento de software
 *      capaz de traduzir requerimentos funcionais e nao-funcionais do sistema. (Tá muito suscinta essa descricao).
 * CORBA: Common Object Request Broker Arquitecture - uma arquitetura que possibilita o desenvolvimento de sistemas construídos
 *        em diversas linguagens distintas, atuar de maneira distribuída segunda um protocolo bem definido. O principal elemento
 *        que torna isso possível é o ORB (Object Request Broker).
 * IDL: Interface Definition Language - é a linguagem usada para definir interfaces de comunicacao na arquitetura CORBA.
 * EIS: Enterprise Information System - qualquer sistema que centralize informacoes de negócio da sua empresa.
 * JAR - Java ARchive - comprimir e criar arquivos "executáveis" em java
 * AWT - Abstract Window Toolkit - API para desenvolvimento de Janelas.
 * GUI - Grafic User Interface - São os tipos de interface geráficas para Usuários, nada muito intuitivo
 * RMI - Remote Method Invocation - Mas centrado em Sistemas distribuídos, semelhante ao CORBA.
 * POO - Programação Orientada a Objetos
 * JCE - Java Cryptography Extension - Extensão para utilização de criptografia utilizando providers que fornecem os
 *       algoritmos tipo DES, RSA e outros. A SUN tem o seu dentro da propria API SUNJCE, mas tem de outras empresas,
 *       como IBM e também alguns free, como o Bouncy Castle
 * JDBC - Java Database Connectivity - Tecnologia que permite que uma aplicação java conecte-se e manipule um bando de dados.
 * JSF - JavaServer Faces: Esta tecnologia simplifica a construção de interfaces com o usuário através de componentes
 *       reutilizáveis que podem estar conectados a data sources.
 * JAAS - Java Authentication and Authorization Service - Implementação da segurança e controle de acessos da máquina virtual.
 * SCJP: Sun Certified Java Programmer - Certificação da Sun para programador Java
 * SCJD: Sun Certified Java Developer - Certificação da Sun para desenvolvedor Java
 * SCEA: Sun Certified Enterprise Architect - Certificação da Sun para arquiteto Java
 * SCWCD: Sun Certified Web Component Developer - Certificação da Sun para desenvolvedor web em java.
 * JRMP Java Remote Method Protocol - Protocolo java para invocar métodos em objetos de outras VMs
 * RMI: Remote Method Invocation - API para invocar métodos em outras VMs.
 * AOP: Aspect Oriented Programming - Programação orientada a aspectos, evolução natural da OOP (Object Oriented Programming)
 * UML: Unified Modeling Language - é uma linguagem gráfica padrão para modelagem de dados, destinada à especificação,
 *       à construção, à visualização e à documentação de sistemas complexos de software.
 * MDA: MODEL DRIVEN ARCHITECTURE / Arquitetura de Modelagem Dirigida - é uma nova forma de se escrever especificações
 *      e desenvolver aplicações, com base em uma PIM (Modelo plataforma-independente).
 * OOAD: object-oriented analysis and design - Análise e Projetos Orintado a Objetos.
 */
public class HelloWorld {

    /*
     * Método principal para execução do código java.
     */
    public static void main(String[] args) {

        // Mostra a mensagem sem pular linha
        System.out.print("Olá mundo!");
        // Mostra a mensagem pulando linhas
        System.out.println(" meu nome é Victor!");
    }
}
