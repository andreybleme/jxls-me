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

Jxls supports [Apache JEXL](http://commons.apache.org/proper/commons-jexl/reference/syntax.html) as an expression language that can be used in an excel template to refer to java object properties and methods. The object must be available in Jxls context under a certain **key**. To output the jedi name in a cell we can put the following text in the cell `${jedi.name}`. Here we just surrounded Jexl expression with `${` and `}`. We assume that in the context there is an **Jedi** object under the `jedi` key.

The property notation is configurable so you may decide to use for example `[[jedi.name]]` as a property notation. See [Jxls Expression Language](http://jxls.sourceforge.net/reference/expression_language.html) for more details on how to do it.

The final template for the example to output a list of Jedi objects can be [downloaded here](https://www.dropbox.com/s/v7omwlne2zv0t4o/jedi_template.xls?dl=0).

On our template cells in row 4 we refer to the jedi object properties using JEXL expressions as described above.

Cell `A1` contains an excel comment with the following text `jx:area(lastCell="D4")`. It defines the root area of our template to be `A1:D4`.

A comment to `A4` cell defines Jxls Each-Command with the following comment text `jx:each(items="jedis" var="jedi" lastCell="D4")`. The [Each-Command](http://jxls.sourceforge.net/reference/each_command.html) will iterate the collection of objects under *jedis* key in Jxls context and place each individual collection item into the context under *jedi* key (defined by var attribute). The body area of the Each-Command is `A4:D4` (defined by the lastCell attribute) and it will be cloned and processed with each new Jedi object in the context.


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

-----

The final template to output a list of Jedi objects can be [downloaded here](https://www.dropbox.com/s/v7omwlne2zv0t4o/jedi_template.xls?dl=0) and looks like this:

![alt text][logo]
[logo]: https://github.com/andreybleme/jxls-me/blob/master/img/jedi-template.png "Jedi Template"
