/*
 * generated by Xtext 2.18.0.M3
 */
package org.omg.kerml.xtext

import org.eclipse.xtext.scoping.IGlobalScopeProvider
import org.eclipse.xtext.naming.IQualifiedNameConverter
import org.omg.kerml.xtext.naming.KerMLQualifiedNameConverter
import org.omg.kerml.xtext.scoping.KerMLGlobalScopeProvider
import org.omg.sysml.lang.sysml.util.IModelLibraryProvider
import org.omg.kerml.xtext.library.KerMLLibraryProvider
import org.eclipse.xtext.naming.IQualifiedNameProvider
import org.omg.kerml.xtext.naming.KerMLQualifiedNameProvider

/**
 * Use this class to register components to be used at runtime / without the Equinox extension registry.
 */
class KerMLRuntimeModule extends AbstractKerMLRuntimeModule {
	
	def Class<? extends IQualifiedNameConverter> bindIQualifiedNameConverter() {
		KerMLQualifiedNameConverter
	}
	
	def Class<? extends IModelLibraryProvider> bindIModelLLibraryProvider() {
		KerMLLibraryProvider
	}
		
	override Class<? extends IGlobalScopeProvider> bindIGlobalScopeProvider() {
		KerMLGlobalScopeProvider
	}

	override Class<? extends IQualifiedNameProvider> bindIQualifiedNameProvider() {
		KerMLQualifiedNameProvider
	}
}
