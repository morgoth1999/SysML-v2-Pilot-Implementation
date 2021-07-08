/*******************************************************************************
 * SysML 2 Pilot Implementation
 * Copyright (c) 2020-2021 Model Driven Solutions, Inc.
 *    
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 *  
 * You should have received a copy of theGNU Lesser General Public License
 * along with this program.  If not, see <https://www.gnu.org/licenses/>.
 *  
 * @license LGPL-3.0-or-later <http://spdx.org/licenses/LGPL-3.0-or-later>
 *  
 *******************************************************************************/
/**
 */
package org.omg.sysml.lang.sysml.util;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.notify.impl.AdapterImpl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.omg.sysml.lang.sysml.AcceptActionUsage;
import org.omg.sysml.lang.sysml.ActionDefinition;
import org.omg.sysml.lang.sysml.ActionUsage;
import org.omg.sysml.lang.sysml.ActorMembership;
import org.omg.sysml.lang.sysml.AllocationDefinition;
import org.omg.sysml.lang.sysml.AllocationUsage;
import org.omg.sysml.lang.sysml.AnalysisCaseDefinition;
import org.omg.sysml.lang.sysml.AnalysisCaseUsage;
import org.omg.sysml.lang.sysml.AnnotatingFeature;
import org.omg.sysml.lang.sysml.Annotation;
import org.omg.sysml.lang.sysml.AssertConstraintUsage;
import org.omg.sysml.lang.sysml.AssignmentActionUsage;
import org.omg.sysml.lang.sysml.Association;
import org.omg.sysml.lang.sysml.AssociationStructure;
import org.omg.sysml.lang.sysml.AttributeDefinition;
import org.omg.sysml.lang.sysml.AttributeUsage;
import org.omg.sysml.lang.sysml.Behavior;
import org.omg.sysml.lang.sysml.BindingConnector;
import org.omg.sysml.lang.sysml.BindingConnectorAsUsage;
import org.omg.sysml.lang.sysml.BooleanExpression;
import org.omg.sysml.lang.sysml.CalculationDefinition;
import org.omg.sysml.lang.sysml.CalculationUsage;
import org.omg.sysml.lang.sysml.CaseDefinition;
import org.omg.sysml.lang.sysml.CaseUsage;
import org.omg.sysml.lang.sysml.Classifier;
import org.omg.sysml.lang.sysml.ConcernDefinition;
import org.omg.sysml.lang.sysml.ConcernUsage;
import org.omg.sysml.lang.sysml.ConjugatedPortDefinition;
import org.omg.sysml.lang.sysml.ConjugatedPortTyping;
import org.omg.sysml.lang.sysml.Conjugation;
import org.omg.sysml.lang.sysml.ConnectionDefinition;
import org.omg.sysml.lang.sysml.ConnectionUsage;
import org.omg.sysml.lang.sysml.Connector;
import org.omg.sysml.lang.sysml.ConstraintDefinition;
import org.omg.sysml.lang.sysml.ConstraintUsage;
import org.omg.sysml.lang.sysml.DataType;
import org.omg.sysml.lang.sysml.DecisionNode;
import org.omg.sysml.lang.sysml.Dependency;
import org.omg.sysml.lang.sysml.Disjoining;
import org.omg.sysml.lang.sysml.Documentation;
import org.omg.sysml.lang.sysml.ElementFilterMembership;
import org.omg.sysml.lang.sysml.EndFeatureMembership;
import org.omg.sysml.lang.sysml.EnumerationDefinition;
import org.omg.sysml.lang.sysml.EnumerationUsage;
import org.omg.sysml.lang.sysml.EventOccurrenceUsage;
import org.omg.sysml.lang.sysml.ExhibitStateUsage;
import org.omg.sysml.lang.sysml.Expose;
import org.omg.sysml.lang.sysml.Expression;
import org.omg.sysml.lang.sysml.Feature;
import org.omg.sysml.lang.sysml.FeatureChaining;
import org.omg.sysml.lang.sysml.FeatureMembership;
import org.omg.sysml.lang.sysml.FeatureReferenceExpression;
import org.omg.sysml.lang.sysml.FeatureTyping;
import org.omg.sysml.lang.sysml.FeatureValue;
import org.omg.sysml.lang.sysml.FlowConnectionUsage;
import org.omg.sysml.lang.sysml.ForLoopActionUsage;
import org.omg.sysml.lang.sysml.ForkNode;
import org.omg.sysml.lang.sysml.FramedConcernMembership;
import org.omg.sysml.lang.sysml.Function;
import org.omg.sysml.lang.sysml.IfActionUsage;
import org.omg.sysml.lang.sysml.Import;
import org.omg.sysml.lang.sysml.IncludeUseCaseUsage;
import org.omg.sysml.lang.sysml.Interaction;
import org.omg.sysml.lang.sysml.InterfaceDefinition;
import org.omg.sysml.lang.sysml.InterfaceUsage;
import org.omg.sysml.lang.sysml.Invariant;
import org.omg.sysml.lang.sysml.InvocationExpression;
import org.omg.sysml.lang.sysml.ItemDefinition;
import org.omg.sysml.lang.sysml.ItemFeature;
import org.omg.sysml.lang.sysml.ItemFlow;
import org.omg.sysml.lang.sysml.ItemFlowEnd;
import org.omg.sysml.lang.sysml.ItemFlowFeature;
import org.omg.sysml.lang.sysml.ItemUsage;
import org.omg.sysml.lang.sysml.JoinNode;
import org.omg.sysml.lang.sysml.LifeClass;
import org.omg.sysml.lang.sysml.LiteralBoolean;
import org.omg.sysml.lang.sysml.LiteralExpression;
import org.omg.sysml.lang.sysml.LiteralInfinity;
import org.omg.sysml.lang.sysml.LiteralInteger;
import org.omg.sysml.lang.sysml.LiteralRational;
import org.omg.sysml.lang.sysml.LiteralString;
import org.omg.sysml.lang.sysml.Membership;
import org.omg.sysml.lang.sysml.MergeNode;
import org.omg.sysml.lang.sysml.MetadataFeature;
import org.omg.sysml.lang.sysml.MetadataFeatureValue;
import org.omg.sysml.lang.sysml.Multiplicity;
import org.omg.sysml.lang.sysml.MultiplicityRange;
import org.omg.sysml.lang.sysml.Namespace;
import org.omg.sysml.lang.sysml.NullExpression;
import org.omg.sysml.lang.sysml.ObjectiveMembership;
import org.omg.sysml.lang.sysml.OccurrenceDefinition;
import org.omg.sysml.lang.sysml.OccurrenceUsage;
import org.omg.sysml.lang.sysml.OperatorExpression;
import org.omg.sysml.lang.sysml.ParameterMembership;
import org.omg.sysml.lang.sysml.PartDefinition;
import org.omg.sysml.lang.sysml.PartUsage;
import org.omg.sysml.lang.sysml.PathSelectExpression;
import org.omg.sysml.lang.sysml.PathStepExpression;
import org.omg.sysml.lang.sysml.PerformActionUsage;
import org.omg.sysml.lang.sysml.PortConjugation;
import org.omg.sysml.lang.sysml.PortDefinition;
import org.omg.sysml.lang.sysml.PortUsage;
import org.omg.sysml.lang.sysml.PortioningFeature;
import org.omg.sysml.lang.sysml.Predicate;
import org.omg.sysml.lang.sysml.Redefinition;
import org.omg.sysml.lang.sysml.ReferenceUsage;
import org.omg.sysml.lang.sysml.Relationship;
import org.omg.sysml.lang.sysml.RenderingDefinition;
import org.omg.sysml.lang.sysml.RenderingUsage;
import org.omg.sysml.lang.sysml.RequirementConstraintMembership;
import org.omg.sysml.lang.sysml.RequirementDefinition;
import org.omg.sysml.lang.sysml.RequirementUsage;
import org.omg.sysml.lang.sysml.RequirementVerificationMembership;
import org.omg.sysml.lang.sysml.ResultExpressionMembership;
import org.omg.sysml.lang.sysml.ReturnParameterMembership;
import org.omg.sysml.lang.sysml.SatisfyRequirementUsage;
import org.omg.sysml.lang.sysml.SendActionUsage;
import org.omg.sysml.lang.sysml.SourceEnd;
import org.omg.sysml.lang.sysml.Specialization;
import org.omg.sysml.lang.sysml.StakeholderMembership;
import org.omg.sysml.lang.sysml.StateDefinition;
import org.omg.sysml.lang.sysml.StateSubactionMembership;
import org.omg.sysml.lang.sysml.StateUsage;
import org.omg.sysml.lang.sysml.Step;
import org.omg.sysml.lang.sysml.Structure;
import org.omg.sysml.lang.sysml.Subclassification;
import org.omg.sysml.lang.sysml.SubjectMembership;
import org.omg.sysml.lang.sysml.Subsetting;
import org.omg.sysml.lang.sysml.Succession;
import org.omg.sysml.lang.sysml.SuccessionAsUsage;
import org.omg.sysml.lang.sysml.SuccessionFlowConnectionUsage;
import org.omg.sysml.lang.sysml.SuccessionItemFlow;
import org.omg.sysml.lang.sysml.SysMLPackage;
import org.omg.sysml.lang.sysml.TargetEnd;
import org.omg.sysml.lang.sysml.TransitionFeatureMembership;
import org.omg.sysml.lang.sysml.TransitionUsage;
import org.omg.sysml.lang.sysml.Type;
import org.omg.sysml.lang.sysml.TypeFeaturing;
import org.omg.sysml.lang.sysml.UseCaseDefinition;
import org.omg.sysml.lang.sysml.UseCaseUsage;
import org.omg.sysml.lang.sysml.VariantMembership;
import org.omg.sysml.lang.sysml.VerificationCaseDefinition;
import org.omg.sysml.lang.sysml.VerificationCaseUsage;
import org.omg.sysml.lang.sysml.ViewDefinition;
import org.omg.sysml.lang.sysml.ViewRenderingMembership;
import org.omg.sysml.lang.sysml.ViewUsage;
import org.omg.sysml.lang.sysml.ViewpointDefinition;
import org.omg.sysml.lang.sysml.ViewpointUsage;
import org.omg.sysml.lang.sysml.WhileLoopActionUsage;
import org.omg.sysml.lang.sysml.*;

/**
 * <!-- begin-user-doc -->
 * An adapter that propagates notifications for derived unions.
 * <!-- end-user-doc -->
 * @see org.omg.sysml.lang.sysml.SysMLPackage
 * @generated
 */
