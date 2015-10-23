/**
 * 
 */
package br.com.jxls_me.util;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import br.com.jxls_me.pojo.Jedi;

/**
 * Useful methods to manipulate Jedis
 * 
 * @author Lucas
 *
 */
public class JediUtils {
	 
	/**
	 * Creates a list full of Jedis
	 * 
	 * @return A list with Jedis ready to fight
	 */
	public static List<Jedi> createJedis() {
			Jedi firstJedi = new Jedi();
			List<Jedi> jediList = new ArrayList<Jedi>();
			
			firstJedi.setBirthDate(new Date());
			firstJedi.setLightSaberColor("Green");
			firstJedi.setName("Yoda");
			firstJedi.setPayment(new BigDecimal(50.000));
			jediList.add(firstJedi);
			
			Jedi secondJedi = new Jedi();
			secondJedi.setBirthDate(new Date());
			secondJedi.setLightSaberColor("Blue");
			secondJedi.setName("Obi Wan");
			secondJedi.setPayment(new BigDecimal(30.000));
			jediList.add(secondJedi);
			
			Jedi thirdJedi = new Jedi();
			thirdJedi.setBirthDate(new Date());
			thirdJedi.setLightSaberColor("Green");
			thirdJedi.setName("Luke Skywalker");
			thirdJedi.setPayment(new BigDecimal(40.000));
			jediList.add(thirdJedi);
			
	    	return jediList;
		}
}
