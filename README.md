# CMake-Maven-Project [![Build Status](https://travis-ci.org/cmake-maven-project/cmake-maven-project.png?branch=master)](https://travis-ci.org/cmake-maven-project/cmake-maven-project)

## Introduction

Um projeto Maven para o sistema de construção CMake. O CMake pode ser integrado ao seu projeto JAVA JNI através do pom.xml do Maven.

Este repositório [estava inicialmente](https://code.google.com/p/cmake-maven-project/) no Google Code e foi migrado para o GitHub (e Git) após o Google Code ser encerrado.

## Como usar

### O alvo `generate`

    <plugin>
      <groupId>com.googlecode.cmake-maven-project</groupId>
      <artifactId>cmake-maven-plugin</artifactId>
      <version>3.16.3-b1</version>
      <executions>
        <execution>
          <id>cmake-generate</id>
          <goals>
            <goal>generate</goal>
          </goals>
          <configuration>
            <sourcePath>
              <!-- The directory containing CMakeLists -->
            </sourcePath>
            <targetPath>
              <!-- The directory write the project files to -->
            </targetPath>
            <generator>
              <!--
              Optional: Overrides the default generator used by cmake.
              The list of available values can be found at 
              https://cmake.org/cmake/help/v3.16/manual/cmake-generators.7.html
              -->
            </generator>
            <environmentVariables>
              <!--
              Optional: Additional environment variables to expose to cmake. If a variable was already set,
              overrides the previous value.             
              -->              
              <key>value</key>
            </environmentVariables>
            <options>
              <!--
              Optional: One or more options found at https://cmake.org/cmake/help/v3.16/manual/cmake.1.html
              For example:
              -->
              <option>-DBUILD_THIRDPARTY:bool=on</option>
            </options>
          </configuration>
        </execution>
      </executions>
    </plugin>

### O alvo `compile`

    <plugin>
      <groupId>com.googlecode.cmake-maven-project</groupId>
      <artifactId>cmake-maven-plugin</artifactId>
      <version>3.16.3-b1</version>
      <executions>
        <execution>
          <id>cmake-compile</id>
          <goals>
            <goal>compile</goal>
          </goals>
          <configuration>
            <config>
              <!-- Optional: the build configuration (e.g. "x64|Release") -->
            </config>
            <target>
              <!-- Optional: the build "target" -->
            </target>
            <projectDirectory>
              <!-- "targetPath" from the "generate" goal -->
            </projectDirectory>
            <environmentVariables>
              <key>value</key>
            </environmentVariables>
          </configuration>
        </execution>
      </executions>
    </plugin>

### O alvo `test`

    <plugin>
      <groupId>com.googlecode.cmake-maven-project</groupId>
      <artifactId>cmake-maven-plugin</artifactId>
      <version>3.16.3-b1</version>
      <executions>
        <execution>
          <id>cmake-test</id>
          <goals>
            <goal>test</goal>
          </goals>
          <configuration>
            <!-- "buildDirectory" is "targetPath" from the "generate" goal -->
            <buildDirectory>${project.build.directory}</buildDirectory>
            <!-- Optional: do not fail the build on test failures. false by default. -->
            <testFailureIgnore>true</testFailureIgnore>
            <!-- Optional: skip only ctest tests. false by default. -->
            <ctest.skip.tests>true</ctest.skip.tests>
            <!-- Optional: Skip all Maven tests. false by default -->
            <maven.test.skip>true</maven.test.skip>
            <!-- Optional: the number of threads tests should use -->
            <threadCount>2</threadCount>
            <!-- Optional: dashboard configuration; used with CTestConfig.cmake -->
            <dashboard>Experimental</dashboard>
          </configuration>
        </execution>
      </executions>
    </plugin>
    
### Exemplos

O projeto abaixo utiliza este plugin:

[Requirements API](https://bitbucket.org/cowwoc/requirements.java/src/759c13be200744e31f0d3f1c6df5d49ac079dfbf/natives/pom.xml#lines-69)

### Instruções de como construir e instalar o plugin no seu repositório Maven local

Para construir e instalar, execute na linha de comenado:

```bash
    mvn install
```

Para limpar arquivos temporários após uma construção, rode:

```bash
    mvn clean
```

Por padrão, o próprio Maven vai esclher o perfil de arquitetura correto baseado em sua máquina virtual java instalada:

* windows-x86_64
* linux-x86_64
* linux-arm_32
* mac-x86_64

Se esta detecção não funcionar, ou se você quiser sobreescrever o perfil para testar, acescente na linha de comando `-P<profile>`.

Exemplo, quando queremos construir e instalar o plugin forçando a arquitetura 64-bit em máquina linux, usamos:

    mvn -Plinux-x86_64 install

### Usando sua própria instalação CMake da máquina local

A cada construção, o plugin baixa uma versão do CMake do site original para usar.
Isso demora e portanto pode ser que voce opter por usar seu CMake instalado na máquina.
Para fazer uso do cmake local, sete a seguinte propriedade no arquivo `pom.xml` do projeto.

1. `${cmake.download}` com o valor `false`.
2. Opcionalmente defina `${cmake.dir}` com o caminho contendo o binário executável do CMake (e.g. `/usr/bin`).

É isso! Para aprender CMake recorra ao site original [CMake.org](https://cmake.org/) website.

### Licença

CMake-Maven-Project é feito sob licença [Apache License 2.0](http://www.apache.org/licenses/LICENSE-2.0)