public class SysMLDerivedUnionAdapter extends AdapterImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static SysMLPackage modelPackage;

	/**
	 * Creates an instance of the adapter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SysMLDerivedUnionAdapter() {
		if (modelPackage == null) {
			modelPackage = SysMLPackage.eINSTANCE;
		}
	}

	/**
	 * Calls <code>notifyChanged</code> with the appropriate model class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param notification a description of the change.
	 * @generated
	 */
	public void notifyChanged(Notification notification) {
		Object notifier = notification.getNotifier();
		if (notifier instanceof EObject) {
			EClass eClass = ((EObject)notifier).eClass();
			if (eClass.eContainer() == modelPackage) {
				notifyChanged(notification, eClass);
			}
		}
	}

	/**
	 * Calls <code>notifyXXXChanged</code> for the corresponding class of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param notification a description of the change.
	 * @param eClass the Ecore class of the notifier.
	 * @generated
	 */
	protected void notifyChanged(Notification notification, EClass eClass) {
		switch (eClass.getClassifierID()) {
			case SysMLPackage.SUBCLASSIFICATION:
				notifySubclassificationChanged(notification, eClass);
				break;
			case SysMLPackage.SPECIALIZATION:
				notifySpecializationChanged(notification, eClass);
				break;
			case SysMLPackage.RELATIONSHIP:
				notifyRelationshipChanged(notification, eClass);
				break;
			case SysMLPackage.MEMBERSHIP:
				notifyMembershipChanged(notification, eClass);
				break;
			case SysMLPackage.NAMESPACE:
				notifyNamespaceChanged(notification, eClass);
				break;
			case SysMLPackage.IMPORT:
				notifyImportChanged(notification, eClass);
				break;
			case SysMLPackage.DOCUMENTATION:
				notifyDocumentationChanged(notification, eClass);
				break;
			case SysMLPackage.ANNOTATION:
				notifyAnnotationChanged(notification, eClass);
				break;
			case SysMLPackage.TYPE:
				notifyTypeChanged(notification, eClass);
				break;
			case SysMLPackage.FEATURE_MEMBERSHIP:
				notifyFeatureMembershipChanged(notification, eClass);
				break;
			case SysMLPackage.TYPE_FEATURING:
				notifyTypeFeaturingChanged(notification, eClass);
				break;
			case SysMLPackage.FEATURE:
				notifyFeatureChanged(notification, eClass);
				break;
			case SysMLPackage.REDEFINITION:
				notifyRedefinitionChanged(notification, eClass);
				break;
			case SysMLPackage.SUBSETTING:
				notifySubsettingChanged(notification, eClass);
				break;
			case SysMLPackage.FEATURE_TYPING:
				notifyFeatureTypingChanged(notification, eClass);
				break;
			case SysMLPackage.FEATURE_CHAINING:
				notifyFeatureChainingChanged(notification, eClass);
				break;
			case SysMLPackage.CONJUGATION:
				notifyConjugationChanged(notification, eClass);
				break;
			case SysMLPackage.MULTIPLICITY:
				notifyMultiplicityChanged(notification, eClass);
				break;
			case SysMLPackage.DISJOINING:
				notifyDisjoiningChanged(notification, eClass);
				break;
			case SysMLPackage.CLASSIFIER:
				notifyClassifierChanged(notification, eClass);
				break;
			case SysMLPackage.RENDERING_DEFINITION:
				notifyRenderingDefinitionChanged(notification, eClass);
				break;
			case SysMLPackage.PART_DEFINITION:
				notifyPartDefinitionChanged(notification, eClass);
				break;
			case SysMLPackage.ITEM_DEFINITION:
				notifyItemDefinitionChanged(notification, eClass);
				break;
			case SysMLPackage.STRUCTURE:
				notifyStructureChanged(notification, eClass);
				break;
			case SysMLPackage.CLASS:
				notifyClassChanged(notification, eClass);
				break;
			case SysMLPackage.OCCURRENCE_DEFINITION:
				notifyOccurrenceDefinitionChanged(notification, eClass);
				break;
			case SysMLPackage.PORT_USAGE:
				notifyPortUsageChanged(notification, eClass);
				break;
			case SysMLPackage.OCCURRENCE_USAGE:
				notifyOccurrenceUsageChanged(notification, eClass);
				break;
			case SysMLPackage.PORTIONING_FEATURE:
				notifyPortioningFeatureChanged(notification, eClass);
				break;
			case SysMLPackage.PORT_DEFINITION:
				notifyPortDefinitionChanged(notification, eClass);
				break;
			case SysMLPackage.CONJUGATED_PORT_DEFINITION:
				notifyConjugatedPortDefinitionChanged(notification, eClass);
				break;
			case SysMLPackage.PORT_CONJUGATION:
				notifyPortConjugationChanged(notification, eClass);
				break;
			case SysMLPackage.ACTION_USAGE:
				notifyActionUsageChanged(notification, eClass);
				break;
			case SysMLPackage.STEP:
				notifyStepChanged(notification, eClass);
				break;
			case SysMLPackage.BEHAVIOR:
				notifyBehaviorChanged(notification, eClass);
				break;
			case SysMLPackage.STATE_USAGE:
				notifyStateUsageChanged(notification, eClass);
				break;
			case SysMLPackage.CONSTRAINT_USAGE:
				notifyConstraintUsageChanged(notification, eClass);
				break;
			case SysMLPackage.BOOLEAN_EXPRESSION:
				notifyBooleanExpressionChanged(notification, eClass);
				break;
			case SysMLPackage.EXPRESSION:
				notifyExpressionChanged(notification, eClass);
				break;
			case SysMLPackage.FUNCTION:
				notifyFunctionChanged(notification, eClass);
				break;
			case SysMLPackage.PREDICATE:
				notifyPredicateChanged(notification, eClass);
				break;
			case SysMLPackage.TRANSITION_USAGE:
				notifyTransitionUsageChanged(notification, eClass);
				break;
			case SysMLPackage.ACCEPT_ACTION_USAGE:
				notifyAcceptActionUsageChanged(notification, eClass);
				break;
			case SysMLPackage.SUCCESSION:
				notifySuccessionChanged(notification, eClass);
				break;
			case SysMLPackage.CONNECTOR:
				notifyConnectorChanged(notification, eClass);
				break;
			case SysMLPackage.ASSOCIATION:
				notifyAssociationChanged(notification, eClass);
				break;
			case SysMLPackage.REQUIREMENT_USAGE:
				notifyRequirementUsageChanged(notification, eClass);
				break;
			case SysMLPackage.REQUIREMENT_DEFINITION:
				notifyRequirementDefinitionChanged(notification, eClass);
				break;
			case SysMLPackage.CONSTRAINT_DEFINITION:
				notifyConstraintDefinitionChanged(notification, eClass);
				break;
			case SysMLPackage.CONCERN_USAGE:
				notifyConcernUsageChanged(notification, eClass);
				break;
			case SysMLPackage.CONCERN_DEFINITION:
				notifyConcernDefinitionChanged(notification, eClass);
				break;
			case SysMLPackage.PART_USAGE:
				notifyPartUsageChanged(notification, eClass);
				break;
			case SysMLPackage.ITEM_USAGE:
				notifyItemUsageChanged(notification, eClass);
				break;
			case SysMLPackage.CALCULATION_USAGE:
				notifyCalculationUsageChanged(notification, eClass);
				break;
			case SysMLPackage.CASE_USAGE:
				notifyCaseUsageChanged(notification, eClass);
				break;
			case SysMLPackage.CASE_DEFINITION:
				notifyCaseDefinitionChanged(notification, eClass);
				break;
			case SysMLPackage.CALCULATION_DEFINITION:
				notifyCalculationDefinitionChanged(notification, eClass);
				break;
			case SysMLPackage.ACTION_DEFINITION:
				notifyActionDefinitionChanged(notification, eClass);
				break;
			case SysMLPackage.ANALYSIS_CASE_USAGE:
				notifyAnalysisCaseUsageChanged(notification, eClass);
				break;
			case SysMLPackage.ANALYSIS_CASE_DEFINITION:
				notifyAnalysisCaseDefinitionChanged(notification, eClass);
				break;
			case SysMLPackage.VARIANT_MEMBERSHIP:
				notifyVariantMembershipChanged(notification, eClass);
				break;
			case SysMLPackage.REFERENCE_USAGE:
				notifyReferenceUsageChanged(notification, eClass);
				break;
			case SysMLPackage.INTERFACE_USAGE:
				notifyInterfaceUsageChanged(notification, eClass);
				break;
			case SysMLPackage.CONNECTION_USAGE:
				notifyConnectionUsageChanged(notification, eClass);
				break;
			case SysMLPackage.ASSOCIATION_STRUCTURE:
				notifyAssociationStructureChanged(notification, eClass);
				break;
			case SysMLPackage.INTERFACE_DEFINITION:
				notifyInterfaceDefinitionChanged(notification, eClass);
				break;
			case SysMLPackage.CONNECTION_DEFINITION:
				notifyConnectionDefinitionChanged(notification, eClass);
				break;
			case SysMLPackage.ATTRIBUTE_USAGE:
				notifyAttributeUsageChanged(notification, eClass);
				break;
			case SysMLPackage.DATA_TYPE:
				notifyDataTypeChanged(notification, eClass);
				break;
			case SysMLPackage.VIEW_USAGE:
				notifyViewUsageChanged(notification, eClass);
				break;
			case SysMLPackage.VIEW_DEFINITION:
				notifyViewDefinitionChanged(notification, eClass);
				break;
			case SysMLPackage.VIEWPOINT_USAGE:
				notifyViewpointUsageChanged(notification, eClass);
				break;
			case SysMLPackage.VIEWPOINT_DEFINITION:
				notifyViewpointDefinitionChanged(notification, eClass);
				break;
			case SysMLPackage.RENDERING_USAGE:
				notifyRenderingUsageChanged(notification, eClass);
				break;
			case SysMLPackage.VERIFICATION_CASE_USAGE:
				notifyVerificationCaseUsageChanged(notification, eClass);
				break;
			case SysMLPackage.VERIFICATION_CASE_DEFINITION:
				notifyVerificationCaseDefinitionChanged(notification, eClass);
				break;
			case SysMLPackage.ENUMERATION_USAGE:
				notifyEnumerationUsageChanged(notification, eClass);
				break;
			case SysMLPackage.ENUMERATION_DEFINITION:
				notifyEnumerationDefinitionChanged(notification, eClass);
				break;
			case SysMLPackage.ATTRIBUTE_DEFINITION:
				notifyAttributeDefinitionChanged(notification, eClass);
				break;
			case SysMLPackage.ALLOCATION_USAGE:
				notifyAllocationUsageChanged(notification, eClass);
				break;
			case SysMLPackage.ALLOCATION_DEFINITION:
				notifyAllocationDefinitionChanged(notification, eClass);
				break;
			case SysMLPackage.USE_CASE_USAGE:
				notifyUseCaseUsageChanged(notification, eClass);
				break;
			case SysMLPackage.USE_CASE_DEFINITION:
				notifyUseCaseDefinitionChanged(notification, eClass);
				break;
			case SysMLPackage.FLOW_CONNECTION_USAGE:
				notifyFlowConnectionUsageChanged(notification, eClass);
				break;
			case SysMLPackage.ITEM_FLOW:
				notifyItemFlowChanged(notification, eClass);
				break;
			case SysMLPackage.ITEM_FLOW_END:
				notifyItemFlowEndChanged(notification, eClass);
				break;
			case SysMLPackage.ITEM_FEATURE:
				notifyItemFeatureChanged(notification, eClass);
				break;
			case SysMLPackage.ITEM_FLOW_FEATURE:
				notifyItemFlowFeatureChanged(notification, eClass);
				break;
			case SysMLPackage.LIFE_CLASS:
				notifyLifeClassChanged(notification, eClass);
				break;
			case SysMLPackage.VIEW_RENDERING_MEMBERSHIP:
				notifyViewRenderingMembershipChanged(notification, eClass);
				break;
			case SysMLPackage.EXPOSE:
				notifyExposeChanged(notification, eClass);
				break;
			case SysMLPackage.TRANSITION_FEATURE_MEMBERSHIP:
				notifyTransitionFeatureMembershipChanged(notification, eClass);
				break;
			case SysMLPackage.EXHIBIT_STATE_USAGE:
				notifyExhibitStateUsageChanged(notification, eClass);
				break;
			case SysMLPackage.PERFORM_ACTION_USAGE:
				notifyPerformActionUsageChanged(notification, eClass);
				break;
			case SysMLPackage.EVENT_OCCURRENCE_USAGE:
				notifyEventOccurrenceUsageChanged(notification, eClass);
				break;
			case SysMLPackage.STATE_DEFINITION:
				notifyStateDefinitionChanged(notification, eClass);
				break;
			case SysMLPackage.STATE_SUBACTION_MEMBERSHIP:
				notifyStateSubactionMembershipChanged(notification, eClass);
				break;
			case SysMLPackage.DEPENDENCY:
				notifyDependencyChanged(notification, eClass);
				break;
			case SysMLPackage.ASSERT_CONSTRAINT_USAGE:
				notifyAssertConstraintUsageChanged(notification, eClass);
				break;
			case SysMLPackage.INVARIANT:
				notifyInvariantChanged(notification, eClass);
				break;
			case SysMLPackage.INCLUDE_USE_CASE_USAGE:
				notifyIncludeUseCaseUsageChanged(notification, eClass);
				break;
			case SysMLPackage.REQUIREMENT_VERIFICATION_MEMBERSHIP:
				notifyRequirementVerificationMembershipChanged(notification, eClass);
				break;
			case SysMLPackage.REQUIREMENT_CONSTRAINT_MEMBERSHIP:
				notifyRequirementConstraintMembershipChanged(notification, eClass);
				break;
			case SysMLPackage.SEND_ACTION_USAGE:
				notifySendActionUsageChanged(notification, eClass);
				break;
			case SysMLPackage.FOR_LOOP_ACTION_USAGE:
				notifyForLoopActionUsageChanged(notification, eClass);
				break;
			case SysMLPackage.MERGE_NODE:
				notifyMergeNodeChanged(notification, eClass);
				break;
			case SysMLPackage.IF_ACTION_USAGE:
				notifyIfActionUsageChanged(notification, eClass);
				break;
			case SysMLPackage.JOIN_NODE:
				notifyJoinNodeChanged(notification, eClass);
				break;
			case SysMLPackage.DECISION_NODE:
				notifyDecisionNodeChanged(notification, eClass);
				break;
			case SysMLPackage.WHILE_LOOP_ACTION_USAGE:
				notifyWhileLoopActionUsageChanged(notification, eClass);
				break;
			case SysMLPackage.ASSIGNMENT_ACTION_USAGE:
				notifyAssignmentActionUsageChanged(notification, eClass);
				break;
			case SysMLPackage.FORK_NODE:
				notifyForkNodeChanged(notification, eClass);
				break;
			case SysMLPackage.OBJECTIVE_MEMBERSHIP:
				notifyObjectiveMembershipChanged(notification, eClass);
				break;
			case SysMLPackage.SUBJECT_MEMBERSHIP:
				notifySubjectMembershipChanged(notification, eClass);
				break;
			case SysMLPackage.PARAMETER_MEMBERSHIP:
				notifyParameterMembershipChanged(notification, eClass);
				break;
			case SysMLPackage.STAKEHOLDER_MEMBERSHIP:
				notifyStakeholderMembershipChanged(notification, eClass);
				break;
			case SysMLPackage.ACTOR_MEMBERSHIP:
				notifyActorMembershipChanged(notification, eClass);
				break;
			case SysMLPackage.SATISFY_REQUIREMENT_USAGE:
				notifySatisfyRequirementUsageChanged(notification, eClass);
				break;
			case SysMLPackage.FRAMED_CONCERN_MEMBERSHIP:
				notifyFramedConcernMembershipChanged(notification, eClass);
				break;
			case SysMLPackage.CONJUGATED_PORT_TYPING:
				notifyConjugatedPortTypingChanged(notification, eClass);
				break;
			case SysMLPackage.BINDING_CONNECTOR_AS_USAGE:
				notifyBindingConnectorAsUsageChanged(notification, eClass);
				break;
			case SysMLPackage.BINDING_CONNECTOR:
				notifyBindingConnectorChanged(notification, eClass);
				break;
			case SysMLPackage.SUCCESSION_FLOW_CONNECTION_USAGE:
				notifySuccessionFlowConnectionUsageChanged(notification, eClass);
				break;
			case SysMLPackage.SUCCESSION_ITEM_FLOW:
				notifySuccessionItemFlowChanged(notification, eClass);
				break;
			case SysMLPackage.SUCCESSION_AS_USAGE:
				notifySuccessionAsUsageChanged(notification, eClass);
				break;
			case SysMLPackage.LITERAL_INTEGER:
				notifyLiteralIntegerChanged(notification, eClass);
				break;
			case SysMLPackage.LITERAL_EXPRESSION:
				notifyLiteralExpressionChanged(notification, eClass);
				break;
			case SysMLPackage.LITERAL_RATIONAL:
				notifyLiteralRationalChanged(notification, eClass);
				break;
			case SysMLPackage.NULL_EXPRESSION:
				notifyNullExpressionChanged(notification, eClass);
				break;
			case SysMLPackage.INVOCATION_EXPRESSION:
				notifyInvocationExpressionChanged(notification, eClass);
				break;
			case SysMLPackage.FEATURE_REFERENCE_EXPRESSION:
				notifyFeatureReferenceExpressionChanged(notification, eClass);
				break;
			case SysMLPackage.PATH_STEP_EXPRESSION:
				notifyPathStepExpressionChanged(notification, eClass);
				break;
			case SysMLPackage.OPERATOR_EXPRESSION:
				notifyOperatorExpressionChanged(notification, eClass);
				break;
			case SysMLPackage.LITERAL_BOOLEAN:
				notifyLiteralBooleanChanged(notification, eClass);
				break;
			case SysMLPackage.LITERAL_STRING:
				notifyLiteralStringChanged(notification, eClass);
				break;
			case SysMLPackage.PATH_SELECT_EXPRESSION:
				notifyPathSelectExpressionChanged(notification, eClass);
				break;
			case SysMLPackage.LITERAL_INFINITY:
				notifyLiteralInfinityChanged(notification, eClass);
				break;
			case SysMLPackage.MULTIPLICITY_RANGE:
				notifyMultiplicityRangeChanged(notification, eClass);
				break;
			case SysMLPackage.PACKAGE:
				notifyPackageChanged(notification, eClass);
				break;
			case SysMLPackage.ELEMENT_FILTER_MEMBERSHIP:
				notifyElementFilterMembershipChanged(notification, eClass);
				break;
			case SysMLPackage.RESULT_EXPRESSION_MEMBERSHIP:
				notifyResultExpressionMembershipChanged(notification, eClass);
				break;
			case SysMLPackage.RETURN_PARAMETER_MEMBERSHIP:
				notifyReturnParameterMembershipChanged(notification, eClass);
				break;
			case SysMLPackage.INTERACTION:
				notifyInteractionChanged(notification, eClass);
				break;
			case SysMLPackage.ANNOTATING_FEATURE:
				notifyAnnotatingFeatureChanged(notification, eClass);
				break;
			case SysMLPackage.METADATA_FEATURE:
				notifyMetadataFeatureChanged(notification, eClass);
				break;
			case SysMLPackage.METADATA_FEATURE_VALUE:
				notifyMetadataFeatureValueChanged(notification, eClass);
				break;
			case SysMLPackage.FEATURE_VALUE:
				notifyFeatureValueChanged(notification, eClass);
				break;
			case SysMLPackage.SOURCE_END:
				notifySourceEndChanged(notification, eClass);
				break;
			case SysMLPackage.TARGET_END:
				notifyTargetEndChanged(notification, eClass);
				break;
			case SysMLPackage.END_FEATURE_MEMBERSHIP:
				notifyEndFeatureMembershipChanged(notification, eClass);
				break;
		}
	}

	/**
	 * Does nothing; clients may override so that it does something.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param notification a description of the change.
	 * @param eClass the Ecore class of the notifier.
	 * @param derivedUnion the derived union affected by the change.
	 * @generated
	 */
	public void notifyChanged(Notification notification, EClass eClass, EStructuralFeature derivedUnion) {
		// Do nothing.
	}

	/**
	 * Calls <code>notifyChanged</code> for each affected derived union.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param notification a description of the change.
	 * @param eClass the Ecore class of the notifier.
	 * @generated
	 */
	protected void notifySubclassificationChanged(Notification notification, EClass eClass) {
		switch (notification.getFeatureID(Subclassification.class)) {
			case SysMLPackage.SUBCLASSIFICATION__OWNED_RELATED_ELEMENT:
				notifyChanged(notification, eClass, SysMLPackage.Literals.RELATIONSHIP__RELATED_ELEMENT);
				break;
			case SysMLPackage.SUBCLASSIFICATION__OWNING_RELATED_ELEMENT:
				notifyChanged(notification, eClass, SysMLPackage.Literals.RELATIONSHIP__RELATED_ELEMENT);
				break;
			case SysMLPackage.SUBCLASSIFICATION__TARGET:
				notifyChanged(notification, eClass, SysMLPackage.Literals.RELATIONSHIP__RELATED_ELEMENT);
				break;
			case SysMLPackage.SUBCLASSIFICATION__SOURCE:
				notifyChanged(notification, eClass, SysMLPackage.Literals.RELATIONSHIP__RELATED_ELEMENT);
				break;
			case SysMLPackage.SUBCLASSIFICATION__OWNING_TYPE:
				notifyChanged(notification, eClass, SysMLPackage.Literals.RELATIONSHIP__RELATED_ELEMENT);
				break;
		}
	}

	/**
	 * Calls <code>notifyChanged</code> for each affected derived union.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param notification a description of the change.
	 * @param eClass the Ecore class of the notifier.
	 * @generated
	 */
	protected void notifySpecializationChanged(Notification notification, EClass eClass) {
		switch (notification.getFeatureID(Specialization.class)) {
			case SysMLPackage.SPECIALIZATION__OWNED_RELATED_ELEMENT:
				notifyChanged(notification, eClass, SysMLPackage.Literals.RELATIONSHIP__RELATED_ELEMENT);
				break;
			case SysMLPackage.SPECIALIZATION__OWNING_RELATED_ELEMENT:
				notifyChanged(notification, eClass, SysMLPackage.Literals.RELATIONSHIP__RELATED_ELEMENT);
				break;
			case SysMLPackage.SPECIALIZATION__TARGET:
				notifyChanged(notification, eClass, SysMLPackage.Literals.RELATIONSHIP__RELATED_ELEMENT);
				break;
			case SysMLPackage.SPECIALIZATION__SOURCE:
				notifyChanged(notification, eClass, SysMLPackage.Literals.RELATIONSHIP__RELATED_ELEMENT);
				break;
			case SysMLPackage.SPECIALIZATION__OWNING_TYPE:
				notifyChanged(notification, eClass, SysMLPackage.Literals.RELATIONSHIP__RELATED_ELEMENT);
				break;
		}
	}

	/**
	 * Calls <code>notifyChanged</code> for each affected derived union.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param notification a description of the change.
	 * @param eClass the Ecore class of the notifier.
	 * @generated
	 */
	protected void notifySendActionUsageChanged(Notification notification, EClass eClass) {
		switch (notification.getFeatureID(SendActionUsage.class)) {
			case SysMLPackage.SEND_ACTION_USAGE__IMPORTED_MEMBERSHIP:
				notifyChanged(notification, eClass, SysMLPackage.Literals.NAMESPACE__MEMBERSHIP);
				break;
			case SysMLPackage.SEND_ACTION_USAGE__OWNED_MEMBERSHIP:
				notifyChanged(notification, eClass, SysMLPackage.Literals.NAMESPACE__MEMBERSHIP);
				break;
			case SysMLPackage.SEND_ACTION_USAGE__OWNED_FEATURE_MEMBERSHIP:
				notifyChanged(notification, eClass, SysMLPackage.Literals.NAMESPACE__MEMBERSHIP);
				break;
			case SysMLPackage.SEND_ACTION_USAGE__INHERITED_MEMBERSHIP:
				notifyChanged(notification, eClass, SysMLPackage.Literals.NAMESPACE__MEMBERSHIP);
				break;
			case SysMLPackage.SEND_ACTION_USAGE__VARIANT_MEMBERSHIP:
				notifyChanged(notification, eClass, SysMLPackage.Literals.NAMESPACE__MEMBERSHIP);
				break;
		}
	}

	/**
	 * Calls <code>notifyChanged</code> for each affected derived union.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param notification a description of the change.
	 * @param eClass the Ecore class of the notifier.
	 * @generated
	 */
	protected void notifyForLoopActionUsageChanged(Notification notification, EClass eClass) {
		switch (notification.getFeatureID(ForLoopActionUsage.class)) {
			case SysMLPackage.FOR_LOOP_ACTION_USAGE__IMPORTED_MEMBERSHIP:
				notifyChanged(notification, eClass, SysMLPackage.Literals.NAMESPACE__MEMBERSHIP);
				break;
			case SysMLPackage.FOR_LOOP_ACTION_USAGE__OWNED_MEMBERSHIP:
				notifyChanged(notification, eClass, SysMLPackage.Literals.NAMESPACE__MEMBERSHIP);
				break;
			case SysMLPackage.FOR_LOOP_ACTION_USAGE__OWNED_FEATURE_MEMBERSHIP:
				notifyChanged(notification, eClass, SysMLPackage.Literals.NAMESPACE__MEMBERSHIP);
				break;
			case SysMLPackage.FOR_LOOP_ACTION_USAGE__INHERITED_MEMBERSHIP:
				notifyChanged(notification, eClass, SysMLPackage.Literals.NAMESPACE__MEMBERSHIP);
				break;
			case SysMLPackage.FOR_LOOP_ACTION_USAGE__VARIANT_MEMBERSHIP:
				notifyChanged(notification, eClass, SysMLPackage.Literals.NAMESPACE__MEMBERSHIP);
				break;
		}
	}

	/**
	 * Calls <code>notifyChanged</code> for each affected derived union.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param notification a description of the change.
	 * @param eClass the Ecore class of the notifier.
	 * @generated
	 */
	protected void notifyAssertConstraintUsageChanged(Notification notification, EClass eClass) {
		switch (notification.getFeatureID(AssertConstraintUsage.class)) {
			case SysMLPackage.ASSERT_CONSTRAINT_USAGE__IMPORTED_MEMBERSHIP:
				notifyChanged(notification, eClass, SysMLPackage.Literals.NAMESPACE__MEMBERSHIP);
				break;
			case SysMLPackage.ASSERT_CONSTRAINT_USAGE__OWNED_MEMBERSHIP:
				notifyChanged(notification, eClass, SysMLPackage.Literals.NAMESPACE__MEMBERSHIP);
				break;
			case SysMLPackage.ASSERT_CONSTRAINT_USAGE__OWNED_FEATURE_MEMBERSHIP:
				notifyChanged(notification, eClass, SysMLPackage.Literals.NAMESPACE__MEMBERSHIP);
				break;
			case SysMLPackage.ASSERT_CONSTRAINT_USAGE__INHERITED_MEMBERSHIP:
				notifyChanged(notification, eClass, SysMLPackage.Literals.NAMESPACE__MEMBERSHIP);
				break;
			case SysMLPackage.ASSERT_CONSTRAINT_USAGE__VARIANT_MEMBERSHIP:
				notifyChanged(notification, eClass, SysMLPackage.Literals.NAMESPACE__MEMBERSHIP);
				break;
		}
	}

	/**
	 * Calls <code>notifyChanged</code> for each affected derived union.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param notification a description of the change.
	 * @param eClass the Ecore class of the notifier.
	 * @generated
	 */
	protected void notifyExposeChanged(Notification notification, EClass eClass) {
		switch (notification.getFeatureID(Expose.class)) {
			case SysMLPackage.EXPOSE__OWNED_RELATED_ELEMENT:
				notifyChanged(notification, eClass, SysMLPackage.Literals.RELATIONSHIP__RELATED_ELEMENT);
				break;
			case SysMLPackage.EXPOSE__OWNING_RELATED_ELEMENT:
				notifyChanged(notification, eClass, SysMLPackage.Literals.RELATIONSHIP__RELATED_ELEMENT);
				break;
			case SysMLPackage.EXPOSE__TARGET:
				notifyChanged(notification, eClass, SysMLPackage.Literals.RELATIONSHIP__RELATED_ELEMENT);
				break;
			case SysMLPackage.EXPOSE__SOURCE:
				notifyChanged(notification, eClass, SysMLPackage.Literals.RELATIONSHIP__RELATED_ELEMENT);
				break;
			case SysMLPackage.EXPOSE__IMPORT_OWNING_NAMESPACE:
				notifyChanged(notification, eClass, SysMLPackage.Literals.RELATIONSHIP__RELATED_ELEMENT);
				break;
		}
	}

	/**
	 * Calls <code>notifyChanged</code> for each affected derived union.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param notification a description of the change.
	 * @param eClass the Ecore class of the notifier.
	 * @generated
	 */
	protected void notifyViewRenderingMembershipChanged(Notification notification, EClass eClass) {
		switch (notification.getFeatureID(ViewRenderingMembership.class)) {
			case SysMLPackage.VIEW_RENDERING_MEMBERSHIP__OWNED_RELATED_ELEMENT:
				notifyChanged(notification, eClass, SysMLPackage.Literals.RELATIONSHIP__RELATED_ELEMENT);
				break;
			case SysMLPackage.VIEW_RENDERING_MEMBERSHIP__OWNING_RELATED_ELEMENT:
				notifyChanged(notification, eClass, SysMLPackage.Literals.RELATIONSHIP__RELATED_ELEMENT);
				break;
			case SysMLPackage.VIEW_RENDERING_MEMBERSHIP__TARGET:
				notifyChanged(notification, eClass, SysMLPackage.Literals.RELATIONSHIP__RELATED_ELEMENT);
				break;
			case SysMLPackage.VIEW_RENDERING_MEMBERSHIP__SOURCE:
				notifyChanged(notification, eClass, SysMLPackage.Literals.RELATIONSHIP__RELATED_ELEMENT);
				break;
			case SysMLPackage.VIEW_RENDERING_MEMBERSHIP__MEMBERSHIP_OWNING_NAMESPACE:
				notifyChanged(notification, eClass, SysMLPackage.Literals.RELATIONSHIP__RELATED_ELEMENT);
				break;
			case SysMLPackage.VIEW_RENDERING_MEMBERSHIP__OWNED_MEMBER_ELEMENT:
				notifyChanged(notification, eClass, SysMLPackage.Literals.RELATIONSHIP__RELATED_ELEMENT);
				break;
			case SysMLPackage.VIEW_RENDERING_MEMBERSHIP__OWNING_FEATURE_OF_TYPE:
				notifyChanged(notification, eClass, SysMLPackage.Literals.RELATIONSHIP__RELATED_ELEMENT);
				break;
		}
	}

	/**
	 * Calls <code>notifyChanged</code> for each affected derived union.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param notification a description of the change.
	 * @param eClass the Ecore class of the notifier.
	 * @generated
	 */
	protected void notifyEventOccurrenceUsageChanged(Notification notification, EClass eClass) {
		switch (notification.getFeatureID(EventOccurrenceUsage.class)) {
			case SysMLPackage.EVENT_OCCURRENCE_USAGE__IMPORTED_MEMBERSHIP:
				notifyChanged(notification, eClass, SysMLPackage.Literals.NAMESPACE__MEMBERSHIP);
				break;
			case SysMLPackage.EVENT_OCCURRENCE_USAGE__OWNED_MEMBERSHIP:
				notifyChanged(notification, eClass, SysMLPackage.Literals.NAMESPACE__MEMBERSHIP);
				break;
			case SysMLPackage.EVENT_OCCURRENCE_USAGE__OWNED_FEATURE_MEMBERSHIP:
				notifyChanged(notification, eClass, SysMLPackage.Literals.NAMESPACE__MEMBERSHIP);
				break;
			case SysMLPackage.EVENT_OCCURRENCE_USAGE__INHERITED_MEMBERSHIP:
				notifyChanged(notification, eClass, SysMLPackage.Literals.NAMESPACE__MEMBERSHIP);
				break;
			case SysMLPackage.EVENT_OCCURRENCE_USAGE__VARIANT_MEMBERSHIP:
				notifyChanged(notification, eClass, SysMLPackage.Literals.NAMESPACE__MEMBERSHIP);
				break;
		}
	}

	/**
	 * Calls <code>notifyChanged</code> for each affected derived union.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param notification a description of the change.
	 * @param eClass the Ecore class of the notifier.
	 * @generated
	 */
	protected void notifyRequirementVerificationMembershipChanged(Notification notification, EClass eClass) {
		switch (notification.getFeatureID(RequirementVerificationMembership.class)) {
			case SysMLPackage.REQUIREMENT_VERIFICATION_MEMBERSHIP__OWNED_RELATED_ELEMENT:
				notifyChanged(notification, eClass, SysMLPackage.Literals.RELATIONSHIP__RELATED_ELEMENT);
				break;
			case SysMLPackage.REQUIREMENT_VERIFICATION_MEMBERSHIP__OWNING_RELATED_ELEMENT:
				notifyChanged(notification, eClass, SysMLPackage.Literals.RELATIONSHIP__RELATED_ELEMENT);
				break;
			case SysMLPackage.REQUIREMENT_VERIFICATION_MEMBERSHIP__TARGET:
				notifyChanged(notification, eClass, SysMLPackage.Literals.RELATIONSHIP__RELATED_ELEMENT);
				break;
			case SysMLPackage.REQUIREMENT_VERIFICATION_MEMBERSHIP__SOURCE:
				notifyChanged(notification, eClass, SysMLPackage.Literals.RELATIONSHIP__RELATED_ELEMENT);
				break;
			case SysMLPackage.REQUIREMENT_VERIFICATION_MEMBERSHIP__MEMBERSHIP_OWNING_NAMESPACE:
				notifyChanged(notification, eClass, SysMLPackage.Literals.RELATIONSHIP__RELATED_ELEMENT);
				break;
			case SysMLPackage.REQUIREMENT_VERIFICATION_MEMBERSHIP__OWNED_MEMBER_ELEMENT:
				notifyChanged(notification, eClass, SysMLPackage.Literals.RELATIONSHIP__RELATED_ELEMENT);
				break;
			case SysMLPackage.REQUIREMENT_VERIFICATION_MEMBERSHIP__OWNING_FEATURE_OF_TYPE:
				notifyChanged(notification, eClass, SysMLPackage.Literals.RELATIONSHIP__RELATED_ELEMENT);
				break;
		}
	}

	/**
	 * Calls <code>notifyChanged</code> for each affected derived union.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param notification a description of the change.
	 * @param eClass the Ecore class of the notifier.
	 * @generated
	 */
	protected void notifySubjectMembershipChanged(Notification notification, EClass eClass) {
		switch (notification.getFeatureID(SubjectMembership.class)) {
			case SysMLPackage.SUBJECT_MEMBERSHIP__OWNED_RELATED_ELEMENT:
				notifyChanged(notification, eClass, SysMLPackage.Literals.RELATIONSHIP__RELATED_ELEMENT);
				break;
			case SysMLPackage.SUBJECT_MEMBERSHIP__OWNING_RELATED_ELEMENT:
				notifyChanged(notification, eClass, SysMLPackage.Literals.RELATIONSHIP__RELATED_ELEMENT);
				break;
			case SysMLPackage.SUBJECT_MEMBERSHIP__TARGET:
				notifyChanged(notification, eClass, SysMLPackage.Literals.RELATIONSHIP__RELATED_ELEMENT);
				break;
			case SysMLPackage.SUBJECT_MEMBERSHIP__SOURCE:
				notifyChanged(notification, eClass, SysMLPackage.Literals.RELATIONSHIP__RELATED_ELEMENT);
				break;
			case SysMLPackage.SUBJECT_MEMBERSHIP__MEMBERSHIP_OWNING_NAMESPACE:
				notifyChanged(notification, eClass, SysMLPackage.Literals.RELATIONSHIP__RELATED_ELEMENT);
				break;
			case SysMLPackage.SUBJECT_MEMBERSHIP__OWNED_MEMBER_ELEMENT:
				notifyChanged(notification, eClass, SysMLPackage.Literals.RELATIONSHIP__RELATED_ELEMENT);
				break;
			case SysMLPackage.SUBJECT_MEMBERSHIP__OWNING_FEATURE_OF_TYPE:
				notifyChanged(notification, eClass, SysMLPackage.Literals.RELATIONSHIP__RELATED_ELEMENT);
				break;
		}
	}

	/**
	 * Calls <code>notifyChanged</code> for each affected derived union.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param notification a description of the change.
	 * @param eClass the Ecore class of the notifier.
	 * @generated
	 */
	protected void notifyObjectiveMembershipChanged(Notification notification, EClass eClass) {
		switch (notification.getFeatureID(ObjectiveMembership.class)) {
			case SysMLPackage.OBJECTIVE_MEMBERSHIP__OWNED_RELATED_ELEMENT:
				notifyChanged(notification, eClass, SysMLPackage.Literals.RELATIONSHIP__RELATED_ELEMENT);
				break;
			case SysMLPackage.OBJECTIVE_MEMBERSHIP__OWNING_RELATED_ELEMENT:
				notifyChanged(notification, eClass, SysMLPackage.Literals.RELATIONSHIP__RELATED_ELEMENT);
				break;
			case SysMLPackage.OBJECTIVE_MEMBERSHIP__TARGET:
				notifyChanged(notification, eClass, SysMLPackage.Literals.RELATIONSHIP__RELATED_ELEMENT);
				break;
			case SysMLPackage.OBJECTIVE_MEMBERSHIP__SOURCE:
				notifyChanged(notification, eClass, SysMLPackage.Literals.RELATIONSHIP__RELATED_ELEMENT);
				break;
			case SysMLPackage.OBJECTIVE_MEMBERSHIP__MEMBERSHIP_OWNING_NAMESPACE:
				notifyChanged(notification, eClass, SysMLPackage.Literals.RELATIONSHIP__RELATED_ELEMENT);
				break;
			case SysMLPackage.OBJECTIVE_MEMBERSHIP__OWNED_MEMBER_ELEMENT:
				notifyChanged(notification, eClass, SysMLPackage.Literals.RELATIONSHIP__RELATED_ELEMENT);
				break;
			case SysMLPackage.OBJECTIVE_MEMBERSHIP__OWNING_FEATURE_OF_TYPE:
				notifyChanged(notification, eClass, SysMLPackage.Literals.RELATIONSHIP__RELATED_ELEMENT);
				break;
		}
	}

	/**
	 * Calls <code>notifyChanged</code> for each affected derived union.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param notification a description of the change.
	 * @param eClass the Ecore class of the notifier.
	 * @generated
	 */
	protected void notifyAcceptActionUsageChanged(Notification notification, EClass eClass) {
		switch (notification.getFeatureID(AcceptActionUsage.class)) {
			case SysMLPackage.ACCEPT_ACTION_USAGE__IMPORTED_MEMBERSHIP:
				notifyChanged(notification, eClass, SysMLPackage.Literals.NAMESPACE__MEMBERSHIP);
				break;
			case SysMLPackage.ACCEPT_ACTION_USAGE__OWNED_MEMBERSHIP:
				notifyChanged(notification, eClass, SysMLPackage.Literals.NAMESPACE__MEMBERSHIP);
				break;
			case SysMLPackage.ACCEPT_ACTION_USAGE__OWNED_FEATURE_MEMBERSHIP:
				notifyChanged(notification, eClass, SysMLPackage.Literals.NAMESPACE__MEMBERSHIP);
				break;
			case SysMLPackage.ACCEPT_ACTION_USAGE__INHERITED_MEMBERSHIP:
				notifyChanged(notification, eClass, SysMLPackage.Literals.NAMESPACE__MEMBERSHIP);
				break;
			case SysMLPackage.ACCEPT_ACTION_USAGE__VARIANT_MEMBERSHIP:
				notifyChanged(notification, eClass, SysMLPackage.Literals.NAMESPACE__MEMBERSHIP);
				break;
		}
	}

	/**
	 * Calls <code>notifyChanged</code> for each affected derived union.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param notification a description of the change.
	 * @param eClass the Ecore class of the notifier.
	 * @generated
	 */
	protected void notifyPerformActionUsageChanged(Notification notification, EClass eClass) {
		switch (notification.getFeatureID(PerformActionUsage.class)) {
			case SysMLPackage.PERFORM_ACTION_USAGE__IMPORTED_MEMBERSHIP:
				notifyChanged(notification, eClass, SysMLPackage.Literals.NAMESPACE__MEMBERSHIP);
				break;
			case SysMLPackage.PERFORM_ACTION_USAGE__OWNED_MEMBERSHIP:
				notifyChanged(notification, eClass, SysMLPackage.Literals.NAMESPACE__MEMBERSHIP);
				break;
			case SysMLPackage.PERFORM_ACTION_USAGE__OWNED_FEATURE_MEMBERSHIP:
				notifyChanged(notification, eClass, SysMLPackage.Literals.NAMESPACE__MEMBERSHIP);
				break;
			case SysMLPackage.PERFORM_ACTION_USAGE__INHERITED_MEMBERSHIP:
				notifyChanged(notification, eClass, SysMLPackage.Literals.NAMESPACE__MEMBERSHIP);
				break;
			case SysMLPackage.PERFORM_ACTION_USAGE__VARIANT_MEMBERSHIP:
				notifyChanged(notification, eClass, SysMLPackage.Literals.NAMESPACE__MEMBERSHIP);
				break;
		}
	}

	/**
	 * Calls <code>notifyChanged</code> for each affected derived union.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param notification a description of the change.
	 * @param eClass the Ecore class of the notifier.
	 * @generated
	 */
	protected void notifyForkNodeChanged(Notification notification, EClass eClass) {
		switch (notification.getFeatureID(ForkNode.class)) {
			case SysMLPackage.FORK_NODE__IMPORTED_MEMBERSHIP:
				notifyChanged(notification, eClass, SysMLPackage.Literals.NAMESPACE__MEMBERSHIP);
				break;
			case SysMLPackage.FORK_NODE__OWNED_MEMBERSHIP:
				notifyChanged(notification, eClass, SysMLPackage.Literals.NAMESPACE__MEMBERSHIP);
				break;
			case SysMLPackage.FORK_NODE__OWNED_FEATURE_MEMBERSHIP:
				notifyChanged(notification, eClass, SysMLPackage.Literals.NAMESPACE__MEMBERSHIP);
				break;
			case SysMLPackage.FORK_NODE__INHERITED_MEMBERSHIP:
				notifyChanged(notification, eClass, SysMLPackage.Literals.NAMESPACE__MEMBERSHIP);
				break;
			case SysMLPackage.FORK_NODE__VARIANT_MEMBERSHIP:
				notifyChanged(notification, eClass, SysMLPackage.Literals.NAMESPACE__MEMBERSHIP);
				break;
		}
	}

	/**
	 * Calls <code>notifyChanged</code> for each affected derived union.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param notification a description of the change.
	 * @param eClass the Ecore class of the notifier.
	 * @generated
	 */
	protected void notifyDecisionNodeChanged(Notification notification, EClass eClass) {
		switch (notification.getFeatureID(DecisionNode.class)) {
			case SysMLPackage.DECISION_NODE__IMPORTED_MEMBERSHIP:
				notifyChanged(notification, eClass, SysMLPackage.Literals.NAMESPACE__MEMBERSHIP);
				break;
			case SysMLPackage.DECISION_NODE__OWNED_MEMBERSHIP:
				notifyChanged(notification, eClass, SysMLPackage.Literals.NAMESPACE__MEMBERSHIP);
				break;
			case SysMLPackage.DECISION_NODE__OWNED_FEATURE_MEMBERSHIP:
				notifyChanged(notification, eClass, SysMLPackage.Literals.NAMESPACE__MEMBERSHIP);
				break;
			case SysMLPackage.DECISION_NODE__INHERITED_MEMBERSHIP:
				notifyChanged(notification, eClass, SysMLPackage.Literals.NAMESPACE__MEMBERSHIP);
				break;
			case SysMLPackage.DECISION_NODE__VARIANT_MEMBERSHIP:
				notifyChanged(notification, eClass, SysMLPackage.Literals.NAMESPACE__MEMBERSHIP);
				break;
		}
	}

	/**
	 * Calls <code>notifyChanged</code> for each affected derived union.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param notification a description of the change.
	 * @param eClass the Ecore class of the notifier.
	 * @generated
	 */
	protected void notifyWhileLoopActionUsageChanged(Notification notification, EClass eClass) {
		switch (notification.getFeatureID(WhileLoopActionUsage.class)) {
			case SysMLPackage.WHILE_LOOP_ACTION_USAGE__IMPORTED_MEMBERSHIP:
				notifyChanged(notification, eClass, SysMLPackage.Literals.NAMESPACE__MEMBERSHIP);
				break;
			case SysMLPackage.WHILE_LOOP_ACTION_USAGE__OWNED_MEMBERSHIP:
				notifyChanged(notification, eClass, SysMLPackage.Literals.NAMESPACE__MEMBERSHIP);
				break;
			case SysMLPackage.WHILE_LOOP_ACTION_USAGE__OWNED_FEATURE_MEMBERSHIP:
				notifyChanged(notification, eClass, SysMLPackage.Literals.NAMESPACE__MEMBERSHIP);
				break;
			case SysMLPackage.WHILE_LOOP_ACTION_USAGE__INHERITED_MEMBERSHIP:
				notifyChanged(notification, eClass, SysMLPackage.Literals.NAMESPACE__MEMBERSHIP);
				break;
			case SysMLPackage.WHILE_LOOP_ACTION_USAGE__VARIANT_MEMBERSHIP:
				notifyChanged(notification, eClass, SysMLPackage.Literals.NAMESPACE__MEMBERSHIP);
				break;
		}
	}

	/**
	 * Calls <code>notifyChanged</code> for each affected derived union.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param notification a description of the change.
	 * @param eClass the Ecore class of the notifier.
	 * @generated
	 */
	protected void notifyAssignmentActionUsageChanged(Notification notification, EClass eClass) {
		switch (notification.getFeatureID(AssignmentActionUsage.class)) {
			case SysMLPackage.ASSIGNMENT_ACTION_USAGE__IMPORTED_MEMBERSHIP:
				notifyChanged(notification, eClass, SysMLPackage.Literals.NAMESPACE__MEMBERSHIP);
				break;
			case SysMLPackage.ASSIGNMENT_ACTION_USAGE__OWNED_MEMBERSHIP:
				notifyChanged(notification, eClass, SysMLPackage.Literals.NAMESPACE__MEMBERSHIP);
				break;
			case SysMLPackage.ASSIGNMENT_ACTION_USAGE__OWNED_FEATURE_MEMBERSHIP:
				notifyChanged(notification, eClass, SysMLPackage.Literals.NAMESPACE__MEMBERSHIP);
				break;
			case SysMLPackage.ASSIGNMENT_ACTION_USAGE__INHERITED_MEMBERSHIP:
				notifyChanged(notification, eClass, SysMLPackage.Literals.NAMESPACE__MEMBERSHIP);
				break;
			case SysMLPackage.ASSIGNMENT_ACTION_USAGE__VARIANT_MEMBERSHIP:
				notifyChanged(notification, eClass, SysMLPackage.Literals.NAMESPACE__MEMBERSHIP);
				break;
		}
	}

	/**
	 * Calls <code>notifyChanged</code> for each affected derived union.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param notification a description of the change.
	 * @param eClass the Ecore class of the notifier.
	 * @generated
	 */
	protected void notifyJoinNodeChanged(Notification notification, EClass eClass) {
		switch (notification.getFeatureID(JoinNode.class)) {
			case SysMLPackage.JOIN_NODE__IMPORTED_MEMBERSHIP:
				notifyChanged(notification, eClass, SysMLPackage.Literals.NAMESPACE__MEMBERSHIP);
				break;
			case SysMLPackage.JOIN_NODE__OWNED_MEMBERSHIP:
				notifyChanged(notification, eClass, SysMLPackage.Literals.NAMESPACE__MEMBERSHIP);
				break;
			case SysMLPackage.JOIN_NODE__OWNED_FEATURE_MEMBERSHIP:
				notifyChanged(notification, eClass, SysMLPackage.Literals.NAMESPACE__MEMBERSHIP);
				break;
			case SysMLPackage.JOIN_NODE__INHERITED_MEMBERSHIP:
				notifyChanged(notification, eClass, SysMLPackage.Literals.NAMESPACE__MEMBERSHIP);
				break;
			case SysMLPackage.JOIN_NODE__VARIANT_MEMBERSHIP:
				notifyChanged(notification, eClass, SysMLPackage.Literals.NAMESPACE__MEMBERSHIP);
				break;
		}
	}

	/**
	 * Calls <code>notifyChanged</code> for each affected derived union.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param notification a description of the change.
	 * @param eClass the Ecore class of the notifier.
	 * @generated
	 */
	protected void notifyMergeNodeChanged(Notification notification, EClass eClass) {
		switch (notification.getFeatureID(MergeNode.class)) {
			case SysMLPackage.MERGE_NODE__IMPORTED_MEMBERSHIP:
				notifyChanged(notification, eClass, SysMLPackage.Literals.NAMESPACE__MEMBERSHIP);
				break;
			case SysMLPackage.MERGE_NODE__OWNED_MEMBERSHIP:
				notifyChanged(notification, eClass, SysMLPackage.Literals.NAMESPACE__MEMBERSHIP);
				break;
			case SysMLPackage.MERGE_NODE__OWNED_FEATURE_MEMBERSHIP:
				notifyChanged(notification, eClass, SysMLPackage.Literals.NAMESPACE__MEMBERSHIP);
				break;
			case SysMLPackage.MERGE_NODE__INHERITED_MEMBERSHIP:
				notifyChanged(notification, eClass, SysMLPackage.Literals.NAMESPACE__MEMBERSHIP);
				break;
			case SysMLPackage.MERGE_NODE__VARIANT_MEMBERSHIP:
				notifyChanged(notification, eClass, SysMLPackage.Literals.NAMESPACE__MEMBERSHIP);
				break;
		}
	}

	/**
	 * Calls <code>notifyChanged</code> for each affected derived union.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param notification a description of the change.
	 * @param eClass the Ecore class of the notifier.
	 * @generated
	 */
	protected void notifyIfActionUsageChanged(Notification notification, EClass eClass) {
		switch (notification.getFeatureID(IfActionUsage.class)) {
			case SysMLPackage.IF_ACTION_USAGE__IMPORTED_MEMBERSHIP:
				notifyChanged(notification, eClass, SysMLPackage.Literals.NAMESPACE__MEMBERSHIP);
				break;
			case SysMLPackage.IF_ACTION_USAGE__OWNED_MEMBERSHIP:
				notifyChanged(notification, eClass, SysMLPackage.Literals.NAMESPACE__MEMBERSHIP);
				break;
			case SysMLPackage.IF_ACTION_USAGE__OWNED_FEATURE_MEMBERSHIP:
				notifyChanged(notification, eClass, SysMLPackage.Literals.NAMESPACE__MEMBERSHIP);
				break;
			case SysMLPackage.IF_ACTION_USAGE__INHERITED_MEMBERSHIP:
				notifyChanged(notification, eClass, SysMLPackage.Literals.NAMESPACE__MEMBERSHIP);
				break;
			case SysMLPackage.IF_ACTION_USAGE__VARIANT_MEMBERSHIP:
				notifyChanged(notification, eClass, SysMLPackage.Literals.NAMESPACE__MEMBERSHIP);
				break;
		}
	}

	/**
	 * Calls <code>notifyChanged</code> for each affected derived union.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param notification a description of the change.
	 * @param eClass the Ecore class of the notifier.
	 * @generated
	 */
	protected void notifyStateDefinitionChanged(Notification notification, EClass eClass) {
		switch (notification.getFeatureID(StateDefinition.class)) {
			case SysMLPackage.STATE_DEFINITION__IMPORTED_MEMBERSHIP:
				notifyChanged(notification, eClass, SysMLPackage.Literals.NAMESPACE__MEMBERSHIP);
				break;
			case SysMLPackage.STATE_DEFINITION__OWNED_MEMBERSHIP:
				notifyChanged(notification, eClass, SysMLPackage.Literals.NAMESPACE__MEMBERSHIP);
				break;
			case SysMLPackage.STATE_DEFINITION__OWNED_FEATURE_MEMBERSHIP:
				notifyChanged(notification, eClass, SysMLPackage.Literals.NAMESPACE__MEMBERSHIP);
				break;
			case SysMLPackage.STATE_DEFINITION__INHERITED_MEMBERSHIP:
				notifyChanged(notification, eClass, SysMLPackage.Literals.NAMESPACE__MEMBERSHIP);
				break;
			case SysMLPackage.STATE_DEFINITION__VARIANT_MEMBERSHIP:
				notifyChanged(notification, eClass, SysMLPackage.Literals.NAMESPACE__MEMBERSHIP);
				break;
		}
	}

	/**
	 * Calls <code>notifyChanged</code> for each affected derived union.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param notification a description of the change.
	 * @param eClass the Ecore class of the notifier.
	 * @generated
	 */
	protected void notifyFeatureMembershipChanged(Notification notification, EClass eClass) {
		switch (notification.getFeatureID(FeatureMembership.class)) {
			case SysMLPackage.FEATURE_MEMBERSHIP__OWNED_RELATED_ELEMENT:
				notifyChanged(notification, eClass, SysMLPackage.Literals.RELATIONSHIP__RELATED_ELEMENT);
				break;
			case SysMLPackage.FEATURE_MEMBERSHIP__OWNING_RELATED_ELEMENT:
				notifyChanged(notification, eClass, SysMLPackage.Literals.RELATIONSHIP__RELATED_ELEMENT);
				break;
			case SysMLPackage.FEATURE_MEMBERSHIP__TARGET:
				notifyChanged(notification, eClass, SysMLPackage.Literals.RELATIONSHIP__RELATED_ELEMENT);
				break;
			case SysMLPackage.FEATURE_MEMBERSHIP__SOURCE:
				notifyChanged(notification, eClass, SysMLPackage.Literals.RELATIONSHIP__RELATED_ELEMENT);
				break;
			case SysMLPackage.FEATURE_MEMBERSHIP__MEMBERSHIP_OWNING_NAMESPACE:
				notifyChanged(notification, eClass, SysMLPackage.Literals.RELATIONSHIP__RELATED_ELEMENT);
				break;
			case SysMLPackage.FEATURE_MEMBERSHIP__OWNED_MEMBER_ELEMENT:
				notifyChanged(notification, eClass, SysMLPackage.Literals.RELATIONSHIP__RELATED_ELEMENT);
				break;
			case SysMLPackage.FEATURE_MEMBERSHIP__OWNING_FEATURE_OF_TYPE:
				notifyChanged(notification, eClass, SysMLPackage.Literals.RELATIONSHIP__RELATED_ELEMENT);
				break;
		}
	}

	/**
	 * Calls <code>notifyChanged</code> for each affected derived union.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param notification a description of the change.
	 * @param eClass the Ecore class of the notifier.
	 * @generated
	 */
	protected void notifyTypeFeaturingChanged(Notification notification, EClass eClass) {
		switch (notification.getFeatureID(TypeFeaturing.class)) {
			case SysMLPackage.TYPE_FEATURING__OWNED_RELATED_ELEMENT:
				notifyChanged(notification, eClass, SysMLPackage.Literals.RELATIONSHIP__RELATED_ELEMENT);
				break;
			case SysMLPackage.TYPE_FEATURING__OWNING_RELATED_ELEMENT:
				notifyChanged(notification, eClass, SysMLPackage.Literals.RELATIONSHIP__RELATED_ELEMENT);
				break;
			case SysMLPackage.TYPE_FEATURING__TARGET:
				notifyChanged(notification, eClass, SysMLPackage.Literals.RELATIONSHIP__RELATED_ELEMENT);
				break;
			case SysMLPackage.TYPE_FEATURING__SOURCE:
				notifyChanged(notification, eClass, SysMLPackage.Literals.RELATIONSHIP__RELATED_ELEMENT);
				break;
			case SysMLPackage.TYPE_FEATURING__OWNING_FEATURE_OF_TYPE:
				notifyChanged(notification, eClass, SysMLPackage.Literals.RELATIONSHIP__RELATED_ELEMENT);
				break;
		}
	}

	/**
	 * Calls <code>notifyChanged</code> for each affected derived union.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param notification a description of the change.
	 * @param eClass the Ecore class of the notifier.
	 * @generated
	 */
	protected void notifyConjugationChanged(Notification notification, EClass eClass) {
		switch (notification.getFeatureID(Conjugation.class)) {
			case SysMLPackage.CONJUGATION__OWNED_RELATED_ELEMENT:
				notifyChanged(notification, eClass, SysMLPackage.Literals.RELATIONSHIP__RELATED_ELEMENT);
				break;
			case SysMLPackage.CONJUGATION__OWNING_RELATED_ELEMENT:
				notifyChanged(notification, eClass, SysMLPackage.Literals.RELATIONSHIP__RELATED_ELEMENT);
				break;
			case SysMLPackage.CONJUGATION__TARGET:
				notifyChanged(notification, eClass, SysMLPackage.Literals.RELATIONSHIP__RELATED_ELEMENT);
				break;
			case SysMLPackage.CONJUGATION__SOURCE:
				notifyChanged(notification, eClass, SysMLPackage.Literals.RELATIONSHIP__RELATED_ELEMENT);
				break;
			case SysMLPackage.CONJUGATION__OWNING_TYPE:
				notifyChanged(notification, eClass, SysMLPackage.Literals.RELATIONSHIP__RELATED_ELEMENT);
				break;
		}
	}

	/**
	 * Calls <code>notifyChanged</code> for each affected derived union.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param notification a description of the change.
	 * @param eClass the Ecore class of the notifier.
	 * @generated
	 */
	protected void notifyMembershipChanged(Notification notification, EClass eClass) {
		switch (notification.getFeatureID(Membership.class)) {
			case SysMLPackage.MEMBERSHIP__OWNED_RELATED_ELEMENT:
				notifyChanged(notification, eClass, SysMLPackage.Literals.RELATIONSHIP__RELATED_ELEMENT);
				break;
			case SysMLPackage.MEMBERSHIP__OWNING_RELATED_ELEMENT:
				notifyChanged(notification, eClass, SysMLPackage.Literals.RELATIONSHIP__RELATED_ELEMENT);
				break;
			case SysMLPackage.MEMBERSHIP__TARGET:
				notifyChanged(notification, eClass, SysMLPackage.Literals.RELATIONSHIP__RELATED_ELEMENT);
				break;
			case SysMLPackage.MEMBERSHIP__SOURCE:
				notifyChanged(notification, eClass, SysMLPackage.Literals.RELATIONSHIP__RELATED_ELEMENT);
				break;
			case SysMLPackage.MEMBERSHIP__MEMBERSHIP_OWNING_NAMESPACE:
				notifyChanged(notification, eClass, SysMLPackage.Literals.RELATIONSHIP__RELATED_ELEMENT);
				break;
			case SysMLPackage.MEMBERSHIP__OWNED_MEMBER_ELEMENT:
				notifyChanged(notification, eClass, SysMLPackage.Literals.RELATIONSHIP__RELATED_ELEMENT);
				break;
		}
	}

	/**
	 * Calls <code>notifyChanged</code> for each affected derived union.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param notification a description of the change.
	 * @param eClass the Ecore class of the notifier.
	 * @generated
	 */
	protected void notifyRelationshipChanged(Notification notification, EClass eClass) {
		switch (notification.getFeatureID(Relationship.class)) {
			case SysMLPackage.RELATIONSHIP__OWNED_RELATED_ELEMENT:
				notifyChanged(notification, eClass, SysMLPackage.Literals.RELATIONSHIP__RELATED_ELEMENT);
				break;
			case SysMLPackage.RELATIONSHIP__OWNING_RELATED_ELEMENT:
				notifyChanged(notification, eClass, SysMLPackage.Literals.RELATIONSHIP__RELATED_ELEMENT);
				break;
			case SysMLPackage.RELATIONSHIP__TARGET:
				notifyChanged(notification, eClass, SysMLPackage.Literals.RELATIONSHIP__RELATED_ELEMENT);
				break;
			case SysMLPackage.RELATIONSHIP__SOURCE:
				notifyChanged(notification, eClass, SysMLPackage.Literals.RELATIONSHIP__RELATED_ELEMENT);
				break;
		}
	}

	/**
	 * Calls <code>notifyChanged</code> for each affected derived union.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param notification a description of the change.
	 * @param eClass the Ecore class of the notifier.
	 * @generated
	 */
	protected void notifyDocumentationChanged(Notification notification, EClass eClass) {
		switch (notification.getFeatureID(Documentation.class)) {
			case SysMLPackage.DOCUMENTATION__OWNED_RELATED_ELEMENT:
				notifyChanged(notification, eClass, SysMLPackage.Literals.RELATIONSHIP__RELATED_ELEMENT);
				break;
			case SysMLPackage.DOCUMENTATION__OWNING_RELATED_ELEMENT:
				notifyChanged(notification, eClass, SysMLPackage.Literals.RELATIONSHIP__RELATED_ELEMENT);
				break;
			case SysMLPackage.DOCUMENTATION__TARGET:
				notifyChanged(notification, eClass, SysMLPackage.Literals.RELATIONSHIP__RELATED_ELEMENT);
				break;
			case SysMLPackage.DOCUMENTATION__SOURCE:
				notifyChanged(notification, eClass, SysMLPackage.Literals.RELATIONSHIP__RELATED_ELEMENT);
				break;
			case SysMLPackage.DOCUMENTATION__DOCUMENTING_COMMENT:
				notifyChanged(notification, eClass, SysMLPackage.Literals.RELATIONSHIP__RELATED_ELEMENT);
				break;
		}
	}

	/**
	 * Calls <code>notifyChanged</code> for each affected derived union.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param notification a description of the change.
	 * @param eClass the Ecore class of the notifier.
	 * @generated
	 */
	protected void notifyPackageChanged(Notification notification, EClass eClass) {
		switch (notification.getFeatureID(org.omg.sysml.lang.sysml.Package.class)) {
			case SysMLPackage.PACKAGE__IMPORTED_MEMBERSHIP:
				notifyChanged(notification, eClass, SysMLPackage.Literals.NAMESPACE__MEMBERSHIP);
				break;
			case SysMLPackage.PACKAGE__OWNED_MEMBERSHIP:
				notifyChanged(notification, eClass, SysMLPackage.Literals.NAMESPACE__MEMBERSHIP);
				break;
		}
	}

	/**
	 * Calls <code>notifyChanged</code> for each affected derived union.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param notification a description of the change.
	 * @param eClass the Ecore class of the notifier.
	 * @generated
	 */
	protected void notifyImportChanged(Notification notification, EClass eClass) {
		switch (notification.getFeatureID(Import.class)) {
			case SysMLPackage.IMPORT__OWNED_RELATED_ELEMENT:
				notifyChanged(notification, eClass, SysMLPackage.Literals.RELATIONSHIP__RELATED_ELEMENT);
				break;
			case SysMLPackage.IMPORT__OWNING_RELATED_ELEMENT:
				notifyChanged(notification, eClass, SysMLPackage.Literals.RELATIONSHIP__RELATED_ELEMENT);
				break;
			case SysMLPackage.IMPORT__TARGET:
				notifyChanged(notification, eClass, SysMLPackage.Literals.RELATIONSHIP__RELATED_ELEMENT);
				break;
			case SysMLPackage.IMPORT__SOURCE:
				notifyChanged(notification, eClass, SysMLPackage.Literals.RELATIONSHIP__RELATED_ELEMENT);
				break;
			case SysMLPackage.IMPORT__IMPORT_OWNING_NAMESPACE:
				notifyChanged(notification, eClass, SysMLPackage.Literals.RELATIONSHIP__RELATED_ELEMENT);
				break;
		}
	}

	/**
	 * Calls <code>notifyChanged</code> for each affected derived union.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param notification a description of the change.
	 * @param eClass the Ecore class of the notifier.
	 * @generated
	 */
	protected void notifyPredicateChanged(Notification notification, EClass eClass) {
		switch (notification.getFeatureID(Predicate.class)) {
			case SysMLPackage.PREDICATE__IMPORTED_MEMBERSHIP:
				notifyChanged(notification, eClass, SysMLPackage.Literals.NAMESPACE__MEMBERSHIP);
				break;
			case SysMLPackage.PREDICATE__OWNED_MEMBERSHIP:
				notifyChanged(notification, eClass, SysMLPackage.Literals.NAMESPACE__MEMBERSHIP);
				break;
			case SysMLPackage.PREDICATE__OWNED_FEATURE_MEMBERSHIP:
				notifyChanged(notification, eClass, SysMLPackage.Literals.NAMESPACE__MEMBERSHIP);
				break;
			case SysMLPackage.PREDICATE__INHERITED_MEMBERSHIP:
				notifyChanged(notification, eClass, SysMLPackage.Literals.NAMESPACE__MEMBERSHIP);
				break;
		}
	}

	/**
	 * Calls <code>notifyChanged</code> for each affected derived union.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param notification a description of the change.
	 * @param eClass the Ecore class of the notifier.
	 * @generated
	 */
	protected void notifyResultExpressionMembershipChanged(Notification notification, EClass eClass) {
		switch (notification.getFeatureID(ResultExpressionMembership.class)) {
			case SysMLPackage.RESULT_EXPRESSION_MEMBERSHIP__OWNED_RELATED_ELEMENT:
				notifyChanged(notification, eClass, SysMLPackage.Literals.RELATIONSHIP__RELATED_ELEMENT);
				break;
			case SysMLPackage.RESULT_EXPRESSION_MEMBERSHIP__OWNING_RELATED_ELEMENT:
				notifyChanged(notification, eClass, SysMLPackage.Literals.RELATIONSHIP__RELATED_ELEMENT);
				break;
			case SysMLPackage.RESULT_EXPRESSION_MEMBERSHIP__TARGET:
				notifyChanged(notification, eClass, SysMLPackage.Literals.RELATIONSHIP__RELATED_ELEMENT);
				break;
			case SysMLPackage.RESULT_EXPRESSION_MEMBERSHIP__SOURCE:
				notifyChanged(notification, eClass, SysMLPackage.Literals.RELATIONSHIP__RELATED_ELEMENT);
				break;
			case SysMLPackage.RESULT_EXPRESSION_MEMBERSHIP__MEMBERSHIP_OWNING_NAMESPACE:
				notifyChanged(notification, eClass, SysMLPackage.Literals.RELATIONSHIP__RELATED_ELEMENT);
				break;
			case SysMLPackage.RESULT_EXPRESSION_MEMBERSHIP__OWNED_MEMBER_ELEMENT:
				notifyChanged(notification, eClass, SysMLPackage.Literals.RELATIONSHIP__RELATED_ELEMENT);
				break;
			case SysMLPackage.RESULT_EXPRESSION_MEMBERSHIP__OWNING_FEATURE_OF_TYPE:
				notifyChanged(notification, eClass, SysMLPackage.Literals.RELATIONSHIP__RELATED_ELEMENT);
				break;
		}
	}

	/**
	 * Calls <code>notifyChanged</code> for each affected derived union.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param notification a description of the change.
	 * @param eClass the Ecore class of the notifier.
	 * @generated
	 */
	protected void notifyTransitionUsageChanged(Notification notification, EClass eClass) {
		switch (notification.getFeatureID(TransitionUsage.class)) {
			case SysMLPackage.TRANSITION_USAGE__IMPORTED_MEMBERSHIP:
				notifyChanged(notification, eClass, SysMLPackage.Literals.NAMESPACE__MEMBERSHIP);
				break;
			case SysMLPackage.TRANSITION_USAGE__OWNED_MEMBERSHIP:
				notifyChanged(notification, eClass, SysMLPackage.Literals.NAMESPACE__MEMBERSHIP);
				break;
			case SysMLPackage.TRANSITION_USAGE__OWNED_FEATURE_MEMBERSHIP:
				notifyChanged(notification, eClass, SysMLPackage.Literals.NAMESPACE__MEMBERSHIP);
				break;
			case SysMLPackage.TRANSITION_USAGE__INHERITED_MEMBERSHIP:
				notifyChanged(notification, eClass, SysMLPackage.Literals.NAMESPACE__MEMBERSHIP);
				break;
			case SysMLPackage.TRANSITION_USAGE__VARIANT_MEMBERSHIP:
				notifyChanged(notification, eClass, SysMLPackage.Literals.NAMESPACE__MEMBERSHIP);
				break;
		}
	}

	/**
	 * Calls <code>notifyChanged</code> for each affected derived union.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param notification a description of the change.
	 * @param eClass the Ecore class of the notifier.
	 * @generated
	 */
	protected void notifyFunctionChanged(Notification notification, EClass eClass) {
		switch (notification.getFeatureID(Function.class)) {
			case SysMLPackage.FUNCTION__IMPORTED_MEMBERSHIP:
				notifyChanged(notification, eClass, SysMLPackage.Literals.NAMESPACE__MEMBERSHIP);
				break;
			case SysMLPackage.FUNCTION__OWNED_MEMBERSHIP:
				notifyChanged(notification, eClass, SysMLPackage.Literals.NAMESPACE__MEMBERSHIP);
				break;
			case SysMLPackage.FUNCTION__OWNED_FEATURE_MEMBERSHIP:
				notifyChanged(notification, eClass, SysMLPackage.Literals.NAMESPACE__MEMBERSHIP);
				break;
			case SysMLPackage.FUNCTION__INHERITED_MEMBERSHIP:
				notifyChanged(notification, eClass, SysMLPackage.Literals.NAMESPACE__MEMBERSHIP);
				break;
		}
	}

	/**
	 * Calls <code>notifyChanged</code> for each affected derived union.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param notification a description of the change.
	 * @param eClass the Ecore class of the notifier.
	 * @generated
	 */
	protected void notifyBehaviorChanged(Notification notification, EClass eClass) {
		switch (notification.getFeatureID(Behavior.class)) {
			case SysMLPackage.BEHAVIOR__IMPORTED_MEMBERSHIP:
				notifyChanged(notification, eClass, SysMLPackage.Literals.NAMESPACE__MEMBERSHIP);
				break;
			case SysMLPackage.BEHAVIOR__OWNED_MEMBERSHIP:
				notifyChanged(notification, eClass, SysMLPackage.Literals.NAMESPACE__MEMBERSHIP);
				break;
			case SysMLPackage.BEHAVIOR__OWNED_FEATURE_MEMBERSHIP:
				notifyChanged(notification, eClass, SysMLPackage.Literals.NAMESPACE__MEMBERSHIP);
				break;
			case SysMLPackage.BEHAVIOR__INHERITED_MEMBERSHIP:
				notifyChanged(notification, eClass, SysMLPackage.Literals.NAMESPACE__MEMBERSHIP);
				break;
		}
	}

	/**
	 * Calls <code>notifyChanged</code> for each affected derived union.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param notification a description of the change.
	 * @param eClass the Ecore class of the notifier.
	 * @generated
	 */
	protected void notifyClassifierChanged(Notification notification, EClass eClass) {
		switch (notification.getFeatureID(Classifier.class)) {
			case SysMLPackage.CLASSIFIER__IMPORTED_MEMBERSHIP:
				notifyChanged(notification, eClass, SysMLPackage.Literals.NAMESPACE__MEMBERSHIP);
				break;
			case SysMLPackage.CLASSIFIER__OWNED_MEMBERSHIP:
				notifyChanged(notification, eClass, SysMLPackage.Literals.NAMESPACE__MEMBERSHIP);
				break;
			case SysMLPackage.CLASSIFIER__OWNED_FEATURE_MEMBERSHIP:
				notifyChanged(notification, eClass, SysMLPackage.Literals.NAMESPACE__MEMBERSHIP);
				break;
			case SysMLPackage.CLASSIFIER__INHERITED_MEMBERSHIP:
				notifyChanged(notification, eClass, SysMLPackage.Literals.NAMESPACE__MEMBERSHIP);
				break;
		}
	}

	/**
	 * Calls <code>notifyChanged</code> for each affected derived union.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param notification a description of the change.
	 * @param eClass the Ecore class of the notifier.
	 * @generated
	 */
	protected void notifyTypeChanged(Notification notification, EClass eClass) {
		switch (notification.getFeatureID(Type.class)) {
			case SysMLPackage.TYPE__IMPORTED_MEMBERSHIP:
				notifyChanged(notification, eClass, SysMLPackage.Literals.NAMESPACE__MEMBERSHIP);
				break;
			case SysMLPackage.TYPE__OWNED_MEMBERSHIP:
				notifyChanged(notification, eClass, SysMLPackage.Literals.NAMESPACE__MEMBERSHIP);
				break;
			case SysMLPackage.TYPE__OWNED_FEATURE_MEMBERSHIP:
				notifyChanged(notification, eClass, SysMLPackage.Literals.NAMESPACE__MEMBERSHIP);
				break;
			case SysMLPackage.TYPE__INHERITED_MEMBERSHIP:
				notifyChanged(notification, eClass, SysMLPackage.Literals.NAMESPACE__MEMBERSHIP);
				break;
		}
	}

	/**
	 * Calls <code>notifyChanged</code> for each affected derived union.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param notification a description of the change.
	 * @param eClass the Ecore class of the notifier.
	 * @generated
	 */
	protected void notifyNamespaceChanged(Notification notification, EClass eClass) {
		switch (notification.getFeatureID(Namespace.class)) {
			case SysMLPackage.NAMESPACE__IMPORTED_MEMBERSHIP:
				notifyChanged(notification, eClass, SysMLPackage.Literals.NAMESPACE__MEMBERSHIP);
				break;
			case SysMLPackage.NAMESPACE__OWNED_MEMBERSHIP:
				notifyChanged(notification, eClass, SysMLPackage.Literals.NAMESPACE__MEMBERSHIP);
				break;
		}
	}

	/**
	 * Calls <code>notifyChanged</code> for each affected derived union.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param notification a description of the change.
	 * @param eClass the Ecore class of the notifier.
	 * @generated
	 */
	protected void notifyClassChanged(Notification notification, EClass eClass) {
		switch (notification.getFeatureID(org.omg.sysml.lang.sysml.Class.class)) {
			case SysMLPackage.CLASS__IMPORTED_MEMBERSHIP:
				notifyChanged(notification, eClass, SysMLPackage.Literals.NAMESPACE__MEMBERSHIP);
				break;
			case SysMLPackage.CLASS__OWNED_MEMBERSHIP:
				notifyChanged(notification, eClass, SysMLPackage.Literals.NAMESPACE__MEMBERSHIP);
				break;
			case SysMLPackage.CLASS__OWNED_FEATURE_MEMBERSHIP:
				notifyChanged(notification, eClass, SysMLPackage.Literals.NAMESPACE__MEMBERSHIP);
				break;
			case SysMLPackage.CLASS__INHERITED_MEMBERSHIP:
				notifyChanged(notification, eClass, SysMLPackage.Literals.NAMESPACE__MEMBERSHIP);
				break;
		}
	}

	/**
	 * Calls <code>notifyChanged</code> for each affected derived union.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param notification a description of the change.
	 * @param eClass the Ecore class of the notifier.
	 * @generated
	 */
	protected void notifyRequirementUsageChanged(Notification notification, EClass eClass) {
		switch (notification.getFeatureID(RequirementUsage.class)) {
			case SysMLPackage.REQUIREMENT_USAGE__IMPORTED_MEMBERSHIP:
				notifyChanged(notification, eClass, SysMLPackage.Literals.NAMESPACE__MEMBERSHIP);
				break;
			case SysMLPackage.REQUIREMENT_USAGE__OWNED_MEMBERSHIP:
				notifyChanged(notification, eClass, SysMLPackage.Literals.NAMESPACE__MEMBERSHIP);
				break;
			case SysMLPackage.REQUIREMENT_USAGE__OWNED_FEATURE_MEMBERSHIP:
				notifyChanged(notification, eClass, SysMLPackage.Literals.NAMESPACE__MEMBERSHIP);
				break;
			case SysMLPackage.REQUIREMENT_USAGE__INHERITED_MEMBERSHIP:
				notifyChanged(notification, eClass, SysMLPackage.Literals.NAMESPACE__MEMBERSHIP);
				break;
			case SysMLPackage.REQUIREMENT_USAGE__VARIANT_MEMBERSHIP:
				notifyChanged(notification, eClass, SysMLPackage.Literals.NAMESPACE__MEMBERSHIP);
				break;
		}
	}

	/**
	 * Calls <code>notifyChanged</code> for each affected derived union.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param notification a description of the change.
	 * @param eClass the Ecore class of the notifier.
	 * @generated
	 */
	protected void notifyRequirementDefinitionChanged(Notification notification, EClass eClass) {
		switch (notification.getFeatureID(RequirementDefinition.class)) {
			case SysMLPackage.REQUIREMENT_DEFINITION__IMPORTED_MEMBERSHIP:
				notifyChanged(notification, eClass, SysMLPackage.Literals.NAMESPACE__MEMBERSHIP);
				break;
			case SysMLPackage.REQUIREMENT_DEFINITION__OWNED_MEMBERSHIP:
				notifyChanged(notification, eClass, SysMLPackage.Literals.NAMESPACE__MEMBERSHIP);
				break;
			case SysMLPackage.REQUIREMENT_DEFINITION__OWNED_FEATURE_MEMBERSHIP:
				notifyChanged(notification, eClass, SysMLPackage.Literals.NAMESPACE__MEMBERSHIP);
				break;
			case SysMLPackage.REQUIREMENT_DEFINITION__INHERITED_MEMBERSHIP:
				notifyChanged(notification, eClass, SysMLPackage.Literals.NAMESPACE__MEMBERSHIP);
				break;
			case SysMLPackage.REQUIREMENT_DEFINITION__VARIANT_MEMBERSHIP:
				notifyChanged(notification, eClass, SysMLPackage.Literals.NAMESPACE__MEMBERSHIP);
				break;
		}
	}

	/**
	 * Calls <code>notifyChanged</code> for each affected derived union.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param notification a description of the change.
	 * @param eClass the Ecore class of the notifier.
	 * @generated
	 */
	protected void notifyFeatureChanged(Notification notification, EClass eClass) {
		switch (notification.getFeatureID(Feature.class)) {
			case SysMLPackage.FEATURE__IMPORTED_MEMBERSHIP:
				notifyChanged(notification, eClass, SysMLPackage.Literals.NAMESPACE__MEMBERSHIP);
				break;
			case SysMLPackage.FEATURE__OWNED_MEMBERSHIP:
				notifyChanged(notification, eClass, SysMLPackage.Literals.NAMESPACE__MEMBERSHIP);
				break;
			case SysMLPackage.FEATURE__OWNED_FEATURE_MEMBERSHIP:
				notifyChanged(notification, eClass, SysMLPackage.Literals.NAMESPACE__MEMBERSHIP);
				break;
			case SysMLPackage.FEATURE__INHERITED_MEMBERSHIP:
				notifyChanged(notification, eClass, SysMLPackage.Literals.NAMESPACE__MEMBERSHIP);
				break;
		}
	}

	/**
	 * Calls <code>notifyChanged</code> for each affected derived union.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param notification a description of the change.
	 * @param eClass the Ecore class of the notifier.
	 * @generated
	 */
	protected void notifyRedefinitionChanged(Notification notification, EClass eClass) {
		switch (notification.getFeatureID(Redefinition.class)) {
			case SysMLPackage.REDEFINITION__OWNED_RELATED_ELEMENT:
				notifyChanged(notification, eClass, SysMLPackage.Literals.RELATIONSHIP__RELATED_ELEMENT);
				break;
			case SysMLPackage.REDEFINITION__OWNING_RELATED_ELEMENT:
				notifyChanged(notification, eClass, SysMLPackage.Literals.RELATIONSHIP__RELATED_ELEMENT);
				break;
			case SysMLPackage.REDEFINITION__TARGET:
				notifyChanged(notification, eClass, SysMLPackage.Literals.RELATIONSHIP__RELATED_ELEMENT);
				break;
			case SysMLPackage.REDEFINITION__SOURCE:
				notifyChanged(notification, eClass, SysMLPackage.Literals.RELATIONSHIP__RELATED_ELEMENT);
				break;
			case SysMLPackage.REDEFINITION__OWNING_TYPE:
				notifyChanged(notification, eClass, SysMLPackage.Literals.RELATIONSHIP__RELATED_ELEMENT);
				break;
		}
	}

	/**
	 * Calls <code>notifyChanged</code> for each affected derived union.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param notification a description of the change.
	 * @param eClass the Ecore class of the notifier.
	 * @generated
	 */
	protected void notifySubsettingChanged(Notification notification, EClass eClass) {
		switch (notification.getFeatureID(Subsetting.class)) {
			case SysMLPackage.SUBSETTING__OWNED_RELATED_ELEMENT:
				notifyChanged(notification, eClass, SysMLPackage.Literals.RELATIONSHIP__RELATED_ELEMENT);
				break;
			case SysMLPackage.SUBSETTING__OWNING_RELATED_ELEMENT:
				notifyChanged(notification, eClass, SysMLPackage.Literals.RELATIONSHIP__RELATED_ELEMENT);
				break;
			case SysMLPackage.SUBSETTING__TARGET:
				notifyChanged(notification, eClass, SysMLPackage.Literals.RELATIONSHIP__RELATED_ELEMENT);
				break;
			case SysMLPackage.SUBSETTING__SOURCE:
				notifyChanged(notification, eClass, SysMLPackage.Literals.RELATIONSHIP__RELATED_ELEMENT);
				break;
			case SysMLPackage.SUBSETTING__OWNING_TYPE:
				notifyChanged(notification, eClass, SysMLPackage.Literals.RELATIONSHIP__RELATED_ELEMENT);
				break;
		}
	}

	/**
	 * Calls <code>notifyChanged</code> for each affected derived union.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param notification a description of the change.
	 * @param eClass the Ecore class of the notifier.
	 * @generated
	 */
	protected void notifyFeatureValueChanged(Notification notification, EClass eClass) {
		switch (notification.getFeatureID(FeatureValue.class)) {
			case SysMLPackage.FEATURE_VALUE__OWNED_RELATED_ELEMENT:
				notifyChanged(notification, eClass, SysMLPackage.Literals.RELATIONSHIP__RELATED_ELEMENT);
				break;
			case SysMLPackage.FEATURE_VALUE__OWNING_RELATED_ELEMENT:
				notifyChanged(notification, eClass, SysMLPackage.Literals.RELATIONSHIP__RELATED_ELEMENT);
				break;
			case SysMLPackage.FEATURE_VALUE__TARGET:
				notifyChanged(notification, eClass, SysMLPackage.Literals.RELATIONSHIP__RELATED_ELEMENT);
				break;
			case SysMLPackage.FEATURE_VALUE__SOURCE:
				notifyChanged(notification, eClass, SysMLPackage.Literals.RELATIONSHIP__RELATED_ELEMENT);
				break;
			case SysMLPackage.FEATURE_VALUE__MEMBERSHIP_OWNING_NAMESPACE:
				notifyChanged(notification, eClass, SysMLPackage.Literals.RELATIONSHIP__RELATED_ELEMENT);
				break;
			case SysMLPackage.FEATURE_VALUE__OWNED_MEMBER_ELEMENT:
				notifyChanged(notification, eClass, SysMLPackage.Literals.RELATIONSHIP__RELATED_ELEMENT);
				break;
			case SysMLPackage.FEATURE_VALUE__FEATURE_WITH_VALUE:
				notifyChanged(notification, eClass, SysMLPackage.Literals.RELATIONSHIP__RELATED_ELEMENT);
				break;
		}
	}

	/**
	 * Calls <code>notifyChanged</code> for each affected derived union.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param notification a description of the change.
	 * @param eClass the Ecore class of the notifier.
	 * @generated
	 */
	protected void notifyExpressionChanged(Notification notification, EClass eClass) {
		switch (notification.getFeatureID(Expression.class)) {
			case SysMLPackage.EXPRESSION__IMPORTED_MEMBERSHIP:
				notifyChanged(notification, eClass, SysMLPackage.Literals.NAMESPACE__MEMBERSHIP);
				break;
			case SysMLPackage.EXPRESSION__OWNED_MEMBERSHIP:
				notifyChanged(notification, eClass, SysMLPackage.Literals.NAMESPACE__MEMBERSHIP);
				break;
			case SysMLPackage.EXPRESSION__OWNED_FEATURE_MEMBERSHIP:
				notifyChanged(notification, eClass, SysMLPackage.Literals.NAMESPACE__MEMBERSHIP);
				break;
			case SysMLPackage.EXPRESSION__INHERITED_MEMBERSHIP:
				notifyChanged(notification, eClass, SysMLPackage.Literals.NAMESPACE__MEMBERSHIP);
				break;
		}
	}

	/**
	 * Calls <code>notifyChanged</code> for each affected derived union.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param notification a description of the change.
	 * @param eClass the Ecore class of the notifier.
	 * @generated
	 */
	protected void notifyStepChanged(Notification notification, EClass eClass) {
		switch (notification.getFeatureID(Step.class)) {
			case SysMLPackage.STEP__IMPORTED_MEMBERSHIP:
				notifyChanged(notification, eClass, SysMLPackage.Literals.NAMESPACE__MEMBERSHIP);
				break;
			case SysMLPackage.STEP__OWNED_MEMBERSHIP:
				notifyChanged(notification, eClass, SysMLPackage.Literals.NAMESPACE__MEMBERSHIP);
				break;
			case SysMLPackage.STEP__OWNED_FEATURE_MEMBERSHIP:
				notifyChanged(notification, eClass, SysMLPackage.Literals.NAMESPACE__MEMBERSHIP);
				break;
			case SysMLPackage.STEP__INHERITED_MEMBERSHIP:
				notifyChanged(notification, eClass, SysMLPackage.Literals.NAMESPACE__MEMBERSHIP);
				break;
		}
	}

	/**
	 * Calls <code>notifyChanged</code> for each affected derived union.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param notification a description of the change.
	 * @param eClass the Ecore class of the notifier.
	 * @generated
	 */
	protected void notifyMultiplicityChanged(Notification notification, EClass eClass) {
		switch (notification.getFeatureID(Multiplicity.class)) {
			case SysMLPackage.MULTIPLICITY__IMPORTED_MEMBERSHIP:
				notifyChanged(notification, eClass, SysMLPackage.Literals.NAMESPACE__MEMBERSHIP);
				break;
			case SysMLPackage.MULTIPLICITY__OWNED_MEMBERSHIP:
				notifyChanged(notification, eClass, SysMLPackage.Literals.NAMESPACE__MEMBERSHIP);
				break;
			case SysMLPackage.MULTIPLICITY__OWNED_FEATURE_MEMBERSHIP:
				notifyChanged(notification, eClass, SysMLPackage.Literals.NAMESPACE__MEMBERSHIP);
				break;
			case SysMLPackage.MULTIPLICITY__INHERITED_MEMBERSHIP:
				notifyChanged(notification, eClass, SysMLPackage.Literals.NAMESPACE__MEMBERSHIP);
				break;
		}
	}

	/**
	 * Calls <code>notifyChanged</code> for each affected derived union.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param notification a description of the change.
	 * @param eClass the Ecore class of the notifier.
	 * @generated
	 */
	protected void notifyDisjoiningChanged(Notification notification, EClass eClass) {
		switch (notification.getFeatureID(Disjoining.class)) {
			case SysMLPackage.DISJOINING__OWNED_RELATED_ELEMENT:
				notifyChanged(notification, eClass, SysMLPackage.Literals.RELATIONSHIP__RELATED_ELEMENT);
				break;
			case SysMLPackage.DISJOINING__OWNING_RELATED_ELEMENT:
				notifyChanged(notification, eClass, SysMLPackage.Literals.RELATIONSHIP__RELATED_ELEMENT);
				break;
			case SysMLPackage.DISJOINING__TARGET:
				notifyChanged(notification, eClass, SysMLPackage.Literals.RELATIONSHIP__RELATED_ELEMENT);
				break;
			case SysMLPackage.DISJOINING__SOURCE:
				notifyChanged(notification, eClass, SysMLPackage.Literals.RELATIONSHIP__RELATED_ELEMENT);
				break;
		}
	}

	/**
	 * Calls <code>notifyChanged</code> for each affected derived union.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param notification a description of the change.
	 * @param eClass the Ecore class of the notifier.
	 * @generated
	 */
	protected void notifyFeatureTypingChanged(Notification notification, EClass eClass) {
		switch (notification.getFeatureID(FeatureTyping.class)) {
			case SysMLPackage.FEATURE_TYPING__OWNED_RELATED_ELEMENT:
				notifyChanged(notification, eClass, SysMLPackage.Literals.RELATIONSHIP__RELATED_ELEMENT);
				break;
			case SysMLPackage.FEATURE_TYPING__OWNING_RELATED_ELEMENT:
				notifyChanged(notification, eClass, SysMLPackage.Literals.RELATIONSHIP__RELATED_ELEMENT);
				break;
			case SysMLPackage.FEATURE_TYPING__TARGET:
				notifyChanged(notification, eClass, SysMLPackage.Literals.RELATIONSHIP__RELATED_ELEMENT);
				break;
			case SysMLPackage.FEATURE_TYPING__SOURCE:
				notifyChanged(notification, eClass, SysMLPackage.Literals.RELATIONSHIP__RELATED_ELEMENT);
				break;
			case SysMLPackage.FEATURE_TYPING__OWNING_TYPE:
				notifyChanged(notification, eClass, SysMLPackage.Literals.RELATIONSHIP__RELATED_ELEMENT);
				break;
		}
	}

	/**
	 * Calls <code>notifyChanged</code> for each affected derived union.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param notification a description of the change.
	 * @param eClass the Ecore class of the notifier.
	 * @generated
	 */
	protected void notifyFeatureChainingChanged(Notification notification, EClass eClass) {
		switch (notification.getFeatureID(FeatureChaining.class)) {
			case SysMLPackage.FEATURE_CHAINING__OWNED_RELATED_ELEMENT:
				notifyChanged(notification, eClass, SysMLPackage.Literals.RELATIONSHIP__RELATED_ELEMENT);
				break;
			case SysMLPackage.FEATURE_CHAINING__OWNING_RELATED_ELEMENT:
				notifyChanged(notification, eClass, SysMLPackage.Literals.RELATIONSHIP__RELATED_ELEMENT);
				break;
			case SysMLPackage.FEATURE_CHAINING__TARGET:
				notifyChanged(notification, eClass, SysMLPackage.Literals.RELATIONSHIP__RELATED_ELEMENT);
				break;
			case SysMLPackage.FEATURE_CHAINING__SOURCE:
				notifyChanged(notification, eClass, SysMLPackage.Literals.RELATIONSHIP__RELATED_ELEMENT);
				break;
		}
	}

	/**
	 * Calls <code>notifyChanged</code> for each affected derived union.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param notification a description of the change.
	 * @param eClass the Ecore class of the notifier.
	 * @generated
	 */
	protected void notifyAssociationChanged(Notification notification, EClass eClass) {
		switch (notification.getFeatureID(Association.class)) {
			case SysMLPackage.ASSOCIATION__IMPORTED_MEMBERSHIP:
				notifyChanged(notification, eClass, SysMLPackage.Literals.NAMESPACE__MEMBERSHIP);
				break;
			case SysMLPackage.ASSOCIATION__OWNED_MEMBERSHIP:
				notifyChanged(notification, eClass, SysMLPackage.Literals.NAMESPACE__MEMBERSHIP);
				break;
			case SysMLPackage.ASSOCIATION__OWNED_FEATURE_MEMBERSHIP:
				notifyChanged(notification, eClass, SysMLPackage.Literals.NAMESPACE__MEMBERSHIP);
				break;
			case SysMLPackage.ASSOCIATION__INHERITED_MEMBERSHIP:
				notifyChanged(notification, eClass, SysMLPackage.Literals.NAMESPACE__MEMBERSHIP);
				break;
			case SysMLPackage.ASSOCIATION__OWNED_RELATED_ELEMENT:
				notifyChanged(notification, eClass, SysMLPackage.Literals.RELATIONSHIP__RELATED_ELEMENT);
				break;
			case SysMLPackage.ASSOCIATION__OWNING_RELATED_ELEMENT:
				notifyChanged(notification, eClass, SysMLPackage.Literals.RELATIONSHIP__RELATED_ELEMENT);
				break;
			case SysMLPackage.ASSOCIATION__TARGET:
				notifyChanged(notification, eClass, SysMLPackage.Literals.RELATIONSHIP__RELATED_ELEMENT);
				break;
			case SysMLPackage.ASSOCIATION__SOURCE:
				notifyChanged(notification, eClass, SysMLPackage.Literals.RELATIONSHIP__RELATED_ELEMENT);
				break;
			case SysMLPackage.ASSOCIATION__SOURCE_TYPE:
				notifyChanged(notification, eClass, SysMLPackage.Literals.ASSOCIATION__RELATED_TYPE);
				break;
			case SysMLPackage.ASSOCIATION__TARGET_TYPE:
				notifyChanged(notification, eClass, SysMLPackage.Literals.ASSOCIATION__RELATED_TYPE);
				break;
		}
	}

	/**
	 * Calls <code>notifyChanged</code> for each affected derived union.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param notification a description of the change.
	 * @param eClass the Ecore class of the notifier.
	 * @generated
	 */
	protected void notifyConnectorChanged(Notification notification, EClass eClass) {
		switch (notification.getFeatureID(Connector.class)) {
			case SysMLPackage.CONNECTOR__IMPORTED_MEMBERSHIP:
				notifyChanged(notification, eClass, SysMLPackage.Literals.NAMESPACE__MEMBERSHIP);
				break;
			case SysMLPackage.CONNECTOR__OWNED_MEMBERSHIP:
				notifyChanged(notification, eClass, SysMLPackage.Literals.NAMESPACE__MEMBERSHIP);
				break;
			case SysMLPackage.CONNECTOR__OWNED_FEATURE_MEMBERSHIP:
				notifyChanged(notification, eClass, SysMLPackage.Literals.NAMESPACE__MEMBERSHIP);
				break;
			case SysMLPackage.CONNECTOR__INHERITED_MEMBERSHIP:
				notifyChanged(notification, eClass, SysMLPackage.Literals.NAMESPACE__MEMBERSHIP);
				break;
			case SysMLPackage.CONNECTOR__OWNED_RELATED_ELEMENT:
				notifyChanged(notification, eClass, SysMLPackage.Literals.RELATIONSHIP__RELATED_ELEMENT);
				break;
			case SysMLPackage.CONNECTOR__OWNING_RELATED_ELEMENT:
				notifyChanged(notification, eClass, SysMLPackage.Literals.RELATIONSHIP__RELATED_ELEMENT);
				break;
			case SysMLPackage.CONNECTOR__TARGET:
				notifyChanged(notification, eClass, SysMLPackage.Literals.RELATIONSHIP__RELATED_ELEMENT);
				break;
			case SysMLPackage.CONNECTOR__SOURCE:
				notifyChanged(notification, eClass, SysMLPackage.Literals.RELATIONSHIP__RELATED_ELEMENT);
				break;
			case SysMLPackage.CONNECTOR__SOURCE_FEATURE:
				notifyChanged(notification, eClass, SysMLPackage.Literals.CONNECTOR__RELATED_FEATURE);
				break;
			case SysMLPackage.CONNECTOR__TARGET_FEATURE:
				notifyChanged(notification, eClass, SysMLPackage.Literals.CONNECTOR__RELATED_FEATURE);
				break;
		}
	}

	/**
	 * Calls <code>notifyChanged</code> for each affected derived union.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param notification a description of the change.
	 * @param eClass the Ecore class of the notifier.
	 * @generated
	 */
	protected void notifyAssociationStructureChanged(Notification notification, EClass eClass) {
		switch (notification.getFeatureID(AssociationStructure.class)) {
			case SysMLPackage.ASSOCIATION_STRUCTURE__IMPORTED_MEMBERSHIP:
				notifyChanged(notification, eClass, SysMLPackage.Literals.NAMESPACE__MEMBERSHIP);
				break;
			case SysMLPackage.ASSOCIATION_STRUCTURE__OWNED_MEMBERSHIP:
				notifyChanged(notification, eClass, SysMLPackage.Literals.NAMESPACE__MEMBERSHIP);
				break;
			case SysMLPackage.ASSOCIATION_STRUCTURE__OWNED_FEATURE_MEMBERSHIP:
				notifyChanged(notification, eClass, SysMLPackage.Literals.NAMESPACE__MEMBERSHIP);
				break;
			case SysMLPackage.ASSOCIATION_STRUCTURE__INHERITED_MEMBERSHIP:
				notifyChanged(notification, eClass, SysMLPackage.Literals.NAMESPACE__MEMBERSHIP);
				break;
			case SysMLPackage.ASSOCIATION_STRUCTURE__OWNED_RELATED_ELEMENT:
				notifyChanged(notification, eClass, SysMLPackage.Literals.RELATIONSHIP__RELATED_ELEMENT);
				break;
			case SysMLPackage.ASSOCIATION_STRUCTURE__OWNING_RELATED_ELEMENT:
				notifyChanged(notification, eClass, SysMLPackage.Literals.RELATIONSHIP__RELATED_ELEMENT);
				break;
			case SysMLPackage.ASSOCIATION_STRUCTURE__TARGET:
				notifyChanged(notification, eClass, SysMLPackage.Literals.RELATIONSHIP__RELATED_ELEMENT);
				break;
			case SysMLPackage.ASSOCIATION_STRUCTURE__SOURCE:
				notifyChanged(notification, eClass, SysMLPackage.Literals.RELATIONSHIP__RELATED_ELEMENT);
				break;
			case SysMLPackage.ASSOCIATION_STRUCTURE__SOURCE_TYPE:
				notifyChanged(notification, eClass, SysMLPackage.Literals.ASSOCIATION__RELATED_TYPE);
				break;
			case SysMLPackage.ASSOCIATION_STRUCTURE__TARGET_TYPE:
				notifyChanged(notification, eClass, SysMLPackage.Literals.ASSOCIATION__RELATED_TYPE);
				break;
		}
	}

	/**
	 * Calls <code>notifyChanged</code> for each affected derived union.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param notification a description of the change.
	 * @param eClass the Ecore class of the notifier.
	 * @generated
	 */
	protected void notifyStructureChanged(Notification notification, EClass eClass) {
		switch (notification.getFeatureID(Structure.class)) {
			case SysMLPackage.STRUCTURE__IMPORTED_MEMBERSHIP:
				notifyChanged(notification, eClass, SysMLPackage.Literals.NAMESPACE__MEMBERSHIP);
				break;
			case SysMLPackage.STRUCTURE__OWNED_MEMBERSHIP:
				notifyChanged(notification, eClass, SysMLPackage.Literals.NAMESPACE__MEMBERSHIP);
				break;
			case SysMLPackage.STRUCTURE__OWNED_FEATURE_MEMBERSHIP:
				notifyChanged(notification, eClass, SysMLPackage.Literals.NAMESPACE__MEMBERSHIP);
				break;
			case SysMLPackage.STRUCTURE__INHERITED_MEMBERSHIP:
				notifyChanged(notification, eClass, SysMLPackage.Literals.NAMESPACE__MEMBERSHIP);
				break;
		}
	}

	/**
	 * Calls <code>notifyChanged</code> for each affected derived union.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param notification a description of the change.
	 * @param eClass the Ecore class of the notifier.
	 * @generated
	 */
	protected void notifyDataTypeChanged(Notification notification, EClass eClass) {
		switch (notification.getFeatureID(DataType.class)) {
			case SysMLPackage.DATA_TYPE__IMPORTED_MEMBERSHIP:
				notifyChanged(notification, eClass, SysMLPackage.Literals.NAMESPACE__MEMBERSHIP);
				break;
			case SysMLPackage.DATA_TYPE__OWNED_MEMBERSHIP:
				notifyChanged(notification, eClass, SysMLPackage.Literals.NAMESPACE__MEMBERSHIP);
				break;
			case SysMLPackage.DATA_TYPE__OWNED_FEATURE_MEMBERSHIP:
				notifyChanged(notification, eClass, SysMLPackage.Literals.NAMESPACE__MEMBERSHIP);
				break;
			case SysMLPackage.DATA_TYPE__INHERITED_MEMBERSHIP:
				notifyChanged(notification, eClass, SysMLPackage.Literals.NAMESPACE__MEMBERSHIP);
				break;
		}
	}

	/**
	 * Calls <code>notifyChanged</code> for each affected derived union.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param notification a description of the change.
	 * @param eClass the Ecore class of the notifier.
	 * @generated
	 */
	protected void notifyElementFilterMembershipChanged(Notification notification, EClass eClass) {
		switch (notification.getFeatureID(ElementFilterMembership.class)) {
			case SysMLPackage.ELEMENT_FILTER_MEMBERSHIP__OWNED_RELATED_ELEMENT:
				notifyChanged(notification, eClass, SysMLPackage.Literals.RELATIONSHIP__RELATED_ELEMENT);
				break;
			case SysMLPackage.ELEMENT_FILTER_MEMBERSHIP__OWNING_RELATED_ELEMENT:
				notifyChanged(notification, eClass, SysMLPackage.Literals.RELATIONSHIP__RELATED_ELEMENT);
				break;
			case SysMLPackage.ELEMENT_FILTER_MEMBERSHIP__TARGET:
				notifyChanged(notification, eClass, SysMLPackage.Literals.RELATIONSHIP__RELATED_ELEMENT);
				break;
			case SysMLPackage.ELEMENT_FILTER_MEMBERSHIP__SOURCE:
				notifyChanged(notification, eClass, SysMLPackage.Literals.RELATIONSHIP__RELATED_ELEMENT);
				break;
			case SysMLPackage.ELEMENT_FILTER_MEMBERSHIP__MEMBERSHIP_OWNING_NAMESPACE:
				notifyChanged(notification, eClass, SysMLPackage.Literals.RELATIONSHIP__RELATED_ELEMENT);
				break;
			case SysMLPackage.ELEMENT_FILTER_MEMBERSHIP__OWNED_MEMBER_ELEMENT:
				notifyChanged(notification, eClass, SysMLPackage.Literals.RELATIONSHIP__RELATED_ELEMENT);
				break;
		}
	}

	/**
	 * Calls <code>notifyChanged</code> for each affected derived union.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param notification a description of the change.
	 * @param eClass the Ecore class of the notifier.
	 * @generated
	 */
	protected void notifyPortUsageChanged(Notification notification, EClass eClass) {
		switch (notification.getFeatureID(PortUsage.class)) {
			case SysMLPackage.PORT_USAGE__IMPORTED_MEMBERSHIP:
				notifyChanged(notification, eClass, SysMLPackage.Literals.NAMESPACE__MEMBERSHIP);
				break;
			case SysMLPackage.PORT_USAGE__OWNED_MEMBERSHIP:
				notifyChanged(notification, eClass, SysMLPackage.Literals.NAMESPACE__MEMBERSHIP);
				break;
			case SysMLPackage.PORT_USAGE__OWNED_FEATURE_MEMBERSHIP:
				notifyChanged(notification, eClass, SysMLPackage.Literals.NAMESPACE__MEMBERSHIP);
				break;
			case SysMLPackage.PORT_USAGE__INHERITED_MEMBERSHIP:
				notifyChanged(notification, eClass, SysMLPackage.Literals.NAMESPACE__MEMBERSHIP);
				break;
			case SysMLPackage.PORT_USAGE__VARIANT_MEMBERSHIP:
				notifyChanged(notification, eClass, SysMLPackage.Literals.NAMESPACE__MEMBERSHIP);
				break;
		}
	}

	/**
	 * Calls <code>notifyChanged</code> for each affected derived union.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param notification a description of the change.
	 * @param eClass the Ecore class of the notifier.
	 * @generated
	 */
	protected void notifyPortDefinitionChanged(Notification notification, EClass eClass) {
		switch (notification.getFeatureID(PortDefinition.class)) {
			case SysMLPackage.PORT_DEFINITION__IMPORTED_MEMBERSHIP:
				notifyChanged(notification, eClass, SysMLPackage.Literals.NAMESPACE__MEMBERSHIP);
				break;
			case SysMLPackage.PORT_DEFINITION__OWNED_MEMBERSHIP:
				notifyChanged(notification, eClass, SysMLPackage.Literals.NAMESPACE__MEMBERSHIP);
				break;
			case SysMLPackage.PORT_DEFINITION__OWNED_FEATURE_MEMBERSHIP:
				notifyChanged(notification, eClass, SysMLPackage.Literals.NAMESPACE__MEMBERSHIP);
				break;
			case SysMLPackage.PORT_DEFINITION__INHERITED_MEMBERSHIP:
				notifyChanged(notification, eClass, SysMLPackage.Literals.NAMESPACE__MEMBERSHIP);
				break;
			case SysMLPackage.PORT_DEFINITION__VARIANT_MEMBERSHIP:
				notifyChanged(notification, eClass, SysMLPackage.Literals.NAMESPACE__MEMBERSHIP);
				break;
		}
	}

	/**
	 * Calls <code>notifyChanged</code> for each affected derived union.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param notification a description of the change.
	 * @param eClass the Ecore class of the notifier.
	 * @generated
	 */
	protected void notifyConjugatedPortDefinitionChanged(Notification notification, EClass eClass) {
		switch (notification.getFeatureID(ConjugatedPortDefinition.class)) {
			case SysMLPackage.CONJUGATED_PORT_DEFINITION__IMPORTED_MEMBERSHIP:
				notifyChanged(notification, eClass, SysMLPackage.Literals.NAMESPACE__MEMBERSHIP);
				break;
			case SysMLPackage.CONJUGATED_PORT_DEFINITION__OWNED_MEMBERSHIP:
				notifyChanged(notification, eClass, SysMLPackage.Literals.NAMESPACE__MEMBERSHIP);
				break;
			case SysMLPackage.CONJUGATED_PORT_DEFINITION__OWNED_FEATURE_MEMBERSHIP:
				notifyChanged(notification, eClass, SysMLPackage.Literals.NAMESPACE__MEMBERSHIP);
				break;
			case SysMLPackage.CONJUGATED_PORT_DEFINITION__INHERITED_MEMBERSHIP:
				notifyChanged(notification, eClass, SysMLPackage.Literals.NAMESPACE__MEMBERSHIP);
				break;
			case SysMLPackage.CONJUGATED_PORT_DEFINITION__VARIANT_MEMBERSHIP:
				notifyChanged(notification, eClass, SysMLPackage.Literals.NAMESPACE__MEMBERSHIP);
				break;
		}
	}

	/**
	 * Calls <code>notifyChanged</code> for each affected derived union.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param notification a description of the change.
	 * @param eClass the Ecore class of the notifier.
	 * @generated
	 */
	protected void notifyPortConjugationChanged(Notification notification, EClass eClass) {
		switch (notification.getFeatureID(PortConjugation.class)) {
			case SysMLPackage.PORT_CONJUGATION__OWNED_RELATED_ELEMENT:
				notifyChanged(notification, eClass, SysMLPackage.Literals.RELATIONSHIP__RELATED_ELEMENT);
				break;
			case SysMLPackage.PORT_CONJUGATION__OWNING_RELATED_ELEMENT:
				notifyChanged(notification, eClass, SysMLPackage.Literals.RELATIONSHIP__RELATED_ELEMENT);
				break;
			case SysMLPackage.PORT_CONJUGATION__TARGET:
				notifyChanged(notification, eClass, SysMLPackage.Literals.RELATIONSHIP__RELATED_ELEMENT);
				break;
			case SysMLPackage.PORT_CONJUGATION__SOURCE:
				notifyChanged(notification, eClass, SysMLPackage.Literals.RELATIONSHIP__RELATED_ELEMENT);
				break;
			case SysMLPackage.PORT_CONJUGATION__OWNING_TYPE:
				notifyChanged(notification, eClass, SysMLPackage.Literals.RELATIONSHIP__RELATED_ELEMENT);
				break;
		}
	}

	/**
	 * Calls <code>notifyChanged</code> for each affected derived union.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param notification a description of the change.
	 * @param eClass the Ecore class of the notifier.
	 * @generated
	 */
	protected void notifyStateUsageChanged(Notification notification, EClass eClass) {
		switch (notification.getFeatureID(StateUsage.class)) {
			case SysMLPackage.STATE_USAGE__IMPORTED_MEMBERSHIP:
				notifyChanged(notification, eClass, SysMLPackage.Literals.NAMESPACE__MEMBERSHIP);
				break;
			case SysMLPackage.STATE_USAGE__OWNED_MEMBERSHIP:
				notifyChanged(notification, eClass, SysMLPackage.Literals.NAMESPACE__MEMBERSHIP);
				break;
			case SysMLPackage.STATE_USAGE__OWNED_FEATURE_MEMBERSHIP:
				notifyChanged(notification, eClass, SysMLPackage.Literals.NAMESPACE__MEMBERSHIP);
				break;
			case SysMLPackage.STATE_USAGE__INHERITED_MEMBERSHIP:
				notifyChanged(notification, eClass, SysMLPackage.Literals.NAMESPACE__MEMBERSHIP);
				break;
			case SysMLPackage.STATE_USAGE__VARIANT_MEMBERSHIP:
				notifyChanged(notification, eClass, SysMLPackage.Literals.NAMESPACE__MEMBERSHIP);
				break;
		}
	}

	/**
	 * Calls <code>notifyChanged</code> for each affected derived union.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param notification a description of the change.
	 * @param eClass the Ecore class of the notifier.
	 * @generated
	 */
	protected void notifyConstraintUsageChanged(Notification notification, EClass eClass) {
		switch (notification.getFeatureID(ConstraintUsage.class)) {
			case SysMLPackage.CONSTRAINT_USAGE__IMPORTED_MEMBERSHIP:
				notifyChanged(notification, eClass, SysMLPackage.Literals.NAMESPACE__MEMBERSHIP);
				break;
			case SysMLPackage.CONSTRAINT_USAGE__OWNED_MEMBERSHIP:
				notifyChanged(notification, eClass, SysMLPackage.Literals.NAMESPACE__MEMBERSHIP);
				break;
			case SysMLPackage.CONSTRAINT_USAGE__OWNED_FEATURE_MEMBERSHIP:
				notifyChanged(notification, eClass, SysMLPackage.Literals.NAMESPACE__MEMBERSHIP);
				break;
			case SysMLPackage.CONSTRAINT_USAGE__INHERITED_MEMBERSHIP:
				notifyChanged(notification, eClass, SysMLPackage.Literals.NAMESPACE__MEMBERSHIP);
				break;
			case SysMLPackage.CONSTRAINT_USAGE__VARIANT_MEMBERSHIP:
				notifyChanged(notification, eClass, SysMLPackage.Literals.NAMESPACE__MEMBERSHIP);
				break;
		}
	}

	/**
	 * Calls <code>notifyChanged</code> for each affected derived union.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param notification a description of the change.
	 * @param eClass the Ecore class of the notifier.
	 * @generated
	 */
	protected void notifyInvariantChanged(Notification notification, EClass eClass) {
		switch (notification.getFeatureID(Invariant.class)) {
			case SysMLPackage.INVARIANT__IMPORTED_MEMBERSHIP:
				notifyChanged(notification, eClass, SysMLPackage.Literals.NAMESPACE__MEMBERSHIP);
				break;
			case SysMLPackage.INVARIANT__OWNED_MEMBERSHIP:
				notifyChanged(notification, eClass, SysMLPackage.Literals.NAMESPACE__MEMBERSHIP);
				break;
			case SysMLPackage.INVARIANT__OWNED_FEATURE_MEMBERSHIP:
				notifyChanged(notification, eClass, SysMLPackage.Literals.NAMESPACE__MEMBERSHIP);
				break;
			case SysMLPackage.INVARIANT__INHERITED_MEMBERSHIP:
				notifyChanged(notification, eClass, SysMLPackage.Literals.NAMESPACE__MEMBERSHIP);
				break;
		}
	}

	/**
	 * Calls <code>notifyChanged</code> for each affected derived union.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param notification a description of the change.
	 * @param eClass the Ecore class of the notifier.
	 * @generated
	 */
	protected void notifyIncludeUseCaseUsageChanged(Notification notification, EClass eClass) {
		switch (notification.getFeatureID(IncludeUseCaseUsage.class)) {
			case SysMLPackage.INCLUDE_USE_CASE_USAGE__IMPORTED_MEMBERSHIP:
				notifyChanged(notification, eClass, SysMLPackage.Literals.NAMESPACE__MEMBERSHIP);
				break;
			case SysMLPackage.INCLUDE_USE_CASE_USAGE__OWNED_MEMBERSHIP:
				notifyChanged(notification, eClass, SysMLPackage.Literals.NAMESPACE__MEMBERSHIP);
				break;
			case SysMLPackage.INCLUDE_USE_CASE_USAGE__OWNED_FEATURE_MEMBERSHIP:
				notifyChanged(notification, eClass, SysMLPackage.Literals.NAMESPACE__MEMBERSHIP);
				break;
			case SysMLPackage.INCLUDE_USE_CASE_USAGE__INHERITED_MEMBERSHIP:
				notifyChanged(notification, eClass, SysMLPackage.Literals.NAMESPACE__MEMBERSHIP);
				break;
			case SysMLPackage.INCLUDE_USE_CASE_USAGE__VARIANT_MEMBERSHIP:
				notifyChanged(notification, eClass, SysMLPackage.Literals.NAMESPACE__MEMBERSHIP);
				break;
		}
	}

	/**
	 * Calls <code>notifyChanged</code> for each affected derived union.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param notification a description of the change.
	 * @param eClass the Ecore class of the notifier.
	 * @generated
	 */
	protected void notifyBooleanExpressionChanged(Notification notification, EClass eClass) {
		switch (notification.getFeatureID(BooleanExpression.class)) {
			case SysMLPackage.BOOLEAN_EXPRESSION__IMPORTED_MEMBERSHIP:
				notifyChanged(notification, eClass, SysMLPackage.Literals.NAMESPACE__MEMBERSHIP);
				break;
			case SysMLPackage.BOOLEAN_EXPRESSION__OWNED_MEMBERSHIP:
				notifyChanged(notification, eClass, SysMLPackage.Literals.NAMESPACE__MEMBERSHIP);
				break;
			case SysMLPackage.BOOLEAN_EXPRESSION__OWNED_FEATURE_MEMBERSHIP:
				notifyChanged(notification, eClass, SysMLPackage.Literals.NAMESPACE__MEMBERSHIP);
				break;
			case SysMLPackage.BOOLEAN_EXPRESSION__INHERITED_MEMBERSHIP:
				notifyChanged(notification, eClass, SysMLPackage.Literals.NAMESPACE__MEMBERSHIP);
				break;
		}
	}

	/**
	 * Calls <code>notifyChanged</code> for each affected derived union.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param notification a description of the change.
	 * @param eClass the Ecore class of the notifier.
	 * @generated
	 */
	protected void notifyActionUsageChanged(Notification notification, EClass eClass) {
		switch (notification.getFeatureID(ActionUsage.class)) {
			case SysMLPackage.ACTION_USAGE__IMPORTED_MEMBERSHIP:
				notifyChanged(notification, eClass, SysMLPackage.Literals.NAMESPACE__MEMBERSHIP);
				break;
			case SysMLPackage.ACTION_USAGE__OWNED_MEMBERSHIP:
				notifyChanged(notification, eClass, SysMLPackage.Literals.NAMESPACE__MEMBERSHIP);
				break;
			case SysMLPackage.ACTION_USAGE__OWNED_FEATURE_MEMBERSHIP:
				notifyChanged(notification, eClass, SysMLPackage.Literals.NAMESPACE__MEMBERSHIP);
				break;
			case SysMLPackage.ACTION_USAGE__INHERITED_MEMBERSHIP:
				notifyChanged(notification, eClass, SysMLPackage.Literals.NAMESPACE__MEMBERSHIP);
				break;
			case SysMLPackage.ACTION_USAGE__VARIANT_MEMBERSHIP:
				notifyChanged(notification, eClass, SysMLPackage.Literals.NAMESPACE__MEMBERSHIP);
				break;
		}
	}

	/**
	 * Calls <code>notifyChanged</code> for each affected derived union.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param notification a description of the change.
	 * @param eClass the Ecore class of the notifier.
	 * @generated
	 */
	protected void notifyOccurrenceUsageChanged(Notification notification, EClass eClass) {
		switch (notification.getFeatureID(OccurrenceUsage.class)) {
			case SysMLPackage.OCCURRENCE_USAGE__IMPORTED_MEMBERSHIP:
				notifyChanged(notification, eClass, SysMLPackage.Literals.NAMESPACE__MEMBERSHIP);
				break;
			case SysMLPackage.OCCURRENCE_USAGE__OWNED_MEMBERSHIP:
				notifyChanged(notification, eClass, SysMLPackage.Literals.NAMESPACE__MEMBERSHIP);
				break;
			case SysMLPackage.OCCURRENCE_USAGE__OWNED_FEATURE_MEMBERSHIP:
				notifyChanged(notification, eClass, SysMLPackage.Literals.NAMESPACE__MEMBERSHIP);
				break;
			case SysMLPackage.OCCURRENCE_USAGE__INHERITED_MEMBERSHIP:
				notifyChanged(notification, eClass, SysMLPackage.Literals.NAMESPACE__MEMBERSHIP);
				break;
			case SysMLPackage.OCCURRENCE_USAGE__VARIANT_MEMBERSHIP:
				notifyChanged(notification, eClass, SysMLPackage.Literals.NAMESPACE__MEMBERSHIP);
				break;
		}
	}

	/**
	 * Calls <code>notifyChanged</code> for each affected derived union.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param notification a description of the change.
	 * @param eClass the Ecore class of the notifier.
	 * @generated
	 */
	protected void notifyPortioningFeatureChanged(Notification notification, EClass eClass) {
		switch (notification.getFeatureID(PortioningFeature.class)) {
			case SysMLPackage.PORTIONING_FEATURE__IMPORTED_MEMBERSHIP:
				notifyChanged(notification, eClass, SysMLPackage.Literals.NAMESPACE__MEMBERSHIP);
				break;
			case SysMLPackage.PORTIONING_FEATURE__OWNED_MEMBERSHIP:
				notifyChanged(notification, eClass, SysMLPackage.Literals.NAMESPACE__MEMBERSHIP);
				break;
			case SysMLPackage.PORTIONING_FEATURE__OWNED_FEATURE_MEMBERSHIP:
				notifyChanged(notification, eClass, SysMLPackage.Literals.NAMESPACE__MEMBERSHIP);
				break;
			case SysMLPackage.PORTIONING_FEATURE__INHERITED_MEMBERSHIP:
				notifyChanged(notification, eClass, SysMLPackage.Literals.NAMESPACE__MEMBERSHIP);
				break;
		}
	}

	/**
	 * Calls <code>notifyChanged</code> for each affected derived union.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param notification a description of the change.
	 * @param eClass the Ecore class of the notifier.
	 * @generated
	 */
	protected void notifyExhibitStateUsageChanged(Notification notification, EClass eClass) {
		switch (notification.getFeatureID(ExhibitStateUsage.class)) {
			case SysMLPackage.EXHIBIT_STATE_USAGE__IMPORTED_MEMBERSHIP:
				notifyChanged(notification, eClass, SysMLPackage.Literals.NAMESPACE__MEMBERSHIP);
				break;
			case SysMLPackage.EXHIBIT_STATE_USAGE__OWNED_MEMBERSHIP:
				notifyChanged(notification, eClass, SysMLPackage.Literals.NAMESPACE__MEMBERSHIP);
				break;
			case SysMLPackage.EXHIBIT_STATE_USAGE__OWNED_FEATURE_MEMBERSHIP:
				notifyChanged(notification, eClass, SysMLPackage.Literals.NAMESPACE__MEMBERSHIP);
				break;
			case SysMLPackage.EXHIBIT_STATE_USAGE__INHERITED_MEMBERSHIP:
				notifyChanged(notification, eClass, SysMLPackage.Literals.NAMESPACE__MEMBERSHIP);
				break;
			case SysMLPackage.EXHIBIT_STATE_USAGE__VARIANT_MEMBERSHIP:
				notifyChanged(notification, eClass, SysMLPackage.Literals.NAMESPACE__MEMBERSHIP);
				break;
		}
	}

	/**
	 * Calls <code>notifyChanged</code> for each affected derived union.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param notification a description of the change.
	 * @param eClass the Ecore class of the notifier.
	 * @generated
	 */
	protected void notifyAttributeDefinitionChanged(Notification notification, EClass eClass) {
		switch (notification.getFeatureID(AttributeDefinition.class)) {
			case SysMLPackage.ATTRIBUTE_DEFINITION__IMPORTED_MEMBERSHIP:
				notifyChanged(notification, eClass, SysMLPackage.Literals.NAMESPACE__MEMBERSHIP);
				break;
			case SysMLPackage.ATTRIBUTE_DEFINITION__OWNED_MEMBERSHIP:
				notifyChanged(notification, eClass, SysMLPackage.Literals.NAMESPACE__MEMBERSHIP);
				break;
			case SysMLPackage.ATTRIBUTE_DEFINITION__OWNED_FEATURE_MEMBERSHIP:
				notifyChanged(notification, eClass, SysMLPackage.Literals.NAMESPACE__MEMBERSHIP);
				break;
			case SysMLPackage.ATTRIBUTE_DEFINITION__INHERITED_MEMBERSHIP:
				notifyChanged(notification, eClass, SysMLPackage.Literals.NAMESPACE__MEMBERSHIP);
				break;
			case SysMLPackage.ATTRIBUTE_DEFINITION__VARIANT_MEMBERSHIP:
				notifyChanged(notification, eClass, SysMLPackage.Literals.NAMESPACE__MEMBERSHIP);
				break;
		}
	}

	/**
	 * Calls <code>notifyChanged</code> for each affected derived union.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param notification a description of the change.
	 * @param eClass the Ecore class of the notifier.
	 * @generated
	 */
	protected void notifyAllocationUsageChanged(Notification notification, EClass eClass) {
		switch (notification.getFeatureID(AllocationUsage.class)) {
			case SysMLPackage.ALLOCATION_USAGE__IMPORTED_MEMBERSHIP:
				notifyChanged(notification, eClass, SysMLPackage.Literals.NAMESPACE__MEMBERSHIP);
				break;
			case SysMLPackage.ALLOCATION_USAGE__OWNED_MEMBERSHIP:
				notifyChanged(notification, eClass, SysMLPackage.Literals.NAMESPACE__MEMBERSHIP);
				break;
			case SysMLPackage.ALLOCATION_USAGE__OWNED_FEATURE_MEMBERSHIP:
				notifyChanged(notification, eClass, SysMLPackage.Literals.NAMESPACE__MEMBERSHIP);
				break;
			case SysMLPackage.ALLOCATION_USAGE__INHERITED_MEMBERSHIP:
				notifyChanged(notification, eClass, SysMLPackage.Literals.NAMESPACE__MEMBERSHIP);
				break;
			case SysMLPackage.ALLOCATION_USAGE__VARIANT_MEMBERSHIP:
				notifyChanged(notification, eClass, SysMLPackage.Literals.NAMESPACE__MEMBERSHIP);
				break;
			case SysMLPackage.ALLOCATION_USAGE__OWNED_RELATED_ELEMENT:
				notifyChanged(notification, eClass, SysMLPackage.Literals.RELATIONSHIP__RELATED_ELEMENT);
				break;
			case SysMLPackage.ALLOCATION_USAGE__OWNING_RELATED_ELEMENT:
				notifyChanged(notification, eClass, SysMLPackage.Literals.RELATIONSHIP__RELATED_ELEMENT);
				break;
			case SysMLPackage.ALLOCATION_USAGE__TARGET:
				notifyChanged(notification, eClass, SysMLPackage.Literals.RELATIONSHIP__RELATED_ELEMENT);
				break;
			case SysMLPackage.ALLOCATION_USAGE__SOURCE:
				notifyChanged(notification, eClass, SysMLPackage.Literals.RELATIONSHIP__RELATED_ELEMENT);
				break;
			case SysMLPackage.ALLOCATION_USAGE__SOURCE_FEATURE:
				notifyChanged(notification, eClass, SysMLPackage.Literals.CONNECTOR__RELATED_FEATURE);
				break;
			case SysMLPackage.ALLOCATION_USAGE__TARGET_FEATURE:
				notifyChanged(notification, eClass, SysMLPackage.Literals.CONNECTOR__RELATED_FEATURE);
				break;
		}
	}

	/**
	 * Calls <code>notifyChanged</code> for each affected derived union.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param notification a description of the change.
	 * @param eClass the Ecore class of the notifier.
	 * @generated
	 */
	protected void notifyAllocationDefinitionChanged(Notification notification, EClass eClass) {
		switch (notification.getFeatureID(AllocationDefinition.class)) {
			case SysMLPackage.ALLOCATION_DEFINITION__IMPORTED_MEMBERSHIP:
				notifyChanged(notification, eClass, SysMLPackage.Literals.NAMESPACE__MEMBERSHIP);
				break;
			case SysMLPackage.ALLOCATION_DEFINITION__OWNED_MEMBERSHIP:
				notifyChanged(notification, eClass, SysMLPackage.Literals.NAMESPACE__MEMBERSHIP);
				break;
			case SysMLPackage.ALLOCATION_DEFINITION__OWNED_FEATURE_MEMBERSHIP:
				notifyChanged(notification, eClass, SysMLPackage.Literals.NAMESPACE__MEMBERSHIP);
				break;
			case SysMLPackage.ALLOCATION_DEFINITION__INHERITED_MEMBERSHIP:
				notifyChanged(notification, eClass, SysMLPackage.Literals.NAMESPACE__MEMBERSHIP);
				break;
			case SysMLPackage.ALLOCATION_DEFINITION__VARIANT_MEMBERSHIP:
				notifyChanged(notification, eClass, SysMLPackage.Literals.NAMESPACE__MEMBERSHIP);
				break;
			case SysMLPackage.ALLOCATION_DEFINITION__OWNED_RELATED_ELEMENT:
				notifyChanged(notification, eClass, SysMLPackage.Literals.RELATIONSHIP__RELATED_ELEMENT);
				break;
			case SysMLPackage.ALLOCATION_DEFINITION__OWNING_RELATED_ELEMENT:
				notifyChanged(notification, eClass, SysMLPackage.Literals.RELATIONSHIP__RELATED_ELEMENT);
				break;
			case SysMLPackage.ALLOCATION_DEFINITION__TARGET:
				notifyChanged(notification, eClass, SysMLPackage.Literals.RELATIONSHIP__RELATED_ELEMENT);
				break;
			case SysMLPackage.ALLOCATION_DEFINITION__SOURCE:
				notifyChanged(notification, eClass, SysMLPackage.Literals.RELATIONSHIP__RELATED_ELEMENT);
				break;
			case SysMLPackage.ALLOCATION_DEFINITION__SOURCE_TYPE:
				notifyChanged(notification, eClass, SysMLPackage.Literals.ASSOCIATION__RELATED_TYPE);
				break;
			case SysMLPackage.ALLOCATION_DEFINITION__TARGET_TYPE:
				notifyChanged(notification, eClass, SysMLPackage.Literals.ASSOCIATION__RELATED_TYPE);
				break;
		}
	}

	/**
	 * Calls <code>notifyChanged</code> for each affected derived union.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param notification a description of the change.
	 * @param eClass the Ecore class of the notifier.
	 * @generated
	 */
	protected void notifyUseCaseUsageChanged(Notification notification, EClass eClass) {
		switch (notification.getFeatureID(UseCaseUsage.class)) {
			case SysMLPackage.USE_CASE_USAGE__IMPORTED_MEMBERSHIP:
				notifyChanged(notification, eClass, SysMLPackage.Literals.NAMESPACE__MEMBERSHIP);
				break;
			case SysMLPackage.USE_CASE_USAGE__OWNED_MEMBERSHIP:
				notifyChanged(notification, eClass, SysMLPackage.Literals.NAMESPACE__MEMBERSHIP);
				break;
			case SysMLPackage.USE_CASE_USAGE__OWNED_FEATURE_MEMBERSHIP:
				notifyChanged(notification, eClass, SysMLPackage.Literals.NAMESPACE__MEMBERSHIP);
				break;
			case SysMLPackage.USE_CASE_USAGE__INHERITED_MEMBERSHIP:
				notifyChanged(notification, eClass, SysMLPackage.Literals.NAMESPACE__MEMBERSHIP);
				break;
			case SysMLPackage.USE_CASE_USAGE__VARIANT_MEMBERSHIP:
				notifyChanged(notification, eClass, SysMLPackage.Literals.NAMESPACE__MEMBERSHIP);
				break;
		}
	}

	/**
	 * Calls <code>notifyChanged</code> for each affected derived union.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param notification a description of the change.
	 * @param eClass the Ecore class of the notifier.
	 * @generated
	 */
	protected void notifyUseCaseDefinitionChanged(Notification notification, EClass eClass) {
		switch (notification.getFeatureID(UseCaseDefinition.class)) {
			case SysMLPackage.USE_CASE_DEFINITION__IMPORTED_MEMBERSHIP:
				notifyChanged(notification, eClass, SysMLPackage.Literals.NAMESPACE__MEMBERSHIP);
				break;
			case SysMLPackage.USE_CASE_DEFINITION__OWNED_MEMBERSHIP:
				notifyChanged(notification, eClass, SysMLPackage.Literals.NAMESPACE__MEMBERSHIP);
				break;
			case SysMLPackage.USE_CASE_DEFINITION__OWNED_FEATURE_MEMBERSHIP:
				notifyChanged(notification, eClass, SysMLPackage.Literals.NAMESPACE__MEMBERSHIP);
				break;
			case SysMLPackage.USE_CASE_DEFINITION__INHERITED_MEMBERSHIP:
				notifyChanged(notification, eClass, SysMLPackage.Literals.NAMESPACE__MEMBERSHIP);
				break;
			case SysMLPackage.USE_CASE_DEFINITION__VARIANT_MEMBERSHIP:
				notifyChanged(notification, eClass, SysMLPackage.Literals.NAMESPACE__MEMBERSHIP);
				break;
		}
	}

	/**
	 * Calls <code>notifyChanged</code> for each affected derived union.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param notification a description of the change.
	 * @param eClass the Ecore class of the notifier.
	 * @generated
	 */
	protected void notifyFlowConnectionUsageChanged(Notification notification, EClass eClass) {
		switch (notification.getFeatureID(FlowConnectionUsage.class)) {
			case SysMLPackage.FLOW_CONNECTION_USAGE__IMPORTED_MEMBERSHIP:
				notifyChanged(notification, eClass, SysMLPackage.Literals.NAMESPACE__MEMBERSHIP);
				break;
			case SysMLPackage.FLOW_CONNECTION_USAGE__OWNED_MEMBERSHIP:
				notifyChanged(notification, eClass, SysMLPackage.Literals.NAMESPACE__MEMBERSHIP);
				break;
			case SysMLPackage.FLOW_CONNECTION_USAGE__OWNED_FEATURE_MEMBERSHIP:
				notifyChanged(notification, eClass, SysMLPackage.Literals.NAMESPACE__MEMBERSHIP);
				break;
			case SysMLPackage.FLOW_CONNECTION_USAGE__INHERITED_MEMBERSHIP:
				notifyChanged(notification, eClass, SysMLPackage.Literals.NAMESPACE__MEMBERSHIP);
				break;
			case SysMLPackage.FLOW_CONNECTION_USAGE__VARIANT_MEMBERSHIP:
				notifyChanged(notification, eClass, SysMLPackage.Literals.NAMESPACE__MEMBERSHIP);
				break;
			case SysMLPackage.FLOW_CONNECTION_USAGE__OWNED_RELATED_ELEMENT:
				notifyChanged(notification, eClass, SysMLPackage.Literals.RELATIONSHIP__RELATED_ELEMENT);
				break;
			case SysMLPackage.FLOW_CONNECTION_USAGE__OWNING_RELATED_ELEMENT:
				notifyChanged(notification, eClass, SysMLPackage.Literals.RELATIONSHIP__RELATED_ELEMENT);
				break;
			case SysMLPackage.FLOW_CONNECTION_USAGE__TARGET:
				notifyChanged(notification, eClass, SysMLPackage.Literals.RELATIONSHIP__RELATED_ELEMENT);
				break;
			case SysMLPackage.FLOW_CONNECTION_USAGE__SOURCE:
				notifyChanged(notification, eClass, SysMLPackage.Literals.RELATIONSHIP__RELATED_ELEMENT);
				break;
			case SysMLPackage.FLOW_CONNECTION_USAGE__SOURCE_FEATURE:
				notifyChanged(notification, eClass, SysMLPackage.Literals.CONNECTOR__RELATED_FEATURE);
				break;
			case SysMLPackage.FLOW_CONNECTION_USAGE__TARGET_FEATURE:
				notifyChanged(notification, eClass, SysMLPackage.Literals.CONNECTOR__RELATED_FEATURE);
				break;
		}
	}

	/**
	 * Calls <code>notifyChanged</code> for each affected derived union.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param notification a description of the change.
	 * @param eClass the Ecore class of the notifier.
	 * @generated
	 */
	protected void notifyStateSubactionMembershipChanged(Notification notification, EClass eClass) {
		switch (notification.getFeatureID(StateSubactionMembership.class)) {
			case SysMLPackage.STATE_SUBACTION_MEMBERSHIP__OWNED_RELATED_ELEMENT:
				notifyChanged(notification, eClass, SysMLPackage.Literals.RELATIONSHIP__RELATED_ELEMENT);
				break;
			case SysMLPackage.STATE_SUBACTION_MEMBERSHIP__OWNING_RELATED_ELEMENT:
				notifyChanged(notification, eClass, SysMLPackage.Literals.RELATIONSHIP__RELATED_ELEMENT);
				break;
			case SysMLPackage.STATE_SUBACTION_MEMBERSHIP__TARGET:
				notifyChanged(notification, eClass, SysMLPackage.Literals.RELATIONSHIP__RELATED_ELEMENT);
				break;
			case SysMLPackage.STATE_SUBACTION_MEMBERSHIP__SOURCE:
				notifyChanged(notification, eClass, SysMLPackage.Literals.RELATIONSHIP__RELATED_ELEMENT);
				break;
			case SysMLPackage.STATE_SUBACTION_MEMBERSHIP__MEMBERSHIP_OWNING_NAMESPACE:
				notifyChanged(notification, eClass, SysMLPackage.Literals.RELATIONSHIP__RELATED_ELEMENT);
				break;
			case SysMLPackage.STATE_SUBACTION_MEMBERSHIP__OWNED_MEMBER_ELEMENT:
				notifyChanged(notification, eClass, SysMLPackage.Literals.RELATIONSHIP__RELATED_ELEMENT);
				break;
			case SysMLPackage.STATE_SUBACTION_MEMBERSHIP__OWNING_FEATURE_OF_TYPE:
				notifyChanged(notification, eClass, SysMLPackage.Literals.RELATIONSHIP__RELATED_ELEMENT);
				break;
		}
	}

	/**
	 * Calls <code>notifyChanged</code> for each affected derived union.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param notification a description of the change.
	 * @param eClass the Ecore class of the notifier.
	 * @generated
	 */
	protected void notifyConjugatedPortTypingChanged(Notification notification, EClass eClass) {
		switch (notification.getFeatureID(ConjugatedPortTyping.class)) {
			case SysMLPackage.CONJUGATED_PORT_TYPING__OWNED_RELATED_ELEMENT:
				notifyChanged(notification, eClass, SysMLPackage.Literals.RELATIONSHIP__RELATED_ELEMENT);
				break;
			case SysMLPackage.CONJUGATED_PORT_TYPING__OWNING_RELATED_ELEMENT:
				notifyChanged(notification, eClass, SysMLPackage.Literals.RELATIONSHIP__RELATED_ELEMENT);
				break;
			case SysMLPackage.CONJUGATED_PORT_TYPING__TARGET:
				notifyChanged(notification, eClass, SysMLPackage.Literals.RELATIONSHIP__RELATED_ELEMENT);
				break;
			case SysMLPackage.CONJUGATED_PORT_TYPING__SOURCE:
				notifyChanged(notification, eClass, SysMLPackage.Literals.RELATIONSHIP__RELATED_ELEMENT);
				break;
			case SysMLPackage.CONJUGATED_PORT_TYPING__OWNING_TYPE:
				notifyChanged(notification, eClass, SysMLPackage.Literals.RELATIONSHIP__RELATED_ELEMENT);
				break;
			case SysMLPackage.CONJUGATED_PORT_TYPING__PORT_DEFINITION:
				notifyChanged(notification, eClass, SysMLPackage.Literals.RELATIONSHIP__RELATED_ELEMENT);
				break;
		}
	}

	/**
	 * Calls <code>notifyChanged</code> for each affected derived union.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param notification a description of the change.
	 * @param eClass the Ecore class of the notifier.
	 * @generated
	 */
	protected void notifyBindingConnectorAsUsageChanged(Notification notification, EClass eClass) {
		switch (notification.getFeatureID(BindingConnectorAsUsage.class)) {
			case SysMLPackage.BINDING_CONNECTOR_AS_USAGE__IMPORTED_MEMBERSHIP:
				notifyChanged(notification, eClass, SysMLPackage.Literals.NAMESPACE__MEMBERSHIP);
				break;
			case SysMLPackage.BINDING_CONNECTOR_AS_USAGE__OWNED_MEMBERSHIP:
				notifyChanged(notification, eClass, SysMLPackage.Literals.NAMESPACE__MEMBERSHIP);
				break;
			case SysMLPackage.BINDING_CONNECTOR_AS_USAGE__OWNED_FEATURE_MEMBERSHIP:
				notifyChanged(notification, eClass, SysMLPackage.Literals.NAMESPACE__MEMBERSHIP);
				break;
			case SysMLPackage.BINDING_CONNECTOR_AS_USAGE__INHERITED_MEMBERSHIP:
				notifyChanged(notification, eClass, SysMLPackage.Literals.NAMESPACE__MEMBERSHIP);
				break;
			case SysMLPackage.BINDING_CONNECTOR_AS_USAGE__VARIANT_MEMBERSHIP:
				notifyChanged(notification, eClass, SysMLPackage.Literals.NAMESPACE__MEMBERSHIP);
				break;
			case SysMLPackage.BINDING_CONNECTOR_AS_USAGE__OWNED_RELATED_ELEMENT:
				notifyChanged(notification, eClass, SysMLPackage.Literals.RELATIONSHIP__RELATED_ELEMENT);
				break;
			case SysMLPackage.BINDING_CONNECTOR_AS_USAGE__OWNING_RELATED_ELEMENT:
				notifyChanged(notification, eClass, SysMLPackage.Literals.RELATIONSHIP__RELATED_ELEMENT);
				break;
			case SysMLPackage.BINDING_CONNECTOR_AS_USAGE__TARGET:
				notifyChanged(notification, eClass, SysMLPackage.Literals.RELATIONSHIP__RELATED_ELEMENT);
				break;
			case SysMLPackage.BINDING_CONNECTOR_AS_USAGE__SOURCE:
				notifyChanged(notification, eClass, SysMLPackage.Literals.RELATIONSHIP__RELATED_ELEMENT);
				break;
			case SysMLPackage.BINDING_CONNECTOR_AS_USAGE__SOURCE_FEATURE:
				notifyChanged(notification, eClass, SysMLPackage.Literals.CONNECTOR__RELATED_FEATURE);
				break;
			case SysMLPackage.BINDING_CONNECTOR_AS_USAGE__TARGET_FEATURE:
				notifyChanged(notification, eClass, SysMLPackage.Literals.CONNECTOR__RELATED_FEATURE);
				break;
		}
	}

	/**
	 * Calls <code>notifyChanged</code> for each affected derived union.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param notification a description of the change.
	 * @param eClass the Ecore class of the notifier.
	 * @generated
	 */
	protected void notifyItemDefinitionChanged(Notification notification, EClass eClass) {
		switch (notification.getFeatureID(ItemDefinition.class)) {
			case SysMLPackage.ITEM_DEFINITION__IMPORTED_MEMBERSHIP:
				notifyChanged(notification, eClass, SysMLPackage.Literals.NAMESPACE__MEMBERSHIP);
				break;
			case SysMLPackage.ITEM_DEFINITION__OWNED_MEMBERSHIP:
				notifyChanged(notification, eClass, SysMLPackage.Literals.NAMESPACE__MEMBERSHIP);
				break;
			case SysMLPackage.ITEM_DEFINITION__OWNED_FEATURE_MEMBERSHIP:
				notifyChanged(notification, eClass, SysMLPackage.Literals.NAMESPACE__MEMBERSHIP);
				break;
			case SysMLPackage.ITEM_DEFINITION__INHERITED_MEMBERSHIP:
				notifyChanged(notification, eClass, SysMLPackage.Literals.NAMESPACE__MEMBERSHIP);
				break;
			case SysMLPackage.ITEM_DEFINITION__VARIANT_MEMBERSHIP:
				notifyChanged(notification, eClass, SysMLPackage.Literals.NAMESPACE__MEMBERSHIP);
				break;
		}
	}

	/**
	 * Calls <code>notifyChanged</code> for each affected derived union.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param notification a description of the change.
	 * @param eClass the Ecore class of the notifier.
	 * @generated
	 */
	protected void notifyOccurrenceDefinitionChanged(Notification notification, EClass eClass) {
		switch (notification.getFeatureID(OccurrenceDefinition.class)) {
			case SysMLPackage.OCCURRENCE_DEFINITION__IMPORTED_MEMBERSHIP:
				notifyChanged(notification, eClass, SysMLPackage.Literals.NAMESPACE__MEMBERSHIP);
				break;
			case SysMLPackage.OCCURRENCE_DEFINITION__OWNED_MEMBERSHIP:
				notifyChanged(notification, eClass, SysMLPackage.Literals.NAMESPACE__MEMBERSHIP);
				break;
			case SysMLPackage.OCCURRENCE_DEFINITION__OWNED_FEATURE_MEMBERSHIP:
				notifyChanged(notification, eClass, SysMLPackage.Literals.NAMESPACE__MEMBERSHIP);
				break;
			case SysMLPackage.OCCURRENCE_DEFINITION__INHERITED_MEMBERSHIP:
				notifyChanged(notification, eClass, SysMLPackage.Literals.NAMESPACE__MEMBERSHIP);
				break;
			case SysMLPackage.OCCURRENCE_DEFINITION__VARIANT_MEMBERSHIP:
				notifyChanged(notification, eClass, SysMLPackage.Literals.NAMESPACE__MEMBERSHIP);
				break;
		}
	}

	/**
	 * Calls <code>notifyChanged</code> for each affected derived union.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param notification a description of the change.
	 * @param eClass the Ecore class of the notifier.
	 * @generated
	 */
	protected void notifyInterfaceDefinitionChanged(Notification notification, EClass eClass) {
		switch (notification.getFeatureID(InterfaceDefinition.class)) {
			case SysMLPackage.INTERFACE_DEFINITION__IMPORTED_MEMBERSHIP:
				notifyChanged(notification, eClass, SysMLPackage.Literals.NAMESPACE__MEMBERSHIP);
				break;
			case SysMLPackage.INTERFACE_DEFINITION__OWNED_MEMBERSHIP:
				notifyChanged(notification, eClass, SysMLPackage.Literals.NAMESPACE__MEMBERSHIP);
				break;
			case SysMLPackage.INTERFACE_DEFINITION__OWNED_FEATURE_MEMBERSHIP:
				notifyChanged(notification, eClass, SysMLPackage.Literals.NAMESPACE__MEMBERSHIP);
				break;
			case SysMLPackage.INTERFACE_DEFINITION__INHERITED_MEMBERSHIP:
				notifyChanged(notification, eClass, SysMLPackage.Literals.NAMESPACE__MEMBERSHIP);
				break;
			case SysMLPackage.INTERFACE_DEFINITION__VARIANT_MEMBERSHIP:
				notifyChanged(notification, eClass, SysMLPackage.Literals.NAMESPACE__MEMBERSHIP);
				break;
			case SysMLPackage.INTERFACE_DEFINITION__OWNED_RELATED_ELEMENT:
				notifyChanged(notification, eClass, SysMLPackage.Literals.RELATIONSHIP__RELATED_ELEMENT);
				break;
			case SysMLPackage.INTERFACE_DEFINITION__OWNING_RELATED_ELEMENT:
				notifyChanged(notification, eClass, SysMLPackage.Literals.RELATIONSHIP__RELATED_ELEMENT);
				break;
			case SysMLPackage.INTERFACE_DEFINITION__TARGET:
				notifyChanged(notification, eClass, SysMLPackage.Literals.RELATIONSHIP__RELATED_ELEMENT);
				break;
			case SysMLPackage.INTERFACE_DEFINITION__SOURCE:
				notifyChanged(notification, eClass, SysMLPackage.Literals.RELATIONSHIP__RELATED_ELEMENT);
				break;
			case SysMLPackage.INTERFACE_DEFINITION__SOURCE_TYPE:
				notifyChanged(notification, eClass, SysMLPackage.Literals.ASSOCIATION__RELATED_TYPE);
				break;
			case SysMLPackage.INTERFACE_DEFINITION__TARGET_TYPE:
				notifyChanged(notification, eClass, SysMLPackage.Literals.ASSOCIATION__RELATED_TYPE);
				break;
		}
	}

	/**
	 * Calls <code>notifyChanged</code> for each affected derived union.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param notification a description of the change.
	 * @param eClass the Ecore class of the notifier.
	 * @generated
	 */
	protected void notifyConnectionDefinitionChanged(Notification notification, EClass eClass) {
		switch (notification.getFeatureID(ConnectionDefinition.class)) {
			case SysMLPackage.CONNECTION_DEFINITION__IMPORTED_MEMBERSHIP:
				notifyChanged(notification, eClass, SysMLPackage.Literals.NAMESPACE__MEMBERSHIP);
				break;
			case SysMLPackage.CONNECTION_DEFINITION__OWNED_MEMBERSHIP:
				notifyChanged(notification, eClass, SysMLPackage.Literals.NAMESPACE__MEMBERSHIP);
				break;
			case SysMLPackage.CONNECTION_DEFINITION__OWNED_FEATURE_MEMBERSHIP:
				notifyChanged(notification, eClass, SysMLPackage.Literals.NAMESPACE__MEMBERSHIP);
				break;
			case SysMLPackage.CONNECTION_DEFINITION__INHERITED_MEMBERSHIP:
				notifyChanged(notification, eClass, SysMLPackage.Literals.NAMESPACE__MEMBERSHIP);
				break;
			case SysMLPackage.CONNECTION_DEFINITION__VARIANT_MEMBERSHIP:
				notifyChanged(notification, eClass, SysMLPackage.Literals.NAMESPACE__MEMBERSHIP);
				break;
			case SysMLPackage.CONNECTION_DEFINITION__OWNED_RELATED_ELEMENT:
				notifyChanged(notification, eClass, SysMLPackage.Literals.RELATIONSHIP__RELATED_ELEMENT);
				break;
			case SysMLPackage.CONNECTION_DEFINITION__OWNING_RELATED_ELEMENT:
				notifyChanged(notification, eClass, SysMLPackage.Literals.RELATIONSHIP__RELATED_ELEMENT);
				break;
			case SysMLPackage.CONNECTION_DEFINITION__TARGET:
				notifyChanged(notification, eClass, SysMLPackage.Literals.RELATIONSHIP__RELATED_ELEMENT);
				break;
			case SysMLPackage.CONNECTION_DEFINITION__SOURCE:
				notifyChanged(notification, eClass, SysMLPackage.Literals.RELATIONSHIP__RELATED_ELEMENT);
				break;
			case SysMLPackage.CONNECTION_DEFINITION__SOURCE_TYPE:
				notifyChanged(notification, eClass, SysMLPackage.Literals.ASSOCIATION__RELATED_TYPE);
				break;
			case SysMLPackage.CONNECTION_DEFINITION__TARGET_TYPE:
				notifyChanged(notification, eClass, SysMLPackage.Literals.ASSOCIATION__RELATED_TYPE);
				break;
		}
	}

	/**
	 * Calls <code>notifyChanged</code> for each affected derived union.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param notification a description of the change.
	 * @param eClass the Ecore class of the notifier.
	 * @generated
	 */
	protected void notifyAttributeUsageChanged(Notification notification, EClass eClass) {
		switch (notification.getFeatureID(AttributeUsage.class)) {
			case SysMLPackage.ATTRIBUTE_USAGE__IMPORTED_MEMBERSHIP:
				notifyChanged(notification, eClass, SysMLPackage.Literals.NAMESPACE__MEMBERSHIP);
				break;
			case SysMLPackage.ATTRIBUTE_USAGE__OWNED_MEMBERSHIP:
				notifyChanged(notification, eClass, SysMLPackage.Literals.NAMESPACE__MEMBERSHIP);
				break;
			case SysMLPackage.ATTRIBUTE_USAGE__OWNED_FEATURE_MEMBERSHIP:
				notifyChanged(notification, eClass, SysMLPackage.Literals.NAMESPACE__MEMBERSHIP);
				break;
			case SysMLPackage.ATTRIBUTE_USAGE__INHERITED_MEMBERSHIP:
				notifyChanged(notification, eClass, SysMLPackage.Literals.NAMESPACE__MEMBERSHIP);
				break;
			case SysMLPackage.ATTRIBUTE_USAGE__VARIANT_MEMBERSHIP:
				notifyChanged(notification, eClass, SysMLPackage.Literals.NAMESPACE__MEMBERSHIP);
				break;
		}
	}

	/**
	 * Calls <code>notifyChanged</code> for each affected derived union.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param notification a description of the change.
	 * @param eClass the Ecore class of the notifier.
	 * @generated
	 */
	protected void notifyViewUsageChanged(Notification notification, EClass eClass) {
		switch (notification.getFeatureID(ViewUsage.class)) {
			case SysMLPackage.VIEW_USAGE__IMPORTED_MEMBERSHIP:
				notifyChanged(notification, eClass, SysMLPackage.Literals.NAMESPACE__MEMBERSHIP);
				break;
			case SysMLPackage.VIEW_USAGE__OWNED_MEMBERSHIP:
				notifyChanged(notification, eClass, SysMLPackage.Literals.NAMESPACE__MEMBERSHIP);
				break;
			case SysMLPackage.VIEW_USAGE__OWNED_FEATURE_MEMBERSHIP:
				notifyChanged(notification, eClass, SysMLPackage.Literals.NAMESPACE__MEMBERSHIP);
				break;
			case SysMLPackage.VIEW_USAGE__INHERITED_MEMBERSHIP:
				notifyChanged(notification, eClass, SysMLPackage.Literals.NAMESPACE__MEMBERSHIP);
				break;
			case SysMLPackage.VIEW_USAGE__VARIANT_MEMBERSHIP:
				notifyChanged(notification, eClass, SysMLPackage.Literals.NAMESPACE__MEMBERSHIP);
				break;
		}
	}

	/**
	 * Calls <code>notifyChanged</code> for each affected derived union.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param notification a description of the change.
	 * @param eClass the Ecore class of the notifier.
	 * @generated
	 */
	protected void notifyViewDefinitionChanged(Notification notification, EClass eClass) {
		switch (notification.getFeatureID(ViewDefinition.class)) {
			case SysMLPackage.VIEW_DEFINITION__IMPORTED_MEMBERSHIP:
				notifyChanged(notification, eClass, SysMLPackage.Literals.NAMESPACE__MEMBERSHIP);
				break;
			case SysMLPackage.VIEW_DEFINITION__OWNED_MEMBERSHIP:
				notifyChanged(notification, eClass, SysMLPackage.Literals.NAMESPACE__MEMBERSHIP);
				break;
			case SysMLPackage.VIEW_DEFINITION__OWNED_FEATURE_MEMBERSHIP:
				notifyChanged(notification, eClass, SysMLPackage.Literals.NAMESPACE__MEMBERSHIP);
				break;
			case SysMLPackage.VIEW_DEFINITION__INHERITED_MEMBERSHIP:
				notifyChanged(notification, eClass, SysMLPackage.Literals.NAMESPACE__MEMBERSHIP);
				break;
			case SysMLPackage.VIEW_DEFINITION__VARIANT_MEMBERSHIP:
				notifyChanged(notification, eClass, SysMLPackage.Literals.NAMESPACE__MEMBERSHIP);
				break;
		}
	}

	/**
	 * Calls <code>notifyChanged</code> for each affected derived union.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param notification a description of the change.
	 * @param eClass the Ecore class of the notifier.
	 * @generated
	 */
	protected void notifyViewpointUsageChanged(Notification notification, EClass eClass) {
		switch (notification.getFeatureID(ViewpointUsage.class)) {
			case SysMLPackage.VIEWPOINT_USAGE__IMPORTED_MEMBERSHIP:
				notifyChanged(notification, eClass, SysMLPackage.Literals.NAMESPACE__MEMBERSHIP);
				break;
			case SysMLPackage.VIEWPOINT_USAGE__OWNED_MEMBERSHIP:
				notifyChanged(notification, eClass, SysMLPackage.Literals.NAMESPACE__MEMBERSHIP);
				break;
			case SysMLPackage.VIEWPOINT_USAGE__OWNED_FEATURE_MEMBERSHIP:
				notifyChanged(notification, eClass, SysMLPackage.Literals.NAMESPACE__MEMBERSHIP);
				break;
			case SysMLPackage.VIEWPOINT_USAGE__INHERITED_MEMBERSHIP:
				notifyChanged(notification, eClass, SysMLPackage.Literals.NAMESPACE__MEMBERSHIP);
				break;
			case SysMLPackage.VIEWPOINT_USAGE__VARIANT_MEMBERSHIP:
				notifyChanged(notification, eClass, SysMLPackage.Literals.NAMESPACE__MEMBERSHIP);
				break;
		}
	}

	/**
	 * Calls <code>notifyChanged</code> for each affected derived union.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param notification a description of the change.
	 * @param eClass the Ecore class of the notifier.
	 * @generated
	 */
	protected void notifyViewpointDefinitionChanged(Notification notification, EClass eClass) {
		switch (notification.getFeatureID(ViewpointDefinition.class)) {
			case SysMLPackage.VIEWPOINT_DEFINITION__IMPORTED_MEMBERSHIP:
				notifyChanged(notification, eClass, SysMLPackage.Literals.NAMESPACE__MEMBERSHIP);
				break;
			case SysMLPackage.VIEWPOINT_DEFINITION__OWNED_MEMBERSHIP:
				notifyChanged(notification, eClass, SysMLPackage.Literals.NAMESPACE__MEMBERSHIP);
				break;
			case SysMLPackage.VIEWPOINT_DEFINITION__OWNED_FEATURE_MEMBERSHIP:
				notifyChanged(notification, eClass, SysMLPackage.Literals.NAMESPACE__MEMBERSHIP);
				break;
			case SysMLPackage.VIEWPOINT_DEFINITION__INHERITED_MEMBERSHIP:
				notifyChanged(notification, eClass, SysMLPackage.Literals.NAMESPACE__MEMBERSHIP);
				break;
			case SysMLPackage.VIEWPOINT_DEFINITION__VARIANT_MEMBERSHIP:
				notifyChanged(notification, eClass, SysMLPackage.Literals.NAMESPACE__MEMBERSHIP);
				break;
		}
	}

	/**
	 * Calls <code>notifyChanged</code> for each affected derived union.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param notification a description of the change.
	 * @param eClass the Ecore class of the notifier.
	 * @generated
	 */
	protected void notifyRenderingUsageChanged(Notification notification, EClass eClass) {
		switch (notification.getFeatureID(RenderingUsage.class)) {
			case SysMLPackage.RENDERING_USAGE__IMPORTED_MEMBERSHIP:
				notifyChanged(notification, eClass, SysMLPackage.Literals.NAMESPACE__MEMBERSHIP);
				break;
			case SysMLPackage.RENDERING_USAGE__OWNED_MEMBERSHIP:
				notifyChanged(notification, eClass, SysMLPackage.Literals.NAMESPACE__MEMBERSHIP);
				break;
			case SysMLPackage.RENDERING_USAGE__OWNED_FEATURE_MEMBERSHIP:
				notifyChanged(notification, eClass, SysMLPackage.Literals.NAMESPACE__MEMBERSHIP);
				break;
			case SysMLPackage.RENDERING_USAGE__INHERITED_MEMBERSHIP:
				notifyChanged(notification, eClass, SysMLPackage.Literals.NAMESPACE__MEMBERSHIP);
				break;
			case SysMLPackage.RENDERING_USAGE__VARIANT_MEMBERSHIP:
				notifyChanged(notification, eClass, SysMLPackage.Literals.NAMESPACE__MEMBERSHIP);
				break;
		}
	}

	/**
	 * Calls <code>notifyChanged</code> for each affected derived union.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param notification a description of the change.
	 * @param eClass the Ecore class of the notifier.
	 * @generated
	 */
	protected void notifyRenderingDefinitionChanged(Notification notification, EClass eClass) {
		switch (notification.getFeatureID(RenderingDefinition.class)) {
			case SysMLPackage.RENDERING_DEFINITION__IMPORTED_MEMBERSHIP:
				notifyChanged(notification, eClass, SysMLPackage.Literals.NAMESPACE__MEMBERSHIP);
				break;
			case SysMLPackage.RENDERING_DEFINITION__OWNED_MEMBERSHIP:
				notifyChanged(notification, eClass, SysMLPackage.Literals.NAMESPACE__MEMBERSHIP);
				break;
			case SysMLPackage.RENDERING_DEFINITION__OWNED_FEATURE_MEMBERSHIP:
				notifyChanged(notification, eClass, SysMLPackage.Literals.NAMESPACE__MEMBERSHIP);
				break;
			case SysMLPackage.RENDERING_DEFINITION__INHERITED_MEMBERSHIP:
				notifyChanged(notification, eClass, SysMLPackage.Literals.NAMESPACE__MEMBERSHIP);
				break;
			case SysMLPackage.RENDERING_DEFINITION__VARIANT_MEMBERSHIP:
				notifyChanged(notification, eClass, SysMLPackage.Literals.NAMESPACE__MEMBERSHIP);
				break;
		}
	}

	/**
	 * Calls <code>notifyChanged</code> for each affected derived union.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param notification a description of the change.
	 * @param eClass the Ecore class of the notifier.
	 * @generated
	 */
	protected void notifyVerificationCaseUsageChanged(Notification notification, EClass eClass) {
		switch (notification.getFeatureID(VerificationCaseUsage.class)) {
			case SysMLPackage.VERIFICATION_CASE_USAGE__IMPORTED_MEMBERSHIP:
				notifyChanged(notification, eClass, SysMLPackage.Literals.NAMESPACE__MEMBERSHIP);
				break;
			case SysMLPackage.VERIFICATION_CASE_USAGE__OWNED_MEMBERSHIP:
				notifyChanged(notification, eClass, SysMLPackage.Literals.NAMESPACE__MEMBERSHIP);
				break;
			case SysMLPackage.VERIFICATION_CASE_USAGE__OWNED_FEATURE_MEMBERSHIP:
				notifyChanged(notification, eClass, SysMLPackage.Literals.NAMESPACE__MEMBERSHIP);
				break;
			case SysMLPackage.VERIFICATION_CASE_USAGE__INHERITED_MEMBERSHIP:
				notifyChanged(notification, eClass, SysMLPackage.Literals.NAMESPACE__MEMBERSHIP);
				break;
			case SysMLPackage.VERIFICATION_CASE_USAGE__VARIANT_MEMBERSHIP:
				notifyChanged(notification, eClass, SysMLPackage.Literals.NAMESPACE__MEMBERSHIP);
				break;
		}
	}

	/**
	 * Calls <code>notifyChanged</code> for each affected derived union.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param notification a description of the change.
	 * @param eClass the Ecore class of the notifier.
	 * @generated
	 */
	protected void notifyVerificationCaseDefinitionChanged(Notification notification, EClass eClass) {
		switch (notification.getFeatureID(VerificationCaseDefinition.class)) {
			case SysMLPackage.VERIFICATION_CASE_DEFINITION__IMPORTED_MEMBERSHIP:
				notifyChanged(notification, eClass, SysMLPackage.Literals.NAMESPACE__MEMBERSHIP);
				break;
			case SysMLPackage.VERIFICATION_CASE_DEFINITION__OWNED_MEMBERSHIP:
				notifyChanged(notification, eClass, SysMLPackage.Literals.NAMESPACE__MEMBERSHIP);
				break;
			case SysMLPackage.VERIFICATION_CASE_DEFINITION__OWNED_FEATURE_MEMBERSHIP:
				notifyChanged(notification, eClass, SysMLPackage.Literals.NAMESPACE__MEMBERSHIP);
				break;
			case SysMLPackage.VERIFICATION_CASE_DEFINITION__INHERITED_MEMBERSHIP:
				notifyChanged(notification, eClass, SysMLPackage.Literals.NAMESPACE__MEMBERSHIP);
				break;
			case SysMLPackage.VERIFICATION_CASE_DEFINITION__VARIANT_MEMBERSHIP:
				notifyChanged(notification, eClass, SysMLPackage.Literals.NAMESPACE__MEMBERSHIP);
				break;
		}
	}

	/**
	 * Calls <code>notifyChanged</code> for each affected derived union.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param notification a description of the change.
	 * @param eClass the Ecore class of the notifier.
	 * @generated
	 */
	protected void notifyEnumerationUsageChanged(Notification notification, EClass eClass) {
		switch (notification.getFeatureID(EnumerationUsage.class)) {
			case SysMLPackage.ENUMERATION_USAGE__IMPORTED_MEMBERSHIP:
				notifyChanged(notification, eClass, SysMLPackage.Literals.NAMESPACE__MEMBERSHIP);
				break;
			case SysMLPackage.ENUMERATION_USAGE__OWNED_MEMBERSHIP:
				notifyChanged(notification, eClass, SysMLPackage.Literals.NAMESPACE__MEMBERSHIP);
				break;
			case SysMLPackage.ENUMERATION_USAGE__OWNED_FEATURE_MEMBERSHIP:
				notifyChanged(notification, eClass, SysMLPackage.Literals.NAMESPACE__MEMBERSHIP);
				break;
			case SysMLPackage.ENUMERATION_USAGE__INHERITED_MEMBERSHIP:
				notifyChanged(notification, eClass, SysMLPackage.Literals.NAMESPACE__MEMBERSHIP);
				break;
			case SysMLPackage.ENUMERATION_USAGE__VARIANT_MEMBERSHIP:
				notifyChanged(notification, eClass, SysMLPackage.Literals.NAMESPACE__MEMBERSHIP);
				break;
		}
	}

	/**
	 * Calls <code>notifyChanged</code> for each affected derived union.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param notification a description of the change.
	 * @param eClass the Ecore class of the notifier.
	 * @generated
	 */
	protected void notifyEnumerationDefinitionChanged(Notification notification, EClass eClass) {
		switch (notification.getFeatureID(EnumerationDefinition.class)) {
			case SysMLPackage.ENUMERATION_DEFINITION__IMPORTED_MEMBERSHIP:
				notifyChanged(notification, eClass, SysMLPackage.Literals.NAMESPACE__MEMBERSHIP);
				break;
			case SysMLPackage.ENUMERATION_DEFINITION__OWNED_MEMBERSHIP:
				notifyChanged(notification, eClass, SysMLPackage.Literals.NAMESPACE__MEMBERSHIP);
				break;
			case SysMLPackage.ENUMERATION_DEFINITION__OWNED_FEATURE_MEMBERSHIP:
				notifyChanged(notification, eClass, SysMLPackage.Literals.NAMESPACE__MEMBERSHIP);
				break;
			case SysMLPackage.ENUMERATION_DEFINITION__INHERITED_MEMBERSHIP:
				notifyChanged(notification, eClass, SysMLPackage.Literals.NAMESPACE__MEMBERSHIP);
				break;
			case SysMLPackage.ENUMERATION_DEFINITION__VARIANT_MEMBERSHIP:
				notifyChanged(notification, eClass, SysMLPackage.Literals.NAMESPACE__MEMBERSHIP);
				break;
		}
	}

	/**
	 * Calls <code>notifyChanged</code> for each affected derived union.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param notification a description of the change.
	 * @param eClass the Ecore class of the notifier.
	 * @generated
	 */
	protected void notifyInterfaceUsageChanged(Notification notification, EClass eClass) {
		switch (notification.getFeatureID(InterfaceUsage.class)) {
			case SysMLPackage.INTERFACE_USAGE__IMPORTED_MEMBERSHIP:
				notifyChanged(notification, eClass, SysMLPackage.Literals.NAMESPACE__MEMBERSHIP);
				break;
			case SysMLPackage.INTERFACE_USAGE__OWNED_MEMBERSHIP:
				notifyChanged(notification, eClass, SysMLPackage.Literals.NAMESPACE__MEMBERSHIP);
				break;
			case SysMLPackage.INTERFACE_USAGE__OWNED_FEATURE_MEMBERSHIP:
				notifyChanged(notification, eClass, SysMLPackage.Literals.NAMESPACE__MEMBERSHIP);
				break;
			case SysMLPackage.INTERFACE_USAGE__INHERITED_MEMBERSHIP:
				notifyChanged(notification, eClass, SysMLPackage.Literals.NAMESPACE__MEMBERSHIP);
				break;
			case SysMLPackage.INTERFACE_USAGE__VARIANT_MEMBERSHIP:
				notifyChanged(notification, eClass, SysMLPackage.Literals.NAMESPACE__MEMBERSHIP);
				break;
			case SysMLPackage.INTERFACE_USAGE__OWNED_RELATED_ELEMENT:
				notifyChanged(notification, eClass, SysMLPackage.Literals.RELATIONSHIP__RELATED_ELEMENT);
				break;
			case SysMLPackage.INTERFACE_USAGE__OWNING_RELATED_ELEMENT:
				notifyChanged(notification, eClass, SysMLPackage.Literals.RELATIONSHIP__RELATED_ELEMENT);
				break;
			case SysMLPackage.INTERFACE_USAGE__TARGET:
				notifyChanged(notification, eClass, SysMLPackage.Literals.RELATIONSHIP__RELATED_ELEMENT);
				break;
			case SysMLPackage.INTERFACE_USAGE__SOURCE:
				notifyChanged(notification, eClass, SysMLPackage.Literals.RELATIONSHIP__RELATED_ELEMENT);
				break;
			case SysMLPackage.INTERFACE_USAGE__SOURCE_FEATURE:
				notifyChanged(notification, eClass, SysMLPackage.Literals.CONNECTOR__RELATED_FEATURE);
				break;
			case SysMLPackage.INTERFACE_USAGE__TARGET_FEATURE:
				notifyChanged(notification, eClass, SysMLPackage.Literals.CONNECTOR__RELATED_FEATURE);
				break;
		}
	}

	/**
	 * Calls <code>notifyChanged</code> for each affected derived union.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param notification a description of the change.
	 * @param eClass the Ecore class of the notifier.
	 * @generated
	 */
	protected void notifyConstraintDefinitionChanged(Notification notification, EClass eClass) {
		switch (notification.getFeatureID(ConstraintDefinition.class)) {
			case SysMLPackage.CONSTRAINT_DEFINITION__IMPORTED_MEMBERSHIP:
				notifyChanged(notification, eClass, SysMLPackage.Literals.NAMESPACE__MEMBERSHIP);
				break;
			case SysMLPackage.CONSTRAINT_DEFINITION__OWNED_MEMBERSHIP:
				notifyChanged(notification, eClass, SysMLPackage.Literals.NAMESPACE__MEMBERSHIP);
				break;
			case SysMLPackage.CONSTRAINT_DEFINITION__OWNED_FEATURE_MEMBERSHIP:
				notifyChanged(notification, eClass, SysMLPackage.Literals.NAMESPACE__MEMBERSHIP);
				break;
			case SysMLPackage.CONSTRAINT_DEFINITION__INHERITED_MEMBERSHIP:
				notifyChanged(notification, eClass, SysMLPackage.Literals.NAMESPACE__MEMBERSHIP);
				break;
			case SysMLPackage.CONSTRAINT_DEFINITION__VARIANT_MEMBERSHIP:
				notifyChanged(notification, eClass, SysMLPackage.Literals.NAMESPACE__MEMBERSHIP);
				break;
		}
	}

	/**
	 * Calls <code>notifyChanged</code> for each affected derived union.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param notification a description of the change.
	 * @param eClass the Ecore class of the notifier.
	 * @generated
	 */
	protected void notifyConcernUsageChanged(Notification notification, EClass eClass) {
		switch (notification.getFeatureID(ConcernUsage.class)) {
			case SysMLPackage.CONCERN_USAGE__IMPORTED_MEMBERSHIP:
				notifyChanged(notification, eClass, SysMLPackage.Literals.NAMESPACE__MEMBERSHIP);
				break;
			case SysMLPackage.CONCERN_USAGE__OWNED_MEMBERSHIP:
				notifyChanged(notification, eClass, SysMLPackage.Literals.NAMESPACE__MEMBERSHIP);
				break;
			case SysMLPackage.CONCERN_USAGE__OWNED_FEATURE_MEMBERSHIP:
				notifyChanged(notification, eClass, SysMLPackage.Literals.NAMESPACE__MEMBERSHIP);
				break;
			case SysMLPackage.CONCERN_USAGE__INHERITED_MEMBERSHIP:
				notifyChanged(notification, eClass, SysMLPackage.Literals.NAMESPACE__MEMBERSHIP);
				break;
			case SysMLPackage.CONCERN_USAGE__VARIANT_MEMBERSHIP:
				notifyChanged(notification, eClass, SysMLPackage.Literals.NAMESPACE__MEMBERSHIP);
				break;
		}
	}

	/**
	 * Calls <code>notifyChanged</code> for each affected derived union.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param notification a description of the change.
	 * @param eClass the Ecore class of the notifier.
	 * @generated
	 */
	protected void notifyConcernDefinitionChanged(Notification notification, EClass eClass) {
		switch (notification.getFeatureID(ConcernDefinition.class)) {
			case SysMLPackage.CONCERN_DEFINITION__IMPORTED_MEMBERSHIP:
				notifyChanged(notification, eClass, SysMLPackage.Literals.NAMESPACE__MEMBERSHIP);
				break;
			case SysMLPackage.CONCERN_DEFINITION__OWNED_MEMBERSHIP:
				notifyChanged(notification, eClass, SysMLPackage.Literals.NAMESPACE__MEMBERSHIP);
				break;
			case SysMLPackage.CONCERN_DEFINITION__OWNED_FEATURE_MEMBERSHIP:
				notifyChanged(notification, eClass, SysMLPackage.Literals.NAMESPACE__MEMBERSHIP);
				break;
			case SysMLPackage.CONCERN_DEFINITION__INHERITED_MEMBERSHIP:
				notifyChanged(notification, eClass, SysMLPackage.Literals.NAMESPACE__MEMBERSHIP);
				break;
			case SysMLPackage.CONCERN_DEFINITION__VARIANT_MEMBERSHIP:
				notifyChanged(notification, eClass, SysMLPackage.Literals.NAMESPACE__MEMBERSHIP);
				break;
		}
	}

	/**
	 * Calls <code>notifyChanged</code> for each affected derived union.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param notification a description of the change.
	 * @param eClass the Ecore class of the notifier.
	 * @generated
	 */
	protected void notifyCaseDefinitionChanged(Notification notification, EClass eClass) {
		switch (notification.getFeatureID(CaseDefinition.class)) {
			case SysMLPackage.CASE_DEFINITION__IMPORTED_MEMBERSHIP:
				notifyChanged(notification, eClass, SysMLPackage.Literals.NAMESPACE__MEMBERSHIP);
				break;
			case SysMLPackage.CASE_DEFINITION__OWNED_MEMBERSHIP:
				notifyChanged(notification, eClass, SysMLPackage.Literals.NAMESPACE__MEMBERSHIP);
				break;
			case SysMLPackage.CASE_DEFINITION__OWNED_FEATURE_MEMBERSHIP:
				notifyChanged(notification, eClass, SysMLPackage.Literals.NAMESPACE__MEMBERSHIP);
				break;
			case SysMLPackage.CASE_DEFINITION__INHERITED_MEMBERSHIP:
				notifyChanged(notification, eClass, SysMLPackage.Literals.NAMESPACE__MEMBERSHIP);
				break;
			case SysMLPackage.CASE_DEFINITION__VARIANT_MEMBERSHIP:
				notifyChanged(notification, eClass, SysMLPackage.Literals.NAMESPACE__MEMBERSHIP);
				break;
		}
	}

	/**
	 * Calls <code>notifyChanged</code> for each affected derived union.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param notification a description of the change.
	 * @param eClass the Ecore class of the notifier.
	 * @generated
	 */
	protected void notifyCalculationDefinitionChanged(Notification notification, EClass eClass) {
		switch (notification.getFeatureID(CalculationDefinition.class)) {
			case SysMLPackage.CALCULATION_DEFINITION__IMPORTED_MEMBERSHIP:
				notifyChanged(notification, eClass, SysMLPackage.Literals.NAMESPACE__MEMBERSHIP);
				break;
			case SysMLPackage.CALCULATION_DEFINITION__OWNED_MEMBERSHIP:
				notifyChanged(notification, eClass, SysMLPackage.Literals.NAMESPACE__MEMBERSHIP);
				break;
			case SysMLPackage.CALCULATION_DEFINITION__OWNED_FEATURE_MEMBERSHIP:
				notifyChanged(notification, eClass, SysMLPackage.Literals.NAMESPACE__MEMBERSHIP);
				break;
			case SysMLPackage.CALCULATION_DEFINITION__INHERITED_MEMBERSHIP:
				notifyChanged(notification, eClass, SysMLPackage.Literals.NAMESPACE__MEMBERSHIP);
				break;
			case SysMLPackage.CALCULATION_DEFINITION__VARIANT_MEMBERSHIP:
				notifyChanged(notification, eClass, SysMLPackage.Literals.NAMESPACE__MEMBERSHIP);
				break;
		}
	}

	/**
	 * Calls <code>notifyChanged</code> for each affected derived union.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param notification a description of the change.
	 * @param eClass the Ecore class of the notifier.
	 * @generated
	 */
	protected void notifyActionDefinitionChanged(Notification notification, EClass eClass) {
		switch (notification.getFeatureID(ActionDefinition.class)) {
			case SysMLPackage.ACTION_DEFINITION__IMPORTED_MEMBERSHIP:
				notifyChanged(notification, eClass, SysMLPackage.Literals.NAMESPACE__MEMBERSHIP);
				break;
			case SysMLPackage.ACTION_DEFINITION__OWNED_MEMBERSHIP:
				notifyChanged(notification, eClass, SysMLPackage.Literals.NAMESPACE__MEMBERSHIP);
				break;
			case SysMLPackage.ACTION_DEFINITION__OWNED_FEATURE_MEMBERSHIP:
				notifyChanged(notification, eClass, SysMLPackage.Literals.NAMESPACE__MEMBERSHIP);
				break;
			case SysMLPackage.ACTION_DEFINITION__INHERITED_MEMBERSHIP:
				notifyChanged(notification, eClass, SysMLPackage.Literals.NAMESPACE__MEMBERSHIP);
				break;
			case SysMLPackage.ACTION_DEFINITION__VARIANT_MEMBERSHIP:
				notifyChanged(notification, eClass, SysMLPackage.Literals.NAMESPACE__MEMBERSHIP);
				break;
		}
	}

	/**
	 * Calls <code>notifyChanged</code> for each affected derived union.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param notification a description of the change.
	 * @param eClass the Ecore class of the notifier.
	 * @generated
	 */
	protected void notifyCalculationUsageChanged(Notification notification, EClass eClass) {
		switch (notification.getFeatureID(CalculationUsage.class)) {
			case SysMLPackage.CALCULATION_USAGE__IMPORTED_MEMBERSHIP:
				notifyChanged(notification, eClass, SysMLPackage.Literals.NAMESPACE__MEMBERSHIP);
				break;
			case SysMLPackage.CALCULATION_USAGE__OWNED_MEMBERSHIP:
				notifyChanged(notification, eClass, SysMLPackage.Literals.NAMESPACE__MEMBERSHIP);
				break;
			case SysMLPackage.CALCULATION_USAGE__OWNED_FEATURE_MEMBERSHIP:
				notifyChanged(notification, eClass, SysMLPackage.Literals.NAMESPACE__MEMBERSHIP);
				break;
			case SysMLPackage.CALCULATION_USAGE__INHERITED_MEMBERSHIP:
				notifyChanged(notification, eClass, SysMLPackage.Literals.NAMESPACE__MEMBERSHIP);
				break;
			case SysMLPackage.CALCULATION_USAGE__VARIANT_MEMBERSHIP:
				notifyChanged(notification, eClass, SysMLPackage.Literals.NAMESPACE__MEMBERSHIP);
				break;
		}
	}

	/**
	 * Calls <code>notifyChanged</code> for each affected derived union.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param notification a description of the change.
	 * @param eClass the Ecore class of the notifier.
	 * @generated
	 */
	protected void notifyCaseUsageChanged(Notification notification, EClass eClass) {
		switch (notification.getFeatureID(CaseUsage.class)) {
			case SysMLPackage.CASE_USAGE__IMPORTED_MEMBERSHIP:
				notifyChanged(notification, eClass, SysMLPackage.Literals.NAMESPACE__MEMBERSHIP);
				break;
			case SysMLPackage.CASE_USAGE__OWNED_MEMBERSHIP:
				notifyChanged(notification, eClass, SysMLPackage.Literals.NAMESPACE__MEMBERSHIP);
				break;
			case SysMLPackage.CASE_USAGE__OWNED_FEATURE_MEMBERSHIP:
				notifyChanged(notification, eClass, SysMLPackage.Literals.NAMESPACE__MEMBERSHIP);
				break;
			case SysMLPackage.CASE_USAGE__INHERITED_MEMBERSHIP:
				notifyChanged(notification, eClass, SysMLPackage.Literals.NAMESPACE__MEMBERSHIP);
				break;
			case SysMLPackage.CASE_USAGE__VARIANT_MEMBERSHIP:
				notifyChanged(notification, eClass, SysMLPackage.Literals.NAMESPACE__MEMBERSHIP);
				break;
		}
	}

	/**
	 * Calls <code>notifyChanged</code> for each affected derived union.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param notification a description of the change.
	 * @param eClass the Ecore class of the notifier.
	 * @generated
	 */
	protected void notifyVariantMembershipChanged(Notification notification, EClass eClass) {
		switch (notification.getFeatureID(VariantMembership.class)) {
			case SysMLPackage.VARIANT_MEMBERSHIP__OWNED_RELATED_ELEMENT:
				notifyChanged(notification, eClass, SysMLPackage.Literals.RELATIONSHIP__RELATED_ELEMENT);
				break;
			case SysMLPackage.VARIANT_MEMBERSHIP__OWNING_RELATED_ELEMENT:
				notifyChanged(notification, eClass, SysMLPackage.Literals.RELATIONSHIP__RELATED_ELEMENT);
				break;
			case SysMLPackage.VARIANT_MEMBERSHIP__TARGET:
				notifyChanged(notification, eClass, SysMLPackage.Literals.RELATIONSHIP__RELATED_ELEMENT);
				break;
			case SysMLPackage.VARIANT_MEMBERSHIP__SOURCE:
				notifyChanged(notification, eClass, SysMLPackage.Literals.RELATIONSHIP__RELATED_ELEMENT);
				break;
			case SysMLPackage.VARIANT_MEMBERSHIP__MEMBERSHIP_OWNING_NAMESPACE:
				notifyChanged(notification, eClass, SysMLPackage.Literals.RELATIONSHIP__RELATED_ELEMENT);
				break;
			case SysMLPackage.VARIANT_MEMBERSHIP__OWNED_MEMBER_ELEMENT:
				notifyChanged(notification, eClass, SysMLPackage.Literals.RELATIONSHIP__RELATED_ELEMENT);
				break;
		}
	}

	/**
	 * Calls <code>notifyChanged</code> for each affected derived union.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param notification a description of the change.
	 * @param eClass the Ecore class of the notifier.
	 * @generated
	 */
	protected void notifyAnalysisCaseUsageChanged(Notification notification, EClass eClass) {
		switch (notification.getFeatureID(AnalysisCaseUsage.class)) {
			case SysMLPackage.ANALYSIS_CASE_USAGE__IMPORTED_MEMBERSHIP:
				notifyChanged(notification, eClass, SysMLPackage.Literals.NAMESPACE__MEMBERSHIP);
				break;
			case SysMLPackage.ANALYSIS_CASE_USAGE__OWNED_MEMBERSHIP:
				notifyChanged(notification, eClass, SysMLPackage.Literals.NAMESPACE__MEMBERSHIP);
				break;
			case SysMLPackage.ANALYSIS_CASE_USAGE__OWNED_FEATURE_MEMBERSHIP:
				notifyChanged(notification, eClass, SysMLPackage.Literals.NAMESPACE__MEMBERSHIP);
				break;
			case SysMLPackage.ANALYSIS_CASE_USAGE__INHERITED_MEMBERSHIP:
				notifyChanged(notification, eClass, SysMLPackage.Literals.NAMESPACE__MEMBERSHIP);
				break;
			case SysMLPackage.ANALYSIS_CASE_USAGE__VARIANT_MEMBERSHIP:
				notifyChanged(notification, eClass, SysMLPackage.Literals.NAMESPACE__MEMBERSHIP);
				break;
		}
	}

	/**
	 * Calls <code>notifyChanged</code> for each affected derived union.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param notification a description of the change.
	 * @param eClass the Ecore class of the notifier.
	 * @generated
	 */
	protected void notifyAnalysisCaseDefinitionChanged(Notification notification, EClass eClass) {
		switch (notification.getFeatureID(AnalysisCaseDefinition.class)) {
			case SysMLPackage.ANALYSIS_CASE_DEFINITION__IMPORTED_MEMBERSHIP:
				notifyChanged(notification, eClass, SysMLPackage.Literals.NAMESPACE__MEMBERSHIP);
				break;
			case SysMLPackage.ANALYSIS_CASE_DEFINITION__OWNED_MEMBERSHIP:
				notifyChanged(notification, eClass, SysMLPackage.Literals.NAMESPACE__MEMBERSHIP);
				break;
			case SysMLPackage.ANALYSIS_CASE_DEFINITION__OWNED_FEATURE_MEMBERSHIP:
				notifyChanged(notification, eClass, SysMLPackage.Literals.NAMESPACE__MEMBERSHIP);
				break;
			case SysMLPackage.ANALYSIS_CASE_DEFINITION__INHERITED_MEMBERSHIP:
				notifyChanged(notification, eClass, SysMLPackage.Literals.NAMESPACE__MEMBERSHIP);
				break;
			case SysMLPackage.ANALYSIS_CASE_DEFINITION__VARIANT_MEMBERSHIP:
				notifyChanged(notification, eClass, SysMLPackage.Literals.NAMESPACE__MEMBERSHIP);
				break;
		}
	}

	/**
	 * Calls <code>notifyChanged</code> for each affected derived union.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param notification a description of the change.
	 * @param eClass the Ecore class of the notifier.
	 * @generated
	 */
	protected void notifyReferenceUsageChanged(Notification notification, EClass eClass) {
		switch (notification.getFeatureID(ReferenceUsage.class)) {
			case SysMLPackage.REFERENCE_USAGE__IMPORTED_MEMBERSHIP:
				notifyChanged(notification, eClass, SysMLPackage.Literals.NAMESPACE__MEMBERSHIP);
				break;
			case SysMLPackage.REFERENCE_USAGE__OWNED_MEMBERSHIP:
				notifyChanged(notification, eClass, SysMLPackage.Literals.NAMESPACE__MEMBERSHIP);
				break;
			case SysMLPackage.REFERENCE_USAGE__OWNED_FEATURE_MEMBERSHIP:
				notifyChanged(notification, eClass, SysMLPackage.Literals.NAMESPACE__MEMBERSHIP);
				break;
			case SysMLPackage.REFERENCE_USAGE__INHERITED_MEMBERSHIP:
				notifyChanged(notification, eClass, SysMLPackage.Literals.NAMESPACE__MEMBERSHIP);
				break;
			case SysMLPackage.REFERENCE_USAGE__VARIANT_MEMBERSHIP:
				notifyChanged(notification, eClass, SysMLPackage.Literals.NAMESPACE__MEMBERSHIP);
				break;
		}
	}

	/**
	 * Calls <code>notifyChanged</code> for each affected derived union.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param notification a description of the change.
	 * @param eClass the Ecore class of the notifier.
	 * @generated
	 */
	protected void notifyConnectionUsageChanged(Notification notification, EClass eClass) {
		switch (notification.getFeatureID(ConnectionUsage.class)) {
			case SysMLPackage.CONNECTION_USAGE__IMPORTED_MEMBERSHIP:
				notifyChanged(notification, eClass, SysMLPackage.Literals.NAMESPACE__MEMBERSHIP);
				break;
			case SysMLPackage.CONNECTION_USAGE__OWNED_MEMBERSHIP:
				notifyChanged(notification, eClass, SysMLPackage.Literals.NAMESPACE__MEMBERSHIP);
				break;
			case SysMLPackage.CONNECTION_USAGE__OWNED_FEATURE_MEMBERSHIP:
				notifyChanged(notification, eClass, SysMLPackage.Literals.NAMESPACE__MEMBERSHIP);
				break;
			case SysMLPackage.CONNECTION_USAGE__INHERITED_MEMBERSHIP:
				notifyChanged(notification, eClass, SysMLPackage.Literals.NAMESPACE__MEMBERSHIP);
				break;
			case SysMLPackage.CONNECTION_USAGE__VARIANT_MEMBERSHIP:
				notifyChanged(notification, eClass, SysMLPackage.Literals.NAMESPACE__MEMBERSHIP);
				break;
			case SysMLPackage.CONNECTION_USAGE__OWNED_RELATED_ELEMENT:
				notifyChanged(notification, eClass, SysMLPackage.Literals.RELATIONSHIP__RELATED_ELEMENT);
				break;
			case SysMLPackage.CONNECTION_USAGE__OWNING_RELATED_ELEMENT:
				notifyChanged(notification, eClass, SysMLPackage.Literals.RELATIONSHIP__RELATED_ELEMENT);
				break;
			case SysMLPackage.CONNECTION_USAGE__TARGET:
				notifyChanged(notification, eClass, SysMLPackage.Literals.RELATIONSHIP__RELATED_ELEMENT);
				break;
			case SysMLPackage.CONNECTION_USAGE__SOURCE:
				notifyChanged(notification, eClass, SysMLPackage.Literals.RELATIONSHIP__RELATED_ELEMENT);
				break;
			case SysMLPackage.CONNECTION_USAGE__SOURCE_FEATURE:
				notifyChanged(notification, eClass, SysMLPackage.Literals.CONNECTOR__RELATED_FEATURE);
				break;
			case SysMLPackage.CONNECTION_USAGE__TARGET_FEATURE:
				notifyChanged(notification, eClass, SysMLPackage.Literals.CONNECTOR__RELATED_FEATURE);
				break;
		}
	}

	/**
	 * Calls <code>notifyChanged</code> for each affected derived union.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param notification a description of the change.
	 * @param eClass the Ecore class of the notifier.
	 * @generated
	 */
	protected void notifyPartUsageChanged(Notification notification, EClass eClass) {
		switch (notification.getFeatureID(PartUsage.class)) {
			case SysMLPackage.PART_USAGE__IMPORTED_MEMBERSHIP:
				notifyChanged(notification, eClass, SysMLPackage.Literals.NAMESPACE__MEMBERSHIP);
				break;
			case SysMLPackage.PART_USAGE__OWNED_MEMBERSHIP:
				notifyChanged(notification, eClass, SysMLPackage.Literals.NAMESPACE__MEMBERSHIP);
				break;
			case SysMLPackage.PART_USAGE__OWNED_FEATURE_MEMBERSHIP:
				notifyChanged(notification, eClass, SysMLPackage.Literals.NAMESPACE__MEMBERSHIP);
				break;
			case SysMLPackage.PART_USAGE__INHERITED_MEMBERSHIP:
				notifyChanged(notification, eClass, SysMLPackage.Literals.NAMESPACE__MEMBERSHIP);
				break;
			case SysMLPackage.PART_USAGE__VARIANT_MEMBERSHIP:
				notifyChanged(notification, eClass, SysMLPackage.Literals.NAMESPACE__MEMBERSHIP);
				break;
		}
	}

	/**
	 * Calls <code>notifyChanged</code> for each affected derived union.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param notification a description of the change.
	 * @param eClass the Ecore class of the notifier.
	 * @generated
	 */
	protected void notifyItemUsageChanged(Notification notification, EClass eClass) {
		switch (notification.getFeatureID(ItemUsage.class)) {
			case SysMLPackage.ITEM_USAGE__IMPORTED_MEMBERSHIP:
				notifyChanged(notification, eClass, SysMLPackage.Literals.NAMESPACE__MEMBERSHIP);
				break;
			case SysMLPackage.ITEM_USAGE__OWNED_MEMBERSHIP:
				notifyChanged(notification, eClass, SysMLPackage.Literals.NAMESPACE__MEMBERSHIP);
				break;
			case SysMLPackage.ITEM_USAGE__OWNED_FEATURE_MEMBERSHIP:
				notifyChanged(notification, eClass, SysMLPackage.Literals.NAMESPACE__MEMBERSHIP);
				break;
			case SysMLPackage.ITEM_USAGE__INHERITED_MEMBERSHIP:
				notifyChanged(notification, eClass, SysMLPackage.Literals.NAMESPACE__MEMBERSHIP);
				break;
			case SysMLPackage.ITEM_USAGE__VARIANT_MEMBERSHIP:
				notifyChanged(notification, eClass, SysMLPackage.Literals.NAMESPACE__MEMBERSHIP);
				break;
		}
	}

	/**
	 * Calls <code>notifyChanged</code> for each affected derived union.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param notification a description of the change.
	 * @param eClass the Ecore class of the notifier.
	 * @generated
	 */
	protected void notifyPartDefinitionChanged(Notification notification, EClass eClass) {
		switch (notification.getFeatureID(PartDefinition.class)) {
			case SysMLPackage.PART_DEFINITION__IMPORTED_MEMBERSHIP:
				notifyChanged(notification, eClass, SysMLPackage.Literals.NAMESPACE__MEMBERSHIP);
				break;
			case SysMLPackage.PART_DEFINITION__OWNED_MEMBERSHIP:
				notifyChanged(notification, eClass, SysMLPackage.Literals.NAMESPACE__MEMBERSHIP);
				break;
			case SysMLPackage.PART_DEFINITION__OWNED_FEATURE_MEMBERSHIP:
				notifyChanged(notification, eClass, SysMLPackage.Literals.NAMESPACE__MEMBERSHIP);
				break;
			case SysMLPackage.PART_DEFINITION__INHERITED_MEMBERSHIP:
				notifyChanged(notification, eClass, SysMLPackage.Literals.NAMESPACE__MEMBERSHIP);
				break;
			case SysMLPackage.PART_DEFINITION__VARIANT_MEMBERSHIP:
				notifyChanged(notification, eClass, SysMLPackage.Literals.NAMESPACE__MEMBERSHIP);
				break;
		}
	}

	/**
	 * Calls <code>notifyChanged</code> for each affected derived union.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param notification a description of the change.
	 * @param eClass the Ecore class of the notifier.
	 * @generated
	 */
	protected void notifySatisfyRequirementUsageChanged(Notification notification, EClass eClass) {
		switch (notification.getFeatureID(SatisfyRequirementUsage.class)) {
			case SysMLPackage.SATISFY_REQUIREMENT_USAGE__IMPORTED_MEMBERSHIP:
				notifyChanged(notification, eClass, SysMLPackage.Literals.NAMESPACE__MEMBERSHIP);
				break;
			case SysMLPackage.SATISFY_REQUIREMENT_USAGE__OWNED_MEMBERSHIP:
				notifyChanged(notification, eClass, SysMLPackage.Literals.NAMESPACE__MEMBERSHIP);
				break;
			case SysMLPackage.SATISFY_REQUIREMENT_USAGE__OWNED_FEATURE_MEMBERSHIP:
				notifyChanged(notification, eClass, SysMLPackage.Literals.NAMESPACE__MEMBERSHIP);
				break;
			case SysMLPackage.SATISFY_REQUIREMENT_USAGE__INHERITED_MEMBERSHIP:
				notifyChanged(notification, eClass, SysMLPackage.Literals.NAMESPACE__MEMBERSHIP);
				break;
			case SysMLPackage.SATISFY_REQUIREMENT_USAGE__VARIANT_MEMBERSHIP:
				notifyChanged(notification, eClass, SysMLPackage.Literals.NAMESPACE__MEMBERSHIP);
				break;
		}
	}

	/**
	 * Calls <code>notifyChanged</code> for each affected derived union.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param notification a description of the change.
	 * @param eClass the Ecore class of the notifier.
	 * @generated
	 */
	protected void notifyFramedConcernMembershipChanged(Notification notification, EClass eClass) {
		switch (notification.getFeatureID(FramedConcernMembership.class)) {
			case SysMLPackage.FRAMED_CONCERN_MEMBERSHIP__OWNED_RELATED_ELEMENT:
				notifyChanged(notification, eClass, SysMLPackage.Literals.RELATIONSHIP__RELATED_ELEMENT);
				break;
			case SysMLPackage.FRAMED_CONCERN_MEMBERSHIP__OWNING_RELATED_ELEMENT:
				notifyChanged(notification, eClass, SysMLPackage.Literals.RELATIONSHIP__RELATED_ELEMENT);
				break;
			case SysMLPackage.FRAMED_CONCERN_MEMBERSHIP__TARGET:
				notifyChanged(notification, eClass, SysMLPackage.Literals.RELATIONSHIP__RELATED_ELEMENT);
				break;
			case SysMLPackage.FRAMED_CONCERN_MEMBERSHIP__SOURCE:
				notifyChanged(notification, eClass, SysMLPackage.Literals.RELATIONSHIP__RELATED_ELEMENT);
				break;
			case SysMLPackage.FRAMED_CONCERN_MEMBERSHIP__MEMBERSHIP_OWNING_NAMESPACE:
				notifyChanged(notification, eClass, SysMLPackage.Literals.RELATIONSHIP__RELATED_ELEMENT);
				break;
			case SysMLPackage.FRAMED_CONCERN_MEMBERSHIP__OWNED_MEMBER_ELEMENT:
				notifyChanged(notification, eClass, SysMLPackage.Literals.RELATIONSHIP__RELATED_ELEMENT);
				break;
			case SysMLPackage.FRAMED_CONCERN_MEMBERSHIP__OWNING_FEATURE_OF_TYPE:
				notifyChanged(notification, eClass, SysMLPackage.Literals.RELATIONSHIP__RELATED_ELEMENT);
				break;
		}
	}

	/**
	 * Calls <code>notifyChanged</code> for each affected derived union.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param notification a description of the change.
	 * @param eClass the Ecore class of the notifier.
	 * @generated
	 */
	protected void notifyBindingConnectorChanged(Notification notification, EClass eClass) {
		switch (notification.getFeatureID(BindingConnector.class)) {
			case SysMLPackage.BINDING_CONNECTOR__IMPORTED_MEMBERSHIP:
				notifyChanged(notification, eClass, SysMLPackage.Literals.NAMESPACE__MEMBERSHIP);
				break;
			case SysMLPackage.BINDING_CONNECTOR__OWNED_MEMBERSHIP:
				notifyChanged(notification, eClass, SysMLPackage.Literals.NAMESPACE__MEMBERSHIP);
				break;
			case SysMLPackage.BINDING_CONNECTOR__OWNED_FEATURE_MEMBERSHIP:
				notifyChanged(notification, eClass, SysMLPackage.Literals.NAMESPACE__MEMBERSHIP);
				break;
			case SysMLPackage.BINDING_CONNECTOR__INHERITED_MEMBERSHIP:
				notifyChanged(notification, eClass, SysMLPackage.Literals.NAMESPACE__MEMBERSHIP);
				break;
			case SysMLPackage.BINDING_CONNECTOR__OWNED_RELATED_ELEMENT:
				notifyChanged(notification, eClass, SysMLPackage.Literals.RELATIONSHIP__RELATED_ELEMENT);
				break;
			case SysMLPackage.BINDING_CONNECTOR__OWNING_RELATED_ELEMENT:
				notifyChanged(notification, eClass, SysMLPackage.Literals.RELATIONSHIP__RELATED_ELEMENT);
				break;
			case SysMLPackage.BINDING_CONNECTOR__TARGET:
				notifyChanged(notification, eClass, SysMLPackage.Literals.RELATIONSHIP__RELATED_ELEMENT);
				break;
			case SysMLPackage.BINDING_CONNECTOR__SOURCE:
				notifyChanged(notification, eClass, SysMLPackage.Literals.RELATIONSHIP__RELATED_ELEMENT);
				break;
			case SysMLPackage.BINDING_CONNECTOR__SOURCE_FEATURE:
				notifyChanged(notification, eClass, SysMLPackage.Literals.CONNECTOR__RELATED_FEATURE);
				break;
			case SysMLPackage.BINDING_CONNECTOR__TARGET_FEATURE:
				notifyChanged(notification, eClass, SysMLPackage.Literals.CONNECTOR__RELATED_FEATURE);
				break;
		}
	}

	/**
	 * Calls <code>notifyChanged</code> for each affected derived union.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param notification a description of the change.
	 * @param eClass the Ecore class of the notifier.
	 * @generated
	 */
	protected void notifySuccessionFlowConnectionUsageChanged(Notification notification, EClass eClass) {
		switch (notification.getFeatureID(SuccessionFlowConnectionUsage.class)) {
			case SysMLPackage.SUCCESSION_FLOW_CONNECTION_USAGE__IMPORTED_MEMBERSHIP:
				notifyChanged(notification, eClass, SysMLPackage.Literals.NAMESPACE__MEMBERSHIP);
				break;
			case SysMLPackage.SUCCESSION_FLOW_CONNECTION_USAGE__OWNED_MEMBERSHIP:
				notifyChanged(notification, eClass, SysMLPackage.Literals.NAMESPACE__MEMBERSHIP);
				break;
			case SysMLPackage.SUCCESSION_FLOW_CONNECTION_USAGE__OWNED_FEATURE_MEMBERSHIP:
				notifyChanged(notification, eClass, SysMLPackage.Literals.NAMESPACE__MEMBERSHIP);
				break;
			case SysMLPackage.SUCCESSION_FLOW_CONNECTION_USAGE__INHERITED_MEMBERSHIP:
				notifyChanged(notification, eClass, SysMLPackage.Literals.NAMESPACE__MEMBERSHIP);
				break;
			case SysMLPackage.SUCCESSION_FLOW_CONNECTION_USAGE__VARIANT_MEMBERSHIP:
				notifyChanged(notification, eClass, SysMLPackage.Literals.NAMESPACE__MEMBERSHIP);
				break;
			case SysMLPackage.SUCCESSION_FLOW_CONNECTION_USAGE__OWNED_RELATED_ELEMENT:
				notifyChanged(notification, eClass, SysMLPackage.Literals.RELATIONSHIP__RELATED_ELEMENT);
				break;
			case SysMLPackage.SUCCESSION_FLOW_CONNECTION_USAGE__OWNING_RELATED_ELEMENT:
				notifyChanged(notification, eClass, SysMLPackage.Literals.RELATIONSHIP__RELATED_ELEMENT);
				break;
			case SysMLPackage.SUCCESSION_FLOW_CONNECTION_USAGE__TARGET:
				notifyChanged(notification, eClass, SysMLPackage.Literals.RELATIONSHIP__RELATED_ELEMENT);
				break;
			case SysMLPackage.SUCCESSION_FLOW_CONNECTION_USAGE__SOURCE:
				notifyChanged(notification, eClass, SysMLPackage.Literals.RELATIONSHIP__RELATED_ELEMENT);
				break;
			case SysMLPackage.SUCCESSION_FLOW_CONNECTION_USAGE__SOURCE_FEATURE:
				notifyChanged(notification, eClass, SysMLPackage.Literals.CONNECTOR__RELATED_FEATURE);
				break;
			case SysMLPackage.SUCCESSION_FLOW_CONNECTION_USAGE__TARGET_FEATURE:
				notifyChanged(notification, eClass, SysMLPackage.Literals.CONNECTOR__RELATED_FEATURE);
				break;
		}
	}

	/**
	 * Calls <code>notifyChanged</code> for each affected derived union.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param notification a description of the change.
	 * @param eClass the Ecore class of the notifier.
	 * @generated
	 */
	protected void notifyMultiplicityRangeChanged(Notification notification, EClass eClass) {
		switch (notification.getFeatureID(MultiplicityRange.class)) {
			case SysMLPackage.MULTIPLICITY_RANGE__IMPORTED_MEMBERSHIP:
				notifyChanged(notification, eClass, SysMLPackage.Literals.NAMESPACE__MEMBERSHIP);
				break;
			case SysMLPackage.MULTIPLICITY_RANGE__OWNED_MEMBERSHIP:
				notifyChanged(notification, eClass, SysMLPackage.Literals.NAMESPACE__MEMBERSHIP);
				break;
			case SysMLPackage.MULTIPLICITY_RANGE__OWNED_FEATURE_MEMBERSHIP:
				notifyChanged(notification, eClass, SysMLPackage.Literals.NAMESPACE__MEMBERSHIP);
				break;
			case SysMLPackage.MULTIPLICITY_RANGE__INHERITED_MEMBERSHIP:
				notifyChanged(notification, eClass, SysMLPackage.Literals.NAMESPACE__MEMBERSHIP);
				break;
			case SysMLPackage.MULTIPLICITY_RANGE__LOWER_BOUND:
				notifyChanged(notification, eClass, SysMLPackage.Literals.MULTIPLICITY_RANGE__BOUND);
				break;
			case SysMLPackage.MULTIPLICITY_RANGE__UPPER_BOUND:
				notifyChanged(notification, eClass, SysMLPackage.Literals.MULTIPLICITY_RANGE__BOUND);
				break;
		}
	}

	/**
	 * Calls <code>notifyChanged</code> for each affected derived union.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param notification a description of the change.
	 * @param eClass the Ecore class of the notifier.
	 * @generated
	 */
	protected void notifyAnnotatingFeatureChanged(Notification notification, EClass eClass) {
		switch (notification.getFeatureID(AnnotatingFeature.class)) {
			case SysMLPackage.ANNOTATING_FEATURE__IMPORTED_MEMBERSHIP:
				notifyChanged(notification, eClass, SysMLPackage.Literals.NAMESPACE__MEMBERSHIP);
				break;
			case SysMLPackage.ANNOTATING_FEATURE__OWNED_MEMBERSHIP:
				notifyChanged(notification, eClass, SysMLPackage.Literals.NAMESPACE__MEMBERSHIP);
				break;
			case SysMLPackage.ANNOTATING_FEATURE__OWNED_FEATURE_MEMBERSHIP:
				notifyChanged(notification, eClass, SysMLPackage.Literals.NAMESPACE__MEMBERSHIP);
				break;
			case SysMLPackage.ANNOTATING_FEATURE__INHERITED_MEMBERSHIP:
				notifyChanged(notification, eClass, SysMLPackage.Literals.NAMESPACE__MEMBERSHIP);
				break;
		}
	}

	/**
	 * Calls <code>notifyChanged</code> for each affected derived union.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param notification a description of the change.
	 * @param eClass the Ecore class of the notifier.
	 * @generated
	 */
	protected void notifyMetadataFeatureChanged(Notification notification, EClass eClass) {
		switch (notification.getFeatureID(MetadataFeature.class)) {
			case SysMLPackage.METADATA_FEATURE__IMPORTED_MEMBERSHIP:
				notifyChanged(notification, eClass, SysMLPackage.Literals.NAMESPACE__MEMBERSHIP);
				break;
			case SysMLPackage.METADATA_FEATURE__OWNED_MEMBERSHIP:
				notifyChanged(notification, eClass, SysMLPackage.Literals.NAMESPACE__MEMBERSHIP);
				break;
			case SysMLPackage.METADATA_FEATURE__OWNED_FEATURE_MEMBERSHIP:
				notifyChanged(notification, eClass, SysMLPackage.Literals.NAMESPACE__MEMBERSHIP);
				break;
			case SysMLPackage.METADATA_FEATURE__INHERITED_MEMBERSHIP:
				notifyChanged(notification, eClass, SysMLPackage.Literals.NAMESPACE__MEMBERSHIP);
				break;
		}
	}

	/**
	 * Calls <code>notifyChanged</code> for each affected derived union.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param notification a description of the change.
	 * @param eClass the Ecore class of the notifier.
	 * @generated
	 */
	protected void notifyMetadataFeatureValueChanged(Notification notification, EClass eClass) {
		switch (notification.getFeatureID(MetadataFeatureValue.class)) {
			case SysMLPackage.METADATA_FEATURE_VALUE__OWNED_RELATED_ELEMENT:
				notifyChanged(notification, eClass, SysMLPackage.Literals.RELATIONSHIP__RELATED_ELEMENT);
				break;
			case SysMLPackage.METADATA_FEATURE_VALUE__OWNING_RELATED_ELEMENT:
				notifyChanged(notification, eClass, SysMLPackage.Literals.RELATIONSHIP__RELATED_ELEMENT);
				break;
			case SysMLPackage.METADATA_FEATURE_VALUE__TARGET:
				notifyChanged(notification, eClass, SysMLPackage.Literals.RELATIONSHIP__RELATED_ELEMENT);
				break;
			case SysMLPackage.METADATA_FEATURE_VALUE__SOURCE:
				notifyChanged(notification, eClass, SysMLPackage.Literals.RELATIONSHIP__RELATED_ELEMENT);
				break;
			case SysMLPackage.METADATA_FEATURE_VALUE__MEMBERSHIP_OWNING_NAMESPACE:
				notifyChanged(notification, eClass, SysMLPackage.Literals.RELATIONSHIP__RELATED_ELEMENT);
				break;
			case SysMLPackage.METADATA_FEATURE_VALUE__OWNED_MEMBER_ELEMENT:
				notifyChanged(notification, eClass, SysMLPackage.Literals.RELATIONSHIP__RELATED_ELEMENT);
				break;
			case SysMLPackage.METADATA_FEATURE_VALUE__FEATURE_WITH_VALUE:
				notifyChanged(notification, eClass, SysMLPackage.Literals.RELATIONSHIP__RELATED_ELEMENT);
				break;
		}
	}

	/**
	 * Calls <code>notifyChanged</code> for each affected derived union.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param notification a description of the change.
	 * @param eClass the Ecore class of the notifier.
	 * @generated
	 */
	protected void notifySuccessionChanged(Notification notification, EClass eClass) {
		switch (notification.getFeatureID(Succession.class)) {
			case SysMLPackage.SUCCESSION__IMPORTED_MEMBERSHIP:
				notifyChanged(notification, eClass, SysMLPackage.Literals.NAMESPACE__MEMBERSHIP);
				break;
			case SysMLPackage.SUCCESSION__OWNED_MEMBERSHIP:
				notifyChanged(notification, eClass, SysMLPackage.Literals.NAMESPACE__MEMBERSHIP);
				break;
			case SysMLPackage.SUCCESSION__OWNED_FEATURE_MEMBERSHIP:
				notifyChanged(notification, eClass, SysMLPackage.Literals.NAMESPACE__MEMBERSHIP);
				break;
			case SysMLPackage.SUCCESSION__INHERITED_MEMBERSHIP:
				notifyChanged(notification, eClass, SysMLPackage.Literals.NAMESPACE__MEMBERSHIP);
				break;
			case SysMLPackage.SUCCESSION__OWNED_RELATED_ELEMENT:
				notifyChanged(notification, eClass, SysMLPackage.Literals.RELATIONSHIP__RELATED_ELEMENT);
				break;
			case SysMLPackage.SUCCESSION__OWNING_RELATED_ELEMENT:
				notifyChanged(notification, eClass, SysMLPackage.Literals.RELATIONSHIP__RELATED_ELEMENT);
				break;
			case SysMLPackage.SUCCESSION__TARGET:
				notifyChanged(notification, eClass, SysMLPackage.Literals.RELATIONSHIP__RELATED_ELEMENT);
				break;
			case SysMLPackage.SUCCESSION__SOURCE:
				notifyChanged(notification, eClass, SysMLPackage.Literals.RELATIONSHIP__RELATED_ELEMENT);
				break;
			case SysMLPackage.SUCCESSION__SOURCE_FEATURE:
				notifyChanged(notification, eClass, SysMLPackage.Literals.CONNECTOR__RELATED_FEATURE);
				break;
			case SysMLPackage.SUCCESSION__TARGET_FEATURE:
				notifyChanged(notification, eClass, SysMLPackage.Literals.CONNECTOR__RELATED_FEATURE);
				break;
		}
	}

	/**
	 * Calls <code>notifyChanged</code> for each affected derived union.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param notification a description of the change.
	 * @param eClass the Ecore class of the notifier.
	 * @generated
	 */
	protected void notifyAnnotationChanged(Notification notification, EClass eClass) {
		switch (notification.getFeatureID(Annotation.class)) {
			case SysMLPackage.ANNOTATION__OWNED_RELATED_ELEMENT:
				notifyChanged(notification, eClass, SysMLPackage.Literals.RELATIONSHIP__RELATED_ELEMENT);
				break;
			case SysMLPackage.ANNOTATION__OWNING_RELATED_ELEMENT:
				notifyChanged(notification, eClass, SysMLPackage.Literals.RELATIONSHIP__RELATED_ELEMENT);
				break;
			case SysMLPackage.ANNOTATION__TARGET:
				notifyChanged(notification, eClass, SysMLPackage.Literals.RELATIONSHIP__RELATED_ELEMENT);
				break;
			case SysMLPackage.ANNOTATION__SOURCE:
				notifyChanged(notification, eClass, SysMLPackage.Literals.RELATIONSHIP__RELATED_ELEMENT);
				break;
		}
	}

	/**
	 * Calls <code>notifyChanged</code> for each affected derived union.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param notification a description of the change.
	 * @param eClass the Ecore class of the notifier.
	 * @generated
	 */
	protected void notifyInteractionChanged(Notification notification, EClass eClass) {
		switch (notification.getFeatureID(Interaction.class)) {
			case SysMLPackage.INTERACTION__IMPORTED_MEMBERSHIP:
				notifyChanged(notification, eClass, SysMLPackage.Literals.NAMESPACE__MEMBERSHIP);
				break;
			case SysMLPackage.INTERACTION__OWNED_MEMBERSHIP:
				notifyChanged(notification, eClass, SysMLPackage.Literals.NAMESPACE__MEMBERSHIP);
				break;
			case SysMLPackage.INTERACTION__OWNED_FEATURE_MEMBERSHIP:
				notifyChanged(notification, eClass, SysMLPackage.Literals.NAMESPACE__MEMBERSHIP);
				break;
			case SysMLPackage.INTERACTION__INHERITED_MEMBERSHIP:
				notifyChanged(notification, eClass, SysMLPackage.Literals.NAMESPACE__MEMBERSHIP);
				break;
			case SysMLPackage.INTERACTION__OWNED_RELATED_ELEMENT:
				notifyChanged(notification, eClass, SysMLPackage.Literals.RELATIONSHIP__RELATED_ELEMENT);
				break;
			case SysMLPackage.INTERACTION__OWNING_RELATED_ELEMENT:
				notifyChanged(notification, eClass, SysMLPackage.Literals.RELATIONSHIP__RELATED_ELEMENT);
				break;
			case SysMLPackage.INTERACTION__TARGET:
				notifyChanged(notification, eClass, SysMLPackage.Literals.RELATIONSHIP__RELATED_ELEMENT);
				break;
			case SysMLPackage.INTERACTION__SOURCE:
				notifyChanged(notification, eClass, SysMLPackage.Literals.RELATIONSHIP__RELATED_ELEMENT);
				break;
			case SysMLPackage.INTERACTION__SOURCE_TYPE:
				notifyChanged(notification, eClass, SysMLPackage.Literals.ASSOCIATION__RELATED_TYPE);
				break;
			case SysMLPackage.INTERACTION__TARGET_TYPE:
				notifyChanged(notification, eClass, SysMLPackage.Literals.ASSOCIATION__RELATED_TYPE);
				break;
		}
	}

	/**
	 * Calls <code>notifyChanged</code> for each affected derived union.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param notification a description of the change.
	 * @param eClass the Ecore class of the notifier.
	 * @generated
	 */
	protected void notifyLifeClassChanged(Notification notification, EClass eClass) {
		switch (notification.getFeatureID(LifeClass.class)) {
			case SysMLPackage.LIFE_CLASS__IMPORTED_MEMBERSHIP:
				notifyChanged(notification, eClass, SysMLPackage.Literals.NAMESPACE__MEMBERSHIP);
				break;
			case SysMLPackage.LIFE_CLASS__OWNED_MEMBERSHIP:
				notifyChanged(notification, eClass, SysMLPackage.Literals.NAMESPACE__MEMBERSHIP);
				break;
			case SysMLPackage.LIFE_CLASS__OWNED_FEATURE_MEMBERSHIP:
				notifyChanged(notification, eClass, SysMLPackage.Literals.NAMESPACE__MEMBERSHIP);
				break;
			case SysMLPackage.LIFE_CLASS__INHERITED_MEMBERSHIP:
				notifyChanged(notification, eClass, SysMLPackage.Literals.NAMESPACE__MEMBERSHIP);
				break;
		}
	}

	/**
	 * Calls <code>notifyChanged</code> for each affected derived union.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param notification a description of the change.
	 * @param eClass the Ecore class of the notifier.
	 * @generated
	 */
	protected void notifyDependencyChanged(Notification notification, EClass eClass) {
		switch (notification.getFeatureID(Dependency.class)) {
			case SysMLPackage.DEPENDENCY__OWNED_RELATED_ELEMENT:
				notifyChanged(notification, eClass, SysMLPackage.Literals.RELATIONSHIP__RELATED_ELEMENT);
				break;
			case SysMLPackage.DEPENDENCY__OWNING_RELATED_ELEMENT:
				notifyChanged(notification, eClass, SysMLPackage.Literals.RELATIONSHIP__RELATED_ELEMENT);
				break;
			case SysMLPackage.DEPENDENCY__TARGET:
				notifyChanged(notification, eClass, SysMLPackage.Literals.RELATIONSHIP__RELATED_ELEMENT);
				break;
			case SysMLPackage.DEPENDENCY__SOURCE:
				notifyChanged(notification, eClass, SysMLPackage.Literals.RELATIONSHIP__RELATED_ELEMENT);
				break;
		}
	}

	/**
	 * Calls <code>notifyChanged</code> for each affected derived union.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param notification a description of the change.
	 * @param eClass the Ecore class of the notifier.
	 * @generated
	 */
	protected void notifyRequirementConstraintMembershipChanged(Notification notification, EClass eClass) {
		switch (notification.getFeatureID(RequirementConstraintMembership.class)) {
			case SysMLPackage.REQUIREMENT_CONSTRAINT_MEMBERSHIP__OWNED_RELATED_ELEMENT:
				notifyChanged(notification, eClass, SysMLPackage.Literals.RELATIONSHIP__RELATED_ELEMENT);
				break;
			case SysMLPackage.REQUIREMENT_CONSTRAINT_MEMBERSHIP__OWNING_RELATED_ELEMENT:
				notifyChanged(notification, eClass, SysMLPackage.Literals.RELATIONSHIP__RELATED_ELEMENT);
				break;
			case SysMLPackage.REQUIREMENT_CONSTRAINT_MEMBERSHIP__TARGET:
				notifyChanged(notification, eClass, SysMLPackage.Literals.RELATIONSHIP__RELATED_ELEMENT);
				break;
			case SysMLPackage.REQUIREMENT_CONSTRAINT_MEMBERSHIP__SOURCE:
				notifyChanged(notification, eClass, SysMLPackage.Literals.RELATIONSHIP__RELATED_ELEMENT);
				break;
			case SysMLPackage.REQUIREMENT_CONSTRAINT_MEMBERSHIP__MEMBERSHIP_OWNING_NAMESPACE:
				notifyChanged(notification, eClass, SysMLPackage.Literals.RELATIONSHIP__RELATED_ELEMENT);
				break;
			case SysMLPackage.REQUIREMENT_CONSTRAINT_MEMBERSHIP__OWNED_MEMBER_ELEMENT:
				notifyChanged(notification, eClass, SysMLPackage.Literals.RELATIONSHIP__RELATED_ELEMENT);
				break;
			case SysMLPackage.REQUIREMENT_CONSTRAINT_MEMBERSHIP__OWNING_FEATURE_OF_TYPE:
				notifyChanged(notification, eClass, SysMLPackage.Literals.RELATIONSHIP__RELATED_ELEMENT);
				break;
		}
	}

	/**
	 * Calls <code>notifyChanged</code> for each affected derived union.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param notification a description of the change.
	 * @param eClass the Ecore class of the notifier.
	 * @generated
	 */
	protected void notifyLiteralBooleanChanged(Notification notification, EClass eClass) {
		switch (notification.getFeatureID(LiteralBoolean.class)) {
			case SysMLPackage.LITERAL_BOOLEAN__IMPORTED_MEMBERSHIP:
				notifyChanged(notification, eClass, SysMLPackage.Literals.NAMESPACE__MEMBERSHIP);
				break;
			case SysMLPackage.LITERAL_BOOLEAN__OWNED_MEMBERSHIP:
				notifyChanged(notification, eClass, SysMLPackage.Literals.NAMESPACE__MEMBERSHIP);
				break;
			case SysMLPackage.LITERAL_BOOLEAN__OWNED_FEATURE_MEMBERSHIP:
				notifyChanged(notification, eClass, SysMLPackage.Literals.NAMESPACE__MEMBERSHIP);
				break;
			case SysMLPackage.LITERAL_BOOLEAN__INHERITED_MEMBERSHIP:
				notifyChanged(notification, eClass, SysMLPackage.Literals.NAMESPACE__MEMBERSHIP);
				break;
		}
	}

	/**
	 * Calls <code>notifyChanged</code> for each affected derived union.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param notification a description of the change.
	 * @param eClass the Ecore class of the notifier.
	 * @generated
	 */
	protected void notifyInvocationExpressionChanged(Notification notification, EClass eClass) {
		switch (notification.getFeatureID(InvocationExpression.class)) {
			case SysMLPackage.INVOCATION_EXPRESSION__IMPORTED_MEMBERSHIP:
				notifyChanged(notification, eClass, SysMLPackage.Literals.NAMESPACE__MEMBERSHIP);
				break;
			case SysMLPackage.INVOCATION_EXPRESSION__OWNED_MEMBERSHIP:
				notifyChanged(notification, eClass, SysMLPackage.Literals.NAMESPACE__MEMBERSHIP);
				break;
			case SysMLPackage.INVOCATION_EXPRESSION__OWNED_FEATURE_MEMBERSHIP:
				notifyChanged(notification, eClass, SysMLPackage.Literals.NAMESPACE__MEMBERSHIP);
				break;
			case SysMLPackage.INVOCATION_EXPRESSION__INHERITED_MEMBERSHIP:
				notifyChanged(notification, eClass, SysMLPackage.Literals.NAMESPACE__MEMBERSHIP);
				break;
		}
	}

	/**
	 * Calls <code>notifyChanged</code> for each affected derived union.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param notification a description of the change.
	 * @param eClass the Ecore class of the notifier.
	 * @generated
	 */
	protected void notifyPathSelectExpressionChanged(Notification notification, EClass eClass) {
		switch (notification.getFeatureID(PathSelectExpression.class)) {
			case SysMLPackage.PATH_SELECT_EXPRESSION__IMPORTED_MEMBERSHIP:
				notifyChanged(notification, eClass, SysMLPackage.Literals.NAMESPACE__MEMBERSHIP);
				break;
			case SysMLPackage.PATH_SELECT_EXPRESSION__OWNED_MEMBERSHIP:
				notifyChanged(notification, eClass, SysMLPackage.Literals.NAMESPACE__MEMBERSHIP);
				break;
			case SysMLPackage.PATH_SELECT_EXPRESSION__OWNED_FEATURE_MEMBERSHIP:
				notifyChanged(notification, eClass, SysMLPackage.Literals.NAMESPACE__MEMBERSHIP);
				break;
			case SysMLPackage.PATH_SELECT_EXPRESSION__INHERITED_MEMBERSHIP:
				notifyChanged(notification, eClass, SysMLPackage.Literals.NAMESPACE__MEMBERSHIP);
				break;
		}
	}

	/**
	 * Calls <code>notifyChanged</code> for each affected derived union.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param notification a description of the change.
	 * @param eClass the Ecore class of the notifier.
	 * @generated
	 */
	protected void notifyLiteralInfinityChanged(Notification notification, EClass eClass) {
		switch (notification.getFeatureID(LiteralInfinity.class)) {
			case SysMLPackage.LITERAL_INFINITY__IMPORTED_MEMBERSHIP:
				notifyChanged(notification, eClass, SysMLPackage.Literals.NAMESPACE__MEMBERSHIP);
				break;
			case SysMLPackage.LITERAL_INFINITY__OWNED_MEMBERSHIP:
				notifyChanged(notification, eClass, SysMLPackage.Literals.NAMESPACE__MEMBERSHIP);
				break;
			case SysMLPackage.LITERAL_INFINITY__OWNED_FEATURE_MEMBERSHIP:
				notifyChanged(notification, eClass, SysMLPackage.Literals.NAMESPACE__MEMBERSHIP);
				break;
			case SysMLPackage.LITERAL_INFINITY__INHERITED_MEMBERSHIP:
				notifyChanged(notification, eClass, SysMLPackage.Literals.NAMESPACE__MEMBERSHIP);
				break;
		}
	}

	/**
	 * Calls <code>notifyChanged</code> for each affected derived union.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param notification a description of the change.
	 * @param eClass the Ecore class of the notifier.
	 * @generated
	 */
	protected void notifyPathStepExpressionChanged(Notification notification, EClass eClass) {
		switch (notification.getFeatureID(PathStepExpression.class)) {
			case SysMLPackage.PATH_STEP_EXPRESSION__IMPORTED_MEMBERSHIP:
				notifyChanged(notification, eClass, SysMLPackage.Literals.NAMESPACE__MEMBERSHIP);
				break;
			case SysMLPackage.PATH_STEP_EXPRESSION__OWNED_MEMBERSHIP:
				notifyChanged(notification, eClass, SysMLPackage.Literals.NAMESPACE__MEMBERSHIP);
				break;
			case SysMLPackage.PATH_STEP_EXPRESSION__OWNED_FEATURE_MEMBERSHIP:
				notifyChanged(notification, eClass, SysMLPackage.Literals.NAMESPACE__MEMBERSHIP);
				break;
			case SysMLPackage.PATH_STEP_EXPRESSION__INHERITED_MEMBERSHIP:
				notifyChanged(notification, eClass, SysMLPackage.Literals.NAMESPACE__MEMBERSHIP);
				break;
		}
	}

	/**
	 * Calls <code>notifyChanged</code> for each affected derived union.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param notification a description of the change.
	 * @param eClass the Ecore class of the notifier.
	 * @generated
	 */
	protected void notifyParameterMembershipChanged(Notification notification, EClass eClass) {
		switch (notification.getFeatureID(ParameterMembership.class)) {
			case SysMLPackage.PARAMETER_MEMBERSHIP__OWNED_RELATED_ELEMENT:
				notifyChanged(notification, eClass, SysMLPackage.Literals.RELATIONSHIP__RELATED_ELEMENT);
				break;
			case SysMLPackage.PARAMETER_MEMBERSHIP__OWNING_RELATED_ELEMENT:
				notifyChanged(notification, eClass, SysMLPackage.Literals.RELATIONSHIP__RELATED_ELEMENT);
				break;
			case SysMLPackage.PARAMETER_MEMBERSHIP__TARGET:
				notifyChanged(notification, eClass, SysMLPackage.Literals.RELATIONSHIP__RELATED_ELEMENT);
				break;
			case SysMLPackage.PARAMETER_MEMBERSHIP__SOURCE:
				notifyChanged(notification, eClass, SysMLPackage.Literals.RELATIONSHIP__RELATED_ELEMENT);
				break;
			case SysMLPackage.PARAMETER_MEMBERSHIP__MEMBERSHIP_OWNING_NAMESPACE:
				notifyChanged(notification, eClass, SysMLPackage.Literals.RELATIONSHIP__RELATED_ELEMENT);
				break;
			case SysMLPackage.PARAMETER_MEMBERSHIP__OWNED_MEMBER_ELEMENT:
				notifyChanged(notification, eClass, SysMLPackage.Literals.RELATIONSHIP__RELATED_ELEMENT);
				break;
			case SysMLPackage.PARAMETER_MEMBERSHIP__OWNING_FEATURE_OF_TYPE:
				notifyChanged(notification, eClass, SysMLPackage.Literals.RELATIONSHIP__RELATED_ELEMENT);
				break;
		}
	}

	/**
	 * Calls <code>notifyChanged</code> for each affected derived union.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param notification a description of the change.
	 * @param eClass the Ecore class of the notifier.
	 * @generated
	 */
	protected void notifyStakeholderMembershipChanged(Notification notification, EClass eClass) {
		switch (notification.getFeatureID(StakeholderMembership.class)) {
			case SysMLPackage.STAKEHOLDER_MEMBERSHIP__OWNED_RELATED_ELEMENT:
				notifyChanged(notification, eClass, SysMLPackage.Literals.RELATIONSHIP__RELATED_ELEMENT);
				break;
			case SysMLPackage.STAKEHOLDER_MEMBERSHIP__OWNING_RELATED_ELEMENT:
				notifyChanged(notification, eClass, SysMLPackage.Literals.RELATIONSHIP__RELATED_ELEMENT);
				break;
			case SysMLPackage.STAKEHOLDER_MEMBERSHIP__TARGET:
				notifyChanged(notification, eClass, SysMLPackage.Literals.RELATIONSHIP__RELATED_ELEMENT);
				break;
			case SysMLPackage.STAKEHOLDER_MEMBERSHIP__SOURCE:
				notifyChanged(notification, eClass, SysMLPackage.Literals.RELATIONSHIP__RELATED_ELEMENT);
				break;
			case SysMLPackage.STAKEHOLDER_MEMBERSHIP__MEMBERSHIP_OWNING_NAMESPACE:
				notifyChanged(notification, eClass, SysMLPackage.Literals.RELATIONSHIP__RELATED_ELEMENT);
				break;
			case SysMLPackage.STAKEHOLDER_MEMBERSHIP__OWNED_MEMBER_ELEMENT:
				notifyChanged(notification, eClass, SysMLPackage.Literals.RELATIONSHIP__RELATED_ELEMENT);
				break;
			case SysMLPackage.STAKEHOLDER_MEMBERSHIP__OWNING_FEATURE_OF_TYPE:
				notifyChanged(notification, eClass, SysMLPackage.Literals.RELATIONSHIP__RELATED_ELEMENT);
				break;
		}
	}

	/**
	 * Calls <code>notifyChanged</code> for each affected derived union.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param notification a description of the change.
	 * @param eClass the Ecore class of the notifier.
	 * @generated
	 */
	protected void notifyActorMembershipChanged(Notification notification, EClass eClass) {
		switch (notification.getFeatureID(ActorMembership.class)) {
			case SysMLPackage.ACTOR_MEMBERSHIP__OWNED_RELATED_ELEMENT:
				notifyChanged(notification, eClass, SysMLPackage.Literals.RELATIONSHIP__RELATED_ELEMENT);
				break;
			case SysMLPackage.ACTOR_MEMBERSHIP__OWNING_RELATED_ELEMENT:
				notifyChanged(notification, eClass, SysMLPackage.Literals.RELATIONSHIP__RELATED_ELEMENT);
				break;
			case SysMLPackage.ACTOR_MEMBERSHIP__TARGET:
				notifyChanged(notification, eClass, SysMLPackage.Literals.RELATIONSHIP__RELATED_ELEMENT);
				break;
			case SysMLPackage.ACTOR_MEMBERSHIP__SOURCE:
				notifyChanged(notification, eClass, SysMLPackage.Literals.RELATIONSHIP__RELATED_ELEMENT);
				break;
			case SysMLPackage.ACTOR_MEMBERSHIP__MEMBERSHIP_OWNING_NAMESPACE:
				notifyChanged(notification, eClass, SysMLPackage.Literals.RELATIONSHIP__RELATED_ELEMENT);
				break;
			case SysMLPackage.ACTOR_MEMBERSHIP__OWNED_MEMBER_ELEMENT:
				notifyChanged(notification, eClass, SysMLPackage.Literals.RELATIONSHIP__RELATED_ELEMENT);
				break;
			case SysMLPackage.ACTOR_MEMBERSHIP__OWNING_FEATURE_OF_TYPE:
				notifyChanged(notification, eClass, SysMLPackage.Literals.RELATIONSHIP__RELATED_ELEMENT);
				break;
		}
	}

	/**
	 * Calls <code>notifyChanged</code> for each affected derived union.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param notification a description of the change.
	 * @param eClass the Ecore class of the notifier.
	 * @generated
	 */
	protected void notifyReturnParameterMembershipChanged(Notification notification, EClass eClass) {
		switch (notification.getFeatureID(ReturnParameterMembership.class)) {
			case SysMLPackage.RETURN_PARAMETER_MEMBERSHIP__OWNED_RELATED_ELEMENT:
				notifyChanged(notification, eClass, SysMLPackage.Literals.RELATIONSHIP__RELATED_ELEMENT);
				break;
			case SysMLPackage.RETURN_PARAMETER_MEMBERSHIP__OWNING_RELATED_ELEMENT:
				notifyChanged(notification, eClass, SysMLPackage.Literals.RELATIONSHIP__RELATED_ELEMENT);
				break;
			case SysMLPackage.RETURN_PARAMETER_MEMBERSHIP__TARGET:
				notifyChanged(notification, eClass, SysMLPackage.Literals.RELATIONSHIP__RELATED_ELEMENT);
				break;
			case SysMLPackage.RETURN_PARAMETER_MEMBERSHIP__SOURCE:
				notifyChanged(notification, eClass, SysMLPackage.Literals.RELATIONSHIP__RELATED_ELEMENT);
				break;
			case SysMLPackage.RETURN_PARAMETER_MEMBERSHIP__MEMBERSHIP_OWNING_NAMESPACE:
				notifyChanged(notification, eClass, SysMLPackage.Literals.RELATIONSHIP__RELATED_ELEMENT);
				break;
			case SysMLPackage.RETURN_PARAMETER_MEMBERSHIP__OWNED_MEMBER_ELEMENT:
				notifyChanged(notification, eClass, SysMLPackage.Literals.RELATIONSHIP__RELATED_ELEMENT);
				break;
			case SysMLPackage.RETURN_PARAMETER_MEMBERSHIP__OWNING_FEATURE_OF_TYPE:
				notifyChanged(notification, eClass, SysMLPackage.Literals.RELATIONSHIP__RELATED_ELEMENT);
				break;
		}
	}

	/**
	 * Calls <code>notifyChanged</code> for each affected derived union.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param notification a description of the change.
	 * @param eClass the Ecore class of the notifier.
	 * @generated
	 */
	protected void notifyLiteralExpressionChanged(Notification notification, EClass eClass) {
		switch (notification.getFeatureID(LiteralExpression.class)) {
			case SysMLPackage.LITERAL_EXPRESSION__IMPORTED_MEMBERSHIP:
				notifyChanged(notification, eClass, SysMLPackage.Literals.NAMESPACE__MEMBERSHIP);
				break;
			case SysMLPackage.LITERAL_EXPRESSION__OWNED_MEMBERSHIP:
				notifyChanged(notification, eClass, SysMLPackage.Literals.NAMESPACE__MEMBERSHIP);
				break;
			case SysMLPackage.LITERAL_EXPRESSION__OWNED_FEATURE_MEMBERSHIP:
				notifyChanged(notification, eClass, SysMLPackage.Literals.NAMESPACE__MEMBERSHIP);
				break;
			case SysMLPackage.LITERAL_EXPRESSION__INHERITED_MEMBERSHIP:
				notifyChanged(notification, eClass, SysMLPackage.Literals.NAMESPACE__MEMBERSHIP);
				break;
		}
	}

	/**
	 * Calls <code>notifyChanged</code> for each affected derived union.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param notification a description of the change.
	 * @param eClass the Ecore class of the notifier.
	 * @generated
	 */
	protected void notifyLiteralRationalChanged(Notification notification, EClass eClass) {
		switch (notification.getFeatureID(LiteralRational.class)) {
			case SysMLPackage.LITERAL_RATIONAL__IMPORTED_MEMBERSHIP:
				notifyChanged(notification, eClass, SysMLPackage.Literals.NAMESPACE__MEMBERSHIP);
				break;
			case SysMLPackage.LITERAL_RATIONAL__OWNED_MEMBERSHIP:
				notifyChanged(notification, eClass, SysMLPackage.Literals.NAMESPACE__MEMBERSHIP);
				break;
			case SysMLPackage.LITERAL_RATIONAL__OWNED_FEATURE_MEMBERSHIP:
				notifyChanged(notification, eClass, SysMLPackage.Literals.NAMESPACE__MEMBERSHIP);
				break;
			case SysMLPackage.LITERAL_RATIONAL__INHERITED_MEMBERSHIP:
				notifyChanged(notification, eClass, SysMLPackage.Literals.NAMESPACE__MEMBERSHIP);
				break;
		}
	}

	/**
	 * Calls <code>notifyChanged</code> for each affected derived union.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param notification a description of the change.
	 * @param eClass the Ecore class of the notifier.
	 * @generated
	 */
	protected void notifyItemFlowEndChanged(Notification notification, EClass eClass) {
		switch (notification.getFeatureID(ItemFlowEnd.class)) {
			case SysMLPackage.ITEM_FLOW_END__IMPORTED_MEMBERSHIP:
				notifyChanged(notification, eClass, SysMLPackage.Literals.NAMESPACE__MEMBERSHIP);
				break;
			case SysMLPackage.ITEM_FLOW_END__OWNED_MEMBERSHIP:
				notifyChanged(notification, eClass, SysMLPackage.Literals.NAMESPACE__MEMBERSHIP);
				break;
			case SysMLPackage.ITEM_FLOW_END__OWNED_FEATURE_MEMBERSHIP:
				notifyChanged(notification, eClass, SysMLPackage.Literals.NAMESPACE__MEMBERSHIP);
				break;
			case SysMLPackage.ITEM_FLOW_END__INHERITED_MEMBERSHIP:
				notifyChanged(notification, eClass, SysMLPackage.Literals.NAMESPACE__MEMBERSHIP);
				break;
		}
	}

	/**
	 * Calls <code>notifyChanged</code> for each affected derived union.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param notification a description of the change.
	 * @param eClass the Ecore class of the notifier.
	 * @generated
	 */
	protected void notifyItemFeatureChanged(Notification notification, EClass eClass) {
		switch (notification.getFeatureID(ItemFeature.class)) {
			case SysMLPackage.ITEM_FEATURE__IMPORTED_MEMBERSHIP:
				notifyChanged(notification, eClass, SysMLPackage.Literals.NAMESPACE__MEMBERSHIP);
				break;
			case SysMLPackage.ITEM_FEATURE__OWNED_MEMBERSHIP:
				notifyChanged(notification, eClass, SysMLPackage.Literals.NAMESPACE__MEMBERSHIP);
				break;
			case SysMLPackage.ITEM_FEATURE__OWNED_FEATURE_MEMBERSHIP:
				notifyChanged(notification, eClass, SysMLPackage.Literals.NAMESPACE__MEMBERSHIP);
				break;
			case SysMLPackage.ITEM_FEATURE__INHERITED_MEMBERSHIP:
				notifyChanged(notification, eClass, SysMLPackage.Literals.NAMESPACE__MEMBERSHIP);
				break;
		}
	}

	/**
	 * Calls <code>notifyChanged</code> for each affected derived union.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param notification a description of the change.
	 * @param eClass the Ecore class of the notifier.
	 * @generated
	 */
	protected void notifySourceEndChanged(Notification notification, EClass eClass) {
		switch (notification.getFeatureID(SourceEnd.class)) {
			case SysMLPackage.SOURCE_END__IMPORTED_MEMBERSHIP:
				notifyChanged(notification, eClass, SysMLPackage.Literals.NAMESPACE__MEMBERSHIP);
				break;
			case SysMLPackage.SOURCE_END__OWNED_MEMBERSHIP:
				notifyChanged(notification, eClass, SysMLPackage.Literals.NAMESPACE__MEMBERSHIP);
				break;
			case SysMLPackage.SOURCE_END__OWNED_FEATURE_MEMBERSHIP:
				notifyChanged(notification, eClass, SysMLPackage.Literals.NAMESPACE__MEMBERSHIP);
				break;
			case SysMLPackage.SOURCE_END__INHERITED_MEMBERSHIP:
				notifyChanged(notification, eClass, SysMLPackage.Literals.NAMESPACE__MEMBERSHIP);
				break;
		}
	}

	/**
	 * Calls <code>notifyChanged</code> for each affected derived union.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param notification a description of the change.
	 * @param eClass the Ecore class of the notifier.
	 * @generated
	 */
	protected void notifyTargetEndChanged(Notification notification, EClass eClass) {
		switch (notification.getFeatureID(TargetEnd.class)) {
			case SysMLPackage.TARGET_END__IMPORTED_MEMBERSHIP:
				notifyChanged(notification, eClass, SysMLPackage.Literals.NAMESPACE__MEMBERSHIP);
				break;
			case SysMLPackage.TARGET_END__OWNED_MEMBERSHIP:
				notifyChanged(notification, eClass, SysMLPackage.Literals.NAMESPACE__MEMBERSHIP);
				break;
			case SysMLPackage.TARGET_END__OWNED_FEATURE_MEMBERSHIP:
				notifyChanged(notification, eClass, SysMLPackage.Literals.NAMESPACE__MEMBERSHIP);
				break;
			case SysMLPackage.TARGET_END__INHERITED_MEMBERSHIP:
				notifyChanged(notification, eClass, SysMLPackage.Literals.NAMESPACE__MEMBERSHIP);
				break;
		}
	}

	/**
	 * Calls <code>notifyChanged</code> for each affected derived union.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param notification a description of the change.
	 * @param eClass the Ecore class of the notifier.
	 * @generated
	 */
	protected void notifyEndFeatureMembershipChanged(Notification notification, EClass eClass) {
		switch (notification.getFeatureID(EndFeatureMembership.class)) {
			case SysMLPackage.END_FEATURE_MEMBERSHIP__OWNED_RELATED_ELEMENT:
				notifyChanged(notification, eClass, SysMLPackage.Literals.RELATIONSHIP__RELATED_ELEMENT);
				break;
			case SysMLPackage.END_FEATURE_MEMBERSHIP__OWNING_RELATED_ELEMENT:
				notifyChanged(notification, eClass, SysMLPackage.Literals.RELATIONSHIP__RELATED_ELEMENT);
				break;
			case SysMLPackage.END_FEATURE_MEMBERSHIP__TARGET:
				notifyChanged(notification, eClass, SysMLPackage.Literals.RELATIONSHIP__RELATED_ELEMENT);
				break;
			case SysMLPackage.END_FEATURE_MEMBERSHIP__SOURCE:
				notifyChanged(notification, eClass, SysMLPackage.Literals.RELATIONSHIP__RELATED_ELEMENT);
				break;
			case SysMLPackage.END_FEATURE_MEMBERSHIP__MEMBERSHIP_OWNING_NAMESPACE:
				notifyChanged(notification, eClass, SysMLPackage.Literals.RELATIONSHIP__RELATED_ELEMENT);
				break;
			case SysMLPackage.END_FEATURE_MEMBERSHIP__OWNED_MEMBER_ELEMENT:
				notifyChanged(notification, eClass, SysMLPackage.Literals.RELATIONSHIP__RELATED_ELEMENT);
				break;
			case SysMLPackage.END_FEATURE_MEMBERSHIP__OWNING_FEATURE_OF_TYPE:
				notifyChanged(notification, eClass, SysMLPackage.Literals.RELATIONSHIP__RELATED_ELEMENT);
				break;
		}
	}

	/**
	 * Calls <code>notifyChanged</code> for each affected derived union.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param notification a description of the change.
	 * @param eClass the Ecore class of the notifier.
	 * @generated
	 */
	protected void notifyTransitionFeatureMembershipChanged(Notification notification, EClass eClass) {
		switch (notification.getFeatureID(TransitionFeatureMembership.class)) {
			case SysMLPackage.TRANSITION_FEATURE_MEMBERSHIP__OWNED_RELATED_ELEMENT:
				notifyChanged(notification, eClass, SysMLPackage.Literals.RELATIONSHIP__RELATED_ELEMENT);
				break;
			case SysMLPackage.TRANSITION_FEATURE_MEMBERSHIP__OWNING_RELATED_ELEMENT:
				notifyChanged(notification, eClass, SysMLPackage.Literals.RELATIONSHIP__RELATED_ELEMENT);
				break;
			case SysMLPackage.TRANSITION_FEATURE_MEMBERSHIP__TARGET:
				notifyChanged(notification, eClass, SysMLPackage.Literals.RELATIONSHIP__RELATED_ELEMENT);
				break;
			case SysMLPackage.TRANSITION_FEATURE_MEMBERSHIP__SOURCE:
				notifyChanged(notification, eClass, SysMLPackage.Literals.RELATIONSHIP__RELATED_ELEMENT);
				break;
			case SysMLPackage.TRANSITION_FEATURE_MEMBERSHIP__MEMBERSHIP_OWNING_NAMESPACE:
				notifyChanged(notification, eClass, SysMLPackage.Literals.RELATIONSHIP__RELATED_ELEMENT);
				break;
			case SysMLPackage.TRANSITION_FEATURE_MEMBERSHIP__OWNED_MEMBER_ELEMENT:
				notifyChanged(notification, eClass, SysMLPackage.Literals.RELATIONSHIP__RELATED_ELEMENT);
				break;
			case SysMLPackage.TRANSITION_FEATURE_MEMBERSHIP__OWNING_FEATURE_OF_TYPE:
				notifyChanged(notification, eClass, SysMLPackage.Literals.RELATIONSHIP__RELATED_ELEMENT);
				break;
		}
	}

	/**
	 * Calls <code>notifyChanged</code> for each affected derived union.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param notification a description of the change.
	 * @param eClass the Ecore class of the notifier.
	 * @generated
	 */
	protected void notifyOperatorExpressionChanged(Notification notification, EClass eClass) {
		switch (notification.getFeatureID(OperatorExpression.class)) {
			case SysMLPackage.OPERATOR_EXPRESSION__IMPORTED_MEMBERSHIP:
				notifyChanged(notification, eClass, SysMLPackage.Literals.NAMESPACE__MEMBERSHIP);
				break;
			case SysMLPackage.OPERATOR_EXPRESSION__OWNED_MEMBERSHIP:
				notifyChanged(notification, eClass, SysMLPackage.Literals.NAMESPACE__MEMBERSHIP);
				break;
			case SysMLPackage.OPERATOR_EXPRESSION__OWNED_FEATURE_MEMBERSHIP:
				notifyChanged(notification, eClass, SysMLPackage.Literals.NAMESPACE__MEMBERSHIP);
				break;
			case SysMLPackage.OPERATOR_EXPRESSION__INHERITED_MEMBERSHIP:
				notifyChanged(notification, eClass, SysMLPackage.Literals.NAMESPACE__MEMBERSHIP);
				break;
		}
	}

	/**
	 * Calls <code>notifyChanged</code> for each affected derived union.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param notification a description of the change.
	 * @param eClass the Ecore class of the notifier.
	 * @generated
	 */
	protected void notifyLiteralStringChanged(Notification notification, EClass eClass) {
		switch (notification.getFeatureID(LiteralString.class)) {
			case SysMLPackage.LITERAL_STRING__IMPORTED_MEMBERSHIP:
				notifyChanged(notification, eClass, SysMLPackage.Literals.NAMESPACE__MEMBERSHIP);
				break;
			case SysMLPackage.LITERAL_STRING__OWNED_MEMBERSHIP:
				notifyChanged(notification, eClass, SysMLPackage.Literals.NAMESPACE__MEMBERSHIP);
				break;
			case SysMLPackage.LITERAL_STRING__OWNED_FEATURE_MEMBERSHIP:
				notifyChanged(notification, eClass, SysMLPackage.Literals.NAMESPACE__MEMBERSHIP);
				break;
			case SysMLPackage.LITERAL_STRING__INHERITED_MEMBERSHIP:
				notifyChanged(notification, eClass, SysMLPackage.Literals.NAMESPACE__MEMBERSHIP);
				break;
		}
	}

	/**
	 * Calls <code>notifyChanged</code> for each affected derived union.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param notification a description of the change.
	 * @param eClass the Ecore class of the notifier.
	 * @generated
	 */
	protected void notifyItemFlowChanged(Notification notification, EClass eClass) {
		switch (notification.getFeatureID(ItemFlow.class)) {
			case SysMLPackage.ITEM_FLOW__IMPORTED_MEMBERSHIP:
				notifyChanged(notification, eClass, SysMLPackage.Literals.NAMESPACE__MEMBERSHIP);
				break;
			case SysMLPackage.ITEM_FLOW__OWNED_MEMBERSHIP:
				notifyChanged(notification, eClass, SysMLPackage.Literals.NAMESPACE__MEMBERSHIP);
				break;
			case SysMLPackage.ITEM_FLOW__OWNED_FEATURE_MEMBERSHIP:
				notifyChanged(notification, eClass, SysMLPackage.Literals.NAMESPACE__MEMBERSHIP);
				break;
			case SysMLPackage.ITEM_FLOW__INHERITED_MEMBERSHIP:
				notifyChanged(notification, eClass, SysMLPackage.Literals.NAMESPACE__MEMBERSHIP);
				break;
			case SysMLPackage.ITEM_FLOW__OWNED_RELATED_ELEMENT:
				notifyChanged(notification, eClass, SysMLPackage.Literals.RELATIONSHIP__RELATED_ELEMENT);
				break;
			case SysMLPackage.ITEM_FLOW__OWNING_RELATED_ELEMENT:
				notifyChanged(notification, eClass, SysMLPackage.Literals.RELATIONSHIP__RELATED_ELEMENT);
				break;
			case SysMLPackage.ITEM_FLOW__TARGET:
				notifyChanged(notification, eClass, SysMLPackage.Literals.RELATIONSHIP__RELATED_ELEMENT);
				break;
			case SysMLPackage.ITEM_FLOW__SOURCE:
				notifyChanged(notification, eClass, SysMLPackage.Literals.RELATIONSHIP__RELATED_ELEMENT);
				break;
			case SysMLPackage.ITEM_FLOW__SOURCE_FEATURE:
				notifyChanged(notification, eClass, SysMLPackage.Literals.CONNECTOR__RELATED_FEATURE);
				break;
			case SysMLPackage.ITEM_FLOW__TARGET_FEATURE:
				notifyChanged(notification, eClass, SysMLPackage.Literals.CONNECTOR__RELATED_FEATURE);
				break;
		}
	}

	/**
	 * Calls <code>notifyChanged</code> for each affected derived union.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param notification a description of the change.
	 * @param eClass the Ecore class of the notifier.
	 * @generated
	 */
	protected void notifyItemFlowFeatureChanged(Notification notification, EClass eClass) {
		switch (notification.getFeatureID(ItemFlowFeature.class)) {
			case SysMLPackage.ITEM_FLOW_FEATURE__IMPORTED_MEMBERSHIP:
				notifyChanged(notification, eClass, SysMLPackage.Literals.NAMESPACE__MEMBERSHIP);
				break;
			case SysMLPackage.ITEM_FLOW_FEATURE__OWNED_MEMBERSHIP:
				notifyChanged(notification, eClass, SysMLPackage.Literals.NAMESPACE__MEMBERSHIP);
				break;
			case SysMLPackage.ITEM_FLOW_FEATURE__OWNED_FEATURE_MEMBERSHIP:
				notifyChanged(notification, eClass, SysMLPackage.Literals.NAMESPACE__MEMBERSHIP);
				break;
			case SysMLPackage.ITEM_FLOW_FEATURE__INHERITED_MEMBERSHIP:
				notifyChanged(notification, eClass, SysMLPackage.Literals.NAMESPACE__MEMBERSHIP);
				break;
		}
	}

	/**
	 * Calls <code>notifyChanged</code> for each affected derived union.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param notification a description of the change.
	 * @param eClass the Ecore class of the notifier.
	 * @generated
	 */
	protected void notifySuccessionItemFlowChanged(Notification notification, EClass eClass) {
		switch (notification.getFeatureID(SuccessionItemFlow.class)) {
			case SysMLPackage.SUCCESSION_ITEM_FLOW__IMPORTED_MEMBERSHIP:
				notifyChanged(notification, eClass, SysMLPackage.Literals.NAMESPACE__MEMBERSHIP);
				break;
			case SysMLPackage.SUCCESSION_ITEM_FLOW__OWNED_MEMBERSHIP:
				notifyChanged(notification, eClass, SysMLPackage.Literals.NAMESPACE__MEMBERSHIP);
				break;
			case SysMLPackage.SUCCESSION_ITEM_FLOW__OWNED_FEATURE_MEMBERSHIP:
				notifyChanged(notification, eClass, SysMLPackage.Literals.NAMESPACE__MEMBERSHIP);
				break;
			case SysMLPackage.SUCCESSION_ITEM_FLOW__INHERITED_MEMBERSHIP:
				notifyChanged(notification, eClass, SysMLPackage.Literals.NAMESPACE__MEMBERSHIP);
				break;
			case SysMLPackage.SUCCESSION_ITEM_FLOW__OWNED_RELATED_ELEMENT:
				notifyChanged(notification, eClass, SysMLPackage.Literals.RELATIONSHIP__RELATED_ELEMENT);
				break;
			case SysMLPackage.SUCCESSION_ITEM_FLOW__OWNING_RELATED_ELEMENT:
				notifyChanged(notification, eClass, SysMLPackage.Literals.RELATIONSHIP__RELATED_ELEMENT);
				break;
			case SysMLPackage.SUCCESSION_ITEM_FLOW__TARGET:
				notifyChanged(notification, eClass, SysMLPackage.Literals.RELATIONSHIP__RELATED_ELEMENT);
				break;
			case SysMLPackage.SUCCESSION_ITEM_FLOW__SOURCE:
				notifyChanged(notification, eClass, SysMLPackage.Literals.RELATIONSHIP__RELATED_ELEMENT);
				break;
			case SysMLPackage.SUCCESSION_ITEM_FLOW__SOURCE_FEATURE:
				notifyChanged(notification, eClass, SysMLPackage.Literals.CONNECTOR__RELATED_FEATURE);
				break;
			case SysMLPackage.SUCCESSION_ITEM_FLOW__TARGET_FEATURE:
				notifyChanged(notification, eClass, SysMLPackage.Literals.CONNECTOR__RELATED_FEATURE);
				break;
		}
	}

	/**
	 * Calls <code>notifyChanged</code> for each affected derived union.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param notification a description of the change.
	 * @param eClass the Ecore class of the notifier.
	 * @generated
	 */
	protected void notifySuccessionAsUsageChanged(Notification notification, EClass eClass) {
		switch (notification.getFeatureID(SuccessionAsUsage.class)) {
			case SysMLPackage.SUCCESSION_AS_USAGE__IMPORTED_MEMBERSHIP:
				notifyChanged(notification, eClass, SysMLPackage.Literals.NAMESPACE__MEMBERSHIP);
				break;
			case SysMLPackage.SUCCESSION_AS_USAGE__OWNED_MEMBERSHIP:
				notifyChanged(notification, eClass, SysMLPackage.Literals.NAMESPACE__MEMBERSHIP);
				break;
			case SysMLPackage.SUCCESSION_AS_USAGE__OWNED_FEATURE_MEMBERSHIP:
				notifyChanged(notification, eClass, SysMLPackage.Literals.NAMESPACE__MEMBERSHIP);
				break;
			case SysMLPackage.SUCCESSION_AS_USAGE__INHERITED_MEMBERSHIP:
				notifyChanged(notification, eClass, SysMLPackage.Literals.NAMESPACE__MEMBERSHIP);
				break;
			case SysMLPackage.SUCCESSION_AS_USAGE__VARIANT_MEMBERSHIP:
				notifyChanged(notification, eClass, SysMLPackage.Literals.NAMESPACE__MEMBERSHIP);
				break;
			case SysMLPackage.SUCCESSION_AS_USAGE__OWNED_RELATED_ELEMENT:
				notifyChanged(notification, eClass, SysMLPackage.Literals.RELATIONSHIP__RELATED_ELEMENT);
				break;
			case SysMLPackage.SUCCESSION_AS_USAGE__OWNING_RELATED_ELEMENT:
				notifyChanged(notification, eClass, SysMLPackage.Literals.RELATIONSHIP__RELATED_ELEMENT);
				break;
			case SysMLPackage.SUCCESSION_AS_USAGE__TARGET:
				notifyChanged(notification, eClass, SysMLPackage.Literals.RELATIONSHIP__RELATED_ELEMENT);
				break;
			case SysMLPackage.SUCCESSION_AS_USAGE__SOURCE:
				notifyChanged(notification, eClass, SysMLPackage.Literals.RELATIONSHIP__RELATED_ELEMENT);
				break;
			case SysMLPackage.SUCCESSION_AS_USAGE__SOURCE_FEATURE:
				notifyChanged(notification, eClass, SysMLPackage.Literals.CONNECTOR__RELATED_FEATURE);
				break;
			case SysMLPackage.SUCCESSION_AS_USAGE__TARGET_FEATURE:
				notifyChanged(notification, eClass, SysMLPackage.Literals.CONNECTOR__RELATED_FEATURE);
				break;
		}
	}

	/**
	 * Calls <code>notifyChanged</code> for each affected derived union.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param notification a description of the change.
	 * @param eClass the Ecore class of the notifier.
	 * @generated
	 */
	protected void notifyLiteralIntegerChanged(Notification notification, EClass eClass) {
		switch (notification.getFeatureID(LiteralInteger.class)) {
			case SysMLPackage.LITERAL_INTEGER__IMPORTED_MEMBERSHIP:
				notifyChanged(notification, eClass, SysMLPackage.Literals.NAMESPACE__MEMBERSHIP);
				break;
			case SysMLPackage.LITERAL_INTEGER__OWNED_MEMBERSHIP:
				notifyChanged(notification, eClass, SysMLPackage.Literals.NAMESPACE__MEMBERSHIP);
				break;
			case SysMLPackage.LITERAL_INTEGER__OWNED_FEATURE_MEMBERSHIP:
				notifyChanged(notification, eClass, SysMLPackage.Literals.NAMESPACE__MEMBERSHIP);
				break;
			case SysMLPackage.LITERAL_INTEGER__INHERITED_MEMBERSHIP:
				notifyChanged(notification, eClass, SysMLPackage.Literals.NAMESPACE__MEMBERSHIP);
				break;
		}
	}

	/**
	 * Calls <code>notifyChanged</code> for each affected derived union.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param notification a description of the change.
	 * @param eClass the Ecore class of the notifier.
	 * @generated
	 */
	protected void notifyNullExpressionChanged(Notification notification, EClass eClass) {
		switch (notification.getFeatureID(NullExpression.class)) {
			case SysMLPackage.NULL_EXPRESSION__IMPORTED_MEMBERSHIP:
				notifyChanged(notification, eClass, SysMLPackage.Literals.NAMESPACE__MEMBERSHIP);
				break;
			case SysMLPackage.NULL_EXPRESSION__OWNED_MEMBERSHIP:
				notifyChanged(notification, eClass, SysMLPackage.Literals.NAMESPACE__MEMBERSHIP);
				break;
			case SysMLPackage.NULL_EXPRESSION__OWNED_FEATURE_MEMBERSHIP:
				notifyChanged(notification, eClass, SysMLPackage.Literals.NAMESPACE__MEMBERSHIP);
				break;
			case SysMLPackage.NULL_EXPRESSION__INHERITED_MEMBERSHIP:
				notifyChanged(notification, eClass, SysMLPackage.Literals.NAMESPACE__MEMBERSHIP);
				break;
		}
	}

	/**
	 * Calls <code>notifyChanged</code> for each affected derived union.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param notification a description of the change.
	 * @param eClass the Ecore class of the notifier.
	 * @generated
	 */
	protected void notifyFeatureReferenceExpressionChanged(Notification notification, EClass eClass) {
		switch (notification.getFeatureID(FeatureReferenceExpression.class)) {
			case SysMLPackage.FEATURE_REFERENCE_EXPRESSION__IMPORTED_MEMBERSHIP:
				notifyChanged(notification, eClass, SysMLPackage.Literals.NAMESPACE__MEMBERSHIP);
				break;
			case SysMLPackage.FEATURE_REFERENCE_EXPRESSION__OWNED_MEMBERSHIP:
				notifyChanged(notification, eClass, SysMLPackage.Literals.NAMESPACE__MEMBERSHIP);
				break;
			case SysMLPackage.FEATURE_REFERENCE_EXPRESSION__OWNED_FEATURE_MEMBERSHIP:
				notifyChanged(notification, eClass, SysMLPackage.Literals.NAMESPACE__MEMBERSHIP);
				break;
			case SysMLPackage.FEATURE_REFERENCE_EXPRESSION__INHERITED_MEMBERSHIP:
				notifyChanged(notification, eClass, SysMLPackage.Literals.NAMESPACE__MEMBERSHIP);
				break;
		}
	}

} //SysMLDerivedUnionAdapter
