/*
 * generated by Xtext 2.12.0
 */
package org.omg.sysml.tests

import com.google.inject.Inject
import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.testing.XtextRunner
import org.eclipse.xtext.testing.util.ParseHelper
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.omg.sysml.kerml.core.Container

@RunWith(XtextRunner)
@InjectWith(AlfInjectorProvider)
class AlfParsingTest {
	@Inject
	ParseHelper<Container> parseHelper
	
	@Test
	def void loadModel() {
		val result = parseHelper.parse('''
			Hello Xtext!
		''')
		Assert.assertNotNull(result)
		Assert.assertTrue(result.eResource.errors.isEmpty)
	}
}
