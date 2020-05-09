/**
 */
package org.omg.sysml.lang.sysml.impl;

import java.util.Collections;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.UniqueEList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.uml2.common.util.UnionEObjectEList;
import org.omg.sysml.lang.sysml.Behavior;
import org.omg.sysml.lang.sysml.Expression;
import org.omg.sysml.lang.sysml.Feature;
import org.omg.sysml.lang.sysml.FeatureMembership;
import org.omg.sysml.lang.sysml.FeatureValue;
import org.omg.sysml.lang.sysml.Function;
import org.omg.sysml.lang.sysml.Parameter;
import org.omg.sysml.lang.sysml.ParameterMembership;
import org.omg.sysml.lang.sysml.SysMLFactory;
import org.omg.sysml.lang.sysml.SysMLPackage;
import org.omg.sysml.lang.sysml.TransitionFeatureKind;
import org.omg.sysml.lang.sysml.TransitionFeatureMembership;
import org.omg.sysml.lang.sysml.Type;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Expression</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.omg.sysml.lang.sysml.impl.ExpressionImpl#getFunction <em>Function</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ExpressionImpl extends StepImpl implements Expression {
	
	public static final String EXPRESSION_SUBSETTING_BASE_DEFAULT = "Performances::evaluations";
	public static final String EXPRESSION_SUBSETTING_PERFORMANCE_DEFAULT = "Performances::Performance::subevaluations";
	public static final String EXPRESSION_GUARD_FEATURE = "TransitionPerformances::TransitionPerformance::guard";
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ExpressionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SysMLPackage.Literals.EXPRESSION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Function getFunction() {
		Function function = basicGetFunction();
		return function != null && function.eIsProxy() ? (Function)eResolveProxy((InternalEObject)function) : function;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public Function basicGetFunction() {
		EList<Behavior> behaviors = super.getBehavior();
		if (behaviors.isEmpty()) {
			return null;
		} else {
			Behavior behavior = behaviors.get(0);
			return behavior instanceof Function? (Function)behavior: null;
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public void setFunction(Function newFunction) {
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetFunction() {
		return basicGetFunction() != null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<Behavior> getBehavior() {
		EList<Behavior> behavior = new UniqueEList<Behavior>();
		Function function = getFunction();
		if (function != null) {
			behavior.add(function);
		}
		return new UnionEObjectEList<Behavior>(this, SysMLPackage.Literals.STEP__BEHAVIOR, behavior.size(), behavior.toArray());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetBehavior() {
  		return false;
	}

	@Override
	protected String getDefaultSupertype() {
		return isSubperformance()?
				EXPRESSION_SUBSETTING_PERFORMANCE_DEFAULT:
				EXPRESSION_SUBSETTING_BASE_DEFAULT;
	}

	@Override
	protected List<? extends Feature> getRelevantFeatures(Type type) {
		Type owningType = getOwningType();
		return isTransitionGuard()?
					type == owningType? Collections.singletonList(this):
					Collections.singletonList((Feature)getDefaultType(EXPRESSION_GUARD_FEATURE)):
			   owningType instanceof FeatureValue? Collections.emptyList():
			   super.getRelevantFeatures(type);
	}
	
	@Override
	protected Set<Type> getGeneralTypes(Type type) {
		Type owningType = getOwningType();
		return isTransitionGuard() && type == owningType?
				Collections.singleton(getDefaultType(TransitionUsageImpl.TRANSITION_USAGE_SUBSETTING_DEFAULT)):
				super.getGeneralTypes(type);
	}
	
	protected boolean isTransitionGuard() {
		FeatureMembership membership = getOwningFeatureMembership();
		return (membership instanceof TransitionFeatureMembership) &&
				((TransitionFeatureMembership)membership).getKind() == TransitionFeatureKind.GUARD;
	}
		
	@Override 
	public EList<Feature> getInput() {
		EList<Feature> inputs = super.getOwnedInput();
		if (inputs.isEmpty()) {
			Function function = getFunction();
			if (function != null) {
				for (Feature parameter: function.getInput()) {
					if (parameter instanceof Parameter && parameter.getOwner() == function) {
						inputs.add(createFeatureForParameter(parameter));
					}
				}
			}
		}
		return inputs;
	}
	
	@Override
	public EList<Feature> getOutput() {
		EList<Feature> outputs = super.getOwnedOutput();
		if (outputs.isEmpty()) {
			Parameter parameter = SysMLFactory.eINSTANCE.createParameter();
			ParameterMembership membership = SysMLFactory.eINSTANCE.createReturnParameterMembership();
			membership.setOwnedMemberParameter_comp(parameter);
			membership.setMemberName("$result");
			getOwnedFeatureMembership_comp().add(membership);
			outputs.add(parameter);
		}
		return outputs;
	}
			
	protected Feature createFeatureForParameter(Feature parameter) {
		if (parameter == null) {
			return null;
		} else {
			Feature feature = SysMLFactory.eINSTANCE.createParameter();
			FeatureMembership membership = SysMLFactory.eINSTANCE.createParameterMembership();
			membership.setOwnedMemberFeature_comp(feature);
			membership.setMemberName("$" + parameter.getName());
			getOwnedFeatureMembership_comp().add(membership);
			FeatureMembership parameterMembership = parameter.getOwningFeatureMembership();
			if (parameterMembership != null) {
				membership.setDirection(parameterMembership.getDirection());
			}			
			return feature;
		}
	}
	
	@Override
	public Feature getResult() {
		return getOutput().stream().
				filter(out->out instanceof Parameter && ((ParameterImpl)out).
				isResultParameter()).
				findFirst().orElse(null);
	}
	
	@Override
	public List<Parameter> getOwnedParameters() {
		getInput();
		getOutput();
		return super.getOwnedParameters();
	}
	
	@Override
	public void transform() {
		super.transform();
		getInput();
		getOutput();
	}
		
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case SysMLPackage.EXPRESSION__FUNCTION:
				if (resolve) return getFunction();
				return basicGetFunction();
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
			case SysMLPackage.EXPRESSION__FUNCTION:
				setFunction((Function)newValue);
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
			case SysMLPackage.EXPRESSION__FUNCTION:
				setFunction((Function)null);
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
			case SysMLPackage.EXPRESSION__BEHAVIOR:
				return isSetBehavior();
			case SysMLPackage.EXPRESSION__FUNCTION:
				return isSetFunction();
		}
		return super.eIsSet(featureID);
	}

} //ExpressionImpl
