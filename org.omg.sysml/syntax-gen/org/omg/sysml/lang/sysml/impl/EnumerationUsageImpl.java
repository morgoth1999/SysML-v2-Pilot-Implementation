/**
 */
package org.omg.sysml.lang.sysml.impl;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.UniqueEList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.uml2.common.util.UnionEObjectEList;
import org.omg.sysml.lang.sysml.DataType;
import org.omg.sysml.lang.sysml.EnumerationDefinition;
import org.omg.sysml.lang.sysml.EnumerationUsage;
import org.omg.sysml.lang.sysml.SysMLPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Enumeration Usage</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.omg.sysml.lang.sysml.impl.EnumerationUsageImpl#getEnumerationDefinition <em>Enumeration Definition</em>}</li>
 * </ul>
 *
 * @generated
 */
public class EnumerationUsageImpl extends AttributeUsageImpl implements EnumerationUsage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EnumerationUsageImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SysMLPackage.Literals.ENUMERATION_USAGE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EnumerationDefinition getEnumerationDefinition() {
		EnumerationDefinition enumerationDefinition = basicGetEnumerationDefinition();
		return enumerationDefinition != null && enumerationDefinition.eIsProxy() ? (EnumerationDefinition)eResolveProxy((InternalEObject)enumerationDefinition) : enumerationDefinition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public EnumerationDefinition basicGetEnumerationDefinition() {
		EList<DataType> definitions = super.getAttributeDefinition();
		if (definitions.isEmpty()) {
			return null;
		} else {
			DataType definition = definitions.get(0);
			return definition instanceof EnumerationDefinition? (EnumerationDefinition)definition: null;
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public void setEnumerationDefinition(EnumerationDefinition newEnumerationDefinition) {
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetEnumerationDefinition() {
		return basicGetEnumerationDefinition() != null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<DataType> getAttributeDefinition() {
		EList<DataType> attributeDefinition = new UniqueEList<DataType>();
		EnumerationDefinition enumerationDefinition = getEnumerationDefinition();
		if (enumerationDefinition != null) {
			attributeDefinition.add(enumerationDefinition);
		}
		return new UnionEObjectEList<DataType>(this, SysMLPackage.Literals.ATTRIBUTE_USAGE__ATTRIBUTE_DEFINITION, attributeDefinition.size(), attributeDefinition.toArray());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetAttributeDefinition() {
  		return false;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case SysMLPackage.ENUMERATION_USAGE__ENUMERATION_DEFINITION:
				if (resolve) return getEnumerationDefinition();
				return basicGetEnumerationDefinition();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case SysMLPackage.ENUMERATION_USAGE__ENUMERATION_DEFINITION:
				setEnumerationDefinition((EnumerationDefinition)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case SysMLPackage.ENUMERATION_USAGE__ENUMERATION_DEFINITION:
				setEnumerationDefinition((EnumerationDefinition)null);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case SysMLPackage.ENUMERATION_USAGE__ATTRIBUTE_DEFINITION:
				return isSetAttributeDefinition();
			case SysMLPackage.ENUMERATION_USAGE__ENUMERATION_DEFINITION:
				return isSetEnumerationDefinition();
		}
		return super.eIsSet(featureID);
	}

} //EnumerationUsageImpl
