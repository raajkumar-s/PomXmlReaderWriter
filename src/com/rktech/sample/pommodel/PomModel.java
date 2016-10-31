package com.rktech.sample.pommodel;

import org.apache.maven.model.Dependency;
import org.apache.maven.model.Model;

/**
 * @author I333245
 *
 */
public class PomModel {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		PomReader pReader = new PomReader();
		Model model = pReader.readPom();
        Dependency dep1 = new Dependency();
        Dependency dep2 = new Dependency();
        dep1.setGroupId("new-groupid");
        dep1.setArtifactId("new-artifact-1");
        dep1.setVersion("1.0.0-SNAPSHOT");
        dep2.setGroupId("new-groupid");
        dep2.setArtifactId("new-artifact-1");
        dep2.setVersion("1.0.0-SNAPSHOT");
        
        model.addDependency(dep1);
        model.addDependency(dep2);
        
        PomWriter pWriter = new PomWriter();
        boolean status = pWriter.writePom(model);
        if(status) {
        	System.out.println("Pom updated successfully");
        } else {
        	System.err.println("Pom update failed");
        }
	}

}
