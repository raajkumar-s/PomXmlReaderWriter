/**
 * 
 */
package com.rktech.sample.pommodel;

import java.io.File;
import java.io.FileReader;

import org.apache.maven.model.Model;
import org.apache.maven.model.io.xpp3.MavenXpp3Reader;

/**
 * @author I333245
 *
 */
public class PomReader {

	public Model readPom() {
	    MavenXpp3Reader reader = new MavenXpp3Reader();
	    Model result = null;
	    
	    File file = new File("src/resource/pom.xml");
//    	BufferedReader br = new BufferedReader(new FileReader(file));
//	    System.out.println(file.getAbsolutePath());
	    
	    try {
	        result = reader.read(new FileReader(file));
	        String artifact = result.getArtifactId();
	        String parentArtifact = result.getParent().getArtifactId();
	        System.out.println(artifact + ", " + parentArtifact);
	    } catch (Exception e) {
	    	System.err.println("Error while reading pom file: ");
	        e.printStackTrace();
	    }
	    
	    return result;
	}
	 
}
