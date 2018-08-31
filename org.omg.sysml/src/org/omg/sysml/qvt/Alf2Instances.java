package org.omg.sysml.qvt;

import java.nio.file.Paths;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.uml2.uml.resource.UMLResource;
import org.eclipse.uml2.uml.resource.XMI2UMLResource;
import org.eclipse.uml2.uml.resources.util.UMLResourcesUtil;
import org.omg.sysml.AlfStandaloneSetup;
import org.omg.sysml.lang.sysml.SysMLPackage;

public class Alf2Instances extends QVTRunner {

	@SuppressWarnings("unused")
	protected void initialize() {
		super.initialize();
		
		UMLResourcesUtil.init(this.resourceSet);
	    Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("xmi", XMI2UMLResource.Factory.INSTANCE);
	    
	    SysMLPackage sysml = SysMLPackage.eINSTANCE;	    
	    AlfStandaloneSetup.doSetup();
	}
	
	@Override
	protected String constructOutputPath(final String... resourcePaths) {
		int n = resourcePaths.length;
		
		// Second to last resource path is presumed to be the input file path.
		String fileName = Paths.get(resourcePaths[n - 2]).getFileName().toString();
		int i = fileName.indexOf('.');
		if (i >= 0) {
			fileName = fileName.substring(0, i);
		}
		
		// Last resource path is presumed to be the output directory path,
		// to which the input file name is appended.
		return resourcePaths[n - 1] + "/" + fileName + "." + UMLResource.FILE_EXTENSION;
	}
	
	public static void main(String[] args) {
		new Alf2Instances().run(args, 4, "Alf2Instances [-l logPath] qvtPath metamodelPath inputPath outputDirectory");
	}

}
