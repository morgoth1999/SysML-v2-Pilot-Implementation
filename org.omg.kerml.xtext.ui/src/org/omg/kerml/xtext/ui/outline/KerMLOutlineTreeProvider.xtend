/*
 * generated by Xtext 2.12.0
 */
package org.omg.kerml.xtext.ui.outline

import org.eclipse.xtext.ui.editor.outline.IOutlineNode
import org.eclipse.xtext.ui.editor.outline.impl.DefaultOutlineTreeProvider
import org.omg.sysml.lang.sysml.Annotation
import org.omg.sysml.lang.sysml.Conjugation
import org.omg.sysml.lang.sysml.Element
import org.omg.sysml.lang.sysml.FeatureMembership
import org.omg.sysml.lang.sysml.Import
import org.omg.sysml.lang.sysml.LiteralBoolean
import org.omg.sysml.lang.sysml.LiteralString
import org.omg.sysml.lang.sysml.Membership
import org.omg.sysml.lang.sysml.NullExpression
import org.omg.sysml.lang.sysml.OperatorExpression
import org.omg.sysml.lang.sysml.Redefinition
import org.omg.sysml.lang.sysml.Relationship
import org.omg.sysml.lang.sysml.Subsetting
import org.omg.sysml.lang.sysml.Type
import org.omg.sysml.lang.sysml.VisibilityKind
import org.omg.sysml.lang.sysml.Comment
import org.omg.sysml.lang.sysml.SysMLPackage
import org.omg.sysml.lang.sysml.TextualRepresentation
import org.omg.sysml.lang.sysml.Association
import org.omg.sysml.lang.sysml.Connector
import org.omg.sysml.lang.sysml.TypeFeaturing
import org.omg.sysml.lang.sysml.Namespace
import java.net.URLDecoder
import org.omg.sysml.lang.sysml.Feature
import org.omg.sysml.lang.sysml.Expression
import org.eclipse.swt.graphics.Image
import org.eclipse.emf.ecore.EObject
import org.eclipse.xtext.ui.editor.outline.impl.AbstractOutlineNode
import org.eclipse.xtext.ui.editor.outline.impl.DocumentRootNode
import org.omg.sysml.util.ElementUtil
import org.omg.sysml.util.TypeUtil
import org.omg.sysml.util.FeatureUtil
import org.omg.sysml.lang.sysml.LiteralRational
import org.omg.sysml.lang.sysml.LiteralInfinity
import org.omg.sysml.lang.sysml.Specialization
import org.omg.sysml.lang.sysml.LiteralInteger

/**
 * Customization of the default outline structure.
 *
 * See https://www.eclipse.org/Xtext/documentation/310_eclipse_support.html#outline
 */
class KerMLOutlineTreeProvider extends DefaultOutlineTreeProvider {
	
	def String metaclassText(Element element) {
		element.eClass.name
	}

	def String _text(Element element) {
		var text = element.metaclassText;
		if (element.humanId !== null) {
			text += ' id ' + element.humanId
		}
		val name = element.getEffectiveName;
		if (name !== null) {
			text += ' ' + name;
		}
		text 
	}
	
	def String _text(Namespace namespace) {
		if (namespace.eContainer !== null || namespace.eResource === null)
			(namespace as Element)._text
		else 
			'Root ' + URLDecoder.decode(namespace.eResource.URI.lastSegment, "UTF-8")
	}
	
	def String _text(VisibilityKind visibility) {
		visibility.toString
	}
	
	def String prefixText(Membership membership) {
		var text = membership.metaclassText;
		if (membership.ownedMemberElement !== null) {
			text += ' owns'
		}
		if (membership.visibility !== null) {
			text += ' ' + membership.visibility._text;
		}
		text
	}
	
	def String nameText(Membership membership) {
		if (membership.memberName !== null)
			membership.memberName
		else {
			val name = membership.memberElement?.getEffectiveName;
			if (name !== null) name else ""
		}
	}
	
	def String _text(Membership membership) {
		membership.prefixText + ' ' + membership.nameText
	}
	
	def String _text(Import import_) {
		var text = import_.metaclassText;
		if (import_.visibility !== null) {
			text += ' ' + import_.visibility._text
		}
		var imp = import_
		if (import_.importedNamespace?.owningRelationship === import_) {
			if (!import_.importedNamespace.ownedImport.isEmpty) {
				imp = import_.importedNamespace.ownedImport.get(0)
				text = text + ' filter'
			}
		}
		if (imp.importedNamespace?.name !== null) {
			text += ' ' + imp.importedNamespace.name
		}
		if (imp.importedMemberName === null) {
			text += "::*"
		} else {
			text += "::" + imp.importedMemberName
		}
		if (imp.isRecursive) {
			text += "::**"
		}
		text
	}
	
