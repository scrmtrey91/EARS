package org.um.feri.ears.experiment.ee.so;

import org.um.feri.ears.algorithms.AlgorithmInfo;
import org.um.feri.ears.algorithms.Author;

import java.util.ArrayList;
import java.util.List;

import org.um.feri.ears.algorithms.Algorithm;
import org.um.feri.ears.problems.DoubleSolution;
import org.um.feri.ears.problems.StopCriteriaException;
import org.um.feri.ears.problems.Task;

/**
 * Used to demonstrate simple implementation
 * <p>
 * 
 * @author Matej Crepinsek
 * @version 1
 * 
 *          <h3>License</h3>
 * 
 *          Copyright (c) 2011 by Matej Crepinsek. <br>
 *          All rights reserved. <br>
 * 
 *          <p>
 *          Redistribution and use in source and binary forms, with or without
 *          modification, are permitted provided that the following conditions
 *          are met:
 *          <ul>
 *          <li>Redistributions of source code must retain the above copyright
 *          notice, this list of conditions and the following disclaimer.
 *          <li>Redistributions in binary form must reproduce the above
 *          copyright notice, this list of conditions and the following
 *          disclaimer in the documentation and/or other materials provided with
 *          the distribution.
 *          <li>Neither the name of the copyright owners, their employers, nor
 *          the names of its contributors may be used to endorse or promote
 *          products derived from this software without specific prior written
 *          permission.
 *          </ul>
 *          <p>
 *          THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
 *          "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT
 *          LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS
 *          FOR A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE
 *          COPYRIGHT OWNERS OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT,
 *          INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING,
 *          BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
 *          LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER
 *          CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT
 *          LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN
 *          ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE
 *          POSSIBILITY OF SUCH DAMAGE.
 * 
 */
public class RandomWalkAlgorithmLogging extends Algorithm {
	DoubleSolution i;
	Task task;
	
	boolean debug=false;
	public RandomWalkAlgorithmLogging() {
		this.debug = false;
		ai = new AlgorithmInfo("RWSi","","RWSi","Random Walk Simple");
		au =  new Author("matej", "matej.crepinsek at uni-mb.si");
	}
	public RandomWalkAlgorithmLogging(boolean d) {
	    this();
		setDebug(d); 
	}
	
	@Override
	public DoubleSolution execute(Task taskProblem) throws StopCriteriaException {
		task = taskProblem;
		DoubleSolution ii;
		i = taskProblem.getRandomSolution();
		if (debug)
			System.out.println(taskProblem.getNumberOfEvaluations() + " " + i);
		while (!taskProblem.isStopCriteria()) {
			List<DoubleSolution> parents = new ArrayList<DoubleSolution>();
			ii = taskProblem.getRandomSolution();
			parents.add(i);
			taskProblem.addAncestors(ii, parents);
			if (taskProblem.isFirstBetter(ii, i)) {
				i = ii;
				if (debug)
					System.out.println(taskProblem.getNumberOfEvaluations() + " " + i);
			}
			task.incrementNumberOfIterations();
		}
		return i;

	}

    @Override
    public void resetDefaultsBeforNewRun() {
        i=null;
        
    }

}
