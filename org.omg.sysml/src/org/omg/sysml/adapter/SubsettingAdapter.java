/*******************************************************************************
 * SysML 2 Pilot Implementation
 * Copyright (c) 2024 Model Driven Solutions, Inc.
 * Copyright (c) 2024 Budapest University of Technology and Economics
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

package org.omg.sysml.adapter;

import org.eclipse.emf.common.util.EList;
import org.omg.sysml.lang.sysml.Element;
import org.omg.sysml.lang.sysml.Feature;
import org.omg.sysml.lang.sysml.Subsetting;
import org.omg.sysml.lang.sysml.SysMLPackage;

public class SubsettingAdapter extends SpecializationAdapter {

	public SubsettingAdapter(Subsetting element) {
		super(element);
	}
	
	@Override
	public Subsetting getTarget() {
		return (Subsetting)super.getTarget();
	}
	
	@Override
	public void postProcess() {
		Subsetting obj = getTarget();
		
		// If the subsettedFeature is empty, then set it to the last ownedRelatedElement
		// (which will be a Feature chain).
		Object subsettedFeature = obj.eGet(SysMLPackage.Literals.SUBSETTING__SUBSETTED_FEATURE, false);
		if (subsettedFeature == null) {
			EList<Element> ownedRelatedElements = obj.getOwnedRelatedElement();
			if (!ownedRelatedElements.isEmpty()) {
				obj.setSubsettedFeature((Feature)ownedRelatedElements.get(ownedRelatedElements.size() - 1));
			}
		}
		
		// If the subsettingFeature is empty, then set it to the owningRelatedFeature, if this is a Feature.
		// Otherwise set it to the first ownedRelatedElement (which will be a Feature chain).
		Object subsettingFeature = obj.eGet(SysMLPackage.Literals.SUBSETTING__SUBSETTING_FEATURE, false);
		if (subsettingFeature == null) {
			Element owner = obj.getOwningRelatedElement();
			if (owner instanceof Feature) {
				obj.setSubsettingFeature((Feature) owner);
			} else {
				EList<Element> ownedRelatedElements = obj.getOwnedRelatedElement();
				if (!ownedRelatedElements.isEmpty()) {
					obj.setSubsettingFeature((Feature)ownedRelatedElements.get(0));
				}
			}
		}
	}
	
}
