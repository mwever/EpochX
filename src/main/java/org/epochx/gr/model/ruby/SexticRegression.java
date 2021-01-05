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
package org.epochx.gr.model.ruby;

/**
 * XGR model for a sextic symbolic regression problem in the Ruby language.
 * 
 * <p>
 * The target program is the function: x^6 - (2 * x^4) + x^2
 */
public class SexticRegression extends Regression {

	/**
	 * Constructs an instance of the SexticRegression model with 50 input
	 * points.
	 */
	public SexticRegression() {
		super();
	}

	/**
	 * Constructs an instance of the SexticRegression model.
	 */
	public SexticRegression(final int noPoints) {
		super(noPoints);
	}

	/**
	 * The actual function we are trying to evolve.
	 */
	@Override
	public double getCorrectResult(final double x) {
		return Math.pow(x, 6) - (2 * Math.pow(x, 4)) + Math.pow(x, 2);
	}
}
