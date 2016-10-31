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
		/*
		<dependency>
			<groupId>com.sap.bdh</groupId>
			<artifactId>bdh-tools-project-type</artifactId>
			<version>1.0.0-SNAPSHOT</version>
		</dependency>
		<dependency>
			<groupId>com.sap.bdh</groupId>
			<artifactId>bdh-tools-project-api</artifactId>
			<version>1.0.0-SNAPSHOT</version>
		</dependency>
		*/
		Model model = pReader.readPom();
        Dependency bdhProjectTypeDep = new Dependency();
        Dependency bdhProjectApiDep = new Dependency();
        bdhProjectTypeDep.setGroupId("com.sap.bdh");
        bdhProjectTypeDep.setArtifactId("bdh-tools-project-type");
        bdhProjectTypeDep.setVersion("1.0.0-SNAPSHOT");
        bdhProjectApiDep.setGroupId("com.sap.bdh");
        bdhProjectApiDep.setArtifactId("bdh-tools-project-api");
        bdhProjectApiDep.setVersion("1.0.0-SNAPSHOT");
        
        model.addDependency(bdhProjectTypeDep);
        model.addDependency(bdhProjectApiDep);
        
        PomWriter pWriter = new PomWriter();
        boolean status = pWriter.writePom(model);
        if(status) {
        	System.out.println("Pom updated successfully");
        } else {
        	System.err.println("Pom update failed");
        }
	}

}
