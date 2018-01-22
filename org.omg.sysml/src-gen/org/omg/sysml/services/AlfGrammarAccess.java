/*
 * generated by Xtext 2.12.0
 */
package org.omg.sysml.services;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import java.util.List;
import org.eclipse.xtext.Alternatives;
import org.eclipse.xtext.Assignment;
import org.eclipse.xtext.CrossReference;
import org.eclipse.xtext.EnumLiteralDeclaration;
import org.eclipse.xtext.EnumRule;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.Group;
import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.ParserRule;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.TerminalRule;
import org.eclipse.xtext.service.AbstractElementFinder.AbstractEnumRuleElementFinder;
import org.eclipse.xtext.service.AbstractElementFinder.AbstractGrammarElementFinder;
import org.eclipse.xtext.service.GrammarProvider;

@Singleton
public class AlfGrammarAccess extends AbstractGrammarElementFinder {
	
	public class PackageDefinitionElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.omg.sysml.Alf.PackageDefinition");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Keyword cPackageKeyword_0 = (Keyword)cGroup.eContents().get(0);
		private final Assignment cNameAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final RuleCall cNameNameParserRuleCall_1_0 = (RuleCall)cNameAssignment_1.eContents().get(0);
		private final Keyword cLeftCurlyBracketKeyword_2 = (Keyword)cGroup.eContents().get(2);
		private final Assignment cOwnedMemberAssignment_3 = (Assignment)cGroup.eContents().get(3);
		private final RuleCall cOwnedMemberPackagedElementParserRuleCall_3_0 = (RuleCall)cOwnedMemberAssignment_3.eContents().get(0);
		private final Keyword cRightCurlyBracketKeyword_4 = (Keyword)cGroup.eContents().get(4);
		
		///* PACKAGES */ PackageDefinition core::Container:
		//	'package' name=Name '{' ownedMember+=PackagedElement* '}';
		@Override public ParserRule getRule() { return rule; }
		
		//'package' name=Name '{' ownedMember+=PackagedElement* '}'
		public Group getGroup() { return cGroup; }
		
		//'package'
		public Keyword getPackageKeyword_0() { return cPackageKeyword_0; }
		
		//name=Name
		public Assignment getNameAssignment_1() { return cNameAssignment_1; }
		
		//Name
		public RuleCall getNameNameParserRuleCall_1_0() { return cNameNameParserRuleCall_1_0; }
		
		//'{'
		public Keyword getLeftCurlyBracketKeyword_2() { return cLeftCurlyBracketKeyword_2; }
		
		//ownedMember+=PackagedElement*
		public Assignment getOwnedMemberAssignment_3() { return cOwnedMemberAssignment_3; }
		
		//PackagedElement
		public RuleCall getOwnedMemberPackagedElementParserRuleCall_3_0() { return cOwnedMemberPackagedElementParserRuleCall_3_0; }
		
