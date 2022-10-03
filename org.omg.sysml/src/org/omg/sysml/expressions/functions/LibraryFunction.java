/*******************************************************************************
 * SysML 2 Pilot Implementation
 * Copyright (c) 2021-2022 Model Driven Solutions, Inc.
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
package org.omg.sysml.expressions.functions;

import org.eclipse.emf.common.util.EList;
import org.omg.sysml.expressions.ModelLevelExpressionEvaluator;
import org.omg.sysml.lang.sysml.Element;
import org.omg.sysml.lang.sysml.InvocationExpression;

public interface LibraryFunction {
	
	public default boolean isModelLevelEvaluable() {
		return true;
	}
	
	abstract public String getPackageName();

	public default String getOperatorName() {
		return null;
	}
	
	public default String[] getOperatorNames() {
		String op = getOperatorName();
		return op == null? new String[] {}: new String[] {op};
	}
	
	public default String[] getFunctionNames() {
		String[] names = getOperatorNames();
		for (int i = 0; i < names.length; i++) {
			names[i] = getPackageName() + "::" + names[i];
		}
		return names;
	}
	
	public EList<Element> invoke(InvocationExpression invocation, Element target, ModelLevelExpressionEvaluator evaluator);

}