	def String _text(Type type) {
		var text = type.eClass.name;
		if (type.isAbstract) {
			text += ' abstract'
		}
		if (type.humanId !== null) {
			text += ' id ' + type.humanId
		}
		val name = type.getEffectiveName
		if (name !== null) {
			text += ' ' + name;
		}
		text
	}
	
	def String _text(Feature feature) {
		var text = feature.eClass.name;
		if (feature.direction !== null) {
			text += ' ' + feature.direction
		}
		if (feature.isAbstract) {
			text += ' abstract'
		}
		if (feature.isComposite) {
			text += ' composite'
		}
		if (feature.isPortion) {
			text += ' portion'
		}
		if (feature.isEnd) {
			text += ' end'
		}
		if (feature.humanId !== null) {
			text += ' id ' + feature.humanId
		}
		val name = feature.getEffectiveName
		if (name !== null) {
			text += ' ' + name;
		}
		text
	}
	
	def String _text(Expression expression) {
		var text = (expression as Feature)._text
		if (expression.isModelLevelEvaluable) {
			text += " model-level"
		}
		text
	}
	
	def String _text(LiteralString literal) {
		literal.metaclassText + ' ' + literal.value
	}
	
	def String _text(LiteralBoolean literal) {
		literal.metaclassText + ' ' + literal.value
	}
	
	def String _text(LiteralInteger literal) {
		literal.metaclassText + ' ' + literal.getValue
	}
	
	def String _text(LiteralRational literal) {
		literal.metaclassText + ' ' + literal.getValue
	}
	
	def String _text(LiteralInfinity literal) {
		literal.metaclassText + ' *'
	}
	
	def String _text(NullExpression expression) {
		expression.metaclassText + ' null'
	}
	
	def boolean _isLeaf(Relationship relationship) {
		false
	}
	
	def void _createChildren(IOutlineNode parentNode, Relationship relationship) {
		createRelatedElements(parentNode, relationship)
		super._createChildren(parentNode, relationship)
	}
	
	def createRelatedElements(IOutlineNode parentNode, Relationship relationship) {
		for (source: relationship.source) {
			createNode(parentNode, source, 
				_image(source), 'from ' + source._text, 
				true
			)
		}
		for (target: relationship.target) {
			createNode(parentNode, target, 
				_image(target), 'to ' + target._text, 
				true
			)
		}
	}
	
	def boolean _isLeaf(Annotation annotation) {
		false
	}
	
	def void _createChildren(IOutlineNode parentNode, Annotation annotation) {
		super._createChildren(parentNode, annotation)
		if (annotation.annotatedElement !== null) {
			createNode(parentNode, annotation.annotatedElement, 
				_image(annotation.annotatedElement), annotation.annotatedElement._text, 
				true
			)
		}
	}
	
	def boolean _isLeaf(Comment comment) {
		comment.body === null && super._isLeaf(comment)
	}
	
	def void _createChildren(IOutlineNode parentNode, Comment comment) {
		if (comment.body !== null) {
			createEStructuralFeatureNode(parentNode, comment, 
				SysMLPackage.eINSTANCE.comment_Body, 
				_image(comment.body), comment.body, true
			)
		}
		super._createChildren(parentNode, comment)
	}
	

	def boolean _isLeaf(TextualRepresentation rep) {
		rep.language === null && rep.body === null && super._isLeaf(rep)
	}
	
	def void _createChildren(IOutlineNode parentNode, TextualRepresentation rep) {
		if (rep.language !== null) {
			createEStructuralFeatureNode(parentNode, rep, 
				SysMLPackage.eINSTANCE.textualRepresentation_Language, 
				_image(rep.language), "language " + rep.language, true
			)
		}
		if (rep.body !== null) {
			createEStructuralFeatureNode(parentNode, rep, 
				SysMLPackage.eINSTANCE.textualRepresentation_Body, 
				_image(rep.body), rep.body, true
			)
		}
		super._createChildren(parentNode, rep)
	}
	

	def boolean _isLeaf(Membership membership) {
		false
	}
	
	def void _createChildren(IOutlineNode parentNode, Membership membership) {
		super._createChildren(parentNode, membership)
		var memberElement = membership.memberElement;
		if (membership.ownedMemberElement === null && 
				memberElement !== null) {
			createNode(parentNode, memberElement, 
				memberElement._image, memberElement._text, 
				true
			)
		}
	}
	
	def boolean _isLeaf(FeatureMembership membership) {
		false
	}
	
