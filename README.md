# jxls-me
Easily export excel files using Java JXLS.

## Why?
Create and export excel templates using Java should be easier than [Apache POI](https://poi.apache.org/) looks like.

## Getting Started
Assuming we have a Java collection of jedi objects that we want to output into Excel. The Jedi class look like this

```java
public class Jedi {

    private String name;
    private java.util.Date birthDate;
    private BigDecimal payment;
    private String lightSaberColor;
}
```

To use JXLS to output this object collection into an Excel you'll need to do the following:

### Add required JXLS libraries to your project

The easiest way to add JXLS libraries to our project is to use Maven and specify the required librarie in your project build configuration file.
See our `pom.xml`.

```xml
<dependency>
    <groupId>org.jxls</groupId>
    <artifactId>jxls</artifactId>
    <version>2.2.6</version>
</dependency>
```

### Create an Excel template using a special markup
TODO :construction:

### Use JXLS API to process the prepared template

At [JediExport](https://github.com/andreybleme/jxls-me/blob/master/src/main/java/br/com/jxls_me/excel/JediExport.java) class you can see  how to use JXLS API to process the excel template

```java
public void exportJediExcelUsingNewTemplate() throws IOException {
		try(InputStream is = Jedi.class.getResourceAsStream("jedi_template.xls")) {
			try (OutputStream os = new FileOutputStream("target/jedi_template.xls")) {
				Context context = new Context();
				context.putVar("jedis", jedis);
				JxlsHelper.getInstance().processTemplate(is, os, context);
			}
		}
	}
```

Here we are loading the template from the classpath resource `jedi_template.xls`. And the target excel file will be written to `target/jedi_template.xls`.