		//'}'
		public Keyword getRightCurlyBracketKeyword_4() { return cRightCurlyBracketKeyword_4; }
	}
	public class PackageDefinitionOrStubElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.omg.sysml.Alf.PackageDefinitionOrStub");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Assignment cPackageVisibilityAssignment_0 = (Assignment)cGroup.eContents().get(0);
		private final RuleCall cPackageVisibilityVisibilityKindEnumRuleCall_0_0 = (RuleCall)cPackageVisibilityAssignment_0.eContents().get(0);
		private final Keyword cPackageKeyword_1 = (Keyword)cGroup.eContents().get(1);
		private final Assignment cNameAssignment_2 = (Assignment)cGroup.eContents().get(2);
		private final RuleCall cNameNameParserRuleCall_2_0 = (RuleCall)cNameAssignment_2.eContents().get(0);
		private final Keyword cLeftCurlyBracketKeyword_3 = (Keyword)cGroup.eContents().get(3);
		private final Assignment cOwnedMemberAssignment_4 = (Assignment)cGroup.eContents().get(4);
		private final RuleCall cOwnedMemberPackagedElementParserRuleCall_4_0 = (RuleCall)cOwnedMemberAssignment_4.eContents().get(0);
		private final Keyword cRightCurlyBracketKeyword_5 = (Keyword)cGroup.eContents().get(5);
		
		//PackageDefinitionOrStub core::Container:
		//	packageVisibility=VisibilityKind 'package' name=Name
		//	'{' ownedMember+=PackagedElement* '}';
		@Override public ParserRule getRule() { return rule; }
		
		////	'package' name = Name ( isStub ?= ';' | '{' ( ownedMember += PackagedElement )* '}' )
		//packageVisibility=VisibilityKind 'package' name=Name '{' ownedMember+=PackagedElement* '}'
		public Group getGroup() { return cGroup; }
		
		////	'package' name = Name ( isStub ?= ';' | '{' ( ownedMember += PackagedElement )* '}' )
		//packageVisibility=VisibilityKind
		public Assignment getPackageVisibilityAssignment_0() { return cPackageVisibilityAssignment_0; }
		
		//VisibilityKind
		public RuleCall getPackageVisibilityVisibilityKindEnumRuleCall_0_0() { return cPackageVisibilityVisibilityKindEnumRuleCall_0_0; }
		
		//'package'
		public Keyword getPackageKeyword_1() { return cPackageKeyword_1; }
		
		//name=Name
		public Assignment getNameAssignment_2() { return cNameAssignment_2; }
		
		//Name
		public RuleCall getNameNameParserRuleCall_2_0() { return cNameNameParserRuleCall_2_0; }
		
		//'{'
		public Keyword getLeftCurlyBracketKeyword_3() { return cLeftCurlyBracketKeyword_3; }
		
		//ownedMember+=PackagedElement*
		public Assignment getOwnedMemberAssignment_4() { return cOwnedMemberAssignment_4; }
		
		//PackagedElement
		public RuleCall getOwnedMemberPackagedElementParserRuleCall_4_0() { return cOwnedMemberPackagedElementParserRuleCall_4_0; }
		
		//'}'
		public Keyword getRightCurlyBracketKeyword_5() { return cRightCurlyBracketKeyword_5; }
	}
	public class PackagedElementElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.omg.sysml.Alf.PackagedElement");
		private final RuleCall cPackagedElementDefinitionParserRuleCall = (RuleCall)rule.eContents().get(1);
		
		//PackagedElement core::ElementRecord:
		//	PackagedElementDefinition;
		@Override public ParserRule getRule() { return rule; }
		
		////  ( documentation += DOCUMENTATION_COMMENT )?
		////  ( annotation += StereotypeAnnotation )*
		////  visibility = ImportVisibilityIndicator 
		////	definition = PackagedElementDefinition
		//PackagedElementDefinition
		public RuleCall getPackagedElementDefinitionParserRuleCall() { return cPackagedElementDefinitionParserRuleCall; }
	}
	public class PackagedElementDefinitionElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.omg.sysml.Alf.PackagedElementDefinition");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final RuleCall cPackageDefinitionOrStubParserRuleCall_0 = (RuleCall)cAlternatives.eContents().get(0);
		private final RuleCall cClassifierDefinitionOrStubParserRuleCall_1 = (RuleCall)cAlternatives.eContents().get(1);
		
		//PackagedElementDefinition core::ElementRecord:
		//	PackageDefinitionOrStub | ClassifierDefinitionOrStub;
		@Override public ParserRule getRule() { return rule; }
		
		//PackageDefinitionOrStub | ClassifierDefinitionOrStub
		public Alternatives getAlternatives() { return cAlternatives; }
		
		//PackageDefinitionOrStub
		public RuleCall getPackageDefinitionOrStubParserRuleCall_0() { return cPackageDefinitionOrStubParserRuleCall_0; }
		
		//ClassifierDefinitionOrStub
		public RuleCall getClassifierDefinitionOrStubParserRuleCall_1() { return cClassifierDefinitionOrStubParserRuleCall_1; }
	}
	public class ClassifierDefinitionOrStubElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.omg.sysml.Alf.ClassifierDefinitionOrStub");
		private final RuleCall cClassDefinitionOrStubParserRuleCall = (RuleCall)rule.eContents().get(1);
		
		//ClassifierDefinitionOrStub str::Class:
		//	ClassDefinitionOrStub;
		@Override public ParserRule getRule() { return rule; }
		
		//ClassDefinitionOrStub
		public RuleCall getClassDefinitionOrStubParserRuleCall() { return cClassDefinitionOrStubParserRuleCall; }
	}
	public class ClassDeclarationElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.omg.sysml.Alf.ClassDeclaration");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Assignment cIsAbstractAssignment_0 = (Assignment)cGroup.eContents().get(0);
		private final Keyword cIsAbstractAbstractKeyword_0_0 = (Keyword)cIsAbstractAssignment_0.eContents().get(0);
		private final Keyword cClassKeyword_1 = (Keyword)cGroup.eContents().get(1);
		private final Assignment cNameAssignment_2 = (Assignment)cGroup.eContents().get(2);
		private final RuleCall cNameNameParserRuleCall_2_0 = (RuleCall)cNameAssignment_2.eContents().get(0);
		private final Group cGroup_3 = (Group)cGroup.eContents().get(3);
		private final Keyword cSpecializesKeyword_3_0 = (Keyword)cGroup_3.eContents().get(0);
		private final Assignment cGeneralizationAssignment_3_1 = (Assignment)cGroup_3.eContents().get(1);
		private final RuleCall cGeneralizationGeneralizationParserRuleCall_3_1_0 = (RuleCall)cGeneralizationAssignment_3_1.eContents().get(0);
		
		///* CLASSES */ ClassDeclaration str::Class:
		//	isAbstract?='abstract'? 'class' name=Name ('specializes' generalization+=Generalization+)?;
		@Override public ParserRule getRule() { return rule; }
		
		////	( 'namespace' namespace += [core::Container | QualifiedName] )?
		////	( ^import += ImportDeclaration )*
		//isAbstract?='abstract'? 'class' name=Name ('specializes' generalization+=Generalization+)?
		public Group getGroup() { return cGroup; }
		
		////	( 'namespace' namespace += [core::Container | QualifiedName] )?
		////	( ^import += ImportDeclaration )*
		//isAbstract?='abstract'?
		public Assignment getIsAbstractAssignment_0() { return cIsAbstractAssignment_0; }
		
		//'abstract'
		public Keyword getIsAbstractAbstractKeyword_0_0() { return cIsAbstractAbstractKeyword_0_0; }
		
		//'class'
		public Keyword getClassKeyword_1() { return cClassKeyword_1; }
		
		//name=Name
		public Assignment getNameAssignment_2() { return cNameAssignment_2; }
		
		//Name
		public RuleCall getNameNameParserRuleCall_2_0() { return cNameNameParserRuleCall_2_0; }
		
		//('specializes' generalization+=Generalization+)?
		public Group getGroup_3() { return cGroup_3; }
		
		//'specializes'
		public Keyword getSpecializesKeyword_3_0() { return cSpecializesKeyword_3_0; }
		
		//generalization+=Generalization+
		public Assignment getGeneralizationAssignment_3_1() { return cGeneralizationAssignment_3_1; }
		
		//Generalization
		public RuleCall getGeneralizationGeneralizationParserRuleCall_3_1_0() { return cGeneralizationGeneralizationParserRuleCall_3_1_0; }
	}
	public class GeneralizationElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.omg.sysml.Alf.Generalization");
		private final Assignment cGeneralAssignment = (Assignment)rule.eContents().get(1);
		private final CrossReference cGeneralClassCrossReference_0 = (CrossReference)cGeneralAssignment.eContents().get(0);
		private final RuleCall cGeneralClassQualifiedNameParserRuleCall_0_1 = (RuleCall)cGeneralClassCrossReference_0.eContents().get(1);
		
		////SpecializationClause returns QualifiedNameList : 
		////	'specializes' QualifiedNameList
		////;
		//Generalization str::Generalization:
		//	general=[str::Class|QualifiedName];
		@Override public ParserRule getRule() { return rule; }
		
		//general=[str::Class|QualifiedName]
		public Assignment getGeneralAssignment() { return cGeneralAssignment; }
		
		//[str::Class|QualifiedName]
		public CrossReference getGeneralClassCrossReference_0() { return cGeneralClassCrossReference_0; }
		
		//QualifiedName
		public RuleCall getGeneralClassQualifiedNameParserRuleCall_0_1() { return cGeneralClassQualifiedNameParserRuleCall_0_1; }
	}
	public class ClassDefinitionElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.omg.sysml.Alf.ClassDefinition");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final RuleCall cClassDeclarationParserRuleCall_0 = (RuleCall)cGroup.eContents().get(0);
		private final Keyword cLeftCurlyBracketKeyword_1 = (Keyword)cGroup.eContents().get(1);
		private final Assignment cOwnedFeatureAssignment_2 = (Assignment)cGroup.eContents().get(2);
		private final RuleCall cOwnedFeatureClassMemberParserRuleCall_2_0 = (RuleCall)cOwnedFeatureAssignment_2.eContents().get(0);
		private final Keyword cRightCurlyBracketKeyword_3 = (Keyword)cGroup.eContents().get(3);
		
		//ClassDefinition str::Class:
		//	ClassDeclaration
		//	'{' ownedFeature+=ClassMember* '}';
		@Override public ParserRule getRule() { return rule; }
		
		//ClassDeclaration '{' ownedFeature+=ClassMember* '}'
		public Group getGroup() { return cGroup; }
		
		//ClassDeclaration
		public RuleCall getClassDeclarationParserRuleCall_0() { return cClassDeclarationParserRuleCall_0; }
		
		//'{'
		public Keyword getLeftCurlyBracketKeyword_1() { return cLeftCurlyBracketKeyword_1; }
		
		//ownedFeature+=ClassMember*
		public Assignment getOwnedFeatureAssignment_2() { return cOwnedFeatureAssignment_2; }
		
		//ClassMember
		public RuleCall getOwnedFeatureClassMemberParserRuleCall_2_0() { return cOwnedFeatureClassMemberParserRuleCall_2_0; }
		
		//'}'
		public Keyword getRightCurlyBracketKeyword_3() { return cRightCurlyBracketKeyword_3; }
	}
	public class ClassDefinitionOrStubElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.omg.sysml.Alf.ClassDefinitionOrStub");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Assignment cPackageVisibilityAssignment_0 = (Assignment)cGroup.eContents().get(0);
		private final RuleCall cPackageVisibilityVisibilityKindEnumRuleCall_0_0 = (RuleCall)cPackageVisibilityAssignment_0.eContents().get(0);
		private final Assignment cIsAbstractAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final Keyword cIsAbstractAbstractKeyword_1_0 = (Keyword)cIsAbstractAssignment_1.eContents().get(0);
		private final Keyword cClassKeyword_2 = (Keyword)cGroup.eContents().get(2);
		private final Assignment cNameAssignment_3 = (Assignment)cGroup.eContents().get(3);
		private final RuleCall cNameNameParserRuleCall_3_0 = (RuleCall)cNameAssignment_3.eContents().get(0);
		private final Group cGroup_4 = (Group)cGroup.eContents().get(4);
		private final Keyword cSpecializesKeyword_4_0 = (Keyword)cGroup_4.eContents().get(0);
		private final Assignment cGeneralizationAssignment_4_1 = (Assignment)cGroup_4.eContents().get(1);
		private final RuleCall cGeneralizationGeneralizationParserRuleCall_4_1_0 = (RuleCall)cGeneralizationAssignment_4_1.eContents().get(0);
		private final Keyword cLeftCurlyBracketKeyword_5 = (Keyword)cGroup.eContents().get(5);
		private final Assignment cOwnedFeatureAssignment_6 = (Assignment)cGroup.eContents().get(6);
		private final RuleCall cOwnedFeatureClassMemberParserRuleCall_6_0 = (RuleCall)cOwnedFeatureAssignment_6.eContents().get(0);
		private final Keyword cRightCurlyBracketKeyword_7 = (Keyword)cGroup.eContents().get(7);
		
		//ClassDefinitionOrStub str::Class:
		//	packageVisibility=VisibilityKind isAbstract?='abstract'? 'class' name=Name ('specializes'
		//	generalization+=Generalization+)?
		//	'{' ownedFeature+=ClassMember* '}'
		//	//	ClassDeclaration
		//	//	( isStub ?= ';' | '{' ( ownedMember += ClassMember )* '}' )
		//;
		@Override public ParserRule getRule() { return rule; }
		
		//packageVisibility=VisibilityKind isAbstract?='abstract'? 'class' name=Name ('specializes'
		//generalization+=Generalization+)? '{' ownedFeature+=ClassMember* '}'
		public Group getGroup() { return cGroup; }
		
		//packageVisibility=VisibilityKind
		public Assignment getPackageVisibilityAssignment_0() { return cPackageVisibilityAssignment_0; }
		
		//VisibilityKind
		public RuleCall getPackageVisibilityVisibilityKindEnumRuleCall_0_0() { return cPackageVisibilityVisibilityKindEnumRuleCall_0_0; }
		
		//isAbstract?='abstract'?
		public Assignment getIsAbstractAssignment_1() { return cIsAbstractAssignment_1; }
		
		//'abstract'
		public Keyword getIsAbstractAbstractKeyword_1_0() { return cIsAbstractAbstractKeyword_1_0; }
		
		//'class'
		public Keyword getClassKeyword_2() { return cClassKeyword_2; }
		
		//name=Name
		public Assignment getNameAssignment_3() { return cNameAssignment_3; }
		
		//Name
		public RuleCall getNameNameParserRuleCall_3_0() { return cNameNameParserRuleCall_3_0; }
		
		//('specializes' generalization+=Generalization+)?
		public Group getGroup_4() { return cGroup_4; }
		
		//'specializes'
		public Keyword getSpecializesKeyword_4_0() { return cSpecializesKeyword_4_0; }
		
		//generalization+=Generalization+
		public Assignment getGeneralizationAssignment_4_1() { return cGeneralizationAssignment_4_1; }
		
		//Generalization
		public RuleCall getGeneralizationGeneralizationParserRuleCall_4_1_0() { return cGeneralizationGeneralizationParserRuleCall_4_1_0; }
		
		//'{'
		public Keyword getLeftCurlyBracketKeyword_5() { return cLeftCurlyBracketKeyword_5; }
		
		//ownedFeature+=ClassMember*
		public Assignment getOwnedFeatureAssignment_6() { return cOwnedFeatureAssignment_6; }
		
		//ClassMember
		public RuleCall getOwnedFeatureClassMemberParserRuleCall_6_0() { return cOwnedFeatureClassMemberParserRuleCall_6_0; }
		
		//'}'
		public Keyword getRightCurlyBracketKeyword_7() { return cRightCurlyBracketKeyword_7; }
	}
	public class ClassMemberElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.omg.sysml.Alf.ClassMember");
		private final RuleCall cFeatureDefinitionParserRuleCall = (RuleCall)rule.eContents().get(1);
		
		//ClassMember str::Feature:
		//	FeatureDefinition
		//	//	( documentation += DOCUMENTATION_COMMENT )?
		//	//	( annotation += StereotypeAnnotation )*
		//	//	( methodVisibility = VisibilityKind )?
		//	//	definition = ClassMemberDefinition
		//;
		@Override public ParserRule getRule() { return rule; }
		
		//FeatureDefinition
		public RuleCall getFeatureDefinitionParserRuleCall() { return cFeatureDefinitionParserRuleCall; }
	}
	public class FeatureDefinitionElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.omg.sysml.Alf.FeatureDefinition");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Assignment cMethodVisibilityAssignment_0 = (Assignment)cGroup.eContents().get(0);
		private final RuleCall cMethodVisibilityVisibilityKindEnumRuleCall_0_0 = (RuleCall)cMethodVisibilityAssignment_0.eContents().get(0);
		private final Assignment cNameAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final RuleCall cNameNameParserRuleCall_1_0 = (RuleCall)cNameAssignment_1.eContents().get(0);
		private final Keyword cColonKeyword_2 = (Keyword)cGroup.eContents().get(2);
		private final Assignment cTypeAssignment_3 = (Assignment)cGroup.eContents().get(3);
		private final CrossReference cTypeClassCrossReference_3_0 = (CrossReference)cTypeAssignment_3.eContents().get(0);
		private final RuleCall cTypeClassQualifiedNameParserRuleCall_3_0_1 = (RuleCall)cTypeClassCrossReference_3_0.eContents().get(1);
		private final Keyword cSemicolonKeyword_4 = (Keyword)cGroup.eContents().get(4);
		
		///* FEATURES */ FeatureDefinition str::Feature:
		//	methodVisibility=VisibilityKind? name=Name ':'
		//	// NOTE: Made type unidirectional; made definingType and refiningType optional.
		//	type+=[str::Class|QualifiedName]
		//	//	( '[' lower = NATURAL_VALUE '..' upper = NATURAL_VALUE ']' )?
		//	';';
		@Override public ParserRule getRule() { return rule; }
		
		//methodVisibility=VisibilityKind? name=Name ':' // NOTE: Made type unidirectional; made definingType and refiningType optional.
		//type+=[str::Class|QualifiedName] //	( '[' lower = NATURAL_VALUE '..' upper = NATURAL_VALUE ']' )?
		//';'
		public Group getGroup() { return cGroup; }
		
		//methodVisibility=VisibilityKind?
		public Assignment getMethodVisibilityAssignment_0() { return cMethodVisibilityAssignment_0; }
		
		//VisibilityKind
		public RuleCall getMethodVisibilityVisibilityKindEnumRuleCall_0_0() { return cMethodVisibilityVisibilityKindEnumRuleCall_0_0; }
		
		//name=Name
		public Assignment getNameAssignment_1() { return cNameAssignment_1; }
		
		//Name
		public RuleCall getNameNameParserRuleCall_1_0() { return cNameNameParserRuleCall_1_0; }
		
		//':'
		public Keyword getColonKeyword_2() { return cColonKeyword_2; }
		
		//// NOTE: Made type unidirectional; made definingType and refiningType optional.
		//type+=[str::Class|QualifiedName]
		public Assignment getTypeAssignment_3() { return cTypeAssignment_3; }
		
		//[str::Class|QualifiedName]
		public CrossReference getTypeClassCrossReference_3_0() { return cTypeClassCrossReference_3_0; }
		
		//QualifiedName
		public RuleCall getTypeClassQualifiedNameParserRuleCall_3_0_1() { return cTypeClassQualifiedNameParserRuleCall_3_0_1; }
		
		////	( '[' lower = NATURAL_VALUE '..' upper = NATURAL_VALUE ']' )?
		//';'
		public Keyword getSemicolonKeyword_4() { return cSemicolonKeyword_4; }
	}
	public class NameElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.omg.sysml.Alf.Name");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final RuleCall cIDTerminalRuleCall_0 = (RuleCall)cAlternatives.eContents().get(0);
		private final RuleCall cUNRESTRICTED_NAMETerminalRuleCall_1 = (RuleCall)cAlternatives.eContents().get(1);
		
		////FeatureDefinitionOrStub returns str::Feature : 
		////  AttributeDefinition /*| OperationDefinitionOrStub*/
		////;
		////
		/////* PROPERTIES */
		////PropertyDefinition returns str::Feature : 
		////	PropertyDeclaration ';'
		////;
		////
		////AttributeDefinition returns str::Feature : 
		////	PropertyDeclaration ( initializer = AttributeInitializer )? ';'
		////;
		////
		////AttributeInitializer returns Expression : 
		////	'=' InitializationExpression
		////;
		////
		////PropertyDeclaration returns PropertyDefinition : 
		////	name = Name ':' ( isComposite?='compose' )? 
		////	// CHANGE: Made TypedElementDefinition a composite part of PropertyDefinition instead of the supertype
		////	typePart = TypePart
		////;
		////
		////TypePart returns TypedElementDefinition :
		////  // CHANGE: Added isAny attribute to TypedElementDefinition to allow Xtext serialization.
		////  // CHANGE: Added isMultiplicity attribute to TypedElementDefinition.
		////  // CHANGE: Added isSequence attribute to TypedElementDefinition.
		////  ( isAny ?= 'any' | typeName = QualifiedName )
		////  ( ( '[' 
		////      ( isMultiplicity ?= ']' | 
		////        ( lowerBound = NATURAL_VALUE '..' )? upperBound = UnlimitedNaturalLiteral ']' 
		////      )
		////    )?
		////    ( isOrdered ?= 'ordered' ( isNonunique ?= 'nonunique' )? | 
		////      isNonunique ?='nonunique' ( isOrdered ?= 'ordered' )? | 
		////      isSequence ?= 'sequence'
		////    )?
		////  )?
		////;
		///***************
		//* NAMES        *
		//***************/ Name:
		//	ID | UNRESTRICTED_NAME;
		@Override public ParserRule getRule() { return rule; }
		
		//ID | UNRESTRICTED_NAME
		public Alternatives getAlternatives() { return cAlternatives; }
		
		//ID
		public RuleCall getIDTerminalRuleCall_0() { return cIDTerminalRuleCall_0; }
		
		//UNRESTRICTED_NAME
		public RuleCall getUNRESTRICTED_NAMETerminalRuleCall_1() { return cUNRESTRICTED_NAMETerminalRuleCall_1; }
	}
	public class QualifiedNameElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.omg.sysml.Alf.QualifiedName");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final RuleCall cNameParserRuleCall_0 = (RuleCall)cGroup.eContents().get(0);
		private final Group cGroup_1 = (Group)cGroup.eContents().get(1);
		private final Keyword cColonColonKeyword_1_0 = (Keyword)cGroup_1.eContents().get(0);
		private final RuleCall cNameParserRuleCall_1_1 = (RuleCall)cGroup_1.eContents().get(1);
		
		//QualifiedName:
		//	Name ('::' Name)*;
		@Override public ParserRule getRule() { return rule; }
		
		//Name ('::' Name)*
		public Group getGroup() { return cGroup; }
		
		//Name
		public RuleCall getNameParserRuleCall_0() { return cNameParserRuleCall_0; }
		
		//('::' Name)*
		public Group getGroup_1() { return cGroup_1; }
		
		//'::'
		public Keyword getColonColonKeyword_1_0() { return cColonColonKeyword_1_0; }
		
		//Name
		public RuleCall getNameParserRuleCall_1_1() { return cNameParserRuleCall_1_1; }
	}
	
	public class VisibilityKindElements extends AbstractEnumRuleElementFinder {
		private final EnumRule rule = (EnumRule) GrammarUtil.findRuleForName(getGrammar(), "org.omg.sysml.Alf.VisibilityKind");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final EnumLiteralDeclaration cPublicEnumLiteralDeclaration_0 = (EnumLiteralDeclaration)cAlternatives.eContents().get(0);
		private final Keyword cPublicPublicKeyword_0_0 = (Keyword)cPublicEnumLiteralDeclaration_0.eContents().get(0);
		private final EnumLiteralDeclaration cPrivateEnumLiteralDeclaration_1 = (EnumLiteralDeclaration)cAlternatives.eContents().get(1);
		private final Keyword cPrivatePrivateKeyword_1_0 = (Keyword)cPrivateEnumLiteralDeclaration_1.eContents().get(0);
		private final EnumLiteralDeclaration cProtectedEnumLiteralDeclaration_2 = (EnumLiteralDeclaration)cAlternatives.eContents().get(2);
		private final Keyword cProtectedProtectedKeyword_2_0 = (Keyword)cProtectedEnumLiteralDeclaration_2.eContents().get(0);
		
		//enum VisibilityKind returns core::visibilityKind:
		//	public | private | protected;
		public EnumRule getRule() { return rule; }
		
		//public | private | protected
		public Alternatives getAlternatives() { return cAlternatives; }
		
		//public
		public EnumLiteralDeclaration getPublicEnumLiteralDeclaration_0() { return cPublicEnumLiteralDeclaration_0; }
		
		//'public'
		public Keyword getPublicPublicKeyword_0_0() { return cPublicPublicKeyword_0_0; }
		
		//private
		public EnumLiteralDeclaration getPrivateEnumLiteralDeclaration_1() { return cPrivateEnumLiteralDeclaration_1; }
		
		//'private'
		public Keyword getPrivatePrivateKeyword_1_0() { return cPrivatePrivateKeyword_1_0; }
		
		//protected
		public EnumLiteralDeclaration getProtectedEnumLiteralDeclaration_2() { return cProtectedEnumLiteralDeclaration_2; }
		
		//'protected'
		public Keyword getProtectedProtectedKeyword_2_0() { return cProtectedProtectedKeyword_2_0; }
	}
	
	private final PackageDefinitionElements pPackageDefinition;
	private final PackageDefinitionOrStubElements pPackageDefinitionOrStub;
	private final PackagedElementElements pPackagedElement;
	private final PackagedElementDefinitionElements pPackagedElementDefinition;
	private final ClassifierDefinitionOrStubElements pClassifierDefinitionOrStub;
	private final ClassDeclarationElements pClassDeclaration;
	private final GeneralizationElements pGeneralization;
	private final ClassDefinitionElements pClassDefinition;
	private final ClassDefinitionOrStubElements pClassDefinitionOrStub;
	private final ClassMemberElements pClassMember;
	private final VisibilityKindElements eVisibilityKind;
	private final FeatureDefinitionElements pFeatureDefinition;
	private final NameElements pName;
	private final QualifiedNameElements pQualifiedName;
	private final TerminalRule tBOOLEAN_VALUE;
	private final TerminalRule tNATURAL_VALUE;
	private final TerminalRule tID;
	private final TerminalRule tUNRESTRICTED_NAME;
	private final TerminalRule tSTRING;
	private final TerminalRule tDOCUMENTATION_COMMENT;
	private final TerminalRule tSTATEMENT_ANNOTATION;
	private final TerminalRule tINLINE_STATEMENT;
	private final TerminalRule tML_COMMENT;
	private final TerminalRule tSL_COMMENT;
	private final TerminalRule tWS;
	
	private final Grammar grammar;

	@Inject
	public AlfGrammarAccess(GrammarProvider grammarProvider) {
		this.grammar = internalFindGrammar(grammarProvider);
		this.pPackageDefinition = new PackageDefinitionElements();
		this.pPackageDefinitionOrStub = new PackageDefinitionOrStubElements();
		this.pPackagedElement = new PackagedElementElements();
		this.pPackagedElementDefinition = new PackagedElementDefinitionElements();
		this.pClassifierDefinitionOrStub = new ClassifierDefinitionOrStubElements();
		this.pClassDeclaration = new ClassDeclarationElements();
		this.pGeneralization = new GeneralizationElements();
		this.pClassDefinition = new ClassDefinitionElements();
		this.pClassDefinitionOrStub = new ClassDefinitionOrStubElements();
		this.pClassMember = new ClassMemberElements();
		this.eVisibilityKind = new VisibilityKindElements();
		this.pFeatureDefinition = new FeatureDefinitionElements();
		this.pName = new NameElements();
		this.pQualifiedName = new QualifiedNameElements();
		this.tBOOLEAN_VALUE = (TerminalRule) GrammarUtil.findRuleForName(getGrammar(), "org.omg.sysml.Alf.BOOLEAN_VALUE");
		this.tNATURAL_VALUE = (TerminalRule) GrammarUtil.findRuleForName(getGrammar(), "org.omg.sysml.Alf.NATURAL_VALUE");
		this.tID = (TerminalRule) GrammarUtil.findRuleForName(getGrammar(), "org.omg.sysml.Alf.ID");
		this.tUNRESTRICTED_NAME = (TerminalRule) GrammarUtil.findRuleForName(getGrammar(), "org.omg.sysml.Alf.UNRESTRICTED_NAME");
		this.tSTRING = (TerminalRule) GrammarUtil.findRuleForName(getGrammar(), "org.omg.sysml.Alf.STRING");
		this.tDOCUMENTATION_COMMENT = (TerminalRule) GrammarUtil.findRuleForName(getGrammar(), "org.omg.sysml.Alf.DOCUMENTATION_COMMENT");
		this.tSTATEMENT_ANNOTATION = (TerminalRule) GrammarUtil.findRuleForName(getGrammar(), "org.omg.sysml.Alf.STATEMENT_ANNOTATION");
		this.tINLINE_STATEMENT = (TerminalRule) GrammarUtil.findRuleForName(getGrammar(), "org.omg.sysml.Alf.INLINE_STATEMENT");
		this.tML_COMMENT = (TerminalRule) GrammarUtil.findRuleForName(getGrammar(), "org.omg.sysml.Alf.ML_COMMENT");
		this.tSL_COMMENT = (TerminalRule) GrammarUtil.findRuleForName(getGrammar(), "org.omg.sysml.Alf.SL_COMMENT");
		this.tWS = (TerminalRule) GrammarUtil.findRuleForName(getGrammar(), "org.omg.sysml.Alf.WS");
	}
	
	protected Grammar internalFindGrammar(GrammarProvider grammarProvider) {
		Grammar grammar = grammarProvider.getGrammar(this);
		while (grammar != null) {
			if ("org.omg.sysml.Alf".equals(grammar.getName())) {
				return grammar;
			}
			List<Grammar> grammars = grammar.getUsedGrammars();
			if (!grammars.isEmpty()) {
				grammar = grammars.iterator().next();
			} else {
				return null;
			}
		}
		return grammar;
	}
	
	@Override
	public Grammar getGrammar() {
		return grammar;
	}
	

	
	///* PACKAGES */ PackageDefinition core::Container:
	//	'package' name=Name '{' ownedMember+=PackagedElement* '}';
	public PackageDefinitionElements getPackageDefinitionAccess() {
		return pPackageDefinition;
	}
	
	public ParserRule getPackageDefinitionRule() {
		return getPackageDefinitionAccess().getRule();
	}
	
	//PackageDefinitionOrStub core::Container:
	//	packageVisibility=VisibilityKind 'package' name=Name
	//	'{' ownedMember+=PackagedElement* '}';
	public PackageDefinitionOrStubElements getPackageDefinitionOrStubAccess() {
		return pPackageDefinitionOrStub;
	}
	
	public ParserRule getPackageDefinitionOrStubRule() {
		return getPackageDefinitionOrStubAccess().getRule();
	}
	
	//PackagedElement core::ElementRecord:
	//	PackagedElementDefinition;
	public PackagedElementElements getPackagedElementAccess() {
		return pPackagedElement;
	}
	
	public ParserRule getPackagedElementRule() {
		return getPackagedElementAccess().getRule();
	}
	
	//PackagedElementDefinition core::ElementRecord:
	//	PackageDefinitionOrStub | ClassifierDefinitionOrStub;
	public PackagedElementDefinitionElements getPackagedElementDefinitionAccess() {
		return pPackagedElementDefinition;
	}
	
	public ParserRule getPackagedElementDefinitionRule() {
		return getPackagedElementDefinitionAccess().getRule();
	}
	
	//ClassifierDefinitionOrStub str::Class:
	//	ClassDefinitionOrStub;
	public ClassifierDefinitionOrStubElements getClassifierDefinitionOrStubAccess() {
		return pClassifierDefinitionOrStub;
	}
	
	public ParserRule getClassifierDefinitionOrStubRule() {
		return getClassifierDefinitionOrStubAccess().getRule();
	}
	
	///* CLASSES */ ClassDeclaration str::Class:
	//	isAbstract?='abstract'? 'class' name=Name ('specializes' generalization+=Generalization+)?;
	public ClassDeclarationElements getClassDeclarationAccess() {
		return pClassDeclaration;
	}
	
	public ParserRule getClassDeclarationRule() {
		return getClassDeclarationAccess().getRule();
	}
	
	////SpecializationClause returns QualifiedNameList : 
	////	'specializes' QualifiedNameList
	////;
	//Generalization str::Generalization:
	//	general=[str::Class|QualifiedName];
	public GeneralizationElements getGeneralizationAccess() {
		return pGeneralization;
	}
	
	public ParserRule getGeneralizationRule() {
		return getGeneralizationAccess().getRule();
	}
	
	//ClassDefinition str::Class:
	//	ClassDeclaration
	//	'{' ownedFeature+=ClassMember* '}';
	public ClassDefinitionElements getClassDefinitionAccess() {
		return pClassDefinition;
	}
	
	public ParserRule getClassDefinitionRule() {
		return getClassDefinitionAccess().getRule();
	}
	
	//ClassDefinitionOrStub str::Class:
	//	packageVisibility=VisibilityKind isAbstract?='abstract'? 'class' name=Name ('specializes'
	//	generalization+=Generalization+)?
	//	'{' ownedFeature+=ClassMember* '}'
	//	//	ClassDeclaration
	//	//	( isStub ?= ';' | '{' ( ownedMember += ClassMember )* '}' )
	//;
	public ClassDefinitionOrStubElements getClassDefinitionOrStubAccess() {
		return pClassDefinitionOrStub;
	}
	
	public ParserRule getClassDefinitionOrStubRule() {
		return getClassDefinitionOrStubAccess().getRule();
	}
	
	//ClassMember str::Feature:
	//	FeatureDefinition
	//	//	( documentation += DOCUMENTATION_COMMENT )?
	//	//	( annotation += StereotypeAnnotation )*
	//	//	( methodVisibility = VisibilityKind )?
	//	//	definition = ClassMemberDefinition
	//;
	public ClassMemberElements getClassMemberAccess() {
		return pClassMember;
	}
	
	public ParserRule getClassMemberRule() {
		return getClassMemberAccess().getRule();
	}
	
	//enum VisibilityKind returns core::visibilityKind:
	//	public | private | protected;
	public VisibilityKindElements getVisibilityKindAccess() {
		return eVisibilityKind;
	}
	
	public EnumRule getVisibilityKindRule() {
		return getVisibilityKindAccess().getRule();
	}
	
	///* FEATURES */ FeatureDefinition str::Feature:
	//	methodVisibility=VisibilityKind? name=Name ':'
	//	// NOTE: Made type unidirectional; made definingType and refiningType optional.
	//	type+=[str::Class|QualifiedName]
	//	//	( '[' lower = NATURAL_VALUE '..' upper = NATURAL_VALUE ']' )?
	//	';';
	public FeatureDefinitionElements getFeatureDefinitionAccess() {
		return pFeatureDefinition;
	}
	
	public ParserRule getFeatureDefinitionRule() {
		return getFeatureDefinitionAccess().getRule();
	}
	
	////FeatureDefinitionOrStub returns str::Feature : 
	////  AttributeDefinition /*| OperationDefinitionOrStub*/
	////;
	////
	/////* PROPERTIES */
	////PropertyDefinition returns str::Feature : 
	////	PropertyDeclaration ';'
	////;
	////
	////AttributeDefinition returns str::Feature : 
	////	PropertyDeclaration ( initializer = AttributeInitializer )? ';'
	////;
	////
	////AttributeInitializer returns Expression : 
	////	'=' InitializationExpression
	////;
	////
	////PropertyDeclaration returns PropertyDefinition : 
	////	name = Name ':' ( isComposite?='compose' )? 
	////	// CHANGE: Made TypedElementDefinition a composite part of PropertyDefinition instead of the supertype
	////	typePart = TypePart
	////;
	////
	////TypePart returns TypedElementDefinition :
	////  // CHANGE: Added isAny attribute to TypedElementDefinition to allow Xtext serialization.
	////  // CHANGE: Added isMultiplicity attribute to TypedElementDefinition.
	////  // CHANGE: Added isSequence attribute to TypedElementDefinition.
	////  ( isAny ?= 'any' | typeName = QualifiedName )
	////  ( ( '[' 
	////      ( isMultiplicity ?= ']' | 
	////        ( lowerBound = NATURAL_VALUE '..' )? upperBound = UnlimitedNaturalLiteral ']' 
	////      )
	////    )?
	////    ( isOrdered ?= 'ordered' ( isNonunique ?= 'nonunique' )? | 
	////      isNonunique ?='nonunique' ( isOrdered ?= 'ordered' )? | 
	////      isSequence ?= 'sequence'
	////    )?
	////  )?
	////;
	///***************
	//* NAMES        *
	//***************/ Name:
	//	ID | UNRESTRICTED_NAME;
	public NameElements getNameAccess() {
		return pName;
	}
	
	public ParserRule getNameRule() {
		return getNameAccess().getRule();
	}
	
	//QualifiedName:
	//	Name ('::' Name)*;
	public QualifiedNameElements getQualifiedNameAccess() {
		return pQualifiedName;
	}
	
	public ParserRule getQualifiedNameRule() {
		return getQualifiedNameAccess().getRule();
	}
	
	//terminal BOOLEAN_VALUE:
	//	'true' | 'false';
	public TerminalRule getBOOLEAN_VALUERule() {
		return tBOOLEAN_VALUE;
	}
	
	//terminal NATURAL_VALUE:
	//	('0' | '1'..'9' ('_'? '0'..'9')*) | ('0b' | '0B') '0'..'1' ('_'? '0'..'1')* | ('0x' | '0X') ('0'..'9' | 'a'..'f' |
	//	'A'..'F') ('_'? ('0'..'9' | 'a'..'f' | 'A'..'F'))* | '0' '_'? '0'..'7' ('_'? '0'..'7')*;
	public TerminalRule getNATURAL_VALUERule() {
		return tNATURAL_VALUE;
	}
	
	//terminal ID:
	//	('a'..'z' | 'A'..'Z' | '_') ('a'..'z' | 'A'..'Z' | '_' | '0'..'9')*;
	public TerminalRule getIDRule() {
		return tID;
	}
	
	//terminal UNRESTRICTED_NAME:
	//	'\'' ('\\' ('b' | 't' | 'n' | 'f' | 'r' | '"' | "'" | '\\') | !('\\' | '\''))* '\'';
	public TerminalRule getUNRESTRICTED_NAMERule() {
		return tUNRESTRICTED_NAME;
	}
	
	//terminal STRING:
	//	'"' ('\\' ('b' | 't' | 'n' | 'f' | 'r' | '"' | "'" | '\\') | !('\\' | '"'))* '"';
	public TerminalRule getSTRINGRule() {
		return tSTRING;
	}
	
	//terminal DOCUMENTATION_COMMENT:
	//	'/**'->'*/';
	public TerminalRule getDOCUMENTATION_COMMENTRule() {
		return tDOCUMENTATION_COMMENT;
	}
	
	//terminal STATEMENT_ANNOTATION:
	//	'//@'->'\n'
	//	//  '//@' WS? ID (WS? '(' WS? (ID | UNRESTRICTED_NAME) (WS? ',' WS? (ID | UNRESTRICTED_NAME))* WS? ')')? 
	//	//  (WS? '@' WS? ID (WS? '(' WS? (ID | UNRESTRICTED_NAME) (WS? ',' WS? (ID | UNRESTRICTED_NAME))* WS? ')')?)* (' '|'\t')* ('\r'? '\n')
	//;
	public TerminalRule getSTATEMENT_ANNOTATIONRule() {
		return tSTATEMENT_ANNOTATION;
	}
	
	//terminal INLINE_STATEMENT:
	//	'/*@inline(' (ID | UNRESTRICTED_NAME) ')'->'*/';
	public TerminalRule getINLINE_STATEMENTRule() {
		return tINLINE_STATEMENT;
	}
	
	//terminal ML_COMMENT:
	//	'/*' !('*' | '@')->'*/';
	public TerminalRule getML_COMMENTRule() {
		return tML_COMMENT;
	}
	
	//terminal SL_COMMENT:
	//	'//' (!('@' | '\n' | '\r') !('\n' | '\r')*)? ('\r'? '\n')?;
	public TerminalRule getSL_COMMENTRule() {
		return tSL_COMMENT;
	}
	
	//terminal WS:
	//	' ' | '\t' | '\r' | '\n'+;
	public TerminalRule getWSRule() {
		return tWS;
	}
}
