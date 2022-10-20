/**
 */
package org.omg.sysml.lang.sysml;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Library Package</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * <p>A LibraryPackage is a Package that is the container for a model library. A LibraryPackage is itself a library Element as are all Elements that are directly or indirectly contained in it.</p>
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.omg.sysml.lang.sysml.LibraryPackage#isStandard <em>Is Standard</em>}</li>
 * </ul>
 *
 * @see org.omg.sysml.lang.sysml.SysMLPackage#getLibraryPackage()
 * @model
 * @generated
 */
public interface LibraryPackage extends org.omg.sysml.lang.sysml.Package {
	/**
	 * Returns the value of the '<em><b>Is Standard</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * <p>Whether this LibraryPackage contains a standard library model. This should only be set to true for LibraryPackage in the standard Kernel Libraries or in normative model libraries for a language built on KerML.</p>
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Is Standard</em>' attribute.
	 * @see #setIsStandard(boolean)
	 * @see org.omg.sysml.lang.sysml.SysMLPackage#getLibraryPackage_IsStandard()
	 * @model default="false" dataType="org.omg.sysml.lang.types.Boolean" required="true" ordered="false"
	 * @generated
	 */
	boolean isStandard();

	/**
	 * Sets the value of the '{@link org.omg.sysml.lang.sysml.LibraryPackage#isStandard <em>Is Standard</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Standard</em>' attribute.
	 * @see #isStandard()
	 * @generated
	 */
	void setIsStandard(boolean value);

} // LibraryPackage
