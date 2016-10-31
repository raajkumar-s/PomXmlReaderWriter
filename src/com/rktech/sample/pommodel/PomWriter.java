/**
 * 
 */
package com.rktech.sample.pommodel;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.Writer;

import org.apache.maven.model.Model;
import org.apache.maven.model.io.xpp3.MavenXpp3Writer;
import org.codehaus.plexus.util.IOUtil;
import org.codehaus.plexus.util.WriterFactory;

/**
 * @author I333245
 *
 */
public class PomWriter {
	public boolean writePom (Model model) {
		boolean status = false;
		Writer writer = null;
		File file = new File("src/resource/pom.xml");
		
        try { 
//        	file.createNewFile();
        	DataOutputStream stream = new DataOutputStream(new FileOutputStream(file));
            writer = WriterFactory.newXmlWriter(stream); 
            new MavenXpp3Writer().write(writer, model);
            status = true;
        } 
        catch (IOException e) {
        	System.err.println("Error while writing pom file: ");
            e.printStackTrace(); 
        } 
        finally { 
            IOUtil.close(writer); 
        }
        
        return status;
	}
}
