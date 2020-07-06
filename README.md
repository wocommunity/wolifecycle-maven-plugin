![Master Build](https://github.com/wocommunity/wolifecycle-maven-plugin/workflows/wolifecycle-maven-plugin%20Master%20Build/badge.svg)

# WOLifecycle Maven Plugin

The wolifecycle-maven-plugin is a Maven plugin to assist in the development and packaging of WebObjects applications and frameworks.

**Version**: 2.3

## Usage

You must add the wolifecycle-maven-plugin to the `pom.xml` in the `build` section according to the following snippet:

```
<build>
  <plugins>
    <plugin>
      <groupId>org.wocommunity</groupId>
      <artifactId>wolifecycle-maven-plugin</artifactId>
      <version>2.3</version>
      <extensions>true</extensions>
    </plugin>
  </plugins>
</build>
```

You can configure the `packaging` property if you want your Maven build to produce a WO framework package:

```
<packaging>woframework</packaging>
```

Or to build a WO application package:

```
<packaging>woapplication</packaging>
```

## Configuration

This plugin comes with some options that you can change in the `configuration` section of the plugin.

- **flattenResources**: Flatten all Resources and WebServerResouces into the Resources folder of the application/framework package. All nested folders other than wo and eomodeld are dissolved.
- **flattenComponents**: Flatten only the WOComponents and EOModels from Resources or Components folders. All other files and directories keep their original nesting structure. 
- **readPatternsets**: Include Resources and WebResources files according to an existing patternset files in the woproject folder. The files here get added *in addition* to anything in the Resources and Component folders processed by default. Also those files and folders will not get flattened.
- **skipAppleProvidedFrameworks**: Do not include Apple WebObjects libraries when building application packages.
- **includeJavaClientClassesInWebServerResources**: Include  JavaClientClasses in the WebServerResources package.

Every option is disabled by default.

## History

The maven-wolifecycle-plugin was initially developed by Andrus Adamchik and Ulrich Köster in the context of the WOProject/WOLips<sup>1</sup> with the support of [objectstyle.org](http://objectstyle.org). In 2012, the control of the WOLips project was handed to [wocommunity.org](http://wocommunity.org). At some point, managing the changes of the maven-wolifecyle-plugin inside the WOLips project became cumbersome. This project was created to overcome these obstacles.

<sup>1</sup> WOLips is an Eclipse plugin to develop WebObjects applications.
