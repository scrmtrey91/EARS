package org.um.feri.ears.benchmark;

import org.um.feri.ears.algorithms.MOAlgorithm;
import org.um.feri.ears.problems.moo.ParetoSolution;

public class MOAlgorithmEvalResult {
	private ParetoSolution best;
    private MOAlgorithm al;
    private boolean evaluated = false;
    public MOAlgorithmEvalResult(ParetoSolution best, MOAlgorithm al) {
        super();
        this.best = best;
        this.al = al;
    }
    public ParetoSolution getBest() {
        return best;
    }
    public void setBest(ParetoSolution best) {
        this.best = best;
    }
    public MOAlgorithm getAl() {
        return al;
    }
    public void setAl(MOAlgorithm al) {
        this.al = al;
    }
	public boolean isEvaluated() {
		return evaluated;
	}
	public void setEvaluated(boolean evaluated) {
		this.evaluated = evaluated;
	}
    
    
}
