/*
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 2 of the License, or
 * (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 675 Mass Ave, Cambridge, MA 02139, USA.
 */

/*
 * NaiveBayes.java
 * Copyright (C) 2004 Remco Bouckaert
 * 
 */
package weka.classifiers.bayes.net.search.fixed;

import weka.classifiers.bayes.net.search.SearchAlgorithm;
import weka.classifiers.bayes.BayesNet;
import weka.core.Instances;

/** The NaiveBayes class generates a fixed Bayes network structure
 * with arrows from the class variable to each of the attribute variables.
 * 
 * @author Remco Bouckaert
 * @version $Revision: 1.2 $
 */
public class NaiveBayes extends SearchAlgorithm {
	
	public void buildStructure (BayesNet bayesNet, Instances instances) throws Exception {
        for (int iAttribute = 0; iAttribute < instances.numAttributes(); iAttribute++) {
        	if (iAttribute != instances.classIndex()) {
        		bayesNet.getParentSet(iAttribute).addParent(instances.classIndex(), instances);
        	}
        }
	} // buildStructure
	
} // class NaiveBayes
