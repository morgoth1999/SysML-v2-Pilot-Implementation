/*******************************************************************************
 * SysML 2 Pilot Implementation
 * Copyright (c) 2022 Model Driven Solutions, Inc.
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
 * You should have received a copy of the GNU Lesser General Public License
 * along with this program.  If not, see <https://www.gnu.org/licenses/>.
 *  
 * @license LGPL-3.0-or-later <http://spdx.org/licenses/LGPL-3.0-or-later>
 *  
 *******************************************************************************/

package org.omg.sysml.execution.expressions;

import org.eclipse.emf.common.util.EList;
import org.omg.sysml.expressions.ModelLevelExpressionEvaluator;
import org.omg.sysml.expressions.util.EvaluationUtil;
import org.omg.sysml.lang.sysml.Element;
import org.omg.sysml.lang.sysml.Expression;
import org.omg.sysml.lang.sysml.Feature;
import org.omg.sysml.lang.sysml.FeatureTyping;
import org.omg.sysml.lang.sysml.Function;
import org.omg.sysml.lang.sysml.InvocationExpression;
import org.omg.sysml.lang.sysml.Type;
import org.omg.sysml.util.ExpressionUtil;
import org.omg.sysml.util.FeatureUtil;
import org.omg.sysml.util.TypeUtil;

public class ExpressionEvaluator extends ModelLevelExpressionEvaluator {
	
	public static final ExpressionEvaluator INSTANCE = new ExpressionEvaluator();
	
	@Override
	public EList<Element> evaluateInvocation(InvocationExpression expression, Element target) {
		Function function = expression.getFunction();
		if (function != null && function.isModelLevelEvaluable()) {
			return super.evaluateInvocation(expression, target);
		} else {
			Type type = expression.getOwnedTyping().stream().map(FeatureTyping::getType).findFirst().orElse(null);
			Expression resultExpression = ExpressionUtil.getResultExpressionOf(type);
			if (resultExpression == null) {
				Feature resultParameter = TypeUtil.getResultParameterOf(type);
				if (resultParameter != null) {
					resultExpression = FeatureUtil.getValueExpressionFor(resultParameter);
				}
			}
			if (resultExpression == null) {
				return EvaluationUtil.singletonList(expression);
			} else {
				Feature targetFeature = EvaluationUtil.getTargetFeatureFor(target);
				if (type instanceof Feature) {
					targetFeature = FeatureUtil.chainFeatures(targetFeature, (Feature)type);
				}
				EList<Element> results = evaluate(resultExpression, FeatureUtil.chainFeatures(targetFeature, expression));
				return results == null? EvaluationUtil.singletonList(resultExpression): results;
			}
		}
	}
	
}