	// Display a FeatureMembership like a Membership, rather than like a TypeFeaturing.
	def void _createChildren(IOutlineNode parentNode, FeatureMembership membership) {
		_createChildren(parentNode, membership as Membership)
	}
	
	def boolean _isLeaf(Import _import) {
		_import.importedNamespace === null && _import.ownedElement.isEmpty
	}
	
	def void _createChildren(IOutlineNode parentNode, Import _import) {
		super._createChildren(parentNode, _import)
		var importedNamespace = _import.importedNamespace;
		if (importedNamespace !== null && importedNamespace.owningRelationship !== _import) {
			createNode(parentNode, importedNamespace, 
				importedNamespace._image, importedNamespace._text, true
			)
		}
	}
	
	def boolean _isLeaf(TypeFeaturing featuring) {
		featuring.featuringType === null
	}
	
	def void _createChildren(IOutlineNode parentNode, TypeFeaturing featuring) {
		if (featuring.featureOfType !== null && featuring.featureOfType !== featuring.eContainer) {
			createNode(parentNode, featuring.featureOfType, 
				featuring.featureOfType._image, featuring.featureOfType._text, 
				true
			)			
		}
		if (featuring.featuringType !== null) {
			createNode(parentNode, featuring.featuringType, 
				featuring.featuringType._image, featuring.featuringType._text, 
				true
			)
		}
	}
	
	def boolean _isLeaf(Specialization generalization) {
		generalization.getGeneral === null
	}
	
	def void _createChildren(IOutlineNode parentNode, Specialization generalization) {
		if (generalization.getSpecific !== null && generalization.getSpecific !== generalization.eContainer) {
			createNode(parentNode, generalization.getSpecific, 
				generalization.getSpecific._image, generalization.getSpecific._text, 
				true
			)			
		}
		if (generalization.getGeneral !== null) {
			createNode(parentNode, generalization.getGeneral, 
				generalization.getGeneral._image, generalization.getGeneral._text, 
				true
			)
		}
	}
	
	def boolean _isLeaf(Redefinition redefinition) {
		redefinition.redefinedFeature === null
	}

	def void _createChildren(IOutlineNode parentNode, Redefinition redefinition) {
		if (redefinition.redefiningFeature !== null && redefinition.redefiningFeature !== redefinition.eContainer) {
			createNode(parentNode, redefinition.redefiningFeature, 
				redefinition.redefiningFeature._image, redefinition.redefiningFeature._text, 
				true
			)			
		}
		if (redefinition.redefinedFeature !== null) {
			createNode(parentNode, redefinition.redefinedFeature, 
				redefinition.redefinedFeature._image, redefinition.redefinedFeature._text, 
				true
			)
		}
	}

	def boolean _isLeaf(Subsetting subset) {
		subset.subsettedFeature === null
	}

	def void _createChildren(IOutlineNode parentNode, Subsetting subsetting) {
		if (subsetting.subsettingFeature !== null && subsetting.subsettingFeature !== subsetting.eContainer) {
			createNode(parentNode, subsetting.subsettingFeature, 
				subsetting.subsettingFeature._image, subsetting.subsettingFeature._text, 
				true
			)			
		}
		if (subsetting.subsettedFeature !== null) {
			createNode(parentNode, subsetting.subsettedFeature, 
				_image(subsetting.subsettedFeature), subsetting.subsettedFeature._text, 
				true
			)
		}
	}
	
	def boolean _isLeaf(Conjugation conjugation) {
		conjugation.originalType === null
	}
	
	def void _createChildren(IOutlineNode parentNode, Conjugation conjugation) {
		if (conjugation.conjugatedType !== null && conjugation.conjugatedType !== conjugation.eContainer) {
			createNode(parentNode, conjugation.conjugatedType, 
				conjugation.conjugatedType._image, conjugation.conjugatedType._text, 
				true
			)			
		}
		if (conjugation.originalType !== null) {
			createNode(parentNode, conjugation.originalType, 
				_image(conjugation.originalType), conjugation.originalType._text, 
				true
			)
		}
	}
	
	def _isLeaf(Type type) {
	    _isLeaf(type as Namespace) && TypeUtil.isImplicitGeneralTypesEmpty(type) 	
	}
	
	def void _createChildren(IOutlineNode parentNode, Type type) {		
		//ImplicitFieldAdapter.getOrCreateAdapter(type).
		createImplicitGeneralizationNodes(parentNode, type)
		if (type instanceof Feature) {
			createImplicitTypeFeaturingNodes(parentNode, type)
		}
		_createChildren(parentNode, type as Namespace)
		createImplicitBindingConnectorNodes(parentNode, type)
	}
	
