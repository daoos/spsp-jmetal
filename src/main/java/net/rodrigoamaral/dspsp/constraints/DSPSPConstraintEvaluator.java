package net.rodrigoamaral.dspsp.constraints;

import net.rodrigoamaral.dspsp.project.DynamicProject;
import net.rodrigoamaral.dspsp.solution.DedicationMatrix;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * Encapsulates the collection of all constraints ({@link IConstraint})
 * of a given SPSP formulation.
 *
 * @author Rodrigo Amaral
 *
 */
public class DSPSPConstraintEvaluator implements IConstraintEvaluator {
    private List<IConstraint> constraints;

    public DSPSPConstraintEvaluator() {
        constraints = new ArrayList<>();
    }

    @Override
    public IConstraintEvaluator addConstraint(IConstraint constraint) {
        constraints.add(constraint);
        return this;
    }

    @Override
    public int size() {
        return constraints.size();
    }

    @Override
    public DedicationMatrix repair(DedicationMatrix dm, DynamicProject project) {
        for (IConstraint c: constraints) {
            dm = c.repair(dm, project);
        }

        return dm;
    }

}
