package org.um.feri.ears.problems.unconstrained.cec2010;

import java.util.List;

import org.apache.commons.lang3.ArrayUtils;
import org.ejml.data.DenseMatrix64F;
import org.ejml.ops.RandomMatrices;
import org.um.feri.ears.problems.unconstrained.cec.Functions;
import org.um.feri.ears.util.Util;

public class F11 extends CEC2010{
	
	public F11(int d) {
		super(d, 11);
		
		name = "F11 D/2m-group Shifted and m-rotated Ackley's Function";
		
		P = new int[numberOfDimensions];
		P = Util.randomPermutation(numberOfDimensions);
		OShift = new double[numberOfDimensions];

		for (int i=0; i<numberOfDimensions; i++){
			OShift[i] = Util.nextDouble(lowerLimit.get(i),upperLimit.get(i));
		}
		
		M = new double[m*m];
		
		DenseMatrix64F A = RandomMatrices.createOrthogonal(m, m, Util.rnd);
		
		for (int i=0; i<m; i++){
			for (int j=0; j<m; j++){
				M[i * m + j] = A.get(i, j);
			}
		}
	}

	@Override
	public double eval(Double[] ds) {
		return eval(ArrayUtils.toPrimitive(ds));
	}
	
	public double eval(double x[]) {
		double F = 0;
		int max = (numberOfDimensions / (m << 1));
		int from, to;
		int from2 = numberOfDimensions / 2;
		
		double[] p1;
		double[] s1;
		
		double[] p2 = getPermutatedIndices(x,P,from2,numberOfDimensions - from2);
		double[] s2 = getPermutatedIndices(OShift,P,from2,numberOfDimensions - from2);

		for (int k = 0; k < max; k++) {
			from = k*m;
			to = (k+1)*m - 1;
			p1 = getPermutatedIndices(x,P,from,to-from);
			s1 = getPermutatedIndices(OShift,P,from,to-from);
			F += Functions.ackley_func(p1, to-from, s1, M, 1, 1);
		}
		
		F += Functions.ackley_func(p2, numberOfDimensions - from2, s2, M, 1, 0);
		
		return F;
	}

}
