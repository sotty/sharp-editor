Maven repository for the projects under this organization.

To use this repository make sure you have the following repository configured in your pom.xml file:

```xml
<repositories>
    <repository>
        <id>EmpireRDF</id>
        <url>https://github.com/HeD-editor/mavenRepo/raw/master/releases</url>
    </repository>
    <repository>
        <id>EmpireRDF-snapshot</id>
        <url>https://github.com/HeD-editor/mavenRepo/raw/master/snapshots</url>
    </repository>
</repositories>
```

To deploy into this repository, you can use the following command:

`mvn deploy -DskipTests=true -DaltDeploymentRepository=releases::default::file:/the/path/to/this/repo/mavenRepo/releases/`
