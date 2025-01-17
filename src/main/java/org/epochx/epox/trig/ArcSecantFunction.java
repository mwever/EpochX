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
package org.epochx.epox.trig;

import org.epochx.epox.Node;
import org.epochx.tools.util.*;

/**
 * A function node which performs the inverse trigonometric function of
 * arc-secant, called ARCSEC.
 */
public class ArcSecantFunction extends Node {

	/**
	 * Constructs an ArcSecantFunction with one <code>null</code> child.
	 */
	public ArcSecantFunction() {
		this(null);
	}

	/**
	 * Constructs an ArcSecantFunction with one numerical child node.
	 * 
	 * @param child the child node.
	 */
	public ArcSecantFunction(final Node child) {
		super(child);
	}

	/**
	 * Evaluates this function. The child node is evaluated, the
	 * result of which must be a numeric type (one of Double, Float, Long,
	 * Integer). The arc-secant of this value becomes the result of this
	 * method as a double value.
	 */
	@Override
	public Double evaluate() {
		final Object c = getChild(0).evaluate();

		return MathUtils.arcsec(NumericUtils.asDouble(c));
	}

	/**
	 * Returns the identifier of this function which is ARCSEC.
	 */
	@Override
	public String getIdentifier() {
		return "ARCSEC";
	}

	/**
	 * Returns this function node's return type for the given child input types.
	 * If there is one input type of a numeric type then the return type will
	 * be Double. In all other cases this method will return <code>null</code>
	 * to indicate that the inputs are invalid.
	 * 
	 * @return the Double class or null if the input type is invalid.
	 */
	@Override
	public Class<?> getReturnType(final Class<?> ... inputTypes) {
		if ((inputTypes.length == 1) && TypeUtils.isNumericType(inputTypes[0])) {
			return Double.class;
		} else {
			return null;
		}
	}
}
