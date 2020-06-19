/**
 */
package org.omg.sysml.lang.sysml;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Decision Node</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * <p>A DecisionNode is a ControlNode that makes a selection from its outgoing Successions. All outgoing Successions must be must have a target multiplicity of 0..1 and subset the Feature <code>DecisionAction::outgoingHBLink</code>. A DecisionNode may have at most one incoming Succession.</p>
 * 
 * <p>A DecisionNode must subset, directly or indirectly, the ActionUsage <code>Action::decisions</code>, implying that it is typed by DecisionAction from the Systems model library (or a subtype of it).</p>
 * <!-- end-model-doc -->
 *
 *
 * @see org.omg.sysml.lang.sysml.SysMLPackage#getDecisionNode()
 * @model
 * @generated
 */
public interface DecisionNode extends ControlNode {
} // DecisionNode