	def createImplicitGeneralizationNodes(IOutlineNode parentNode, Type type) {
		TypeUtil.forEachImplicitGeneralTypeOf(type, [eClass, generalType |
			/*
			 * TODO here image dispatcher should be called with a type that
			 * returns that appropriate icon for generalizations, but there
			 * are no such icons added yet; in the future, the generalType
			 * reference might return an unexpected icon if at a later point
			 * type-specific icons are added.
			 */
			val implicitNode = new ImplicitNode(parentNode, 
				imageDispatcher.invoke(generalType), eClass
			)
			
			// Traversal does not know about the new node, children have to be created here
			if (generalType !== null) {
				createNode(implicitNode, generalType, 
					generalType._image, generalType._text, 
					true
				)
			}
		])
	}
	
	def createImplicitTypeFeaturingNodes(IOutlineNode parentNode, Feature feature) {
		FeatureUtil.forEachImplicitFeaturingTypeOf(feature, [featuringType |
			/*
			 * TODO here image dispatcher should be called with a type that
			 * returns that appropriate icon for generalizations, but there
			 * are no such icons added yet; in the future, the generalType
			 * reference might return an unexpected icon if at a later point
			 * type-specific icons are added.
			 */
			val implicitNode = new ImplicitNode(parentNode, 
				imageDispatcher.invoke(featuringType), SysMLPackage.Literals.TYPE_FEATURING
			)
			// Traversal does not know about the new node, children have to be created here
			if (featuringType !== null) {
				createNode(implicitNode, featuringType, 
					featuringType._image, featuringType._text, 
					true
				)
			}
		])
	}
	
	def createImplicitBindingConnectorNodes(IOutlineNode parentNode, Type type) {
		TypeUtil.forEachImplicitBindingConnectorOf(type, [connector, eClass |
			/*
			 * TODO here image dispatcher should be called with a type that
			 * returns that appropriate icon for generalizations, but there
			 * are no such icons added yet; in the future, the generalType
			 * reference might return an unexpected icon if at a later point
			 * type-specific icons are added.
			 */
			val implicitNode = new ImplicitNode(parentNode, 
				imageDispatcher.invoke(connector), eClass)
			implicitNode.createNode(connector, imageDispatcher.invoke(connector), connector.eClass.getName, false)
		])
	}
	
	def _isLeaf(Association association) {
		false
	}
	
	def _createChildren(IOutlineNode parentNode, Association association) {
		createRelatedElements(parentNode, association)
		_createChildren(parentNode, association as Type)
	}

	def _isLeaf(Connector connector) {
		false
	}
	
	def _createChildren(IOutlineNode parentNode, Connector connector) {
		createRelatedElements(parentNode, connector)
		_createChildren(parentNode, connector as Type)
	}

	def void _createChildren(IOutlineNode parentNode, OperatorExpression expression) {
		createImplicitGeneralizationNodes(parentNode, expression)
		createImplicitTypeFeaturingNodes(parentNode, expression)
		for (Relationship relationship : expression.ownedRelationship) {
			createNode(parentNode, relationship, 
				_image(relationship), 
				if (relationship instanceof Membership) (relationship as Membership)._text 
				else relationship._text, 
				false
			);
		}
		createImplicitBindingConnectorNodes(parentNode, expression)
	}
	
	override _createNode(DocumentRootNode parentNode, EObject modelElement) {
		var text = textDispatcher.invoke(modelElement);
		if (text === null) {
			text = modelElement.eResource().getURI().trimFileExtension().lastSegment();
		}
		createNode(parentNode, modelElement, imageDispatcher.invoke(modelElement), text.toString,
				isLeafDispatcher.invoke(modelElement));
	}
	
	override _createNode(IOutlineNode parentNode, EObject modelElement) {
		var Object text = textDispatcher.invoke(modelElement);
		val isLeaf = isLeafDispatcher.invoke(modelElement);
		if (text === null && isLeaf)
			return;
		val Image image = imageDispatcher.invoke(modelElement);
		createNode(parentNode, modelElement, image, text.toString, isLeaf);
	}
	
	private def AbstractOutlineNode createNode(IOutlineNode parentNode, EObject modelElement, Image image, String text,
			boolean isLeaf) {
		if (modelElement.eResource !== null) {
			super.createEObjectNode(parentNode, modelElement, image, text, isLeaf)
		} else {
			val node = new ImplicitNode(parentNode, image, text)
			if (modelElement instanceof Element) {
				ElementUtil.transform(modelElement);
			}
			createChildrenDispatcher.invoke(node, modelElement)
			node
		}
	}
	
}
