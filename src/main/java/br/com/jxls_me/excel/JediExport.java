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

import br.com.jxls_me.jxls_me.Jedi;
import br.com.jxls_me.utils.JediUtils;

/**
 * Export excel of Jedis class
 * 
 * @author Lucas
 *
 */
public class JediExport {
    List<Jedi> jedis = JediUtils.createJedis();
    
    public void exportJediExcelTemplate() throws IOException {
    	try(InputStream is = Jedi.class.getResourceAsStream("jedi_template.xls")) {
    	       try (OutputStream os = new FileOutputStream("target/jedi_template.xls")) {
    	           Context context = new Context();
    	           context.putVar("jedis", jedis);
    	           JxlsHelper.getInstance().processTemplate(is, os, context);
    	       }
    	}
	}
    
}
