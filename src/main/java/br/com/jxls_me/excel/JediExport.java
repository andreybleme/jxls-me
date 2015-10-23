/**
 * 
 */
package br.com.jxls_me.excel;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

import org.jxls.common.Context;
import org.jxls.util.JxlsHelper;

import br.com.jxls_me.pojo.Jedi;
import br.com.jxls_me.util.JediUtils;

/**
 * Export excel template with Jedis class
 * 
 * @author Lucas
 *
 */
public class JediExport {
	List<Jedi> jedis = JediUtils.createJedis();

	/**
	 *  Loads the template from the classpath resource jedi_template.xls. 
	 *  The target excel file will be written to target/jedi_template.xls.
	 *  
	 * @throws IOException
	 */
	public void exportJediExcelTemplate() throws IOException {
		try(InputStream is = Jedi.class.getResourceAsStream("jedi_template.xls")) {
			try (OutputStream os = new FileOutputStream("target/jedi_template.xls")) {
				Context context = new Context();
				context.putVar("jedis", jedis);
				//	All the main processing is performed here
				JxlsHelper.getInstance().processTemplate(is, os, context);
			}
		}
	}

}
