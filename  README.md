#

## Finalizando o projeto

Ao terminar de realizar as alterações basta agora executar o comando a seguir para instalar o archetype.

```bash
mvn install
```

## Criando um projeto apartir do seat-service-archetype

Para criar um projeto novo execute no terminal o seguinte comando:

```bash
mvn archetype:generate  \
  -DarchetypeGroupId=br.ind.seat \
  -DarchetypeArtifactId=seat-service-archetype \
  -DarchetypeVersion=1.0.0 \
  -DgroupId={{ groupId do seu webservice }} \
  -DartifactId={{ artifactId do seu webservice }}

```