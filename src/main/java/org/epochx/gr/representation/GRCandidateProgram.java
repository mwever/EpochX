/*
 * Copyright 2007-2011 Tom Castle & Lawrence Beadle
 * Licensed under GNU Lesser General Public License
 *
 * This file is part of EpochX: genetic programming software for research
 *
 * EpochX is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * EpochX is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with EpochX. If not, see <http://www.gnu.org/licenses/>.
 *
 * The latest version is available from: http://www.epochx.org
 */
package org.epochx.gr.representation;

import org.epochx.gr.model.GRModel;
import org.epochx.representation.CandidateProgram;
import org.epochx.tools.grammar.NonTerminalSymbol;

/**
 * <p>
 * Note: this class has a natural ordering that is inconsistent with equals.
 */
public class GRCandidateProgram extends CandidateProgram {

	private GRModel model;

	// The phenotype.
	private NonTerminalSymbol parseTree;

	// The fitness of the phenotype.
	private double fitness;

	// A stash of the source for testing if fitness cache is up to date.
	private String sourceCache;

	public GRCandidateProgram(final GRModel model) {
		this(null, model);
	}

	public GRCandidateProgram(final NonTerminalSymbol parseTree, final GRModel model) {
		this.model = model;
		this.parseTree = parseTree;
		this.sourceCache = null;
		// Initialise the fitness to 0.0 until we are asked to calculate it.
		// fitness = 0.0;
	}

	public void setParseTree(final NonTerminalSymbol parseTree) {
		this.parseTree = parseTree;
	}

	@Override
	public double getFitness() {
		// Only get the source code if caching to avoid overhead otherwise.
		String source = null;
		if (this.model.cacheFitness()) {
			source = this.getSourceCode();
		}

		// If we're not caching or the cache is out of date.
		if (!this.model.cacheFitness() || !source.equals(this.sourceCache)) {
			this.fitness = this.model.getFitness(this);
			this.sourceCache = source;
		}

		return this.fitness;
	}

	public double getFitnessValue() {
		return this.fitness;
	}

	public void setFitnessValue(final double fitnessValue) {
		this.fitness = fitnessValue;
	}

	@Override
	public boolean isValid() {
		boolean valid = true;

		final int maxProgramDepth = this.model.getMaxDepth();

		if ((maxProgramDepth != -1) && (this.getDepth() > maxProgramDepth)) {
			valid = false;
		}

		return valid;
	}

	public String getSourceCode() {
		return this.parseTree.toString();
	}

	public NonTerminalSymbol getParseTree() {
		return this.parseTree;
	}

	public int getDepth() {
		return this.parseTree.getDepth();
	}

	public void reset() {
		this.setFitnessValue(0.0);
	}

	/**
	 * Create a clone of this GECandidateProgram. The list of codons are copied
	 * as are all caches.
	 *
	 * @return a copy of this GECandidateProgram instance.
	 */
	@Override
	public CandidateProgram clone() {
		final GRCandidateProgram clone = (GRCandidateProgram) super.clone();

		// If codons are the same then the source and fitness should be the
		// same.
		if (this.parseTree == null) {
			clone.parseTree = null;
		} else {
			clone.parseTree = this.parseTree.clone();
		}

		// Copy the caches.
		clone.sourceCache = this.sourceCache;
		clone.fitness = this.fitness;

		// Shallow copy the model.
		clone.model = this.model;

		return clone;
	}

	/**
	 * Returns a string representation of this program. This will be either the
	 * genotype or the phenotype, depending on whether the program has
	 * undergone mapping or not.
	 */
	@Override
	public String toString() {
		if (this.parseTree != null) {
			return this.parseTree.toString();
		} else {
			return null;
		}
	}

	/**
	 * Compares the given argument for equivalence to this GECandidateProgram.
	 * Two GR candidate programs are equal if they have equal syntax regardless
	 * of grammar rules used or if both have a null parse tree.
	 *
	 * @return true if the object is an equivalent candidate program, false
	 *         otherwise.
	 */
	@Override
	public boolean equals(final Object o) {

		if (o instanceof GRCandidateProgram) {
			final GRCandidateProgram prog = (GRCandidateProgram) o;

			return prog.toString().equals(this.toString());
		} else {
			return false;
		}
	}

	/**
	* Compares this program to another based upon fitness. Returns a negative
	* integer if this program has a worse (larger) fitness value, zero if they
	* have equal fitnesses and a positive integer if this program has a
	* better (smaller) fitness value.
	* 
	* @param o the <code>CandidateProgram</code> instance to compare against.
	* @return a negative integer, zero, or a positive integer if this program
	*         has a worse, equal or better fitness than <code>o</code>
	*         respectively.
	*/
	@Override
	public int compareTo(final CandidateProgram o) {
		if (o == null) {
			throw new NullPointerException("cannot compare to null");
		}

		final double thisFitness = this.getFitnessValue();
		final double objFitness = ((GRCandidateProgram) o).getFitnessValue();

		if (thisFitness < objFitness) {
			return -1;
		} else if (thisFitness == objFitness) {
			return 0;
		} else {
			return 1;
		}
	}

}
