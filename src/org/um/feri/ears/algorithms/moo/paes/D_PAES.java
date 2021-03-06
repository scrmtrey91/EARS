package org.um.feri.ears.algorithms.moo.paes;

import org.um.feri.ears.operators.MutationOperator;
import org.um.feri.ears.operators.PolynomialMutation;
import org.um.feri.ears.problems.DoubleMOTask;
import org.um.feri.ears.problems.StopCriteriaException;

public class D_PAES extends PAES<DoubleMOTask, Double> {
	
	public D_PAES() {
		this(new PolynomialMutation(1.0 / 10, 20.0), 100);
	}
	
	public D_PAES(int populationSize) {
		this(new PolynomialMutation(1.0 / 10, 20.0), populationSize);
	}

	public D_PAES(MutationOperator mutation, int populationSize) {
		super(mutation, populationSize);
	}

	@Override
	public void start() throws StopCriteriaException {
		super.start();
		mut.setProbability(1.0 / num_var);
	}
	
}
